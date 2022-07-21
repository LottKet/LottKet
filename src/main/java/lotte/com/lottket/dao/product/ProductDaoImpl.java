package lotte.com.lottket.dao.product;

import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.ProductImageDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Map;

@Service
public class ProductDaoImpl implements ProductDao{
    @Autowired
    SqlSession session;

    String ns = "Product.";

    Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Override
    public void insertOneProduct(ProductDto dto) {
        session.insert(ns + "insertOneProduct", dto);
    }

    @Override
    public void insertOneImage(ProductImageDto dto) {
        session.insert(ns + "insertOneImage", dto);
    }

    @Override
    public boolean checkIfEmptyDB() {
        if( session.selectList(ns + "checkIfEmptyDB").size()  > 0)
            return false;   // not empty
        else
            return true;    // is empty
    }

    @Override
    public int insertProduct(ProductDto dto) {
        return session.insert(ns + "insertProduct", dto);
    }

    @Override
    public int updateProduct(ProductDto dto) {
        return session.update(ns + "updateProduct", dto);
    }

    @Override
    public int deleteProduct(ProductDto dto) {
        return session.delete(ns + "deleteProduct", dto);
    }

    @Override
    public ProductDto selectProduct(ProductDto dto) {
        return session.selectOne(ns + "selectProduct", Long.toString(dto.getProductId()));
    }

    @Override
    public List<ProductDto> selectProductAll() {
        return session.selectList(ns + "selectProductAll");
    }

    @Override
    public List<ProductDto> selectProductFind(String productTitle) {
        return session.selectList(ns + "selectProductFind", productTitle);
    }

    @Override
    public Long getId(ProductDto dto) {
        return session.selectOne(ns + "getId", dto);
    }

    @Override
    public List<ProductImageDto> selectBestProduct() {
        List<ProductImageDto> list = session.selectList(ns + "selectBestProduct") ;
        list.stream()
                .forEach(i-> {
                    i.setProductTitle(session.selectOne(ns + "getTitle", i.getProductId()));
                });
        return list;
    }

    @Override
    public List<ProductImageDto> selectWeeklyBestProduct() {
        List<ProductImageDto> list =  session.selectList(ns + "selectWeeklyBestProduct");
        list.stream()
                .forEach(i-> {
                    i.setProductTitle(session.selectOne(ns + "getTitle", i.getProductId()));
                });
        return list;
    }

    @Override
    public List<ProductImageDto> selectNewProduct() {
        List<ProductImageDto> list =  session.selectList(ns + "selectNewProduct");
        list.stream()
                .forEach(i-> {
                    i.setProductTitle(session.selectOne(ns + "getTitle", i.getProductId()));
                });
        return list;
    }

    @Override
    public int findProductStock(long productId) {
        return session.selectOne(ns+"findProductStock",productId);
    }

    @Override
    public void updateProductStock(Map<String, Object> param) {
        session.update(ns+"updateProductStock",param);
    }

    @Override
    public ProductDto findByProductId(long productId) {
        return session.selectOne(ns+"findByProductId",productId);
    }
}
