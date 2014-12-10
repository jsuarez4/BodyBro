package com.example.bodybro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		setTitle("Body Bro");
		Button btnFinish = (Button) findViewById(R.id.button_finish);
		btnFinish.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//make a blank parseuser to submit and register to parse.com
				ParseUser currentUser = new ParseUser();
				
				//pull username and password
				String username = ((EditText)findViewById(R.id.edit_text_register_username)).getText().toString();
				String password = ((EditText)findViewById(R.id.edit_text_register_password)).getText().toString();
				
				//set username and pass for the parseuser
				currentUser.setUsername(username);
				currentUser.setPassword(password);
				
				//signup using a separate thread in the background done() will be called when complete
				currentUser.signUpInBackground(new SignUpCallback() {
					
					@Override
					public void done(ParseException e) {
						if (e == null) {
							//registered successfully if e is null
							Toast.makeText(RegisterActivity.this, "Succesfully signed up!", Toast.LENGTH_SHORT).show();
							startActivity(new Intent(RegisterActivity.this, MainActivity.class));
						} else {
							//register failed!!!!
							Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
						}
					}
				});
				
				
			}
		});
	}
}
