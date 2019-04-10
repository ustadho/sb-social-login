/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustadho.social.sbsocial.social;

/**
 *
 * @author Ustadho_1218
 */
import com.ustadho.social.sbsocial.entity.AppUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;
 
public class SocialUserDetailsImpl implements SocialUserDetails {
 
    private static final long serialVersionUID = -5246117266247684905L;
 
    private List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
    private AppUser appUser;
 
    public SocialUserDetailsImpl(AppUser appUser, List<String> roleNames) {
        this.appUser = appUser;
 
        for (String roleName : roleNames) {
 
            GrantedAuthority grant = new SimpleGrantedAuthority(roleName );
            this.list.add(grant);
        }
    }
 
    @Override
    public String getUserId() {
        return this.appUser.getUserId() + "";
    }
 
    @Override
    public String getUsername() {
        return appUser.getUserName();
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return list;
    }
 
    @Override
    public String getPassword() {
        return appUser.getEncrytedPassword();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
}