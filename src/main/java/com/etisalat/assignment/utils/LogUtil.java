/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.utils;

import com.etisalat.assignment.statics.AppDefines;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author hesham.ibrahim
 */
public class LogUtil {

    private static Logger logger;

    public static void initialize() {
        try {
            // Log
            System.out.println("Initializing LogUtil");
            if (logger == null) {
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                URL url = loader.getResource(AppDefines.APP.LOG_PROPERTIES_FILE_NAME);
                if (url != null) {
                    PropertyConfigurator.configure(url);
                } else {
                    PropertyConfigurator.configure("log4j.properties");
                }

                // Get logger
                logger = Logger.getRootLogger();

                // Log
                if (logger != null) {
                    System.out.println("LogUtil Initialized Successfully");
                } else {
                    System.out.println("Error in initialization log");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialize(Logger logger) {
        try {
            // Log
            System.out.println("Initializing LogUtil");
            if (LogUtil.logger == null) {
                LogUtil.logger = logger;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void trace(String message) {
        if (logger != null) {
            logger.trace(formatMessage(message));
        }
    }

    public static void debug(String message) {
        if (logger != null) {
            logger.debug(formatMessage(message));
        }
    }

    public static void info(String message) {
        if (logger != null) {
            logger.info(formatMessage(message));
        }
    }

    
    public static void warn(String message) {
        if (logger != null) {
            logger.warn(formatMessage(message));
        }
    }

    public static void error(String message) {
        if (logger != null) {
            logger.error(formatMessage(message));
        }
    }

    public static void fatal(String message) {
        if (logger != null) {
            logger.fatal(formatMessage(message));
        }
    }

    public static void error(Throwable e) {
        // Log error type and message
        error(e.getClass().getSimpleName() + ": " + e.getMessage());

        // Log stack trace
        StringWriter stackTrace = new StringWriter();
        e.printStackTrace(new PrintWriter(stackTrace));
        error(stackTrace.toString());
    }

    public static void time(long timeMsec, String... msgs) {

        StackTraceElement caller = getStackTraceOfCaller();
        try {
            logger.info(((Class) Class.forName(caller.getClassName())).getSimpleName() + "." + caller.getMethodName() + "() out in ["
                    + (System.currentTimeMillis() - timeMsec) + "] msec " + mergeStrings(msgs));
        } catch (ClassNotFoundException ex) {
            logger.error(caller.getClassName() + "." + caller.getMethodName() + "() | " + "Failed to log time");
        }
    }

    private static StackTraceElement getStackTraceOfCaller() {
        StackTraceElement st[] = Thread.currentThread().getStackTrace();
        return st[3];
    }

    private static String mergeStrings(String... arrayOfStrings) {
        String oneString = "";
        StringBuilder sb = null;
        if (arrayOfStrings != null && arrayOfStrings.length != 0) {
            sb = new StringBuilder();

            for (String msg : arrayOfStrings) {
                sb.append(msg).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb != null) {
            oneString = sb.toString();
        }
        return oneString;
    }

    public static void error(String msg, Throwable e) {
        // Log error type and message
        logger.error(e.getClass().getSimpleName() + ": " + e.getMessage() + " appMsg(" + msg + ")");

        // Log stack trace
        StringWriter stackTrace = new StringWriter();
        e.printStackTrace(new PrintWriter(stackTrace));
        error(stackTrace.toString());
    }

    public static String formatMessage(String message, Object... args) {
        // Get caller
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int stackDepth = 3;
        String methodName = stackTrace[stackDepth].getMethodName();
        String className = stackTrace[stackDepth].getClassName();
        if (className.indexOf('.') > 0) {
            className = className.substring(className.lastIndexOf('.') + 1);
        }
        String caller = className + "." + methodName + "()";

        // Prepare format
        String format = String.format("%s : %s", caller, message);

        // Format message
//        return String.format(format, args);
        return format;
    }

    public static void printTimeLog(long startime) {
        logger.info("Out in [" + (System.currentTimeMillis() - startime) + "] msec");
    }

    public static void printStartLog() {
        logger.debug("Starting");
    }

    public static void printSuccessLog() {
        logger.debug("Success");
    }


}
