import java.lang.reflect.InvocationTargetException;

import Base.BaseReport;
import Impl.ModelChild;
import Impl.SubChildReport;

/**
 * 
 */

/**
 * @author Septian Pramana R
 *
 */
public class Main {

    /**
     * @param args
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @By : Septian Pramana R
     * @Author: SEAL
     */
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        BaseReport b = new SubChildReport();
        b.prepareData(new ModelChild());
        System.out.println("sd");
    }

}
