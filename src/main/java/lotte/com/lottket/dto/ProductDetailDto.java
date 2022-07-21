package lotte.com.lottket.dto;

public class ProductDetailDto {
    private int productDetailId;
    private long productId;
    private String productDetailImageUrl;

    public ProductDetailDto() {

    }

    public ProductDetailDto(long productId, String productDetailImageUrl) {
        this.productId = productId;
        this.productDetailImageUrl = productDetailImageUrl;
    }

    public ProductDetailDto(int productDetailId, long productId, String productDetailImageUrl) {
        this.productDetailId = productDetailId;
        this.productId = productId;
        this.productDetailImageUrl = productDetailImageUrl;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public long getProductId() {
        return productId;
    }

    public String getProductDetailImageUrl() {
        return productDetailImageUrl;
    }

    @Override
    public String toString() {
        return "ProductDetailDto{" +
                "productDetailId=" + productDetailId +
                ", productId=" + productId +
                ", productDetailImageUrl='" + productDetailImageUrl + '\'' +
                '}';
    }
}
