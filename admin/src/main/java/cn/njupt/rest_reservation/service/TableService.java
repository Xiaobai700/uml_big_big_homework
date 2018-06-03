package cn.njupt.rest_reservation.service;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangqiao on 2018/5/25.
 */
@Component
public interface TableService {
    Map queryAllTable(Map map);

    Map selectChooseTable(Map map);
}
