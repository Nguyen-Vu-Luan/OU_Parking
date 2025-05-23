/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services.impl;

import com.cloudinary.Cloudinary;
import com.gr5.pojo.Users;
import com.gr5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gr5.repositories.UserRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luann
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    @Autowired
//    private Cloudinary cloudinary;

    @Override
    public Users getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users u = this.userRepo.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid username!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole()));
        
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPasswordHash(), authorities);
    }

//    @Override
//    public Users addUser(Map<String, String> params, MultipartFile avatar) {
//        Users u = new Users();
//        u.setFirstName(params.get("firstName"));
//        u.setLastName(params.get("lastName"));
//        u.setEmail(params.get("email"));
//        u.setPhone(params.get("phone"));
//        u.setUsername(params.get("username"));
//        u.setPasswordHash(this.passwordEncoder.encode(params.get("password")));
//        u.setRole("user");
//        
////        if (!avatar.isEmpty()) {
////            try {
////                Map res = cloudinary.uploader().upload(avatar.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
////                u.setAvatar(res.get("secure_url").toString());
////            } catch (IOException ex) {
////                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
////            }
////        }
//        
//        return this.userRepo.addUser(u);
//    }
//
//    @Override
//    public boolean authenticate(String username, String password) {
//        return this.userRepo.authenticate(username, password);
//    }
}
