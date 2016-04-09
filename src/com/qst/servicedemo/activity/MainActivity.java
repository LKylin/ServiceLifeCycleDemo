package com.qst.servicedemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.qst.servicedemo.R;
import com.qst.servicedemo.service.KylinService;

public class MainActivity extends Activity {

	private KylinService mService = null;
	
	private ServiceConnection mServiceConn = new ServiceConnection() { 
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				mService = ((KylinService.MyBinder) (service)).getService();  
			}
			@Override
			public void onServiceDisconnected(ComponentName name) {
				mService = null;
			}  
	 };

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.act_main_next:
			Intent intentNext = new Intent(this, SecondActivity.class);
			startActivity(intentNext);
			break;
		case R.id.act_main_start:
			Intent intentStart = new Intent();
			intentStart.setAction("com.qst.servicedemo.service.KylinService");
			intentStart.setPackage(getPackageName());
			startService(intentStart);
			break;
		case R.id.act_main_bind:
			Intent intentBind = new Intent();
			intentBind.setAction("com.qst.servicedemo.service.KylinService");
			intentBind.setPackage(getPackageName());
		    bindService(intentBind, mServiceConn, Context.BIND_AUTO_CREATE);
			break;
		case R.id.act_main_unbind:
			unbindService(mServiceConn);
			break;
		case R.id.act_main_stop:
			Intent intentStop = new Intent();
			intentStop.setAction("com.qst.servicedemo.service.KylinService");
			intentStop.setPackage(getPackageName());
			stopService(intentStop);
			break;
		}
	}
}
