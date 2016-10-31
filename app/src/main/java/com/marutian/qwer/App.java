package com.marutian.qwer;

import android.app.Application;

/**
 * Copyright 2016 Marutian. All rights reserved.
 *
 * @author Shin Gwangsu (maruroid@gmail.com)
 * @since 2016. 10. 31.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitUtil.initRetrofit();  //반드시 해줘야 함
    }
}
