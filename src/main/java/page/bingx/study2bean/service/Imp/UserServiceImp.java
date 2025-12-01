package page.bingx.study2bean.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import page.bingx.study2bean.dao.UserDao;
import page.bingx.study2bean.pojo.User;
import page.bingx.study2bean.service.UserService;
import page.bingx.study2bean.vo.UserVO;

/**
 * @program: study-ssm
 * @description: 实现类
 * @author: bingxunqing
 * @create: 2025-12-01 23:50
 */
@Service("UserService")
// 推荐使用企业级别的写法！！ 这样直接确保无法出现空指针（创建但是依赖还没注入的中间情况）
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Override
    public User login(String userName, String userPassword) {
        User user =  userDao.Login(userName, userPassword);

        if(user != null){
            return user;
        }
        return new User();
    }
}
