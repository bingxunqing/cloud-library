package page.bingx.study2bean.common;

/**
 * @program: study2-bean
 * @description:
 * @author: bingxunqing
 * @create: 2025-11-30 09:53
 */
public enum ResultCode {
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    NOT_FOUND(404, "未找到"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    VALIDATE_FILED(404,"参数校验失败");


    private final int code;
    private final String message;
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
