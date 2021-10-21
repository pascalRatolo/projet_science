package loading;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Uppercase extends DocumentFilter {
	public void insertString(DocumentFilter.FilterBypass fb,int offset,
			String text,AttributeSet attr) throws BadLocationException{
		fb.insertString(offset, Methode.finitText(text), attr);
	}
	public void replace(DocumentFilter.FilterBypass fb,int offset,int length,
			String text,AttributeSet attr) throws BadLocationException{
		fb.replace(offset, length,Methode.finitText(text), attr);
	}

}
