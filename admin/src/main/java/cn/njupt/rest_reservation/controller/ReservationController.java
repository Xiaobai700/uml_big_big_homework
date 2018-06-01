package cn.njupt.rest_reservation.controller;

import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.service.ReservationService;
import cn.njupt.rest_reservation.utils.DateTableUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangqiao on 2018/6/1.
 */
@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @ResponseBody
    @RequestMapping(value = "reservation_list.json")
    public void customer_list(HttpServletResponse response,
                              String aoData)throws  Exception{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(fmt);

        Map returnMap = new HashMap();
        try {
            Map requestMap = new HashMap();
            if(aoData!=null && !aoData.equals("")) {
                requestMap = DateTableUtil.getDateTableRequestDate(aoData);
            }
            returnMap =reservationService.queryAllReservation(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            returnMap = ResponseConstant.getResponsecodeDesc(10005);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
        return;

    }
}
