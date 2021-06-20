package Core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import Base.Ctr;
import Base.Model;

/**
 * 
 */

/**
 * @author Septian Pramana R
 *
 */
public final class Scanner {
    private static Class<Model> model = Model.class;
    private static Class<Ctr>   ctr   = Ctr.class;

    /**
     * Scan for method annotated with {@link Process} <br/>
     * 
     * @param cls  'this keyword'
     * @param root Root of the class
     * @return Method container contains every method groupped by Category and
     *         ordered by executionOrder
     * @By : Septian Pramana R
     * @Author: SEAL
     */
    public static MethodContainer scan(Object cls, Class<?> root) {

        Map<String, Map<Integer, Method>> methods     = new HashMap<String, Map<Integer, Method>>();
        Set<String>                       duplication = new HashSet<String>();

        scan_(cls.getClass(), root, methods, duplication);
        return new MethodContainer(methods, cls);
    }

    /**
     * Scan every method in this class and it's parent recursively
     * 
     * @param cls
     * @param root
     * @param methods
     * @param duplication
     * @By : Septian Pramana R
     * @Author: SEAL
     */
    private static void scan_(Class<?> cls, Class<?> root, Map<String, Map<Integer, Method>> methods, Set<String> duplication) {
        for (Method method : cls.getDeclaredMethods()) {
            Class<?>[] params = method.getParameterTypes();

            boolean valid = false;
            if (method.getParameterCount() == 1 && Model.class.isAssignableFrom(params[0])) {
                valid = true;
            }

            if (!valid && method.getParameterCount() == 2 && params[0].equals(model) && params[1].equals(ctr)) {
                valid = true;
            }

            if (duplication.contains(method.getName())) {
                continue;
            }

            if (!valid || !method.isAnnotationPresent(Process.class)) {
                continue;
            }

            duplication.add(method.getName());

            Process annotationValue = method.getAnnotation(Process.class);
            String  category        = annotationValue.category();
            int     order           = annotationValue.executionOrder();

            if (!methods.containsKey(category)) {
                methods.put(category, new TreeMap<Integer, Method>());
            }

            if (!methods.get(category).containsKey(order)) {
                ++order;
            }
            methods.get(category).put(order, method);
        }

        if (cls.equals(root)) {
            return;
        }
        else {
            scan_(cls.getSuperclass(), root, methods, duplication);
        }
    }
}
