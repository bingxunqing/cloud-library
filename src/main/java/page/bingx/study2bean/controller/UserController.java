package page.bingx.study2bean.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import page.bingx.study2bean.DTO.UserLoginDTO;
import page.bingx.study2bean.common.Result;
import page.bingx.study2bean.pojo.User;
import page.bingx.study2bean.service.UserService;
import page.bingx.study2bean.vo.UserVO;

/**
 * @program: study-ssm
 * @description: 控制层
 * @author: bingxunqing
 * @create: 2025-12-01 23:53
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody UserLoginDTO user, HttpSession session){

        if (!StringUtils.hasText(user.getUserName()) || !StringUtils.hasText(user.getUserPassword())) {
            return Result.failed("输入不完整");
        }
        User loginUser = userService.login(user.getUserName(), user.getUserPassword());
//        if (loginUser == null) {
//            return Result.Loginfailed("账号或密码错误");
//        }
        if (!StringUtils.hasText(loginUser.getUserName())) {
            return Result.Loginfailed("账号或密码错误");
        }

        System.out.println("loginUser:" + loginUser.getUserName()+"," + loginUser.getUserPassword()+"," + loginUser.getUserEmail()+"," + loginUser.getUserRole()+"11111111111111111111111\n231321312");
        System.out.println("----------------------------------\n"+StringUtils.hasText(loginUser.getUserName())+"\n"+StringUtils.hasText(loginUser.getUserPassword()));
            session.setAttribute("loginUser", loginUser);

            UserVO userVO = new UserVO();
            userVO.setUserName(loginUser.getUserName());
            userVO.setEmail(loginUser.getUserEmail());
            userVO.setRole(loginUser.getUserRole());
            return Result.success(userVO);
//        if(loginUser != null){
//           session.setAttribute("loginUser", loginUser);
//
//            UserVO userVO = new UserVO();
//            userVO.setUserName(loginUser.getUserName());
//            userVO.setEmail(loginUser.getUserEmail());
//            userVO.setRole(loginUser.getUserRole());
//
//            return Result.success(userVO);
//        }
    }
}
