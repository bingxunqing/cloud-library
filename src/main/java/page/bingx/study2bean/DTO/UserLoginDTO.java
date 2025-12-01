package page.bingx.study2bean.DTO;

import lombok.Data;

/**
 * @program: study-ssm
 * @description: 传入的类（用户名和密码）
 * @author: bingxunqing
 * @create: 2025-12-01 23:58
 */
@Data
public class UserLoginDTO {
    private  String userName;
    private String userPassword;
}
