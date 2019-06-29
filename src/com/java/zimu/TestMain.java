package com.java.zimu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TestMain {
	int speed=5;
	JFrame jFrame;
	String[] strings= {"a","b","c","d","e","f","g","h","i","j","k","l",
			"m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	ArrayList<Integer> k=new ArrayList<Integer>();
	int sum=0;
	Random random=new Random();
	int a=random.nextInt(26); 
	int b=random.nextInt(26); 
	int c=random.nextInt(26);
	int d=random.nextInt(26); 
	int e=random.nextInt(26); 
	int f=random.nextInt(26); 
	static boolean istrue=true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestMain().initView();
	}
	public void initView() {
		jFrame=new JFrame("字母游戏");
		jFrame.setBounds(500, 100, 600, 600);
		jFrame.setLayout(null);
		
		MyThread myThread=new MyThread();
		JLabel jLabel=new JLabel("你的成绩：");
		jLabel.setBounds(150, 520, 200, 20);
//		jLabel.setText("你的成绩是"+sum+"");
//		jFrame.add(jLabel);
		//设置背景图片
//		ImageIcon imageIcon=new ImageIcon("images/background.jpg");
//		JPanel panel=new JPanel() {
//			public void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				Graphics2D gg=(Graphics2D)g;
//				if (imageIcon!=null) {
//					gg.drawImage(imageIcon.getImage(), 0, 0, 500,
//							500,jFrame);
//					}
//				}
//		};
//		panel.setLayout(null);
//		jFrame.setContentPane(panel);
		ArrayList<DataInfo>list=new ArrayList<DataInfo>();
		DataInfo d1=new DataInfo(100, 0, strings[a]);
		list.add(d1);
		DataInfo d2=new DataInfo(200, 0, strings[b]);
		list.add(d2);
		DataInfo d3=new DataInfo(50, 0, strings[c]);
		list.add(d3);
		DataInfo d4=new DataInfo(290,0, strings[d]);
		list.add(d4);
		DataInfo d5=new DataInfo(220,0, strings[e]);
		list.add(d5);
		DataInfo d6=new DataInfo(350, 0, strings[f]);
		list.add(d6);
		MyCanvas myCanvas=new MyCanvas(list,myThread);
		myCanvas.setBounds(0, 0, 500, 500);
		
		//键盘
		myCanvas.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				char ch=e.getKeyChar();//返回按下的字母
				String string=String.valueOf(ch);//字符转字符串
//				String string2 =myCanvas.getStr();
//				if(string.equals(string2)) {
//					//myCanvas.setStr("a");
//					Random random=new Random();//随机类
//					int k=random.nextInt(26);//产生小于26的正整数
//					myCanvas.setStr(strings[k]);
//					myCanvas.setY(10); //设置新字母的出现位置
//					myCanvas.repaint();
//				}
//				System.out.println(string);
				
//				ArrayList<DataInfo>list=myCanvas.getList();
				//1获取当前集合
				//2遍历集合
                //3判断是否相等
				//4如果相等，随机获取新的字母替换旧的字母，修改y的坐标
			
//				for(int i=0;i<list.size();i++) {
//					
//					String string2=list.get(i).getName();
//					if(string.equals(string2)) {
//						speed+=5;
//						Random random=new Random();
//						int k=random.nextInt(26);
//						list.get(i).setName(strings[k]);
//						list.get(i).setY((int)(Math.random()*150));//随机字母位置
////					list.get(i).setY(70);
//						myCanvas.repaint();
//						b=true;
////					i=list.size();跳出循环判断
//					}
//					if (!string.equals(string2)) {
//						myCanvas.repaint();
//						b=false;
//					}
//					
//				}
				boolean b=true;
				for(int i=0;i<list.size();i++) {
					//s[i]=list.get(i).getName();
					String string2=list.get(i).getName();
					if(string.equals(string2)) {
						String[] sss = new String[6];
						int j=0;
						for(DataInfo as : list) {
							sss[j++] = as.getName();
						}
						Random random=new Random();
						int k;
						boolean asas = true;
						do {
							k=random.nextInt(26);
							if(strings[k].equals(sss[0]) || strings[k].equals(sss[1])|| 
							   strings[k].equals(sss[2])|| strings[k].equals(sss[3])|| 
							   strings[k].equals(sss[4])|| strings[k].equals(sss[5])) {
								k=random.nextInt(26);
							} else break;
						}
						while(asas);
						list.get(i).setName(strings[k]);
						list.get(i).setY((int)(Math.random()*150));//随机字母位置
//					    list.get(i).setY(70);
					    b=true;
						speed+=2;
						myCanvas.repaint();
						break;
				   } 
					else {
					b=false;
					myCanvas.repaint();
				   }
				}
				if (b) {
					sum+=10;
				}
				else {
					sum-=10;
				}
				jLabel.setText("你的成绩："+sum);
		      }
		});
		jFrame.add(myCanvas);
		
		JLabel jLabel2=new JLabel("倒计时：");
		jLabel2.setBounds(20, 520, 100, 20);
		myThread.setL(jLabel2);
		
		JButton jButton=new JButton("开始");
		jButton.setBounds(500, 270, 60, 60);
		jButton.setBackground(Color.white);
		jFrame.add(jButton);
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myThread.start();
				Thread thread=new Thread(new Runnable() {
					@Override
					public void run() {
//						myThread.setL(jLabel2);
//						myThread.start();
						// TODO Auto-generated method stub
						while(istrue) {
//							//先得到值
//							int y=myCanvas.getY();
//							y+=5;
//							myCanvas.setY(y);
//							//y改变
//							//myCanvas.invalidate();
//							myCanvas.repaint();
//							try {
//								Thread.sleep(100);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
							
							try {
								Thread.sleep(500);
								ArrayList<DataInfo>list=myCanvas.getList();
								for(int i=0;i<list.size();i++) {
									int y=list.get(i).getY();
									y+=speed;//y随着敲击键盘的速度改变
									if(y>500) {
										sum-=10;
										y=50;
										jLabel.setText("你的成绩："+sum);
									}
									list.get(i).setY(y);
								}
								myCanvas.setList(list);
								myCanvas.repaint();
							}catch(InterruptedException e){
								e.printStackTrace();
							}
						}
					}
				});
				thread.start();
			}
		});
		JButton jButton2=new JButton("结束");
		jButton2.setBounds(500, 400, 60, 60);
		jButton2.setBackground(Color.white);
		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (istrue) {
					istrue=false;
					MyThread.IsRun=false;
				}
			}
		});
		JButton jButton3=new JButton("重新开始");
		jButton3.setBounds(350, 510, 150, 40);
		jButton3.setBackground(Color.white);
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setY(0);
					sum=0;
					MyThread.i=180;
				}
				jLabel.setText("你的成绩："+sum);	
			}
		});
		jFrame.add(jButton3);
		jFrame.add(jButton2);
		jFrame.add(jLabel);
		jFrame.add(jLabel2);
		jFrame.setVisible(true);
	}
}
