package page.bingx.study2bean.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: study2-bean
 * @description: 返回响应
 * @author: bingxunqing
 * @create: 2025-11-30 09:57
 */

@Data
@NoArgsConstructor
public class Result<T> {
    private long code;
    private String message;
    private T data;

    private Result(long code,String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(ResultCode.SUCCESS.getCode(), message, data);
    }
    public static <T> Result<T> Loginfailed(String message) {
        return new Result<>(ResultCode.PASSWORD_ERROR.getCode(), message, null);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<>(ResultCode.ERROR.getCode(), message, null);
    }

    public static <T> Result<T> failed(ResultCode errorCode) {
        return new Result<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

}
