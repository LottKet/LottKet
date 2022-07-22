package lotte.com.lottket.controller;

import lotte.com.lottket.dto.*;
import lotte.com.lottket.service.productdetail.ProductDetailService;
import lotte.com.lottket.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class ProductDetailController {

    @Autowired
    ProductDetailService productDetailService;
    //Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "detail.do")
    public String detail(int productid, Model model){

        ProductDto productDto = productDetailService.productById(productid);
        List<ProductImageDto> productImageDto = productDetailService.productImageById(productid);
        List<ProductDetailDto> productDetailDto = productDetailService.productDetailById(productid);
        List<ReviewJoinUser> reviewJoinUserDto = productDetailService.reviewById(productid);
        List<ReviewJoinReply> reviewJoinReplyDto = productDetailService.replyById(productid);

        model.addAttribute("productDto",productDto);
        model.addAttribute("productImageDto",productImageDto);
        model.addAttribute("productDetailDto", productDetailDto);
        model.addAttribute("reviewJoinUserDto", reviewJoinUserDto);
        model.addAttribute("reviewJoinReplyDto", reviewJoinReplyDto);

        return "detail";
    }

    @RequestMapping(value = "getProductById.do")
    public String getProductById(int productid, Model model){

        ProductDto productDto = productDetailService.productById(productid);
        model.addAttribute("productDto",productDto);

        return "/detail.jsp";
    }

    @RequestMapping(value = "getProductImageById.do")
    public String getProductImageById(int productid, Model model){

        List<ProductImageDto> productImageDto = productDetailService.productImageById(productid);
        model.addAttribute("productImageDto",productImageDto);

        return "/detail.jsp";
    }

    @RequestMapping(value = "getProductDetailById.do")
    public String getProductDetailById(int productid, Model model) {

        List<ProductDetailDto> productDetailDto = productDetailService.productDetailById(productid);
        model.addAttribute("productDetailDto", productDetailDto);

        return "detail";
    }

    @RequestMapping(value = "getReviewById.do")
    public String getReviewById(int productid, Model model){

        List<ReviewJoinUser> reviewJoinUserDto = productDetailService.reviewById(productid);
        model.addAttribute("reviewJoinUserDto", reviewJoinUserDto);

        return "detail";
    }

    @RequestMapping(value = "getReplyById.do")
    public String getReplyById(int productid, Model model){

        List<ReviewJoinReply> reviewJoinReplyDto = productDetailService.replyById(productid);
        model.addAttribute("reviewJoinReplyDto", reviewJoinReplyDto);

        return "detail";
    }

    @RequestMapping(value = "insertReview.do")
    public String insertReview(String userRole, int userId, int productId, String content, double rating, Model model) {

        HashMap<String, Object> review = new HashMap<String, Object>();

        review.put("userId", userId);
        review.put("productId", productId);
        review.put("content", content);
        review.put("rating", rating);
        int count = productDetailService.insertReview(review);
        int count1 = productDetailService.updateRate(productId);

        ProductDto productDto = productDetailService.productById(productId);
        List<ReviewJoinUser> reviewJoinUserDto = productDetailService.reviewById(productId);
        List<ReviewJoinReply> reviewJoinReplyDto = productDetailService.replyById(productId);

        model.addAttribute("productDto",productDto);
        model.addAttribute("reviewJoinUserDto", reviewJoinUserDto);
        model.addAttribute("reviewJoinReplyDto", reviewJoinReplyDto);
        model.addAttribute("userRole",userRole);

        return "reviewhtml";
    }

    @RequestMapping(value = "insertReply.do")
    public String insertReply(String userRole, int productId, int reviewId, String content, Model model){
        System.out.print("hihi");
        HashMap<String, Object> reply = new HashMap<String, Object>();


        reply.put("reviewId",reviewId);
        reply.put("content",content);

        int count = productDetailService.insertReply(reply);

        ProductDto productDto = productDetailService.productById(productId);
        List<ReviewJoinUser> reviewJoinUserDto = productDetailService.reviewById(productId);
        List<ReviewJoinReply> reviewJoinReplyDto = productDetailService.replyById(productId);

        model.addAttribute("productDto",productDto);
        model.addAttribute("reviewJoinUserDto", reviewJoinUserDto);
        model.addAttribute("reviewJoinReplyDto", reviewJoinReplyDto);
        model.addAttribute("userRole",userRole);
        return "reviewhtml";
    }
}