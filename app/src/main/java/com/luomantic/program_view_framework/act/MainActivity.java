package com.luomantic.program_view_framework.act;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.gson.Gson;
import com.luomantic.program_view_framework.R;
import com.luomantic.program_view_framework.bean.ConfigBean;
import com.luomantic.program_view_framework.ui.bean.ItemBean;
import com.luomantic.program_view_framework.ui.bean.ProgramBean;
import com.luomantic.program_view_framework.ui.bean.WindowBean;
import com.luomantic.program_view_framework.ui.view.MultiPartitionView;

import org.json.JSONException;
import org.json.XML;

import java.util.ArrayList;
import java.util.List;

import static com.luomantic.program_view_framework.utils.LuoUtils.checkPermissionAllGranted;

public class MainActivity extends AppCompatActivity {

    private String[] permissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setFullScreen(this);
        setContentView(R.layout.activity_main);

        if (checkPermissionAllGranted(this, permissions)) {
            initApp();
        }
    }

    private void initApp() {
        initData();

        LogUtils.e(programBean.toString());

        initView();
    }

    private void initView() {
        // 创建自定义视图

        RelativeLayout rootLayout = findViewById(R.id.rl_root);

        MultiPartitionView multiPartitionView = new MultiPartitionView(this, programBean, Environment.getExternalStorageDirectory().getPath());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(50, 100, 0, 0);
        multiPartitionView.setLayoutParams(layoutParams);
        rootLayout.addView(multiPartitionView);
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
    }

    private ProgramBean programBean = new ProgramBean();
    private List<WindowBean> windowList = new ArrayList<>();

    private void initProgramBean(ConfigBean configBean) {
        addMainWindow(configBean);

        addSubWindow(configBean);

        programBean.setWindowList(windowList);
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

                itemList.add(itemBean);
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
            itemBean.setFontName(configBean.getWINDOWS().getMAIN_WINDOW().getITEMS().getITEM().get(i).getFONTCOLOR().getFontname() + "");
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
