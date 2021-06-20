package Impl;

/**
 * 
 */

import Base.BaseReport;
import Core.Process;

/**
 * @author Septian Pramana R
 *
 */
public class ReportChild extends BaseReport {

    @Process(executionOrder = 1, category = "preparation")
    public void prepare1(ModelChild m) {
        System.out.println(m.getParent());
    }

    @Process(executionOrder = 2, category = "preparation")
    public void prepare2(ModelChild m) {
        System.out.println(m.childName());
    }

    @Process(executionOrder = 5, category = "preparation")
    public void prepare6(ModelChild m) {
        System.out.println("im no 6");
    }

    @Process(executionOrder = 5, category = "preparation")
    public void prepare5(ModelChild m) {
        System.out.println("im no 5");
    }

    @Process(executionOrder = 7, category = "preparation")
    public void prepare7(ModelChild m) {
        System.out.println("im no 7");
    }
}
