package com.lemon.lemonmovies;

import android.os.Build;

import java.util.Locale;

/**
 * A simple helper that helps to get some device/app information
 */
public final class DeviceConfigurationHelper {

    private static final String DEVICE_INFO_FORMAT = "%s %s (%s)";
    private static final String VERSION_INFO_FORMAT = "%s (%d)";

    /**
     * @return device info string
     */
    public static String getDeviceInfo() {
        return String.format(DEVICE_INFO_FORMAT, Build.MANUFACTURER, Build.MODEL, Build.DEVICE);
    }

    /**
     * @return device build info string
     */
    public static String getBuildInfo() {
        return Build.ID;
    }

    /**
     * @return device android version info string
     */
    public static String getVersionInfo() {
        return String.format(Locale.getDefault(), VERSION_INFO_FORMAT, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
    }

    /**
     * @return current app version info string
     */
    public static String getAppVersionInfo() {
        return BuildConfig.VERSION_NAME;
    }

    private DeviceConfigurationHelper() {
    }
}
