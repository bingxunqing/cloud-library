package page.bingx.study2bean.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @program: study2-bean
 * @description: 商品类
 * @author: bingxunqing
 * @create: 2025-11-28 23:55
 */
@JsonIgnoreProperties(value = { "handler" })
public class Product {
    private Integer id;
    private String productName;
    private double price;
    public  Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public  void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
