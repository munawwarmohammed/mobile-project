package com.example.myapplication.Service;





import com.example.myapplication.model.Customer;

public interface CustomerApi {
    @POST("/api/Customer")
    Call<Customer> save(@Body Customer customer);
}
