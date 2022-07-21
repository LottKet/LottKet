package lotte.com.lottket.service.product;

import lotte.com.lottket.dto.ProductDetailDto;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.ProductImageDto;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;
public interface ProductService {

    void insertOneProduct(ProductDto dto);
    void insertOneImage(ProductImageDto dto);
    void insertOneDetailImage(ProductDetailDto dto);
    boolean checkIfEmptyDB();

    ProductDto findByProductId(long productId);
    int insertProduct(ProductDto dto);
    int updateProduct(ProductDto dto);
    int deleteProduct(ProductDto dto);
    ProductDto selectProduct(ProductDto dto);
    List<ProductDto> selectProductAll();
    List<ProductDto> selectProductFind(String productTitle);
    Long getId(ProductDto dto);
    List<ProductImageDto> selectBestProduct();
    List<ProductImageDto> selectWeeklyBestProduct();
    List<ProductImageDto> selectNewProduct();

    int findProductStock(long productId);
    void updateProductStock(Map<String,Object> param);

}
