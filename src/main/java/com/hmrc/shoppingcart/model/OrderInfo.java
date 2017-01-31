package com.hmrc.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class hold order information with order details
 * Created by Sunil on 27/01/2017.
 */
public class OrderInfo {
    private String orderNum;
    private Double totalAmt;
    private Double discountAmt;
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Double getTotalAmt() {
        Double total = 0.0;
        if(orderDetails != null && !orderDetails.isEmpty()){
            for(OrderDetail orderDetail : orderDetails){
                total = total + orderDetail.getProduct().getPrice() * orderDetail.getQuantity();
            }
        }
        return total;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Integer getTotalQuantity(){
        Integer totalQuantity = 0;
        if(orderDetails != null && !orderDetails.isEmpty()){
            for(OrderDetail orderDetail : orderDetails){
                totalQuantity = totalQuantity + orderDetail.getQuantity();
            }
        }
        return totalQuantity;
    }

    public Double getTotalDiscountedAmt() {
        return getTotalAmt() - discountAmt;
    }
}
