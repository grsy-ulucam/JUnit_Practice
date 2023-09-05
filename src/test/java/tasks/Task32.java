package tasks;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;


public class Task32 {
    @Test
    public void log4j() {

        PropertyConfigurator.configure("log4j.properties");
        org.apache.log4j.Logger logger = Logger.getLogger(Task32.class.getName());

        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");

    }

    @Test
    public void log4j2() {

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Task32.class.getName());

        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");

    }
}
