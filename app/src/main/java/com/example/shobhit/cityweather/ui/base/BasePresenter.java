package com.example.shobhit.cityweather.ui.base;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class BasePresenter<V extends BaseView> {

    private V mMvpView;

    public BasePresenter(){
    }

   public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public void onDetach() {
        mMvpView = null;
    }

    protected V getMvpView() {
        return mMvpView;
    }
}
