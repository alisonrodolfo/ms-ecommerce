package one.digital.innovation.shoppingcart.model;

import org.springframework.data.redis.core.RedisHash;

/**
 * The type Item.
 */
@RedisHash("item")
public class Item {

    private Integer productId;
    private Integer amount;

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Sets product id.
     *
     * @param productId the product id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Item{" +
                "productId=" + productId +
                ", amount=" + amount +
                '}';
    }
}
