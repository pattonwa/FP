package com.centling.findplayer;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.centling.findplayer.utils.*;

public class LoginActivity extends Activity {
	private Button registeBtn;
	private Button submitBtn;
	private TextView forgetPwText;
	private EditText show;
	private EditText loginAcc;
	private EditText loginPw;
	
	@SuppressLint({ "JavascriptInterface", "HandlerLeak" })
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		registeBtn = (Button)findViewById(R.id.login_registBtn);
		submitBtn = (Button)findViewById(R.id.login_submitBtn);
		forgetPwText = (TextView)findViewById(R.id.login_forget_pw);
		loginAcc = (EditText)findViewById(R.id.login_accountEdit);
		loginPw = (EditText)findViewById(R.id.login_pwdEdit);

        final Handler h = new Handler(){  
            @Override  
            public void handleMessage(Message msg) {  

            	String result = msg.obj.toString().trim();
            	String returnCode = "";
            	try {
					JSONObject dataJson = new JSONObject(result);
					returnCode = dataJson.getString("returnCode");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
				}
            	
                if(returnCode.equals("200")){
	            	AlertDialog.Builder builder = new Builder(LoginActivity.this);
	               	builder.setTitle("提示：");
	               	builder.setMessage("登录成功，将跳回主页面");
	               	builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent(LoginActivity.this,MainActivity.class); 
		    				LoginActivity.this.startActivity(intent);
						}
	               	});
	               	builder.show();
                	
                }else{
                	//show.setText(msg.obj.toString() + ", wrong user or pw!");
                	AlertDialog.Builder builder = new Builder(LoginActivity.this);
                	 builder.setTitle("错误!");
                	 builder.setMessage("用户名或密码错误");
                	 builder.setPositiveButton("确定", null);
                	 builder.show();
                }  
            }  
        };  
		
		registeBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,RegisteActivity.class); 
				LoginActivity.this.startActivity(intent);
			}});
		
		submitBtn.setOnClickListener(new OnClickListener()  
        {  
            @Override  
            public void onClick(View v)  
            {  
                final String user = loginAcc.getText().toString().trim();
                final String password = loginPw.getText().toString().trim();
                String param = "user=" + user + "&password=" + password;
            	new Thread(new AccessNetworkUtil("POST", "http://172.20.10.10:8080/c2mwebservice/api/v1/public/findlogin", param, h)).start();
            }             
        });
		
		SpannableString ss = new SpannableString(forgetPwText.getText());
		int length = (int)((forgetPwText.getText()).length());
		ss.setSpan( new ClickableSpan() {
		      @Override
		      public void onClick(View widget) {
		        Intent intent = new Intent(LoginActivity.this, ForgetPwActivity.class);
		        startActivity(intent);
		      }
		    }, 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		forgetPwText.setText(ss);
		forgetPwText.setMovementMethod(LinkMovementMethod.getInstance());

	}

}
