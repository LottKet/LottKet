package lotte.com.lottket.controller;

import lotte.com.lottket.dto.CartDto;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.UserDto;
import lotte.com.lottket.service.cart.CartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CartController {
    /**
     * 장바구니 페이지 내에서는 완전히 새로운 상품을 추가 불가능하다
     * 제품 상세페이지 -> ' 장바구니에 추가 ' 로만 새 상품 추가 가능
     *
     * 따라서 장바구니 페이지 내에서는 이미 담긴 물품들 수량 up, down, delete만 가능
     */
    @Autowired
    CartService cartService;
    Logger logger = LoggerFactory.getLogger(CartController.class);

    /**
     * 내 장바구니 모든 물품 조회
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping(value = "cart.do", method = RequestMethod.GET)
    public String findAllCart(@RequestParam("userId") Long userId, Model model) {

        List<CartDto> mycartList = cartService.findAllCart(userId);
        model.addAttribute("myCartList", mycartList);
        return "cart";
    }

    /**
     * 장바구니에 기존에 안담겨있던 새 물품 추가 ( 제품 상세에서 버튼으로 Ajax )
     * @param model, Long userId, Long productId, int amount
     * @return String
     */
    @RequestMapping(value = "newcart.do", method = RequestMethod.POST)
    @ResponseBody // Ajax 처리시 필수
    public String addNewCart(Model model,
                             @RequestBody CartDto dto
//                            ,@RequestParam("userId") Long userId,
//                             @RequestParam("productId") Long productId,
//                             @RequestParam("amount") int amount
    ) {
        CartDto cartDto = new CartDto(dto.getUserId(), dto.getProductId(), dto.getAmount());
        int count = cartService.addNewCart(cartDto);
        return count>0?"YES":"NO";
    }

    /**
     * 카트 한개 삭제 Ajax 버튼으로 처리
     * @param model,  Long cartId
     * @return String
     */
    @RequestMapping(value = "deletecart.do", method= RequestMethod.POST)
    @ResponseBody
    public String deleteOneCart(Model model, @RequestBody Long cartId) {
        int count = cartService.deleteOneCart(cartId);
//        model.addAttribute("cartId", cartId);
        return count>0?"YES":"NO";
    }

    /**
     * 카트 전부 삭제 Ajax 버튼으로 처리
     * @param model, Long userId
     * @return String
     */
    @RequestMapping(value = "deleteallcart.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAllCart(Model model, @RequestBody Long userId) {
        int count = cartService.deleteAllCart(userId);
//        model.addAttribute("userId", userId);
        return count>0?"YES":"NO";
    }
}
