package cn.njupt.rest_reservation.controller;

import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.service.ReservationService;
import cn.njupt.rest_reservation.utils.DateTableUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @ResponseBody
    @RequestMapping(value = "cancel_reservation.json")
    public void cancel_reservation(HttpServletResponse response,
                              Integer id)throws  Exception{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(fmt);

        Map returnMap = new HashMap();
        try {
            Map requestMap = new HashMap();
            requestMap.put("id",id);
            returnMap =reservationService.cancel_reservation(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
        return;
    }

    @ResponseBody
    @RequestMapping(value = "transfer_reservation.json")
    public void transfer_reservation(HttpServletResponse response,
                                     Integer id,
                                     Integer newTableId)throws  Exception{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(fmt);

        Map returnMap = new HashMap();
        try {
            Map requestMap = new HashMap();
            requestMap.put("id",id);
            requestMap.put("newTableId",newTableId);
            returnMap =reservationService.transfer_reservation(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
        return;
    }

    @ResponseBody
    @RequestMapping(value = "record_arrival.json")
    public void record_arrival(HttpServletResponse response,
                                     Integer id)throws  Exception{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(fmt);

        Map returnMap = new HashMap();
        try {
            Map requestMap = new HashMap();
            requestMap.put("id",id);
            returnMap =reservationService.record_arrival(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            e.printStackTrace();
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
        return;
    }

    @ResponseBody
    @RequestMapping(value = "end_meal.json")
    public void end_meal(HttpServletResponse response,
                               Integer id)throws  Exception{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(fmt);

        Map returnMap = new HashMap();
        try {
            Map requestMap = new HashMap();
            requestMap.put("id",id);
            returnMap =reservationService.end_meal(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            e.printStackTrace();
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
        return;
    }

    @ResponseBody
    @RequestMapping(value = "add_Reservation.json")
    public void add_reservation(HttpServletResponse response,
                                HttpServletRequest request,
                                HttpSession session,
                                     String token,
                                     Integer tablewareNumber,
                                     String mealTime,
                                     Integer flag
                                     )throws  Exception{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(fmt);

        Map returnMap = new HashMap();
        try {
            Map requestMap = new HashMap();
            switch (flag){
                case 0 :
                    Integer userId =Integer.parseInt(token);
                    requestMap.put("userId",userId);
                    requestMap.put("tablewareNumber",tablewareNumber);
                    requestMap.put("flag",flag);
                    requestMap.put("mealTime",mealTime);
                    break;
                case 1:
                    requestMap.put("userId",0);
                    requestMap.put("tablewareNumber",tablewareNumber);
                    requestMap.put("flag",flag);
                    requestMap.put("mealTime",mealTime);
                    break;
            }
            returnMap =reservationService.addReservation(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            outWriter.write(mapper.writeValueAsString(returnMap));
            e.printStackTrace();
        }
        return;
    }


}
