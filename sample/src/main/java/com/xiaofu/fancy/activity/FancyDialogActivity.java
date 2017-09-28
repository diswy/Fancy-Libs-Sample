package com.xiaofu.fancy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.xiaofu.fancy.R;
import com.xiaofu.fancylibs.view.FancyButton;
import com.xiaofu.fancylibs.view.FancyDialog;

public class FancyDialogActivity extends AppCompatActivity implements View.OnClickListener {

    FancyDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_dialog);

        FancyButton fb = findViewById(R.id.btn_show_dialog);
        fb.setOnClickListener(this);

    }

    private void showCustomDialog(){
        FancyDialog.Builder builder = new FancyDialog.Builder(this);
        dialog = builder.view(R.layout.my_dialog)
                .cancelTouchOut(true)
                .addListener(R.id.dialog_btn_cancel,this)
                .addListener(R.id.dialog_btn_confirm,this)
//                .width(300)
//                .height(200)
                .build();
        dialog.show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialog_btn_cancel:
                dialog.dismiss();
                break;
            case R.id.dialog_btn_confirm:
                Toast.makeText(this,"确定",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                break;
            case R.id.btn_show_dialog:
                showCustomDialog();
                break;
        }
    }
}
