package com.mingying.androidmvpsample.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;
import com.mingying.androidmvpsample.data.bean.WeatherDataBean;
import com.mingying.androidmvpsample.data.source.DataSource;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.util.TextUtils;

/**
 * Created by caihanlin on 16/6/5.
 */
public class WeatherRemoteDataSource implements DataSource {

    private static WeatherRemoteDataSource _INSTANCE;

    private WeatherRemoteDataSource(Context context){

    }

    public static WeatherRemoteDataSource getInstance(Context context){
        if (_INSTANCE == null){
            _INSTANCE = new WeatherRemoteDataSource(context);
        }

        return _INSTANCE;
    }

    /**
     * get the weather data from net
     * @param loadDataCallback
     */
    @Override
    public void getWeatherData(final LoadDataCallback loadDataCallback) {
        if (loadDataCallback == null){
            return;
        }
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get("http://www.weather.com.cn/adat/sk/101010100.html",new TextHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                if (!TextUtils.isEmpty(response)){
                    WeatherDataBean weatherDataBean = JSON.parseObject(response,WeatherDataBean.class);
                    loadDataCallback.loadDataSuccess(weatherDataBean);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                loadDataCallback.loadDataFailure(responseString);
                Log.e("chl","responseString  = "+ responseString);
            }
        });
    }


    @Override
    public void refresh() {
        // Not required because the {@link WeatherRepository} handles the logic of refreshing the
        // tasks from all the available data sources.
    }
}
