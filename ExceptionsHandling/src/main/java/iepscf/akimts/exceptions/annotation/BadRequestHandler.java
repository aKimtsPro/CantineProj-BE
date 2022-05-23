package iepscf.akimts.exceptions.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotate an ControllerAdviser class or an class extending ControllerAdviser.
 * Permits to list Exceptions that need to be handled by the annotated ControllerAdviser via a 400 response.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@AdvisorHandled
public @interface BadRequestHandler {

    @AliasFor("exception")
    Class<? extends Throwable>[] value() default {};

    /**
     * The value indicates the different Exception class that need to be handled by the annotated ControllerAdviser
     */
    @AliasFor("value")
    Class<? extends Throwable>[] exception() default {};

}
