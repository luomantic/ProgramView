package com.luomantic.program_view.bean;

/**
 * 节目基类 - 包含每一条节目的详细信息
 */
public class ItemBean {

    /**
     * 文字进入的方式，0 表示从右像左滚动 ←，1表示从下往上滚动 ↑
     */
    private int inType;

    /**
     * 文字进入的速度，单位为像素，表示每秒钟移动多少像素的距离。（走马灯步长）
     */
    private int inSpeed;

    /**
     * 图片的播放时间
     */
    private int stayTime;

    /**
     * 字体名字
     */
    private String fontName;

    /**
     * 文字大小，单位px
     */
    private int fontSize;

    /**
     * 字体颜色 - 由rgb字符串转成的int
     */
    private int textColor;

    /**
     * 背景颜色 - 由rgb字符串转成的int
     */
    private int backColor;

    /**
     * 文件名称 - 文件根路径 + 文件名称 = 文件全路径
     */
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getInType() {
        return inType;
    }

    public void setInType(int inType) {
        this.inType = inType;
    }

    public int getInSpeed() {
        return inSpeed;
    }

    public void setInSpeed(int inSpeed) {
        this.inSpeed = inSpeed;
    }

    public int getStayTime() {
        return stayTime;
    }

    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBackColor() {
        return backColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "inType=" + inType +
                ", inSpeed=" + inSpeed +
                ", stayTime=" + stayTime +
                ", fontName='" + fontName + '\'' +
                ", fontSize=" + fontSize +
                ", textColor=" + textColor +
                ", backColor=" + backColor +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
