/**
 * 
 */
package com.coolweather.app.util;

/**
 * @author MjieQiu
 *
 */
public interface HttpCallbackListener {

	void onFinish(String response);
	void onError(Exception e);
}
