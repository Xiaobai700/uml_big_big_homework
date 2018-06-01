package cn.njupt.rest_reservation.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thy_niit on 2016/9/18.
 */
public class ResponseConstant {
    public final static Map getResponsecodeDesc(Integer requestCode) {
        Map returnMap = new HashMap();
        returnMap.put(ParameterConstant.RETURN_CODE, requestCode);
        switch (requestCode) {
            case -1:
                returnMap.put(ParameterConstant.RETURN_MSG, "获取用户权限失败!");
                break;
            case 0:
                returnMap.put(ParameterConstant.RETURN_MSG,"返回成功");
                break;
            case 10001:
                returnMap.put(ParameterConstant.RETURN_MSG,"'CommonController.uploadFile'抛出异常");
                break;
            case 10002:
                returnMap.put(ParameterConstant.RETURN_MSG,"'EditionService.getNewEdition'抛出异常");
                break;
            case 10003:
                returnMap.put(ParameterConstant.RETURN_MSG,"'CommonController.checkUpdate'抛出异常");
                break;
            case 10004:
                returnMap.put(ParameterConstant.RETURN_MSG,"'AdminService.getAdminListByPage'抛出异常");
                break;
            case 10005:
                returnMap.put(ParameterConstant.RETURN_MSG,"'AdminController.asminListDo'抛出异常");
                break;
            case 10006:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserService.registerUser'抛出异常");
                break;
            case 10007:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserController.register'抛出异常");
                break;
            case 10008:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserController.login'抛出异常");
                break;
            case 10009:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserService.loginUser'抛出异常");
                break;
            case 10010:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserController.thirdLogin'抛出异常");
                break;
            case 10011:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserService.thirdLogin'抛出异常");
                break;
            case 10012:
                returnMap.put(ParameterConstant.RETURN_MSG,"'CodeService.sendCode'抛出异常");
                break;
            case 10013:
                returnMap.put(ParameterConstant.RETURN_MSG,"'ModelController.modelList'抛出异常");
                break;
            case 10014:
                returnMap.put(ParameterConstant.RETURN_MSG,"'ModelService.getModelListByPage'抛出异常");
                break;
            case 10015:
                returnMap.put(ParameterConstant.RETURN_MSG,"'ModelController.modelAddDo'抛出异常");
                break;
            case 10016:
                returnMap.put(ParameterConstant.RETURN_MSG,"'ModelService.addModel'抛出异常");
                break;
            case 10017:
                returnMap.put(ParameterConstant.RETURN_MSG,"'ManageController.uploadFile'抛出异常");
                break;
            case 10018:
                returnMap.put(ParameterConstant.RETURN_MSG,"'ModelController.modelDelDo'抛出异常");
                break;
            case 10019:
                returnMap.put(ParameterConstant.RETURN_MSG,"'ModelService.delModel'抛出异常");
                break;
            case 10020:
                returnMap.put(ParameterConstant.RETURN_MSG,"'NewsManagerController.newsListDo'抛出异常");
                break;
            case 10021:
                returnMap.put(ParameterConstant.RETURN_MSG,"'NewsService.getNewList'抛出异常");
                break;
            case 10022:
                returnMap.put(ParameterConstant.RETURN_MSG,"'NewsManagerController.newsAddDo'抛出异常");
                break;
            case 10023:
                returnMap.put(ParameterConstant.RETURN_MSG,"'VideoManageController.VideoListDo'抛出异常");
                break;
            case 10024:
                returnMap.put(ParameterConstant.RETURN_MSG,"'VideoService.getVideos'抛出异常");
                break;
            case 10025:
                returnMap.put(ParameterConstant.RETURN_MSG,"'VideoManageController.videoAddDo'抛出异常");
                break;
            case 10026:
                returnMap.put(ParameterConstant.RETURN_MSG,"'VideoService.addVideo'抛出异常");
                break;
            case 10027:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserService.getUserByPage'抛出异常");
                break;
            case 10028:
                returnMap.put(ParameterConstant.RETURN_MSG,"'UserManageController.userListDo'抛出异常");
                break;
            default:
                break;
        }
        return returnMap;
    }

    public final static Map getOneResponseMsg(String msg){
        Map returnMap = new HashMap();
        returnMap.put("code",1);
        returnMap.put("msg",msg);
        return returnMap;
    }
}
