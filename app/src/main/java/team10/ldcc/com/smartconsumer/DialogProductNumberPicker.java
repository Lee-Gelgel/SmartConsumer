package team10.ldcc.com.smartconsumer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import team10.ldcc.com.smartconsumer.Data.Product;

/**
 * Created by Gelgel on 2017. 7. 30..
 */
public class DialogProductNumberPicker extends Dialog {

    private Button btn_back;
    private Button btn_ok;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DialogProductNumberPicker(Context mContext,View.OnClickListener btnOk, int num) {
        super(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_product_count);

        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        numberPicker.setValue(num);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(btnOk);

    }

    public int setNumber(){
        return numberPicker.getValue();
    }
}
