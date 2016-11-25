package com.hld.retrofit2.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hld.retrofit2.R;
import com.hld.retrofit2.model.request.LoginRequestModel;
import com.hld.retrofit2.model.response.LoginResponseModel;
import com.hld.retrofit2.network.ApiRestClient;
import com.hld.retrofit2.ui.main.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private ApiRestClient apiRestClient = new ApiRestClient(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.activity_login_btn_login);
        usernameEditText = (EditText) findViewById(R.id.activity_login_et_username);
        passwordEditText = (EditText) findViewById(R.id.activity_login_et_password);

        loginButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO: 25/11/2016 login here
            login();
        }
    };

    private void login() {
        LoginRequestModel requestModel = new LoginRequestModel();
        requestModel.setUsername(usernameEditText.getText().toString());
        requestModel.setPassword(passwordEditText.getText().toString());
        requestModel.setPushbots_token("234567890");

        apiRestClient.getService().login(requestModel).enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                LoginResponseModel responseModel = response.body();

                // TODO: 25/11/2016 Simpan token di sharedprefence
                if (responseModel.isError()) {
                    Log.d("error message", responseModel.getMessage());
                } else {
                    SharedPreferences preferences = getSharedPreferences("savetoken", 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("token", "Bearer " + responseModel.getToken());

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    //Log.d("token", responseModel.getToken());
                }
            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Log.e("errror", t.getLocalizedMessage());
            }
        });
    }


}
