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
		jFrame=new JFrame("��ĸ��Ϸ");
		jFrame.setBounds(500, 100, 600, 600);
		jFrame.setLayout(null);
		
		MyThread myThread=new MyThread();
		JLabel jLabel=new JLabel("��ĳɼ���");
		jLabel.setBounds(150, 520, 200, 20);
//		jLabel.setText("��ĳɼ���"+sum+"");
//		jFrame.add(jLabel);
		//���ñ���ͼƬ
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
		
		//����
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
				char ch=e.getKeyChar();//���ذ��µ���ĸ
				String string=String.valueOf(ch);//�ַ�ת�ַ���
//				String string2 =myCanvas.getStr();
//				if(string.equals(string2)) {
//					//myCanvas.setStr("a");
//					Random random=new Random();//�����
//					int k=random.nextInt(26);//����С��26��������
//					myCanvas.setStr(strings[k]);
//					myCanvas.setY(10); //��������ĸ�ĳ���λ��
//					myCanvas.repaint();
//				}
//				System.out.println(string);
				
//				ArrayList<DataInfo>list=myCanvas.getList();
				//1��ȡ��ǰ����
				//2��������
                //3�ж��Ƿ����
				//4�����ȣ������ȡ�µ���ĸ�滻�ɵ���ĸ���޸�y������
			
//				for(int i=0;i<list.size();i++) {
//					
//					String string2=list.get(i).getName();
//					if(string.equals(string2)) {
//						speed+=5;
//						Random random=new Random();
//						int k=random.nextInt(26);
//						list.get(i).setName(strings[k]);
//						list.get(i).setY((int)(Math.random()*150));//�����ĸλ��
////					list.get(i).setY(70);
//						myCanvas.repaint();
//						b=true;
////					i=list.size();����ѭ���ж�
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
						list.get(i).setY((int)(Math.random()*150));//�����ĸλ��
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
				jLabel.setText("��ĳɼ���"+sum);
		      }
		});
		jFrame.add(myCanvas);
		
		JLabel jLabel2=new JLabel("����ʱ��");
		jLabel2.setBounds(20, 520, 100, 20);
		myThread.setL(jLabel2);
		
		JButton jButton=new JButton("��ʼ");
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
//							//�ȵõ�ֵ
//							int y=myCanvas.getY();
//							y+=5;
//							myCanvas.setY(y);
//							//y�ı�
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
									y+=speed;//y�����û����̵��ٶȸı�
									if(y>500) {
										sum-=10;
										y=50;
										jLabel.setText("��ĳɼ���"+sum);
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
		JButton jButton2=new JButton("����");
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
		JButton jButton3=new JButton("���¿�ʼ");
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
				jLabel.setText("��ĳɼ���"+sum);	
			}
		});
		jFrame.add(jButton3);
		jFrame.add(jButton2);
		jFrame.add(jLabel);
		jFrame.add(jLabel2);
		jFrame.setVisible(true);
	}
}
