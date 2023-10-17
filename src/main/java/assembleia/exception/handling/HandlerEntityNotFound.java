package assembleia.exception.handling;

public class HandlerEntityNotFound extends RuntimeException {

    public HandlerEntityNotFound(String msg) {
        super(msg);
    }
    public HandlerEntityNotFound(String msg, Throwable throwable) {
        super(msg,throwable);
    }
}
