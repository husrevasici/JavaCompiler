package JavaCompiler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

class Enter extends Program implements Command {
	int flag = 0;
	String qStringArray[];
	static int tempo, n;
	String h, pl;

	@Override
	public void checkSyntax(String s) throws Exception {
		System.out.println("Enter Classı gelen String -->> " + s);
		if (s.charAt(s.length() - 1) == ';') {

		} else {
			throw new RunError("enter" + "'in (';') noktali virgülü yok !!!");
		}
		s = s.substring(0, s.length() - 1);
		s = s.substring(5).trim(); // Enterden sonraki string'i s'de tut

		qStringArray = s.split(",");
		// qStringArray girilen degiskenleri tutan dizi

		for (int p = 0; p < s.length(); p++) {
			if (s.charAt(p) == ',')
				flag = 1;
		}
		/*
		 * Enter den sonra bir de fazla eleman varsa flag=0 Enter den sonra bir tane
		 * eleman varsa flag=1
		 */

		if (flag == 0) {
			String str = (String) JOptionPane.showInputDialog(text2, "Enter the values", "Enter command",
					JOptionPane.PLAIN_MESSAGE);
			insert(s, str);

		}

		else // If the no of variables are more than one
		{
			// birden fazla eleman istemek icin icini doldurulacak.
		}

	}

	@Override
	public void executeCommand(String s) throws Exception {

		h = s; // (Enter,Value) r[0]=Enter r[1]=value

	}

	public void insert(String s, String str) {
		var.remove(s);
		if (var.containsKey(s) == false) {

			var.put(s, str);
			System.out.println(s + " " + var.get(s));
		}

		else {
			text2.append("\n" + s + " degiskeni hafizada bir degere sahiptir.");

		}

	}

}
