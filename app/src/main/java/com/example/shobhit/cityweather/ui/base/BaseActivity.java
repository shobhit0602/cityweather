package com.example.shobhit.cityweather.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.shobhit.cityweather.R;

import butterknife.BindView;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setSupportActionBar(mToolbar);
    }
}
