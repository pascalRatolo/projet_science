package inscription;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

 @SuppressWarnings("serial")
public class FieldFormat extends JFormattedTextField{

	public FieldFormat(String k) {
		super();
		MaskFormatter cacheFormat= null;
		try {
			if(k=="nume")
			cacheFormat = new MaskFormatter("#####");  
			else if(k=="phone")
				cacheFormat = new MaskFormatter("### ## ### ##"); 
			else if(k=="date") {
				cacheFormat = new MaskFormatter("## /## /####"); 
				
			}
			else if(k=="cin")
				cacheFormat = new MaskFormatter("### ### ### ###"); 
			
			else if(k=="bacc")
				cacheFormat = new MaskFormatter("### ### #");
			
			else if(k=="anne")
				cacheFormat = new MaskFormatter("####-####");
			
			else cacheFormat = new MaskFormatter("##.##"); 
		}
		catch (ParseException e){
			e.printStackTrace();
		}
		cacheFormat.setPlaceholderCharacter('_'); 
		cacheFormat.setCommitsOnValidEdit(true);
		setFormatterFactory(new DefaultFormatterFactory(cacheFormat));
	}
}
