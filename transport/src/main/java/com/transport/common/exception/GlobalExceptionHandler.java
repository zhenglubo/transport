package com.transport.common.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.transport.common.result.DataResult;
import com.transport.common.result.ErrorCode;
import lombok.extern.slf4j.Slf4j;
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

import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.ConnectException;



/**全局异常控制类
 * @author zlb
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Resource
    private LocaleUtil localeUtil;

    /**
     * 运行时异常
     *
     * @param ex 异常类型
     * @return 结果
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public DataResult<String> runtimeExceptionHandler(RuntimeException ex) {
        return result(ErrorCode.RUNTIME_EXCEPTION, ex);
    }

    /**
     * 空指针异常
     *
     * @param ex 空指针异常
     * @return 结果
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public DataResult<String> nullPointerExceptionHandler(NullPointerException ex) {
        return result(ErrorCode.NULL_POINTER_EXCEPTION, ex);
    }

    /**
     *
     *
     * @param ex 类型转换异常
     * @return 结果
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public DataResult<String> classCastExceptionHandler(ClassCastException ex) {
        return result(ErrorCode.CLASS_CAST_EXCEPTION, ex);
    }

    /**
     *
     *
     * @param ex IO异常
     * @return 结果
     */
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public DataResult<String> ioExceptionHandler(IOException ex) {
        return result(ErrorCode.IO_EXCEPTION, ex);
    }

    /**
     *
     *
     * @param ex 未知方法异常
     * @return 结果
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public DataResult<String> noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return result(ErrorCode.NO_SUCH_METHOD_EXCEPTION, ex);
    }

    /**
     *
     *
     * @param ex 数组越界异常
     * @return 结果
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public DataResult<String> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return result(ErrorCode.INDEX_OUT_OF_BOUNDS_EXCEPTION, ex);
    }

    /**
     *
     *
     * @param ex 网络异常
     * @return 结果
     */
    @ExceptionHandler(ConnectException.class)
    @ResponseBody
    public DataResult<String> connectException(ConnectException ex) {
        return result(ErrorCode.CONNECT_EXCEPTION, ex);
    }

    /**
     * 4
     *
     * @param ex 400错误
     * @return 结果
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public DataResult<String> requestNotReadable(HttpMessageNotReadableException ex) {
        return result(ErrorCode.BAD_REQUEST, ex);
    }

    /**
     *
     *
     * @param ex 400错误
     * @return 结果
     */
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public DataResult<String> requestTypeMismatch(TypeMismatchException ex) {
        return result(ErrorCode.BAD_REQUEST, ex);
    }

    /**
     *
     *
     * @param ex 400错误
     * @return 结果
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public DataResult<String> requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return result(ErrorCode.BAD_REQUEST, ex);
    }

    @ExceptionHandler({ServletException.class})
    @ResponseBody
    public DataResult<String> http404(ServletException ex) {
        return result(ErrorCode.NOT_FOUND_REQUEST, ex);
    }

    /**
     *
     *
     * @param ex 405错误
     * @return 结果
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public DataResult<String> request405(HttpRequestMethodNotSupportedException ex) {
        return result(ErrorCode.METHOD_NOT_ALLOWED, ex);
    }

    /**
     *
     *
     * @param ex 406错误
     * @return 结果
     */
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public DataResult<String> request406(HttpMediaTypeNotAcceptableException ex) {
        return result(ErrorCode.NOT_ACCEPTABLE, ex);
    }

    /**
     *
     *
     * @param runtimeException 500错误
     * @return 结果
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public DataResult<String> server500(RuntimeException runtimeException) {
        return result(ErrorCode.INTERNAL_SERVER_ERROR, runtimeException);
    }

    /**
     *
     *
     * @param globalException GlobalException 业务异常
     * @return 结果
     */
    @ExceptionHandler({GlobalException.class})
    @ResponseBody
    public DataResult<String> appWebException(GlobalException globalException) {
        return result(globalException.getCode(), globalException);
    }


    @ExceptionHandler({JsonMappingException.class})
    @ResponseBody
    public DataResult<String> jsonMappingException(JsonMappingException jsonMappingException) {
        return result(ErrorCode.ERROR_FORMAT_PARAMETER, jsonMappingException);
    }

    /**
     *
     *
     * @param errCode 错误码
     * @param e  GlobalException
     * @return 结果
     */
    private DataResult<String> result(int errCode, GlobalException e) {
        log.error(e.getMessage(), e);
        String localValue = localeUtil.getMessage(String.valueOf(errCode));
        if (!StringUtils.isEmpty(localValue)) {
            return new DataResult<String>().fail(errCode, localValue, e.getMessage());
        } else {
            return new DataResult<String>().fail(errCode, e.getError(), e.getMessage());
        }
    }

    private DataResult<String> result(ErrorCode errorCode,Exception e){
        log.error(e.getMessage(), e);
        return new DataResult<String>().fail(errorCode.getCode(),errorCode.getMsg(),e.getMessage());
    }

    private DataResult<String> result(int errCode, Exception e) {
        log.error(e.getMessage(), e);
        return new DataResult<String>().fail(errCode, localeUtil.getMessage(String.valueOf(errCode)), e.getMessage());
    }


}
