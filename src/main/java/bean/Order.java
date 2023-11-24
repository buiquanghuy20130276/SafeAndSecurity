package bean;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Order implements Serializable {
    private String orderID;
    private String userID;
    private String fullName;
    private int totalPrice;
    private String address;
    private String phone;
    private String email;
    private int status;
    private String createDate;
    private String updateDate;
    private String signature;
    private List<OrderDetail> orderDetails;

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", userID='" + userID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", totalPrice=" + totalPrice +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", signature='" + signature + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public Order(String orderID, String userID, String fullName, int totalPrice, String address, String phone, String email) {
        this.orderID = orderID;
        this.userID = userID;
        this.fullName = fullName;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Order(String orderID, String userID, String fullName, int totalPrice, String address, String phone, String email, int status, String createDate, String updateDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.fullName = fullName;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Order(String orderID, String userID, String fullName, int totalPrice, String address, String phone, String email, int status, String createDate, String updateDate, String signature) {
        this.orderID = orderID;
        this.userID = userID;
        this.fullName = fullName;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDataToSign(){
        StringBuilder data = new StringBuilder();
        data.append(orderID);
        data.append(userID);
        data.append(address);
        data.append(totalPrice);
        data.append(phone);
        data.append(email);
        data.append(createDate);
        data.append(updateDate);

        // Thêm các thuộc tính của từng chi tiết đơn hàng
        if (orderDetails != null) {
            for (OrderDetail detail : orderDetails) {
                data.append(detail.getProductID());
                data.append(detail.getNameProduct());
                data.append(detail.getPriceProduct());
                data.append(detail.getProductQuantity());
            }
        }

        return data.toString();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}