package com.jandzy.news;

import android.app.Application;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class MyApplicant extends Application {

    private static MyApplicant myApplicant;

    private MyApplicant() {
        myApplicant = this;
    }

    public static MyApplicant getMyApplicant(){
        if(myApplicant==null){
            myApplicant = new MyApplicant();
        }
        return myApplicant;
    }
}
