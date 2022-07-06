package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Service.CustomerApi;
import com.example.myapplication.Service.RetrofitService;
import com.example.myapplication.model.Customer;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.callback.Callback;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 initializer();
    }

    public void initializer(){
        Spinner flower, gifty;
        EditText first,last, phone, cityy;
        Button submit;

        flower= (Spinner) findViewById(R.id.FLOWERS);
        gifty =(Spinner) findViewById(R.id.GIFT);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,
                R.array.FLOWERSLIST, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        flower.setAdapter(adapter);

        ArrayAdapter<CharSequence> main = ArrayAdapter.createFromResource( this,
                R.array.GIFTLIST, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        gifty.setAdapter(main);


        first=findviewById(R.id.first);
         last = findviewById(R.id.last);
        phone = findviewById(R.id.phone);
        cityy=findviewById(R.id.cityy);
        submit=(Button)findviewById(R.id.submit);

        RetrofitService retrofitService = new RetrofitService();
        CustomerApi customerApi = retrofitService.getRetrofit().create(CustomerApi.class);
        submit.setOnClickListener(view->{
            String first_name=String.valueOf(first_name.getText());
            String last_name=String.valueOf(last_name.getText());
            int phone_number=String.valueOf(phone_number.getText());
            String city=String.valueOf(city.getText());
            String flowers= flower.getSelectedItem().toString();
            String gift = gifty.getSelectedItem().toString();
            Customer customer=new Customer();

            customer.setfirst_name(first_name);
            customer.setlast_name(last_name);
            customer.setphone_number(phone_number);
            customer.setcity(city);
            customer.setflowers(flowers);
            customer.setgift(gift);


            customerApi.save(customer)
                    .enqueue(new Callback<Customer>(){
                        @Override
                        public  void  onResponse(Call<Customer>call, Response<Customer> response){
                            Toast.makeText(MainActivity.this, "Save succesful!", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<Customer>call, Throwable t){
                            Toast.makeText(MainActivity.this, "Sae failed!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);
                        }
                    });


        });

    }



}