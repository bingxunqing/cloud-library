package page.bingx.study2bean.service;

import page.bingx.study2bean.pojo.User;
import page.bingx.study2bean.vo.UserVO;

/**
 * @program: study-ssm
 * @description: 用户相关的service层
 * @author: bingxunqing
 * @create: 2025-12-01 23:50
 */
public interface UserService {

    public User login(String userName, String userPassword);
}
