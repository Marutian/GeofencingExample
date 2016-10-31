package com.marutian.qwer;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.bumptech.glide.Glide;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright 2016 Marutian. All rights reserved.
 *
 * @author Shin Gwangsu (maruroid@gmail.com)
 * @since 2016. 10. 31.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        RetrofitUtil.getRetrofit().create(Vita500Service.class).getVita500().enqueue(new Callback<Vita500>() {
            @Override
            public void onResponse(Call<Vita500> call, Response<Vita500> response) {
                //Vita500 data = response.body();  //응답결과를 받아와서 저장
                //Glide.with(MainActivity.this).load(data.img);  //이미지 불러오기
                //data.menuList.get(0).name;  //리스트가 있을 때 리스트 안 데이터 접근하기

            }

            @Override
            public void onFailure(Call<Vita500> call, Throwable t) {

            }
        });
    }
}
