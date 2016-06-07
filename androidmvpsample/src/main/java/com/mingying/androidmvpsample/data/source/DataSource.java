package com.mingying.androidmvpsample.data.source;

import com.mingying.androidmvpsample.data.bean.WeatherDataBean;

/**
 * Created by caihanlin on 16/6/5.
 */
public interface DataSource{

    interface LoadDataCallback{

        void loadDataSuccess(WeatherDataBean mainModelBean);

        void loadDataFailure(String error);
    }

    void getWeatherData(LoadDataCallback loadDataCallback);

    void refresh();
}
