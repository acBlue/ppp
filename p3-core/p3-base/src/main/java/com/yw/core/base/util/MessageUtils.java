package com.yw.core.base.util;


import com.yw.core.base.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.Locale;

@Slf4j
@Component
public class MessageUtils {

    @Value("${retail.i18n.message.enable:false}")
    private boolean messageEnable;

    private static MessageSourceAccessor accessor;

    private static MessageUtils messageUtils;

    private MessageSource messageSource;

    @PostConstruct
    public void init() {
        accessor = new MessageSourceAccessor(messageSource);
        messageUtils = this;
        if (messageEnable) {
            log.info("消息国际化已开启");
        } else {
            log.warn("消息国际化未开启，要开启请配置属性：retail.i18n.message.enable=true");
        }
    }

    public static String getMessage(ResultEnum<Integer> code) {
        return getMessage(code.toString(), code.getDesc());
    }


    public static String getMessage(ResultEnum<Integer> code, String defaultMessage) {
        return getMessage(code.toString(), defaultMessage);
    }

    public static String getMessage(ResultEnum<Integer> code, Object[] args, String defaultMessage, Locale locale) {
        return getMessage(code.getCode().toString(), args, defaultMessage, locale);
    }

    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return getMessageSourceAccessor().getMessage(code, args, defaultMessage, locale);
    }

    public static String getMessage(ResultEnum<Integer> code, Object[] args) {
        return getMessage(code.toString(), args, code.getDesc());
    }

    public static String getMessage(ResultEnum<Integer> code, Object[] args, String defaultMessage) {
        return getMessage(code.toString(), args, defaultMessage);
    }

    public static String getMessage(String code) {
        return getMessageSourceAccessor().getMessage(code, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String code, String defaultMessage) {
        if (isEnable()) {
            return getMessageSourceAccessor().getMessage(code, defaultMessage, LocaleContextHolder.getLocale());
        }
        return defaultMessage;
    }

    /**
     * 根据当前请求区域的获取消息
     *
     * @param code 消息编码
     * @param args 消息模板参数
     */
    public static String getMessage(String code, Object[] args) {
        return getMessageSourceAccessor().getMessage(code, args, LocaleContextHolder.getLocale());
    }


    public static String getMessage(String code, Object[] args, String defaultMessage) {
        if (isEnable()) {
            return getMessageSourceAccessor().getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
        }
        return defaultMessage;
    }

    public static boolean isEnable() {
        return messageUtils != null && messageUtils.messageEnable && accessor != null;
    }

    private static MessageSourceAccessor getMessageSourceAccessor() {
        if (isEnable()) {
            return accessor;
        } else {
            throw new RuntimeException("未启用消息国际化处理，开启属性:{retail.i18n.message.enable=true}");
        }
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
