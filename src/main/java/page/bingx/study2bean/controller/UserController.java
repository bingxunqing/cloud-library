package page.bingx.study2bean.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import page.bingx.study2bean.common.Result;
import page.bingx.study2bean.pojo.Order;
import page.bingx.study2bean.pojo.User;
import page.bingx.study2bean.service.UserService;
import page.bingx.study2bean.vo.OrderVO;
import page.bingx.study2bean.vo.UserVO;

import java.util.ArrayList;
import java.util.List;


/**
 * @author bingxunqin
 * 控制层的bean对象
 */
@RestController("UserController")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    @Resource(name = "UserService")
    private final UserService userService;
//    这是字段注入十分不推荐，编译的原理是 先通过无参构造获取到这个bean对象，才能使用字段注入
    // 然后构造完无参构造后，这时候存在这个对象的内存后，才能去寻找对应名称的bean对象
    // 才给这个字段赋值，如果构造函数有这个注入字段的调用，这时候这个字段还是null
    // 就会出现NullPointer
//    @Resource(name = "UserService")
//    private UserService userService;

//    public UserControllerImp(UserService userService) {
//        System.out.println("UserControllerImp created!");
//        this.userService = userService;
//    }

    @GetMapping("/{id}")
    public Result<UserVO> getUserWithOrders(@PathVariable("id") Integer id) {
        UserVO uservo = userService.getUserWithOrders(id);
        if (uservo == null) {
            return Result.failed("User not found");
        }
        return Result.success(uservo);

    }

}
