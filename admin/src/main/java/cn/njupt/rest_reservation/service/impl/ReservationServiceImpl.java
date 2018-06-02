package cn.njupt.rest_reservation.service.impl;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.dao.CustomerMapper;
import cn.njupt.rest_reservation.dao.ReservationMapper;
import cn.njupt.rest_reservation.dao.TableMapper;
import cn.njupt.rest_reservation.enums.ReservationStatus;
import cn.njupt.rest_reservation.enums.TableStatus;
import cn.njupt.rest_reservation.model.Customer;
import cn.njupt.rest_reservation.model.Reservation;
import cn.njupt.rest_reservation.model.Table;
import cn.njupt.rest_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by zhangqiao on 2018/6/1.
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Map queryAllReservation(Map map) {
        Map returnMap = new HashMap();
        try{
            List<Reservation> reservations = reservationMapper.selectAllReservation(map);
            List<Map> list = new ArrayList<>();
            for (Reservation reservation:reservations) {
                String userName = "店小二";
                Customer customer = customerMapper.selectByPrimaryKey(reservation.getUserId());
                if(customer != null){
                    userName = customer.getName();
                }else {
                    returnMap.put(ParameterConstant.RETURN_MSG,"用户数据有误！");
                }
                Map map1 = new HashMap();
                map1.put("mealTime",reservation.getMealTime());
                map1.put("createTime",reservation.getCreateTime());
                map1.put("updateTime",reservation.getUpdateTime());
                map1.put("flag",reservation.getFlag());
                map1.put("id",reservation.getId());
                map1.put("status",reservation.getStatus());
                map1.put("remarks",reservation.getRemarks());
                map1.put("tableId",reservation.getTableId());
                map1.put("tablewareNumber",reservation.getTablewareNumber());
                map1.put("userName",userName);
                list.add(map1);
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


    /**调换餐桌
     1.修改当前预约的状态
     2.当前预约的备注信息为调换后的餐桌号
     3.修改原餐桌的状态为可用
     4.修改新餐桌的状态为不可用
     */
    @Override
    public Map transfer_reservation(Map map) {
        Map returnMap = new HashMap();
        try{
            Integer id = (Integer) map.get("id");
            String newTableId = String.valueOf(map.get("newTableId"));
            Reservation reservation = reservationMapper.selectByPrimaryKey(id);
            if(reservation != null){
                Integer tableId = reservation.getTableId();
                Integer reservationStatus = reservation.getStatus();
                String remark = reservation.getRemarks();

                if(!reservationStatus.equals(ReservationStatus.TRANSFER.getStatus())){
                    reservation.setStatus(ReservationStatus.TRANSFER.getStatus());
                }
                reservation.setUpdateTime(new Date());
                reservation.setRemarks(newTableId);
                reservationMapper.updateByPrimaryKey(reservation);

                if(remark != null && !remark.equals("")){
                    tableId = Integer.parseInt(remark);
                }
                Table table = tableMapper.selectByPrimaryKey(tableId);
                if(table != null){
                    table.setTableStatus(TableStatus.USABLE.getStatus());
                    table.setUpdatetime(new Date());

                    tableMapper.updateByPrimaryKey(table);
                }else {
                    returnMap.put(ParameterConstant.RETURN_MSG,"原餐桌不存在！");
                }
                Table newTable = tableMapper.selectByPrimaryKey(Integer.parseInt(newTableId));
                if (newTable != null){
                    if(newTable.getTableStatus().equals(TableStatus.USABLE.getStatus())){
                        newTable.setTableStatus(TableStatus.UNUSABLE.getStatus());
                        newTable.setUpdatetime(new Date());

                        tableMapper.updateByPrimaryKey(newTable);
                        returnMap.put(ParameterConstant.RETURN_CODE,0);
                        returnMap.put(ParameterConstant.RETURN_MSG,"调换成功！");
                    }else {
                        returnMap.put(ParameterConstant.RETURN_MSG,"所选新餐桌已被占用不可调换");
                    }
                }else {
                    returnMap.put(ParameterConstant.RETURN_MSG,"所选新餐桌不存在");
                }
            }
        }catch (Exception  e){
            e.printStackTrace();
        }
        return  returnMap;
    }

    @Override
    public Map cancel_reservation(Map map) {
        Map returnMap = new HashMap();
        try{
            Integer id = (Integer) map.get("id");
            Reservation reservation = reservationMapper.selectByPrimaryKey(id);
            if(reservation != null){
                Integer tableId = reservation.getTableId();
                reservation.setStatus(ReservationStatus.CANCEL.getStatus());
                reservation.setUpdateTime(new Date());

                reservationMapper.updateByPrimaryKey(reservation);
                Table table = tableMapper.selectByPrimaryKey(tableId);
                if(table != null){
                    table.setTableStatus(TableStatus.USABLE.getStatus());
                    table.setUpdatetime(new Date());

                    tableMapper.updateByPrimaryKey(table);
                    returnMap.put(ParameterConstant.RETURN_CODE,0);
                    returnMap.put(ParameterConstant.RETURN_MSG,"取消成功！");
                }else {
                    returnMap.put(ParameterConstant.RETURN_MSG,"该餐桌不存在！");
                }
            }else {
                returnMap.put(ParameterConstant.RETURN_MSG,"该预约不存在！");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  returnMap;
    }

    @Override
    public Map record_arrival(Map map) {
        Map returnMap = new HashMap();
        try{
            Integer id = (Integer) map.get("id");
            Reservation reservation = reservationMapper.selectByPrimaryKey(id);
            if(reservation != null){
                reservation.setStatus(ReservationStatus.ARRIVE.getStatus());
                reservation.setUpdateTime(new Date());
                reservationMapper.updateByPrimaryKey(reservation);
                returnMap.put(ParameterConstant.RETURN_CODE,0);
                returnMap.put(ParameterConstant.RETURN_MSG,"记录到达成功！");
            }else {
                returnMap.put(ParameterConstant.RETURN_MSG,"该预约不存在！");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }

    @Override
    public Map end_meal(Map map) {
        Map returnMap = new HashMap();
        try{
            Integer id = (Integer) map.get("id");
            Reservation reservation = reservationMapper.selectByPrimaryKey(id);
            if(reservation != null){
                reservation.setStatus(ReservationStatus.END_MEAL.getStatus());
                reservation.setUpdateTime(new Date());
                reservationMapper.updateByPrimaryKey(reservation);

                /*用餐结束要释放餐桌，若备注为空，则释放table_id字段对应的餐桌*/
                String remark = reservation.getRemarks();
                Integer tableId = reservation.getTableId();
                Integer theTabeId = 0;
                if(remark == null || remark.equals("")){
                    theTabeId = tableId;
                }else {
                    theTabeId = Integer.parseInt(remark);
                }
                Table table = tableMapper.selectByPrimaryKey(theTabeId);
                table.setTableStatus(0);
                table.setUpdatetime(new Date());
                tableMapper.updateByPrimaryKey(table);
                returnMap.put(ParameterConstant.RETURN_CODE,0);
                returnMap.put(ParameterConstant.RETURN_MSG,"修改状态成功！");
            }else {
                returnMap.put(ParameterConstant.RETURN_MSG,"该预约不存在！");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }


}
