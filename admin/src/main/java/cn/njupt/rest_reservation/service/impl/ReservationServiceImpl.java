package cn.njupt.rest_reservation.service.impl;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.dao.ReservationMapper;
import cn.njupt.rest_reservation.model.Reservation;
import cn.njupt.rest_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangqiao on 2018/6/1.
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public Map queryAllReservation(Map map) {
        Map returnMap = new HashMap();
        try{
            List<Reservation> reservations = reservationMapper.selectAllReservation(map);
            List<Reservation> list = new ArrayList<>();
            for (Reservation reservation:reservations) {
                list.add(reservation);
            }

            returnMap = ResponseConstant.getResponsecodeDesc(0);
            returnMap.put(ParameterConstant.RETURN_DATA,list);
            map.remove(ParameterConstant.INDEX);
            map.remove(ParameterConstant.LENGTH);
            returnMap.put(ParameterConstant.DATA_ITOTALDISPLAYRECORDS,reservationMapper.selectAllReservation(map).size());
            returnMap.put(ParameterConstant.DATA_ITOTALRECORDS,reservationMapper.selectAllReservation(map).size());
            return returnMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }
}
