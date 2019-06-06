package com.luomantic.program_view_framework.ui.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.luomantic.program_view_framework.ui.bean.ProgramBean;
import com.luomantic.program_view_framework.ui.bean.WindowBean;

/**
 * 多分区的节目视图 = N * 单分区的节目视图
 */
public class MultiPartitionView extends RelativeLayout {
    private Context context;
    private String filePath;
    private ProgramBean programBean;
    private Handler taskHandler = new Handler();

    public MultiPartitionView(Context context, ProgramBean programBean, String filePath) { // 代码初始化调用
        super(context);
        this.context = context;
        this.programBean = programBean;
        this.filePath = filePath;

        initView();
    }

    public MultiPartitionView(Context context, AttributeSet attrs) { // xml文件中调用
        this(context, attrs, 0);
    }

    public MultiPartitionView(Context context, AttributeSet attrs, int defStyleAttr) { // 带样式的时候调用
        super(context, attrs, defStyleAttr);
        this.context = context;

        initView();
    }

    private void initView() {
        if (null != programBean) {
            for (int i = 0; i < programBean.getWindowList().size(); i++) { // 有多少个window就创建多少个view
                if (programBean.getWindowList().get(i).isMainWindow()) {
                    if (programBean.getWindowList().get(i).getConfigType() == 0) { // 按次数播放
                        if (programBean.getWindowList().get(i).getDisplayTime() > 0) {
                            initPartitionView(programBean.getWindowList().get(i));
                        } else {
                            LogUtils.e("播放次数为0，请重新设置");
                        }
                    } else if (programBean.getWindowList().get(i).getConfigType() == 1) { // 按时间播放
                        initPartitionView(programBean.getWindowList().get(i));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // TODO: 移除主分区以及所有的子分区
                                LogUtils.e("播放时间已到期");
                            }
                        }, programBean.getWindowList().get(i).getDisplayTime() * 1000);
                    }
                } else {
                    // 子分区 windowIndex  itemIndex
                    initPartitionView(programBean.getWindowList().get(i));
                }
            }
        } else {
            LogUtils.e("programBean is null");
        }
    }

    private void initPartitionView(WindowBean windowBean) {
        SinglePartitionView singlePartitionView = new SinglePartitionView(context);
        this.addView(singlePartitionView);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                windowBean.getWidth(), windowBean.getHeight());
        layoutParams.setMargins(windowBean.getMarginLeft(), windowBean.getMarginTop(),0 ,0);
        singlePartitionView.setLayoutParams(layoutParams);

        // TODO: ① 可以添加布局动画  ② 可以添加悬浮窗
        initPartitionChildView(windowBean, singlePartitionView);
    }

    private void initPartitionChildView(WindowBean windowBean, SinglePartitionView singlePartitionView) {
        String fileName = windowBean.getItemList().get(windowBean.getItemIndex()).getFileName().toLowerCase();

        if (fileName.endsWith(".txt")) {
            showText(windowBean, singlePartitionView);
        } else if (fileName.endsWith(".mp4")) {
            showVideo(windowBean, singlePartitionView);
        } else if (fileName.endsWith(".gif")) {
            showGif(windowBean, singlePartitionView);
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
            showImage(windowBean, singlePartitionView);
        }
    }

    private void showImage(final WindowBean windowBean, final SinglePartitionView singlePartitionView) {
        singlePartitionView.showImage();
        // 设置普通图片
        String path = filePath + windowBean.getItemList().get(windowBean.getItemIndex()).getFileName();
        singlePartitionView.setGlideImage(context, path);

        taskHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNextItem(windowBean, singlePartitionView);
            }
        }, windowBean.getItemList().get(windowBean.getItemIndex()).getStayTime() * 1000);
    }

    private void showGif(final WindowBean windowBean, final SinglePartitionView singlePartitionView) {
        singlePartitionView.showImage();
        // 设置gif
        String path = filePath + windowBean.getItemList().get(windowBean.getItemIndex()).getFileName();
        singlePartitionView.setGifDrawableImage(path);

        taskHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNextItem(windowBean, singlePartitionView);
            }
        }, windowBean.getItemList().get(windowBean.getItemIndex()).getStayTime() * 1000);
    }

    private void showVideo(final WindowBean windowBean, final SinglePartitionView singlePartitionView) {
        singlePartitionView.showVideo();
        String path = filePath + windowBean.getItemList().get(windowBean.getItemIndex()).getFileName();
//        File file = new File(path);
//        LogUtils.e(file.exists());
        singlePartitionView.setVideoPath(path);
        // TODO: 将VideoView的背景设置成视频的第一帧跟最后一帧, 防黑屏
        singlePartitionView.setVideoCompleteListener(new SinglePartitionView.OnVideoCompleteListener() {
            @Override
            public void onVideoComplete() {
                singlePartitionView.setVideoPause();
                showNextItem(windowBean, singlePartitionView);
            }
        });
        singlePartitionView.setVideoStart();
    }

    private void showText(final WindowBean windowBean, final SinglePartitionView singlePartitionView) {
        singlePartitionView.showText();

        // TODO: 把readFile2String抽出来，不依赖AndroidUtilCodes
        String text = FileIOUtils.readFile2String(filePath + windowBean.getItemList().get(windowBean.getItemIndex()).getFileName());

        // 读取文字并设置
        singlePartitionView.setText(text);
        singlePartitionView.setTextSize(windowBean.getItemList().get(windowBean.getItemIndex()).getFontSize());
//        singlePartitionView.setTextColor(windowBean.getItemList().get(windowBean.getItemIndex()).getTextColor());

        taskHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNextItem(windowBean, singlePartitionView);
            }
        }, windowBean.getItemList().get(windowBean.getItemIndex()).getStayTime() * 1000);
    }

    private void showNextItem(WindowBean windowBean, SinglePartitionView singlePartitionView) {
        windowBean.setItemIndex(windowBean.getItemIndex() + 1);

        if (windowBean.isMainWindow()) {
            if (windowBean.getItemIndex() == windowBean.getItemList().size()) {
                windowBean.setItemIndex(0);

                if (windowBean.getConfigType() == 0) { // 按次数播放
                    windowBean.setPlayedTimes(windowBean.getPlayedTimes() + 1);
                    LogUtils.e(windowBean.getPlayedTimes());
                    if (windowBean.getPlayedTimes() == windowBean.getDisplayTime()) {

                        LogUtils.e("没有播放次数了" + windowBean.getDisplayTime());
                        initPartitionChildView(windowBean, singlePartitionView);
                    } else {
                        initPartitionChildView(windowBean, singlePartitionView);
                    }
                } else if (windowBean.getConfigType() == 1) { // 按时间播放
                    initPartitionChildView(windowBean, singlePartitionView);
                }
            } else {
                initPartitionChildView(windowBean, singlePartitionView);
            }
        } else {
            if (windowBean.getItemIndex() == windowBean.getItemList().size()) {
                windowBean.setItemIndex(0);
                initPartitionChildView(windowBean, singlePartitionView);
            } else {
                initPartitionChildView(windowBean, singlePartitionView);
            }
        }
    }

}
