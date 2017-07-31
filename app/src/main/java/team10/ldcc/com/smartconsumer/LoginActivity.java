package team10.ldcc.com.smartconsumer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team10.ldcc.com.smartconsumer.Data.User;
import team10.ldcc.com.smartconsumer.common.StringUtil;
import team10.ldcc.com.smartconsumer.retrofitService.NetworkService;


public class LoginActivity extends AppCompatActivity {
    private ApplicationController application;
    private NetworkService networkService;
    private TextInputEditText edit_email;
    private TextInputEditText edit_pw;
    private Button btn_login;
    private Button btn_register;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 화면을 portrait(세로) 화면으로 고정하고 싶은 경우
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 화면을 landscape(가로) 화면으로 고정하고 싶은 경우

        setContentView(R.layout.activity_login);
        application = ApplicationController.getInstance();
        application.buildNetworkService();
        networkService = ApplicationController.getInstance().getContentService();


        initLayout();
        setLayout();
        loginCheck();
    }
    private void initLayout(){
        edit_email = (TextInputEditText) findViewById(R.id.edit_email);
        edit_pw = (TextInputEditText) findViewById(R.id.edit_pw);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_registr);
    }

    private void setLayout(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edit_email.getText().toString();
//                String pw = edit_pw.getText().toString();
                if (StringUtil.isEmailValid(LoginActivity.this, email)){ // 이메일 유효성 검사
                    loginUser();
                } else {
                    Toast.makeText(LoginActivity.this, "이메일 형식이 옳바르지 않습니다", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_email.setText("");
                edit_pw.setText("");
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            edit_email.requestFocus();
//            Log.e("LoginActivity","onActivityResult -> RESULT_OK");
        }
    }

    public void loginCheck(){
        if (application.isLogin()){
//            Log.e("abc","isLogin truel");
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//            intent.putExtra("user",application.getMember());
            startActivity(intent);
            finish();
        }
    }


    public void loginUser(){
        User user = new User();
        String email = edit_email.getText().toString().trim();
        String password = edit_pw.getText().toString().trim();
        user.setUser_email(email);
        user.setUser_password(password);

        Call<User> call = networkService.loginUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    Log.e("user ?",""+user.toString());
                    if (!"".equals(user.getUser_name()) && user.getUser_name() != null) {
                        ApplicationController.getInstance().setUser(user);
                        ApplicationController.getInstance().setLogin(true);
                        Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                        Log.e("getUser ?",""+ApplicationController.getInstance().getUser());
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                        setResult(RESULT_OK, intent);
                        startActivity(intent);
                        finish();
                    } else {
//                    int statusCode = response.code();
                        Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를\n다시 입력해주세요.", Toast.LENGTH_LONG).show();
//                    Log.e("error", "응답코드 : " + statusCode);
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("error", "서버 onFailure : " + t.getMessage());
            }
        });
    }






    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

   @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한번 더 뒤로가기 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }

}
