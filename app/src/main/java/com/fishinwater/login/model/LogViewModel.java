package com.fishinwater.login.model;

import androidx.lifecycle.ViewModel;

import com.fishinwater.login.fragment.IOnResultListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @author fishinwater-1999
 * @version 2019-11-12
 */
public class LogViewModel extends ViewModel implements IBaseLog {

    private final String TAG = "LogViewModel";

    private final String LOG_IN_URL = "http://192.168.0.103/SitUp/LoginServlet";

    @Override
    public void login(String userAccount, String mPassword, final IOnResultListener logResultListener) {
        OkHttpUtils
                .post()
                .url(LOG_IN_URL)
                .addParams("username", userAccount)
                .addParams("password", mPassword)
                .build()
                .execute( new StringCallback(){

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        logResultListener.onFailed(e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        logResultListener.onSucceed(response);
                    }
                });
    }

    @Override
    public void resist(String userAccount, String mPassword, final IOnResultListener logResultListener) {
        OkHttpUtils
                .post()
                .url(LOG_IN_URL)
                .addParams("username", userAccount)
                .addParams("password", mPassword)
                .build()
                .execute( new StringCallback(){

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        logResultListener.onSucceed(response);
                    }
                });
    }

    @Override
    public void logout(IOnResultListener logResultListener) {

    }

}
