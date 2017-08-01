package team10.ldcc.com.smartconsumer;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team10.ldcc.com.smartconsumer.Data.Cart;
import team10.ldcc.com.smartconsumer.Data.Product;
import team10.ldcc.com.smartconsumer.common.StringUtil;
import team10.ldcc.com.smartconsumer.retrofitService.NetworkService;


/**
 * Created by Gelgel on 2017. 5. 30..
 */
public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder> {
    private Context mContext;
    public List<Product> productList;
    private ApplicationController application;
    private DatePickerDialog dialogDatePicker;
    private DialogProducDelivery dialogProducDelivery;
    private DialogProducDelivery2 dialogProducDelivery2;
    private NetworkService networkService;
    private DialogProductNumberPicker dialogProductNumberPicker;
    private int itemNum = 0;
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
        private TextView item_weight;
        private TextView textview_count;
        private LinearLayout layout_count;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.item_img);
            name = (TextView) view.findViewById(R.id.item_name);
            price = (TextView) view.findViewById(R.id.item_price);
            cart = (ImageView) view.findViewById(R.id.btn_buy);
            image_medal = (ImageView) view.findViewById(R.id.image_medal);
            layout_count = (LinearLayout) view.findViewById(R.id.layout_count);
            textview_count = (TextView) view.findViewById(R.id.textview_count);
            item_weight = (TextView) view.findViewById(R.id.item_weight);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        application = ApplicationController.getInstance();
        application.buildNetworkService();
        networkService = ApplicationController.getInstance().getContentService();
        ViewHolder vh;
        View v = LayoutInflater.from(mContext).inflate(R.layout.product_item, parent, false);
        vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(mContext).load(mContext.getResources().getString(R.string.baseURL) + productList.get(position).getProduct_image())
                .placeholder(0)
                .into(holder.img);
        holder.name.setText(productList.get(position).getProduct_name());
        int price = Integer.parseInt(productList.get(position).getProduct_price());
        holder.price.setText(StringUtil.changePrice(price));
        holder.layout_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogProductNumberPicker = new DialogProductNumberPicker(mContext, btnOk);
                dialogProductNumberPicker.show();
                itemNum = position;
            }
        });
        holder.item_weight.setText(productList.get(position).getProductBase_weight());
        holder.textview_count.setText(productList.get(position).getProduct_count() == null ? "1" : productList.get(position).getProduct_count());
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemNum = position;
//                dialogProducDelivery = new DialogProducDelivery(mContext);
//                dialogProducDelivery.show();
                dialogProducDelivery2 = new DialogProducDelivery2(mContext,btnDelivery);
                dialogProducDelivery2.show();

//                dialogDatePicker = new DatePickerDialog(mContext, listener, 2017, 6, 31);
//                dialogDatePicker.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
//                dialogDatePicker.show();
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
//        }

        switch(position){
            case 0:
                holder.image_medal.setVisibility(View.VISIBLE);
                holder.image_medal.setImageResource(R.drawable.first);
                break;
            case 1:
                holder.image_medal.setVisibility(View.VISIBLE);
                holder.image_medal.setImageResource(R.drawable.second);
                break;
            case 2:
                holder.image_medal.setVisibility(View.VISIBLE);
                holder.image_medal.setImageResource(R.drawable.third);
                break;
            default:
                holder.image_medal.setVisibility(View.GONE);
                break;
        }
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

    View.OnClickListener btnOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("abc", "btnOk_" + dialogProductNumberPicker.setNumber());
            productList.get(itemNum).setProduct_count("" + dialogProductNumberPicker.setNumber());
            notifyDataSetChanged();
            dialogProductNumberPicker.dismiss();
        }
    };

    View.OnClickListener btnDelivery = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String delivery = dialogProducDelivery2.getDelivery();
            Log.e("abccc","abcc"+delivery);
            addCart(delivery);
        }
    };

    public void addCart(String delivery){
        Cart cart = new Cart();
        Log.e("abcde",""+productList.get(itemNum));
        cart.setUser_code(ApplicationController.getInstance().getUser().getUser_code());
        cart.setProductDetail_code(productList.get(itemNum).getProductDetail_code());
        cart.setCart_count(null==productList.get(itemNum).getProduct_count()?""+
                1:productList.get(itemNum).getProduct_count());
        cart.setCart_delivery(delivery);

        Log.e("abc",""+cart.toString());
        Call<Cart> call = networkService.addCart(cart);

        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if(response.isSuccessful()){
                    productList.get(itemNum).setProduct_count("1");
                    notifyDataSetChanged();
                    dialogProducDelivery2.dismiss();
                    Toast.makeText(mContext, "장바구니에 담았습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Log.e("error", "서버 onFailure : " + t.getMessage());
            }
        });
    }

}
