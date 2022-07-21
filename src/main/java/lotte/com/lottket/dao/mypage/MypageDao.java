package lotte.com.lottket.dao.mypage;

import lotte.com.lottket.dto.OrderDto;

import java.util.HashMap;
import java.util.List;

public interface MypageDao {

    List<HashMap> showAllMyOrders(Long userId);

    int changeOrderDestination(HashMap<String, Object> map);

    int cancelOrder(Long orderId);
}
