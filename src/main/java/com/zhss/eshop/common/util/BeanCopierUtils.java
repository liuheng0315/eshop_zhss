package com.zhss.eshop.common.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuheng
 */
public class BeanCopierUtils {
    public static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

    /**
     * 将source对象拷贝到target
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object source, Object target) {
        String cacheKey = source.getClass().toString() + target.getClass().toString();

        BeanCopier beanCopier = null;
        if (!beanCopierMap.containsKey(cacheKey)) {
            synchronized (BeanCopierUtils.class) {
                if (!beanCopierMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierMap.put(cacheKey, beanCopier);
                }
            }
        }else {
            beanCopier = beanCopierMap.get(cacheKey);
        }
        beanCopier.copy(source, target, null);
    }
}
