package com.example.bodybro;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		//initializing Parse.com stuff
		Parse.initialize(this, "05Bkc0xDEqMmdoXxvsGFodE8X55Ci3s1huL2yBh7", "uYz8u93WCYH509Zgc2GmOHd0VdnqE4ZHVCQsL85q");
	}
	
}
