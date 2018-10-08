package newSwin;
import sun.audio.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.ui.*;
import javafx.application.*;
import javafx.collections.FXCollections;  
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.collections.*;
import java.awt.Color;
import java.awt.FlowLayout;

import javafx.scene.control.Label;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.jws.soap.SOAPBinding.Style;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

public class Test  extends JFrame implements ActionListener,KeyListener
{
	
	static JLabel lblSelectTwoSimilar= null;
	static JButton btnSubmit=null;
	static JButton btnNewButton =null;
	static HashSet<String> hs;
	static String sent ="";
	static long timestamp;
	static int lll=1;
	JLabel ln = null;
	static JLabel label;
	static JLabel label_1;
	static JLabel label_2;
	static JRadioButton rb;
	static JRadioButton rb1;
	static JRadioButton rb2;
	static int mm =0;
	static int ss =0;
	static JButton btnListening = null;
	static JButton btnWriting= null;
	static JButton btnMaths = null;
	static JButton btnImageRec = null;
	static JButton btnReading =null;
	static timer t = new timer();
	static timer sound = new timer();
	static JPanel panel = null;
	static Question question = null;
	static boolean flag = false;
	static JButton btnOptExtraTime = null;
	private static JTextPane textField;
	private String word="";
	public static boolean flaglog=false;
	public static boolean afl =true;
	protected static boolean flag11=false;
	static Student student;
	protected static boolean timer=true;;
	static JPanel panel_1 = null;
	static JPanel panel_2=null;
	static JLabel lblNewLabel = null;
	static boolean glag= false;
	private static JButton btnMaths1;
	private static JButton btnImageRec1;
	private static JButton btnListening1;
	private static JButton btnReading1;
	private static JButton btnWriting1;
	private static JButton btnStat;
	private static class timer extends Thread
	{
		void music() throws Exception
		{
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\mulla\\eclipse-workspace\\newSwin\\timer.wav"));
			AudioInputStream ain = AudioSystem.getAudioInputStream(in);

			Clip c = AudioSystem.getClip();
			c.open(ain);

			while(afl)
			{
				c.loop(1);
			}
		}
		void setStart()
		{
			panel_1.removeAll();
		}
		public void run()
		{
			mm=0;
			ss=0;
		//	System.out.println("11");
			panel_1.removeAll();
			long timecons = student.currTime;
			long sec =0;
			long min=0;
			long asec=0;
			
			sec= timecons/1000;
			min = sec/60;
			asec = sec%60;
			
			lblNewLabel.setText(min+" : "+asec);
			panel_1.add(lblNewLabel);
			panel_1.revalidate();
			panel_1.repaint();
			long milli=System.currentTimeMillis();
			long as;
		//	System.out.println("222");
		//	System.out.println(timer+" "+min);
			timer =true;
			while(timer&&min<3)
			{
				//System.out.println("333");
				
				mm=(int)min;
				
				ss=(int)sec;
				if(question.subject=="Maths")
				{
					if(min>=3)
					{
						lblNewLabel.setForeground(Color.red);
						try {
							sound.music();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				if(question.subject=="Image")
				{
					if(min>=3)
					{
						lblNewLabel.setForeground(Color.red);
						try {
							sound.music();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(min==3)
						{
							break;
						}
					}
				}
				if(question.subject=="Spell")
				{
					
					if(timestamp+10000<System.currentTimeMillis()&&!glag)
					{
						question.takenhint=true;
						JDialog d  = new JDialog();
						System.out.println(question.hint);
						d.getContentPane().add(new JLabel(question.hint));
						d.setSize(300,100);
						d.setVisible(true);
						glag=true;
						new Timer(5000, new ActionListener()
								{

									@Override
									public void actionPerformed(ActionEvent e) 
									{
										d.setVisible(false);
										
									}
									
								}).start();
					}
					if(min>=3)
					{
						lblNewLabel.setForeground(Color.red);
						try {
							sound.music();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(min==3)
						{
							break;
						}
					}
				}
				if(question.subject=="Write")
				{
					if(min>=3)
					{
						lblNewLabel.setForeground(Color.red);
						try {
							sound.music();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(min==3)
						{
							break;
						}
					}
				}
				if(question.subject=="Listen")
				{
					int delim;
					delim=check();
					if(min>=delim)
					{
						lblNewLabel.setForeground(Color.red);
						try {
							sound.music();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(min==delim+1)
						{
							break;
						}
					}
				}

				as=System.currentTimeMillis()-milli;
				if(sec==60)
				{
					sec=0;
					min++;
				}
				if(as>=1000)
				{
					milli=System.currentTimeMillis();
					sec++;
					student.currTime = student.currTime+1000;
					if(sec%10==0)
					{try {
						student.save();
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
					if(sec<=9)
						lblNewLabel.setText(min+" : 0"+sec);
					else 
						lblNewLabel.setText(min+" : "+sec);
				}
				try
				{
					synchronized(t)
					{
						t.wait(1);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				panel_1.add(lblNewLabel);
		//		System.out.println("ghn");
			}
			
			try {
				student.currTime=0;
				student.save();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(min==2&&sec==60)
			{
				JOptionPane.showMessageDialog(null,"Your time for this section is up.");
				student.subCount++;
				if(student.subCount>=5)
				{
					examFinish();
				}
			}
				
			try {
				endSection();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	Test(int pin, Student st) throws Exception
	{
		
		setBounds(30,30, 700, 800);
		student=st;
		
		
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 118, 674, 215);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(595, 45, 89, 62);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 11, 69, 40);
		panel_1.add(lblNewLabel);
		
		
		btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(flag)
				{
					afl = false;
					timer = false;
					question.questionno=student.questionnum;
					student.questionnum++;
					System.out.println(student.questionnum);
					
					String ans = textField.getText();
					String sub = question.subject;
					if(!sub.equalsIgnoreCase("Image"))
					{
					if(ans.equalsIgnoreCase(question.answer))
					{
						valueQuestion();
					}
					}
					else
					{
						getContentPane().remove(lblSelectTwoSimilar);
						boolean flag1,flag2;
						flag1= false;
						flag2 =false;
						String line[] = question.answer.split(" ");
						if(line[0]=="1"||line[1]=="1")
						{
							if(rb.isSelected())
							{
								flag1=true;
							}
						}
						if(line[0]=="2"||line[1]=="2")
						{
							if(rb1.isSelected())
							{
								if(flag1)
								{
									flag2 = true;
								}
								else
								{
									flag1 =true;
								}
							}
						}
						if(line[0]=="3"||line[1]=="3")
						{
							if(rb2.isSelected())
							{
								if(flag1)
								{
									flag2=true;
								}
								else
								{
									flag1 = true;
								}
							}
						}
						if(flag1&&flag2)
						{
							if(question.difficulty==1)
							{
								question.marksobtained=2;
								student.imagemark = student.imagemark+2;
								student.updateMarks(2);
							}
							else if(question.difficulty==2)
							{
								question.marksobtained=5;
								student.imagemark=student.imagemark+5;
								student.updateMarks(5);
							}
							else if(question.difficulty==3)
							{
								question.marksobtained=10;
								student.imagemark=student.imagemark+10;
								student.updateMarks(10);
							}
							
						}
						try {
							student.updateQuestionList(question);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					try {
						student.save();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					student.subCount++;
					if(student.subCount>=5)
					{
						System.out.println("dd");
						examFinish();
					}
					else
					{
						try {
							endSection();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(647, 422, 65, 23);
		btnNewButton.setEnabled(false);
		
		getContentPane().add(btnNewButton);
		
		
		btnSubmit = new JButton("Submit & Next");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				question.questionno=student.questionnum;
				student.questionnum++;
				btnNewButton.setEnabled(true);
				System.out.println(student.questionnum);
				
				String ans = textField.getText();
				String sub = question.subject;
				if(!sub.equalsIgnoreCase("Image"))
				{
				if(!question.subject.contentEquals("Write")&&ans.equalsIgnoreCase(question.answer))
				{
					valueQuestion();
					int diff =question.difficulty;
					if(diff==3)
					{
						question = new Question(sub,3);
					}
					else
					{
						question = new Question(sub,++diff);
					}
				}
				else if(question.subject.contentEquals("Write"))
				{
					boolean fla = false;
					String text[] = textField.getText().split(" ");
					for(int i=0;i<text.length;i++)
					{
						if(hs.contains(text[i]))
						{
							continue;
						}
						else
						{
							fla = true;
							break;
						}
					}
					if(!fla)
					{
						int diff = question.difficulty;
						if(diff==1)
						{
							question = new Question(sub,1);
						}
						else
						{
							question =  new Question(sub,--diff);
						}
					}
				}
				else
				{
					int diff = question.difficulty;
					if(diff==1)
					{
						question = new Question(sub,1);
					}
					else
					{
						question =  new Question(sub,--diff);
					}
				}
				}
				else
				{
					boolean flag1,flag2;
					flag1= false;
					flag2 =false;
					String line[] = question.answer.split(" ");
				//	System.out.println(line[0]+" "+line[1]);
					if(line[0].equalsIgnoreCase("1")||line[1].equalsIgnoreCase("1"))
					{
					//System.out.println("\n\n"+" 11 11 ");
						if(rb.isSelected())
						{
							flag1=true;
						}
					}
					if(line[0].equalsIgnoreCase("2")||line[1].equalsIgnoreCase("2"))
					{
						if(rb1.isSelected())
						{
							if(flag1)
							{
								flag2 = true;
							}
							else
							{
								flag1 =true;
							}
						}
					}
					if(line[0].equalsIgnoreCase("3")||line[1].equalsIgnoreCase("3"))
					{
						if(rb2.isSelected())
						{
							if(flag1)
							{
								flag2=true;
							}
							else
							{
								flag1 = true;
							}
						}
					}
					if(flag1&&flag2)
					{
						if(question.difficulty==1)
						{
							question.marksobtained=2;
							student.imagemark = student.imagemark+2;
							student.updateMarks(2);
							question = new Question(sub,2);
						}
						else if(question.difficulty==2)
						{
							question.marksobtained=5;
							student.imagemark=student.imagemark+5;
							student.updateMarks(5);
							question = new Question(sub,3);
						}
						else if(question.difficulty==3)
						{
							question.marksobtained=10;
							student.imagemark=student.imagemark+10;
							student.updateMarks(10);
							question = new Question(sub,3);
						}
						
					}
					else
					{
					//	System.out.println("\n\n"+" kkkk ");
						int diff = question.difficulty;
						if(diff==1)
						{
						//	System.out.println("\n\n"+" crkt");
							question = new Question(sub,1);
						}
						else
						{
						//	System.out.println("\n\n"+" wrng   "+diff);
							question =  new Question(sub,--diff);
						}
					}
					try {
						student.updateQuestionList(question);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					student.save();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				student.curr = question;
				panel.removeAll();
				JLabel ln = new JLabel();
				if(sub!="Image"&&sub!="Listen")
				{
					if(sub=="Write")
					{
						glag=false;
						timestamp = System.currentTimeMillis();
					}
					try {
						ln.setText(question.getQuestion(student));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ln.setBounds(147, 11, 238, 135);
					panel.add(ln);
					panel.repaint();
					panel.revalidate();
					getContentPane().validate();
				}
				else if (sub.equalsIgnoreCase("Image"))
				{
					panel.removeAll();
					String line[] = null;
					try {
						line = question.getQuestion(student).split(" ");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rb = new JRadioButton("");
					rb.setBounds(28, 47, 21, 23);
					panel.add(rb);
					
					rb1 = new JRadioButton("");
					rb1.setBounds(283, 47, 21, 23);
					panel.add(rb1);
					
					rb2= new JRadioButton("");
					rb2.setBounds(485, 47, 21, 23);
					panel.add(rb2);
					
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(line[0]));
					label.setBounds(55, 11, 222, 193);
					panel.add(label);
					
					JLabel label_1 = new JLabel("");
					label_1.setIcon(new ImageIcon(line[1]));
					label_1.setBounds(310, 11, 169, 193);
					panel.add(label_1);
					
					JLabel label_2 = new JLabel("");
					label_2.setIcon(new ImageIcon(line[2]));
					label_2.setBounds(507, 11, 157, 193);
					panel.add(label_2);
					panel.repaint();
					panel.revalidate();
				}
				else if(sub.equalsIgnoreCase("Listen"))
				{
					if(!flag11)
					{
						BufferedInputStream in=null;
						try {
							in = new BufferedInputStream(new FileInputStream(question.getQuestion(student)));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						AudioInputStream ain = null;
						try {
							ain = AudioSystem.getAudioInputStream(in);
						} catch (UnsupportedAudioFileException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Clip c = null;
						try {
							c = AudioSystem.getClip();
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							c.open(ain);
						} catch (LineUnavailableException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						c.loop(1);
					}
					else
					{
						ArrayList<Question> arr  = student.hm.get("Listen");
						try
						{
							if(arr.size()>=lll)
								{
									question = arr.get(lll);
									lll++;
								}
							else
							{
								flag11=false;
								BufferedInputStream in = new BufferedInputStream(new FileInputStream(arr.get(lll).question));
								AudioInputStream ais = AudioSystem.getAudioInputStream(in);
								Clip c = AudioSystem.getClip();
								c.open(ais);
								c.loop(1);
								lll++;
							}
							
						}
						catch(Exception ee)
						{
							ee.printStackTrace();
						}
					}
				}
				
				
		//		System.out.println("4444");
				
			}
		});
		btnSubmit.setBounds(10, 422, 157, 23);
		getContentPane().add(btnSubmit);
		
		
		
		textField = new JTextPane();
		textField.setBounds(244, 360, 229, 33);
		getContentPane().add(textField);
		
		
		btnOptExtraTime = new JButton("Opt Extra Time");
		btnOptExtraTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				HashMap hm = student.hm;
				ArrayList<Question> arr = (ArrayList<Question>) hm.get("Listen");
				try
				{
					BufferedInputStream in = new BufferedInputStream(new FileInputStream(arr.get(0).question));
					AudioInputStream ais = AudioSystem.getAudioInputStream(in);
					Clip c = AudioSystem.getClip();
					c.open(ais);
					c.loop(1);
					question = arr.get(0);
				}
				catch(Exception eee)
				{
					eee.printStackTrace();
				}
				student.penalcount++;
				student.mark=student.mark-5;
				flag11 = true;
				btnOptExtraTime.setEnabled(false);
			}
		});
		btnOptExtraTime.setBounds(296, 422, 118, 23);
		btnOptExtraTime.setVisible(false);
		getContentPane().add(btnOptExtraTime);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 674, 75);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		btnMaths = new JButton("Maths");
		btnMaths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				flag=true;
				t.start();
				student.maths=true;
				panel.removeAll();
				question = new Question("Maths",2);
				
				ln = new JLabel();
				student.questionnum++;
				question.questionno=student.questionnum;
				try {
					ln.setText(question.getQuestion(student));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				student.curr=question;
				ln.setBounds(147, 11, 238, 135);
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(ln);
				try {
					student.updateQuestionList(question);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMaths.setBounds(10, 11, 61, 23);
		panel_2.add(btnMaths);
		btnMaths.setActionCommand("Maths");
		
		btnImageRec = new JButton("Image Rec");
		btnImageRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!flag)
				{
				//	System.out.println("1");
					lblSelectTwoSimilar = new JLabel("Select two similar patterns.");
					lblSelectTwoSimilar.setBounds(60, 97, 214, 14);
					getContentPane().add(lblSelectTwoSimilar);
				panel_1.removeAll();
				t = new timer();
			//	System.out.println("sd");
			//	timer = true;
				t.start();
				
			//	System.out.println(t.getState());
				flag =true;
				student.image=true;
				panel.removeAll();
				question = new Question("Image",2);
				String line[] = null;
				try {
					line = question.getQuestion(student).split(" ");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				rb = new JRadioButton("");
				rb.setBounds(28, 47, 21, 23);
				panel.add(rb);
				
				rb1 = new JRadioButton("");
				rb1.setBounds(283, 47, 21, 23);
				panel.add(rb1);
				
				rb2= new JRadioButton("");
				rb2.setBounds(485, 47, 21, 23);
				panel.add(rb2);
		//		System.out.println(line[0]);
				label = new JLabel("");
				label.setIcon(new ImageIcon(line[0]));
				label.setBounds(55, 11, 222, 193);
				panel.add(label);
				
				label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(line[1]));
				label_1.setBounds(310, 11, 169, 193);
				panel.add(label_1);
				
				label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon(line[2]));
				
				
				
				label_2.setBounds(507, 11, 157, 193);
				panel.add(label_2);
				panel.repaint();
				panel.revalidate();
				try {
					student.updateQuestionList(question);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnImageRec.setBounds(129, 11, 89, 23);
		panel_2.add(btnImageRec);
		btnImageRec.setActionCommand("Image");
		
		btnListening = new JButton("Listening");
		btnListening.setBounds(296, 11, 89, 23);
		panel_2.add(btnListening);
		btnListening.setActionCommand("Listen");
		
		btnReading = new JButton("Spelling");
		btnReading.setBounds(443, 11, 89, 23);
		panel_2.add(btnReading);
		btnReading.setActionCommand("Spell");
		
		btnWriting = new JButton("Writing");
		btnWriting.setBounds(575, 11, 89, 23);
		panel_2.add(btnWriting);
		btnWriting.setActionCommand("Write");
		btnWriting.addActionListener(this);
		btnReading.addActionListener(this);
		btnListening.addActionListener(this);
	//	btnImageRec.addActionListener(this);
		
		
		textField.select(1, 3);
	//	textField.setSelectionEnd(5);
		
		textField.setSelectedTextColor(Color.red);
		
		if(student.image)
		{
			btnImageRec.setEnabled(false);
		}
		if(student.listen)
		{
			btnListening.setEnabled(false);
		}
		if(student.maths)
		{
			btnMaths.setEnabled(false);
		}
		if(student.spell)
		{
			btnReading.setEnabled(false);
		}
		if(student.write)
		{
			btnWriting.setEnabled(false);
		}
		if(student.curr!=null)
		{
			flaglog=true;
			t.start();
			question = student.curr;
			if(question.subject.equalsIgnoreCase("Maths"))
			{
				System.out.println("vghj");
				panel.removeAll();
				question = new Question("Maths",2);
				
				ln = new JLabel();
				student.questionnum++;
				question.questionno=student.questionnum;
				try {
					ln.setText(question.getQuestion(student));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student.curr=question;
				ln.setBounds(147, 11, 238, 135);
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(ln);
			}
			else if(question.subject.equalsIgnoreCase("Listen"))
			{
				BufferedInputStream in=null;
				try {
					in = new BufferedInputStream(new FileInputStream(question.getQuestion(student)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AudioInputStream ain = null;
				try {
					ain = AudioSystem.getAudioInputStream(in);
				} catch (UnsupportedAudioFileException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Clip c = null;
				try {
					c = AudioSystem.getClip();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					c.open(ain);
				} catch (LineUnavailableException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.loop(1);
				if(student.mark>=10)
				{
					
					btnOptExtraTime.setVisible(true);
					btnOptExtraTime.setEnabled(false);
				}
			}
			else if(question.subject.equalsIgnoreCase("Write"))
			{
				try
				{
				File f11 = new File("Dictionary.txt");
				FileInputStream fout = new FileInputStream(f11);
				ObjectInputStream oot = new ObjectInputStream(fout);
				
				hs = (HashSet<String>) oot.readObject();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				textField.requestFocusInWindow();
				textField.addKeyListener(this);
				
				
				
				ln = new JLabel();
				
				
				try {
					ln.setText(question.getQuestion(student));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ln.setBounds(147, 11, 238, 135);
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(ln);
			}
			else if(question.subject.equalsIgnoreCase("Image"))
			{
				String line[] = null;
				try {
					line = question.getQuestion(student).split(" ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rb = new JRadioButton("");
				rb.setBounds(28, 47, 21, 23);
				panel.add(rb);
				
				rb1 = new JRadioButton("");
				rb1.setBounds(283, 47, 21, 23);
				panel.add(rb1);
				
				rb2= new JRadioButton("");
				rb2.setBounds(485, 47, 21, 23);
				panel.add(rb2);
	//			System.out.println(line[0]);
				label = new JLabel("");
				label.setIcon(new ImageIcon(line[0]));
				label.setBounds(55, 11, 222, 193);
				panel.add(label);
				
				label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(line[1]));
				label_1.setBounds(310, 11, 169, 193);
				panel.add(label_1);
				
				label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon(line[2]));
				
				
				
				label_2.setBounds(507, 11, 157, 193);
				panel.add(label_2);
				panel.repaint();
				panel.revalidate();
			}
			else if(question.subject.equalsIgnoreCase("Spell"))
			{
				ln = new JLabel();
				student.questionnum++;
				question.questionno=student.questionnum;
				try {
					ln.setText(question.getQuestion(student));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student.curr=question;
				ln.setBounds(147, 11, 238, 135);
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(ln);
			}
			
		}
		
		
		JLabel lblSelectTwoSimilar = new JLabel("Select two similar patterns.");
		lblSelectTwoSimilar.setBounds(60, 97, 214, 14);
		getContentPane().add(lblSelectTwoSimilar);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected static void examFinish() 
	{
		btnOptExtraTime.setVisible(false);
		btnSubmit.setVisible(false);
		btnNewButton.setVisible(false);
		textField.setVisible(false);
		panel_2.removeAll();
		JLabel l = new JLabel();
		l.setBounds(129, 11, 300, 23);
		panel_2.add(l);
		panel_2.repaint();
		panel_2.revalidate();
		panel_2.setLayout(null);
		btnMaths1 = new JButton("Maths");
		btnMaths1.setBounds(10, 31, 61, 23);
		panel_2.add(btnMaths1);
		btnMaths1.setActionCommand("Maths");
		btnMaths1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame jf  = new JFrame("Maths Resuls");
				HashMap<String,ArrayList<Question>> hm = student.hm;
				ArrayList<Question> ar = hm.get("Maths");
				jf.getContentPane().setLayout(new GridLayout());
				for(int i=0;i<ar.size();i++)
				jf.getContentPane().add(new JLabel(ar.get(i).questionno+" "+ar.get(i).marksobtained+" "+ar.get(i).marks));
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
		);
		btnImageRec1 = new JButton("Image Rec");
		btnImageRec1.setBounds(129, 31, 89, 23);
		panel_2.add(btnImageRec1);
		btnImageRec1.setActionCommand("Image");
		btnImageRec1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			//	System.out.println("Img");
				JFrame jf  = new JFrame("Image Resuls");
				HashMap<String,ArrayList<Question>> hm = student.hm;
				ArrayList<Question> ar = hm.get("Image");
				jf.getContentPane().setLayout(new GridLayout());
				for(int i=0;i<ar.size();i++)
				jf.getContentPane().add(new JLabel(ar.get(i).questionno+" "+ar.get(i).marksobtained+" "+ar.get(i).marks));
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
		);
		
		btnListening1 = new JButton("Listening");
		btnListening1.setBounds(296, 31, 89, 23);
		panel_2.add(btnListening1);
		btnListening1.setActionCommand("Listen");
		btnListening1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			//	System.out.println("lst");
				JFrame jf  = new JFrame("Listen Resuls");
				HashMap<String,ArrayList<Question>> hm = student.hm;
				ArrayList<Question> ar = hm.get("Listen");
				jf.getContentPane().setLayout(new GridLayout());
				for(int i=0;i<ar.size();i++)
				jf.getContentPane().add(new JLabel(ar.get(i).questionno+" "+ar.get(i).marksobtained+" "+ar.get(i).marks));
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
		);
		
		btnReading1 = new JButton("Spelling");
		btnReading1.setBounds(443, 31, 89, 23);
		panel_2.add(btnReading1);
		btnReading1.setActionCommand("Spell");
		btnReading1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			//	System.out.println("spl");
				JFrame jf  = new JFrame("Spell Resuls");
				HashMap<String,ArrayList<Question>> hm = student.hm;
				ArrayList<Question> ar = hm.get("Spell");
				jf.getContentPane().setLayout(new GridLayout());
				for(int i=0;i<ar.size();i++)
				jf.getContentPane().add(new JLabel(ar.get(i).questionno+" "+ar.get(i).marksobtained+" "+ar.get(i).marks));
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
		);
		
		btnWriting1 = new JButton("Writing");
		btnWriting1.setBounds(575, 31, 89, 23);
		panel_2.add(btnWriting1);
		btnWriting1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			//	System.out.println("wrt");
				JFrame jf  = new JFrame("Write Resuls");
				HashMap<String,ArrayList<Question>> hm = student.hm;
				ArrayList<Question> ar = hm.get("Write");
				jf.getContentPane().setLayout(new GridLayout());
				for(int i=0;i<ar.size();i++)
				jf.getContentPane().add(new JLabel(ar.get(i).questionno+" "+ar.get(i).marksobtained+" "+ar.get(i).marks));
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
		);
		
		btnStat = new JButton("Graphs");
		btnStat.setBounds(10, 54, 89, 23);
		btnStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			//	System.out.println("graph");
				/*JFrame jf = new JFrame();
				ObservableList<PieChart.Data> pie = FXCollections.observableArrayList( 
						new PieChart.Data("Maths",student.mathmark),
						new PieChart.Data("Listen",student.listenmark),
						new PieChart.Data("Write",student.writemark),
						new PieChart.Data("Image",student.imagemark),
						new PieChart.Data("Spell",student.spellmark)
						);
				PieChart pieChart = new PieChart();
				pieChart.setData(pie);
				pieChart.setTitle("Mobile Sales"); 
			       
			      //setting the direction to arrange the data 
			      pieChart.setClockwise(true); 
			       
			      //Setting the length of the label line 
			      pieChart.setLabelLineLength(50); 

			      //Setting the labels of the pie chart visible  
			      pieChart.setLabelsVisible(true); 
			       
			      //Setting the start angle of the pie chart  
			      pieChart.setStartAngle(180);     
			         
			      //Creating a Group object  
			      Group root = new Group(pieChart); 
			         
			      //Creating a scene object 
			      Scene scene = new Scene(root, 600, 400);  
			     
			      JFXPanel datapanel = new JFXPanel();
			      datapanel.setScene(scene);
			      jf.add(datapanel);
			      jf.setVisible(true);
			      jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
				JFrame jf = new JFrame("Charts");
				jf.getContentPane().setLayout(new FlowLayout());
				try {
					if(!new File("PieChart.jpeg").exists())
					{
						new CreatePie(student);
						JLabel ln1 = new JLabel();
						ln1.setIcon(new ImageIcon("PieChart.jpeg"));
						jf.getContentPane().add(ln1);
					}
					
					else
					{
						JLabel ln1 = new JLabel();
						ln1.setIcon(new ImageIcon("PieChart.jpeg"));
						jf.getContentPane().add(ln1);
						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jf.setVisible(true);jf.pack();
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				 
				
			}
		}
		);
		panel_2.add(btnStat);
		
		
		
	}

	protected void valueQuestion() 
	{
		
//		System.out.println(student.questionnum);
		
		String ans = textField.getText();
		String sub = question.subject;
		if(!sub.equalsIgnoreCase("Write")&&ans.equalsIgnoreCase(question.answer))
		{

			
			if(question.difficulty==1)
			{
				if(sub.equalsIgnoreCase("Maths"))
				{
					student.mathmark=student.mathmark+2;
					question.marksobtained= question.marks;
					student.updateMarks(2);
				}
				else if(sub.equalsIgnoreCase("Spell"))
				{
					if(question.takenhint)
					{
						student.spellmark = student.spellmark+1;
						question.marksobtained=1;
						student.updateMarks(1);
					}
					else
					{
						student.spellmark = student.spellmark+2;
						question.marksobtained=2;
						student.updateMarks(2);
					}
				}
				else if(sub.equalsIgnoreCase("Image"))
				{
					student.imagemark=student.imagemark+2;
					question.marksobtained=2;
					student.updateMarks(2);
				}
				else if(sub.equalsIgnoreCase("Write"))
				{
					if(question.takenhint)
					{
						student.writemark=student.writemark+1;
						question.marksobtained=1;
						student.updateMarks(1);
					}
					else
					{
						student.writemark=student.writemark+2;
						question.marksobtained=2;
						student.updateMarks(2);
					}
				}
				else if(sub.equalsIgnoreCase("Listen"))
				{
					student.listenmark=student.listenmark+2;
					question.marksobtained=2;
					student.updateMarks(2);
				}
				
			}
			else if(question.difficulty==2)
			{
				if(sub.equalsIgnoreCase("Maths"))
				{
					student.mathmark=student.mathmark+5;
					question.marksobtained= question.marks;
					student.updateMarks(5);
				}
				else if(sub.equalsIgnoreCase("Spell"))
				{
					if(question.takenhint)
					{
						student.spellmark = student.spellmark+3;
						question.marksobtained=3;
						student.updateMarks(3);
					}
					else
					{
						student.spellmark = student.spellmark+5;
						question.marksobtained=5;
						student.updateMarks(5);
					}
				}
				else if(sub.equalsIgnoreCase("Image"))
				{
					student.imagemark=student.imagemark+5;
					question.marksobtained=5;
					student.updateMarks(5);
				}
				else if(sub.equalsIgnoreCase("Write"))
				{
					if(question.takenhint)
					{
						student.writemark=student.writemark+3;
						question.marksobtained=3;
						student.updateMarks(3);
					}
					else
					{
						student.writemark=student.writemark+5;
						question.marksobtained=5;
						student.updateMarks(5);
					}
				}
				else if(sub.equalsIgnoreCase("Listen"))
				{
					student.listenmark=student.listenmark+5;
					question.marksobtained=5;
					student.updateMarks(5);
				}
				
			}
			else if(question.difficulty==3)
			{
				if(sub.equalsIgnoreCase("Maths"))
				{
					student.mathmark=student.mathmark+10;
					question.marksobtained= question.marks;
					student.updateMarks(10);
				}
				else if(sub.equalsIgnoreCase("Spell"))
				{
					if(question.takenhint)
					{
						student.spellmark = student.spellmark+5;
						question.marksobtained=5;
						student.updateMarks(5);
					}
					else
					{
						student.spellmark = student.spellmark+10;
						question.marksobtained=10;
						student.updateMarks(10);
					}
				}
				else if(sub.equalsIgnoreCase("Image"))
				{
					student.imagemark=student.imagemark+10;
					question.marksobtained=10;
					student.updateMarks(10);
				}
				else if(sub.equalsIgnoreCase("Write"))
				{
					if(question.takenhint)
					{
						student.writemark=student.writemark+5;
						question.marksobtained=5;
						student.updateMarks(5);
					}
					else
					{
						student.writemark=student.writemark+10;
						question.marksobtained=10;
						student.updateMarks(10);
					}
				}
				else if(sub.equalsIgnoreCase("Listen"))
				{
					student.listenmark=student.listenmark+10;
					question.marksobtained=10;
					student.updateMarks(10);
				}
				
				
			}
		
		}
		else if(sub.equalsIgnoreCase("Write"))
		{
			boolean fla = false;
			String text[] = textField.getText().split(" ");
			for(int i=0;i<text.length;i++)
			{
				if(hs.contains(text[i]))
				{
					continue;
				}
				else
				{
					fla = true;
					break;
				}
			}
			if(!fla)
			{
				if(question.difficulty==3)
				{
					if(question.takenhint)
					{
						student.writemark=student.writemark+5;
						question.marksobtained=5;
						student.updateMarks(5);
					}
					else
					{
						student.writemark=student.writemark+10;
						question.marksobtained=10;
						student.updateMarks(10);
					}
					
				}
				else if(question.difficulty==2)
				{
					if(question.takenhint)
					{
						student.writemark=student.writemark+3;
						question.marksobtained=3;
						student.updateMarks(3);
					}
					else
					{
						student.writemark=student.writemark+3;
						question.marksobtained=3;
						student.updateMarks(3);
					}
				}
				else if(question.difficulty==1)
				{
					if(question.takenhint)
					{
						student.writemark=student.writemark+1;
						question.marksobtained=1;
						student.updateMarks(1);
					}
					else
					{
						student.writemark=student.writemark+2;
						question.marksobtained=2;
						student.updateMarks(2);
					}
				}
					
			}
			
		}
			
		try {
			if(!flag11)
			student.updateQuestionList(question);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public static void endSection() throws InterruptedException 
	{
		
		if(question.subject.equalsIgnoreCase("Maths"))
		{
			btnMaths.setToolTipText("Time taken to complete this section is"+mm+" : "+ss);
			btnMaths.setEnabled(false);
		}
		else if(question.subject.equalsIgnoreCase("Image"))
		{
			btnImageRec.setToolTipText("Time taken to complete this section is"+mm+" : "+ss);
			btnImageRec.setEnabled(false);
		}
		else if(question.subject.equalsIgnoreCase("Write"))
		{
			btnWriting.setToolTipText("Time taken to complete this section is"+mm+" : "+ss);
			btnWriting.setEnabled(false);
		}
		else if(question.subject.equalsIgnoreCase("Listen"))
		{
			btnListening.setToolTipText("Time taken to complete this section is"+mm+" : "+ss);
			btnListening.setEnabled(false);
		}
		else if(question.subject.equalsIgnoreCase("Spell"))
		{
			btnReading.setToolTipText("Time taken to complete this section is"+mm+" : "+ss);
			btnReading.setEnabled(false);
		}
		
		Object obj = new Object();
		synchronized(obj)
		{
			
			obj.wait(10000);
			panel.removeAll();
			flag = false;
			JOptionPane.showMessageDialog(null,"Choose another section in 5 seconds");
			obj.wait(5000);
			if(!flag)
			{
				
				if(!student.image)
				{
					btnImageRec.doClick();
				}
				else if(!student.listen)
				{
					btnListening.doClick();
				}
				else if(!student.maths)
				{
					btnMaths.doClick();
				}
				else if(!student.write)
				{
					btnWriting.doClick();
				}
				else if(!student.spell)
				{
					btnReading.doClick();
				}
			}
		}
		
	}

	public static int check() 
	{
		if(flag11)
		{
			return 3;
		}
		else
		{
			return 1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(flag)
		{
			JOptionPane.showMessageDialog(null,"Please complete the current Test");
		}
		else
		{
			flag = true;
			String btnname = arg0.getActionCommand();
			if(btnname.equalsIgnoreCase("Maths"))
			{
				t.start();
				student.maths=true;
				panel.removeAll();
				question = new Question("Maths",2);
				
				ln = new JLabel();
				student.questionnum++;
				question.questionno=student.questionnum;
				try {
					ln.setText(question.getQuestion(student));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student.curr=question;
				ln.setBounds(147, 11, 238, 135);
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(ln);
				
			}
			else if(btnname.equalsIgnoreCase("Image"))
			{
				t.start();
				student.image=true;
				panel.removeAll();
				question = new Question("Image",2);
				String line[] = null;
				try {
					line = question.getQuestion(student).split(" ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rb = new JRadioButton("");
				rb.setBounds(28, 47, 21, 23);
				panel.add(rb);
				
				rb1 = new JRadioButton("");
				rb1.setBounds(283, 47, 21, 23);
				panel.add(rb1);
				
				rb2= new JRadioButton("");
				rb2.setBounds(485, 47, 21, 23);
				panel.add(rb2);
	//			System.out.println(line[0]);
				label = new JLabel("");
				label.setIcon(new ImageIcon(line[0]));
				label.setBounds(55, 11, 222, 193);
				panel.add(label);
				
				label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(line[1]));
				label_1.setBounds(310, 11, 169, 193);
				panel.add(label_1);
				
				label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon(line[2]));
				
				
				
				label_2.setBounds(507, 11, 157, 193);
				panel.add(label_2);
				panel.repaint();
				panel.revalidate();
			}
			else if(btnname.equalsIgnoreCase("Listen"))
			{
				t = new timer();
				t.start();
				student.listen=true;
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				question = new Question("Listen",2);
				student.curr = question;
				BufferedInputStream in=null;
				try {
					in = new BufferedInputStream(new FileInputStream(question.getQuestion(student)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AudioInputStream ain = null;
				try {
					ain = AudioSystem.getAudioInputStream(in);
				} catch (UnsupportedAudioFileException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Clip c = null;
				try {
					c = AudioSystem.getClip();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					c.open(ain);
				} catch (LineUnavailableException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.loop(1);
				if(student.mark>=10)
				{
					
					btnOptExtraTime.setVisible(true);
					btnOptExtraTime.setEnabled(false);
				}
			}
			else if(btnname.equalsIgnoreCase("Spell"))
			{
				t =new timer();
				t.start();
				timestamp = System.currentTimeMillis();
				student.spell=true;
				panel.removeAll();
				question = new Question("Spell",2);
				ln = new JLabel();
				student.questionnum++;
				question.questionno=student.questionnum;
				try {
					ln.setText(question.getQuestion(student));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student.curr=question;
				ln.setBounds(147, 11, 238, 135);
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(ln);
				
				
			}
			else if(btnname.equalsIgnoreCase("Write"))
			{
				try
				{
				File f11 = new File("Dictionary.txt");
				FileInputStream fout = new FileInputStream(f11);
				ObjectInputStream oot = new ObjectInputStream(fout);
				
				hs = (HashSet<String>) oot.readObject();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				textField.requestFocusInWindow();
				textField.addKeyListener(this);
				t = new timer();
				t.start();
				student.write=true;
				panel.removeAll();
				question = new Question("Write",2);
				ln = new JLabel();
				student.questionnum++;
				question.questionno=student.questionnum;
				
				try {
					ln.setText(question.getQuestion(student));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				student.curr=question;
				ln.setBounds(147, 11, 238, 135);
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(ln);
				
			}
			
				if(student.subCount!=5)
				{
			try {
				student.updateQuestionList(question);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		
		if(question.subject.equalsIgnoreCase("Write"))
		{
			
				
				try
				{
					
					String sentence[] =null;
			//		System.out.println(arg0.getKeyChar());
					char c =arg0.getKeyChar();
					if(c==' ')
					{
						StyleContext context = new StyleContext();
					    StyledDocument document = new DefaultStyledDocument(context);
					    javax.swing.text.Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
					    StyleConstants.setUnderline(style, false);
						sentence =  textField.getText().split(" ");
						int j=0;
						for(int i=0;i<sentence.length;i++)
						{
							
							if(hs.contains(sentence[i]))
							{
								StyleConstants.setUnderline(style, false);
								sent = sent+word+(char)arg0.getKeyChar();
								document.insertString(document.getLength(),word+""+c, style);
								word="";
							}
							else
							{
								

							   StyleConstants.setUnderline(style, true);

							    document.insertString(document.getLength(), sentence[i], style);
						//		System.out.println(" wrong1 ");
								question.takenhint = true;
								
								textField.requestFocusInWindow();
								int len =textField.getText().length();
								int start = word.length();
								textField.select(len-start-1, len-1);
								textField.getSelectedText();
								//System.out.println(j+" "+sentence[i].length());
							//	str_attribut.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, j, j+sentence[i].length());
								
								
							}
							j=j+sentence[i].length();
							}
						
						textField = new JTextPane(document);
					//	textField.setDocument(document);
						textField.repaint();
						textField.revalidate();
						textField.setBounds(244, 360, 229, 33);
						getContentPane().repaint();
					}
					
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			
		}
	}
}
