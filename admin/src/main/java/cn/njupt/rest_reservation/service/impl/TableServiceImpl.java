package cn.njupt.rest_reservation.service.impl;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.dao.ReservationMapper;
import cn.njupt.rest_reservation.dao.TableMapper;
import cn.njupt.rest_reservation.model.Reservation;
import cn.njupt.rest_reservation.model.Table;
import cn.njupt.rest_reservation.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public Map queryAllTable(Map map) {
        Map returnMap = new HashMap();
        try{
            List<Table> tables = tableMapper.selectAllTable(map);
            List<Map> list = new ArrayList<>();
            for (Table table:tables) {
                String detailTime = "";
                Map map1 = new HashMap();
                map1.put("tableNo",table.getTableNo());
                map1.put("id",table.getId());
                map1.put("seatsNumber",table.getSeatsNumber());
                map1.put("tableStatus",table.getTableStatus());
                map1.put("updateTime",table.getUpdatetime());
                if(table.getTableStatus()>0){
                    //找到预约详情
                    Map requestMap = new HashMap();
                    requestMap.put("tableId",table.getId());
                    requestMap.put("trans",2);
                    List<Reservation> reservationList = reservationMapper.selectAllReservation(requestMap);
                    if(reservationList.size()>0){
                        for (Reservation re:reservationList) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String mealTime = sdf.format(re.getMealTime());
                            detailTime += mealTime+"顾客"+re.getTablewareNumber()+"人"+"\n";
                        }
                    }else{
                        returnMap.put(ParameterConstant.RETURN_MSG,"数据异常！");
                    }

                }
                map1.put("detailTime",detailTime);
                list.add(map1);
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

    @Override
    public Map selectChooseTable(Map map) {
        Map returnMap = new HashMap();
        try{
            List<Table> tables = tableMapper.selectChoose(map);
            List<Map> list = new ArrayList<>();
            for (Table table:tables) {
                String detailTime = "";
                Map map1 = new HashMap();
                map1.put("tableNo",table.getTableNo());
                map1.put("id",table.getId());
                map1.put("seatsNumber",table.getSeatsNumber());
                map1.put("tableStatus",table.getTableStatus());
                if(table.getTableStatus()>0){
                    //找到预约详情
                    Map requestMap = new HashMap();
                    requestMap.put("tableId",table.getId());
                    requestMap.put("trans",2);
                    List<Reservation> reservationList = reservationMapper.selectAllReservation(requestMap);
                    if(reservationList.size()>0){
                        for (Reservation re:reservationList) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String mealTime = sdf.format(re.getMealTime());
                            detailTime += mealTime+"顾客"+re.getTablewareNumber()+"人"+"\n";
                        }
                    }else{
                        returnMap.put(ParameterConstant.RETURN_MSG,"数据有异常！");
                    }

                }
                map1.put("detailTime",detailTime);
                list.add(map1);
            }

            returnMap = ResponseConstant.getResponsecodeDesc(0);
            returnMap.put(ParameterConstant.RETURN_DATA,list);
            map.remove(ParameterConstant.INDEX);
            map.remove(ParameterConstant.LENGTH);
            returnMap.put(ParameterConstant.DATA_ITOTALDISPLAYRECORDS,tableMapper.selectChoose(map).size());
            returnMap.put(ParameterConstant.DATA_ITOTALRECORDS,tableMapper.selectChoose(map).size());
            return returnMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }
}
