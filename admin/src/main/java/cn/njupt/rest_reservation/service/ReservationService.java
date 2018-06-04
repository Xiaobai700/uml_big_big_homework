package cn.njupt.rest_reservation.service;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangqiao on 2018/6/1.
 */
@Component
public interface ReservationService {
    Map queryAllReservation(Map map);

    Map transfer_reservation(Map map);

    Map cancel_reservation(Map map);

    Map record_arrival(Map map);

    Map end_meal(Map map);

    Map addReservation(Map map);
}
