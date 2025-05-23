/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gr5.pojo.Users;
import com.gr5.repositories.UserRepository;
import org.hibernate.Session;
import jakarta.persistence.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

/**
 *
 * @author luann
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Users getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Users.findByUsername", Users.class);
        q.setParameter("username", username);

        return (Users) q.getSingleResult();

    }

//    @Override
//    public Users addUser(Users u) {
//        Session s = this.factory.getObject().getCurrentSession();
//        s.persist(u);
//        
//        return u;
//    }
//
//    @Override
//    public boolean authenticate(String username, String password) {
//        Users u = this.getUserByUsername(username);
//
//        return this.passwordEncoder.matches(password, u.getPasswordHash());
//    }
}
