package com.mingying.androidmvpsample.weather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mingying.androidmvpsample.R;
import com.mingying.androidmvpsample.data.bean.WeatherDataBean;


/**
 * Created by caihanlin on 16/6/5.
 */
public class WeatherActivity extends AppCompatActivity implements WeatherContract.View {


    private TextView mCityName;

    private TextView mTemp;

    private TextView mWeatherDetail;

    private ProgressDialog mProgressDialog;

    private WeatherPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_layout);
        initViews();
        mPresenter = new WeatherPresenter(getApplicationContext(),this);
        mPresenter.loadWeatherData(true);

    }

    private void initViews(){
        mCityName = (TextView) findViewById(R.id.city_name);
        mTemp = (TextView) findViewById(R.id.weather_temp);
        mWeatherDetail = (TextView) findViewById(R.id.weather_detail);
    }

    @Override
    public void showProgressDialog() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setTitle("正在请求天气数据");
        }
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.cancel();
        }
    }

    @Override
    public void showWeatherUi(WeatherDataBean weatherDataBean) {
        if (weatherDataBean != null){
            mCityName.setText(weatherDataBean.getWeatherinfo().getCity());
            mTemp.setText(weatherDataBean.getWeatherinfo().getTemp());
            mWeatherDetail.setText(weatherDataBean.getWeatherinfo().getWD());
        }
    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        //这里用不到
    }
}
