package com.luomantic.program_view.bean;

import java.util.List;

/**
 * 窗口基类 - 包含单分区的详细信息，包括分区的宽、高、左边距、上边距、列表索引、主分区标记、节目播放类型、节目播放次数。
 */
public class WindowBean {

    /**
     * 左边距
     */
    private int marginLeft;

    /**
     * 上边距
     */
    private int marginTop;

    /**
     * 单分区宽度
     */
    private int width;

    /**
     * 单分区高度
     */
    private int height;

    /**
     * 列表索引 - 从0开始播放，记录要播放的Item在ItemList中的位置
     */
    private int itemIndex;

    /**
     * 记录ItemList已播放完的次数
     */
    private int playedTimes;

    /**
     * 主分区标记 - 标记是否是主分区
     */
    private boolean isMainWindow;

    /**
     * 节目的播放类型，0表示按次数播放，1表示按时间播放
     */
    private int configType;

    /**
     * ① 按次数播放：ItemList需要播放的总次数
     * ② 按时间播放：ItemList需要播放的总时长
     */
    private int displayTime;

    /**
     * 节目列表 - 保存每个单分区的节目内容，单分区有多个节目
     */
    private List<ItemBean> itemList;

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public int getConfigType() {
        return configType;
    }

    public void setConfigType(int configType) {
        this.configType = configType;
    }

    public int getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(int displayTime) {
        this.displayTime = displayTime;
    }

    public int getPlayedTimes() {
        return playedTimes;
    }

    public void setPlayedTimes(int playedTimes) {
        this.playedTimes = playedTimes;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isMainWindow() {
        return isMainWindow;
    }

    public void setMainWindow(boolean mainWindow) {
        isMainWindow = mainWindow;
    }

    public List<ItemBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemBean> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "WindowBean{" +
                "marginLeft=" + marginLeft +
                ", marginTop=" + marginTop +
                ", width=" + width +
                ", height=" + height +
                ", itemIndex=" + itemIndex +
                ", playedTimes=" + playedTimes +
                ", isMainWindow=" + isMainWindow +
                ", configType=" + configType +
                ", displayTime=" + displayTime +
                ", itemList=" + itemList +
                '}';
    }
}
