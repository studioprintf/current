package com.printfstudio.current.bean;

import com.printfstudio.current.server.Account;

import java.util.Date;

/**
 * 封装用户的信息类
 * 待完善的类
 */
public class User extends Account {
    //用邮箱来当作登录名

    private String nickName;          //昵称
    private boolean sex;              //性别
    private Date birthDay;            //生日
    private String signature;         //签名


    /*
    * getter and setter area
    */
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
