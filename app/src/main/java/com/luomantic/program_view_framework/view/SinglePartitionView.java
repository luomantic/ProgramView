package com.luomantic.program_view_framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * 单个分区的节目视图
 * 自定义组合控件 - 包含一个自定义MarqueeTextView + ImageView + VideoView
 * TODO: 我擦MarqueeTextView出不来
 */
public class SinglePartitionView extends RelativeLayout {
    private TextView textView;
    private ImageView imageView;
    private VideoView videoView;

    public SinglePartitionView(Context context) {
        this(context, null);
    }

    public SinglePartitionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SinglePartitionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        if (null == textView) {
            textView = new TextView(context);
        }
        if (null == imageView) {
            imageView = new ImageView(context);
        }
        if (null == videoView) {
            videoView = new VideoView(context);
        }
        this.addView(textView);
        this.addView(imageView);
        this.addView(videoView);

        // 设置各布局填充RelativeLayout
        textView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        videoView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        hideAllViews();
    }

    //--------------------------- 对外提供的接口方法,各接口可按需拓展 ----------------------------------------

    public void setText(String text){
        textView.setText(text);
    }

    public void setTextGravity(int textGravity){
        textView.setGravity(textGravity);
    }

    public void setImageDrawable(int resId) {
        imageView.setImageDrawable(getResources().getDrawable(resId));
    }

    public void setVideoPath(String path) {
        videoView.setVideoPath(path);
    }

    public void showText() {
        textView.setVisibility(VISIBLE);
        imageView.setVisibility(GONE);
        videoView.setVisibility(GONE);
    }

    public void showImage() {
        imageView.setVisibility(VISIBLE);
        textView.setVisibility(GONE);
        videoView.setVisibility(GONE);
    }

    public void showVideo() {
        videoView.setVisibility(VISIBLE);
        textView.setVisibility(GONE);
        imageView.setVisibility(GONE);
    }

    public void hideAllViews(){
        textView.setVisibility(GONE);
        imageView.setVisibility(GONE);
        videoView.setVisibility(GONE);
    }

}
