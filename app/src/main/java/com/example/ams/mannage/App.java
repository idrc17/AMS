package com.example.ams.mannage;

import android.app.Application;

import com.example.ams.ui.Check.CheckResultData;
import com.lzy.okgo.OkGo;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    public List<CheckResultData> listcheckResultData=new ArrayList<CheckResultData>();//
    private String username;//用户名

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
        LitePal.initialize(this);


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
