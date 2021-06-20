package Core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 
 */

/**
 * @author Septian Pramana R
 *
 */
public class MethodContainer {
    private Map<String, Map<Integer, Method>> methods;
    private Object                            caller;

    /**
     * Create an instance of MethodContainer <br/>
     * 
     * @param methods Map of Method by category. Sorted by executionOrder located in
     *                {@link Process}
     * @param caller  Instance object (class who's invoke the method)
     */
    public MethodContainer(Map<String, Map<Integer, Method>> methods, Object caller) {
        this.methods = methods;
        this.caller  = caller;
    }

    /**
     * Execute every method grouped by category and ordered by executionOrder
     * located in {@link Process}
     * 
     * @param category Method group name
     * @param param    Method's first parameter
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @By : Septian Pramana R
     * @Author: SEAL
     */
    public void execute(String category, Object param) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (Method p : this.methods.get(category).values()) {
            p.invoke(this.caller, param);
        }
    }

}
