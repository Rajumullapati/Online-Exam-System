package newSwin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener
{
	Student st = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Login()
	{
		getContentPane().setLayout(null);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setBounds(187, 293, 89, 23);
		btnLogIn.addActionListener(this);
		getContentPane().add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SignUp su = new SignUp();
				dispose();
				return;
			}
		});
		btnSignUp.setBounds(187, 343, 89, 23);
		getContentPane().add(btnSignUp);
		
		textField = new JTextField();
		textField.setBounds(231, 58, 137, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 133, 137, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Roll Number");
		lblNewLabel.setBounds(70, 67, 101, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("School Name");
		lblNewLabel_1.setBounds(70, 142, 89, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(231, 197, 137, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PIN");
		lblNewLabel_2.setBounds(70, 206, 46, 14);
		getContentPane().add(lblNewLabel_2);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try {
			if(validate(textField.getText(),textField_1.getText(),textField_2.getText()))  
			{
				if(st.absTime+20000<System.currentTimeMillis())
				{
					dispose();
					Test t1 = new Test(Integer.parseInt(textField_2.getText()),st);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Session Expired.");
				}
			}
			else
				{
					JOptionPane.showMessageDialog(null,"Please register and login.");
				}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private boolean validate(String text, String text2, String text3) throws Exception 
	{
		HashMap<String, HashMap<String, Student>> hm  = new HashMap<>();
		File f = new File("School.txt");
		if(!f.exists()||f.length()==0)
		{
			return false;
		}
		FileInputStream fis  = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		hm = (HashMap<String, HashMap<String,Student>>) ois.readObject();
		if(hm.get(text2).get(text).getPin()==Integer.parseInt(text3))
		{
			st=hm.get(text2).get(text);
			return true;
		}
		else
			return false;
	}
}
