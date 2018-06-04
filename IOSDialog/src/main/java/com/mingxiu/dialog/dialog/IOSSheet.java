package com.mingxiu.dialog.dialog;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mingxiu.dialog.R;
import com.mingxiu.dialog.controller.SheetController;

import java.util.ArrayList;
import java.util.List;

/**
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
public class IOSSheet extends BaseDialog {

    SheetController mAlert;
    LinearLayout mRootView;
    LinearLayout mLlTop;
    TextView mTvTitle;
    View mPartingLineH;
    LinearLayout mLlList;
    TextView mTvNegative;
    ArrayList<TextView> mData = new ArrayList<>();

    public IOSSheet(Activity context) {
        super(context);
        mAlert = new SheetController(this);
    }

    @Override
    protected ViewGroup.LayoutParams setDialog(Window window, Activity context) {
        window.setWindowAnimations(R.style.SheetAnimation);
        return new ViewGroup.LayoutParams(context.getWindowManager().getDefaultDisplay().getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public int getLayout() {
        return R.layout.sheet;
    }

    @Override
    protected void initViews(View rootView) {
        mRootView = (LinearLayout) rootView.findViewById(R.id.ll_boot);
        mLlTop = (LinearLayout) rootView.findViewById(R.id.ll_top);
        mTvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        mPartingLineH = rootView.findViewById(R.id.partingLine_h);
        mLlList = (LinearLayout) rootView.findViewById(R.id.ll_list);
        mTvNegative = (TextView) rootView.findViewById(R.id.tv_Negative);
    }

    public LinearLayout getmRootView() {
        return mRootView;
    }

    public void setmRootView(LinearLayout mRootView) {
        this.mRootView = mRootView;
    }

    public LinearLayout getmLlTop() {
        return mLlTop;
    }

    public void setmLlTop(LinearLayout mLlTop) {
        this.mLlTop = mLlTop;
    }

    public TextView getmTitle() {
        return mTvTitle;
    }

    public void setmTvTitle(TextView mTvTitle) {
        this.mTvTitle = mTvTitle;
    }

    public View getmPartingLineH() {
        return mPartingLineH;
    }

    public void setmPartingLineH(View mPartingLineH) {
        this.mPartingLineH = mPartingLineH;
    }

    public LinearLayout getmLlList() {
        return mLlList;
    }

    public void setmLlList(LinearLayout mLlList) {
        this.mLlList = mLlList;
    }

    public TextView getmTvNegative() {
        return mTvNegative;
    }

    public void setmTvNegative(TextView mTvNegative) {
        this.mTvNegative = mTvNegative;
    }

    public ArrayList<TextView> getmData() {
        return mData;
    }

    public void setmData(ArrayList<TextView> mData) {
        this.mData = mData;
    }

    public static class Builder {
        private final SheetController.SheetParams P;

        public Builder(@NonNull Activity context) {
            this.P = new SheetController.SheetParams(context);
        }

        @NonNull
        public Context getContext() {
            return P.mContext;
        }

        public Builder setAutoDismiss(boolean isAutoDismiss) {
            P.isAutoDismiss = isAutoDismiss;
            return this;
        }

        public Builder setPaddingLeftRight(int dp) {
            P.mPaddingLeftRight = dp;
            return this;
        }

        public Builder setGravity(int gravity) {
            P.mGravity = gravity;
            return this;
        }

        public Builder setPaddingBottom(int paddingBottom) {
            P.mPaddingBottom = paddingBottom;
            return this;
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

        public Builder setTitle(float size) {
            P.mTitleTextSize = size;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence title) {
            P.mTitle = title;
            return this;
        }

        public Builder addSheetItem(SheetController.SheetItemParams sheetItem) {
            P.mData.add(sheetItem);
            return this;
        }

        public Builder addSheetItem(List<View> viewList) {
            P.mDataView.addAll(viewList);
            return this;
        }

        public Builder addSheetItem(View view) {
            P.mDataView.add(view);
            return this;
        }

        public Builder addSheetItem(ArrayList<SheetController.SheetItemParams> sheetItemData) {
            P.mData.addAll(sheetItemData);
            return this;
        }

        public Builder addSheetItem(String[] sheetItemData) {
            for (String s : sheetItemData) {
                P.mData.add(new SheetController.SheetItemParams(s));
            }
            return this;
        }

        public Builder addSheetItem(String[] sheetItemData, IOSSheet.OnItemClickListener listener) {
            for (String s : sheetItemData) {
                P.mData.add(new SheetController.SheetItemParams(s));
            }
            P.mOnItemClickListener = listener;
            return this;
        }

        public Builder addSheetItem(ArrayList<SheetController.SheetItemParams> sheetItemData, IOSSheet.OnItemClickListener listener) {
            P.mData.addAll(sheetItemData);
            P.mOnItemClickListener = listener;
            return this;
        }

        public Builder addSheetItem(@StringRes int textId) {
            P.mData.add(new SheetController.SheetItemParams(P.mContext.getText(textId)));
            return this;
        }

        public Builder addSheetItem(@StringRes int textId, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(P.mContext.getText(textId), listener));
            return this;
        }

        public Builder addSheetItem(CharSequence text) {
            P.mData.add(new SheetController.SheetItemParams(text));
            return this;
        }

        public Builder addSheetItem(CharSequence text, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(text, listener));
            return this;
        }

        public Builder addSheetItem(@StringRes int textId, @ColorInt int color) {
            P.mData.add(new SheetController.SheetItemParams(color, P.mContext.getText(textId)));
            return this;
        }

        public Builder addSheetItem(CharSequence text, @ColorInt int color) {
            P.mData.add(new SheetController.SheetItemParams(color, text));
            return this;
        }

        public Builder addSheetItem(@StringRes int textId, float size) {
            P.mData.add(new SheetController.SheetItemParams(P.mContext.getText(textId), size));
            return this;
        }

        public Builder addSheetItem(CharSequence text, float size) {
            P.mData.add(new SheetController.SheetItemParams(text, size));
            return this;
        }

        public Builder addSheetItem(@StringRes int textId, float size, @ColorInt int color) {
            P.mData.add(new SheetController.SheetItemParams(color, P.mContext.getText(textId), size));
            return this;
        }

        public Builder addSheetItem(CharSequence text, @ColorInt int color, float size) {
            P.mData.add(new SheetController.SheetItemParams(color, text, size));
            return this;
        }

        public Builder addSheetItem(@StringRes int textId, float size, @ColorInt int color, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(color, P.mContext.getText(textId), size, listener));
            return this;
        }

        public Builder addSheetItem(CharSequence text, float size, @ColorInt int color, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(color, text, size, listener));
            return this;
        }

        public Builder addSheetItem(@StringRes int textId, @ColorInt int color, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(color, P.mContext.getText(textId), listener));
            return this;
        }

        public Builder addSheetItem(CharSequence text, @ColorInt int color, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(color, text, listener));
            return this;
        }

        public Builder addSheetItem(@StringRes int textId, float size, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(textId, size, listener));
            return this;
        }

        public Builder addSheetItem(CharSequence text, float size, IOSSheet.OnClickListener listener) {
            P.mData.add(new SheetController.SheetItemParams(text, size, listener));
            return this;
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

        public Builder setNegativeButton(final IOSSheet.OnClickListener listener) {
            P.mNegativeButtonListener = listener;
            return this;
        }

        public Builder setNegativeButton(@StringRes int textId, @ColorInt int color) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(textId);
        }

        public Builder setNegativeButton(CharSequence text, @ColorInt int color) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(text);
        }

        public Builder setNegativeButton(@StringRes int textId, final IOSSheet.OnClickListener listener) {
            return setNegativeButton(textId).setNegativeButton(listener);
        }

        public Builder setNegativeButton(CharSequence text, final IOSSheet.OnClickListener listener) {
            return setNegativeButton(text).setNegativeButton(listener);
        }

        public Builder setNegativeButton(@StringRes int textId, @ColorInt int color, final IOSSheet.OnClickListener listener) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(textId).setNegativeButton(listener);
        }

        public Builder setNegativeButton(CharSequence text, @ColorInt int color, final IOSSheet.OnClickListener listener) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(text).setNegativeButton(listener);
        }

        public Builder setNegativeButton(CharSequence text, @ColorInt int color, float size, final IOSSheet.OnClickListener listener) {
            P.mNegativeButtonTextColor = color;
            return setNegativeButton(text).setNegativeButton(listener).setNegativeButton(size);
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
            P.mViewLayoutResId = layoutResId;
            return this;
        }


        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnItemClickListener(OnItemClickListener onItemClickListener) {
            P.mOnItemClickListener = onItemClickListener;
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

        public IOSSheet create() {
            final IOSSheet dialog = new IOSSheet(P.mContext);
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

        public IOSSheet show() {
            final IOSSheet dialog = create();
            dialog.show();
            return dialog;
        }
    }

    public interface OnClickListener extends BaseDialog.OnClickListener<IOSSheet> {
    }

    public interface OnItemClickListener {
        void onClick(int position, IOSSheet dialog);
    }
}
