package inetShop.domain;

import inetShop.repository.UserRepository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Администратор on 08.07.2017.
 */
public class User {


    private String login;
    private String password;
    private String name;
    private String region;
    private String feedback;
    private String gender;
    private String retypepsw;
    private String agree;



    private boolean access;
    private boolean registration;
    public User(){}

    @Override
    public String toString() {
        return "User [login=" + login + ", password=" + password + ", access=" + access + "]";
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, String region, String feedback, String gender) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.region = region;
        this.feedback = feedback;
        this.gender = gender;
    }

    public boolean getAccess(String login, String password) {
        UserRepository db=new UserRepository();
        db.connect_to_database_from_properties();
        access = db.getAuthorithation(login, passwordConverter(password));
        return access;
     // return true;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public boolean getRegistration() {
        UserRepository db=new UserRepository();
        db.connect_to_database_from_properties();
        registration=db.registration(login, passwordConverter(password), name, region, feedback, gender);
        return registration;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setRetypepsw(String retypepsw) {
        this.retypepsw = retypepsw;
    }
    public void setAgree(String agree) {
        this.agree = agree;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getRegion() {
        return region;
    }
    public String getFeedback() {
        return feedback;
    }
    public String getGender() {
        return gender;
    }
    public String getRetypepsw() {
        return retypepsw;
    }
    public String getAgree() {
        return agree;
    }

public static String passwordConverter(String password){
    MessageDigest messageDigest = null;
    byte[] digest = new byte[0];
    try {
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(password.getBytes());
        digest = messageDigest.digest();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    BigInteger bigInt = new BigInteger(1, digest);
    String md5Hex = bigInt.toString(16);

    while( md5Hex.length() < 32 ){
        md5Hex = "0" + md5Hex;
    }
    return md5Hex;
}

}
