package com.example.bodybro;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		//pull the logic behind the login button and do stuff with it
		Button btnLogin = (Button) findViewById(R.id.button_login);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//pull the text from the top box to get username and the bottom box to get password
				String username = ((EditText)findViewById(R.id.edit_text_username)).getText().toString();
				String password = ((EditText)findViewById(R.id.edit_text_password)).getText().toString();
				ParseUser.logInInBackground(username, password, new LogInCallback() {
					
					@Override
					public void done(ParseUser user, ParseException e) {
						//if login succeeds, popup will appear
						if(user != null){
							Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
							startActivity(new Intent(LoginActivity.this, MainActivity.class));
						} else {
							//if login fails, print the error from ParseException e to the user
							Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
						}
					}
				});
				
			}
		});
		
		//register button logic
		Button btnRegister = (Button) findViewById(R.id.button_to_register);
		btnRegister.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//go to the register activity
				startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
			}
		});
	}
}
