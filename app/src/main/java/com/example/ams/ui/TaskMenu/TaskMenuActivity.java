package com.example.ams.ui.TaskMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ams.R;
import com.example.ams.ui.TaskView.TaskviewActivity;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class TaskMenuActivity extends AppCompatActivity {

    ///////////////

    private List<InfoBean.ObjBean> mBeanList;
    private TaskMenuAdapter taskMenuAdapter;
    private String username;
    private Integer TaskID;
    private LinearLayoutManager linearLayoutManager;
    private  RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_menu);
//        setContentView(R.layout.activity_taskmenu_item);

        //获取用户名
        Intent intent = getIntent();
        username = intent.getStringExtra("Username");


        //初始化
        OkGo.getInstance().init(this.getApplication());
        initView();
        initData();

        //页面跳转
        taskMenuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


                //Toast.makeText(TaskMenuActivity.this, position, Toast.LENGTH_SHORT).show();

                InfoBean.ObjBean objBean=mBeanList.get(position);

                Intent intent = new Intent();
                intent.putExtra("Username", username);//登录名
                //intent.putExtra("Task_ID",objBean.getMainId().toString());//任务ID
                intent.putExtra("Task_ID",String.valueOf(objBean.getMainId()));
                intent.putExtra("Task_NAME", objBean.getInventoryName());//名称

                intent.setClass(TaskMenuActivity.this, TaskviewActivity.class);//从哪里跳到哪里

                TaskMenuActivity.this.startActivity(intent);
            }
        });
    }



    //加载数据
    private void initData() {
        sendRequestWithHttpURLConnectionV2();
    }


    //访问url
    private void sendRequestWithHttpURLConnectionV2() {
        OkGo.<String>get("http://10.33.230.211:8080/api/app/alltasks")
                //post("http://10.33.230.211:8080/api/app/alltasks")
//                .params("name", "lizhenwei")
//                .params("password", "123456")
                //.upJson("{}")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        //转成
                        parseJson2InfoBean(json);
                        //Toast.makeText(TaskMenuActivity.this, json, Toast.LENGTH_LONG).show();
                    }
                });
    }

    //数据解析
    private void parseJson2InfoBean(String json) {
        InfoBean infoBean = new Gson().fromJson(json, InfoBean.class);
        if (infoBean.isResult()) {
            mBeanList = infoBean.getObj();
            taskMenuAdapter.replaceData(mBeanList);
        }
    }


    //界面展示
    private void initView() {
        rvMain = findViewById(R.id.Rv_TM);
        rvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        taskMenuAdapter = new TaskMenuAdapter(R.layout.activity_taskmenu_item, null);
        taskMenuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(TaskMenuActivity.this, mBeanList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        rvMain.setAdapter(taskMenuAdapter);
    }
}
