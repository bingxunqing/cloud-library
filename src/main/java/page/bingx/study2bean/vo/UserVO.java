package page.bingx.study2bean.vo;

import lombok.Data;
import page.bingx.study2bean.pojo.Order;

import java.util.List;

/**
 * @program: study2-bean
 * @description:
 * @author: bingxunqing
 * @create: 2025-11-30 10:21
 */
@Data
public class UserVO {
    private Integer id;
    private String username;
    private double balance;

    private List<OrderVO> orderList;


}
