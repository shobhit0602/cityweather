package com.example.shobhit.cityweather.ui.cityweather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shobhit.cityweather.R;
import com.example.shobhit.cityweather.ui.CommonUtils;
import com.example.shobhit.cityweather.ui.cityweather.viewmodels.CityWeatherViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private Context mContext;
    private ArrayList<CityWeatherViewModel> mCityWeatherList;
    private RecyclerViewItemClickListener mRecyclerViewItemClickListener;

    public WeatherAdapter(Context context, ArrayList<CityWeatherViewModel> cityWeatherList,
                          RecyclerViewItemClickListener recyclerItemClickListener) {
        this.mContext = context;
        this.mCityWeatherList = cityWeatherList;
        this.mRecyclerViewItemClickListener = recyclerItemClickListener;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_weather_data_row, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final CityWeatherViewModel cityWeatherViewModel = mCityWeatherList.get(position);

        holder.cityName.setText(cityWeatherViewModel.getName());
        holder.countryName.setText(cityWeatherViewModel.getCountryName());
        holder.cityWeather.setText(
                cityWeatherViewModel.getWeatherList().get(position).getDescription());
        holder.cityMaxTemp.setText(cityWeatherViewModel.getTempMax());
        holder.cityMinTemp.setText(cityWeatherViewModel.getTempMin());
        holder.cityTemp.setText(String.format(mContext.getResources().getString(R.string.degree_celcius),
                CommonUtils.convertFarenheitToCelcius(cityWeatherViewModel.getTemp())));
        holder.cityHumidity.setText(cityWeatherViewModel.getHumidity());
        holder.cityPressure.setText(cityWeatherViewModel.getPressure());

    }

    @Override
    public int getItemCount() {
        return mCityWeatherList.size();
    }

    public void setItems(ArrayList<CityWeatherViewModel> cityWeatherList) {
        this.mCityWeatherList = cityWeatherList;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {

         @BindView(R.id.cityName) TextView cityName;
         @BindView(R.id.countryName) TextView countryName;
         @BindView(R.id.cityWeather) TextView cityWeather;
         @BindView(R.id.cityMaxTemp) TextView cityMaxTemp;
         @BindView(R.id.cityMinTemp) TextView cityMinTemp;
         @BindView(R.id.cityWeatherTemp) TextView cityTemp;
         @BindView(R.id.cityHumidity) TextView cityHumidity;
         @BindView(R.id.cityPressure) TextView cityPressure;

        WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
