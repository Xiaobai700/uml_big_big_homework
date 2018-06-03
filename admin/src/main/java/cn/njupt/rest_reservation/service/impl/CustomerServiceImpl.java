package cn.njupt.rest_reservation.service.impl;

import cn.njupt.rest_reservation.constant.ParameterConstant;
import cn.njupt.rest_reservation.constant.ResponseConstant;
import cn.njupt.rest_reservation.dao.CustomerMapper;
import cn.njupt.rest_reservation.model.Customer;
import cn.njupt.rest_reservation.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Map queryAllCustomer(Map map) {
        Map returnMap = new HashMap();
        try{
            List<Customer> customers = customerMapper.selectAllCustomer(map);
            List<Customer> list = new ArrayList<>();
            for (Customer customer:customers) {
                list.add(customer);
            }

            returnMap = ResponseConstant.getResponsecodeDesc(0);
            returnMap.put(ParameterConstant.RETURN_DATA,list);
            map.remove(ParameterConstant.INDEX);
            map.remove(ParameterConstant.LENGTH);
            returnMap.put(ParameterConstant.DATA_ITOTALDISPLAYRECORDS,customerMapper.selectAllCustomer(map).size());
            returnMap.put(ParameterConstant.DATA_ITOTALRECORDS,customerMapper.selectAllCustomer(map).size());
            return returnMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }

    @Override
    public Map login(String account,String password) {
        Map returnMap = new HashMap();
        try{
            Customer customer = new Customer();
            customer.setPhone(account);
            customer.setPassword(password);
            customer = customerMapper.selectCustomer(customer);
            returnMap.put("customer",customer);
            returnMap.put(ParameterConstant.RETURN_CODE,0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  returnMap;
    }
}
