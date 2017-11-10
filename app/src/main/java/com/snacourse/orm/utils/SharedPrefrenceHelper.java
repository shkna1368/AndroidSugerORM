package com.snacourse.orm.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sh-Java on 11/9/2017.
 */

public class SharedPrefrenceHelper {
    private String KEY_LOGIN="login";

    private static SharedPrefrenceHelper instance;
  private static SharedPreferences pref;
    private SharedPrefrenceHelper(){}

    public static SharedPrefrenceHelper getInstance(Context context){
        if(instance == null){
            instance = new SharedPrefrenceHelper();
             pref = context.getApplicationContext().getSharedPreferences("StudentPref", 0); // 0 - for private mode
        }
        return instance;
    }


public boolean alreadyLogin(){
  boolean result=  pref.getBoolean(KEY_LOGIN, false); // getting boolean
return result;
}

public void Login(){
    SharedPreferences.Editor editor = pref.edit();
   editor.putBoolean(KEY_LOGIN, true); // getting boolean
    editor.apply();
    editor.commit();

}



}
