package page.bingx.study2bean.vo;

import lombok.Data;

/**
 * @program: study2-bean
 * @description:
 * @author: bingxunqing
 * @create: 2025-11-30 10:23
 */
@Data
public class OrderVO {
    private Integer id;
    private Integer userId;
    private String order_no;
    private Double  total_amount;
}
