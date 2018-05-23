package com.mingxiu.dialog.dialog;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mingxiu.dialog.controller.AlertController;
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
 * 创建时间：2017/7/27
 * Email：13872829574@163.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */

public class IOSAlert extends BaseDialog {

    AlertController mAlert;
    LinearLayout mRootView;
    LinearLayout mContentView;
    LinearLayout mLlBottom;
    TextView mTitle;
    TextView mMsg;
    TextView mTvNegative;
    View mPartingLine;
    TextView mTvPosittive;
    View mPartingLineH;

    private IOSAlert(Activity context) {
        super(context);
        mAlert = new AlertController(this);
    }


    @Override
    protected ViewGroup.LayoutParams setDialog(Window window, Activity context) {
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.CenterAnimation);
        return new ViewGroup.LayoutParams(context.getWindowManager().getDefaultDisplay().getWidth() * 3 / 4, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public int getLayout() {
        return R.layout.alert_ios;
    }

    @Override
    protected void initViews(View rootView) {
        mRootView = (LinearLayout) rootView.findViewById(R.id.ll_boot);
        mContentView = (LinearLayout) rootView.findViewById(R.id.ll_content_view);
        mTitle = (TextView) rootView.findViewById(R.id.tv_title);
        mMsg = (TextView) rootView.findViewById(R.id.tv_msg);
        mPartingLineH = rootView.findViewById(R.id.partingLine_h);
        mLlBottom = (LinearLayout) rootView.findViewById(R.id.ll_bottom);
        mTvNegative = (TextView) rootView.findViewById(R.id.tv_Negative);
        mPartingLine = rootView.findViewById(R.id.partingLine);
        mTvPosittive = (TextView) rootView.findViewById(R.id.tv_Positive);

    }

    public LinearLayout getmLlBottom() {
        return mLlBottom;
    }

    public void setmLlBottom(LinearLayout mLlBottom) {
        this.mLlBottom = mLlBottom;
    }

    public View getmPartingLineH() {
        return mPartingLineH;
    }

    public void setmPartingLineH(View mPartingLineH) {
        this.mPartingLineH = mPartingLineH;
    }

    public LinearLayout getmRootView() {
        return mRootView;
    }

    public void setmRootView(LinearLayout mRootView) {
        this.mRootView = mRootView;
    }

    public LinearLayout getmContentView() {
        return mContentView;
    }

    public void setmContentView(LinearLayout mContentView) {
        this.mContentView = mContentView;
    }

    public TextView getmTitle() {
        return mTitle;
    }

    public void setmTitle(TextView mTitle) {
        this.mTitle = mTitle;
    }

    public TextView getmMsg() {
        return mMsg;
    }

    public void setmMsg(TextView mMsg) {
        this.mMsg = mMsg;
    }

    public TextView getmTvNegative() {
        return mTvNegative;
    }

    public void setmTvNegative(TextView mTvNegative) {
        this.mTvNegative = mTvNegative;
    }

    public View getmPartingLine() {
        return mPartingLine;
    }

    public void setmPartingLine(View mPartingLine) {
        this.mPartingLine = mPartingLine;
    }

    public TextView getmTvPosittive() {
        return mTvPosittive;
    }

    public void setmTvPosittive(TextView mTvPosittive) {
        this.mTvPosittive = mTvPosittive;
    }

    public static class Builder {
        private final AlertController.AlertParams P;
        private final Context context;

        public Builder(@NonNull Activity context) {
            this.P = new AlertController.AlertParams(context);
            this.context = context;
        }

        public Context getContext() {
            return context;
        }

        /**
         * setTitle
         *
         * @param isVisible
         * @return
         */

        public Builder setTitle(boolean isVisible) {
            P.mTitleVisibility = isVisible;
            return this;
        }

        public Builder setTitle(@StringRes int titleId) {
            P.mTitle = P.mContext.getText(titleId);
            return this;
        }
        private Builder setTitleColor(@ColorInt int color) {
            P.mTitleTextColor = color;
            return this;
        }

        public Builder setTitle(float size) {
            P.mTitleTextSize = size;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence title) {
            P.mTitle = title;
            return this;
        }

        public Builder setTitle(@StringRes int titleId, @ColorInt int color) {
            return setTitle(titleId).setTitleColor(color);
        }

        public Builder setTitle(@StringRes int titleId, float size) {
            return setTitle(titleId).setTitle(size);
        }

        public Builder setTitle(@Nullable CharSequence title, @ColorInt int color) {
            return setTitle(title).setTitleColor(color);
        }

        public Builder setTitle(@Nullable CharSequence title, float size) {
            return setTitle(title).setTitle(size);
        }

        public Builder setTitle(@Nullable CharSequence title, @ColorInt int color, float size) {
            return setTitle(title).setTitleColor(color).setTitle(size);
        }

        public Builder setTitle(@StringRes int titleId, @ColorInt int color, float size) {
            return setTitle(titleId).setTitleColor(color).setTitle(size);
        }

        /**
         * setMessage
         *
         * @param isVisible
         * @return
         */

        public Builder setMessage(boolean isVisible) {
            P.mMessageVisibility = isVisible;
            return this;
        }

        public Builder setMessage(@StringRes int messageId) {
            P.mMessage = P.mContext.getText(messageId);
            return this;
        }
        private Builder setMessageColor(@ColorInt int color) {
            P.mMessageTextColor = color;
            return this;
        }
        public Builder setMessage(float size) {
            P.mMessageTextSize = size;
            return this;
        }

        public Builder setMessage(@Nullable CharSequence message) {
            P.mMessage = message;
            return this;
        }

        public Builder setMessage(@StringRes int messageId, @ColorInt int color) {
            return setMessage(messageId).setMessageColor(color);
        }

        public Builder setMessage(@StringRes int messageId, float size) {
            return setMessage(messageId).setMessage(size);
        }

        public Builder setMessage(@Nullable CharSequence message, float size) {
            return setMessage(message).setMessage(size);
        }

        public Builder setMessage(@Nullable CharSequence message, @ColorInt int color) {
            return setMessage(message).setMessageColor(color);
        }

        public Builder setMessage(@StringRes int messageId, @ColorInt int color, float size) {
            return setMessage(messageId).setMessage(size).setMessageColor(color);
        }

        public Builder setMessage(@Nullable CharSequence message, @ColorInt int color, float size) {
            return setMessage(message).setMessage(size).setMessageColor(color);
        }


        /**
         * setPositiveButton
         *
         * @param textId
         * @return
         */
        public Builder setPositiveButton(@StringRes int textId) {
            P.mPositiveButtonText = P.mContext.getText(textId);
            return this;
        }

        public Builder setPositiveButton(float size) {
            P.mPositiveButtonTextSize = size;
            return this;
        }

        public Builder setPositiveButton(boolean isVisible) {
            P.mPositiveButtonVisibility = isVisible;
            return this;
        }

        public Builder setPositiveButton(CharSequence text) {
            P.mPositiveButtonText = text;
            return this;
        }

        public Builder setPositiveButton(final IOSAlert.OnClickListener listener) {
            P.mPositiveButtonListener = listener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int textId, @ColorInt int color) {
            P.mPositiveButtonTextColor = color;
            return setPositiveButton(textId);
        }

        public Builder setPositiveButton(CharSequence text, @ColorInt int color) {
            P.mPositiveButtonTextColor = color;
            return setPositiveButton(text);
        }

        public Builder setPositiveButton(@StringRes int textId, final IOSAlert.OnClickListener listener) {
            return setPositiveButton(textId).setPositiveButton(listener);
        }

        public Builder setPositiveButton(CharSequence text, final IOSAlert.OnClickListener listener) {
            return setPositiveButton(text).setPositiveButton(listener);
        }

        public Builder setPositiveButton(@StringRes int textId, @ColorInt int color, final IOSAlert.OnClickListener listener) {
            P.mPositiveButtonTextColor = color;
            return setPositiveButton(textId).setPositiveButton(listener);
        }

        public Builder setPositiveButton(CharSequence text, @ColorInt int color, final IOSAlert.OnClickListener listener) {
            P.mPositiveButtonTextColor = color;
            return setPositiveButton(text).setPositiveButton(listener);
        }

        /**
         * setNegativeButton
         *
         * @param textId
         * @return
         */
        public Builder setNegativeButton(@StringRes int textId) {
            P.mNegativeButtonText = P.mContext.getText(textId);
            return this;
        }

        public Builder setNegativeButton(float size) {
            P.mNegativeButtonTextSize = size;
            return this;
        }

        public Builder setNegativeButton(boolean isVisible) {
            P.mNegativeButtonVisibility = isVisible;
            return this;
        }

        public Builder setNegativeButton(CharSequence text) {
            P.mNegativeButtonText = text;
            return this;
        }

        public Builder setNegativeButton(final IOSAlert.OnClickListener listener) {
            P.mNegativeButtonListener = listener;
            return this;
        }

        public Builder setNegativeButton(@StringRes int textId,  @ColorInt int color) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(textId);
        }

        public Builder setNegativeButton(CharSequence text,  @ColorInt int color) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(text);
        }

