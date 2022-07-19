package lotte.com.lottket.dto;

public class ProductImageDto {
    private int productImageIdx;
    private int productId;
    private String productImageUrl;

    public ProductImageDto() {

    }

    public ProductImageDto(int productImageIdx, int productId, String productImageUrl) {
        this.productImageIdx = productImageIdx;
        this.productId = productId;
        this.productImageUrl = productImageUrl;
    }

    public int getProductImageIdx() {
        return productImageIdx;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageIdx(int productImageIdx) {
        this.productImageIdx = productImageIdx;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public String toString() {
        return "ProductImageDto{" +
                "productImageIdx=" + productImageIdx +
                ", productId=" + productId +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }
}
