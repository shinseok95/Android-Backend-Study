package com.example.retrofit2example;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit.APIInterface;
import retrofit.HttpClient;
import retrofit.ReqLoginData;
import retrofit.ResLoginData;
import retrofit.ResUsersData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIInterface api;

    Button getBtn;
    Button postBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        getBtn = findViewById(R.id.btnGet);
        postBtn = findViewById(R.id.btnPost);
        resultText = findViewById(R.id.txtResult);

        api =HttpClient.getRetrofit().create(APIInterface.class);
    }


    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnGet:
                resultText.setText("");
                requestGet();
                break;

            case R.id.btnPost:
                resultText.setText("");
                requestPost();
                break;

        }
    }

    // POST 통신요청
     public void requestPost() {
         ReqLoginData reqLoginData = new ReqLoginData("eve.holt@reqres.in", "cityslicka");
         Call<ResLoginData> call = api.requestPostLogin(reqLoginData);

         // 비동기로 백그라운드 스레드로 동작 (네트워크 응답이 느리기 때문에 비동기 적용)
         call.enqueue(new Callback<ResLoginData>() {

             // 응답 성공시
             @Override
             public void onResponse(Call<ResLoginData> call, Response<ResLoginData> response) {
                 resultText.setText(response.body().toString());
             }

             @Override
             public void onFailure(Call<ResLoginData> call, Throwable t) {
                 resultText.setText("onFailure");
             }
         });
     }
       //
       public void requestGet(){
           Call<ResUsersData> call = api.requestGetUsersDetail("2");

           call.enqueue(new Callback<ResUsersData>() {
               @Override
               public void onResponse(Call<ResUsersData> call, Response<ResUsersData> response) {
                   resultText.setText(response.body().toString());
               }

               @Override
               public void onFailure(Call<ResUsersData> call, Throwable t) {
                    resultText.setText("onFailure");
               }
           });
       }

}
