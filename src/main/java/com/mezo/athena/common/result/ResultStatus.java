package com.mezo.athena.common.result;

public enum ResultStatus {

    SUCCESS(200),
    MSG_ERROR(400),
    SER_ERROR(500);

    Integer status;

    ResultStatus(Integer status) {
        this.status = status;
    }
}
