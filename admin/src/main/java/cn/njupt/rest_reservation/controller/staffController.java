package cn.njupt.rest_reservation.controller;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.model.Staff;
import cn.njupt.rest_reservation.service.StaffService;
import cn.njupt.rest_reservation.utils.DateTableUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangqiao on 2018/5/31.
 */
@Controller
public class staffController {
    @Autowired
    private StaffService staffService;

    /*登陆验证*/
    @ResponseBody
    @RequestMapping(value="loginCheck.json")
    public  void  loginCheck(HttpSession session,
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
            returnMap = staffService.login(account,password);
            if(String.valueOf(returnMap.get(ParameterConstant.RETURN_CODE)).equals("0")){
                Staff staff = (Staff) returnMap.get("staff");
                request.getSession().setAttribute("account",account);
                request.getSession().setAttribute("userId",staff.getId());
            }
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            returnMap = ResponseConstant.getOneResponseMsg("登录失败");
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
    }

    /*登出*/
    @RequestMapping(value = "login_out.html")
    public ModelAndView login_out(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("login");
        request.removeAttribute(ParameterConstant.P_ACCOUNT);
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "staff_list.json")
    public void banner_list(HttpServletResponse response,
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
            returnMap =staffService.queryAllStaff(requestMap);
            System.out.println("returnMap:"+returnMap);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }catch (Exception e){
            returnMap = ResponseConstant.getResponsecodeDesc(10005);
            outWriter.write(mapper.writeValueAsString(returnMap));
        }
        return;

    }












}
