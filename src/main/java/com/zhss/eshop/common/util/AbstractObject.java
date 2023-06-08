package com.zhss.eshop.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : liu heng
 * @description :基础pojo类
 * @date : 2023-04-22 22:53
 **/
public class AbstractObject {
    /**
     * 浅拷贝
     * @param clazz 目标
     * @param <T> 范型
     * @return 目标拷贝
     * @throws Exception 异常
     */
    public <T> T clone(Class<T> clazz) throws Exception {
        T target = clazz.newInstance();
        BeanCopierUtils.copyProperties(this, target);
        return target;
    }

    /**
     * 浅克隆
     * @param target 目标对象
     * @param <T> 范型
     * @return 克隆后的目标对象
     * @throws Exception 异常
     */
    public <T> T clone(T target) throws Exception{
        BeanCopierUtils.copyProperties(this, target);
        return target;
    }

    public <T> T clone(Class<T> clazz, Integer cloneDirection) throws Exception {
        // 先完成基本字段的克隆
        T target = clazz.newInstance();
        BeanCopierUtils.copyProperties(this, target);

        // 完成所有list类型的深度克隆
        Class<?> thisClazz = this.getClass();

        Field[] declaredFields = thisClazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);

            // 判断字段是否是List类型
            if (field.getType() != List.class) {
                continue;
            }

            List<?> list = (List<?>)field.get(this);
            if (list == null || list.size() == 0) {
                continue;
            }

            // 获取List集合中的范型类型
            Class<?> listGenericClazz = getListGenericType(field);

            // 获取要克隆的目标类型
            Class<?> cloneTargetClazz = getCloneTargetClazz(listGenericClazz, cloneDirection);

            // 将list集合克隆到目标list中去
            List cloneList = new ArrayList();

            cloneList(list, cloneList, cloneTargetClazz, cloneDirection);

            // 获取设置克隆好的list的方法名称
            Method setFieldMethod = getSetCloneListFieldMethodName(field, clazz);
            setFieldMethod.invoke(target, cloneList);
        }
        return target;
    }

    /**
     * 将一个list克隆到另外一个list
     * @param list 原list
     * @param cloneList 克隆的list对象
     * @param cloneTargetClazz 目标类
     * @param cloneDirection 方向
     */
    private void cloneList(List<?> list, List targetList, Class<?> cloneTargetClazz, Integer cloneDirection)
            throws Exception {
        for (Object object : list) {
            AbstractObject targetObject = (AbstractObject) object;
            AbstractObject cloneObject = (AbstractObject) targetObject.clone(cloneTargetClazz, cloneDirection);
            targetList.add(cloneObject);
        }
    }

    /**
     * 获取目标类名
     * @param clazz list中的类型
     * @param cloneDirection 克隆方向
     * @return 目标类名
     */
    private Class<?> getCloneTargetClazz(Class<?> clazz, Integer cloneDirection) throws Exception{
        String cloneTargetClassName = null;
        String className = clazz.getName();

        if (cloneDirection.equals(CloneDirection.FORWARD)) {
            if (className.startsWith(DomainType.VO)) {
                cloneTargetClassName = className.substring(0, className.length() - 2) + "DTO";
            } else if (className.startsWith(DomainType.DTO)) {
                cloneTargetClassName = className.substring(0, className.length() - 3) + "DO";
            }
        }

        if(cloneDirection.equals(CloneDirection.OPPOSITE)) {
            if(className.endsWith(DomainType.DO)) {
                cloneTargetClassName =  className.substring(0, className.length() - 2) + "DTO";
            } else if(className.endsWith(DomainType.DTO)) {
                cloneTargetClassName = className.substring(0, className.length() - 3) + "VO";
            }
        }

        return Class.forName(cloneTargetClassName);
    }

    /**
     * 获取list集合的泛型类型
     * @param field 字段
     * @return list集合的泛型类型
     * @throws Exception
     */
    public Class<?> getListGenericType(Field field) throws Exception {
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            return (Class<?>) parameterizedType.getActualTypeArguments()[0];
        }
        return null;
    }

    /**
     * 获取设置克隆好的list的方法名称
     * @param field 方法
     * @param clazz 类
     * @return 克隆好的list的方法名称
     * @throws Exception
     */
    private Method getSetCloneListFieldMethodName(Field field, Class<?> clazz) throws Exception{
        String name = field.getName();
        String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);

        Method setFieldMethod = null;

        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(setMethodName)) {
                setFieldMethod = method;
                break;
            }
        }

        return setFieldMethod;
    }
}
