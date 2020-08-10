package com.example.ams.ui.Check;

import java.util.List;

public class Beaninfo {


    /**
     * result : true
     * obj : [{"MainId":2010,"SubId":1139,"AssetCode":"130000016199","AssetName":"笔记本电脑I5-8250","Model":"","CostCenter":"3","CostCenterName":null,"AssetDate":"2019-06-11T00:00:00Z","OriginalValue":8078.77,"NetValue":0,"ServiceLife":5,"Position":"","Serial":"","Source":"零购","Status":"新增","AssetType":"固定资产-通用设备"},{"MainId":2010,"SubId":1140,"AssetCode":"130000016200","AssetName":"笔记本电脑I5-8250","Model":"","CostCenter":"3","CostCenterName":null,"AssetDate":"2019-06-11T00:00:00Z","OriginalValue":8078.77,"NetValue":0,"ServiceLife":5,"Position":"","Serial":"","Source":"零购","Status":"新增","AssetType":"固定资产-通用设备"},{"MainId":2010,"SubId":1141,"AssetCode":"130000016202","AssetName":"笔记本电脑I5-8250","Model":"","CostCenter":"3","CostCenterName":null,"AssetDate":"2019-06-11T00:00:00Z","OriginalValue":8078.77,"NetValue":0,"ServiceLife":5,"Position":"","Serial":"","Source":"零购","Status":"新增","AssetType":"固定资产-通用设备"}]
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
         * MainId : 2010
         * SubId : 1139
         * AssetCode : 130000016199
         * AssetName : 笔记本电脑I5-8250
         * Model :
         * CostCenter : 3
         * CostCenterName : null
         * AssetDate : 2019-06-11T00:00:00Z
         * OriginalValue : 8078.77
         * NetValue : 0
         * ServiceLife : 5
         * Position :
         * Serial :
         * Source : 零购
         * Status : 新增
         * AssetType : 固定资产-通用设备
         */

        private int MainId;
        private int SubId;
        private String AssetCode;
        private String AssetName;
        private String Model;
        private String CostCenter;
        private Object CostCenterName;
        private String AssetDate;
        private double OriginalValue;
        private double NetValue;
        private double ServiceLife;
        private String Position;
        private String Serial;
        private String Source;
        private String Status;
        private String AssetType;

        public int getMainId() {
            return MainId;
        }

        public void setMainId(int MainId) {
            this.MainId = MainId;
        }

        public int getSubId() {
            return SubId;
        }

        public void setSubId(int SubId) {
            this.SubId = SubId;
        }

        public String getAssetCode() {
            return AssetCode;
        }

        public void setAssetCode(String AssetCode) {
            this.AssetCode = AssetCode;
        }

        public String getAssetName() {
            return AssetName;
        }

        public void setAssetName(String AssetName) {
            this.AssetName = AssetName;
        }

        public String getModel() {
            return Model;
        }

        public void setModel(String Model) {
            this.Model = Model;
        }

        public String getCostCenter() {
            return CostCenter;
        }

        public void setCostCenter(String CostCenter) {
            this.CostCenter = CostCenter;
        }

        public Object getCostCenterName() {
            return CostCenterName;
        }

        public void setCostCenterName(Object CostCenterName) {
            this.CostCenterName = CostCenterName;
        }

        public String getAssetDate() {
            return AssetDate;
        }

        public void setAssetDate(String AssetDate) {
            this.AssetDate = AssetDate;
        }

        public double getOriginalValue() {
            return OriginalValue;
        }

        public void setOriginalValue(double OriginalValue) {
            this.OriginalValue = OriginalValue;
        }

        public double getNetValue() {
            return NetValue;
        }

        public void setNetValue(double NetValue) {
            this.NetValue = NetValue;
        }

        public double getServiceLife() {
            return ServiceLife;
        }

        public void setServiceLife(double ServiceLife) {
            this.ServiceLife = ServiceLife;
        }

        public String getPosition() {
            return Position;
        }

        public void setPosition(String Position) {
            this.Position = Position;
        }

        public String getSerial() {
            return Serial;
        }

        public void setSerial(String Serial) {
            this.Serial = Serial;
        }

        public String getSource() {
            return Source;
        }

        public void setSource(String Source) {
            this.Source = Source;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getAssetType() {
            return AssetType;
        }

        public void setAssetType(String AssetType) {
            this.AssetType = AssetType;
        }
    }
}
