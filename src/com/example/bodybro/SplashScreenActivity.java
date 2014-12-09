package com.example.bodybro;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

public class SplashScreenActivity extends Activity {
	AlertDialog disclaimerDialog;
	CountDownTimer timer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		//disclaimer
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("You should be in good physical condition and be able to participate in the exercise. Body Bro is not a licensed medical care provider and represents that it has no expertise in diagnosing, examining, or treating medical conditions of any kind, or in determining the effect of any specific exercise on a medical condition. You should understand that when participating in any exercise or exercise program, there is the possibility of physical injury. If you engage in this exercise or exercise program, you agree that you do so at your own risk, are voluntarily participating in these activities, assume all risk of injury to yourself, and agree to release and discharge Body Bro from any and all claims or causes of action, known or unknown, arising out of Body Bro's negligence.");
		builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
					
					timer = new CountDownTimer(3000, 1000) {
					
					@Override
					public void onTick(long millisUntilFinished) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onFinish() {
						//when timer finishes, go to main menu
						startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
					}
				};
				timer.start();
				dialog.dismiss();
			}
		});
		disclaimerDialog = builder.create();
		
		//when dialog is dismissed, start timer
		disclaimerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
			
			@Override
			public void onDismiss(DialogInterface dialog) {
				
				
			}
		});
		disclaimerDialog.show();
		
	}
}
