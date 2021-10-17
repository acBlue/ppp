package ppp.core.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ppp.core.exception.BusinessException;
import ppp.core.util.LocalDateTimeUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Map;

/**
 * @author Administrator
 */
public class JacksonMapper {

    private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        // 设置输出时包含属性的风格
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_TIME_FORMATTER)));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_FORMATTER)));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.TIME_FORMATTER)));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_TIME_FORMATTER)));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_FORMATTER)));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.TIME_FORMATTER)));
        mapper.registerModule(javaTimeModule);
    }


    /**
     * Object可以是POJO，也可以是Collection或数组。
     */
    public static String toJson(Object object) {

        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            logger.error("JSON反序列化异常:{}", object, e);
            throw new BusinessException("JSON反序列化异常");
        }
    }

    /**
     * 反序列化POJO或简单Collection如List<?>.
     * <p>
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     * <p>
     * 如需反序列化复杂Collection如List<?>, 请使用fromJson(String, JavaType)
     *
     * @see #fromJson(String, JavaType)
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            logger.error("JSON反序列化异常: {}", jsonString, e);
            throw new BusinessException("JSON反序列化异常: " + jsonString);
        }
    }

    /**
     * 反序列化复杂Collection如List<?>, 先使用createCollectionType()或contructMapType()构造类型, 然后调用本函数.
     */
    public static <T> T fromJson(String jsonString, JavaType javaType) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return (T) mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            logger.error("JSON反序列化异常: {}", jsonString, e);
            throw new BusinessException("JSON反序列化异常: " + jsonString);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> T fromJson(String jsonString, TypeReference type) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return (T) mapper.readValue(jsonString, type);
        } catch (IOException e) {
            logger.error("JSON反序列化异常:{}", jsonString, e);
            throw new BusinessException("JSON反序列化异常: " + jsonString);
        }
    }

    /**
     * 构造Collection类型.
     */
    public static JavaType contructCollectionType(Class<? extends Collection> collectionClass,
                                                  Class<?> elementClass) {
        return mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    /**
     * 构造Map类型.
     */
    public static JavaType contructMapType(Class<? extends Map> mapClass, Class<?> keyClass,
                                           Class<?> valueClass) {
        return mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }

    /**
     * 當JSON裡只含有Bean的部分屬性時，更新一個已存在Bean，只覆蓋該部分的屬性.
     */
    public static <T> T update(String jsonString, T object) {
        try {
            return mapper.readerForUpdating(object).readValue(jsonString);
        } catch (IOException e) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
            throw new BusinessException("JSON反序列化异常: " + jsonString);
        }
    }

    /**
     * 輸出JSONP格式數據.
     */
    public static String toJsonP(String functionName, Object object) {
        return toJson(new JSONPObject(functionName, object));
    }

    /**
     * 設定是否使用Enum的toString函數來讀寫Enum, 為False時時使用Enum的name()函數來讀寫Enum, 默認為False. 注意本函數一定要在Mapper創建後,
     * 所有的讀寫動作之前調用.
     */
    public void enableEnumUseToString() {
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    }

    /**
     * 取出Mapper做进一步的设置或使用其他序列化API.
     */
    public static ObjectMapper getMapper() {
        return mapper;
    }
}
