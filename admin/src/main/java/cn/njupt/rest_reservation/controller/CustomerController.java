package cn.njupt.rest_reservation.controller;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.model.Customer;
import cn.njupt.rest_reservation.service.CustomerService;
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
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "customer_list.json")
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
            returnMap =customerService.queryAllCustomer(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            returnMap = ResponseConstant.getResponsecodeDesc(10005);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
        return;
    }

    @ResponseBody
    @RequestMapping(value="login.json")
    public void login(HttpSession session,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             String account,
                             String password)
            throws Exception{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Map returnMap = new HashMap();
        try {
            returnMap = customerService.login(account,password);
            if(String.valueOf(returnMap.get(ParameterConstant.RETURN_CODE)).equals("0")){
                Customer customer = (Customer)returnMap.get("customer");
                request.getSession().setAttribute("account",account);
                request.getSession().setAttribute("userId",customer.getId());
            }
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            returnMap = ResponseConstant.getOneResponseMsg("登录失败");
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
    }

}
