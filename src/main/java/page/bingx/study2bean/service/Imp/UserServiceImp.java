package page.bingx.study2bean.service.Imp;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import page.bingx.study2bean.dao.UserDao;
import page.bingx.study2bean.pojo.Order;
import page.bingx.study2bean.pojo.User;
import page.bingx.study2bean.service.UserService;
import page.bingx.study2bean.vo.OrderVO;
import page.bingx.study2bean.vo.UserVO;

import java.util.ArrayList;
import java.util.List;


/**
 * @author bingxunqin
 * Service 层的 bean 对象
 */
@Service("UserService")
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
//    @Resource(name = "userDao")
    private final UserDao userDao;

//    @Resource(name = "UserDao")
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImp(@Qualifier("userDao") UserDao userDao) {
//        this.userDao = userDao;
//    }

//    之前配置xml的beans对象用的，现在用注解就不需要了
//    public UserServiceImp(UserDao userDao) {
//        System.out.println("[Spring] create UserServiceImp object!");
//        this.userDao = userDao;
//    }

//    @Override
//    public int register(User user) {
//        System.out.println("[Service] launch!");
//        return userDao.save(user);
//    }
    @Override
    public UserVO getUserWithOrders(Integer id) {

        User user = userDao.findUserWithOrders(id);

        if(user == null){
            return null;
        }

        UserVO userVO = new UserVO();

        BeanUtils.copyProperties(user,userVO);

        if(user.getOrderList()!=null){
            List<OrderVO> orderVOList = new ArrayList<>();

            for(Order order : user.getOrderList()){
                OrderVO orderVO = new OrderVO();
                BeanUtils.copyProperties(order,orderVO);
                orderVOList.add(orderVO);
            }

            userVO.setOrderList(orderVOList);
        }

        return userVO;

    }
}
