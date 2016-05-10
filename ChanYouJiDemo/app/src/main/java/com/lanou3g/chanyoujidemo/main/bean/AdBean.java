package com.lanou3g.chanyoujidemo.main.bean;

/**
 * Created by ${jl} on 16/5/9.
 * 广告类
 */
public class AdBean extends MainContentBean {
    private String adPosition;
    private String adImageUrl;
    private String advertType;
    private String adPositionContent;
    private boolean adRotaion;
    int type = 0;







    public String getAdPosition() {
        return adPosition;
    }

    public AdBean setAdPosition(String adPosition) {
        this.adPosition = adPosition;
        return this;
    }

    public String getAdImageUrl() {
        return adImageUrl;
    }

    public AdBean setAdImageUrl(String adImageUrl) {
        this.adImageUrl = adImageUrl;
        return this;

    }

    public String getAdvertType() {
        return advertType;
    }

    public AdBean setAdvertType(String advertType) {
        this.advertType = advertType;
        return this;
    }

    public String getAdPositionContent() {
        return adPositionContent;
    }

    public AdBean setAdPositionContent(String adPositionContent) {
        this.adPositionContent = adPositionContent;
        return this;
    }

    public boolean isAdRotaion() {
        return adRotaion;
    }

    public AdBean setAdRotaion(boolean adRotaion) {
        this.adRotaion = adRotaion;
        return this;
    }


}
