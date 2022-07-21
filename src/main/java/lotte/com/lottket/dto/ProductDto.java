package lotte.com.lottket.dto;

import java.time.LocalDateTime;

public class ProductDto {
    private long productId;
    private String productSitm;     // 롯데 고유 품번
    private String productTitle;
    private String productCategory;
    private int productPrice;
    private int productStock;
    private String productRegDate;
    private double productTotalRate;

    private String productImageUrl;

    public ProductDto() {
    }

    public ProductDto(long productId, String productSitm, String productTitle, String productCategory, int productPrice, int productStock, String productRegDate, double productTotalRate) {
        this.productId = productId;
        this.productSitm = productSitm;
        this.productTitle = productTitle;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productRegDate = productRegDate;
        this.productTotalRate = productTotalRate;
    }

    public ProductDto(long productId, String productSitm, String productTitle, String productCategory, int productPrice, int productStock, String productRegDate, double productTotalRate, String productImageUrl) {
        this.productId = productId;
        this.productSitm = productSitm;
        this.productTitle = productTitle;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productRegDate = productRegDate;
        this.productTotalRate = productTotalRate;
        this.productImageUrl = productImageUrl;
    }


    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productSitm='" + productSitm + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", productRegDate='" + productRegDate + '\'' +
                ", productTotalRate=" + productTotalRate +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }

    public ProductDto( String productSitm, String productTitle, String category, int productPrice, int productStock, String productRegDate, double productTotalRate) {
        this.productSitm = productSitm;
        this.productTitle = productTitle;
        this.productCategory = category;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productRegDate = productRegDate;
        this.productTotalRate = productTotalRate;
    }

    public String getProductSitm() {
        return productSitm;
    }

    public void setProductSitm(String productSitm) {
        this.productSitm = productSitm;
    }

    public String getProductRegDate() {
        return productRegDate;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public double getProductTotalRate() {
        return productTotalRate;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }
}
