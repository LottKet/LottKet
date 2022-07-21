package lotte.com.lottket.controller;

import lotte.com.lottket.dto.OrdersDto;
import lotte.com.lottket.service.admin.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;


    Logger logger = LoggerFactory.getLogger(AdminController.class);

    /***
     * 인기 상품 통계
     * @param map
     * @return List<HashMap>
     */
    @RequestMapping(value="selectPopulalityProduct.do", method = RequestMethod.POST)
    @ResponseBody
    public List<HashMap> selectPopulalityProduct(@RequestBody Map<String, Object> map) {
        logger.info("selectPopulalityProduct hello" + new Date());
        return adminService.selectPopulalityProduct((HashMap) map);
    }

    /***
     * 날짜별 매출 통계
     * @param map
     * @return List<HashMap>
     */
    @RequestMapping(value="selectDateTotal.do", method = RequestMethod.POST)
    @ResponseBody
    public List<HashMap> selectDateTotal(@RequestBody Map<String, Object> map) {
        logger.info("selectDateTotal hello" + new Date());
        return adminService.selectDateTotal((HashMap) map);
    }

    /***
     * 연령별 주문 통계
     * @param map
     * @return HashMap
     */
    @RequestMapping(value="selectAgeStatistics.do", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> selectAgeStastistics(@RequestBody Map<String, Object> map) {
        logger.info("selectAgeStatistics hello" + new Date());
        return adminService.selectAgeStatistics((HashMap) map);
    }

    /***
     * 성별 주문 통계
     * @param map
     * @return HashMap
     */
    @RequestMapping(value="selectGenderStatistics.do", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object>  selectGenderStastistics(@RequestBody Map<String, Object> map) {
        logger.info("selectGenderStatistics hello" + new Date());
        return adminService.selectGenderStatistics((HashMap) map);
    }

    /***
     * 전체 주문 조회
     * @param map
     * @return List<HashMap></HashMap>
     */
    @RequestMapping(value="selectTotalOrders.do", method = RequestMethod.POST)
    @ResponseBody
    public List<OrdersDto>  selectTotalOrders(@RequestBody Map<String, Object> map) {
        logger.info("selectTotalOrders hello" + new Date());
        return adminService.selectTotalOrders((HashMap) map);
    }

    /***
     *어드민 페이지 이동
     * @param model
     * @return admin
     */
    @RequestMapping(value = "admin.do")
    public String adminInit(Model model) {
        logger.info("adminInit hello" + new Date());
        return "admin";
    }

    /***
     * 주문 페이지 이동
     * @param model
     * @return HashMap
     */
    @RequestMapping(value = "orders.do")
    public String selectOrder(Model model){
        logger.info("orders hello" + new Date());
        return "orders";
    }



}
