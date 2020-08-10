package com.example.ams.ui.TaskView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ams.R;
import com.example.ams.ui.Check.Beaninfo;
import com.example.ams.ui.Check.CheckActivity;
import com.example.ams.ui.Check.CheckResultData;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class TaskviewActivity extends AppCompatActivity {

    ///////////////

    private List<Beaninfo.ObjBean> mBeanList;
    private TaskViewAdapter taskViewAdapter;
    private String username;
    private String taskID;
    private String taskname;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView rvMain;
    private String url;
    public List<String> LNID;

    public List<CheckResultData> listcheckResultData=new ArrayList<CheckResultData>();//加载任务明细页面时，新建结果。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskview);


        final ImageView close = findViewById(R.id.return_back);

//        setContentView(R.layout.activity_taskmenu_item);

        //获取用户名
        Intent intent=getIntent();
        username=intent.getStringExtra("Username");
        taskID=intent.getStringExtra("Task_ID");
        taskname=intent.getStringExtra("Task_NAME");

        url="http://10.33.230.211:8080/api/app/taskDetails/?taskid="+taskID;


        //初始化
        OkGo.getInstance().init(this.getApplication());
        initView();
        initData();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskviewActivity.this.finish();

            }
        });

        //页面跳转
        taskViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //Toast.makeText(TaskMenuActivity.this, position, Toast.LENGTH_SHORT).show();

                Beaninfo.ObjBean objBean=mBeanList.get(position);

                Intent intent = new Intent();
                intent.putExtra("Username", username);//登录名
                //intent.putExtra("Task_ID",objBean.getMainId().toString());//任务ID

                intent.putExtra("Task_ID",String.valueOf(objBean.getMainId()));
                intent.putExtra("Task_NAME",taskname);

                intent.setClass(TaskviewActivity.this, CheckActivity.class);//从哪里跳到哪里
                TaskviewActivity.this.startActivity(intent);
            }
        });
    }




    //加载数据
    private void initData() {
        sendRequestWithHttpURLConnectionV2();
    }


    //访问url
    private void sendRequestWithHttpURLConnectionV2() {
        OkGo.<String>get(url)

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        //转成
                        parseJson2Beaninfo(json);
                        //Toast.makeText(TaskMenuActivity.this, json, Toast.LENGTH_LONG).show();
                    }
                });
    }

    //数据解析
    private void parseJson2Beaninfo(String json) {
        Beaninfo infoBean = new Gson().fromJson(json, Beaninfo.class);
        if (infoBean.isResult()) {
            mBeanList = infoBean.getObj();

            taskViewAdapter.replaceData(mBeanList);
        }
    }


    //界面展示
    private void initView() {
        rvMain = findViewById(R.id.Rv_taskview);
        rvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        taskViewAdapter = new TaskViewAdapter(R.layout.item_taskview, null);
        taskViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(TaskviewActivity.this, mBeanList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        rvMain.setAdapter(taskViewAdapter);
    }
}
