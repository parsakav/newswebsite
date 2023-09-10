package org.example;

import org.example.exception.DuplicateValueException;
import org.example.Role;
import org.example.User;

import java.sql.SQLException;

public interface UserDao {
    public boolean addUser(User user) throws DuplicateValueException, NullPointerException;
    public User getUser(int id);
    public User getUser(String name);
    public Role getUserRole(String name);
    public Role getUserRole(User user);
    public Role getUserRole(int id);
}
