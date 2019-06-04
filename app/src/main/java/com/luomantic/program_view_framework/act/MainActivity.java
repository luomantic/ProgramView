package com.luomantic.program_view_framework.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.luomantic.program_view_framework.R;
import com.luomantic.program_view_framework.view.MultiPartitionView;
import com.luomantic.program_view_framework.view.SinglePartitionView;

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
        multiPartitionView = findViewById(R.id.program_layout);

//        programView = findViewById(R.id.program_view);


//        rootLayout = findViewById(R.id.rl_root);
//
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
    }
}
