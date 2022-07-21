package lotte.com.lottket.controller;

import org.springframework.stereotype.Controller;
import lotte.com.lottket.dto.OrderDto;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.UserDto;
import lotte.com.lottket.service.order.OrderService;
import lotte.com.lottket.service.product.ProductService;
import lotte.com.lottket.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    /**
     * Order 전 Order 정보를 보여주는 orderSheet
     * POST order/orderSheet.do
     * @param model
     * @param productId
     * @param userId
     * @param orderAmount
     * @return "orderSheet"
     */
    @RequestMapping(value = "order/orderSheet.do" , method = RequestMethod.GET)
    public String orderSheet(Model model,long productId, long userId, int orderAmount){

        UserDto user= userService.findByUserId(userId);
        ProductDto product = productService.findByProductId(productId);

        int totalPrice = product.getProductPrice()*orderAmount;
        String grade= user.getUserGrade();
        int salePrice=0;
        if(grade.equals("1")) salePrice = (int)(totalPrice*0.1);
        else if(grade.equals("2")) salePrice = (int)(totalPrice*0.07);
        else if(grade.equals("3")) salePrice = (int)(totalPrice*0.05);
        else if(grade.equals("4")) salePrice = (int)(totalPrice*0.03);


        OrderDto order= new OrderDto(orderAmount, user.getUserAddress(), user.getUserDetailAddress(),totalPrice
                ,user.getUserId(), user.getUserName(), user.getUserPhoneNumber(), product.getProductId(),product.getProductTitle(),product.getProductPrice()
        ,product.getProductImageUrl());

        order.setProductCategory(product.getProductCategory());
        order.setDeliveryRequirement("문 앞에 놓아주세요");
        order.changeSalePrice(salePrice);
        model.addAttribute("order",order);

        return "order";

    }

    /**
     * 주문하기
     * POST order/makeOrder.do
     * @param model
     * @param orderDto
     * @return "myPage"
     * model userId
     * data :{ key : value , key: value}
     */
    @RequestMapping(value = "order/makeOrder.do" , method = RequestMethod.POST)
    public String saveOrder(Model model,OrderDto orderDto){

        System.out.println("OrderController.saveOrder");
        System.out.println(orderDto.toString());

        Date nowDate=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        orderDto.setOrderDate(simpleDateFormat.format(nowDate));
        orderService.saveOrder(orderDto);

        model.addAttribute("userId",orderDto.getUserId());

        int curStock=productService.findProductStock(orderDto.getProductId());
        int updateStock=curStock-orderDto.getOrderAmount();

        Map<String,Object> param=new HashMap<>();
        param.put("updateStock",updateStock);
        param.put("productId",orderDto.getProductId());

        productService.updateProductStock(param);

        return "myPage";

    }
}
