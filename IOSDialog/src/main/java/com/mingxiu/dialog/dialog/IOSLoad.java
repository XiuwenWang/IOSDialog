package com.mingxiu.dialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.mingxiu.dialog.R;


/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * 版权所有：个人
 * 作者：Created by a.wen.
 * 创建时间：2016/12/23
 * Email：13872829574@163.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */

public class IOSLoad extends Dialog {


    private IOSLoad(Builder builder) {
        super(builder.context, R.style.loading_dialog);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setWindowAnimations(R.style.DialogAnimation);
        View rootView = getLayoutInflater().inflate(R.layout.loading_dialog, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        super.setContentView(rootView, params);
        initViews(rootView, builder);
    }

    private void initViews(View rootView, Builder builder) {
        ImageView spaceshipImage = (ImageView) rootView.findViewById(R.id.img);   //加载图片提示
        TextView tipTextView = (TextView) rootView.findViewById(R.id.tipTextView);// 提示文字

        if (builder.imageId != 0) {
            spaceshipImage.setImageResource(builder.imageId);
        }
        if (builder.isAnimation) {
            // 加载动画
            Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.loading_animation);
            // 使用ImageView显示动画
            spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        }

        if (TextUtils.isEmpty(builder.msg)) {
            tipTextView.setVisibility(View.GONE);
        } else {
            tipTextView.setVisibility(View.VISIBLE);
            tipTextView.setText(builder.msg);// 设置加载信息
        }
        setCanceledOnTouchOutside(builder.canceledOnTouchOutside);
        setCancelable(builder.cancelable);
    }

    private static Dialog mDialog;

    /**
     * 关闭加载对话框
     */
    public static void cancelDialog() {
        if (mDialog != null) {
            mDialog.cancel();
            mDialog = null;
        }
    }

    public static class Builder {
        final Context context;
        String msg;
        int imageId = 0;
        boolean isAnimation = true;
        boolean cancelable = true;
        boolean canceledOnTouchOutside = false;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        private Builder setImageId(@DrawableRes int imageId) {
            this.imageId = imageId;
            return this;
        }

        public Builder setAnimation(boolean animation) {
            this.isAnimation = animation;
            return this;
        }

        public Builder setCancelable(boolean isCancel) {
            this.cancelable = isCancel;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean isCanceledOnTouchOutside) {
            this.canceledOnTouchOutside = isCanceledOnTouchOutside;
            return this;
        }

        public IOSLoad create() {
            return new IOSLoad(this);
        }

        public IOSLoad show() {
            IOSLoad dialog = create();
            dialog.show();
            mDialog = dialog;
            return dialog;
        }
    }
}
