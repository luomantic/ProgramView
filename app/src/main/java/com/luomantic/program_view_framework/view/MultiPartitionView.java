package com.luomantic.program_view_framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.RelativeLayout;

import com.luomantic.program_view_framework.bean.ProgramBean;
import com.luomantic.program_view_framework.bean.WindowBean;

/**
 * 多个分区的节目视图 = N * 单个分区的节目视图
 * 在自定义控件的基础上，做自定义组合控件，纯代码实现封装jar包
 */
public class MultiPartitionView extends RelativeLayout {

    public MultiPartitionView(Context context) { // 代码初始化调用
        this(context, null);
    }

    public MultiPartitionView(Context context, AttributeSet attrs) { // xml文件中调用
        this(context, attrs, 0);
    }

    public MultiPartitionView(Context context, AttributeSet attrs, int defStyleAttr) { // 带样式的时候调用
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        if ( null != programData) {
            for (int i = 0; i < programBean.getWindowList().size(); i++) {
                WindowBean windowBean = programBean.getWindowList().get(i);
                if (i==0) {
                    if (windowBean.getConfigType() == 0) { // 按次数播放
                        if (windowBean.getDisplayTime() > 0) {
                            // TODO: 2
                        }else {
                            // TODO: 提示没有播放次数了
                        }
                    }else { // 按时间播放

                    }
                }else {
                    SinglePartitionView singlePartitionView = new SinglePartitionView(context);
                    this.addView(singlePartitionView);

                    // 设置窗口位置参数
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1,1);
                    layoutParams.setMargins(1,1,0,0);
                    singlePartitionView.setLayoutParams(layoutParams);

                    // 2 TODO：根据文本、图片、视频播放结束的监听，循环设置节目参数.
                    // 根据文件名称，设置节目参数
                    if (programBean.getItemList().get(windowBean.getItemListPosition()).getFileName().endsWith(".txt")) {
                        singlePartitionView.showText();
                        singlePartitionView.setText("各种设置text");
                    }
                }
            }

//            singlePartitionView.setTextGravity(Gravity.CENTER);
//            singlePartitionView.setText("你打野，我不打");
//            singlePartitionView.showText();
        }
    }


    private ProgramBean programBean;


    //--------------------------- 对外提供的接口方法,各接口可按需拓展 ----------------------------------------
    private ProgramBean programData;

    public void setProgramData(ProgramBean programData) {
        this.programData = programData;
    }
}
