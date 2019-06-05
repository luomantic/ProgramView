package com.luomantic.program_view_framework.ui.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * 单个分区节目视图
 * TODO: 我擦MarqueeTextView出不来，需要给MarqueeTextView传x,y的参数，否则画的时候，会把文字画到看不见的地方.
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
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                onVideoCompleteListener.onVideoComplete();
            }
        });

        // TODO: 添加布局动画的封装

        hideAllViews();
    }

    //--------------------------- 对外提供的接口方法,各接口可按需拓展 ----------------------------------------

    /*------------------------ TextView  相关 -----------------------*/

    public void setText(String text){
        textView.setText(text);
    }

    public void setTextColor(int color) {
        textView.setTextColor(color);
    }

    public void setTextSize(int textSize) {
        textView.setTextSize(textSize);
    }

    public void setTextGravity(int textGravity){
        textView.setGravity(textGravity);
    }

    /*------------------------ ImageView 相关 -----------------------*/

    public void setImageDrawable(int resId) {
        imageView.setImageDrawable(getResources().getDrawable(resId));
    }

    public void setGlideImage(Context context, String imagePath) {
//        Glide.with(getApplicationContext())
//                .load(file)
//                .transition(DrawableTransitionOptions.withCrossFade(2000)) // 适用于Drawable，过渡动画持续600ms
//                .transition(BitmapTransitionOptions.withCrossFade(2000))   // 适用于Bitmap，过渡动画持续600ms
//                .transition(GenericTransitionOptions.with(R.anim.zoom_in))   // 补间动画，适用于自定义动画效果，传入animationId
//                .transition(GenericTransitionOptions.with(animator)) // 属性动画
//                .into(imageView);
    }

    public void setGifDrawableImage(String imagePath) {
//        GifDrawable gifDrawable = new GifDrawable(root_path + itemList.get(windowBean.getItemListPosition()).getFileName());
//        imageView.setImageDrawable(gifDrawable);

        // TODO: 记得添加 recycle() - 释放内存和Bitmap的作用方法一样
        //isRecycled() - 检查是否已经被回收
        //getError() - 返回最新的错误细节
    }

    /*------------------------ VideoView 相关 -----------------------*/

    public void setVideoPath(String path) {
        videoView.setVideoPath(path);
    }

    public void setVideoPause() {
        videoView.pause();
    }

    public void setVideoStart() {
        videoView.start();
    }

    public int getVideoDuration() {
        return videoView.getDuration();
    }

    public void setVideoBackground(Drawable drawable) {
        videoView.setBackground(drawable);
    }

    private OnVideoCompleteListener onVideoCompleteListener;

    public interface OnVideoCompleteListener {
        void onVideoComplete();
    }

    public void setVideoCompleteListener(OnVideoCompleteListener onVideoCompleteListener) {
        this.onVideoCompleteListener = onVideoCompleteListener;
    }

    /*------------------------ 显示隐藏  相关 -----------------------*/

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
