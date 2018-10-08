package newSwin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SignUp extends JFrame implements ActionListener 
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblName;
	private JLabel lblSchoolName;
	JRadioButton rdbtnNewRadioButton;
	SignUp()
	{
		this.setSize(500,500);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(236, 74, 137, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 137, 137, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(236, 201, 137, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("Student Id");
		label.setBounds(61, 77, 108, 14);
		getContentPane().add(label);
		
		lblName = new JLabel("Name");
		lblName.setBounds(64, 140, 46, 14);
		getContentPane().add(lblName);
		
		lblSchoolName = new JLabel("School Name");
		lblSchoolName.setBounds(61, 204, 84, 14);
		getContentPane().add(lblSchoolName);
		
		rdbtnNewRadioButton = new JRadioButton("Accept terms and conditions.");
		rdbtnNewRadioButton.setBounds(61, 259, 279, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(this);
		btnSignup.setBounds(284, 342, 89, 23);
		getContentPane().add(btnSignup);
		
		JButton btnLogInWith = new JButton("Log In with Pin");
		btnLogInWith.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) 
			{
				Login li = new Login();
				dispose();
				return;
			}
		});
		btnLogInWith.setBounds(56, 342, 113, 23);
		getContentPane().add(btnLogInWith);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try {
			if(!rdbtnNewRadioButton.isSelected())
			{
				JOptionPane.showMessageDialog(null,"Please accept the terms and conditions.");
			}
			else
			{
			if(validate(textField_2.getText(),textField.getText(),textField_1.getText()))//name=txt1  id=txt  schname=txt2
			{
				
				Student st = new Student();
				st.setName(textField_1.getText());
				st.setId(textField.getText());
				st.setSchool(textField_2.getText());
				st.setStart();				
				Random rd = new Random();
				int pin = rd.nextInt(9999)+1000;
				st.setPin(pin);
				
				JOptionPane.showMessageDialog(null,"The pin for you exam is "+pin+".");
				try
				{
					st.save();
				} 
				catch (ClassNotFoundException | IOException e)
				{
					e.printStackTrace();
				}
				dispose();
				Test test = new Test(pin,st);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You have already registered. Please Log In with pin.");
				Login li = new Login();
				dispose();
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}

	private boolean validate(String text, String text2, String text3) throws Exception
	{
		HashMap<String, HashMap<String, Student>> hm  = new HashMap<>();
		File f = new File("School.txt");
		if(!f.exists()||f.length()==0)
		{
			return true;
		}
		
		FileInputStream fis  = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		hm = (HashMap<String, HashMap<String,Student>>) ois.readObject();
		if(hm.containsKey(text)&&hm.get(text).containsKey(text2)&&hm.get(text).get(text2).Name.equalsIgnoreCase(text3))
		{
			return false;
		}
		return true;
	}
}
