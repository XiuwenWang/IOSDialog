package com.mingxiu.dialog.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mingxiu.dialog.R;
import com.mingxiu.dialog.dialog.IOSSheet;
import com.mingxiu.dialog.utils.PixelUtils;

import java.util.ArrayList;
import java.util.List;

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

public class SheetController {

    private IOSSheet mIosSheet;

    public SheetController(IOSSheet mIosSheet) {
        this.mIosSheet = mIosSheet;
    }

    private void setContentView(View mContentView) {
        mIosSheet.getmLlList().addView(mContentView);
    }

    private void setContentView(List<View> data) {
        for (int i = 0; i < data.size(); i++) {
            mIosSheet.getmLlList().addView(data.get(i));
            if (i != data.size() - 1) {
                View mPartingLine = new View(mIosSheet.getContext());
                mPartingLine.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
                mPartingLine.setBackgroundColor(mIosSheet.getContext().getResources().getColor(R.color.partingLineColor));
                mIosSheet.getmLlList().addView(mPartingLine);
            }
        }
    }

    private void setNegativeButton(CharSequence mNegativeButtonText, int mNegativeButtonTextColor, final IOSSheet.OnClickListener mNegativeButtonListener) {
        if (mNegativeButtonText != null) {
            mIosSheet.getmTvNegative().setText(mNegativeButtonText);
        }
        if (mNegativeButtonTextColor != 0) {
            mIosSheet.getmTvNegative().setTextColor(mNegativeButtonTextColor);
        }

        mIosSheet.getmTvNegative().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIosSheet.dismiss();
                if (mNegativeButtonListener != null) {
                    mNegativeButtonListener.onClick(mIosSheet);
                }
            }
        });
    }

    private void setTitle(CharSequence mTitle) {
        mIosSheet.getmTitle().setText(mTitle);
    }

    private void setTitleTextColor(int mTitleTextColor) {
        mIosSheet.getmTitle().setTextColor(mTitleTextColor);
    }

    private void setNegativeButtonVisibility(boolean mNegativeButtonVisibility) {
        if (mNegativeButtonVisibility) {
            mIosSheet.getmTvNegative().setVisibility(View.VISIBLE);
        } else {
            mIosSheet.getmTvNegative().setVisibility(View.GONE);
        }
    }

    private void setTitleVisibility(boolean mTitleVisibility) {
        if (mTitleVisibility) {
            mIosSheet.getmTitle().setVisibility(View.VISIBLE);
            mIosSheet.getmPartingLineH().setVisibility(View.VISIBLE);
        } else {
            mIosSheet.getmTitle().setVisibility(View.GONE);
            mIosSheet.getmPartingLineH().setVisibility(View.GONE);
        }
    }

    private void setTitleTextSize(float mTitleTextSize) {
        mIosSheet.getmTitle().setTextSize(mTitleTextSize);
    }

    private void setTopCornerRadius(final float mCornerRadius, final int pressColor, final int normalColor) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(normalColor);
        drawable.setCornerRadius(PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()));
        mIosSheet.getmLlTop().setBackgroundDrawable(drawable);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setNegativeButtonCornerRadius(final float mCornerRadius, final int pressColor, final int normalColor) {
        final GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(normalColor);
        drawable.setCornerRadius(PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()));
        mIosSheet.getmTvNegative().setBackgroundDrawable(drawable);
        mIosSheet.getmTvNegative().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        drawable.setColor(pressColor);
                        mIosSheet.getmTvNegative().setBackgroundDrawable(drawable);
                        break;
                    case MotionEvent.ACTION_UP:
                        drawable.setColor(normalColor);
                        mIosSheet.getmTvNegative().setBackgroundDrawable(drawable);
                        break;
                }
                return false;
            }
        });
    }

    public static class SheetParams {

        public Activity mContext;
        @ColorInt
        public int mTitleTextColor = Color.GRAY;
        public CharSequence mTitle;
        public float mTitleTextSize = 10;
        public boolean mTitleVisibility = false;

        public ArrayList<SheetItemParams> mData = new ArrayList<>();


        @ColorInt
        public int mNegativeButtonTextColor;
        public CharSequence mNegativeButtonText;
        public float mNegativeButtonTextSize;
        public IOSSheet.OnClickListener mNegativeButtonListener;
        public boolean mNegativeButtonVisibility = false;

        public float mCornerRadius = 10;
        public float mMaxCornerRadius = 25;
        public float mMinCornerRadius = 0;

        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public IOSSheet.OnItemClickListener mOnItemClickListener;
        public int mGravity = Gravity.BOTTOM;

        @ColorInt
        public int mBackground_s = Color.parseColor("#e6e6e7");
        @ColorInt
        public int mBackground = Color.WHITE;
        public boolean mCancelable = true;
        public ArrayList<View> mDataView = new ArrayList<>();
        public int mViewLayoutResId;
        public int mPaddingLeftRight = 8;
        public int mPaddingBottom = 8;

        public SheetParams(Activity mContext) {
            this.mContext = mContext;
        }

        public void apply(SheetController dialog) {
            if (!TextUtils.isEmpty(mTitle)) {
                mTitleVisibility = true;
            }
            if (!TextUtils.isEmpty(mNegativeButtonText) || mNegativeButtonListener != null) {
                mNegativeButtonVisibility = true;
            }
            dialog.setGravity(mGravity);
            if (mTitle != null) {
                dialog.setTitle(mTitle);
            }
            if (mTitleTextSize != 0) {
                dialog.setTitleTextSize(mTitleTextSize);
            }
            if (mTitleTextColor != 0) {
                dialog.setTitleTextColor(mTitleTextColor);
            }
            dialog.setTitleVisibility(mTitleVisibility);

            if (mData != null && mData.size() > 0) {
                dialog.setData(mData, mOnItemClickListener, mBackground_s, mBackground, mCornerRadius, mTitleVisibility);
            }

            dialog.setNegativeButton(mNegativeButtonText, mNegativeButtonTextColor, mNegativeButtonListener);
            dialog.setNegativeButtonVisibility(mNegativeButtonVisibility);
            dialog.setNegativeButtonTextSize(mNegativeButtonTextSize);

            if (mViewLayoutResId != 0) {
                mDataView.add(mContext.getLayoutInflater().inflate(mViewLayoutResId, null));
            }
            if (mDataView.size() != 0) {
                dialog.setContentView(mDataView);
            }

            if (mCornerRadius >= mMinCornerRadius && mCornerRadius <= mMaxCornerRadius) {
                if (mCornerRadius == 0) {
                    mPaddingLeftRight = 0;
                    mPaddingBottom = 0;
                }
                dialog.setTopCornerRadius(mCornerRadius, mBackground_s, mBackground);
                dialog.setNegativeButtonCornerRadius(mCornerRadius, mBackground_s, mBackground);
            }
            dialog.setPadding(mPaddingLeftRight, mPaddingBottom);
        }

    }

    private void setGravity(int mGravity) {
        if (mGravity == Gravity.CENTER) {
            mIosSheet.getWindow().setWindowAnimations(R.style.CenterAnimation);
        } else {
            if (mGravity == Gravity.BOTTOM) {
                mIosSheet.getWindow().setWindowAnimations(R.style.SheetAnimation);
            }
        }
        mIosSheet.getWindow().setGravity(mGravity);
    }

    private void setPadding(int mPaddingLeftRight, int mPaddingBottom) {
        mIosSheet.getmRootView().setPadding(PixelUtils.dp2px(mPaddingLeftRight, mIosSheet.getContext()),
                0,
                PixelUtils.dp2px(mPaddingLeftRight, mIosSheet.getContext()),
                PixelUtils.dp2px(mPaddingBottom, mIosSheet.getContext()));
    }


    private void setNegativeButtonTextSize(float mNegativeButtonTextSize) {
        if (mNegativeButtonTextSize != 0) {
            mIosSheet.getmTvNegative().setTextSize(mNegativeButtonTextSize);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setData(final ArrayList<SheetItemParams> mData, final IOSSheet.OnItemClickListener mOnItemClickListener, final int pressColor, final int normalColor, final float mCornerRadius, final boolean mTitleVisibility) {
        final LinearLayout llList = mIosSheet.getmLlList();
        for (int i = 0; i < mData.size(); i++) {
            SheetItemParams sheetItem = mData.get(i);
            TextView itemView = new TextView(mIosSheet.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, PixelUtils.dp2px(sheetItem.mItemHeight, mIosSheet.getContext()));
            itemView.setLayoutParams(layoutParams);
            itemView.setGravity(Gravity.CENTER);
            itemView.setPadding(PixelUtils.dp2px(sheetItem.getmItemPaddingLeft(), mIosSheet.getContext()), 0, PixelUtils.dp2px(sheetItem.getmItemPaddingRight(), mIosSheet.getContext()), 0);
            itemView.setText(sheetItem.getmItemTitle());
            if (sheetItem.getmItemTextColor() != 0) {
                itemView.setTextColor(sheetItem.getmItemTextColor());
            }
            if (sheetItem.getmItemTextSize() != 0) {
                itemView.setTextSize(sheetItem.getmItemTextSize());
            }
            itemView.setTag(i);
            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (mTitleVisibility) {
                        if ((Integer) view.getTag() == mData.size() - 1) {
                            final GradientDrawable negativeDrawable = new GradientDrawable();
                            negativeDrawable.setShape(GradientDrawable.RECTANGLE);
                            negativeDrawable.setColor(normalColor);
                            float[] radii = new float[]{0, 0, 0, 0,
                                    PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()),
                                    PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext())};
                            negativeDrawable.setCornerRadii(radii);
                            switch (motionEvent.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    negativeDrawable.setColor(pressColor);
                                    view.setBackgroundDrawable(negativeDrawable);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    negativeDrawable.setColor(normalColor);
                                    view.setBackgroundDrawable(negativeDrawable);
                                    break;
                            }
                        } else {
                            switch (motionEvent.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    view.setBackgroundColor(pressColor);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    view.setBackgroundColor(normalColor);
                                    break;
                            }
                        }
                    } else {
                        if (mData.size() == 1) {
                            final GradientDrawable negativeDrawable = new GradientDrawable();
                            negativeDrawable.setShape(GradientDrawable.RECTANGLE);
                            negativeDrawable.setColor(normalColor);
                            float[] radii = new float[]{
                                    PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()),
                                    PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()),
                                    PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()),
                                    PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext())};
                            negativeDrawable.setCornerRadii(radii);
                            switch (motionEvent.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    negativeDrawable.setColor(pressColor);
                                    view.setBackgroundDrawable(negativeDrawable);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    negativeDrawable.setColor(normalColor);
                                    view.setBackgroundDrawable(negativeDrawable);
                                    break;
                            }
                        } else {
                            if ((Integer) view.getTag() == mData.size() - 1) {
                                final GradientDrawable negativeDrawable = new GradientDrawable();
                                negativeDrawable.setShape(GradientDrawable.RECTANGLE);
                                negativeDrawable.setColor(normalColor);
                                float[] radii = new float[]{0, 0, 0, 0,
                                        PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()),
                                        PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext())};
                                negativeDrawable.setCornerRadii(radii);
                                switch (motionEvent.getAction()) {
                                    case MotionEvent.ACTION_DOWN:
                                        negativeDrawable.setColor(pressColor);
                                        view.setBackgroundDrawable(negativeDrawable);
                                        break;
                                    case MotionEvent.ACTION_UP:
                                        negativeDrawable.setColor(normalColor);
                                        view.setBackgroundDrawable(negativeDrawable);
                                        break;
                                }
                            } else if ((Integer) view.getTag() == 0) {
                                final GradientDrawable negativeDrawable = new GradientDrawable();
                                negativeDrawable.setShape(GradientDrawable.RECTANGLE);
                                negativeDrawable.setColor(normalColor);
                                float[] radii = new float[]{
                                        PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()),
                                        PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()), PixelUtils.dp2px(mCornerRadius, mIosSheet.getContext()),
                                        0, 0, 0, 0};
                                negativeDrawable.setCornerRadii(radii);
                                switch (motionEvent.getAction()) {
                                    case MotionEvent.ACTION_DOWN:
                                        negativeDrawable.setColor(pressColor);
                                        view.setBackgroundDrawable(negativeDrawable);
                                        break;
                                    case MotionEvent.ACTION_UP:
                                        negativeDrawable.setColor(normalColor);
                                        view.setBackgroundDrawable(negativeDrawable);
                                        break;
                                }
                            } else {
                                switch (motionEvent.getAction()) {
                                    case MotionEvent.ACTION_DOWN:
                                        view.setBackgroundColor(pressColor);
                                        break;
                                    case MotionEvent.ACTION_UP:
                                        view.setBackgroundColor(normalColor);
                                        break;
                                }
                            }
                        }

                    }
                    return false;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIosSheet.dismiss();
                    IOSSheet.OnClickListener listener = mData.get((Integer) view.getTag()).getListener();
                    if (listener != null) {
                        listener.onClick(mIosSheet);
                    }
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onClick((Integer) view.getTag(), mIosSheet);
                    }
                }
            });

            llList.addView(itemView);
            if (i != mData.size() - 1) {
                View mPartingLine = new View(mIosSheet.getContext());
                mPartingLine.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
                mPartingLine.setBackgroundColor(mIosSheet.getContext().getResources().getColor(R.color.partingLineColor));
                llList.addView(mPartingLine);
            }

        }
    }


    public static class SheetItemParams {
        @ColorInt
        public int mItemTextColor = Color.BLACK;
        public CharSequence mItemTitle;
        public float mItemTextSize = 16;
        public IOSSheet.OnClickListener listener;
        public float mItemHeight = 45;
        public int mItemPaddingLeft = 15;
        public int mItemPaddingRight = 15;

        public SheetItemParams() {
        }

        public SheetItemParams(int mMessageTextColor) {
            this.mItemTextColor = mMessageTextColor;
        }

        public SheetItemParams(CharSequence mMessage) {
            this.mItemTitle = mMessage;
        }

        public SheetItemParams(float mMessageTextSize) {
            this.mItemTextSize = mMessageTextSize;
        }

        public SheetItemParams(IOSSheet.OnClickListener listener) {
            this.listener = listener;
        }

        public SheetItemParams(int mMessageTextColor, CharSequence mMessage) {
            this.mItemTextColor = mMessageTextColor;
            this.mItemTitle = mMessage;
        }

        public SheetItemParams(int mMessageTextColor, float mMessageTextSize) {
            this.mItemTextColor = mMessageTextColor;
            this.mItemTextSize = mMessageTextSize;
        }

        public SheetItemParams(int mMessageTextColor, IOSSheet.OnClickListener listener) {
            this.mItemTextColor = mMessageTextColor;
            this.listener = listener;
        }

        public SheetItemParams(CharSequence mMessage, float mMessageTextSize) {
            this.mItemTitle = mMessage;
            this.mItemTextSize = mMessageTextSize;
        }

        public SheetItemParams(CharSequence mMessage, IOSSheet.OnClickListener listener) {
            this.mItemTitle = mMessage;
            this.listener = listener;
        }

        public SheetItemParams(float mMessageTextSize, IOSSheet.OnClickListener listener) {
            this.mItemTextSize = mMessageTextSize;
            this.listener = listener;
        }

        public SheetItemParams(int mMessageTextColor, CharSequence mMessage, float mMessageTextSize) {
            this.mItemTextColor = mMessageTextColor;
            this.mItemTitle = mMessage;
            this.mItemTextSize = mMessageTextSize;
        }

        public SheetItemParams(int mMessageTextColor, CharSequence mMessage, IOSSheet.OnClickListener listener) {
            this.mItemTextColor = mMessageTextColor;
            this.mItemTitle = mMessage;
            this.listener = listener;
        }

        public SheetItemParams(int mMessageTextColor, float mMessageTextSize, IOSSheet.OnClickListener listener) {
            this.mItemTextColor = mMessageTextColor;
            this.mItemTextSize = mMessageTextSize;
            this.listener = listener;
        }

        public SheetItemParams(CharSequence mMessage, float mMessageTextSize, IOSSheet.OnClickListener listener) {
            this.mItemTitle = mMessage;
            this.mItemTextSize = mMessageTextSize;
            this.listener = listener;
        }

        public SheetItemParams(int mMessageTextColor, CharSequence mMessage, float mMessageTextSize, IOSSheet.OnClickListener listener) {
            this.mItemTextColor = mMessageTextColor;
            this.mItemTitle = mMessage;
            this.mItemTextSize = mMessageTextSize;
            this.listener = listener;
        }

        public float getmItemPaddingLeft() {
            return mItemPaddingLeft;
        }

        public SheetItemParams setmItemPaddingLeft(int mItemPaddingLeft) {
            this.mItemPaddingLeft = mItemPaddingLeft;
            return this;
        }

        public float getmItemPaddingRight() {
            return mItemPaddingRight;
        }

        public SheetItemParams setmItemPaddingRight(int mItemPaddingRight) {
            this.mItemPaddingRight = mItemPaddingRight;
            return this;
        }

        public float getmItemHeight() {
            return mItemHeight;
        }

        public SheetItemParams setmItemHeight(float mItemHeight) {
            this.mItemHeight = mItemHeight;
            return this;
        }

        public int getmItemTextColor() {
            return mItemTextColor;
        }

        public SheetItemParams setmItemTextColor(int mItemTextColor) {
            this.mItemTextColor = mItemTextColor;
            return this;
        }

        public CharSequence getmItemTitle() {
            return mItemTitle;
        }

        public SheetItemParams setmItemTitle(CharSequence mItemTitle) {
            this.mItemTitle = mItemTitle;
            return this;
        }

        public float getmItemTextSize() {
            return mItemTextSize;
        }

        public SheetItemParams setmItemTextSize(float mItemTextSize) {
            this.mItemTextSize = mItemTextSize;
            return this;
        }

        public IOSSheet.OnClickListener getListener() {
            return listener;
        }

        public SheetItemParams setOnClickListener(IOSSheet.OnClickListener listener) {
            this.listener = listener;
            return this;
        }
    }
}
