package team10.ldcc.com.smartconsumer.Data;

import java.io.Serializable;

/**
 * Created by Gelgel on 2017. 7. 27..
 */
public class User implements Serializable{
    private String user_code;
    private String user_name;;
    private String user_phoneNumber;
    private String user_birthday;
    private String user_email;
    private String user_password;
    private String user_gender;
    private String user_address;
    private String user_number_family;
    private String user_type;
    private String result;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phoneNumber() {
        return user_phoneNumber;
    }

    public void setUser_phoneNumber(String user_phoneNumber) {
        this.user_phoneNumber = user_phoneNumber;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_number_family() {
        return user_number_family;
    }

    public void setUser_number_family(String user_number_family) {
        this.user_number_family = user_number_family;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_code='" + user_code + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_phoneNumber='" + user_phoneNumber + '\'' +
                ", user_birthday='" + user_birthday + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_gender='" + user_gender + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_number_family='" + user_number_family + '\'' +
                ", user_type='" + user_type + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
