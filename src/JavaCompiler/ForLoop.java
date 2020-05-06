package JavaCompiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForLoop extends Program implements Command {
	Main mainClass = new Main();
	Program programClassObject = new Program();

	public void checkSyntax(String mainFromString, int stringLineNumber) throws Exception {
		System.out.println("first: " + mainFromString);
		mainFromString = mainFromString.substring(3).trim();
		System.out.println("second: " + mainFromString);

		String forMiddlePartString = null, forLastPartString = null, forfirstPartString = null;
		int forFirstPartValue = 0, forMiddlePartValue = 0;
		String patternString = "([^\\w]{0,1})" + "(\\s*+)" + "(\\w{0,3})" + "(\\s*+)" + "(\\w{0,1})" + "(\\s*+)"
				+ "([^\\w]{0,1})" + "(\\s*+)" + "(\\d*+)" + "(\\s*+)" + "([^\\w]{0,1})" + "(\\s*+)" + "(\\w*+)"
				+ "(\\s*+)" + "([^\\w]{0,1})" + "(\\s*+)" + "(\\d*+)" + "(\\s*+)" + "([^\\w]{0,1})" + "(\\s*+)"
				+ "(\\w*+)" + "(\\s*+)" + "([^\\w]*+)";
		Pattern p;
		Matcher m;
		p = Pattern.compile(patternString);
		// String x = ("(int i=0; i< 5 ; i++)");
		m = p.matcher(mainFromString);
		if (m.find()) {
			for (int i = 0; i < 24; i++) {
				System.out.println("mGroup" + (i) + ": " + m.group(i));
			}
			// forfirstPartString = m.group(5).trim().toString();
			forFirstPartValue = Integer.parseInt(m.group(9));
			// forMiddlePartString = m.group(13).trim().toString();
			forMiddlePartValue = Integer.parseInt(m.group(17));
			// forLastPartString = m.group(21).trim().toString();
		}
		if ((forfirstPartString == forMiddlePartString) && (forfirstPartString == forLastPartString)
				&& (forMiddlePartString == forLastPartString)) {

		} else {
			throw new Exception(
					"for döngüsünün içinde hata var!! [Örnek:for(int i=0;i<5;i++) --> i değerleri aynı değil]");
		}
		int endForIndex = stringLineNumber;
		System.out.println("startForIndex" + endForIndex);
		while (!mainClass.satirText[endForIndex].equals("endfor;"))

		{
			endForIndex++;
		}
		System.out.println("endForIndex" + endForIndex);

		for (int i = stringLineNumber + 1; i < endForIndex; i++) { // kaç defa döngü olacak
			for (int j = forFirstPartValue; j < forMiddlePartValue; j++) { // satiri dönder
				System.out.println(
						"####################################################################################################");
				programClassObject.checkSyntax(mainClass.satirText[i].substring(0, mainClass.satirText[i].length()), i);
				System.out.println(
						"****************************************************************************************************");
			}
		}
		int satir = endForIndex + 1;
		if (mainClass.satirText[satir].equals("endif;")) {
			mainClass.satir = endForIndex + 2;
			System.out.println("for döngüsü bitiminde endif: index'i: " + mainClass.satir);
		} else if (mainClass.satirText[satir].equals("endelse;")) {
			mainClass.satir = endForIndex + 2;
			System.out.println("for döngüsü bitiminde endelse: index'i: " + mainClass.satir);
		} else {
			mainClass.satir = endForIndex + 1;
			System.out.println("for döngüsü bitiminde index'i: " + mainClass.satir + " " + endForIndex + 1);
		}
	}

}
