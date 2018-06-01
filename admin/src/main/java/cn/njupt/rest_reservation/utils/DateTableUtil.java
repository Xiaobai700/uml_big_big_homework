package cn.njupt.rest_reservation.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class DateTableUtil {
    public static Map getDateTableRequestDate(String aoData){
        Map requestMap = new HashMap();
        JSONArray jsonArray = JSONArray.fromObject(aoData);
        for (int i = 0; i < jsonArray.size(); i++)
        {
            try
            {
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                if (jsonObject.get("name").equals("sEcho"))
                    requestMap.put("sEcho", jsonObject.get("value").toString());
                else if (jsonObject.get("name").equals("iDisplayStart"))
                    requestMap.put("index", Integer.valueOf(jsonObject.get("value").toString()));
                else if (jsonObject.get("name").equals("iDisplayLength"))
                    requestMap.put("size", Integer.valueOf(jsonObject.get("value").toString()));
                else if (jsonObject.get("name").equals("sSearch"))
                    requestMap.put("keys", jsonObject.get("value").toString());
                else if (jsonObject.get("name").equals("sStora"))
                    requestMap.put("sortId", jsonObject.get("value").toString());
                else if (jsonObject.get("name").equals("sortId")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("sortId", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("CityName")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("CityName", jsonObject.get("value").toString());
                    }
                }


                else if (jsonObject.get("name").equals("SearchNames")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("SearchNames", jsonObject.get("value").toString());
                    }

                }

                else if (jsonObject.get("name").equals("startTime")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("startTime", jsonObject.get("value").toString());
                    }

                }
                else if (jsonObject.get("name").equals("eventType")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("eventType", jsonObject.get("value").toString());
                    }

                }



                else if (jsonObject.get("name").equals("endTime")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("endTime", jsonObject.get("value").toString());
                    }

                }


                else if (jsonObject.get("name").equals("modelId")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("modelId", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("typeId")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("typeId", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("identity")) {
                    if (!jsonObject.get("value").toString().equals("-1")) {
                        requestMap.put("identity", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("industry")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("industry", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("resultId")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("resultId", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("typeId")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("typeId", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("enterpriseId")) {
                    if (!jsonObject.get("value").toString().equals("0")) {
                        requestMap.put("enterpriseId", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("isChecked")) {
                    if (!jsonObject.get("value").toString().equals("-1")&&!jsonObject.get("value").toString().equals("")) {
                        requestMap.put("isChecked", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("phone")) {
                    if (!jsonObject.get("value").toString().equals("-1")&&!jsonObject.get("value").toString().equals("")) {
                        requestMap.put("phone", jsonObject.get("value").toString());
                    }
                }
                else if (jsonObject.get("name").equals("delFlag")) {
                    if (!jsonObject.get("value").toString().equals("-1")&&!jsonObject.get("value").toString().equals("")) {
                        requestMap.put("delFlag", jsonObject.get("value").toString());
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                break;
            }
        }
        return requestMap;
    }
}
