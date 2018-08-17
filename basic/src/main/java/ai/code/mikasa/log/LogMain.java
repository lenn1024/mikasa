package ai.code.mikasa.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.spi.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain {
    private static Logger logger = LoggerFactory.getLogger(LogMain.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("1. info msg.");
        logger.debug("1. debug msg.");

        String loggerName = logger.getName();

        LoggerContext context = LogManager.getContext();
        if(context instanceof org.apache.logging.log4j.core.LoggerContext){
            org.apache.logging.log4j.core.LoggerContext ctx = (org.apache.logging.log4j.core.LoggerContext)context;
            Configuration logConfig = ctx.getConfiguration();
            LoggerConfig loggerConfig = logConfig.getLoggerConfig(loggerName);
            Level fromLevel = loggerConfig.getLevel();

            String level = "debug";
            if (logger.isInfoEnabled()) {
                logger.info("[processLog2Config] set loggerName=[" + loggerName + "] from [" + fromLevel + "] to level=" + level + ", loggerConfig=" + loggerConfig);
            }

            displayLevel(fromLevel);
            loggerConfig.setLevel(Level.toLevel(level, fromLevel));
            ctx.updateLoggers();
        }
        //logger = LoggerFactory.getLogger(LogMain.class);
        logger.debug("2. debug msg.");
    }

    static void displayLevel(Level level){
        System.out.println("当前日志级别为：" + level);
    }
}
