package Impl;

import Core.Process;

/**
 * 
 */

/**
 * @author Septian Pramana R
 *
 */
public class SubChildReport extends ReportChild {

    @Override
    @Process(executionOrder = 3, category = "preparation")
    public void prepare5(ModelChild m) {
        System.out.println("Grand son");
    }
}
