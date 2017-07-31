package team10.ldcc.com.smartconsumer.Data;

import java.io.Serializable;

/**
 * Created by Gelgel on 2017. 7. 30..
 */
public class Cart implements Serializable {
    private String user_code;
    private String productDetail_code;
    private String cart_count;
    private String cart_delivery;

    private String product_name;
    private String product_count;
    private String product_delivery;
    private String product_image;

    public Cart(String product_name, String product_count, String product_delivery, String product_image) {
        this.product_name = product_name;
        this.product_count = product_count;
        this.product_delivery = product_delivery;
        this.product_image = product_image;
    }

    public String getCart_count() {
        return cart_count;
    }

    public void setCart_count(String cart_count) {
        this.cart_count = cart_count;
    }

    public String getCart_delivery() {
        return cart_delivery;
    }

    public void setCart_delivery(String cart_delivery) {
        this.cart_delivery = cart_delivery;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getProductDetail_code() {
        return productDetail_code;
    }

    public void setProductDetail_code(String productDetail_code) {
        this.productDetail_code = productDetail_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }

    public String getProduct_delivery() {
        return product_delivery;
    }

    public void setProduct_delivery(String product_delivery) {
        this.product_delivery = product_delivery;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }


    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "product_image='" + product_image + '\'' +
                ", product_delivery='" + product_delivery + '\'' +
                ", product_count='" + product_count + '\'' +
                ", product_name='" + product_name + '\'' +
                ", productDetail_code='" + productDetail_code + '\'' +
                ", user_code='" + user_code + '\'' +
                '}';
    }
}
