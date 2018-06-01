package cn.njupt.rest_reservation.dao;

import cn.njupt.rest_reservation.model.Reservation;

import java.util.List;
import java.util.Map;

public interface ReservationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    Reservation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);

    List<Reservation> selectAllReservation(Map map);
}