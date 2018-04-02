package com.example.shobhit.cityweather.ui.cityweather;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.shobhit.cityweather.R;
import com.example.shobhit.cityweather.business.CityWeatherFromServerUseCase;
import com.example.shobhit.cityweather.business.models.CityWeatherResponseDomainModel;
import com.example.shobhit.cityweather.ui.cityweather.viewmodels.CityWeatherViewModel;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CityWeatherActivity extends AppCompatActivity implements CityWeatherView {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private WeatherAdapter mAdapter;
    private ArrayList<CityWeatherViewModel> mDataList = new ArrayList<>();

    @BindView(R.id.cityWeatherRecyclerView)
    RecyclerView mCityWeatherRecyclerView;

    @BindView(R.id.cityNameEdittext)
    EditText mCityNameEditText;

    private CityWeatherPresenter mPresenter;
    private ProgressBar mProgressBar;

    protected RecyclerView.LayoutManager mLayoutManager;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, CityWeatherActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new CityWeatherPresenter(new CityWeatherFromServerUseCase<>());
        mPresenter.onAttach(this);
        initializeRecyclerView();
        initProgressBar();
        mPresenter.setCurrentCityName();

        if (savedInstanceState != null) {
            mDataList = savedInstanceState.getParcelableArrayList("Bundle");
            setData(mDataList);
        }
    }

    @Override
    public void setCurrentCityName() {
        mCityNameEditText.setText(getResources().getString(R.string.current_city_name));
    }

    private void initializeRecyclerView() {
        mCityWeatherRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(CityWeatherActivity.this);
        mCityWeatherRecyclerView.setLayoutManager(mLayoutManager);

        if (mDataList != null) {
            mAdapter = new WeatherAdapter(CityWeatherActivity.this, mDataList,
                    recyclerItemClickListener);
            mCityWeatherRecyclerView.setAdapter(mAdapter);
        }
    }

    @OnClick(R.id.downloadWeatherButton)
    public void getCityWeatherData(){
        if(checkPermission()){
            mPresenter.getCityWeatherData(mCityNameEditText.getText().toString(),
                    getResources().getString(R.string.api_key));
        } else {
            requestPermission();
        }
    }

    @Override
    public void setDataToRecyclerView(ArrayList<CityWeatherViewModel> cityWeatherViewModelList) {
        mDataList = cityWeatherViewModelList;
        mAdapter.setItems(mDataList);
        mAdapter.notifyDataSetChanged();
    }

    private void setData(ArrayList<CityWeatherViewModel> mDataList) {
        mAdapter = new WeatherAdapter(CityWeatherActivity.this, mDataList,
                recyclerItemClickListener);
        mCityWeatherRecyclerView.setAdapter(mAdapter);
    }

    private RecyclerViewItemClickListener recyclerItemClickListener =
            new RecyclerViewItemClickListener() {
        @Override
        public void onItemClick(CityWeatherResponseDomainModel cityWeather) {
        }
    };

    private void initProgressBar() {
        mProgressBar = new ProgressBar(this, null,
                android.R.attr.progressBarStyleLarge);
        mProgressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(mProgressBar);
        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        mProgressBar.setVisibility(View.INVISIBLE);
        this.addContentView(relativeLayout, params);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(CityWeatherActivity.this,
                getString(R.string.response_failure) + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(CityWeatherActivity.this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("Bundle",mDataList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.INTERNET},PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mPresenter.getCityWeatherData(mCityNameEditText.getText().toString(),
                            getResources().getString(R.string.api_key));
                } else {
                    Toast.makeText(CityWeatherActivity.this,
                            getResources().getString(R.string.permission_denied),
                            Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
