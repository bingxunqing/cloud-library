package page.bingx.study2bean.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @program: study2-bean
 * @description: 订单类，包含订单编号，数量，id
 * @author: bingxunqing
 * @create: 2025-11-23 16:06
 */
@JsonIgnoreProperties(value = { "handler" })
public class Order {
    private Integer id;
    private Integer userId;
    private String orderNumber;
    private Double amount;
    private List<OrderItem> orderItemList;
    public Integer getUserId() {
        return userId;
    }

    public  void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setOrderItemList(List<OrderItem> productList) {
        this.orderItemList = productList;
    }
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
