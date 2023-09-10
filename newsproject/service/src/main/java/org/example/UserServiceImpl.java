package org.example;

import org.example.exception.DuplicateValueException;

public class UserServiceImpl implements UserService {

    private SHA256Alghoritm alghoritm;
    private static final UserDao userDao;
    static{
        userDao = new UserDaoImpl();

    }
    public UserServiceImpl() {
        alghoritm=new SHA256AlghoritmImpl();
    }
    @Override
    public boolean addUser(User user) throws DuplicateValueException {
        if(user.getRole_id()!=0 && user.getName().equals(null) && user.getName().isEmpty()
        && user.getPass().isEmpty() && user.getPass().equals(null)) {
            throw new NullPointerException("All field in the User object must be not null");
        }
user.setPass(alghoritm.toHash(user.getPass()));
        return userDao.addUser(user);
    }

    @Override
    public Role getUserRole(User user) {
        if(user.getRole_id()!=0) {
            return userDao.getUserRole(user);
        }
        return null;
    }

    @Override
    public Role getUserRole(String name) {
        if(name.equals(null) || name.isEmpty()){
            throw new NullPointerException("user name is empty or null");
        }
        return userDao.getUserRole(name);
    }

    @Override
    public User getUser(String name) {
        if(name.equals(null) || name.isEmpty()){
            throw new NullPointerException("user name is empty or null");
        }
        return userDao.getUser(name);
    }

    public boolean checkLoginTrue(String name,String pass){
        if(name.equals(null) || name.isEmpty() && pass.equals(null) || pass.isEmpty()){
            throw new NullPointerException("username/password  is empty or null");
        }
       User user= getUser(name);
        if (user==null) {
            return false;
        }
        return alghoritm.checkHash(alghoritm.toHash(pass),user.getPass());
    }
}
