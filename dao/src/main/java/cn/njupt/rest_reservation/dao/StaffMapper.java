package cn.njupt.rest_reservation.dao;

import cn.njupt.rest_reservation.model.Staff;

import java.util.List;
import java.util.Map;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    Staff selectStaff(Staff staff);

    List<Staff> selectAllStaff(Map map);
}