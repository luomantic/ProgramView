package com.luomantic.program_view_framework.act;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.gson.Gson;
import com.luomantic.program_view_framework.R;
import com.luomantic.program_view_framework.bean.ConfigBean;
import com.luomantic.program_view_framework.ui.bean.ItemBean;
import com.luomantic.program_view_framework.ui.bean.ProgramBean;
import com.luomantic.program_view_framework.ui.bean.WindowBean;
import com.luomantic.program_view_framework.ui.view.MarqueeTextView;
import com.luomantic.program_view_framework.ui.view.MultiPartitionView;
import com.luomantic.program_view_framework.ui.view.SinglePartitionView;

import org.json.JSONException;
import org.json.XML;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MultiPartitionView multiPartitionView;
    private SinglePartitionView singlePartitionView;
    private RelativeLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        // 创建自定义视图



//        programView = findViewById(R.id.program_view);

//        rootLayout = findViewById(R.id.rl_root);
//        MarqueeTextView textView = new MarqueeTextView(this);
//        textView.setText("健身房๑Ő௰Ő๑)曾经瘦过，你也是厉害！副书记阿里阿萨德水电费");
//        rootLayout.addView(textView);

//        programView = new ProgramView(this);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 100);
//        layoutParams.setMargins(10, 300, 0, 0);
//        programView.setLayoutParams(layoutParams);
//
//        rootLayout.addView(programView);
//
//        programView.setText("法拉盛多来几个狼藉怕讲故事的菩萨的");
//        programView.setTextGravity(Gravity.CENTER);
//        programView.showText();
//
//        programView.setImageDrawable(R.mipmap.ic_launcher);
//        programView.showImage();
    }

    private void initData() {
        // 构造数据
        String xml = ResourceUtils.readAssets2String("3.XML");
        String json = null;
        try {
            json = XML.toJSONObject(xml).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ConfigBean configBean = new Gson().fromJson(json, ConfigBean.class);
        initProgramBean(configBean);

        // 将programBean传给multi 测试
    }
    private ProgramBean programBean = new ProgramBean();
    private List<WindowBean> windowList = new ArrayList<>();

    private void initProgramBean(ConfigBean configBean) {
        addMainWindow(configBean);

        addSubWindow(configBean);

        programBean.setWindowList(windowList);

        LogUtils.e(programBean.getWindowList().size());

        multiPartitionView = findViewById(R.id.program_layout);
        multiPartitionView.setProgramBean(programBean);
        multiPartitionView.setFilePath(Environment.getExternalStorageDirectory().getPath());
    }

    private void addSubWindow(ConfigBean configBean) {
        for (int i = 0; i < configBean.getWINDOWS().getSUB_WINDOW().size(); i++) {
            WindowBean windowBean = new WindowBean();
            windowBean.setMarginLeft(configBean.getWINDOWS().getSUB_WINDOW().get(i).getZERO().getX());
            windowBean.setMarginTop(configBean.getWINDOWS().getSUB_WINDOW().get(i).getZERO().getY());
            windowBean.setWidth(configBean.getWINDOWS().getSUB_WINDOW().get(i).getZERO().getW());
            windowBean.setHeight(configBean.getWINDOWS().getSUB_WINDOW().get(i).getZERO().getH());
            windowBean.setMainWindow(false);
            windowBean.setItemIndex(0);

            List<ItemBean> itemList = new ArrayList<>();
            for (int j = 0; j < configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().size(); j++) {
                ItemBean itemBean = new ItemBean();
                itemBean.setInType(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getSHOWFORMAT().getInType());
                itemBean.setInSpeed(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getSHOWFORMAT().getInSpeed());
                itemBean.setStayTime(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getSHOWFORMAT().getStayTime());
                itemBean.setFontName(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getFONTCOLOR().getFontname());
                itemBean.setFontSize(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getFONTCOLOR().getFontsize());
                itemBean.setTextColor(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getFONTCOLOR().getTextcolor());
                itemBean.setBackColor(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getFONTCOLOR().getBackcolor());
                itemBean.setFileName(configBean.getWINDOWS().getSUB_WINDOW().get(i).getITEMS().getITEM().get(j).getFILE().getFilename());

                windowBean.setItemList(itemList);
            }

            windowBean.setItemList(itemList);
            windowList.add(windowBean);
        }
    }

    private void addMainWindow(ConfigBean configBean) {
        WindowBean windowBean = new WindowBean();
        windowBean.setMarginLeft(configBean.getWINDOWS().getMAIN_WINDOW().getZERO().getX());
        windowBean.setMarginTop(configBean.getWINDOWS().getMAIN_WINDOW().getZERO().getY());
        windowBean.setWidth(configBean.getWINDOWS().getMAIN_WINDOW().getZERO().getW());
        windowBean.setHeight(configBean.getWINDOWS().getMAIN_WINDOW().getZERO().getH());
        windowBean.setMainWindow(true);
        windowBean.setItemIndex(0);
        windowBean.setPlayedTimes(0);
        windowBean.setConfigType(configBean.getWINDOWS().getPROGRAM().getNConfigType());
        windowBean.setDisplayTime(configBean.getWINDOWS().getPROGRAM().getNDispTimes());

        List<ItemBean> itemList = new ArrayList<>();
        for (int i = 0; i < configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().size(); i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.setInType(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getSHOWFORMAT().getInType());
            itemBean.setInSpeed(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getSHOWFORMAT().getInSpeed());
            itemBean.setStayTime(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getSHOWFORMAT().getStayTime());
            itemBean.setFontName(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getFONTCOLOR().getFontname()+"");
            itemBean.setFontSize(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getFONTCOLOR().getFontsize());
            itemBean.setTextColor(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getFONTCOLOR().getTextcolor());
            itemBean.setBackColor(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getFONTCOLOR().getBackcolor());
            itemBean.setFileName(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getFILE().getFilename());

            itemList.add(itemBean);
        }

        windowBean.setItemList(itemList);
        windowList.add(windowBean);
    }

}
