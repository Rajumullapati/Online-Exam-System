package newSwin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Question implements Serializable
{
	int questionno=0;
	int difficulty;
	String answer="";
	String question="";
	String subject="";
	int marks;
	protected int marksobtained=0;
	String hint=null;
	protected boolean takenhint;
	public Question()
	{
		
	}
	public Question(String subject, int difficulty)
	{
		this.subject=subject;
		this.difficulty=difficulty;
		if(difficulty==1)
		{
			this.marks=2;
		}
		else if(difficulty==2)
		{
			this.marks=5;
		}
		else if(difficulty==3)
		{
			this.marks=10;
		}
	}
	public String getAnswer()
	{
		return null;
	}
	public String getQuestion(Student student) throws Exception 
	{
		ArrayList<Question> arr = new ArrayList<>();
		File f = new File(this.subject+"\\"+this.difficulty+".txt");
//		System.out.println(f.getPath());
		if(!f.exists()||f.length()==0)
		{
			if(!f.exists())
			f.createNewFile();
			fillfile(f,this.subject,this.difficulty);
		}
		FileInputStream fis  = new FileInputStream(f);
		ObjectInputStream ois  = new ObjectInputStream(fis);
		Object obj;
		obj=  ois.readObject();
		arr = (ArrayList<Question>) obj;
		ArrayList<Question> ar1 = new ArrayList<>() ;
		if(student.hm.containsKey(this.subject))
		{
			ar1 = student.hm.get(this.subject);
		}
//		System.out.println(ar1+" "+arr+" "+this);
		int index=0;
		if(ar1.size()>0)
		{
			for(int i=0;i<ar1.size();i++)
			{
				int fl =0;
				for(int j=0;j<arr.size();j++)
				{
					if(!ar1.get(i).question.equals(arr.get(j).question))
					{
						index = j;
						fl=1;
						break;
					}
					if(fl==1)
						break;
				}
			}
		}
		Question q  = arr.get(index);
		
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		this.question=q.question;
		this.answer=q.answer;
		this.hint=q.hint;
		out.writeObject(arr);
		return q.question;
	}
	private void fillfile(File f,String sub, int diff) throws Exception 
	{
		File f1 = new File("C:\\Users\\mulla\\Desktop\\dic.txt");
		BufferedReader br =  new BufferedReader(new FileReader(f1));
		HashSet<String> hs = new HashSet<>();
		String line  ;
		while((line = br.readLine())!=null)
		{
			String line1 [] = line.split(" ");
			for(int i=0;i<line1.length;i++)
			{
				hs.add(line1[i]);
			}
		}
		File f11 = new File("Dictionary.txt");
		FileOutputStream fout = new FileOutputStream(f11);
		ObjectOutputStream oot = new ObjectOutputStream(fout);
		oot.writeObject(hs);
		ArrayList<Question> arr = new ArrayList<>();
		if(sub.equals("Maths")&&diff==1)
		{
			Question q1 = new Question(sub,1);
			q1.question="1+1";
			q1.answer="2";
			arr.add(q1);
			Question q2  = new Question("Maths",1);
			q2.question="1+2";
			q2.answer="3";
			arr.add(q2);
			Question q3  = new Question("Maths",1);
			q3.question="2+2";
			q3.answer="4";
			arr.add(q3);
		}
		else if(sub.equals("Maths")&&diff==2)
		{
			Question q1 = new Question(sub,2);
			q1.question="1+10";
			q1.answer="11";
			arr.add(q1);
			Question q2  = new Question("Maths",2);
			q2.question="1+12";
			q2.answer="13";
			arr.add(q2);
			Question q3  = new Question("Maths",2);
			q3.question="12+12";
			q3.answer="24";
			arr.add(q3);
		}
		else if(sub.equals("Maths")&&diff==3)
		{
			Question q1 = new Question(sub,3);
			q1.question="100+10";
			q1.answer="110";
			arr.add(q1);
			Question q2  = new Question("Maths",3);
			q2.question="100+12";
			q2.answer="112";
			arr.add(q2);
			Question q3  = new Question("Maths",3);
			q3.question="100+12";
			
			q3.answer="112";
			arr.add(q3);
		}
		else if(sub.equalsIgnoreCase("Image")&&diff==1)
		{
			Question q1 = new Question(sub,diff);
			q1.question="C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img2.png C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img3.png C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img4.png";
			q1.answer="2 3";
	//		System.out.println(q1.question);
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Image")&&diff==2)
		{
			Question q1 = new Question(sub,diff);
			q1.question="C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img1.png C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img2.png C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img3.png";
			q1.answer="1 3";
		//	System.out.println(q1.question);
			arr.add(q1);

		}
		else if(sub.equalsIgnoreCase("Image")&&diff==3)
		{
			Question q1 = new Question(sub,diff);
			q1.question="C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img1.png C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img3.png C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Image\\img4.png";
		//	System.out.println(q1.question);
			q1.answer="1 2";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Spell")&&diff==1)
		{
			Question q1 = new Question(sub,diff);
			q1.question="Type a positive word with more than 3 words starting with letter 'G'.";
			q1.answer="Good";
			q1.hint = "Goo";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Spell")&&diff==2)
		{
			Question q1 = new Question(sub,diff);
			q1.question="Type a positive word with more than 3 words starting with letter 'J'.";
			q1.answer="Janatha";
			q1.hint="Jana";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Spell")&&diff==3)
		{
			Question q1 = new Question(sub,diff);
			q1.question="Type a positive word with more than 3 words starting with letter 'Z'.";
			q1.answer="Zanatha";
			q1.hint="Zana";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Write")&&diff==1)
		{
			Question q1 =  new Question(sub,diff);
			q1.question="Type a simple sentence.";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Write")&&diff==2)
		{
			Question q1 =  new Question(sub,diff);
			q1.question="Type a complex sentence.";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Write")&&diff==3)
		{
			Question q1 =  new Question(sub,diff);
			q1.question="Type a compound sentence.";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Listen")&&diff==1)
		{
			Question q1 =  new Question(sub,diff);
			q1.question="C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Listen\\s1.wav";
			q1.answer="adequate";
			arr.add(q1);
			Question q2 = new Question(sub,diff);
			q2.question="C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Listen\\s2.wav";
			q2.answer="anxiously";
			arr.add(q2);
		}
		else if(sub.equalsIgnoreCase("Listen")&&diff==2)
		{
			Question q1 = new Question(sub,diff);
			q1.question="C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Listen\\s4.wav";
			q1.answer="baran";
			arr.add(q1);
		}
		else if(sub.equalsIgnoreCase("Listen")&&diff==3)
		{
			Question q1 = new Question(sub,diff);
			q1.question="C:\\Users\\mulla\\eclipse-workspace\\newSwin\\Listen\\s5.wav";
			q1.answer="alpha";
			arr.add(q1);
		}
		
		FileOutputStream fout1 = new FileOutputStream(f);
		ObjectOutputStream oout1 = new ObjectOutputStream(fout1);
		oout1.writeObject(arr);
	}

}
