package com.mingying.androidmvpsample.data.source;

import android.content.Context;
import android.util.Log;

import com.mingying.androidmvpsample.data.source.local.WeatherLocalDataSource;
import com.mingying.androidmvpsample.data.source.remote.WeatherRemoteDataSource;


/**
 * Created by caihanlin on 16/6/5.
 */
public class WeatherRepository implements DataSource{

    private static WeatherRepository _INSTANCE;

    private WeatherLocalDataSource mLocalDataSource;

    private WeatherRemoteDataSource mRemoteDataSource;

    private boolean isRefresh;

    private WeatherRepository(Context context){
        mLocalDataSource = WeatherLocalDataSource.getInstance(context);
        mRemoteDataSource = WeatherRemoteDataSource.getInstance(context);
    }

    public static WeatherRepository getInstance(Context context){
        if (_INSTANCE == null){
            _INSTANCE = new WeatherRepository(context);
        }

        return _INSTANCE;
    }

    @Override
    public void getWeatherData(LoadDataCallback loadDataCallback) {
        if (isRefresh){
            mRemoteDataSource.getWeatherData(loadDataCallback);
        }else{
            Log.e("chl"," 还没处理本地缓存!");
        }
    }

    @Override
    public void refresh() {

    }

    public void setRefresh(boolean isRefresh){
        this.isRefresh = isRefresh;
    }



}
