package org.example;

import org.example.exception.DuplicateValueException;

public interface UserService {
    public boolean addUser(User user) throws DuplicateValueException;
    public Role getUserRole(User user);
    public Role getUserRole(String name);
    public User getUser(String name);
     public boolean checkLoginTrue(String name,String pass);


    }
