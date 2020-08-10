package com.example.ams.ui.TaskMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ams.R;

import java.util.List;


public class TaskMenuAdapter extends BaseQuickAdapter<InfoBean.ObjBean, BaseViewHolder> {

    public TaskMenuAdapter(int layoutResId, @Nullable List<InfoBean.ObjBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, InfoBean.ObjBean bean) {
        //baseViewHolder.setText(android.R.id.tv_value_taskname, bean.getInventoryName());
        baseViewHolder
                .setText(R.id.tv_value_taskname, bean.getInventoryName())
                .setText(R.id.tv_value_creator, "备注信息:"+bean.getRemark())
                .setText(R.id.tv_value_time, "开始时间:"+bean.getStartDate())
                .setText(R.id.tv_value_endtime, "结束时间:"+bean.getEndDate())
                .setText(R.id.tv_value_state, String.valueOf(bean.getMainId())

                );

    }

}