        public Builder setNegativeButton(@StringRes int textId, final IOSAlert.OnClickListener listener) {
            return setNegativeButton(textId).setNegativeButton(listener);
        }

        public Builder setNegativeButton(CharSequence text, final IOSAlert.OnClickListener listener) {
            return setNegativeButton(text).setNegativeButton(listener);
        }

        public Builder setNegativeButton(@StringRes int textId, @ColorInt int color, final IOSAlert.OnClickListener listener) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(textId).setNegativeButton(listener);
        }

        public Builder setNegativeButton(CharSequence text, @ColorInt int color, final IOSAlert.OnClickListener listener) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(text).setNegativeButton(listener);
        }

        /**
         * setCancelable
         *
         * @param cancelable
         * @return
         */
        public Builder setCancelable(boolean cancelable) {
            P.mCancelable = cancelable;
            return this;
        }

        /**
         * setView
         *
         * @param layoutResId
         * @return
         */
        public Builder setView(int layoutResId) {
            P.mContentView = null;
            P.mViewLayoutResId = layoutResId;
            P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            P.mContentView = view;
            P.mViewLayoutResId = 0;
            P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            P.mOnCancelListener = onCancelListener;
            return this;
        }


        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            P.mOnDismissListener = onDismissListener;
            return this;
        }


        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setCornerRadius(float dp) {
            P.mCornerRadius = dp;
            return this;
        }

        public IOSAlert create() {
            final IOSAlert dialog = new IOSAlert(P.mContext);
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
            if (P.mCancelable) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(P.mOnCancelListener);
            dialog.setOnDismissListener(P.mOnDismissListener);
            if (P.mOnKeyListener != null) {
                dialog.setOnKeyListener(P.mOnKeyListener);
            }
            return dialog;
        }

        public IOSAlert show() {
            final IOSAlert dialog = create();
            dialog.show();
            return dialog;
        }


    }

    public interface OnClickListener extends BaseDialog.OnClickListener<IOSAlert> {
    }


}
