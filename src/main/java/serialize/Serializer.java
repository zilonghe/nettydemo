package serialize;

import serialize.impl.JSONSerializer;

/**
 * @author hezilong
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法类型
     * @return 序列化算法类型
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     * @param obj java对象
     * @return 二进制
     */
    byte[] serialize(Object obj);

    /**
     * 二进制转换成java 对象
     * @param clazz 需要转换成的java对象类
     * @param bytes 被转换的二进制
     * @param <T> 泛型
     * @return java对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
