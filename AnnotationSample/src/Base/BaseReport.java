package Base;

import java.lang.reflect.InvocationTargetException;

import Core.MethodContainer;
import Core.Scanner;
import Impl.ModelChild;
import Core.Process;
/**
 * 
 */

/**
 * @author Septian Pramana R
 *
 */
public abstract class BaseReport {
    MethodContainer mc;

    public BaseReport() {
        this.mc = Scanner.scan(this, BaseReport.class);
    }

    public void prepareData(Model m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.mc.execute("preparation", m);
        this.mc.execute("getMe", m);
    }

    @Process(category = "getMe", executionOrder = 0)
    public void prepare0(ModelChild m) {
        System.out.println("Im the parent");
    }

}
