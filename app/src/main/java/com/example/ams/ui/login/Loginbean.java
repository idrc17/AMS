package com.example.ams.ui.login;

public class Loginbean {
    /**
     * result : true
     * msg :
     * obj : {"UserCode":"admin","UserName":"admin","OrganizationCode":null}
     */

    private boolean result;
    private String msg;
    private ObjBean obj;

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

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * UserCode : admin
         * UserName : admin
         * OrganizationCode : null
         */

        private String UserCode;
        private String UserName;
        private Object OrganizationCode;

        public String getUserCode() {
            return UserCode;
        }

        public void setUserCode(String UserCode) {
            this.UserCode = UserCode;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public Object getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(Object OrganizationCode) {
            this.OrganizationCode = OrganizationCode;
        }
    }
}
