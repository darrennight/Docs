package com.abay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class CustomViewGroup extends ViewGroup {

	public CustomViewGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

		
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		measureChildren(widthMeasureSpec, heightMeasureSpec);	
		
		setMeasuredDimension(widthSize, heightSize);
	}
	  
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

	    int mTotalHeight = 0;
		
        // ������������ͼ	
		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++) {
			View childView = getChildAt(i);
			
			// ��ȡ��onMeasure�м������ͼ�ߴ�
			int measureHeight = childView.getMeasuredHeight();
			int measuredWidth = childView.getMeasuredWidth();
			
			childView.layout(left, mTotalHeight, measuredWidth, mTotalHeight + measureHeight);
			
			mTotalHeight += measureHeight;
			
			Log.e("CustomViewGroup", "changed = " + changed 
	                + ", left = " + left + ", top = " + top 
	                + ", right = " + right + ", bottom = " + bottom 
	                + ", measureWidth = " + measuredWidth + ", measureHieght = " + measureHeight);
			
		}
	}
	
}
