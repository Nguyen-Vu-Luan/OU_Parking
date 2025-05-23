/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services;

import com.gr5.pojo.Users;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luann
 */
public interface UserService extends UserDetailsService{
    Users getUserByUsername(String username);
    Users register(Map<String, String> params, MultipartFile avatar);
//    boolean authenticate(String username, String password);
}
