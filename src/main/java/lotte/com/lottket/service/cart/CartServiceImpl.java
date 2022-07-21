package lotte.com.lottket.service.cart;

import lotte.com.lottket.dao.cart.CartDao;
import lotte.com.lottket.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartDao dao;

    @Override
    public List<CartDto> findAllCart(Long userId) {
        return dao.selectCartAll(userId);
    }

    @Override
    public int addNewCart(CartDto dto) {
        return dao.insertCart(dto);
    }

    @Override
    public int deleteOneCart(Long cartId) {
        return dao.deleteOneCart(cartId);
    }

    @Override
    public int deleteAllCart(Long userId) {
        return dao.deleteAllCart(userId);
    }
}
