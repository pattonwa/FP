package com.centling.findplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class ForgetPwActivity extends ActionBarActivity{
	
	private Button fetchNewPw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget_pw);
		
		fetchNewPw = (Button)findViewById(R.id.forget_pw_finishBtn);
		fetchNewPw.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ForgetPwActivity.this,LoginActivity.class); 
				ForgetPwActivity.this.startActivity(intent);
			}});
	}
}
