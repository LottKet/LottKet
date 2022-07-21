package lotte.com.lottket.dao.product;

import lotte.com.lottket.dto.ProductDetailDto;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.ProductImageDto;
import java.util.Map;
import java.util.List;
import java.util.Map;

public interface ProductDao {

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
