package team10.ldcc.com.smartconsumer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;

import team10.ldcc.com.smartconsumer.common.StringUtil;

/**
 * Created by Gelgel on 2017. 7. 30..
 */
public class DialogProducDelivery2 extends Dialog  {

    private TextView textview_cancel;
    private TextView textview_confirm;
    private MaterialCalendarView widget;
    private String delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DialogProducDelivery2(Context mContext,View.OnClickListener btn_delivery) {
        super(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_product_delivery2);
        widget = (MaterialCalendarView) findViewById(R.id.calendarView);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        widget.state().edit()
                .setMinimumDate(CalendarDay.from(year,month+1,day))
                .setMaximumDate(CalendarDay.from(year, month + 2, day));

        widget.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {
                Log.e("aaa",""+getSelectedDatesString());
                String month = "";
                if((date.getMonth()+1)<=9){
                    month += "0";
                }
                month+=(date.getMonth()+1);

                String day = "";
                if(date.getDay()<=9){
                    day +=  "0";
                }
                day += date.getDay();
                delivery = date.getYear()+""+month+""+day;
            }
        });
//        widget.setOnMonthChangedListener(this);


        textview_cancel = (TextView) findViewById(R.id.textview_cancel);
        textview_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        textview_confirm = (TextView) findViewById(R.id.textview_confirm);
        textview_confirm.setOnClickListener(btn_delivery);
    }


    public String getDelivery(){

        return delivery;
    }

    private String getSelectedDatesString() {
        CalendarDay date = widget.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return date.toString();
    }
}
