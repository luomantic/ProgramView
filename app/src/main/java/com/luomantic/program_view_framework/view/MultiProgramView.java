package com.luomantic.program_view_framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luomantic.program_view_framework.bean.ItemBean;
import com.luomantic.program_view_framework.bean.WindowBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 节目视图
 * 在自定义控件的基础上，做自定义组合控件，纯代码实现封装jar包
 */
public class MultiProgramView extends RelativeLayout {

    public MultiProgramView(Context context) { // 代码初始化调用
        this(context, null);
    }

    public MultiProgramView(Context context, AttributeSet attrs) { // xml文件中调用
        this(context, attrs, 0);
    }

    public MultiProgramView(Context context, AttributeSet attrs, int defStyleAttr) { // 带样式的时候调用
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private TextView textView;
    private ImageView imageView;

    private void initView(Context context) {

        // 用代码实现布局

        // View.inflate(context, R.layout.program_layout, this); // 不加载xml，加载一个用纯代码实现的布局

//        textView = new TextView(context);
//        imageView = new ImageView(context);
//
//        this.addView(textView);
//        this.addView(imageView);

        // 根据数据，创建N个RelativeLayout

        // 分别给每个RelativeLayout中，根据需要添加相应的布局。
        // 2种实现方式：
        //      ① 用到哪个view创建哪个view
        //      ② 每个layout都创建txt,img,video的view, 但是不添加内容。后面分别添加内容后，显示隐藏。（注意隐藏的时候释放video资源）

        // TODO: 每一个SubWindow都有自己marginleft, marginTop, width, height
        createViewByData(new WindowBean(), new ArrayList<ItemBean>());
    }

    private void createViewByData(WindowBean windowBean, List<ItemBean> itemList) {
        String fileName = itemList.get(windowBean.getItemListPosition()).getFileName();

//        if (fileName.endsWith(".txt")) { // 文字跑马灯效果
//            createMarqueeView(windowBean, itemList);
//        } else if (fileName.endsWith(".mp4")) { // 播放器
//            createPlayerView(windowBean, itemList);
//        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".JPG")
//                || fileName.endsWith(".png") || fileName.endsWith(".PNG")) { // 图片
//            createImageView(windowBean, itemList);
//        } else if (fileName.endsWith(".gif") || fileName.endsWith(".GIF")) { // gif
//            createGifView(windowBean, itemList);
//        }
    }

    private WindowBean windowBean;

    public void setProgramData(WindowBean windowBean) {
        this.windowBean = windowBean;
    }

    public void setTextView(String text) {
        textView.setText(text);
    }

    public void setImageView(int resId) {
        imageView.setImageDrawable(getResources().getDrawable(resId));
    }

    public void showText() {
        textView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
    }

    public void showImg() {
        imageView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
    }

}
