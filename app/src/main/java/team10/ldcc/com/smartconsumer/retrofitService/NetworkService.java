package team10.ldcc.com.smartconsumer.retrofitService;





import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import team10.ldcc.com.smartconsumer.Data.Cart;
import team10.ldcc.com.smartconsumer.Data.Product;
import team10.ldcc.com.smartconsumer.Data.User;


/**
 * Created by Gelgel on 2017. 5. 30..
 */
public interface NetworkService {


    @POST("/cart/insertProd")
    Call<Cart> addCart(@Body Cart cart);


    @GET("/user/email/{email}")
    Call<User> emailCheck(@Path("email") String email);

    @POST("/user/login")
    Call<User> loginUser(@Body User user);

    @POST("/user/register")
    Call<User> registerUser(@Body User user);

    @POST("/user/detail")
    Call<User> userDetail(@Body User user);

    @GET("/product/barcodeScanner/{barcode}/{shop_code}")
    Call<Product> barcodeScanner(@Path("barcode") String barcode, @Path("shop_code") String shop_code);

    @POST("/product/selectTop10")
    Call<List<Product>> selectTop10();


    /*@POST("/member/insert")
    Call<Member> insertMember(@Body Member member);

    @POST("/member/update")
    Call<Member> updateMember(@Body Member member);

    @GET("/member/delete/{id}")
    Call<Member> deleteMember(@Path("id") int id);



    @POST("/member/login")
    Call<Member> loginMember(@Body Member member);

    @GET("/product/{id}")
    Call<List<Product>> getProductList(@Path("id") int id);

    @GET("/product/{id}/{company}")
    Call<List<Product>> getProductListbyCompany(@Path("id") int id, @Path("company") int company);*/
}
