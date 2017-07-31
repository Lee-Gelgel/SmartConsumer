package team10.ldcc.com.smartconsumer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Gelgel on 2017. 7. 30..
 */
public class DialogProducDelivery extends Dialog {

    private Button btn_back;

    private Button calendar_year_month;
    private TextView calendar_day_1,calendar_day_2,calendar_day_3,calendar_day_4,calendar_day_5,calendar_day_6,calendar_day_7;
    private TextView calendar_day_8,calendar_day_9,calendar_day_10,calendar_day_11,calendar_day_12,calendar_day_13,calendar_day_14;
    private TextView calendar_day_15,calendar_day_16,calendar_day_17,calendar_day_18,calendar_day_19,calendar_day_20,calendar_day_21;
    private TextView calendar_day_22,calendar_day_23,calendar_day_24,calendar_day_25,calendar_day_26,calendar_day_27,calendar_day_28;
    private TextView calendar_day_29,calendar_day_30,calendar_day_31,calendar_day_32,calendar_day_33,calendar_day_34,calendar_day_35;
    private TextView calendar_day_36,calendar_day_37,calendar_day_38,calendar_day_39,calendar_day_40,calendar_day_41,calendar_day_42;
    private ArrayList<TextView> calendar_days;
    private int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DialogProducDelivery(Context mContext) {
        super(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_product_delivery);


        btn_back = (Button) findViewById(R.id.btn_back2);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("abc","close");
                dismiss();
            }
        });


        initLayout();

        calendar_day_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("abc", "abc");
                calendar_day_2.setBackgroundColor(Color.BLUE);
            }
        });

        Calendar calendar = Calendar.getInstance();
        Log.e("aaa",""+calendar.get(Calendar.MONTH));
        Log.e("aaa",""+calendar.get(Calendar.DAY_OF_MONTH));
        Log.e("aaa",""+calendar.get(Calendar.DAY_OF_WEEK));


        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;

        calendar_year_month.setText(""+year+"년 "+month+"월");

        calendar.set(year, month-1, 1);
        Log.e("aaa",""+calendar.get(Calendar.MONTH));
        Log.e("aaa",""+calendar.get(Calendar.DAY_OF_MONTH));
        Log.e("aaa", "" + calendar.get(Calendar.DAY_OF_WEEK));

        if (isLeapYear(year)) {
            months[1] = 29;
        }

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int day = 1;
        for(int i=0;i<calendar_days.size();i++){
//            calendar_day_13.setText("");
//            calendar_days.get(i).setText("");
            if(i<dayOfWeek-1){
                calendar_days.get(i).setText("");
            } else if(day<=months[month-1]) {
                calendar_days.get(i).setText(""+day++);
            } else {
                calendar_days.get(i).setText("");
            }

        }
    }

    private void initLayout() {
        setContentView(R.layout.dialog_product_delivery);
        calendar_year_month = (Button) findViewById(R.id.calendar_year_month);
        calendar_days = new ArrayList<>();
        calendar_day_1 = (TextView) findViewById(R.id.calendar_day_1);
        calendar_day_2 = (TextView) findViewById(R.id.calendar_day_2);
        calendar_day_3 = (TextView) findViewById(R.id.calendar_day_3);
        calendar_day_4 = (TextView) findViewById(R.id.calendar_day_4);
        calendar_day_5 = (TextView) findViewById(R.id.calendar_day_5);
        calendar_day_6 = (TextView) findViewById(R.id.calendar_day_6);
        calendar_day_7 = (TextView) findViewById(R.id.calendar_day_7);
        calendar_day_8 = (TextView) findViewById(R.id.calendar_day_8);
        calendar_day_9 = (TextView) findViewById(R.id.calendar_day_9);
        calendar_day_10 = (TextView) findViewById(R.id.calendar_day_10);
        calendar_day_11 = (TextView) findViewById(R.id.calendar_day_11);
        calendar_day_12 = (TextView) findViewById(R.id.calendar_day_12);
        calendar_day_13 = (TextView) findViewById(R.id.calendar_day_13);
        calendar_day_14 = (TextView) findViewById(R.id.calendar_day_14);
        calendar_day_15 = (TextView) findViewById(R.id.calendar_day_15);
        calendar_day_16 = (TextView) findViewById(R.id.calendar_day_16);
        calendar_day_17 = (TextView) findViewById(R.id.calendar_day_17);
        calendar_day_18 = (TextView) findViewById(R.id.calendar_day_18);
        calendar_day_19 = (TextView) findViewById(R.id.calendar_day_19);
        calendar_day_20 = (TextView) findViewById(R.id.calendar_day_20);
        calendar_day_21 = (TextView) findViewById(R.id.calendar_day_21);
        calendar_day_22 = (TextView) findViewById(R.id.calendar_day_22);
        calendar_day_23 = (TextView) findViewById(R.id.calendar_day_23);
        calendar_day_24 = (TextView) findViewById(R.id.calendar_day_24);
        calendar_day_25 = (TextView) findViewById(R.id.calendar_day_25);
        calendar_day_26 = (TextView) findViewById(R.id.calendar_day_26);
        calendar_day_27 = (TextView) findViewById(R.id.calendar_day_27);
        calendar_day_28 = (TextView) findViewById(R.id.calendar_day_28);
        calendar_day_29 = (TextView) findViewById(R.id.calendar_day_29);
        calendar_day_30 = (TextView) findViewById(R.id.calendar_day_30);
        calendar_day_31 = (TextView) findViewById(R.id.calendar_day_31);
        calendar_day_32 = (TextView) findViewById(R.id.calendar_day_32);
        calendar_day_33 = (TextView) findViewById(R.id.calendar_day_33);
        calendar_day_34 = (TextView) findViewById(R.id.calendar_day_34);
        calendar_day_35 = (TextView) findViewById(R.id.calendar_day_35);
        calendar_day_36 = (TextView) findViewById(R.id.calendar_day_36);
        calendar_day_37 = (TextView) findViewById(R.id.calendar_day_37);
        calendar_day_38 = (TextView) findViewById(R.id.calendar_day_38);
        calendar_day_39 = (TextView) findViewById(R.id.calendar_day_39);
        calendar_day_40 = (TextView) findViewById(R.id.calendar_day_40);
        calendar_day_41 = (TextView) findViewById(R.id.calendar_day_41);
        calendar_day_42 = (TextView) findViewById(R.id.calendar_day_42);
        calendar_days.add(calendar_day_1);
        calendar_days.add(calendar_day_2);
        calendar_days.add(calendar_day_3);
        calendar_days.add(calendar_day_4);
        calendar_days.add(calendar_day_5);
        calendar_days.add(calendar_day_6);
        calendar_days.add(calendar_day_7);
        calendar_days.add(calendar_day_8);
        calendar_days.add(calendar_day_9);
        calendar_days.add(calendar_day_10);
        calendar_days.add(calendar_day_11);
        calendar_days.add(calendar_day_12);
        calendar_days.add(calendar_day_13);
        calendar_days.add(calendar_day_14);
        calendar_days.add(calendar_day_15);
        calendar_days.add(calendar_day_16);
        calendar_days.add(calendar_day_17);
        calendar_days.add(calendar_day_18);
        calendar_days.add(calendar_day_19);
        calendar_days.add(calendar_day_20);
        calendar_days.add(calendar_day_21);
        calendar_days.add(calendar_day_22);
        calendar_days.add(calendar_day_23);
        calendar_days.add(calendar_day_24);
        calendar_days.add(calendar_day_25);
        calendar_days.add(calendar_day_26);
        calendar_days.add(calendar_day_27);
        calendar_days.add(calendar_day_28);
        calendar_days.add(calendar_day_29);
        calendar_days.add(calendar_day_30);
        calendar_days.add(calendar_day_31);
        calendar_days.add(calendar_day_32);
        calendar_days.add(calendar_day_33);
        calendar_days.add(calendar_day_34);
        calendar_days.add(calendar_day_35);
        calendar_days.add(calendar_day_36);
        calendar_days.add(calendar_day_37);
        calendar_days.add(calendar_day_38);
        calendar_days.add(calendar_day_39);
        calendar_days.add(calendar_day_40);
        calendar_days.add(calendar_day_41);
        calendar_days.add(calendar_day_42);
    }

    private boolean isLeapYear(int year){
        return year%4==0?(year%100==0?(year%400==0?true:false):true):false; // 4로 나눠지면 윤년, 100으로 나눠지면 평년, 400으로 나눠지면 윤년
    }
}
