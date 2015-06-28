package com.connectu.mody.category.model;

/**
 * Created by seongsuPark on 15. 6. 28..
 */
public enum CategoryTypeEnum {
    MEET("만남","http://www.iconsdownload.net/icons/512/13788-man-and-woman-standing-silhouette-vector.png"),
    ADULT("19","http://image.club5678.com/imgs/regist/070414/icon_19.gif"),
    SPORT("스포츠", "http://www.fitacrosscultures.com/wp-content/uploads/2013/09/FIT_sports_icon1.png"),
    STUDY("스터디", "http://tkr.khazanah.com.my/2013/images/case-icon.png"),
    TRAVEL("여행", "http://www.clker.com/cliparts/P/O/p/c/c/N/travel-icon-airplane-md.png"),
    MEAL("밥","https://shop.fiu.edu/_assets/images/one-card/icon_utensils.png"),
    PERFORMANCE("공연","http://cache4.asset-cache.net/xc/494856317.jpg?v=2&c=IWSAsset&k=2&d=zKa0O67xK3zmIKg0MVKprzhvZo5kwoyPYtrh4SagZYzAm5vT3ESURPgFcjv5SOh-0"),
    ETC("기타","http://fullofbooks.com.au/images/categories/etc_icon.png");

    private String name;
    private String url;

    CategoryTypeEnum(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

}
