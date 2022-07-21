package lotte.com.lottket.dao.cart;

import lotte.com.lottket.dto.CartDto;
import lotte.com.lottket.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao{

    @Autowired
    SqlSession session;

    String ns = "Cart.";

    /* 내 장바구니 전부 출력 */
    @Override
    public List<CartDto> selectCartAll(Long userId) {
        return session.selectList(ns + "selectCartAll", userId);
    }

    /* 장바구니 카트 하나 추가 */
    @Override
    public int insertCart(CartDto dto) {
        return session.insert(ns + "insertCart", dto);
    }

    @Override
    public int deleteOneCart(Long cartId) {
        return session.delete(ns + "deleteCart", cartId);
    }

    @Override
    public int deleteAllCart(Long userId) {
        return session.delete(ns + "deleteCartAll", userId);
    }

}
