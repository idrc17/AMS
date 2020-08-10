package com.example.ams.ui.Check;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ams.R;
import com.example.ams.mannage.App;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class CheckActivity extends AppCompatActivity  {

    private  String username;
    private  String taskID;
    private  String url;
    private  String remark;
    private  String taskname;
    public List<Beaninfo.ObjBean> beanList;
    private Beaninfo.ObjBean mbean;//

    private  String JsoncheckResultDataList;//


    //加载app对象
    private App myApplication=(App) getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        //控件
        final TextView task_name=findViewById(R.id.tv_task_name);//任务名称

        final ImageButton geterror=findViewById(R.id.ibtn_error);//设备报错按钮
        final EditText input_error = findViewById(R.id.textinput_error);//错误内容输入框
        final Button seterror=findViewById(R.id.btn_error);//提交错误信息按钮

        final ImageView close = findViewById(R.id.btn_close);//返回按钮
        final ImageButton correct=findViewById(R.id.btn_correct);//确认无误按钮

        final EditText editText = findViewById(R.id.ext_code);//扫描条码输入框

//        final TextView AssetCode =findViewById(R.id.AssetCode);
//        final TextView AssetName =findViewById(R.id.AssetName);
//        final TextView AssetModel =findViewById(R.id.AssetModel);
//        final TextView CostCenter =findViewById(R.id.CostCenter);
//        final TextView Status =findViewById(R.id.Status);
//        final TextView AssetDate =findViewById(R.id.AssetDate);

        //设备数据内容
        final TextView AssetCode_Value =findViewById(R.id.AssetCode_Value);
        final TextView AssetNameValue =findViewById(R.id.AssetName_Value);
        final TextView AssetModel_Value =findViewById(R.id.AssetModel_Value);
        final TextView CostCenter_Value =findViewById(R.id.CostCenter_Value);
        final TextView Status_Value =findViewById(R.id.Status_Value);
        final TextView AssetDate_Value =findViewById(R.id.AssetDate_Value);

        //默认不显示
        seterror.setVisibility(View.INVISIBLE);
        input_error.setVisibility(View.INVISIBLE);


        //获取用户名
        Intent intent=getIntent();
        username=intent.getStringExtra("Username");
        taskID=intent.getStringExtra("Task_ID");
        taskname=intent.getStringExtra("Task_NAME");
        task_name.setText(taskname);

        url="http://10.33.230.211:8080/api/app/taskDetails/?taskid="+taskID;

//        OkGo.getInstance().init(this.getApplication());

        initData(username,taskID);

        //返回
        close.setOnClickListener(new View.OnClickListener() {
            private AlertDialog.Builder builder;
            @Override
            public void onClick(View v) {
                error();

                return;
            }
            private void error(){
                builder = new AlertDialog.Builder(CheckActivity.this);
                builder.setIcon(R.mipmap.error);
                builder.setTitle("提示！");
                builder.setMessage("当前任务仍未完成，是否确认退出？");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(JsoncheckResultDataList!=null){
                            //保存当前已扫描的数据
                            PostResultDataWithHttpURLConnectionV2();
                        }

                        //退出
                        CheckActivity.this.finish();
                        return;
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo:
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });


//        //设备报错
//        error.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                clear();
//                input_error.setVisibility(View.VISIBLE);
//                CheckOK.setVisibility(View.VISIBLE);
////                Toast.makeText(CheckActivity.this, "已清空！", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        });


//        //查看列表
//        taskview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("Task_ID",String.valueOf(taskID));
//                intent.setClass(CheckActivity.this, TaskviewActivity.class);//从哪里跳到哪里
//                CheckActivity.this.startActivity(intent);
//
//            }
//        });

        //任务提交
        input_error.setOnClickListener(new View.OnClickListener() {
            private AlertDialog.Builder builder;
            @Override
            public void onClick(View v) {
                switch (1){
                    case 1:
                        task_finsh();
                        break;
                    default:

                }
            }

            //任务提交方法
            private void task_finsh(){
                builder = new AlertDialog.Builder(CheckActivity.this);
                builder.setIcon(R.mipmap.mention);
                builder.setTitle("提示！");
                builder.setMessage(getString(R.string.task_dialog_finish));
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //上传任务结果
                        if(JsoncheckResultDataList!=null){
                            //保存当前已扫描的数据
                            PostResultDataWithHttpURLConnectionV2();
                            CheckActivity.this.finish();
                        }
                        else{
                            Toast.makeText(CheckActivity.this, "请先扫描巡检设备再做提交！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo:
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }


        });



        //回车事件
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER){
                    String msg="";
                    String str = editText.getText().toString();

                    int i;
                    for( i=0;i<beanList.size();i++)
                    {
                        mbean=beanList.get(i);
                        boolean e=(mbean.getAssetCode().equals(str));
                        if(e)
                        {
                            remark=mbean.getAssetCode();

                            AssetCode_Value.setText(mbean.getAssetCode());
                            AssetNameValue.setText(mbean.getAssetName());
                            AssetModel_Value.setText(mbean.getModel());
                            CostCenter_Value.setText(mbean.getCostCenter());
                            Status_Value.setText(mbean.getStatus());
                            AssetDate_Value.setText(mbean.getAssetDate());


                            AssetCode_Value.setVisibility(View.VISIBLE);
                            AssetNameValue.setVisibility(View.VISIBLE);
                            AssetModel_Value.setVisibility(View.VISIBLE);
                            CostCenter_Value.setVisibility(View.VISIBLE);
                            Status_Value.setVisibility(View.VISIBLE);
                            AssetDate_Value.setVisibility(View.VISIBLE);
                            break;
                        }
                        if(i==(beanList.size()-1))
                        {
                            msg="当前任务中无此条码！";
                            Toast.makeText(CheckActivity.this, msg, Toast.LENGTH_SHORT).show();
                            editText.setText("");
                            editText.requestFocus();
                        }}
                    return true; } return false; }});



        //提交报错
        geterror.setOnClickListener(new View.OnClickListener() {

            private AlertDialog.Builder builder;
            @Override
            public void onClick(View v) {
                error();
                return;
            }
            private void error(){
                builder = new AlertDialog.Builder(CheckActivity.this);
                builder.setIcon(R.mipmap.error);
                builder.setTitle("提示！");
                builder.setMessage("是否确认报错？");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //
                        SetData("设备报错,需要复查！");
                        Toast.makeText(CheckActivity.this, "已记录！", Toast.LENGTH_SHORT).show();

                        AssetCode_Value.setVisibility(View.INVISIBLE);
                        AssetNameValue.setVisibility(View.INVISIBLE);
                        AssetModel_Value.setVisibility(View.INVISIBLE);
                        CostCenter_Value.setVisibility(View.INVISIBLE);
                        Status_Value.setVisibility(View.INVISIBLE);
                        AssetDate_Value.setVisibility(View.INVISIBLE);

                        editText.setText("");
                        editText.requestFocus();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo:
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }


    //数据保存
    private void SetData(String Remark) {

        CheckResultData checkResultData=new CheckResultData();
        checkResultData.setSubId(mbean.getSubId());//改成subid
        checkResultData.setInventoryUserName(username);
        checkResultData.setInventoryRemark(remark+Remark);//可以加上日期

        myApplication.listcheckResultData.add(checkResultData);//保存到app数据中

        Gson gson=new Gson();
//        JsoncheckResultDataList=gson.toJson(checkResultDataList);
    }


    //上传检测结果
    private void PostResultDataWithHttpURLConnectionV2() {
        OkGo.<String>
                post("http://10.33.230.211:8080/api/app/uploadResult/?taskId=1")

//                .params("password", "123456")
                .upJson(JsoncheckResultDataList)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
//                      Persion p  = GosnUtils.parse2Bean(json, Peraion.class);
                        Toast.makeText(CheckActivity.this, json, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //加载数据
    private void initData(String username,String taskID) {
        sendRequestWithHttpURLConnectionV2(username,taskID);
    }


    //加载数据url
    private void sendRequestWithHttpURLConnectionV2(String username,String taskID) {

        OkGo.<String>

                get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        //转成
                        parseJson2InfoBean(json);
//                        Toast.makeText(CheckActivity.this, json, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //数据解析
    private void parseJson2InfoBean(String json) {
        Beaninfo beaninfo = new Gson().fromJson(json, Beaninfo.class);
        if (beaninfo.isResult()) {
            beanList = beaninfo.getObj();//获取到的list对象
            //taskMenuAdapter.replaceData(beanList);
        }
    }


  }


