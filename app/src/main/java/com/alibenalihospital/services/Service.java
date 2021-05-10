package com.alibenalihospital.services;

import com.alibenalihospital.models.NotificationDataModel;
import com.alibenalihospital.models.PlaceGeocodeData;
import com.alibenalihospital.models.PlaceMapDetailsData;
import com.alibenalihospital.models.SliderDataModel;
import com.alibenalihospital.models.SettingModel;
import com.alibenalihospital.models.StatusResponse;
import com.alibenalihospital.models.UserModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Service {

    @GET("place/findplacefromtext/json")
    Call<PlaceMapDetailsData> searchOnMap(@Query(value = "inputtype") String inputtype,
                                          @Query(value = "input") String input,
                                          @Query(value = "fields") String fields,
                                          @Query(value = "language") String language,
                                          @Query(value = "key") String key
    );

    @GET("geocode/json")
    Call<PlaceGeocodeData> getGeoData(@Query(value = "latlng") String latlng,
                                      @Query(value = "language") String language,
                                      @Query(value = "key") String key);

    @FormUrlEncoded
    @POST("api/client-login")
    Call<UserModel> login(@Field("phone_code") String phone_code,
                          @Field("phone") String phone,
                          @Field("password") String password

    );


    @FormUrlEncoded
    @POST("api/client-register")
    Call<UserModel> signUpWithoutImage(@Field("name") String name,
                                       @Field("phone_code") String phone_code,
                                       @Field("phone") String phone,
                                       @Field("password") String password,
                                       @Field("gender") String gender,
                                       @Field("birthday") String birthday,
                                       @Field("software_type") String software_type
    );

    @Multipart
    @POST("api/client-register")
    Call<UserModel> signUpWithImage(@Part("name") RequestBody name,
                                    @Part("phone_code") RequestBody phone_code,
                                    @Part("phone") RequestBody phone,
                                    @Part("password") RequestBody password,
                                    @Part("gender") RequestBody gender,
                                    @Part("birthday") RequestBody birthday,
                                    @Part("software_type") RequestBody software_type,
                                    @Part MultipartBody.Part logo


    );




}