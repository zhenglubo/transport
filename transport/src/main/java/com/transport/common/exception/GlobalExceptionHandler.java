package com.transport.common.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.transport.common.result.DataResult;
import com.transport.common.result.DataResultBuild;
import com.transport.common.result.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.ConnectException;

/**
 * @description: 全局异常控制类
 * @author: zhenglubo
 * @create: 2019-04-11 16:01
 **/

//@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = GlobalException.class)
    public DataResult hanlerException(HttpServletRequest request, GlobalException e){
        return DataResultBuild.fail(e.getMessage());
    }

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public DataResult<String> runtimeExceptionHandler(RuntimeException ex) {
        return this.result(ErrorCode.RUNTIME_EXCEPTION.getCode(), (Exception)ex);
    }

    @ExceptionHandler({NullPointerException.class})
    @ResponseBody
    public DataResult<String> nullPointerExceptionHandler(NullPointerException ex) {
        return this.result(ErrorCode.NULL_POINTER_EXCEPTION.getCode(), (Exception)ex);
    }

    @ExceptionHandler({ClassCastException.class})
    @ResponseBody
    public DataResult<String> classCastExceptionHandler(ClassCastException ex) {
        return this.result(ErrorCode.CLASS_CAST_EXCEPTION.getCode(), (Exception)ex);
    }

    @ExceptionHandler({IOException.class})
    @ResponseBody
    public DataResult<String> ioExceptionHandler(IOException ex) {
        return this.result(ErrorCode.IO_EXCEPTION.getCode(), (Exception)ex);
    }

    @ExceptionHandler({NoSuchMethodException.class})
    @ResponseBody
    public DataResult<String> noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return this.result(ErrorCode.NO_SUCH_METHOD_EXCEPTION.getCode(), (Exception)ex);
    }

    @ExceptionHandler({IndexOutOfBoundsException.class})
    @ResponseBody
    public DataResult<String> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return this.result(ErrorCode.INDEX_OUT_OF_BOUNDS_EXCEPTION.getCode(), (Exception)ex);
    }

    @ExceptionHandler({ConnectException.class})
    @ResponseBody
    public DataResult<String> connectException(ConnectException ex) {
        return this.result(ErrorCode.CONNECT_EXCEPTION.getCode(), (Exception)ex);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public DataResult<String> requestNotReadable(HttpMessageNotReadableException ex) {
        return this.result(ErrorCode.BAD_REQUEST.getCode(), (Exception)ex);
    }

    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public DataResult<String> requestTypeMismatch(TypeMismatchException ex) {
        return this.result(ErrorCode.BAD_REQUEST.getCode(), (Exception)ex);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public DataResult<String> requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return this.result(ErrorCode.BAD_REQUEST.getCode(), (Exception)ex);
    }

    @ExceptionHandler({ServletException.class})
    @ResponseBody
    public DataResult<String> http404(ServletException ex) {
        return this.result(ErrorCode.NOT_FOUND_REQUEST.getCode(), (Exception)ex);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public DataResult<String> request405(HttpRequestMethodNotSupportedException ex) {
        return this.result(ErrorCode.METHOD_NOT_ALLOWED.getCode(), (Exception)ex);
    }

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public DataResult<String> request406(HttpMediaTypeNotAcceptableException ex) {
        return this.result(ErrorCode.NOT_ACCEPTABLE.getCode(), (Exception)ex);
    }

    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public DataResult<String> server500(RuntimeException runtimeException) {
        return this.result(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), (Exception)runtimeException);
    }

    @ExceptionHandler({GlobalException.class})
    @ResponseBody
    public DataResult<String> appWebException(GlobalException bizRuntimeException) {
        return this.result(bizRuntimeException.getCode(), bizRuntimeException);
    }

    @ExceptionHandler({JsonMappingException.class})
    @ResponseBody
    public DataResult<String> jsonMappingException(JsonMappingException jsonMappingException) {
        return this.result(ErrorCode.ERROR_FORMAT_PARAMETER.getCode(), (Exception)jsonMappingException);
    }

    private DataResult<String> result(int errCode, GlobalException e) {
        log.error(e.getMessage(), e);
        String localValue = String.valueOf(errCode);
        return !StringUtils.isEmpty(localValue) ? (new DataResult()).fail(errCode, localValue, e.getMessage()) : (new DataResult()).fail(errCode, e.getError(), e.getMessage());
    }

    private DataResult<String> result(int errCode, Exception e) {
        log.error(e.getMessage(), e);
        return (new DataResult()).fail(errCode, String.valueOf(errCode), e.getMessage());
    }


}
