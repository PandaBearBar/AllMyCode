package systemException;

public class SystemException extends Exception {
    public SystemException(ExceptionMSG exceptionMSG) {
        super(exceptionMSG.getMsg());
    }
}
