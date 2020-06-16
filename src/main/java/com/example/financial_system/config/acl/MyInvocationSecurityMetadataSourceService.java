package com.example.financial_system.config.acl;

import com.example.financial_system.dao.RoleDao;
import com.example.financial_system.entity.RoleOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: linqx
 * @Date: 2020/6/15 14:50
 */
@Component
public class MyInvocationSecurityMetadataSourceService  implements
        FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleDao roleDao;

    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到 不急弄清楚
     */
    private static HashMap<String, Collection<ConfigAttribute>> map =null;



    //初始化 所有资源 对应的角色
    public void loadResourceDefine(){
        map = new HashMap<>();
        //权限资源 和 角色对应的表  也就是 角色 权限中间表
        List<RoleOperation> roleOperations = roleDao.selectRoleOperation();

        //每个资源 所需要的角色
        for (RoleOperation roleOperation : roleOperations) {

            String url = roleOperation.getUrl();
            String roleName = roleOperation.getRoleName();
            ConfigAttribute role = new SecurityConfig(roleName);

            if(map.containsKey(url)){
                map.get(url).add(role);
            }else{
                map.put(url,new ArrayList<ConfigAttribute>(){{
                    add(role);
                }});
            }
        }
    }

    /**
     * 我的理解是 方法会被调用，然后返回资源所需要的角色
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map ==null) {
            loadResourceDefine();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            String url = iter.next();
            if(new AntPathRequestMatcher(url).matches(request)) {
                return map.get(url);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
