/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.repositories;

import com.gr5.pojo.Users;
import java.util.List;

/**
 *
 * @author luann
 */
public interface UserRepository {
    Users getUserByUsername(String username);
    Users register(Users u);
    List<Users> getUser();
//    boolean authenticate(String username, String password);
}
