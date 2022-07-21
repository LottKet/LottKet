package lotte.com.lottket.controller;
import lotte.com.lottket.service.product.DBInitialize;
import lotte.com.lottket.service.product.ProductService;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.ProductImageDto;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @RequestMapping(value="main.do", method = RequestMethod.GET)
    public String main(Model model) {
        List<ProductImageDto> bestProduct = selectBestProduct();
        List<ProductImageDto> weeklyBestProduct = selectWeeklyBestProduct();
        List<ProductImageDto> newProduct = selectNewProduct();
        model.addAttribute("bestProduct", bestProduct);
        model.addAttribute("weeklyBestProduct", weeklyBestProduct);
        model.addAttribute("newProduct", newProduct);
        return "main";
    }

    /**
     * 도메인 productlist.do 로 가야만 db값 insert하는거 이상하니 추후 수정할게요 insert xml도 이후에
     */
    @RequestMapping(value="productlist.do", method = RequestMethod.GET)
    public String insertAllProducts(Model model){

        String ret = "";
        logger.info("ProductController insertAllProducts() ");

        Map<String, Object> paramMap = new HashMap<>();
        List<ProductDto> productList = new ArrayList<>();
        List<ProductImageDto> productImageList = new ArrayList<>();

        if(service.checkIfEmptyDB()) {
            try {
                paramMap = DBInitialize.run();
                productList = (List<ProductDto>) paramMap.get("productList");
                productImageList = (List<ProductImageDto>) paramMap.get("productImageList");

                /**
                 * product table 값 insert
                 */
                for (int i = 0; i < productList.size(); i++) {
                    service.insertOneProduct(productList.get(i));
                    System.out.println(i+" : "+productList.get(i).toString());
                }
                /**
                 * productimage table 값 insert
                 */
                for (int i = 0; i < productImageList.size(); i++) {
                    service.insertOneImage(productImageList.get(i));
                    System.out.println(i+" : "+productImageList.get(i).toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("productList", productList);
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
    public String updateProduct(@RequestBody ProductDto dto) {
        int count = service.updateProduct(dto);
        return count>0?"YES":"NO";
    }

    @RequestMapping(value="deleteProduct.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteProduct(@RequestBody ProductDto dto) {
        int count = service.deleteProduct(dto);
        return count>0?"YES":"NO";
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
}
