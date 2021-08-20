package com.mezo.athena.admin.common.util;

import java.util.Date;

/**
 * @author qzrs
 */
public class UUIDUtils {
    public static String timestamp() {
        return DateTimeUtils.dateToString(new Date(), "yyyyMMddHHmmssSSS");
    }
}
