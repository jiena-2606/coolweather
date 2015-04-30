/**
 * 
 */
package com.coolweather.app.receiver;

import com.coolweather.app.service.AutoUpdateService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author MjieQiu
 *
 */
public class AutoUpdateReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Intent intent = new Intent(arg0, AutoUpdateService.class);
		arg0.startService(intent);
	}

}
