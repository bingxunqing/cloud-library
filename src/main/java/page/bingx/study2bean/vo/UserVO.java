package page.bingx.study2bean.vo;

import lombok.Data;

/**
 * @program: study-ssm
 * @description:
 * @author: bingxunqing
 * @create: 2025-12-02 00:21
 */
@Data
public class UserVO {
    private String userName;
    private String role;
    private String email;
    private String token;

    public  UserVO() {
    }
    public UserVO(String userName,  String email,String role) {
        this.userName = userName;
        this.role = role;
        this.email = email;
    }

}
