package com.mezo.athena.common.result;

public class ReturnDataResult {

    private Integer statusCode;
    private String errorMessage;
    private Object resultData;

    public ReturnDataResult(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public ReturnDataResult(Integer statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public ReturnDataResult(Integer statusCode, String errorMessage, Object resultData) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.resultData = resultData;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public static ReturnDataResult getSuccess() {
        return new ReturnDataResult(ResultStatus.SUCCESS.status);
    }

    public static ReturnDataResult getSuccess(String errorMessage) {
        return new ReturnDataResult(ResultStatus.SUCCESS.status,errorMessage);
    }

    public static ReturnDataResult getSuccess(String errorMessage, Object resultData) {
        return new ReturnDataResult(ResultStatus.SUCCESS.status,errorMessage,resultData);
    }

    public static ReturnDataResult getMsgError(String errorMessage) {
        return new ReturnDataResult(ResultStatus.MSG_ERROR.status,errorMessage);
    }

    public static ReturnDataResult getMsgError(String errorMessage, Object resultData) {
        return new ReturnDataResult(ResultStatus.MSG_ERROR.status,errorMessage,resultData);
    }

    public static ReturnDataResult getSerError(String errorMessage) {
        return new ReturnDataResult(ResultStatus.SER_ERROR.status,errorMessage);
    }

    public static ReturnDataResult getSerError(String errorMessage, Object resultData) {
        return new ReturnDataResult(ResultStatus.SER_ERROR.status,errorMessage,resultData);
    }
}
