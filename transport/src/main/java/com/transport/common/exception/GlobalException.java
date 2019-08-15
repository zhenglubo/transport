package com.transport.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**全局异常
 * @author zlb
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int code = 1;
    private String error = "业务异常";

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(int code, String error, String msg) {
        super(msg);
        this.code = code;
        this.error = error;
    }

    public GlobalException(int code, String error, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.error = error;
    }

}
