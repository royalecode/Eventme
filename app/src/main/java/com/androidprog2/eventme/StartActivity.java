package com.androidprog2.eventme;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.androidprog2.eventme.Persistance.API.APIConnector;
import com.androidprog2.eventme.Persistance.API.UserDAO;
import com.androidprog2.eventme.business.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        createUser(new User(0, "https://ichef.bbci.co.uk/news/800/cpsprodpb/F1F2/production/_118283916_b19c5a1f-162b-410b-8169-f58f0d153752.jpg", "david2", "Marquet2", "test2@hotmail.com", "david123"));
    }

    private void createUser(User user) {
        Retrofit retrofit = APIConnector.getRetrofitInstance();
        UserDAO userDAO = retrofit.create(UserDAO.class);
        Call<User> call = userDAO.createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                switch (response.code()) {
                    case 400:
                        break;
                    case 201:
                        break;
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }
}