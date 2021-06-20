package Core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 */

/**
 * Apply this annotation into method you want to execute automatically
 * 
 * @author Septian Pramana R
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Process {

    /**
     * Define order of the method. <br/>
     * Smaller value will be execute first. default is 0
     * 
     * @By : Septian Pramana R
     * @Author: SEAL
     */
    public int executionOrder() default 0;

    /**
     * Method category. <br/>
     * Group one or more method
     * 
     * @By : Septian Pramana R
     * @Author: SEAL
     */
    public String category();
}