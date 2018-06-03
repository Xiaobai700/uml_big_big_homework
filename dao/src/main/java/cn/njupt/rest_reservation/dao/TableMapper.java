package cn.njupt.rest_reservation.dao;

import cn.njupt.rest_reservation.model.Table;

import java.util.List;
import java.util.Map;

public interface TableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Table record);

    int insertSelective(Table record);

    Table selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Table record);

    int updateByPrimaryKey(Table record);

    List<Table> selectAllTable(Map map);

    List<Table> selectChoose(Map map);
}