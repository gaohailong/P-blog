package com.sxau.pblog.pojo;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/25.
 * 管理员的基本信息（图表用）
 */
public class AdminTotal {
    private int adminTitleCount;
    private Date adminTitleDate;

    private int cateTitleCount;
    private String cateName;

    public int getAdminTitleCount() {
        return adminTitleCount;
    }

    public void setAdminTitleCount(int adminTitleCount) {
        this.adminTitleCount = adminTitleCount;
    }

    public Date getAdminTitleDate() {
        return adminTitleDate;
    }

    public void setAdminTitleDate(Date adminTitleDate) {
        this.adminTitleDate = adminTitleDate;
    }

    public int getCateTitleCount() {
        return cateTitleCount;
    }

    public void setCateTitleCount(int cateTitleCount) {
        this.cateTitleCount = cateTitleCount;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
