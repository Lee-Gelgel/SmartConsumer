package team10.ldcc.com.smartconsumer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team10.ldcc.com.smartconsumer.Data.User;
import team10.ldcc.com.smartconsumer.common.StringUtil;
import team10.ldcc.com.smartconsumer.retrofitService.NetworkService;


/**
 * Created by Gelgel on 2017. 5. 30..
 */
public class RegisterActivity extends AppCompatActivity {
    private NetworkService contentService;
    private TextInputLayout layout_edit_email, layout_edit_pw, layout_edit_name, layout_edit_phone_number, layout_edit_address, layout_edit_birthday;
    private TextInputEditText edit_email, edit_pw, edit_name, edit_phone_number, edit_address, edit_birthday;
    private Button btn_register;
    private Toolbar toolbar;
    private DialogBirthday dialogBirthday;
    private RadioButton radio_male, radio_female;

    String city1_str, city2_str;
    Spinner family,city1,city2;
    String[] family_array,city1_array,city2_array;
    ArrayAdapter family_adapter,city1_adapter,city2_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ApplicationController application = ApplicationController.getInstance();
        application.buildNetworkService();
        contentService = ApplicationController.getInstance().getContentService();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setTitle("");

        initLayout();
        setLayout();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initLayout() {
        btn_register = (Button) findViewById(R.id.btn_registr);

        layout_edit_email = (TextInputLayout) findViewById(R.id.layout_edit_email);
        layout_edit_pw = (TextInputLayout) findViewById(R.id.layout_edit_pw);
        layout_edit_name = (TextInputLayout) findViewById(R.id.layout_edit_name);
        layout_edit_phone_number = (TextInputLayout) findViewById(R.id.layout_edit_phone_number);
        layout_edit_address = (TextInputLayout) findViewById(R.id.layout_edit_address);
        layout_edit_birthday = (TextInputLayout) findViewById(R.id.layout_edit_birthday);

        edit_email = (TextInputEditText) findViewById(R.id.edit_email);
        edit_pw = (TextInputEditText) findViewById(R.id.edit_pw);
        edit_name = (TextInputEditText) findViewById(R.id.edit_name);
        edit_phone_number = (TextInputEditText) findViewById(R.id.edit_phone_number);
        edit_address = (TextInputEditText) findViewById(R.id.edit_address);
        edit_birthday = (TextInputEditText) findViewById(R.id.edit_birthday);

//        family = (Spinner) findViewById(R.id.family_spin);
        city1 = (Spinner) findViewById(R.id.city_spin1);
        city2 = (Spinner) findViewById(R.id.city_spin2);

        radio_male = (RadioButton) findViewById(R.id.radio_male);
        radio_female = (RadioButton) findViewById(R.id.radio_female);
    }

    private void setLayout() {

//        family_array = getResources().getStringArray(R.array.family_array);
        city1_array = getResources().getStringArray(R.array.city1_array);
        city2_array = getResources().getStringArray(R.array.city2_array);

//        family_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,family_array);
        city1_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city1_array);
        city2_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city2_array);
        //가족수
