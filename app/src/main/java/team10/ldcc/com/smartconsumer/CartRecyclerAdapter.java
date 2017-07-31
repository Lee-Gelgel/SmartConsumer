package team10.ldcc.com.smartconsumer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import team10.ldcc.com.smartconsumer.Data.Cart;



/**
 * Created by Gelgel on 2017. 5. 30..
 */
public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder> {
    private Context mContext;
    public List<Cart> cartList;

    public CartRecyclerAdapter(List<Cart> cartList, Context mContext) {
        this.cartList = cartList;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView price;
        public Button buy;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.item_img);
            name = (TextView) view.findViewById(R.id.item_name);
            price = (TextView) view.findViewById(R.id.item_price);
            buy = (Button) view.findViewById(R.id.btn_buy);
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
//        Glide.with(mContext).load(mContext.getResources().getString(R.string.baseURL) + productList.get(position).getImages())
//                .placeholder(R.drawable.no_image_product)
//                .into(holder.img);
//        holder.name.setText(productList.get(position).getProduct_name());
//        int price = Integer.parseInt(productList.get(position).getProduct_price());
//        holder.price.setText(StringUtil.changePrice(price) + "원");
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
        return cartList.size();
    }


}
