package lotte.com.lottket.controller;

import lotte.com.lottket.dto.OrderDto;
import lotte.com.lottket.dto.OrdersDto;
import lotte.com.lottket.dto.UserDto;
import lotte.com.lottket.service.mypage.MypageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MypageController {

    @Autowired
    MypageService service;
    Logger logger = LoggerFactory.getLogger(MypageController.class);

    /**
     * 내 주문 전부 조회
     */
    @RequestMapping(value="mypage.do", method = RequestMethod.GET)
    public String showAllMyOrders(@RequestParam("userId") Long userId, Model model) {
        List<HashMap> list = service.showAllMyOrders(userId);

        model.addAttribute("list", list);
        model.addAttribute("userId", userId);
        return "mypage";
    }


    /**
     * 배송지 변경  with Ajax Button
     * @param map (Long orderId, String newOrderAddress)
     * @return String
     */
    @RequestMapping(value="mypageupdateorderaddress.do", method = RequestMethod.POST)
    @ResponseBody
    public String changeOrderDestination(@RequestBody HashMap<String, Object> map) {
        int count = service.changeOrderDestination(map);

        return count>0?"YES":"NO";
    }


    /**
     * 주문 취소 Ajax Button
     * @param Long orderId
     * @return String
     */
    @RequestMapping(value="mypagedeleteorder.do", method = RequestMethod.POST)
    @ResponseBody
    public String cancelOrder(@RequestBody Long orderId) {
        int count = service.cancelOrder(orderId);

        return count>0?"YES":"NO";
    }

}
