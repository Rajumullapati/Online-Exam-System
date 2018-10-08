package newSwin;

import java.io.File;
import javafx.scene.chart.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Student  implements Serializable
{
	protected int subCount =0;
	int questionnum =0;
	Question curr = null;
	String Name=null;
	String SchoolName=null;
	int pin=0;
	String id=null;
	int mark=0;
	long startTime=0;;
	long currTime=0;
	int mathmark=0;
	int imagemark=0;
	int spellmark=0;
	int writemark=0;
	int listenmark=0;
	boolean maths=false,image=false,spell=false,write=false,listen=false;
	HashMap<String,ArrayList<Question>> hm = new HashMap();
	protected int penalcount;
	protected long absTime;
	public Student()
	{
		
	}
	public void setQuestion(Question num) throws ClassNotFoundException, IOException
	{
		this.curr = num;
		this.save();
	}
	public void setQuestionNUM()
	{
		this.questionnum++;
	}
	public void setStart() throws Exception
	{
		this.absTime=System.currentTimeMillis();
		this.startTime = System.currentTimeMillis();
	}
	
	public void setName(String text) 
	{
		this.Name = text;
	}
	public void updateMarks(int add)
	{
		this.mark = this.mark+add;
		
	}
	public void setId(String text) 
	{
		this.id=text;
		
	}

	
	public void setPin(int pin) 
	{
		this.pin =pin;
	}

	public void setSchool(String text) 
	{
		this.SchoolName = text;
	}

	public void save() throws IOException, ClassNotFoundException 
	{
		HashMap<String,HashMap<String,Student>> hm  =null;
		HashMap<String,Student> hm1 = null;
		File f = new File("School.txt");
		if(!f.exists())
		{
			f.createNewFile();
			hm= new HashMap<>();
			hm1 = new HashMap<>();
		}
		else
		{
			FileInputStream fis  = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
				hm = (HashMap<String, HashMap<String, Student>>) ois.readObject();
			if(hm.containsKey(SchoolName))
			hm1=hm.get(SchoolName);
			else
			{
				hm1 = new HashMap<>();
			}
			
		}
	//	System.out.println(SchoolName+" "+id+" "+this+" "+hm.get(SchoolName)+" "+hm);
		hm1.put(id, this);
		hm.put(SchoolName, hm1);
		FileOutputStream fs  = new FileOutputStream(f);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(hm);
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return "";
	}
	public int getPin() {
		
		return pin;
	}
	public void updateQuestionList(Question question) throws ClassNotFoundException, IOException 
	{
		ArrayList<Question> arr = new ArrayList<>();
		if(hm.size()!=0)
		{
			if(hm.containsKey(question.subject))
			{
				arr = hm.get(question.subject);
			}
		}
		arr.add(question);
		hm.put(question.subject, arr);
		this.save();
	}

}
