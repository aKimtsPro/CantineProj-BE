package iepscf.akimts.exceptions;

import org.springframework.http.HttpStatus;

public class BasicControllerExceptionHandler{

    private BasicControllerExceptionHandler(Class<? extends Throwable> clazz, HttpStatus status){
        this.exceptionClazz = clazz;
        this.status = status;
    }

    private final Class<? extends Throwable> exceptionClazz;
    private final HttpStatus status;

    public Class<? extends Throwable> getExceptionClazz() {
        return exceptionClazz;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public static <S extends Throwable> BasicControllerExceptionHandlerBuilder<S> forException(Class<S> exceptionClazz){
        return new BasicControllerExceptionHandlerBuilder<>(exceptionClazz);
    }

    public static class BasicControllerExceptionHandlerBuilder<S extends Throwable>{

        private final Class<? extends S> clazz;

        private BasicControllerExceptionHandlerBuilder(Class<? extends S> clazz) {
            this.clazz = clazz;
        }

        public BasicControllerExceptionHandler status(HttpStatus status){
            return new BasicControllerExceptionHandler(clazz, status);
        }

        public BasicControllerExceptionHandler badRequest(){
            return new BasicControllerExceptionHandler(clazz, HttpStatus.BAD_REQUEST);
        }
    }


}
