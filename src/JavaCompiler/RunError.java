package JavaCompiler;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class RunError extends Exception
{
	static JFrame j;
	
	public static void GetArea(JFrame k)
	{
		j=k;
	}
	
	RunError(String s)
	{
		JOptionPane.showMessageDialog(j,s);		
	}
}