package com.dunhili.eternitysdungeon.utils;

import android.util.Log;

/**
 * Utility class for handling logging levels.
 * Created by Dunhili on 5/24/2015.
 */
public class Logging {
    public static int NONE = 0;
    public static int ERROR = 1;
    public static int WARN = 2;
    public static int INFO = 3;
    public static int DEBUG = 4;
    public static int VERBOSE = 5;
    public static int ALL = 6;

    private static int loggingLevel = DEBUG;

    /**
     * Returns the current logging level.
     * <ul>
     *     <li>0 - NONE</li>
     *     <li>1 - ERROR</li>
     *     <li>2 - WARN</li>
     *     <li>3 - INFO</li>
     *     <li>4 - DEBUG</li>
     *     <li>5 - VERBOSE</li>
     *     <li>6 - ALL</li>
     * </ul>
     * @return current logging level
     */
    public static int getLoggingLevel() {
        return loggingLevel;
    }

    /**
     * Returns true if the current logging level is at most NONE, otherwise returns false.
     * @return true if the current logging level is at most NONE
     */
    public static boolean isNoneEnabled() {
        return loggingLevel <= NONE;
    }

    /**
     * Returns true if the current logging level is at most ERROR, otherwise returns false.
     * @return true if the current logging level is at most ERROR
     */
    public static boolean isErrorEnabled() {
        return loggingLevel <= ERROR;
    }

    /**
     * Returns true if the current logging level is at most WARN, otherwise returns false.
     * @return true if the current logging level is at most WARN
     */
    public static boolean isWarnEnabled() {
        return loggingLevel <= WARN;
    }

    /**
     * Returns true if the current logging level is at most INFO, otherwise returns false.
     * @return true if the current logging level is at most INFO
     */
    public static boolean isInfoEnabled() {
        return loggingLevel <= INFO;
    }

    /**
     * Returns true if the current logging level is at most DEBUG, otherwise returns false.
     * @return true if the current logging level is at most DEBUG
     */
    public static boolean isDebugEnabled() {
        return loggingLevel <= DEBUG;
    }

    /**
     * Returns true if the current logging level is at most VERBOSE, otherwise returns false.
     * @return true if the current logging level is at most VERBOSE
     */
    public static boolean isVerboseEnabled() {
        return loggingLevel <= VERBOSE;
    }

    /**
     * Returns true if the current logging level is at most ALL, otherwise returns false.
     * @return true if the current logging level is at most ALL
     */
    public static boolean isAllEnabled() {
        return loggingLevel <= ALL;
    }

    /**
     * Logs the given message if error logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     */
    public static void error(String tag, String message) {
        if (isErrorEnabled()) {
            Log.e(tag, message);
        }
    }

    /**
     * Logs the given message if error logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     * @param error error message to log
     */
    public static void error(String tag, String message, Throwable error) {
        if (isErrorEnabled()) {
            Log.e(tag, message, error);
        }
    }

    /**
     * Logs the given message if warn logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     */
    public static void warn(String tag, String message) {
        if (isWarnEnabled()) {
            Log.w(tag, message);
        }
    }

    /**
     * Logs the given message if warn logging is enabled.
     * @param tag tag for the message
     * @param error error message to log
     */
    public static void warn(String tag, Throwable error) {
        if (isWarnEnabled()) {
            Log.w(tag, error);
        }
    }

    /**
     * Logs the given message if warn logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     * @param error error message to log
     */
    public static void warn(String tag, String message, Throwable error) {
        if (isWarnEnabled()) {
            Log.w(tag, message, error);
        }
    }

    /**
     * Logs the given message if info logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     */
    public static void info(String tag, String message) {
        if (isInfoEnabled()) {
            Log.i(tag, message);
        }
    }

    /**
     * Logs the given message if info logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     * @param error error message to log
     */
    public static void info(String tag, String message, Throwable error) {
        if (isInfoEnabled()) {
            Log.i(tag, message, error);
        }
    }

    /**
     * Logs the given message if debug logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     */
    public static void debug(String tag, String message) {
        if (isDebugEnabled()) {
            Log.d(tag, message);
        }
    }

    /**
     * Logs the given message if debug logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     * @param error error message to log
     */
    public static void debug(String tag, String message, Throwable error) {
        if (isDebugEnabled()) {
            Log.d(tag, message, error);
        }
    }

    /**
     * Logs the given message if verbose logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     */
    public static void verbose(String tag, String message) {
        if (isVerboseEnabled()) {
            Log.v(tag, message);
        }
    }

    /**
     * Logs the given message if verbose logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     * @param error error message to log
     */
    public static void verbose(String tag, String message, Throwable error) {
        if (isVerboseEnabled()) {
            Log.v(tag, message, error);
        }
    }

    /**
     * Logs the given message if all logging is enabled.
     * @param tag tag for the message
     * @param message message to log
     */
    public static void all(String tag, String message) {
        if (isAllEnabled()) {
            Log.println(Log.ASSERT, tag, message);
        }
    }
}
