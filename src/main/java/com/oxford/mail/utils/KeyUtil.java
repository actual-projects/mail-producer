package com.oxford.mail.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * 生成键值的工具类
 *
 * @author Chova
 * @date 2020-02-27
 */
public class KeyUtil {


    /**
     * 使用基于时间的生成器生成UUID
     *
     * @return String 基于时间生成器生成的UUID
     */
    public static String generateUuid() {
        TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        return timeBasedGenerator.generate().toString();
    }
}
