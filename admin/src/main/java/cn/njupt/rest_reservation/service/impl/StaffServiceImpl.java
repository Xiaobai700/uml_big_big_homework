package cn.njupt.rest_reservation.service.impl;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.dao.StaffMapper;
import cn.njupt.rest_reservation.model.Staff;
import cn.njupt.rest_reservation.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangqiao on 2018/5/31.
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Map login(String account, String password) {
        Map returnMap = new HashMap();
        try{
            Staff staff = new Staff();
            staff.setJobNumber(account);
            staff.setPassword(password);
            staff = staffMapper.selectStaff(staff);
            returnMap.put("staff",staff);
            returnMap.put(ParameterConstant.RETURN_CODE,0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  returnMap;
    }


    @Override
    public Map queryAllStaff(Map map) {
        Map returnMap = new HashMap();
        try{
            List<Staff> staffs = staffMapper.selectAllStaff(map);
            List<Staff> list = new ArrayList<>();
            for (Staff staff:staffs) {
                list.add(staff);
            }

            returnMap = ResponseConstant.getResponsecodeDesc(0);
            returnMap.put(ParameterConstant.RETURN_DATA,list);
            map.remove(ParameterConstant.INDEX);
            map.remove(ParameterConstant.LENGTH);
            returnMap.put(ParameterConstant.DATA_ITOTALDISPLAYRECORDS,staffMapper.selectAllStaff(map).size());
            returnMap.put(ParameterConstant.DATA_ITOTALRECORDS,staffMapper.selectAllStaff(map).size());
            return returnMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }


}
