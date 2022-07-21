package lotte.com.lottket.service.admin;

import lotte.com.lottket.dao.admin.AdminDao;
import lotte.com.lottket.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;


    /***
     * 날짜별 매출 통계
     * @param map
     * @return List<HashMap>
     */
    @Override
    public List<HashMap> selectDateTotal(HashMap map) {
        return adminDao.selectStatistics(map);
    }

    /***
     * 전체 주문 목록 조회
     * @param map
     * @return List<HashMap>
     */
    @Override
    public List<OrdersDto> selectTotalOrders(HashMap map) {
        return adminDao.selectTotalOrders(map);
    }

    /***
     * 인기 상품 통계
     * @param map
     * @return List<HashMap>
     */
    @Override
    public List<HashMap> selectPopulalityProduct(HashMap map) {
        return adminDao.selectPopulalityProduct(map);
    }

    /***
     * 성별 주문 통계
     * @param map
     * @return HashMap
     */
    @Override
    public HashMap<String, Object> selectGenderStatistics(HashMap map) { return adminDao.selectGenderStatistics(map); }

    /***
     * 나이별 주문 통계
     * @param map
     * @return HashMap
     */
    @Override
    public HashMap<String, Object> selectAgeStatistics(HashMap map) {
        return adminDao.selectAgeStatistics(map);
    }


}
