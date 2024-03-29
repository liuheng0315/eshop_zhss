package com.zhss.eshop.common.util;

import java.util.Date;

/**
 * @author : liu heng
 * @description :日期辅助组件接口
 * @date : 2023-06-09 00:06
 **/
public interface DateProvider {
    /**
     * 获取当前时间
     * @return 当前时间
     * @throws Exception
     */
    Date getCurrentTime() throws Exception;

    /**
     * 将Date对象格式化成：yyyy-MM-dd HH:mm:ss
     * @param date Date对象
     * @return 格式化日期字符串
     * @throws Exception
     */
    String formatDatetime(Date date) throws Exception;

    /**
     * 将日期字符串转化为Date对象
     * @param datetime 日期字符串
     * @return date对象
     * @throws Exception
     */
    Date parseDatetime(String datetime) throws Exception;
}
