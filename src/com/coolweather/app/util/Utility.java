/**
 * 
 */
package com.coolweather.app.util;

import android.text.TextUtils;

import com.coolweather.app.model.City;
import com.coolweather.app.model.CoolWeatherDB;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

/**
 * @author MjieQiu
 *
 */
public class Utility {

	public synchronized static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinceStrings = response.split(",");
			if(allProvinceStrings != null && allProvinceStrings.length > 0 ){
				for (String p : allProvinceStrings) {
					String[] arrayStrings = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(arrayStrings[0]);
					province.setProvinceName(arrayStrings[1]);
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	public synchronized static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB, String response, int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCitys = response.split(",");
			if(allCitys != null && allCitys.length > 0){
				for (String c : allCitys) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}
	
	public synchronized static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB, String response, int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCountys = response.split(",");
			if(allCountys != null && allCountys.length > 0){
				for (String cString : allCountys) {
					String[] arrayStrings = cString.split("\\|");
					County county = new County();
					county.setCityId(cityId);
					county.setCountyCode(arrayStrings[0]);
					county.setCountyName(arrayStrings[1]);
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}
}
