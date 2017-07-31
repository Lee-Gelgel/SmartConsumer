package team10.ldcc.com.smartconsumer;

import android.app.DatePickerDialog;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Calendar;
import java.util.List;

import team10.ldcc.com.smartconsumer.Data.Product;
import team10.ldcc.com.smartconsumer.common.StringUtil;


/**
 * Created by Gelgel on 2017. 5. 30..
 */
public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder> {
    private Context mContext;
    public List<Product> productList;
    private DatePickerDialog dialogDatePicker;
    public ProductRecyclerAdapter(List<Product> productList, Context mContext) {
        this.productList = productList;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView price;
        public ImageView cart;
        public ImageView image_medal;
        private LinearLayout layout_count;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.item_img);
            name = (TextView) view.findViewById(R.id.item_name);
            price = (TextView) view.findViewById(R.id.item_price);
            cart = (ImageView) view.findViewById(R.id.btn_buy);
            image_medal = (ImageView) view.findViewById(R.id.image_medal);
            layout_count = (LinearLayout) view.findViewById(R.id.layout_count);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        ViewHolder vh;
        View v = LayoutInflater.from(mContext).inflate(R.layout.product_item, parent, false);
        vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        switch(position){
            case 0:
                holder.image_medal.setImageResource(R.drawable.first);
                break;
            case 1:
                holder.image_medal.setImageResource(R.drawable.second);
                break;
            case 2:
                holder.image_medal.setImageResource(R.drawable.third);
                break;
            default:
                holder.image_medal.setVisibility(View.GONE);
                break;
        }
        Glide.with(mContext).load(mContext.getResources().getString(R.string.baseURL) + productList.get(position).getProduct_image())
                .placeholder(R.drawable.img_cider)
                .into(holder.img);
        holder.name.setText(productList.get(position).getProduct_name());
        int price = Integer.parseInt(productList.get(position).getProduct_price());
        holder.price.setText(StringUtil.changePrice(price));
        holder.layout_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogProductNumberPicker(mContext).show();
            }
        });
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDatePicker = new DatePickerDialog(mContext, listener, 2017, 6, 31);
                dialogDatePicker.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
                dialogDatePicker.show();
            }
        });
//
//        holder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String company = "롯데"+productList.get(position).getCompany()+"고객센터 : "+productList.get(position).getPhone_number();
//                Toast.makeText(mContext, "상품 상세 페이지는 준비중입니다.\n"+company,Toast.LENGTH_LONG).show();
//            }
//        });
//        holder.buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String company = "롯데"+productList.get(position).getCompany()+"고객센터 : "+productList.get(position).getPhone_number();
//                if (ApplicationController.getInstance().isLogin()) {
//                    Toast.makeText(mContext,"결제 페이지는 준비중입니다.\n"+company,Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(mContext,"로그인 후 결제 가능합니다",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 10;//productList.size();
    }
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(mContext, year + "년" + monthOfYear + "월" + dayOfMonth +"일", Toast.LENGTH_SHORT).show();
//          product_delivery = year + "." + (monthOfYear + 1) + "." + dayOfMonth;
//            addCart();
        }
    };

}
