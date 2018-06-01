package cn.njupt.rest_reservation.service.impl;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.dao.TableMapper;
import cn.njupt.rest_reservation.model.Table;
import cn.njupt.rest_reservation.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangqiao on 2018/5/25.
 */
@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private TableMapper tableMapper;

    @Override
    public Map queryAllTable(Map map) {
        Map returnMap = new HashMap();
        try{
            List<Table> tables = tableMapper.selectAllTable(map);
            List<Table> list = new ArrayList<>();
            for (Table table:tables) {
                list.add(table);
            }

            returnMap = ResponseConstant.getResponsecodeDesc(0);
            returnMap.put(ParameterConstant.RETURN_DATA,list);
            map.remove(ParameterConstant.INDEX);
            map.remove(ParameterConstant.LENGTH);
            returnMap.put(ParameterConstant.DATA_ITOTALDISPLAYRECORDS,tableMapper.selectAllTable(map).size());
            returnMap.put(ParameterConstant.DATA_ITOTALRECORDS,tableMapper.selectAllTable(map).size());
            return returnMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }
}
