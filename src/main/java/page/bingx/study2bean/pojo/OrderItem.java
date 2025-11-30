package page.bingx.study2bean.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @program: study2-bean
 * @description: 商品和订单的中间类
 * @author: bingxunqing
 * @create: 2025-11-29 00:28
 */
@JsonIgnoreProperties(value = { "handler" })
public class OrderItem {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;

    private Product product;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public  Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public  Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

}
