package page.bingx.study2bean.service;

import page.bingx.study2bean.pojo.User;
import page.bingx.study2bean.vo.UserVO;

public interface UserService {
    UserVO getUserWithOrders(Integer id);
//    int register(User user);
}
