package bean;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private int status;
    private Date reqTime;

    public String getValidatecode() {
        return validatecode;
    }

    public void setValidatecode(String validatecode) {
        this.validatecode = validatecode;
    }

    private  String validatecode;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }
}
