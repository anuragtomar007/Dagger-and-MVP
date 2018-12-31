package com.example.dell.flexydriver.Networking;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface LoginAPIInterface {
    @FormUrlEncoded
    @Headers("language:en")
    @POST("/driver/signIn")
    void signInFlexy(@Field("countryCode") String counrtryCode,
                     @Field("mobile") String mobile,
                     @Field("password") String password,
                     @Field("deviceId") String deviceId,
                     @Field("pushToken") String pushToken,
                     @Field("appVersion") String version,
                     @Field("deviceMake") String deviceMake,
                     @Field("deviceModel") String deviceModel,
                     @Field("deviceType") int deviceType,
                     @Field("deviceTime") String deviceTime,
                     @Field("deviceOsVersion") int deviceOsVersion,
                     Callback<FlexyData> callback);
}