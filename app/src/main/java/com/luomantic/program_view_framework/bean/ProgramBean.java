package com.luomantic.program_view_framework.bean;

import java.util.List;

public class ProgramBean {

    public List<WindowBean> windowList;

    public List<ItemBean> itemList;

    public List<WindowBean> getWindowList() {
        return windowList;
    }

    public void setWindowList(List<WindowBean> windowList) {
        this.windowList = windowList;
    }

    public List<ItemBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemBean> itemList) {
        this.itemList = itemList;
    }
}
