package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.domain.PriorityDTO;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : liu heng
 * @description :权限缓存管理组件
 * @date : 2023-06-09 00:17
 **/
@Component
public class PriorityCacheManagerImpl implements PriorityCacheManager{
    /**
     * 用户授权的菜单树的缓存
     */
    private Map<Long, List<PriorityDTO>> authorizedPriorityTreeCache =
            new ConcurrentHashMap<Long, List<PriorityDTO>>();
    /**
     * 用户对某个编号的权限是否被授权的缓存
     */
    private Map<String, Boolean> authorizedByCodeCache =
            new ConcurrentHashMap<String, Boolean>();
    /**
     * 用户对某个url的权限是否被授权的缓存
     */
    private Map<String, Boolean> authorizedByUrlCache =
            new ConcurrentHashMap<String, Boolean>();

    /**
     * 获取账号的授权菜单树
     * @param accountId 账号id
     * @return
     */
    @Override
    public List<PriorityDTO> getAuthorizedPriorityTree(Long accountId) {
        return authorizedPriorityTreeCache.get(accountId);
    }

    /**
     * 缓存授权菜单树
     * @param accountId 账号id
     * @param authorizedPriorityTree 授权菜单树
     * @throws
     */
    @Override
    public void cacheAuthorizedPriorityTree(Long accountId,
                                            List<PriorityDTO> authorizedPriorityTree) throws Exception {
        authorizedPriorityTreeCache.put(accountId, authorizedPriorityTree);
    }

    /**
     * 删除授权菜单树的缓存
     * @param accountId 账号id
     */
    @Override
    public void removeAuthorizedPriorityTree(Long accountId) {
        authorizedPriorityTreeCache.remove(accountId);
    }

    /**
     * 获取账号对指定编号的权限是否被授权
     * @param accountId 账号id
     * @param code 权限编号
     * @return 是否授权
     */
    @Override
    public Boolean getAuthorizedByCode(Long accountId, String code) {
        return authorizedByCodeCache.get(getAuthorizedByCodeCacheKey(accountId, code));
    }

    /**
     * 缓存账号对指定编号的权限是否被授权
     * @param accountId 账号
     * @param code 权限编号
     * @param authorized 是否被授权
     * @throws Exception
     */
    @Override
    public void cacheAuthorizedByCode(Long accountId,
                                      String code, Boolean authorized) throws Exception {
        authorizedByCodeCache.put(getAuthorizedByCodeCacheKey(accountId, code), authorized);
    }

    /**
     * 获取账号对指定编号的权限是否被授权的缓存key
     * @param accountId 账号id
     * @param code 权限编号
     * @return 缓存key
     */
    private String getAuthorizedByCodeCacheKey(Long accountId, String code) {
        return accountId + "_" + code;
    }

    /**
     * 删除账号对指定编号的权限是否被授权的缓存
     * @param accountId 账号id
     */
    @Override
    public void removeAuthorizedByCode(Long accountId) {
        Iterator<String> cacheKeyIterator = authorizedByCodeCache.keySet().iterator();
        while(cacheKeyIterator.hasNext()) {
            String cacheKey = cacheKeyIterator.next();
            if(cacheKey.substring(0, cacheKey.indexOf("_"))
                    .equals(String.valueOf(accountId))) {
                authorizedByCodeCache.remove(cacheKey);
            }
        }
    }

    /**
     * 获取账号对指定url的权限是否被授权
     * @param accountId 账号id
     * @param url 权限url
     * @return 是否授权
     */
    @Override
    public Boolean getAuthorizedByUrl(Long accountId, String url) {
        return authorizedByUrlCache.get(getAuthorizedByCodeCacheKey(accountId, url));
    }

    /**
     * 缓存账号对指定URL的权限是否被授权
     * @param accountId 账号
     * @param url 权限url
     * @param authorized 是否被授权
     * @throws Exception
     */
    @Override
    public void cacheAuthorizedByUrl(Long accountId,
                                     String url, Boolean authorized) throws Exception {
        authorizedByUrlCache.put(getAuthorizedByUrlCacheKey(accountId, url), authorized);
    }

    /**
     * 获取账号对指定url的权限是否被授权的缓存key
     * @param accountId 账号id
     * @param url 权限url
     * @return 缓存key
     */
    private String getAuthorizedByUrlCacheKey(Long accountId, String url) {
        return accountId + "_" + url;
    }

    /**
     * 删除账号对指定url的权限是否被授权的缓存
     * @param accountId 账号id
     */
    @Override
    public void removeAuthorizedByUrl(Long accountId) {
        Iterator<String> cacheKeyIterator = authorizedByUrlCache.keySet().iterator();
        while(cacheKeyIterator.hasNext()) {
            String cacheKey = cacheKeyIterator.next();
            if(cacheKey.substring(0, cacheKey.indexOf("_"))
                    .equals(String.valueOf(accountId))) {
                authorizedByUrlCache.remove(cacheKey);
            }
        }
    }

    /**
     * 删除账号对应的所有权限缓存数据
     * @param accountId
     */
    @Override
    public void remove(Long accountId) {
        removeAuthorizedPriorityTree(accountId);
        removeAuthorizedByCode(accountId);
        removeAuthorizedByUrl(accountId);
    }
}
