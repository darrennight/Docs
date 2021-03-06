package com.abay.aml.handler;


import com.abay.aml.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * 
 * 实现的主要功能。
 * @version 1.0.0 
 * @author Abay Zhuang <br/>
 *		   Create at 2014-7-28
 */
public class HandlerActivity2 extends Activity {

	private final Handler mHandler = new MyHandler(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler.sendMessageDelayed(Message.obtain(), 60000);
 
        //just finish this activity
        finish();
    }
    
    
    public void todo(){};

    private static class MyHandler extends Handler{
        private final HandlerActivity2 mActivity;
        public MyHandler(HandlerActivity2 activity) {
            mActivity = activity;
        }
        @Override
        public void handleMessage(Message msg) {
            System.out.println(msg);
            if(mActivity == null) {
                return;
            }
            mActivity.todo();
        }
    }

}
