package lotte.com.lottket.controller;

import lotte.com.lottket.dao.product.ProductDao;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.service.category.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    /**
     * category로 조회
     * GET category.do
     * @param model
     * @param productCategory
     * @return "category"
     */
    @RequestMapping(value = "category.do", method = RequestMethod.GET)
    public String findByCategory(Model model, String productCategory){
        logger.info("CategoryController findByCategory()");

        model.addAttribute("productList",categoryService.findByCategory(productCategory));
        model.addAttribute("category", productCategory);

        return "category";
    }

    /**
     * 낮은 가격 순 조회
     * GET category/productPrice.do
     * @param productCategory
     * @param search (검색어)
     * @return "category"
     */
    @ResponseBody
    @RequestMapping(value="category/productPrice.do", method = RequestMethod.GET)
    public List<ProductDto> findByCategoryOrderByProductPrice(String productCategory, String search) {
        logger.info("CategoryController findByCategoryOrderByProductPrice() ");
        List<ProductDto> list= categoryService.findByCategoryOrderByProductPrice(search, productCategory);

        return list;
    }

    /**
     * Product 등록 최신순으로 조회
     * GET category/regDate.do
     * @param productCategory
     * @param search
     * @return "category"
     */
    @ResponseBody
    @RequestMapping(value="category/regDate.do", method = RequestMethod.GET)
    public List<ProductDto> findByCategoryOrderByProductRegDate(String productCategory, String search){
        logger.info("CategoryController findByCategoryOrderByProductRegDate() ");

        List<ProductDto> list =categoryService.findByCategoryOrderByProductRegDate(search,productCategory);

        return list;

    }

    /**
     * 높은 평점 순으로 조회
     * GET category/totalRate.do
     * @param productCategory
     * @param search
     * @return
     */
    @ResponseBody
    @RequestMapping(value="category/totalRate.do", method = RequestMethod.GET)
    public List<ProductDto> findByCategoryOrderByProductTotalRate(String productCategory, String search){
        logger.info("CategoryController findByCategoryOrderByProductRegDate() ");

        return categoryService.findByCategoryOrderByProductTotalRate(search,productCategory);

    }
}
