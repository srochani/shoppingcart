package com.hmrc.shoppingcart;

import com.hmrc.shoppingcart.model.OrderInfo;
import com.hmrc.shoppingcart.model.Product;
import com.hmrc.shoppingcart.service.ShoppingCartService;

/**
 * Created by Sunil on 27/01/2017.
 */
public class ShoppingCartMain {

    public static void main(String arg[]){

        String apple = "APPLE";
        Double applePrice = 00.60;
        String orange = "ORANGE";
        Double orangePrice = 00.25;

        Product appleProduct = new Product();
        appleProduct.setName(apple);
        appleProduct.setCode("101");
        appleProduct.setPrice(applePrice);

        Product orangeProduct = new Product();
        orangeProduct.setName(orange);
        orangeProduct.setCode("102");
        orangeProduct.setPrice(orangePrice);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNum("10001");

        ShoppingCartService shoppingCartService = new ShoppingCartService();
        shoppingCartService.addProduct(orderInfo,appleProduct,1);
        shoppingCartService.addProduct(orderInfo,appleProduct,1);
        shoppingCartService.addProduct(orderInfo,orangeProduct,1);
        //shoppingCartService.addProduct(orderInfo,appleProduct,1);

        System.out.println("total checkout amount => " + shoppingCartService.totalAmount(orderInfo) );

        shoppingCartService.applyDiscount(orderInfo);

        System.out.println("total checkout amount => " + shoppingCartService.totalDiscountedAmount(orderInfo) );


    }
}
