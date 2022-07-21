package lotte.com.lottket.service.productdetail;

import lotte.com.lottket.dto.*;

import java.util.HashMap;
import java.util.List;

public interface ProductDetailService {
    ProductDto productById(int id);

    List<ProductImageDto> productImageById(int id);

    List<ProductDetailDto> productDetailById(int id);

    List<ReviewJoinUser> reviewById(int id);

    List<ReviewJoinReply> replyById(int id);

    int insertReview(HashMap<String, Object> review);

    int insertReply(HashMap<String, Object> reply);

    int updateRate(int productId);
}
