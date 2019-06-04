package com.luomantic.program_view_framework.bean;

/**
 * 窗口基类
 * window分为主window与子window
 */
public class WindowBean {

    private int marginLeft;
    private int marginTop;
    private int width;
    private int height;
    private int itemSize;
    private int itemListPosition; // 标记item列表的位置
    private int count; // item 列表播已播放完几次
    private boolean isMainWindow;

    public int getItemListPosition() {
        return itemListPosition;
    }

    public void setItemListPosition(int curItemPosition) {
        this.itemListPosition = curItemPosition;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public int getItemSize() {
        return itemSize;
    }

    public void setItemSize(int itemSize) {
        this.itemSize = itemSize;
    }

    public boolean isMainWindow() {
        return isMainWindow;
    }

    public void setMainWindow(boolean mainWindow) {
        isMainWindow = mainWindow;
    }
}
