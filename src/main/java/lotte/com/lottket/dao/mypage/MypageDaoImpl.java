package lotte.com.lottket.dao.mypage;

import lotte.com.lottket.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MypageDaoImpl implements MypageDao{

    @Autowired
    SqlSession session;

    String ns = "Mypage.";

    @Override
    public List<HashMap> showAllMyOrders(Long userId) {
        return session.selectList(ns + "selectAllMyOrders", userId);
    }

    @Override
    public int changeOrderDestination(HashMap<String, Object> map) {
        return session.update(ns + "updateOrderDestination", map);
    }

    @Override
    public int cancelOrder(Long orderId) {
        return session.delete(ns + "deleteOrder", orderId);
    }
}
