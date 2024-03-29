package lotte.com.lottket.service.mypage;

import lotte.com.lottket.dao.mypage.MypageDao;
import lotte.com.lottket.dto.OrderDto;
import lotte.com.lottket.dto.ShoworderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MypageServiceImpl implements MypageService{
    @Autowired
    MypageDao dao;

    @Override
    public List<ShoworderDto> showAllMyOrders(Long userId) {
        return dao.showAllMyOrders(userId);
    }

    @Override
    public int changeOrderDestination(OrderDto dto) {
        return dao.changeOrderDestination(dto);
    }

    @Override
    public int cancelOrder(Long orderId) {
        return dao.cancelOrder(orderId);
    }
}
