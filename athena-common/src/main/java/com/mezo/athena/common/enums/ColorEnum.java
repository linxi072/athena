package com.mezo.athena.common.enums;

import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author liu
 */

public enum ColorEnum {

    RED("红色", HSSFColor.HSSFColorPredefined.RED.getIndex()),
    GREEN("绿色", HSSFColor.HSSFColorPredefined.GREEN.getIndex()),
    BLANK("白色", HSSFColor.HSSFColorPredefined.WHITE.getIndex()),
    YELLOW("黄色", HSSFColor.HSSFColorPredefined.YELLOW.getIndex()),
    BLUE("蓝色", HSSFColor.HSSFColorPredefined.CORNFLOWER_BLUE.getIndex());
    private String name;
    private short index;

    ColorEnum(String name, short index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

}