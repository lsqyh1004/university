package com.qf.config;


import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    //权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String)principals.getPrimaryPrincipal();
        User user=new User();
        user.setName(primaryPrincipal);
        Integer id=userService.findOne(user).getId();
        List<Permission> permissions = userService.selectById(id);
        if(permissions!=null && permissions.size()!=0){
            Collection collection = new HashSet();
            for (Permission p: permissions){
                collection.add(p.getRoler());
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(collection);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = (String)token.getPrincipal();
        User user=userService.selectByName(name);
        if (user!=null){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getName(),user.getPass(),getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
