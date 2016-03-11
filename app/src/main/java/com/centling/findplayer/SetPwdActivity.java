package com.centling.findplayer;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.centling.findplayer.utils.AccessNetworkUtil;
import com.centling.findplayer.utils.GetPostUtil;

public class SetPwdActivity extends Activity {
	private Button completeBtn;
	private EditText setPwPw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_pwd);
		
		completeBtn = (Button)findViewById(R.id.set_pwd_finishBtn);
		setPwPw = (EditText)findViewById(R.id.set_pwd_pwdEdit);

		final Handler hh = new Handler(){
	            @Override  
	            public void handleMessage(Message msg) {  

	            	String result = msg.obj.toString().trim();
	            	String returnCode = "";
	            	try {
						JSONObject dataJson = new JSONObject(result);
						returnCode = dataJson.getString("returnCode");
					} catch (JSONException e) {
						// TODO handle exception, doc logs
					}
	            	
	                if(returnCode.equals("200")){
		            	AlertDialog.Builder builder = new Builder(SetPwdActivity.this);
		               	builder.setTitle("提示");
		               	builder.setMessage("注册成功,确定后跳回主页");
		               	builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Intent intent = new Intent(SetPwdActivity.this,MainActivity.class); 
								SetPwdActivity.this.startActivity(intent);
							}
		               	});
		               	builder.show();
	                }else{
	                	//show.setText(msg.obj.toString() + ", wrong user or pw!");
	                	AlertDialog.Builder builder = new Builder(SetPwdActivity.this);
	                	 builder.setTitle("错误！");
	                	 builder.setMessage("注册失败");
	                	 builder.setPositiveButton("确定", null);
	                	 builder.show();
	                }  
	            }  
	        };  

		completeBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent_t = getIntent();
				String user = intent_t.getStringExtra("user");
				String password = setPwPw.getText().toString().trim();
				String param = "user=" + user + "&password=" + password;
				new Thread(new AccessNetworkUtil("POST", "http://172.20.10.10:8080/c2mwebservice/api/v1/public/registe", param, hh)).start();
			}
		});
	}

}
