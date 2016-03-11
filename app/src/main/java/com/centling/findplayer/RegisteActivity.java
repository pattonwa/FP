package com.centling.findplayer;

import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class RegisteActivity extends Activity {
	private Button nextStepBtn;
	
	private TextView regAgreeContract;
	private CheckBox agreeContractChk;
	private TextView regAgreeContractText;
	private EditText regAcc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registe);
		
		nextStepBtn = (Button)findViewById(R.id.reg_nextStepBtn);
		regAcc = (EditText)findViewById(R.id.reg_accountEdit);
		
		nextStepBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO check if editText value is none before jumping.
				Intent intent = new Intent();
                intent.putExtra("user", regAcc.getText().toString().trim());
                intent.setClass(RegisteActivity.this,SetPwdActivity.class);
				RegisteActivity.this.startActivity(intent);
			}});

		regAgreeContract = (TextView)findViewById(R.id.reg_agree_contract);
		SpannableString ss = new SpannableString(regAgreeContract.getText());
		int length = (int)((regAgreeContract.getText()).length());
		ss.setSpan( new ClickableSpan() {
		      @Override
		      public void onClick(View widget) {
		        Intent intent = new Intent(Intent.ACTION_VIEW);
		        intent.setData(Uri.parse("http://www.baidu.com"));
		        startActivity(intent);
		      }
		    }, 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		regAgreeContract.setText(ss);
		regAgreeContract.setMovementMethod(LinkMovementMethod.getInstance());  

		agreeContractChk = (CheckBox)findViewById(R.id.reg_checkBox);
		agreeContractChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton nextStepBtn_tmp, boolean isChecked){
				if(isChecked){ 
					nextStepBtn.setEnabled(true); 
					//nextStepBtn.setTextColor(0xFF29981A);
					nextStepBtn.setBackgroundColor(0xFF00cccc);
                }else{ 
                	nextStepBtn.setEnabled(false); 
                	//nextStepBtn.setTextColor(0xFF6C6C6C);
                	nextStepBtn.setBackgroundColor(0xFF888888);
                }
			};
		});
	}

}
