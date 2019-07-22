package com.luomantic.program_view.custom_ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 *  自定义view，在TextView的基础上，增加左右滑动，上下滑动的功能。
 *      支持step步长设置
 *      支持滚动速度设置
 *      支持一条文字播放结束时候的监听
 *  TODO: 增加direction, 控制从右往左滚动，以及从上往下滚动 .
 *  TODO: 增加一个判断，判断是否需要文字滚动，如果不需要就正常显示 .
 *  TODO: MarqueeTextView或其父view设置了Gravity的时候出不来，会把文字画到看不见的地方. 需另行对Gravity.CENTER进行处理
 *  fixme: 改用staticLayout绘制文字，或者改良自动换行处理.
 */
public class MarqueeTextView extends android.support.v7.widget.AppCompatTextView {

    private OnScrollFinishedListener listener; // 文字滚动结束监听

    public interface OnScrollFinishedListener {
        void onScrollFinished();
    }

    public void setOnScrollFinishedListener(OnScrollFinishedListener listener) {
        this.listener = listener;
    }

    /**
     * 文字内容
     */
    private String text;

    /**
     * 文字大小
     */
    private float textSize;

    /**
     * 字体
     */
    private Typeface typeface;

    private int mOrientation = 0; // 文字滚动方向，0表示水平方向，1表示垂直方向

    private float offX = 0f; // 水平方向的滚动
    private float offY = 0f; // 垂直方向的滚动

    private float mStep = 0.5f; // 默认速度（步长）

    private Rect mRect = new Rect();

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MarqueeTextView(Context context) {
        super(context);
        setSingleLine(true);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setSingleLine(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        text = getText().toString();
        textSize = getTextSize();

        if (typeface !=null) {
            mPaint.setTypeface(typeface);
        }

        mPaint.setColor(getCurrentTextColor());
        mPaint.setTextSize(textSize);
        mPaint.getTextBounds(text, 0, text.length(), mRect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float x , y;
        if (mOrientation == 0) { // 水平滚动
            x = getMeasuredWidth() - offX;
            y = (getMeasuredHeight() >> 1) + (mPaint.descent() - mPaint.ascent()) / 2;

            if (text != null) { // 在代码里面设置的setText, 可能会在onMeasure以后才获取到值.
                canvas.drawText(text, x, y, mPaint);
                offX += mStep;
                if (offX >= getMeasuredWidth() + mRect.width()) {
                    offX = 0f;
                    if (listener != null) {
                        listener.onScrollFinished();
                    }
                }
                invalidate();
            }
        } else if (mOrientation == 1){ // 垂直滚动
            x = 0;
            y = (getMeasuredHeight() >> 1) + (mPaint.descent() - mPaint.ascent()) / 2 - offY;

            if (text != null) {
                List<String> textList = getTextList(text);
                float space = mPaint.getFontSpacing();

                for (int i = 0; i < textList.size(); i++) {
                    canvas.drawText(textList.get(i), x, y + space * i, mPaint);
                }

                offY += mStep;
                if (offY >= getMeasuredHeight() + mRect.height() + space * textList.size() - 1) {
                    offY = 0f;
                    if (listener!=null) {
                        listener.onScrollFinished();
                    }
                }
                invalidate();
            }
        }
    }

    /**
     * 对文字重新排版
     *
     * @param mText 要排版的文字
     * @return 已排版的文字列表
     */
    private List<String> getTextList(String mText) {
        List<String> list = new ArrayList<>();
        int textLength = mText.length();
        int width = getMeasuredWidth();

        float limit = width / textSize;
        if (limit >= textLength) {
            list.add(mText);
        } else {
            int size = (int) (textLength / limit + (textLength % limit != 0 ? 1 : 0));
            for (int i = 0; i < size; i++) {
                int beginIndex = (int) (i * limit);
                int endIndex = (i + 1) * limit >= textLength ? textLength : (int) ((i + 1) * limit);
                list.add(mText.substring(beginIndex, endIndex));
            }
        }
        return list;
    }

    /**
     * 设置字幕滚动的速度
     */
    public void setSpeed(int step) {
        mStep = step;
    }

    public void setOrientation(int orientation) {
        mOrientation = orientation;
    }

    public void setFont(Typeface typeface) {
        this.typeface = typeface;
    }
}

