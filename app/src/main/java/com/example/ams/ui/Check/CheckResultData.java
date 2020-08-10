package com.example.ams.ui.Check;

public class CheckResultData {

    /**
     * SubId : 100
     * InventoryRemark : 2
     * InventoryUserName : 1300010032
     */

    private int SubId;//任务id
    private String InventoryRemark;//盘点结果
    private String InventoryUserName;//扫描人

    public int getSubId() {
        return SubId;
    }

    public void setSubId(int SubId) {
        this.SubId = SubId;
    }

    public String getInventoryRemark() {
        return InventoryRemark;
    }

    public void setInventoryRemark(String InventoryRemark) {
        this.InventoryRemark = InventoryRemark;
    }

    public String getInventoryUserName() {
        return InventoryUserName;
    }

    public void setInventoryUserName(String InventoryUserName) {
        this.InventoryUserName = InventoryUserName;
    }
}
