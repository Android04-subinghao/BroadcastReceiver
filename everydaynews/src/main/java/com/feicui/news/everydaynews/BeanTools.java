package com.feicui.news.everydaynews;

/**
 * Created by Administrator on 2016/8/9.
 */
public class BeanTools {
    public String title;
    public String imasrc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImasrc() {
        return imasrc;
    }

    public void setImasrc(String imasrc) {
        this.imasrc = imasrc;
    }
    public BeanTools(String title,String imasrc){
        this.title=title;
        this.imasrc=imasrc;
    }
}
