package com.luomantic.program_view_framework.ui.bean;

import java.util.List;

public class WindowBean {

    private int marginLeft;
    private int marginTop;
    private int width;
    private int height;
    private int itemIndex; // 标记item列表的位置 这个也可以
    private int playedTimes; // item 列表播已播放完几次
    private boolean isMainWindow; // 是否是主分区
    private int configType; // 播放类型，按时间播放或按次数播放
    private int displayTime; // 播放次数或时间
    private List<ItemBean> itemList; // 每个window包含多个item

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
}
