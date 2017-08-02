package team10.ldcc.com.smartconsumer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import team10.ldcc.com.smartconsumer.Data.Cart;
import team10.ldcc.com.smartconsumer.Data.Product;
import team10.ldcc.com.smartconsumer.common.StringUtil;


/**
 * Created by Gelgel on 2017. 5. 30..
 */
public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder> {
    private Context mContext;
    public List<Product> cartList;

    public CartRecyclerAdapter(List<Product> cartList, Context mContext) {
        this.cartList = cartList;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_delivery;


        public ImageView img;
        public TextView name;
        public TextView price;
        public Button buy;
        public LinearLayout layout_line;
        public CheckBox checkbox;
        public ViewHolder(View view) {
            super(view);
            tv_delivery = (TextView) view.findViewById(R.id.tv_delivery);
            img = (ImageView) view.findViewById(R.id.item_img);
            name = (TextView) view.findViewById(R.id.item_name);
            price = (TextView) view.findViewById(R.id.item_price);
            layout_line = (LinearLayout) view.findViewById(R.id.layout_line);
            checkbox = (CheckBox) view.findViewById(R.id.checkbox);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        ViewHolder vh;
        View v = LayoutInflater.from(mContext).inflate(R.layout.cart_item, parent, false);
        vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).load(mContext.getResources().getString(R.string.baseURL) + cartList.get(position).getProduct_image())
                .placeholder(R.drawable.img_cider)
                .into(holder.img);
        String[] infos = cartList.get(position).getProduct_info().split(",");
        String name = "["+infos[0].split(":")[1].trim()+"] "+cartList.get(position).getProduct_name()+" "+infos[1].split(":")[1].trim();
        holder.name.setText(name);
        int price = Integer.parseInt(cartList.get(position).getProduct_price());
        holder.price.setText(StringUtil.changePrice(price) + "원");
        holder.tv_delivery.setText(cartList.get(position).getProduct_delivery());

        if(position>0){
            int day1 = Integer.parseInt(cartList.get(position-1).getProduct_delivery());
            int day2 = Integer.parseInt(cartList.get(position).getProduct_delivery());
            if(day1==day2){
                holder.tv_delivery.setVisibility(View.GONE);
                holder.layout_line.setVisibility(View.GONE);
            } else {
                holder.tv_delivery.setVisibility(View.VISIBLE);
                holder.layout_line.setVisibility(View.VISIBLE);
            }
        }
        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cartList.get(position).setProduct_check(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }


    public List<Product> returnList(){
        return cartList;
    }

}
