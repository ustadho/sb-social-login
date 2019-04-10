/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustadho.social.sbsocial.utils;

/**
 *
 * @author Ustadho_1218
 */
import java.util.Collection;
  
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
  
public class WebUtils {
  
    public static String toString(UserDetails user) {
        StringBuilder sb = new StringBuilder();
  
        sb.append("UserName:").append(user.getUsername());
  
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
     
}