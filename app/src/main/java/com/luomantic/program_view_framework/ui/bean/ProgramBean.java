package com.luomantic.program_view_framework.ui.bean;

import java.util.List;

/**
 * 多分区视图的填充数据
 */
public class ProgramBean {

    /**
     * 单分区列表 - 多分区包含多个单分区
     */
    public List<WindowBean> windowList;

    public List<WindowBean> getWindowList() {
        return windowList;
    }

    public void setWindowList(List<WindowBean> windowList) {
        this.windowList = windowList;
    }

    @Override
    public String toString() {
        return "ProgramBean{" +
                "windowList=" + windowList +
                '}';
    }
}
