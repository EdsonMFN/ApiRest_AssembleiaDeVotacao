package assembleia.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j(topic = "ERROR_HANDLING")
@RestControllerAdvice
public class TratamentoErros extends ResponseEntityExceptionHandler {


}
