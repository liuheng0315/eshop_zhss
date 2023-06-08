package com.zhss.eshop.common.util;

import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liu heng
 * @description : BeanCopierUtils工具类
 * @date : 2023-04-22 22:54
 **/
public class BeanCopierUtils {
    public static Map<String, BeanCopier> beanCopierCacheMap = new HashMap<>();

    /**
     * 将source对象的属性拷贝到target对象
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String cacheKey = source.getClass().toString() + target.getClass().toString();

        BeanCopier beanCopier;
        if (!beanCopierCacheMap.containsKey(cacheKey)) {
            synchronized (BeanCopierUtils.class) {
                if (!beanCopierCacheMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierCacheMap.put(cacheKey, beanCopier);
                }else {
                    beanCopier = beanCopierCacheMap.get(cacheKey);
                }
            }
        }else {
            beanCopier = beanCopierCacheMap.get(cacheKey);
        }

        beanCopier.copy(source, target, null);
    }
}
