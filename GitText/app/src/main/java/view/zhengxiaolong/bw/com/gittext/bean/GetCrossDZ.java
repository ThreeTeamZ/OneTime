package view.zhengxiaolong.bw.com.gittext.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */

public class GetCrossDZ {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"111","createTime":"2018-04-26T22:24:45","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247526857212018-04-25_15-50-11.jpg|https://www.zhaoapi.cn/images/quarter/15247526857212018-04-25_15-57-35.jpg","jid":2347,"praiseNum":null,"shareNum":null,"uid":3026,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524033488755test.png","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:58:09","imgUrls":null,"jid":2346,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:58:06","imgUrls":null,"jid":2345,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:52:04","imgUrls":null,"jid":2344,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:52:01","imgUrls":null,"jid":2343,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:21:07","imgUrls":null,"jid":2342,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:21:04","imgUrls":null,"jid":2341,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:18:09","imgUrls":null,"jid":2340,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:17:08","imgUrls":null,"jid":2339,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:17:06","imgUrls":null,"jid":2338,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 111
         * createTime : 2018-04-26T22:24:45
         * imgUrls : https://www.zhaoapi.cn/images/quarter/15247526857212018-04-25_15-50-11.jpg|https://www.zhaoapi.cn/images/quarter/15247526857212018-04-25_15-57-35.jpg
         * jid : 2347
         * praiseNum : null
         * shareNum : null
         * uid : 3026
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524033488755test.png","nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524033488755test.png
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
