package lotte.com.lottket.service.productdetail;

import lotte.com.lottket.dao.productdetail.ProductDetailDao;
import lotte.com.lottket.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{

    @Autowired
    ProductDetailDao productDetailDao;

    @Override
    public ProductDto productById(int id){
        return productDetailDao.productById(id);
    }

    @Override
    public List<ProductImageDto> productImageById(int id){
        return productDetailDao.productImageById(id);
    }

    @Override
    public List<ProductDetailDto> productDetailById(int id) { return productDetailDao.productDetailById(id);}

    @Override
    public List<ReviewJoinUser> reviewById(int id) { return productDetailDao.reviewById(id);}

    @Override
    public List<ReviewJoinReply> replyById(int id) { return productDetailDao.replyById(id);}

    @Override
    public int insertReview(HashMap<String, Object> review) { return productDetailDao.insertReview(review);}

    @Override
    public int insertReply(HashMap<String, Object> reply) { return productDetailDao.insertReply(reply); }

    @Override
    public int updateRate(int productId) { return productDetailDao.updateRate(productId);}
}
