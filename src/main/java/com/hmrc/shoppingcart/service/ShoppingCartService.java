package com.hmrc.shoppingcart.service;

import com.hmrc.shoppingcart.model.OrderDetail;
import com.hmrc.shoppingcart.model.OrderInfo;
import com.hmrc.shoppingcart.model.Product;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Sunil on 27/01/2017.
 */
public class ShoppingCartService {

    /**
     * To add product into the order info
     * @param orderInfo
     * @param product
     * @param quantity
     */
    public OrderInfo addProduct(OrderInfo orderInfo, Product product,Integer quantity ){
        if(orderInfo != null && product != null){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(product);
            orderDetail.setQuantity(quantity);
            orderInfo.getOrderDetails().add(orderDetail);
        }
        return orderInfo;
    }

    /**
     * Get total amount of the give order info
     * @param orderInfo
     * @return
     */
    public Double totalAmount(OrderInfo orderInfo){
        if(orderInfo != null) {
            return orderInfo.getTotalAmt();
        }
        else{
            return 0.0;
        }
    }


    public Double totalDiscountedAmount(OrderInfo orderInfo) {
        if(orderInfo != null){
            return orderInfo.getTotalDiscountedAmt();
        }
        else{
            return 0.0;
        }
    }

    public void applyDiscount(OrderInfo orderInfo){
        Map<Product,Integer> appleCountMap = new HashMap<>();
        if(orderInfo != null){
            for(OrderDetail orderDetail : orderInfo.getOrderDetails()){
                if(orderDetail.getProduct().getCode().equals("101")){
                    Integer appleCount = 0;
                    if(appleCountMap.containsKey(orderDetail.getProduct())) {
                        appleCount = appleCountMap.get(orderDetail.getProduct());

                    }
                    ++appleCount;
                    appleCountMap.put(orderDetail.getProduct(),appleCount);
                }
            }
            appleCountMap.forEach((k,v) -> {
                if(k.getCode().equals("101"))
                    if(v > 1) {

                        orderInfo.setDiscountAmt(k.getPrice() * (v/2));
                    }

            });
        }
    }
}
