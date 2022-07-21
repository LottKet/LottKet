package lotte.com.lottket.dto;

public class ProductImageDto {
    private int productImageIdx;
    private int productId;
    private String productImageUrl;
    private String productTitle;
    public ProductImageDto() {

    }

    public ProductImageDto(int productId, int productImageIdx, String productImageUrl) {
        this.productId = productId;
        this.productImageIdx = productImageIdx;
        this.productImageUrl = productImageUrl;
    }

    public ProductImageDto(int productImageIdx, int productId, String productImageUrl, String productTitle) {
        this.productImageIdx = productImageIdx;
        this.productId = productId;
        this.productImageUrl = productImageUrl;
        this.productTitle = productTitle;
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

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
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
                ", productName='" + productTitle + '\'' +
                '}';
    }
}
