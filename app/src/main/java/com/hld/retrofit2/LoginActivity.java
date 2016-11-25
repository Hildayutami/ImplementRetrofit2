package com.hld.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;

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
            Toast.makeText(LoginActivity.this, "toast", Toast.LENGTH_SHORT).show();
        }
    };


}
