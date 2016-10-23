package com.sxau.pblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxau.pblog.utils.ConstantUtil;
import com.sxau.pblog.utils.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Date;

/**
 * Created by gaohailong on 2016/10/8.
 */
public class BaseController {

    /**
     * 将String转换为json
     *
     * @param message
     * @return
     * @throws JsonProcessingException
     */
    public String responseStringToJson(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return message = mapper.writeValueAsString(message);
    }

    /**
     * CUD所用的JSON
     *
     * @param num
     * @return
     * @throws JsonProcessingException
     */
    public String responseStringToJsonForCUD(int num, int type) throws JsonProcessingException {
        String message = "发生错误";
        if (num != 0) {
            if (type == 0) {
                message = "添加成功";
            } else if (type == 1) {
                message = "删除成功";
            }
        } else {
            message = "添加失败";
        }
        ObjectMapper mapper = new ObjectMapper();
        return message = mapper.writeValueAsString(message);
    }


    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    /**
     * 返回服务端处理结果
     *
     * @param obj 服务端输出对象
     * @return 输出处理结果给前段JSON格式数据
     * @author YANGHONGXIA
     * @since 2015-01-06
     */
    public String responseResult(Object obj) {
        JSONObject jsonObj = null;
        if (obj != null) {
//            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonObj = JSONObject.fromObject(obj, jsonConfig);
//            logger.info("后端返回数据：" + jsonObj);
            if (ConstantUtil.SERVICE_RESPONSE_SUCCESS_CODE.equals(jsonObj.getString(ConstantUtil.SERVICE_RESPONSE_RESULT_FLAG))) {
                jsonObj.element(ConstantUtil.RESPONSE_RESULT_FLAG_ISERROR, false);
                jsonObj.element(ConstantUtil.SERVICE_RESPONSE_RESULT_MSG, "");
            } else {
                jsonObj.element(ConstantUtil.RESPONSE_RESULT_FLAG_ISERROR, true);
                String errMsg = jsonObj.getString(ConstantUtil.SERVICE_RESPONSE_RESULT_MSG);
                jsonObj.element(ConstantUtil.SERVICE_RESPONSE_RESULT_MSG, errMsg == null ? ConstantUtil.SERVICE_RESPONSE_NULL : errMsg);
            }
        }
//        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回成功
     *
     * @param obj 输出对象
     * @return 输出成功的JSON格式数据
     */
    public String responseSuccess(Object obj) {
        JSONObject jsonObj = null;
        if (obj != null) {
//            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonObj = JSONObject.fromObject(obj, jsonConfig);
//            logger.info("后端返回数据：" + jsonObj);
            jsonObj.element(ConstantUtil.RESPONSE_RESULT_FLAG_ISERROR, false);
            jsonObj.element(ConstantUtil.SERVICE_RESPONSE_RESULT_MSG, "");
        }
//        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回成功
     *
     * @param obj 输出对象
     * @return 输出成功的JSON格式数据
     */
    public String responseArraySuccess(Object obj) {
        JSONArray jsonObj = null;
        if (obj != null) {
//            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonObj = JSONArray.fromObject(obj, jsonConfig);
//            logger.info("后端返回数据：" + jsonObj);
        }
//        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回成功
     *
     * @param obj 输出对象
     * @return 输出成功的JSON格式数据
     */
    public String responseSuccess(Object obj, String msg) {
        JSONObject jsonObj = null;
        if (obj != null) {
//            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonObj = JSONObject.fromObject(obj, jsonConfig);
//            logger.info("后端返回数据：" + jsonObj);
            jsonObj.element(ConstantUtil.RESPONSE_RESULT_FLAG_ISERROR, false);
            jsonObj.element(ConstantUtil.SERVICE_RESPONSE_RESULT_MSG, msg);
        }
//        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回失败
     *
     * @param errorMsg 错误信息
     * @return 输出失败的JSON格式数据
     */
    public String responseFail(String errorMsg) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(ConstantUtil.RESPONSE_RESULT_FLAG_ISERROR, true);
        jsonObj.put(ConstantUtil.SERVICE_RESPONSE_RESULT_MSG, errorMsg);
//        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

}
