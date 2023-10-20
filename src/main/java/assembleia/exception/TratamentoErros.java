package assembleia.exception;


import assembleia.exception.handling.HandlerEntityNotFound;
import assembleia.rest.response.ResponseError;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j(topic = "ERROR_HANDLING")
@RestControllerAdvice
public class TratamentoErros extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        log.error("Request vazia ou formato invalido");

        Object mensage = null;

        if (ex.getCause() instanceof InvalidFormatException){
            InvalidFormatException formatException =(InvalidFormatException)ex.getCause();
            mensage =formatException.getValue();
        }
        return buildErrorResponse(ex.getCause(),HttpStatus.BAD_REQUEST,"Erro na requisição");
    }
    @ExceptionHandler(HandlerEntityNotFound.class)
    public ResponseEntity<Object> handlerEntityNotFound(HandlerEntityNotFound ex, WebRequest request){
        log.error("Entidade não encontrada ou não existe");
        logError(ex);

        return buildErrorResponse(ex.getCause(),HttpStatus.NOT_FOUND,"Entidade não encontrada");
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionGenerica(Exception ex,WebRequest request){
        log.error("Erro na api");
        logError(ex);

        return buildErrorResponse(ex.getCause(),HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
    }
    private static void logError(Exception ex) {
        log.error(ex.getClass().getName(), ex);
        log.error(ex.getClass().getName(), ex.getMessage());
        log.error(ex.getClass().getName(), ex.getLocalizedMessage());
    }

    private ResponseEntity<Object> buildErrorResponse(Throwable message, HttpStatus status, String error) {

        ResponseError responseError = new ResponseError(status,error,message);
        return ResponseEntity.status(status).body(responseError);
    }
}
