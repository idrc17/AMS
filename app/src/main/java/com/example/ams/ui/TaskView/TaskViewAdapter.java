package com.example.ams.ui.TaskView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ams.R;
import com.example.ams.ui.Check.Beaninfo;

import java.util.List;


public class TaskViewAdapter extends BaseQuickAdapter<Beaninfo.ObjBean, BaseViewHolder> {

    public TaskViewAdapter(int layoutResId, @Nullable List<Beaninfo.ObjBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, Beaninfo.ObjBean bean) {
        //baseViewHolder.setText(android.R.id.tv_value_taskname, bean.getInventoryName());
        baseViewHolder
                .setText(R.id.tv_value_thingsname, bean.getAssetName())
                .setText(R.id.tv_value_thingscode, bean.getAssetCode())
                .setText(R.id.tv_value_thingstime, bean.getAssetDate())

        ;

    }

}