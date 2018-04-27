package view.zhengxiaolong.bw.com.gittext.bean;

import java.util.List;

/**
 * 推荐里列表bean类
 */

public class RecommendListSuperClass {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":1,"comments":[{"cid":347,"content":"好好！！","createTime":"2018-04-26T21:29:55","jid":null,"mvp":null,"nickname":"我是XXX","praiseNum":0,"uid":1570,"wid":430}],"cover":"https://www.zhaoapi.cn/images/quarter/1524744369253152826.jpg","createTime":"2018-04-26T20:06:09","favoriteNum":0,"latitude":null,"localUri":null,"longitude":null,"playNum":1,"praiseNum":1,"uid":1286,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524742442023215980.jpg","nickname":"大头","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15247443692531523331608204recording-1675724830.mp4","wid":430,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1524744339940152826.jpg","createTime":"2018-04-26T20:05:39","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":1286,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524742442023215980.jpg","nickname":"大头","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15247443399401523331608204recording-1675724830.mp4","wid":429,"workDesc":"这个视屏非常好看！"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1524716831828head.jpg","createTime":"2018-04-26T12:27:11","favoriteNum":0,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":0,"uid":11555,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524747172146avatar.jpg","nickname":"渣渣辉","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524716831828e2306259-4302-4fa0-bcf2-876f7b03aadb.mp4","wid":428,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15247138064323d2b7b899e510fb36e80ebc7db33c895d0430c2f.jpg","createTime":"2018-04-26T11:36:46","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"40","playNum":0,"praiseNum":0,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524713806432WIN_20180426_11_32_06_Pro.mp4","wid":427,"workDesc":"小二逼按时打发斯蒂芬"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1524666486716spl","createTime":"2018-04-25T22:28:06","favoriteNum":0,"latitude":"36.00088487413194","localUri":null,"longitude":"104.5662464735243","playNum":0,"praiseNum":0,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":"嘿嘿嘿","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524666486716video_1524666397541.mp4","wid":426,"workDesc":"这个视屏非常好看！"}]
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
         * commentNum : 1
         * comments : [{"cid":347,"content":"好好！！","createTime":"2018-04-26T21:29:55","jid":null,"mvp":null,"nickname":"我是XXX","praiseNum":0,"uid":1570,"wid":430}]
         * cover : https://www.zhaoapi.cn/images/quarter/1524744369253152826.jpg
         * createTime : 2018-04-26T20:06:09
         * favoriteNum : 0
         * latitude : null
         * localUri : null
         * longitude : null
         * playNum : 1
         * praiseNum : 1
         * uid : 1286
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524742442023215980.jpg","nickname":"大头","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/15247443692531523331608204recording-1675724830.mp4
         * wid : 430
         * workDesc : null
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private Object latitude;
        private Object localUri;
        private Object longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<CommentsBean> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
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

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524742442023215980.jpg
             * nickname : 大头
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
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

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }

        public static class CommentsBean {
            /**
             * cid : 347
             * content : 好好！！
             * createTime : 2018-04-26T21:29:55
             * jid : null
             * mvp : null
             * nickname : 我是XXX
             * praiseNum : 0
             * uid : 1570
             * wid : 430
             */

            private int cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private String nickname;
            private int praiseNum;
            private int uid;
            private int wid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
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

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }
        }
    }
}
