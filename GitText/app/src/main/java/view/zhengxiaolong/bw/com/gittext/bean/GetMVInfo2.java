package view.zhengxiaolong.bw.com.gittext.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/4/27.
 */

public class GetMVInfo2 {

    /**
     * msg : 获取附近作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15230066291341522808912953.png","createTime":"2018-04-06T17:23:49","favoriteNum":1,"latitude":"40","localUri":null,"longitude":"40","playNum":0,"praiseNum":0,"uid":12400,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15236793605801523679359410.png","nickname":"日出东方","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523006629134recording-1593713751.mp4","wid":314,"workDesc":"456761"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15230067753061522808912953.png","createTime":"2018-04-06T17:26:15","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"40","playNum":0,"praiseNum":0,"uid":12400,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15236793605801523679359410.png","nickname":"日出东方","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523006775306recording-1234930085.mp4","wid":315,"workDesc":"是否干活"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15230070174001522730795274.png","createTime":"2018-04-06T17:30:17","favoriteNum":1,"latitude":"40","localUri":null,"longitude":"40","playNum":0,"praiseNum":0,"uid":12400,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15236793605801523679359410.png","nickname":"日出东方","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523007017400recording-791112252.mp4","wid":316,"workDesc":"7383385"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15247138064323d2b7b899e510fb36e80ebc7db33c895d0430c2f.jpg","createTime":"2018-04-26T11:36:46","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"40","playNum":0,"praiseNum":1,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524799498120head_icon.jpg","nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524713806432WIN_20180426_11_32_06_Pro.mp4","wid":427,"workDesc":"小二逼按时打发斯蒂芬"}]
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
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/15230066291341522808912953.png
         * createTime : 2018-04-06T17:23:49
         * favoriteNum : 1
         * latitude : 40
         * localUri : null
         * longitude : 40
         * playNum : 0
         * praiseNum : 0
         * uid : 12400
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15236793605801523679359410.png","nickname":"日出东方","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1523006629134recording-1593713751.mp4
         * wid : 314
         * workDesc : 456761
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

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

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
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

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15236793605801523679359410.png
             * nickname : 日出东方
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
    }
}
