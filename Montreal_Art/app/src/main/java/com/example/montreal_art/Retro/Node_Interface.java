package com.example.montreal_art.Retro;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Node_Interface {
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(@Field("email") String email,
                                @Field("name") String name,
                                @Field("password") String password,
                                @Field("phone") String phone);
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(@Field("email") String email,
                             @Field("password") String password);
}
