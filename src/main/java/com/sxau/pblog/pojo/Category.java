package com.sxau.pblog.pojo;

import java.io.Serializable;

/**
 * 分类
 */
public class Category implements Serializable{
    private Integer id;

    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}