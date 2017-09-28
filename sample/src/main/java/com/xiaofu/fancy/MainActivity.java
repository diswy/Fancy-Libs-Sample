package com.xiaofu.fancy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaofu.fancy.activity.FancyButtonActivity;
import com.xiaofu.fancy.activity.FancyDialogActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBtn;
    private Button btnDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    /**
     * 初始化
     */
    private void init() {
        btnBtn = findViewById(R.id.btn_btn);
        btnDialog = findViewById(R.id.btn_dialog);

        btnBtn.setOnClickListener(this);
        btnDialog.setOnClickListener(this);
    }


    /**
     * 按钮监听
     * @param view 控件
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_btn:
                startActivity(new Intent(this, FancyButtonActivity.class));
                break;
            case R.id.btn_dialog:
                startActivity(new Intent(this, FancyDialogActivity.class));
                break;
        }
    }
}
