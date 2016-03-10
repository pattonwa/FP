package com.centling.findplayer.utils;

import android.os.Handler;
import android.os.Message;

public class AccessNetworkUtil implements Runnable{
    private String op ;  
    private String url;  
    private String params;  
    private Handler h;  
      
    public AccessNetworkUtil(String op, String url, String params,Handler h) {  
        super();  
        this.op = op;  
        this.url = url;  
        this.params = params;  
        this.h = h;  
    }  
  
    @Override  
    public void run() {  
        Message m = new Message();
        if(op.equals("GET")){
            m.obj = GetPostUtil.sendGet(url, params);
        }  
        if(op.equals("POST")){
            m.obj = GetPostUtil.sendPost(url, params);
        }  
        h.sendMessage(m);  
    }  
} 