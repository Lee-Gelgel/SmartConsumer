package team10.ldcc.com.smartconsumer;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import team10.ldcc.com.smartconsumer.Data.User;
import team10.ldcc.com.smartconsumer.retrofitService.NetworkService;

/**
 * Created by Gelgel on 2017. 5. 30..
 */
public class ApplicationController extends Application {
    private static ApplicationController instance;

    public static ApplicationController getInstance() {
        return instance;
    }


    private SharedPreferences setting;                                  // 앱 유지 데이터 저장
    private SharedPreferences.Editor editor;                            // 앱 유지 데이터 수정

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;
        setting = getSharedPreferences("setting", 0);
        editor = setting.edit();
    }

    private NetworkService contentService;

    public NetworkService getContentService() {
        return contentService;
    }

    private String baseUrl;

    public void buildNetworkService() {
        synchronized (ApplicationController.class) {
            if (contentService == null) {
//                baseUrl = String.format("http://%s:%d", ip, port);
                baseUrl = "http://52.78.34.142:3000";
                Gson gson = new GsonBuilder().create();

                GsonConverterFactory factory = GsonConverterFactory.create(gson);

                Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(factory).build();
                contentService = retrofit.create(NetworkService.class);

            }
        }
    }

    public void setLogin(boolean isLogin){
        editor.putString("isLogin", isLogin ? "0" : "1");
        editor.commit();
    }

    public boolean isLogin(){
        String login = setting.getString("isLogin","");
        return login.equals("0");

    }

    public void setUser(User user){
        if (user == null) {
            user = new User();
        }
        editor.putString("user_code",user.getUser_code());
        editor.putString("user_email",user.getUser_email());
        editor.putString("user_name",user.getUser_name());
        editor.putString("user_birthday",user.getUser_birthday());
        editor.putString("user_gender",user.getUser_gender());
        editor.putString("user_address",user.getUser_address());
        editor.putString("user_phoneNumber",user.getUser_phoneNumber());
        editor.putString("user_number_family",user.getUser_number_family());
        editor.putString("user_type",user.getUser_type());
        editor.commit();
    }

    public User getUser(){
        User user = new User();
        user.setUser_code(setting.getString("user_code", ""));
        user.setUser_email(setting.getString("user_email", ""));
        user.setUser_name(setting.getString("user_name", ""));
        user.setUser_birthday(setting.getString("user_birthday", ""));
        user.setUser_gender(setting.getString("user_gender", ""));
        user.setUser_address(setting.getString("user_address", ""));
        user.setUser_phoneNumber(setting.getString("user_phoneNumber", ""));
        user.setUser_number_family(setting.getString("user_number_family", ""));
        user.setUser_type(setting.getString("user_type", ""));
        return user;
    }
}
