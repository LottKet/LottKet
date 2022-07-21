package lotte.com.lottket.dao.productdetail;

import lotte.com.lottket.dto.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductDetailDaoImpl implements ProductDetailDao{

    @Autowired
    SqlSession session;

    String ns = "ProductDetail.";

    @Override
    public ProductDto productById(int id) {
        return session.selectOne(ns + "productById", id);
    }

    @Override
    public List<ProductImageDto> productImageById(int id){
        return session.selectList(ns + "productImageById", id);
    }

    @Override
    public List<ProductDetailDto> productDetailById(int id){
        return session.selectList(ns+"productDetailById", id);
    }

    @Override
    public List<ReviewJoinUser> reviewById(int id){
        return session.selectList(ns+"reviewById", id);
    }

    @Override
    public List<ReviewJoinReply> replyById(int id){
        return session.selectList(ns+"replyById", id);
    }

    @Override
    public int insertReview(HashMap<String, Object> review) { return session.insert(ns+"insertReview", review); }

    @Override
    public int insertReply(HashMap<String, Object> reply) { return session.insert(ns+"insertReply", reply); }

    @Override
    public int updateRate(int productId) { return session.update(ns+"updateRate", productId);}
}
