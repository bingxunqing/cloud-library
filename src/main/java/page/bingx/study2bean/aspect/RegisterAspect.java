package page.bingx.study2bean.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import page.bingx.study2bean.pojo.User;

/**
 * @author bingxunqin
 * 切面增强方法 法
 *
 */
@Aspect
@Component
public class RegisterAspect {

    @Pointcut("execution(* page.bingx.study2bean.service.UserService.register(..))")
    public void registerPointcut() {

    }

    @Before("registerPointcut()")
    public void checkPermission(JoinPoint joinPoint) {
        // 这个getArgs 方法 获取的是 拦截的方法的参数列表，比如service带了三个参数，
        // 这里面就依次放三个参数
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];

        System.out.println("正在进行权限检查...");

        if("admin".equals(user.getUsername())) {
            System.out.println("权限检查通过");
        } else {
            System.out.println("权限检查失败");
        }
    }

    @AfterReturning(pointcut = "registerPointcut()", returning = "result")
    public void writeLog(JoinPoint joinPoint,Object result) {
        System.out.println("正在记录注册日志...");
        User registerUser = (User) joinPoint.getArgs()[0];

        System.out.println("🏁 [AOP-返回通知]：开始编写注册成功日志...");
        System.out.println("   [AOP-日志]：用户 " + registerUser.getUsername() + " 注册成功。");
        System.out.println("   [AOP-日志]：Service 返回值是：" + result);
    }


}
