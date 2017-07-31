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
public class DialogProductDetail extends Dialog {

    private Button btn_close;
    private TextView textview_productname;
    private TextView textview_productinfo;
    private TextView textview_productinfo2;
    private ImageView imageview_productimage;
    private TextView btn_add_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DialogProductDetail(Context mContext, Product product, View.OnClickListener addCart) {
        super(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_product_detail);

        imageview_productimage = (ImageView) findViewById(R.id.imageview_productimage);
        textview_productname = (TextView) findViewById(R.id.textview_productname);
        textview_productinfo = (TextView) findViewById(R.id.textview_productinfo);
        textview_productinfo2 = (TextView) findViewById(R.id.textview_productinfo2);
        btn_add_cart = (TextView) findViewById(R.id.btn_add_cart);

        Glide.with(mContext).load(mContext.getResources().getString(R.string.baseURL) + product.getProduct_image())
                .placeholder(R.drawable.img_cider)
                .into(imageview_productimage);

        textview_productname.setText(product.getProduct_name());
        textview_productinfo.setText(product.getProduct_price());
        textview_productinfo2.setText(product.getProduct_info());

        btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btn_add_cart.setOnClickListener(addCart);

    }
}
