package com.mezo.athena.common.enums;

/**
 * @author qzrs
 */

public enum DateEnum {
    DATE_1("yyyy-MM-dd"),
    DATE_2("yyyy/MM/dd"),
    DATE_3("yyyy年MM月dd日"),
    DATE_4("yyyy-M-d"),
    DATE_5("yyyy/M/d");

    String value;

    DateEnum(String s) {
    }
}
