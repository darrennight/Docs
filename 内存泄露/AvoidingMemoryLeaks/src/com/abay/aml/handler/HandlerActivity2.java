package com.abay.aml.handler;

import java.lang.ref.WeakReference;

import com.abay.avoidingmemoryleaks.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * 
 * ʵ�ֵ���Ҫ���ܡ�
 * 
 * @version 1.0.0
 * @author Abay Zhuang <br/>
 *         Create at 2014-7-28
 */
public class HandlerActivity2 extends Activity {

	private static final int MESSAGE_1 = 1;
	private static final int MESSAGE_2 = 2;
	private static final int MESSAGE_3 = 3;
	private final Handler mHandler = new MyHandler(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mHandler.sendMessageDelayed(Message.obtain(), 60000);

		// just finish this activity
		finish();
	}

	public void todo() {
	};

	private static class MyHandler extends Handler {
		private final WeakReference<HandlerActivity2> mActivity;

		public MyHandler(HandlerActivity2 activity) {
			mActivity = new WeakReference<HandlerActivity2>(activity);
		}

		@Override
		public void handleMessage(Message msg) {
			System.out.println(msg);
			if (mActivity.get() == null) {
				return;
			}
			mActivity.get().todo();
		}
	}

	private Runnable mRunnable = new Runnable() {

		@Override
		public void run() {

		}

	};

	/**
	 * һ�ж���Ϊ�˲�Ҫ��mHandler�����ˮ
	 */
	@Override
	public void onDestroy() {
		mHandler.removeMessages(MESSAGE_1);
		mHandler.removeMessages(MESSAGE_2);
		mHandler.removeMessages(MESSAGE_3);

		// ... ...

		mHandler.removeCallbacks(mRunnable);

		// ... ...
	}
//
//	@Override
//	public void onDestroy() {
//	    //  If null, all callbacks and messages will be removed.
//	    mHandler.removeCallbacksAndMessages(null);
//	}
	
}
