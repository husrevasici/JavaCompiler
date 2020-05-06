package JavaCompiler;

import javax.swing.JOptionPane;

public class VariableDefine extends Program implements Command {
	Main mainClass = new Main();

	@Override
	public void checkSyntax(String mainFromString, int stringLineNumber) throws Exception {
		System.out.println("VariableDefine değişkeni mainFromString: " + mainFromString);
		if (mainClass.satirText[stringLineNumber].contains(";")) {

		} else {
			stringLineNumber += 1;
			throw new RunError(stringLineNumber + " 'nolu satirda tanimlanan degiskenin (';') noktali virgülü yok !!!");
		}
		mainFromString = mainFromString.substring(0, mainFromString.length() - 1);
		String mainFromStringValue, mainFromStringKey;
		int firstGap, secondGap;
		// mainFromString -->> int x=5;
		firstGap = mainFromString.indexOf(" ");
		mainFromString = mainFromString.substring(firstGap).trim(); // x=5;
		System.out.println(mainFromString);
		secondGap = mainFromString.indexOf("=");
		mainFromStringKey = mainFromString.substring(0, secondGap); // x
		mainFromStringValue = mainFromString.substring(secondGap + 1).trim(); // 5
		System.out.println("mainFromStringKey: " + mainFromStringKey);
		if (var.contains(mainFromStringKey) == true) {
			text2.append(
					"\n" + mainFromString + " degiskeni hafizada " + var.get(mainFromString) + " degerine sahiptir.");
		} else if (var.contains(mainFromString) == false) {
			insert(mainFromStringKey, mainFromStringValue);
		} else {

		}

	}

	@Override
	public void executeCommand(String s) throws Exception {

	}

	public void insert(String mainStringFromStringKey, String mainFromStringVariable) {

//		System.out.println(mainStringFromStringKey);
//		System.out.println(mainFromStringVariable);
		var.remove(mainStringFromStringKey);
		if (var.containsKey(mainStringFromStringKey) == false) {
			var.put(mainStringFromStringKey, mainFromStringVariable);
		} else {
			text2.append(mainStringFromStringKey + "->" + "degiskeni hafizada bir degere sahiptir.");
		}
		// System.out.println(var.containsKey(mainStringFromStringKey));

	}

}
