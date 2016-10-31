package com.marutian.qwer;

import retrofit2.Call;
import retrofit2.http.*;

public interface Vita500Service {

  @GET("vita500")
  Call<Vita500> getVita500();

}