package newSwin;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;

public class CreatePie extends ApplicationFrame
{
	public CreatePie(Student student) throws IOException
	{
		super("");
		DefaultPieDataset ds = new DefaultPieDataset();
		ds.setValue("Maths",student.mathmark);
		ds.setValue("Listen",student.listenmark);
		ds.setValue("Write",student.writemark);
		ds.setValue("Image",student.imagemark);
		ds.setValue("Spell",student.spellmark);
		JFreeChart chart = ChartFactory.createPieChart("Marks",ds,true,true,false);
		int width = 640;   /* Width of the image */
	      int height = 480;  /* Height of the image */ 
	      File pieChart = new File( "PieChart.jpeg" ); 
	      
	      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		
	}

	
}
