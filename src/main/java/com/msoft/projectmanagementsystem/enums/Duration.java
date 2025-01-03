package com.msoft.projectmanagementsystem.enums;

/**
 * Created On:1/3/25 1:04 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
public enum Duration {
    WEEK,
    ONE_MONTH("1 MONTH"),
    THREE_MONTHS("3 MONTHS"),
    SIX_MONTHS("6 MONTHS"),
    YEAR;
    private String value;

    Duration() {
        this.value = name();
    }

    Duration(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }

}
