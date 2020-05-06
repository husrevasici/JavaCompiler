package JavaCompiler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.plaf.synth.SynthSeparatorUI;

class Program extends gui implements Command {
	Enter enter;
	Print print;
	Add add;
	Sub sub;
	Mul mul;
	Div div;
	ForLoop forLoop;
	IfElseControlandInteger ifControlObject;
	VariableDefine variableDefine;
	ArrayList arraylist;
	static int z, i = 0, count = 0, ln, f;
	// count is a counter for the array of objects of variables
	// z is a counter for the line no.
	// i is Counter for the execution array

	static Variables v[] = new Variables[30];
	// array of objects of the type 'Variables'

	static Hashtable<String, String> var = new Hashtable<String, String>();
	static Hashtable<String, Integer> ifHashTable = new Hashtable<String, Integer>();
	// Hashtable with object name as the key and position no of the resp object in
	// the array v[]

	static String ex[] = new String[100];
	// Execution array used later for reference of order to execute commands during
	// run-time

	String ab[];
	final String k1 = "Enter", k2 = "Print", k3 = "Repeat", k4 = "Add", k5 = "Sub", k6 = "Mul", k7 = "Div", k8 = "int",
			k9 = "double", k10 = "string", k11 = "if", k12 = "for";

	public void checkSyntax(String mainFromString, int stringLineNumber) throws Exception {
		System.out.println("Program classı mainFromString valuesi gelen değer: " + mainFromString);
		enter = new Enter();
		print = new Print();
		add = new Add();
		sub = new Sub();
		mul = new Mul();
		div = new Div();
		ifControlObject = new IfElseControlandInteger();
		variableDefine = new VariableDefine();
		forLoop = new ForLoop();
		z++;

		// checkSyntax fonksiyonuna gelen string'teki ilk boslugun indexini tutan
		int index = mainFromString.indexOf(' ');
		System.out.println("bosluk: "+index);
		String keyValue = mainFromString.substring(0, index);
		// String p anahtar kelime Enter,Print, Repeat ya da Add olmali

		if (keyValue.equalsIgnoreCase(k1)) // Enter
		{
			enter.checkSyntax(mainFromString);
		} else if (keyValue.equalsIgnoreCase(k2)) // Print
		{

			print.checkSyntax(mainFromString);
		} else if (keyValue.equalsIgnoreCase(k4)) // Add
		{
			add.checkSyntax(mainFromString);
		} else if (keyValue.equalsIgnoreCase(k5)) // Sub
		{
			sub.checkSyntax(mainFromString);
		} else if (keyValue.equalsIgnoreCase(k6)) // mul
		{
			mul.checkSyntax(mainFromString);
		} else if (keyValue.equalsIgnoreCase(k7)) // Mul
		{
			div.checkSyntax(mainFromString);
		} else if (keyValue.equalsIgnoreCase(k8) || keyValue.equalsIgnoreCase(k9) || keyValue.equalsIgnoreCase(k10)) // variable
																														// define
		{
			variableDefine.checkSyntax(mainFromString, stringLineNumber); // variableDefine
		} else if (keyValue.equalsIgnoreCase(k11)) // ifelse
		{

			ifControlObject.checkSyntax(mainFromString, stringLineNumber);
		} else if (keyValue.equalsIgnoreCase(k12)) // forloop
		{

			forLoop.checkSyntax(mainFromString, stringLineNumber);
		}

		else {
			try {
				throw new RunError("Invalid Syntax On Command Line " + z + ".Satir -->" + " "
						+ "Enter-Print-Add-Sub-Mul-Div-int-double-string,for,if else anahtar kelimelerini Lutfen Duzgun yaziniz. ");
			} catch (RunError r) {

			}
		}

	}

	public void executeCommand() throws Exception {
		count = 0;

		for (int k = 0; k < i; k++) {
			// final String
			// k1="Enter",k2="Print",k3="Repeat",k4="Add",k5="Sub",k6="Mul",k7="Div";

			String r[] = ex[k].split(",");

			if (r[0].equalsIgnoreCase(k1)) {
				// System.out.println("r1: "+r[1]);

				enter.executeCommand(r[1]);
			}

			else if (r[0].equalsIgnoreCase(k2)) {
				// print.executeCommand(r[1]);

			}

			else if (r[0].equalsIgnoreCase(k4)) {
				// add.executeCommand(r[1]);
			} else if (r[0].equalsIgnoreCase(k5)) {

				// sub.executeCommand(r[1]);

			}

			else if (r[0].equalsIgnoreCase(k6)) {
				// mul.executeCommand(r[1]);
			} else if (r[0].equalsIgnoreCase(k7)) {
				// div.executeCommand(r[1]);
			}
		}
	}

	public Float getValue(String s)

	{
		Float f = null;
		int counter = 0;

		String h = var.get(s); // HashTable'da String varsa anahtara karsilik gelen keyi d�nder
		for (int g = 0; g < h.length(); g++) {
			if (h.charAt(g) == ',')
				counter++;
		}
		if (counter == 0)
			f = v[Integer.parseInt(h)].value;
		else {
			String ne = "";
			ab = h.split(",");
			f = v[Integer.parseInt(ab[0])].value;
			for (int g = 1; g < ab.length; g++)
				ne = ne + ab[g] + ",";

			ne = ne.substring(0, ne.length() - 1);

			var.put(s, ne);
		}
		return f;
	}

	@Override
	public void checkSyntax(String s) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeCommand(String s) throws Exception {
		// TODO Auto-generated method stub

	}

}