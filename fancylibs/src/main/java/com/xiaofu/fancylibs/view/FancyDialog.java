package com.xiaofu.fancylibs.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.xiaofu.fancylibs.utils.MeasureUtils;


/**
 * Author:          小夫
 * Date:            2017/9/18 13:57
 * Description:     可扩展的自定义Dialog
 * <p>
 * 大人者，言不必信，行不必果，惟义所在
 */

public class FancyDialog extends Dialog {
    private Context context;
    private View view;
    private int height;
    private int width;
    private boolean cancelTouchOut;


    private FancyDialog(Builder builder) {
        super(builder.context);
        this.context = builder.context;
        this.view = builder.view;
        this.height = builder.height;
        this.width = builder.width;
        this.cancelTouchOut = builder.cancelTouchOut;
    }

    private FancyDialog(Builder builder, int resStyle) {
        super(builder.context, resStyle);
        this.context = builder.context;
        this.view = builder.view;
        this.height = builder.height;
        this.width = builder.width;
        this.cancelTouchOut = builder.cancelTouchOut;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(view);
        setCanceledOnTouchOutside(cancelTouchOut);


        if (height!= 0 && width != 0){
            Window win = getWindow();
            if (win != null){
                WindowManager.LayoutParams lp = win.getAttributes();
                lp.gravity = Gravity.CENTER;
                lp.width = width;
                lp.height = height;
                win.setAttributes(lp);
            }
        }

    }

    public static final class Builder {
        private Context context;
        private View view;
        private boolean cancelTouchOut = true;
        private int resStyle = -1;
        private int height;
        private int width;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder view(int resLayout) {
            view = LayoutInflater.from(context).inflate(resLayout, null);
            return this;
        }

        public Builder style(int resStyle) {
            this.resStyle = resStyle;
            return this;
        }

        public Builder cancelTouchOut(boolean cancelTouchOut) {
            this.cancelTouchOut = cancelTouchOut;
            return this;
        }

        public Builder height(float height) {
            this.height = (int) MeasureUtils.dp2px(context, height);
            return this;
        }

        public Builder width(float width) {
            this.width = (int) MeasureUtils.dp2px(context, width);
            return this;
        }

        public Builder addListener(int viewId,View.OnClickListener listener) {
            view.findViewById(viewId).setOnClickListener(listener);
            return this;
        }

        public FancyDialog build() {
            if (resStyle != -1)
                return new FancyDialog(this, resStyle);
            else
                return new FancyDialog(this);
        }
    }

}
