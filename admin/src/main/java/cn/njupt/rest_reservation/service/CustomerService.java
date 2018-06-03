package cn.njupt.rest_reservation.service;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangqiao on 2018/6/1.
 */
@Component
public interface CustomerService {
    Map queryAllCustomer(Map map);

    Map login(String account,String password);
}
