package com.mingying.androidmvpsample.data.source.local;

import android.content.Context;

import com.mingying.androidmvpsample.data.source.DataSource;

/**
 * Created by caihanlin on 16/6/5.
 */
public class WeatherLocalDataSource implements DataSource {

    private static WeatherLocalDataSource _INSTANCE;

    private WeatherLocalDataSource(Context context){

    }

    public static WeatherLocalDataSource getInstance(Context context){
        if (_INSTANCE == null){
            _INSTANCE = new WeatherLocalDataSource(context);
        }

        return _INSTANCE;
    }

    @Override
    public void getWeatherData(LoadDataCallback loadDataCallback) {

    }

    @Override
    public void refresh() {
        // Not required because the {@link WeatherRepository} handles the logic of refreshing the
        // tasks from all the available data sources.
    }
}
