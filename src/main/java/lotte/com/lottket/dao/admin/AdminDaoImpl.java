package lotte.com.lottket.dao.admin;

import lotte.com.lottket.dto.OrdersDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

import static com.mysql.cj.conf.PropertyKey.logger;

@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    SqlSession session;

    String ns = "statistics.";

    Logger log = Logger.getLogger(AdminDaoImpl.class);

    /***
     * 날짜별 주문 통계
     * @param map
     * @return List<HashMap>
     */
    @Override
    public List<HashMap> selectStatistics(HashMap map) {
        if (map.get("date").equals("day")) {
            return session.selectList(ns + "salesdaytotal", map);
        } else if (map.get("date").equals("week")) {
            return session.selectList(ns + "salesweektotal", map);
        } else if ((map.get("date")).equals("month")) {
            return session.selectList(ns + "salesmonthtotal", map);
        }
        return null;
    }

    /***
     * 전체 주문 조회
     * @param map
     * @return List<HashMap>
     */
    @Override
    public List<OrdersDto> selectTotalOrders(HashMap map) {
        return session.selectList(ns + "totalorders", map);
    }

    /***
     * 인기 상품 통계
     * @param map
     * @return List<HashMap>
     */
    @Override
    public List<HashMap> selectPopulalityProduct(HashMap map) {
        return session.selectList(ns + "populalityproduct", map);
    }

    /***
     * 나이별 주문 통계
     * @param map
     * @return HashMap
     */
    @Override
    public HashMap<String, Object> selectAgeStatistics(HashMap map) {
        return session.selectOne(ns + "agestatistics", map);
    }

    /***
     * 성별 주문 통계
     * @param map
     * @return HashMap
     */
    @Override
    public HashMap<String, Object> selectGenderStatistics(HashMap map) {
        return session.selectOne(ns + "genderstatistics", map);
    }
}
