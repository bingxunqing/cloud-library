package page.bingx.study2bean.pojo;

/**
 * @program: study2-bean
 * @description: 查询订单的参数类
 * @author: bingxunqing
 * @create: 2025-11-29 10:27
 */
public class OrderSearch {
    private Integer id;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private  Integer userId;
    private Double minAmount;
    private Double maxAmount;
    private String orderNumberKeyword;

    public String getOrderNumberKeyword() {
        return orderNumberKeyword;
    }

    public void setOrderNumberKeyword(String orderNumberKeyword) {
        this.orderNumberKeyword = orderNumberKeyword;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

}
