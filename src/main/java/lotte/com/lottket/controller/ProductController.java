package lotte.com.lottket.controller;
import com.google.gson.JsonObject;
import lotte.com.lottket.dto.ProductDetailDto;
import lotte.com.lottket.service.category.CategoryService;
import com.google.gson.JsonParser;
import lotte.com.lottket.dto.UserDto;
import lotte.com.lottket.service.product.ProductService;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.ProductImageDto;
import lotte.com.lottket.service.user.UserService;
import org.apache.commons.collections.ArrayStack;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @Autowired
    UserService userService;

    @RequestMapping(value="main.do", method = RequestMethod.GET)
    public String main(String id, Model model) {
        List<ProductImageDto> bestProduct = selectBestProduct();
        List<ProductImageDto> weeklyBestProduct = selectWeeklyBestProduct();
        List<ProductImageDto> newProduct = selectNewProduct();
        model.addAttribute("bestProduct", bestProduct);
        model.addAttribute("weeklyBestProduct", weeklyBestProduct);
        model.addAttribute("newProduct", newProduct);

        if(id != null) {
            UserDto dto = userService.getUser(Long.parseLong(id));
            model.addAttribute("dto", dto);
        }

        return "main";
    }

    @RequestMapping(value="main.do", method = RequestMethod.POST)
    @ResponseBody
    public String mainPost(@RequestBody String ob, Model model) {
        JSONObject obj = new JSONObject(ob);
        String email = "";
        if(obj.has("email")) {
            email = obj.getString("email");
        }

        List<ProductImageDto> bestProduct = selectBestProduct();
        List<ProductImageDto> weeklyBestProduct = selectWeeklyBestProduct();
        List<ProductImageDto> newProduct = selectNewProduct();
        model.addAttribute("bestProduct", bestProduct);
        model.addAttribute("weeklyBestProduct", weeklyBestProduct);
        model.addAttribute("newProduct", newProduct);
        return "main";
    }

    @RequestMapping(value="insertProduct.do", method = RequestMethod.GET)
    @ResponseBody
    public String insertProduct(@RequestBody ProductDto dto) {
        int count = service.insertProduct(dto);
        return count>0?"YES":"NO";
    }

    @RequestMapping(value="updateProduct.do", method = RequestMethod.POST)
    @ResponseBody
    public String updateProduct(@RequestBody String json) {
        JSONObject jsonObject = new JSONObject(json);
        String productId = jsonObject.getString("productId");
        String productTitle = jsonObject.getString("productTitle");
        String productCategory = jsonObject.getString("productCategory");
        String productPrice = jsonObject.getString("productPrice");
        String productStock = jsonObject.getString("productStock");
        ProductDto dto = new ProductDto(Integer.parseInt(productId), productTitle, productCategory, Integer.parseInt(productPrice), Integer.parseInt(productStock), "now()", 0.0, null);
        int count = service.updateProduct(dto);
        return count>0?"YES":"NO";
    }

    @RequestMapping(value="deleteProduct.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteProduct(@RequestBody String productTitle, @RequestBody String productCategory, @RequestBody String productPrice, @RequestBody String productStock) {
//        ProductDto dto = new ProductDto(productTitle, productCategory, Integer.parseInt(productPrice), Integer.parseInt(productStock), "now()", 0.0);
//        int count = service.deleteProduct(dto);
//        return count>0?"YES":"NO";
        return "";
    }

    @RequestMapping(value="selectProduct.do", method = RequestMethod.GET)
    @ResponseBody
    //json
    public String selectProduct(ProductDto dto) throws IOException {
        Long id = (Long)service.getId(dto);
        dto.setProductId(id);

        JSONObject obj = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();

        ProductDto result = service.selectProduct(dto);
        String resultJson = mapper.writeValueAsString(result);
        return resultJson;
    }

    @RequestMapping(value="selectProductAll.do", method = RequestMethod.POST)
    //@ResponseBody
    public List<ProductDto> selectProductAll() {
        return service.selectProductAll();
    }

    @RequestMapping(value="selectProductFind.do", method = RequestMethod.GET)
    //@ResponseBody
    public List<ProductDto> selectProductFind(String productTitle) {
        return service.selectProductFind(productTitle);
    }


    @RequestMapping(value="selectBestProduct.do", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductImageDto> selectBestProduct() {
        List<ProductImageDto> dto = service.selectBestProduct();
        return dto;
    }

    @RequestMapping(value="selectWeeklyBestProduct.do", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductImageDto> selectWeeklyBestProduct() {
        List<ProductImageDto> dto = service.selectWeeklyBestProduct();
        return dto;
    }

    @RequestMapping(value="selectNewProduct.do", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductImageDto> selectNewProduct() {
        List<ProductImageDto> dto = service.selectNewProduct();
        return dto;
    }

    @RequestMapping(value="moveadmin.do", method = RequestMethod.GET)
    public String moveadmin(Model model) {
        List<ProductDto> list = selectProductAll();
        model.addAttribute("list", list);
        return "admin_product_crud";
    }
}
