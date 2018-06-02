package cn.njupt.rest_reservation.enums;

/**
 * Created by zhangqiao on 2018/6/2.
 */
public enum ReservationStatus {
    CANCEL(-1,"取消"),
    NOT_ARRIVE(0,"客人还未到"),
    ARRIVE(1,"客人到达"),
    TRANSFER(2,"调换餐桌"),
    END_MEAL(3,"用餐结束");
    private Integer status;
    private String status_name;

    ReservationStatus(Integer type, String status_name){
        this.status = type;
        this.status_name = status_name;
    }

    public Integer getStatus(){
        return status;
    }
    public String getStatus_name(){
        return status_name;
    }

}
