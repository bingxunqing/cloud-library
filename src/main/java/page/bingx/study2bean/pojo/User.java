package page.bingx.study2bean.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: study-ssm
 * @description: 用户类
 * @author: bingxunqing
 * @create: 2025-12-01 23:29
 */
@Data
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userRole;

}
