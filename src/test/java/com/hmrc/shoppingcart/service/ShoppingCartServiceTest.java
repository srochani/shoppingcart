package com.hmrc.shoppingcart.service;

import com.hmrc.shoppingcart.model.OrderInfo;
import com.hmrc.shoppingcart.model.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sunil on 27/01/2017.
 */
public class ShoppingCartServiceTest {

    private ShoppingCartService shoppingCartService;

    @Before
    public void setUp(){
        shoppingCartService = new ShoppingCartService();
    }

    /**
     * Test for Add product method when add a APPLE product
     */
    @Test
    public void testAddProduct(){
        String apple = "APPLE";
        Double applePrice = 00.60;

        Product appleProduct = new Product();
        appleProduct.setName(apple);
        appleProduct.setCode("101");
        appleProduct.setPrice(applePrice);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNum("10001");

        OrderInfo actualOrderInfo = shoppingCartService.addProduct(orderInfo,appleProduct,1);
        Assert.assertNotNull(actualOrderInfo);
        Assert.assertEquals(orderInfo.getOrderNum(),actualOrderInfo.getOrderNum());
        Assert.assertEquals(1,actualOrderInfo.getOrderDetails().size());

    }

    /**
     * Test for Total amount for checkout the cart
     */
    @Test
    public void testTotalAmount(){
        String orange = "ORANGE";
        Double orangePrice = 00.25;

        Product orangeProduct = new Product();
        orangeProduct.setName(orange);
        orangeProduct.setCode("102");
        orangeProduct.setPrice(orangePrice);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNum("10001");

        OrderInfo actualOrderInfo = shoppingCartService.addProduct(orderInfo,orangeProduct,1);
        Double actualAmount = shoppingCartService.totalAmount(orderInfo);

        Assert.assertNotNull(actualAmount);
        Assert.assertEquals(orangePrice,actualAmount);

    }

    /**
     * Test for discounted Amount when we have apple Buy one get one free
     */
    @Test
    public void totalDiscountedAmount(){
        String apple = "APPLE";
        Double applePrice = 00.60;
        Double expectedTotalAmt = 00.60;

        Product appleProduct = new Product();
        appleProduct.setName(apple);
        appleProduct.setCode("101");
        appleProduct.setPrice(applePrice);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNum("10001");

        OrderInfo actualOrderInfo = shoppingCartService.addProduct(orderInfo,appleProduct,1);
        actualOrderInfo = shoppingCartService.addProduct(orderInfo,appleProduct,1);

        shoppingCartService.applyDiscount(orderInfo);
        Double actualAmount = shoppingCartService.totalDiscountedAmount(orderInfo);

        Assert.assertNotNull(actualAmount);
        Assert.assertEquals(expectedTotalAmt,actualAmount);
    }

}
