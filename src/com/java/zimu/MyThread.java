package com.java.zimu;

import javax.swing.JLabel;

public class MyThread extends Thread{
	public  JLabel jLabel2;//通信，传值
	static int i=180;
	static boolean  IsRun=true;
	public void setL(JLabel jLabel2) {
		this.jLabel2=jLabel2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(IsRun) {
			try {
				Thread.sleep(1000);
				i--;
				jLabel2.setText("倒计时："+i);
				if(i==0) {
					IsRun=false;
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}


