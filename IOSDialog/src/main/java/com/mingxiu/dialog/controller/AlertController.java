package com.mingxiu.dialog.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mingxiu.dialog.dialog.IOSAlert;
import com.mingxiu.dialog.utils.PixelUtils;

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

public class AlertController {

    private IOSAlert mIosAlert;

    public AlertController(IOSAlert iosAlert) {
        this.mIosAlert = iosAlert;
    }

    private void setContentView(View mContentView) {
        mIosAlert.getmContentView().setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mIosAlert.getmContentView().removeAllViews();
        mIosAlert.getmContentView().addView(mContentView);
    }

    private void setNegativeButton(final boolean isAutoDismiss, CharSequence mNegativeButtonText, int mNegativeButtonTextColor, final IOSAlert.OnClickListener mNegativeButtonListener) {
        if (mNegativeButtonText != null) {
            mIosAlert.getmTvNegative().setText(mNegativeButtonText);
        }
        if (mNegativeButtonTextColor != 0) {
            mIosAlert.getmTvNegative().setTextColor(mNegativeButtonTextColor);
        }

        mIosAlert.getmTvNegative().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAutoDismiss) {
                    mIosAlert.dismiss();
                }
                if (mNegativeButtonListener != null) {
                    mNegativeButtonListener.onClick(mIosAlert);
                }
            }
        });
    }

    private void setPositiveButton(final boolean isAutoDismiss, CharSequence mPositiveButtonText, int mPositiveButtonTextColor, final IOSAlert.OnClickListener mPositiveButtonListener) {
        if (mPositiveButtonText != null) {
            mIosAlert.getmTvPosittive().setText(mPositiveButtonText);
        }
        if (mPositiveButtonTextColor != 0) {
            mIosAlert.getmTvPosittive().setTextColor(mPositiveButtonTextColor);
        }

        mIosAlert.getmTvPosittive().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAutoDismiss) {
                    mIosAlert.dismiss();
                }
                if (mPositiveButtonListener != null) {
                    mPositiveButtonListener.onClick(mIosAlert);
                }
            }
        });
    }

    private void setMessage(CharSequence mMessage) {
        mIosAlert.getmMsg().setText(mMessage);
    }


    private void setMessageTextColor(int mMessageTextColor) {
        mIosAlert.getmMsg().setTextColor(mMessageTextColor);
    }

    private void setTitle(CharSequence mTitle) {
        mIosAlert.getmTitle().setText(mTitle);
    }

    private void setTitleTextColor(int mTitleTextColor) {
        mIosAlert.getmTitle().setTextColor(mTitleTextColor);
    }

    private void setPositiveButtonVisibility(boolean mPositiveButtonVisibility) {
        if (mPositiveButtonVisibility) {
            mIosAlert.getmTvPosittive().setVisibility(View.VISIBLE);
        } else {
            mIosAlert.getmTvPosittive().setVisibility(View.GONE);
        }
    }

    private void setNegativeButtonVisibility(boolean mNegativeButtonVisibility) {
        if (mNegativeButtonVisibility) {
            mIosAlert.getmTvNegative().setVisibility(View.VISIBLE);
        } else {
            mIosAlert.getmTvNegative().setVisibility(View.GONE);
        }
    }

    private void setTitleVisibility(boolean mTitleVisibility) {
        if (mTitleVisibility) {
            mIosAlert.getmTitle().setVisibility(View.VISIBLE);
        } else {
            mIosAlert.getmTitle().setVisibility(View.GONE);
        }
    }

    private void setMessageVisibility(boolean messageVisibility) {
        if (messageVisibility) {
            mIosAlert.getmMsg().setVisibility(View.VISIBLE);
        } else {
            mIosAlert.getmMsg().setVisibility(View.GONE);
        }
    }

    private void setPartingLineVisibility(boolean isVisible) {
        if (isVisible) {
            mIosAlert.getmPartingLine().setVisibility(View.VISIBLE);
        } else {
            mIosAlert.getmPartingLine().setVisibility(View.GONE);
        }
    }

    private void setBottomVisibility(boolean isVisible) {
        if (isVisible) {
            mIosAlert.getmLlBottom().setVisibility(View.VISIBLE);
            mIosAlert.getmPartingLineH().setVisibility(View.VISIBLE);
        } else {
            mIosAlert.getmLlBottom().setVisibility(View.GONE);
            mIosAlert.getmPartingLineH().setVisibility(View.GONE);
        }
    }

    private void setPositiveButtonTextSize(float mPositiveButtonTextSize) {
        if (mPositiveButtonTextSize != 0) {
            mIosAlert.getmTvPosittive().setTextSize(mPositiveButtonTextSize);
        }
    }

    private void setNegativeButtonTextSize(float mNegativeButtonTextSize) {
        if (mNegativeButtonTextSize != 0) {
            mIosAlert.getmTvNegative().setTextSize(mNegativeButtonTextSize);
        }
    }

    private void setMessageTextSize(float mMessageTextSize) {
        mIosAlert.getmMsg().setTextSize(mMessageTextSize);
    }

    private void setTitleTextSize(float mTitleTextSize) {
        mIosAlert.getmTitle().setTextSize(mTitleTextSize);
    }

    private void setCornerRadius(final float mCornerRadius, final int pressColor, final int normalColor) {
        GradientDrawable rootViewDrawable = new GradientDrawable();
        rootViewDrawable.setShape(GradientDrawable.RECTANGLE);
        rootViewDrawable.setColor(normalColor);
        rootViewDrawable.setCornerRadius(PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()));
        mIosAlert.getmRootView().setBackgroundDrawable(rootViewDrawable);
    }

    public static class AlertParams {
        public Activity mContext;
        @ColorInt
        public int mTitleTextColor;
        public CharSequence mTitle;
        public float mTitleTextSize;
        public boolean mTitleVisibility = false;

        @ColorInt
        public int mMessageTextColor;
        public CharSequence mMessage;
        public float mMessageTextSize;
        public boolean mMessageVisibility = false;

        @ColorInt
        public int mPositiveButtonTextColor;
        public CharSequence mPositiveButtonText;
        public float mPositiveButtonTextSize;
        public IOSAlert.OnClickListener mPositiveButtonListener;
        public boolean mPositiveButtonVisibility = false;


        @ColorInt
        public int mNegativeButtonTextColor;
        public CharSequence mNegativeButtonText;
        public float mNegativeButtonTextSize;
        public IOSAlert.OnClickListener mNegativeButtonListener;
        public boolean mNegativeButtonVisibility = false;

        public boolean mCancelable = true;
        public boolean isAutoDismiss = true;
        public View mContentView;
        public int mViewLayoutResId;
        public boolean mViewSpacingSpecified;

        public float mCornerRadius = 10;
        public float mMaxCornerRadius = 25;
        public float mMinCornerRadius = 0;

        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;

        @ColorInt
        public int mBackground_s = Color.parseColor("#e6e6e7");
        @ColorInt
        public int mBackground = Color.WHITE;


        public AlertParams(Activity context) {
            mContext = context;
        }

        public void apply(AlertController dialog) {
            if (!TextUtils.isEmpty(mTitle)) {
                mTitleVisibility = true;
            }
            if (!TextUtils.isEmpty(mMessage)) {
                mMessageVisibility = true;
            }
            if (!TextUtils.isEmpty(mPositiveButtonText) || mPositiveButtonListener != null) {
                mPositiveButtonVisibility = true;
            }
            if (!TextUtils.isEmpty(mNegativeButtonText) || mNegativeButtonListener != null) {
                mNegativeButtonVisibility = true;
            }
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

            if (mMessage != null) {
                dialog.setMessage(mMessage);
            }
            if (mMessageTextSize != 0) {
                dialog.setMessageTextSize(mMessageTextSize);
            }
            if (mMessageTextColor != 0) {
                dialog.setMessageTextColor(mMessageTextColor);
            }
            dialog.setMessageVisibility(mMessageVisibility);

            dialog.setNegativeButton(isAutoDismiss, mNegativeButtonText, mNegativeButtonTextColor, mNegativeButtonListener);
            dialog.setNegativeButtonVisibility(mNegativeButtonVisibility);
            dialog.setNegativeButtonTextSize(mNegativeButtonTextSize);
            dialog.setPositiveButton(isAutoDismiss, mPositiveButtonText, mPositiveButtonTextColor, mPositiveButtonListener);
            dialog.setPositiveButtonVisibility(mPositiveButtonVisibility);
            dialog.setPositiveButtonTextSize(mPositiveButtonTextSize);

            if (!mPositiveButtonVisibility && !mNegativeButtonVisibility) {
                dialog.setBottomVisibility(false);
            } else {
                dialog.setBottomVisibility(true);
            }
            if (!mPositiveButtonVisibility || !mNegativeButtonVisibility) {
                dialog.setPartingLineVisibility(false);
            } else {
                dialog.setPartingLineVisibility(true);
            }

            if (mContentView != null) {
                dialog.setContentView(mContentView);
            } else if (mViewLayoutResId != 0) {
                dialog.setContentView(mContext.getLayoutInflater().inflate(mViewLayoutResId, null));
            }
            if (mCornerRadius > mMinCornerRadius && mCornerRadius <= mMaxCornerRadius) {
                dialog.setCornerRadius(mCornerRadius, mBackground_s, mBackground);
                dialog.setNegativeButtonCornerRadius(mCornerRadius, mBackground_s, mBackground, mPositiveButtonVisibility);
                dialog.setPositiveButtonCornerRadius(mCornerRadius, mBackground_s, mBackground, mNegativeButtonVisibility);
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setNegativeButtonCornerRadius(final float mCornerRadius, final int pressColor, final int normalColor, boolean isPositiveButtonVisibility) {
        final GradientDrawable negativeDrawable = new GradientDrawable();
        negativeDrawable.setShape(GradientDrawable.RECTANGLE);
        negativeDrawable.setColor(normalColor);
        float[] radii;
        if (isPositiveButtonVisibility) {
            radii = new float[]{0, 0, 0, 0, 0, 0, PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext())};
        } else {
            radii = new float[]{0, 0, 0, 0, PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext())};
        }
        negativeDrawable.setCornerRadii(radii);
        mIosAlert.getmTvNegative().setBackgroundDrawable(negativeDrawable);
        mIosAlert.getmTvNegative().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        negativeDrawable.setColor(pressColor);
                        mIosAlert.getmTvNegative().setBackgroundDrawable(negativeDrawable);
                        break;
                    case MotionEvent.ACTION_UP:
                        negativeDrawable.setColor(normalColor);
                        mIosAlert.getmTvNegative().setBackgroundDrawable(negativeDrawable);
                        break;
                }
                return false;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setPositiveButtonCornerRadius(final float mCornerRadius, final int pressColor, final int normalColor, boolean isNegativeButtonVisibility) {
        final GradientDrawable PositiveDrawable = new GradientDrawable();
        PositiveDrawable.setShape(GradientDrawable.RECTANGLE);
        PositiveDrawable.setColor(normalColor);
        float[] radii;
        if (isNegativeButtonVisibility) {
            radii = new float[]{0, 0, 0, 0, PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), 0, 0};
        } else {
            radii = new float[]{0, 0, 0, 0, PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext()), PixelUtils.dp2px(mCornerRadius, mIosAlert.getContext())};
        }
        PositiveDrawable.setCornerRadii(radii);
        mIosAlert.getmTvPosittive().setBackgroundDrawable(PositiveDrawable);
        mIosAlert.getmTvPosittive().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        PositiveDrawable.setColor(pressColor);
                        mIosAlert.getmTvPosittive().setBackgroundDrawable(PositiveDrawable);
                        break;
                    case MotionEvent.ACTION_UP:
                        PositiveDrawable.setColor(normalColor);
                        mIosAlert.getmTvPosittive().setBackgroundDrawable(PositiveDrawable);
                        break;
                }
                return false;
            }
        });

    }

}
