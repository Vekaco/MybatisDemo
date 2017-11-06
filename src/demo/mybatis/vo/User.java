package demo.mybatis.vo;

public class User {
    private int userid;
    private String username;
    private String password;

    public User() {

    }

    public User(int id, String username, String password) {
        this.userid = id;
        this.username = username;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String toString() {
        return "[userid:" + this.userid + ", username:" + this.username + ", password:" + this.password + "]";
    }
}
