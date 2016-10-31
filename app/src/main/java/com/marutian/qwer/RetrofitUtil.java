package com.marutian.qwer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright 2016 Marutian. All rights reserved.
 *
 * @author Shin Gwangsu (maruroid@gmail.com)
 * @since 2016. 10. 31.
 */
public class RetrofitUtil {

    static Retrofit mRetrofit;

    public static void initRetrofit(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofit(){
        return mRetrofit;
    }
}
