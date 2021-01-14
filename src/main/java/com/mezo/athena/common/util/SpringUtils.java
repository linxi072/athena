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

    public static boolean equals(String str1, String str2) {
        if (isBack(str1) || isBack(str2)) {
            return false;
        } else {
            return str1.equals(str2);
        }
    }

}
