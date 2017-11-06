package demo.mybatis.vo;

/**
 * 用于测试表属性名与实体类变量名不一致的情况
 * 
 * @author KaikaiFu
 *
 */
public class Order {
    private int orderId;
    private float orderPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String toString() {
        return "[orderId:" + this.orderId + ", orderPrice:" + this.orderPrice + "]";
    }
}
