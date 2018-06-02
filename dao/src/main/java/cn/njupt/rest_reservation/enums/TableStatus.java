package cn.njupt.rest_reservation.enums;

/**
 * Created by zhangqiao on 2018/6/2.
 */
public enum TableStatus {
    USABLE(0,"可用"),
    UNUSABLE(1,"不可用");

    private Integer status;
    private String status_name;

    TableStatus(Integer status,String status_name){
        this.status = status;
        this.status_name = status_name;
    }

    public Integer getStatus(){
        return status;
    }
    public String getStatus_name(){
        return status_name;
    }

}
