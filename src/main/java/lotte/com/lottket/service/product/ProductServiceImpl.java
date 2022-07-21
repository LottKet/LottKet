package lotte.com.lottket.service.product;

import lotte.com.lottket.dao.product.ProductDao;
import lotte.com.lottket.dto.ProductDetailDto;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.ProductImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao dao;

    @Override
    public void insertOneProduct(ProductDto dto) {
        dao.insertOneProduct(dto);
    }

    @Override
    public void insertOneImage(ProductImageDto dto) {
        dao.insertOneImage(dto);
    }

    @Override
    public void insertOneDetailImage(ProductDetailDto dto) {
        dao.insertOneDetailImage(dto);
    }

    public boolean checkIfEmptyDB() {
        return dao.checkIfEmptyDB();
    }
    
    @Override
    public int insertProduct(ProductDto dto) {
        return dao.insertProduct(dto);
    }

    @Override
    public int updateProduct(ProductDto dto) {
        return dao.updateProduct(dto);
    }

    @Override
    public int deleteProduct(ProductDto dto) {
        return dao.deleteProduct(dto);
    }

    @Override
    public ProductDto selectProduct(ProductDto dto) {
        return dao.selectProduct(dto);
    }

    @Override
    public List<ProductDto> selectProductAll() {
        return dao.selectProductAll();
    }

    @Override
    public List<ProductDto> selectProductFind(String productTitle) {
        return dao.selectProductFind(productTitle);
    }

    @Override
    public Long getId(ProductDto dto) {
        return dao.getId(dto);
    }

    @Override
    public List<ProductImageDto> selectBestProduct() {
        return dao.selectBestProduct();
    }

    @Override
    public List<ProductImageDto> selectWeeklyBestProduct() {
        return dao.selectWeeklyBestProduct();
    }

    @Override
    public List<ProductImageDto> selectNewProduct() {
        return dao.selectNewProduct();
    }

    @Override
    public int findProductStock(long productId) {
        return dao.findProductStock(productId);
    }

    @Override
    public void updateProductStock(Map<String, Object> param) {
        dao.updateProductStock(param);
    }

    @Override
    public ProductDto findByProductId(long productId) {
        return dao.findByProductId(productId);
    }
}
