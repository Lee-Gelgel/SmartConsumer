package team10.ldcc.com.smartconsumer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import team10.ldcc.com.smartconsumer.common.DatePicker.DatePicker;


/**
 * Created by Gelgel on 2017. 2. 9..
 */
public class DialogBirthday extends Dialog {

    private DialogBirthday dialogBirthday;
    private TextView button_cancel;
    private TextView button_confirm;
    private DatePicker mDatePicker3;
    private TextView text_year, text_month, text_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DialogBirthday(Context context,String birthDay, View.OnClickListener confirmClick) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_birthday);

        button_cancel = (TextView) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        button_confirm = (TextView) findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(confirmClick);

        text_year = (TextView) findViewById(R.id.text_year);
        text_month = (TextView) findViewById(R.id.text_month);
        text_day = (TextView) findViewById(R.id.text_day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            if("".equals(birthDay)||birthDay==null){
                date = sdf.parse("19880101");
                text_year.setText("1988");
                text_month.setText("1");
                text_day.setText("1");
            } else {
                date = sdf.parse(birthDay);

                String year = birthDay.substring(0,4);
                text_year.setText(year);

                String month = birthDay.substring(4,6);
                if(month.indexOf('0')==0){
                    month = month.replaceFirst("0","");
                }
                text_month.setText(month);

                String day = birthDay.substring(6,8);
                if(day.indexOf('0')==0){
                    day = day.replaceFirst("0","");
                }
                text_day.setText(day);

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mDatePicker3 = (DatePicker) findViewById(R.id.datePicker);
        mDatePicker3
                .setDate(date)
                .setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Log.i("DatePicker", year + "-" + monthOfYear + "-" + dayOfMonth);
                        text_year.setText("" + year);
                        text_month.setText(""+monthOfYear);
                        text_day.setText(""+dayOfMonth);
                    }
                });
    }

}
