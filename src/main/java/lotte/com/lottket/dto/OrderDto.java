package lotte.com.lottket.dto;

import java.util.Date;

public class OrderDto
{

    private long orderId;
    private int orderAmount;
    private String orderDate;
    private String orderAddress;
    private String orderDetailAddress;
    private int orderTotalPrice;
    private String payment;
    private String deliveryRequirement;

    private String productImageUrl;

    private int salePrice;

    // User
    private long userId;
    private String userName;
    private String userPhoneNumber;

    private String userGrade;
    // Product
    private long productId;
    private String productTitle;
    private int productPrice;

    private String productCategory;

    public OrderDto() {
    }

    public OrderDto(int orderAmount, String orderAddress, String orderDetailAddress, int orderTotalPrice, long userId, String userName, String userPhoneNumber, long productId, String productTitle, int productPrice, String productImageUrl) {
        this.orderAmount = orderAmount;
        this.orderAddress = orderAddress;
        this.orderDetailAddress = orderDetailAddress;
        this.orderTotalPrice = orderTotalPrice;
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productImageUrl=productImageUrl;
    }

    public OrderDto( int orderAmount, String orderAddress, String orderDetailAddress, int orderTotalPrice, long userId, String userName, String userPhoneNumber, long productId, String productTitle, int productPrice,String orderDate, String payment) {
        this.orderAmount = orderAmount;
        this.orderAddress = orderAddress;
        this.orderDetailAddress = orderDetailAddress;
        this.orderTotalPrice = orderTotalPrice;
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.payment=payment;
        this.orderDate=orderDate;
    }

    public OrderDto(long orderId, int orderAmount, String orderDate, String orderAddress, String orderDetailAddress, int orderTotalPrice, String payment, String deliveryRequirement, long userId, String userName, String userPhoneNumber, long productId, String productTitle, int productPrice) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderDetailAddress = orderDetailAddress;
        this.orderTotalPrice = orderTotalPrice;
        this.payment = payment;
        this.deliveryRequirement = deliveryRequirement;
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }



    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderDetailAddress() {
        return orderDetailAddress;
    }

    public void setOrderDetailAddress(String orderDetailAddress) {
        this.orderDetailAddress = orderDetailAddress;
    }

    public int getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(int orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDeliveryRequirement() {
        return deliveryRequirement;
    }

    public void setDeliveryRequirement(String deliveryRequirement) {
        this.deliveryRequirement = deliveryRequirement;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void changeSalePrice(int price){
        this.salePrice=price;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", orderAmount=" + orderAmount +
                ", orderDate='" + orderDate + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderDetailAddress='" + orderDetailAddress + '\'' +
                ", orderTotalPrice=" + orderTotalPrice +
                ", payment='" + payment + '\'' +
                ", deliveryRequirement='" + deliveryRequirement + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", salePrice=" + salePrice +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userGrade='" + userGrade + '\'' +
                ", productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
