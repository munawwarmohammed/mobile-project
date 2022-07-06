package com.example.myapplication.Service;

import java.net.URI;

public class RetrofitService {
    private Retrofit retrofit;



    public RetrofitService(){ initializerRetrofit();}

    private void initializerRetrofit(){
        retrofit= new Retrofit.Builder()
                .baseUrl("http://172.20.10.5:8080/api/Customer")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    public Retrofit getRetrofit(){ return retrofit;}

    private class Retrofit {
    }
}
