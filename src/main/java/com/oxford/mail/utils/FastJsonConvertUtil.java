package com.oxford.mail.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * Json转换工具类
 *
 * @author Chova
 * @date 2020/02/27
 */
public class FastJsonConvertUtil {
    public static final SerializerFeature[] FEATURESWITHNULLVALUE = {SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty};

    /**
     * 将JSON字符串转化为对象
     *
     * @param data  JSON字符串
     * @param clazz 从JSON字符串转化的类对象
     * @return T 从JSON字符串转化对象
     */
    public static <T> T convertJsonToObject(String data, Class<T> clazz) {
        try {
            T t = JSON.parseObject(data, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSON对象转化为Java对象
     *
     * @param data  JSON对象
     * @param clazz 从JSON对象转化的类对象
     * @return T 从JSON对象转化的Java对象
     */
    public static <T> T convertJsonToObject(JSONObject data, Class<T> clazz) {
        try {
            T t = JSONObject.toJavaObject(data, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSON字符串转化为List
     *
     * @param data  JSON字符串
     * @param clazz 从JSON字符串转化的类对象
     * @return List<T> 从JSON字符串转化的List
     */
    public static <T> List<T> convertJsonToArray(String data, Class<T> clazz) {
        try {
            List<T> t = JSON.parseArray(data, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSON集合转化为数组
     *
     * @param data  JSON集合
     * @param clazz 从JSON字符串转化的类对象
     * @return List<T> 从JSON字符串转化的数组集合List
     */
    public static <T> List<T> convertJsonToArray(List<JSONObject> data, Class<T> clazz) {
        try {
            List<T> t = new ArrayList<>();
            for (JSONObject jsonObject : data) {
                t.add(convertJsonToObject(jsonObject, clazz));
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转化为JSON字符串
     *
     * @param obj 需要转化为JSON字符串的对象
     * @return String 从对象转化的JSON字符串
     */
    public static String convertObjectToJson(Object obj) {
        try {
            String text = JSON.toJSONString(obj);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转化为JSON对象
     *
     * @param obj 需要转化为JSON对象的对象
     * @return JSONObject 从对象转化的JSON对象
     */
    public static JSONObject converObjectToJsonObject(Object obj) {
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转化为JSON字符串并过滤掉空元素
     *
     * @param obj 需要转化为JSON字符串并过滤掉空元素的对象
     * @return String 从对象转化的JSON字符串并过滤掉空元素
     */
    public static String convertObjectToJsonWithNullValue(Object obj) {
        try {
            String text = JSONObject.toJSONString(obj, FEATURESWITHNULLVALUE);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
