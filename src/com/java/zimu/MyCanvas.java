package com.java.zimu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//此类不加逻辑
import java.util.ArrayList;
import java.util.Random;
public class MyCanvas extends Canvas{
//	private int sum=0;
//	private int y;
//	private String str;
//	public MyCanvas(int y,String str) {
//		this.y=y;
//		this.str=str;
//	}
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		Font font=new Font(null, HEIGHT, 50);//w的字体及其大小
//		g.setFont(font);
//		g.drawString(str, 50, y);//字符串及其x坐标
//	}
//	public void setY(int y) {
//		this.y=y;
//	}
//	public int getY() {         
//		return y;
//	}
//	public void setStr(String str) {
//		this.str=str;
//	}
//	public String getStr() {
//		return str;
//	}
	private ArrayList<DataInfo>list=new ArrayList<DataInfo>();
	public MyCanvas(ArrayList<DataInfo>list,MyThread myThread) {
		this.list=list;
		this.myThread=myThread;
	}
	
	MyThread myThread;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.pink);
		g.fillRect(0, 0, 500, 500);//画矩形
		Font font=new Font(getName(),HEIGHT,35);
		g.setFont(font);
		g.setColor(Color.blue);
		MyCanvas.getRandColor();
		g.setColor(getRandColor());
		if (MyThread.IsRun==false) {
			 g.drawString("Game Over!", 200, 250);
			 TestMain.istrue=false;
		}
		if (TestMain.istrue) {
			for(int i=0;i<list.size();i++) {
				g.drawString(list.get(i).getName(), list.get(i).getX(), list.get(i).getY());			
			}
		}
	}
	//字体改变颜色
	public static Color getRandColor() {
		Random random=new Random();
		Color color=new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		return color;
	}
	public ArrayList<DataInfo>getList(){
		return list;
	}
	public void setList(ArrayList<DataInfo>list) {
		this.list=list;
	}
}
