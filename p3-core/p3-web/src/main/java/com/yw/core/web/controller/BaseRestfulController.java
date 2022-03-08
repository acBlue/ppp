package com.yw.core.web.controller;

import com.yw.core.base.constant.HeaderConstant;
import com.yw.core.base.enums.ResultCode;
import com.yw.core.base.enums.ResultEnum;
import com.yw.core.base.exception.BusinessException;
import com.yw.core.base.model.HeaderInfo;
import com.yw.core.base.model.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
public abstract class BaseRestfulController extends BaseGeneralController{

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    /**
     * 返回数据封装
     *
     * @param data 消息内容
     * @param result 消息code
     * @return Map
     * @author guocp
     * @date 2017年3月22日
     */
    protected <T> ResponseData<T> resultData(T data, ResultEnum<Integer> result) {
        return ResponseData.builder(data, result);
    }

    /**
     * 返回成功数据
     *
     * @param data 消息内容
     * @date 2017年3月22日
     */
    protected <T> ResponseData<T> successData(T data) {
        return ResponseData.builder(data, ResultCode.SUCCESS);
    }
    /**
     * 返回成功
     *
     * @date 2017年3月22日
     */
    protected <T> ResponseData<T> success() {
        return ResponseData.builder(ResultCode.SUCCESS);
    }
    /**
     * 返回错误
     *
     * @date 2017年3月22日
     */
    protected <T> ResponseData<T> fail(ResultEnum<Integer> result) {
        return ResponseData.builder(result);
    }


    /**
     * @Description: 获取请求header公共参数
     * @author guocp
     * @date 2018年4月24日
     */
    protected HeaderInfo getHeaderInfo(HttpServletRequest request) {
        HeaderInfo headerInfo = new HeaderInfo();
        headerInfo.setClientId(request.getHeader(HeaderConstant.CLIENT_ID));
        headerInfo.setClientType(request.getHeader(HeaderConstant.CLIENT_TYPE));
        headerInfo.setClientAgent(request.getHeader(HeaderConstant.CLIENT_AGENT));
        headerInfo.setVersion(request.getHeader(HeaderConstant.VERSION));
        headerInfo.setScreen(request.getHeader(HeaderConstant.SCREEN));
        headerInfo.setSign(request.getHeader(HeaderConstant.SIGN));
        String channelId = request.getHeader(HeaderConstant.CHANNEL_ID);
        // 设置channelId
        if (StringUtils.isNotBlank(channelId)) {
            if (!StringUtils.isNumeric(channelId)) {
                throw new BusinessException(ResultCode.CHANNEL_ID_ERROR);
            }
            headerInfo.setChannelId(Long.parseLong(channelId));
        }
        return headerInfo;
    }



    /**
     * @Description: 获取请求header公共参数
     * @author wanghong
     * @date 2018年4月24日
     */
    protected HeaderInfo getHeaderInfo() {
        return getHeaderInfo(request);
    }


    /**
     * 获取请求渠道ID,
     * @return 返回请求渠道ID
     */
    protected Long getRequestChannelId() {
        String channelId = request.getHeader(HeaderConstant.CHANNEL_ID);
        if (StringUtils.isNotBlank(channelId)) {
            if (!StringUtils.isNumeric(channelId)) {
                throw new BusinessException(ResultCode.CHANNEL_ID_ERROR);
            }
            return Long.valueOf(channelId);
        }
        return null;
    }



    /**
     * @param name 自定义参数key
     * @Description: 获取请求header自定义参数
     * @author wanghong
     */
    protected String getHeaderValue(String name) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return request.getHeader(name);
    }
}
