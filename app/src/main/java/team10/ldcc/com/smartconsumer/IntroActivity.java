package team10.ldcc.com.smartconsumer;
/**
 * 애플리케이션 인트로를 2초동안 실행하기 위한 액티비티
 */

import android.app.Activity;
import android.os.*;
import android.content.*;
import android.view.*;

public class IntroActivity extends Activity {

    Handler h;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //인트로 화면이므로 타이틀 바 삭제
        setContentView(R.layout.activity_intro);
        h = new Handler(); //딜레이를 주기 위한 핸들러
        h.postDelayed(mrun, 2000); //런어블 객체 mrun, 시간 2초
    }
    Runnable mrun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        h.removeCallbacks(mrun);
    }
}
