package service;

import bean.User;
import dao.UserDao;

public class UserService {
    public void insertUser(User user){
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
    public User queryUser(String username,String uuid){
        UserDao userDao = new UserDao();
        User user = userDao.queryUser(username, uuid);
        return user;
    }
    public void updateStauts(String username,String uuid){
        UserDao userDao = new UserDao();
        userDao.updateStauts(username,uuid);
    }
}
