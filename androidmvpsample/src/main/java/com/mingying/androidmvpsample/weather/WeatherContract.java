package com.mingying.androidmvpsample.weather;

import com.mingying.androidmvpsample.BasePresenter;
import com.mingying.androidmvpsample.BaseView;
import com.mingying.androidmvpsample.data.bean.WeatherDataBean;

/**
 *
 * This specifies the contract between the view and the presenter.
 *
 * Created by caihanlin on 16/6/5.
 */
public interface WeatherContract {

    interface View extends BaseView<Presenter>{

        void showProgressDialog();

        void hideProgressDialog();

        void showWeatherUi(WeatherDataBean weatherDataBean);

        void showError(String error);

    }

    interface Presenter extends BasePresenter{

        void loadWeatherData(boolean forceUpdate);


    }
}
