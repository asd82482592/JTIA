package com.example.kam.jtia;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PreferenceUtil.init(this);

	    switchLanguage(PreferenceUtil.getString("language", "en"));
	}
	
	
	protected void switchLanguage(String language) {

		Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
       if (language.equals("zh")) {
            config.locale = Locale.TRADITIONAL_CHINESE;
        } else {
        	 config.locale = Locale.ENGLISH;
        }
        resources.updateConfiguration(config, dm);
        

        PreferenceUtil.commitString("language", language);
    }
}
