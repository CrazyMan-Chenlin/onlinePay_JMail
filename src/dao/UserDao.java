package dao;

import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JdbcUtil;

import java.sql.SQLException;

public class UserDao {
    public void insertUser(User user){
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        String sql="Insert into user2(username,password,email,status,reqtime,validatecode) value(?,?,?,?,?,?)";
        try {
            qr.update(sql,new Object[]{user.getUsername(),user.getPassword(),
                    user.getEmail(),user.getStatus(),user.getReqTime(),user.getValidatecode()});
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }
    public User queryUser(String username,String uuid){
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        String sql ="select * from user2 where username=? and validatecode=?";
        try {
            User user = (User) qr.query(sql, new BeanHandler(User.class),new Object[]{username,uuid});
            return user;
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
    public void updateStauts(String username,String uuid){
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update user2 set status=1 where username=? and validatecode=?";
        try {
            qr.update(sql,new Object[]{username,uuid});
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }
}
