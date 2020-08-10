package com.example.ams.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ams.R;
import com.example.ams.ui.TaskMenu.TaskMenuActivity;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class LoginActivity extends AppCompatActivity {

//    private LoginViewModel loginViewModel;

    private String username;
    private String password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);

        //控件引用
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);


        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        OkGo.getInstance().init(this.getApplication());

        //登录监听器
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //访问url
                username=usernameEditText.getText()+"";
                password=passwordEditText.getText()+"";
                //Toast.makeText(LoginActivity.this, "网络开小差了，请稍后重试。", Toast.LENGTH_SHORT).show();
                OkGo.<String>get("http://10.33.230.211:8080/api/app/login/?usercode="+username+"&password="+password)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                String json = response.body();
                                parseJson2InfoBean(json);
                                //转成
                                return;
                            }

                            @Override
                            public void onError(Response<String> response) {
                                super.onError(response);
                                Toast.makeText(LoginActivity.this, "网络开小差了，请稍后重试。", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void parseJson2InfoBean(String json) {
        Loginbean loginbean = new Gson().fromJson(json, Loginbean.class);
        if (loginbean.isResult()) {

            //跳转传参
            Intent intent=new Intent();
            intent.putExtra("Username",username);//设置参数,""
            intent.setClass(LoginActivity.this, TaskMenuActivity.class);//从哪里跳到哪里
            LoginActivity.this.startActivity(intent);

            Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(LoginActivity.this, "访问不成功，请输出正确的用户名和密码！", Toast.LENGTH_SHORT).show();
        }
    }
}







//
//    }
//    //UI跳转
//    private void updateUiWithUser(LoggedInUserView model) {
//        String welcome = getString(R.string.welcome);
//        // TODO : initiate successful logged in experience
//        Intent intent = new Intent(LoginActivity.this, TaskMenuActivity.class);
//        startActivity(intent);
//        //Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//    }
//
//    //失败后报错
//    private void showLoginFailed(@StringRes Integer errorString) {
//        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();

