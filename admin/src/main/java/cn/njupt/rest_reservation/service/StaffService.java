package cn.njupt.rest_reservation.service;

import java.util.Map;

/**
 * Created by zhangqiao on 2018/5/31.
 */
public interface StaffService {
    /*登录*/
    Map login(String account,String password);


    Map queryAllStaff(Map map);
}
