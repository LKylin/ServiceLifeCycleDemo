package com.qst.servicedemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class KylinService extends Service {

	public static final String TAG = "KylinSercie";
	private final IBinder mBinder = new MyBinder();
	
	@Override
	public void onCreate() {
		Log.e(TAG, "onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.e(TAG, "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		Log.e(TAG, "onStart");
		super.onStart(intent, startId);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.e(TAG, "onBind");
		return mBinder;
	}
	
	@Override
	public void onRebind(Intent intent) {
		Log.e(TAG, "onRebind");
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.e(TAG, "onUnbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onDestroy() {
		Log.e(TAG, "onDestroy");
		super.onDestroy();
	}
	
	public class MyBinder extends Binder {
		public KylinService getService() {
			return KylinService.this;
		}
	}

}
