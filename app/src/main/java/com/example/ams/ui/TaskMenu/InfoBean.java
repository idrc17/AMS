package com.example.ams.ui.TaskMenu;

import java.util.List;

public class InfoBean {

    /**
     * result : true
     * obj : [{"MainId":1002,"InventoryName":"2020年第二季度审计盘点","StartDate":"2020-06-11T00:00:00Z","EndDate":"2020-06-12T00:00:00Z","CreateDate":"2020-06-11T21:15:23.087Z","CreateUser":"admin","UpdateDate":"2020-06-11T21:15:23.087Z","UpdateUser":"admin","Status":"新增","Remark":""},{"MainId":1002,"InventoryName":"2020年第二季度审计盘点","StartDate":"2020-06-11T00:00:00Z","EndDate":"2020-06-12T00:00:00Z","CreateDate":"2020-06-11T21:15:23.087Z","CreateUser":"admin","UpdateDate":"2020-06-11T21:15:23.087Z","UpdateUser":"admin","Status":"新增","Remark":""}]
     * msg :
     */

    private boolean result;
    private String msg;
    private List<ObjBean> obj;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * MainId : 1002
         * InventoryName : 2020年第二季度审计盘点
         * StartDate : 2020-06-11T00:00:00Z
         * EndDate : 2020-06-12T00:00:00Z
         * CreateDate : 2020-06-11T21:15:23.087Z
         * CreateUser : admin
         * UpdateDate : 2020-06-11T21:15:23.087Z
         * UpdateUser : admin
         * Status : 新增
         * Remark :
         */

        private int MainId;
        private String InventoryName;
        private String StartDate;
        private String EndDate;
        private String CreateDate;
        private String CreateUser;
        private String UpdateDate;
        private String UpdateUser;
        private String Status;
        private String Remark;

        public int getMainId() {
            return MainId;
        }

        public void setMainId(int MainId) {
            this.MainId = MainId;
        }

        public String getInventoryName() {
            return InventoryName;
        }

        public void setInventoryName(String InventoryName) {
            this.InventoryName = InventoryName;
        }

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String StartDate) {
            this.StartDate = StartDate;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getCreateUser() {
            return CreateUser;
        }

        public void setCreateUser(String CreateUser) {
            this.CreateUser = CreateUser;
        }

        public String getUpdateDate() {
            return UpdateDate;
        }

        public void setUpdateDate(String UpdateDate) {
            this.UpdateDate = UpdateDate;
        }

        public String getUpdateUser() {
            return UpdateUser;
        }

        public void setUpdateUser(String UpdateUser) {
            this.UpdateUser = UpdateUser;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }
    }
}