//        family.setAdapter(family_adapter);
//        family.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                //user_number_family  = Integer.parseInt(family_adapter.getItem(i).toString());
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
        //시
        city1.setAdapter(city1_adapter);
        city1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city1_str = city1_adapter.getItem(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //구
        city2.setAdapter(city2_adapter);
        city2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city2_str = city2_adapter.getItem(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edit_email.getText().toString();

                if ("".equals(email)) {
                    Toast.makeText(RegisterActivity.this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_email.requestFocus();
                    return;
                }

                if (!StringUtil.isEmailValid(RegisterActivity.this, email)) { // 이메일 유효성 검사
//                    layout_edit_email.setErrorEnabled(true);
//                    layout_edit_email.setError("이메일 유효성 검사");
                    Toast.makeText(RegisterActivity.this, "이메일 형식이 옳바르지 않습니다", Toast.LENGTH_SHORT).show();
                    edit_email.requestFocus();
                    return;
                }

                String pw = edit_pw.getText().toString();
                if ("".equals(pw)) {
                    Toast.makeText(RegisterActivity.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_pw.requestFocus();
                    return;
                }

                String name = edit_name.getText().toString();
                if ("".equals(name)) {
                    Toast.makeText(RegisterActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_name.requestFocus();
                    return;
                }

                String phone_number = edit_phone_number.getText().toString();
                if ("".equals(phone_number)) {
                    Toast.makeText(RegisterActivity.this, "연락처를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_phone_number.requestFocus();
                    return;
                }

                String address = edit_address.getText().toString();
                if ("".equals(address)) {
                    Toast.makeText(RegisterActivity.this, "주소 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_address.requestFocus();
                    return;
                }


                String birthday = edit_birthday.getText().toString();
                if ("".equals(birthday)) {
                    Toast.makeText(RegisterActivity.this, "생년월일을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    edit_birthday.requestFocus();
                    return;
                }


                emailCheck();






            }
        });

        edit_birthday.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialogBirthday = new DialogBirthday(RegisterActivity.this, edit_birthday.getText().toString(), confirmBirthday);
                    dialogBirthday.show();
                }
            }
        });
        edit_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBirthday = new DialogBirthday(RegisterActivity.this, edit_birthday.getText().toString(), confirmBirthday);
                dialogBirthday.show();
            }
        });
    }

    View.OnClickListener confirmBirthday = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView text_year = (TextView) dialogBirthday.findViewById(R.id.text_year);
            TextView text_month = (TextView) dialogBirthday.findViewById(R.id.text_month);
            TextView text_day = (TextView) dialogBirthday.findViewById(R.id.text_day);

            String year = text_year.getText().toString();
            String month = text_month.getText().toString();
            String day = text_day.getText().toString();

            String birthdayStr = year + ((month.length() == 1) ? "0" + month : month) + ((day.length() == 1) ? "0" + day : day);
//
//            Log.e("MyInfoManageActivity", "text_year : " + text_year.getText().toString() + ", text_month :" + text_month.getText().toString() + ", text_day : " + text_day.getText().toString());
            edit_birthday.setText(birthdayStr);
//            new SetBirtydayThread(MyInfoManageActivity.this, birthdayHandler).execute(KClassApplication.getInstance().getUserId(), KClassApplication.getInstance().getUserToken(), birthdayStr);
            dialogBirthday.dismiss();
        }
    };

    public void emailCheck(){

        Call<User> call = contentService.emailCheck(edit_email.getText().toString());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if(!"".equals(user.getUser_name()) && user.getUser_name() != null){
                        Toast.makeText(RegisterActivity.this, "이미 가입되어있는 이메일입니다.", Toast.LENGTH_LONG).show();
                        edit_email.requestFocus();
                    } else {
                        registerUser();
                    }

                } else {
                    int statusCode = response.code();
                    Log.e("error", "응답코드 : " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("error", "서버 onFailure : " + t.getMessage());
            }
        });
    }

    private void registerUser(){
        User user = new User();
        user.setUser_email(edit_email.getText().toString().trim());
        user.setUser_password(edit_pw.getText().toString().trim());
        user.setUser_type("1");
        user.setUser_name(edit_name.getText().toString().trim());
        user.setUser_birthday(edit_birthday.getText().toString());
        user.setUser_phoneNumber(edit_phone_number.getText().toString());
        user.setUser_address(city1_str + " " + city2_str + " " + edit_address.getText().toString());
        String gender = "0";
        if(radio_male.isChecked()){
            gender = "1";
        } else if (radio_female.isChecked()) {
            gender = "2";
        }
        user.setUser_gender(gender);


        Call<User> call = contentService.registerUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User result = response.body();
                    Log.e("abc",""+result.getResult());
                    Toast.makeText(RegisterActivity.this, "가입되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("error", "서버 onFailure : " + t.getMessage());
            }
        });
        Log.e("User ?",""+user.toString());
    }

//    public void insertMember() {
//        Member member = new Member();
//        member.setName(edit_name.getText().toString().trim());
//        member.setAddress(edit_address.getText().toString().trim());
//        member.setBirthday(edit_birthday.getText().toString().trim());
//        member.setEmail(edit_email.getText().toString().trim());
//        member.setPassword(StringUtil.changeSHA256(edit_pw.getText().toString().trim()));
//        member.setPhone_number(edit_phone_number.getText().toString().trim());
//        member.setStatus("1");
//        Call<Member> call = contentService.insertMember(member);
//        call.enqueue(new Callback<Member>() {
//            @Override
//            public void onResponse(Call<Member> call, Response<Member> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(RegisterActivity.this, "가입되었습니다.", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                    setResult(RESULT_OK, intent);
//                    finish();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Member> call, Throwable t) {
//                Log.e("error", "서버 onFailure : " + t.getMessage());
//            }
//        });
//    }


}
