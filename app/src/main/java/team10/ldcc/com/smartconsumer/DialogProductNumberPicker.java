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
    private NumberPicker numberpicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DialogProductNumberPicker(Context mContext) {
        super(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_product_delivery);

        numberpicker = (NumberPicker) findViewById(R.id.numberpicker);
        numberpicker.setMinValue(1);
        numberpicker.setValue(1);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
