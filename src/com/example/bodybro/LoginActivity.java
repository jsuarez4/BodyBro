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
		
		Button btnLogin = (Button) findViewById(R.id.button_login);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String username = ((EditText)findViewById(R.id.edit_text_username)).getText().toString();
				String password = ((EditText)findViewById(R.id.edit_text_password)).getText().toString();
				ParseUser.logInInBackground(username, password, new LogInCallback() {
					
					@Override
					public void done(ParseUser user, ParseException e) {
						Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
						startActivity(new Intent(LoginActivity.this, MainActivity.class));
					}
				});
				
			}
		});
	}
}
