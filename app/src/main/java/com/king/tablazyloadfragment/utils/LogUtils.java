package com.king.tablazyloadfragment.utils;

import android.util.Log;

import com.king.tablazyloadfragment.BuildConfig;

public class LogUtils {
    /**
     * 日志输出时的TAG
     */
    private static String mTag = "LogUtil";

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void v(String msg) {

        if (BuildConfig.LOG_DEBUG) {
            Log.v(mTag, msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void d(String msg) {

        if (BuildConfig.LOG_DEBUG) {
//            Log.d(mTag, msg);

            int segmentSize = 3 * 1024;
            long length = msg.length();
            if (length <= segmentSize ) {// 长度小于等于限制直接打印
                Log.d(mTag, msg);
            }else {
                while (msg.length() > segmentSize ) {// 循环分段打印日志
                    String logContent = msg.substring(0, segmentSize );
                    msg = msg.replace(logContent, "");
                    Log.d(mTag, logContent);
                }
                Log.d(mTag, msg);// 打印剩余日志
            }
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */
    public static void i(String msg) {
        if (BuildConfig.LOG_DEBUG) {
            Log.i(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG
     */
    public static void w(String msg) {
        if (BuildConfig.LOG_DEBUG) {
            Log.w(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出Throwable
     */
    public static void w(Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            Log.w(mTag, "", tr);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG信息和Throwable
     */
    public static void w(String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            Log.w(mTag, msg, tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG
     */
    public static void e(String msg) {
        if (BuildConfig.LOG_DEBUG) {
            Log.e(mTag, msg);
        }
    }

    /**
     * 以级别为 e 的形式输出Throwable
     */
    public static void e(Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            Log.e(mTag, "", tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG信息和Throwable
     */
    public static void e(String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            Log.e(mTag, msg, tr);
        }
    }
}
