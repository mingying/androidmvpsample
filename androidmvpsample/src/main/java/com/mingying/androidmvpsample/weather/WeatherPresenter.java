package com.mingying.androidmvpsample.weather;

import android.content.Context;

import com.mingying.androidmvpsample.data.bean.WeatherDataBean;
import com.mingying.androidmvpsample.data.source.DataSource;
import com.mingying.androidmvpsample.data.source.WeatherRepository;

/**
 *
 * Listens to user actions from the UI ({@link WeatherActivity}), retrieves the data and updates the
 * UI as required.
 *
 * Created by caihanlin on 16/6/5.
 */
public class WeatherPresenter implements WeatherContract.Presenter {

    private WeatherContract.View mWeatherView;

    private WeatherRepository mWeatherRepository;

    public WeatherPresenter(Context context, WeatherContract.View view){
        mWeatherView = view;
        mWeatherRepository = WeatherRepository.getInstance(context);
    }

    @Override
    public void loadWeatherData(boolean forceUpdate) {
        mWeatherView.showProgressDialog();
        mWeatherRepository.setRefresh(forceUpdate);
        mWeatherRepository.getWeatherData(new DataSource.LoadDataCallback() {
            @Override
            public void loadDataSuccess(WeatherDataBean mainModelBean) {
                mWeatherView.hideProgressDialog();
                mWeatherView.showWeatherUi(mainModelBean);
            }

            @Override
            public void loadDataFailure(String Error) {
                mWeatherView.hideProgressDialog();
            }
        });
    }

    @Override
    public void start() {

    }
}
