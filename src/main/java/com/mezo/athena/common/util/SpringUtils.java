package com.mezo.athena.common.util;

public final class SpringUtils {

    public static boolean isBack(String str) {
        return str == null || "".equals(str) || "".equals(str.trim());
    }

    public static boolean isEmpty(String str) {
        if (isBack(str)) {
            return true;
        }
        return "null".equals(str);
    }
}
