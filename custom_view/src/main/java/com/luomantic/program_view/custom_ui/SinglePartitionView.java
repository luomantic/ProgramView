package com.luomantic.program_view.custom_ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.blankj.utilcode.util.ColorUtils;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

/**
 * 单分区的节目视图
 * 注意：
 * 视频分辨率不能大于屏幕分辨率，否则会出现can't play this video弹框
 */
public class SinglePartitionView extends RelativeLayout {
    private MarqueeTextView textView;
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
            textView = new MarqueeTextView(context);
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
        textView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        videoView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        textView.setOnScrollFinishedListener(new MarqueeTextView.OnScrollFinishedListener() {
            @Override
            public void onScrollFinished() {
                textScrollFinishedListener.onScrollFinished();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.stopPlayback();
                videoFinishedListener.onVideoFinished();
            }
        });

        // TODO: 添加布局动画的封装

        hideAllViews();
    }

    //--------------------------- 对外提供的接口方法,各接口可按需拓展 ----------------------------------------

    /*------------------------ TextView  相关 -----------------------*/

    /**
     * 设置MarqueeTextView的文字 内容
     *
     * @param text 文字内容
     */
    public void setText(String text) {
        textView.setText(text);
    }

    /**
     * 设置MarqueeTextView的文字 颜色
     *
     * @param color 文字颜色，int类型自动转换成rgb字符串
     */
    public void setTextColor(int color) {
        textView.setTextColor(Color.parseColor(ColorUtils.int2RgbString(color)));
    }

    /**
     * 设置MarqueeTextView的文字 大小
     *
     * @param textSize 文字大小
     */
    public void setTextSize(int textSize) {
        textView.setTextSize(textSize);
    }

    /**
     * 设置MarqueeTextView的文字 滚动的速度
     *
     * @param textSpeed 滚动的速度（单位：像素），表示没秒钟滚动多少像素
     */
    public void setTextSpeed(int textSpeed) {
        textView.setSpeed(textSpeed);
    }

    /**
     * 设置MarqueeTextView的文字 字体
     *
     * @param typeface 可以是系统提供的四种字体，也可以是assert下的字体，或第三方框架提供的字体
     */
    public void setTextFont(Typeface typeface) {
        textView.setFont(typeface);
    }

    /**
     * 设置MarqueeTextView的文字 滚动方向
     *
     * @param orientation 0 表示从右向左 ← ，1表示从下到上 ↑
     */
    public void setTextOrientation(int orientation) {
        textView.setOrientation(orientation);
    }

    private TextScrollFinishedListener textScrollFinishedListener;

    public interface TextScrollFinishedListener {
        void onScrollFinished();
    }

    public void setTextScrollFinishedListener(TextScrollFinishedListener textScrollFinishedListener) {
        this.textScrollFinishedListener = textScrollFinishedListener;
    }

    /*------------------------ ImageView 相关 -----------------------*/

    /**
     * 通过Glide加载静态图片
     *
     * @param context   上下文
     * @param imagePath 本地图片存储路径
     */
    public void setGlideImage(Context context, String imagePath) {
        Glide.with(context)
                .load(new File(imagePath))
//                .transition(DrawableTransitionOptions.withCrossFade(2000)) // 适用于Drawable，过渡动画持续600ms
//                .transition(BitmapTransitionOptions.withCrossFade(2000))   // 适用于Bitmap，过渡动画持续600ms
//                .transition(GenericTransitionOptions.with(R.anim.zoom_in))   // 补间动画，适用于自定义动画效果，传入animationId
//                .transition(GenericTransitionOptions.with(animator)) // 属性动画
                .into(imageView);
    }

    /**
     * 通过GifDrawable加载Gif图片
     *
     * @param imagePath 本地gif存储路径
     */
    public void setGifDrawableImage(String imagePath) {
        GifDrawable gifDrawable = null;
        try {
            gifDrawable = new GifDrawable(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImageDrawable(gifDrawable);

        // TODO: 记得添加 recycle() - 释放内存和Bitmap的作用方法一样
        //isRecycled() - 检查是否已经被回收
        //getError() - 返回最新的错误细节
    }

    /*------------------------ VideoView 相关 -----------------------*/

    /**
     * 设置视频路径
     *
     * @param path 本地视频存储路径
     */
    public void setVideoPath(String path) {
        videoView.setVideoPath(path);
    }

    /**
     * 暂停播放视频
     */
    public void setVideoPause() {
        videoView.pause();
    }

    /**
     * 开始播放视频
     */
    public void setVideoStart() {
        videoView.start();
    }

    /**
     * 获取视频的总长度 单位是毫秒
     *
     * @return 视频总毫秒长度
     */
    public int getVideoDuration() {
        return videoView.getDuration();
    }

    /**
     * 设置视频播放的背景 - 防止加载视频过渡的时候黑屏
     *
     * @param drawable drawable类型的图片
     */
    public void setVideoBackground(Drawable drawable) {
        videoView.setBackground(drawable);
    }


    private VideoFinishedListener videoFinishedListener;

    public interface VideoFinishedListener {
        void onVideoFinished();
    }

    public void setVideoCompleteListener(VideoFinishedListener videoFinishedListener) {
        this.videoFinishedListener = videoFinishedListener;
    }

    /*------------------------ 显示隐藏  相关 -----------------------*/

    /**
     * 显示文本，并隐藏图片跟视频
     */
    public void showText() {
        textView.setVisibility(VISIBLE);
        imageView.setVisibility(GONE);
        videoView.setVisibility(GONE);
    }

    /**
     * 显示图片，并隐藏文本跟视频
     */
    public void showImage() {
        imageView.setVisibility(VISIBLE);
        textView.setVisibility(GONE);
        videoView.setVisibility(GONE);
    }

    /**
     * 显示视频，并隐藏文本跟图片
     */
    public void showVideo() {
        videoView.setVisibility(VISIBLE);
        textView.setVisibility(GONE);
        imageView.setVisibility(GONE);
    }

    /**
     * 隐藏单分区所有布局
     */
    public void hideAllViews() {
        textView.setVisibility(GONE);
        imageView.setVisibility(GONE);
        videoView.setVisibility(GONE);
    }

}
