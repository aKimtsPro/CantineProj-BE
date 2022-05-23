package iepscf.akimts.exceptions.annotation;

import iepscf.akimts.exceptions.AbstractControllerAdvisor;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Activates auto-handling by a child bean of <code>AbstractControllerAdvisor</code>
 * for targeted <code>Throwable</code>.
 *
 * @see AbstractControllerAdvisor
 * @see SkippedProperty
 * @author Alexandre Kimtsaris
 * @version 0.1
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AdvisorHandled {

    @AliasFor("status")
    HttpStatus value() default HttpStatus.BAD_REQUEST;

    @AliasFor("value")
    HttpStatus status() default HttpStatus.BAD_REQUEST;

    Class<? extends Throwable> skipFrom() default Throwable.class;

}
