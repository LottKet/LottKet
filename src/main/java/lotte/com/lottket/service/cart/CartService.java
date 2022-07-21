package lotte.com.lottket.service.cart;

import lotte.com.lottket.dto.CartDto;

import java.util.List;

public interface CartService {
    // 카트1추가, 카트1삭제, 카트selectAll,

    List<CartDto> findAllCart(Long userId);

    int addNewCart(CartDto dto);

    int deleteOneCart(Long cartId);
    int deleteAllCart(Long userId);


}

