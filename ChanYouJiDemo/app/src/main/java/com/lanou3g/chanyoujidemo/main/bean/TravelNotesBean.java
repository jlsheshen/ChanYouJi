package com.lanou3g.chanyoujidemo.main.bean;

/**
 * Created by ${jl} on 16/5/9.
 * 游记类
 *
 */
public class TravelNotesBean extends MainContentBean {
    private int traveId;
    private String traveName;
    private int travePhotoCount;
    private String traveStartData;
    private String traveEndData;
    private int traveDay;
    private int traveLevel;
    private int traveViewsCount;
    private int traveCommentsCount;
    private int traveLikesCount;
    private String traveSource;
    private String traveUrl;
    private boolean traveFeatured;
    private UesrBean teaveUserBean;
    int type = 1;

    public UesrBean getTeaveUserBean() {
        return teaveUserBean;
    }

    public void setTeaveUserBean(UesrBean teaveUserBean) {
        this.teaveUserBean = teaveUserBean;
    }

    public int getTraveId() {
        return traveId;
    }

    public TravelNotesBean setTraveId(int traveId) {
        this.traveId = traveId;
        return this;
    }

    public String getTraveName() {
        return traveName;
    }

    public TravelNotesBean setTraveName(String traveName) {
        this.traveName = traveName;
        return this;
    }

    public int getTravePhotoCount() {
        return travePhotoCount;
    }

    public TravelNotesBean setTravePhotoCount(int travePhotoCount) {
        this.travePhotoCount = travePhotoCount;
        return this;
    }

    public String getTraveStartData() {
        return traveStartData;
    }

    public TravelNotesBean setTraveStartData(String traveStartData) {
        this.traveStartData = traveStartData;
        return this;
    }

    public String getTraveEndData() {
        return traveEndData;
    }

    public TravelNotesBean setTraveEndData(String traveEndData) {
        this.traveEndData = traveEndData;
        return this;
    }

    public int getTraveDay() {
        return traveDay;
    }

    public TravelNotesBean setTraveDay(int traveDay) {
        this.traveDay = traveDay;
        return this;
    }

    public int getTraveLevel() {
        return traveLevel;
    }

    public TravelNotesBean setTraveLevel(int traveLevel) {
        this.traveLevel = traveLevel;
        return this;
    }

    public int getTraveViewsCount() {
        return traveViewsCount;
    }

    public TravelNotesBean setTraveViewsCount(int traveViewsCount) {
        this.traveViewsCount = traveViewsCount;
        return this;
    }

    public int getTraveCommentsCount() {
        return traveCommentsCount;
    }

    public TravelNotesBean setTraveCommentsCount(int traveCommentsCount) {
        this.traveCommentsCount = traveCommentsCount;
        return this;
    }

    public int getTraveLikesCount() {
        return traveLikesCount;
    }

    public TravelNotesBean setTraveLikesCount(int traveLikesCount) {
        this.traveLikesCount = traveLikesCount;
        return this;
    }

    public String getTraveSource() {
        return traveSource;
    }

    public TravelNotesBean setTraveSource(String traveSource) {
        this.traveSource = traveSource;
        return this;
    }

    public String getTraveUrl() {
        return traveUrl;
    }

    public TravelNotesBean setTraveUrl(String traveUrl) {
        this.traveUrl = traveUrl;
        return this;
    }

    public boolean isTraveFeatured() {
        return traveFeatured;
    }

    public TravelNotesBean setTraveFeatured(boolean traveFeatured) {
        this.traveFeatured = traveFeatured;
        return this;
    }

    /**
     * Created by ${jl} on 16/5/9.
     *
     * 作者类
     */
    public static class UesrBean {
        private int userId;
        private String userName;
        private String userUrl;

        public int getUserId() {
            return userId;
        }

        public UesrBean setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public UesrBean setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getUserUrl() {
            return userUrl;
        }

        public UesrBean setUserUrl(String userUrl) {
            this.userUrl = userUrl;
            return this;
        }
    }
}
