package team10.ldcc.com.smartconsumer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import team10.ldcc.com.smartconsumer.Data.Product;

/**
 * Created by Gelgel on 2017. 7. 30..
 */
public class DialogProductDetail2 extends Dialog {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private TextView tv_name;
    private ImageView iv_img;
    private TextView tv_info3;
    private TextView tv_info2;
    private TextView tv_info4;
    private ImageView iv_recipe1;
    private ImageView iv_recipe2;
    private Button btn_add_cart;
    private ImageView close_btn;


    public DialogProductDetail2(Context mContext, Product product) {
        super(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_product_detail2);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_info3 = (TextView) findViewById(R.id.tv_info3);
        tv_info2 = (TextView) findViewById(R.id.tv_info2);
        tv_info4 = (TextView) findViewById(R.id.tv_info4);

        iv_img = (ImageView) findViewById(R.id.iv_img);
        iv_recipe1 = (ImageView) findViewById(R.id.iv_recipe1);
        iv_recipe2 = (ImageView) findViewById(R.id.iv_recipe2);
        close_btn = (ImageView) findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
