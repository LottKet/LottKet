package lotte.com.lottket.dto;

public class CartDto {

    private Long cartId;
    private Long userId;
    private Long productId;
    private int amount;

    public CartDto() {

    }

    public CartDto(Long cartId, Long userId, Long productId, int amount) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
    }

    public CartDto(Long userId, Long productId, int amount) {
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", amount=" + amount +
                '}';
    }
}
