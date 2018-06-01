package cn.njupt.rest_reservation.controller;

/**
 * Created by zhangqiao on 2018/5/25.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping(value = "login.html")
    public ModelAndView login()throws Exception{
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value = "index.html")
    public ModelAndView index()throws Exception{
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "customer_list.html")
    public ModelAndView customer_list()throws Exception{
        ModelAndView modelAndView = new ModelAndView("customer_list");
        return modelAndView;
    }

    @RequestMapping(value = "staff_list.html")
    public ModelAndView staff_list()throws Exception{
        ModelAndView modelAndView = new ModelAndView("staff_list");
        return modelAndView;
    }

    @RequestMapping(value = "table_list.html")
    public ModelAndView table_list()throws Exception{
        ModelAndView modelAndView = new ModelAndView("table_list");
        return modelAndView;
    }

    @RequestMapping(value = "reservation_list.html")
    public ModelAndView reservation_list()throws Exception{
        ModelAndView modelAndView = new ModelAndView("reservation_list");
        return modelAndView;
    }

}
