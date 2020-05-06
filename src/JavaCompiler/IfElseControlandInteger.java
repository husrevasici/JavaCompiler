package JavaCompiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfElseControlandInteger extends Program implements Command {
	static Program programClassObjectifControlin = new Program();
	Main mainClass = new Main();
//	static int mGroup1;
//	static int mGroup3;
//	static String operators;
	private static char operators1;
	static String[] operatorsArray = { ">", "<", "==", "<=", ">=", "!=" };
	private static String mGroup3;

	public void checkSyntax(String mainFromString, int satir) throws Exception {
		System.out.println("IfElseControlandInteger classı gelen String: " + mainFromString);
		if (mainClass.satirText[satir].charAt(0) == 'i' || mainClass.satirText[satir].charAt(0) == 'I') {
			int j = mainClass.satirText[satir].indexOf(' '); // ilk boşluk nerde
			String c = mainClass.satirText[satir].substring(0, j); // Kelimenin başlangici ile bosluga kadar String c de
																	// tut.
			mainClass.d = mainClass.satirText[satir].substring(j + 1); // boşluktan sonrasini ise string d'de tut.
			// System.out.println("d: " + d);

			if (c.equals("if")) {
				designPatternControl(satir);
			} else {
				throw new RunError("Syntax Error in Repeat --> " + "if seklinde olmali");
			}
		}
	}

	private void designPatternControl(int satir) throws Exception {
		int jump = 0;
		int mGroup1;
		int mGroup2;
		IfElseControlString ifElseControlStringObject;
		String operators;
		String patternString = "(\\s*+)([^\\w]{0,1})(\\s*+)(\\w*+)(\\s*+)([^\\w]{0,2})(\\s*+)([^\\w]{0,1})(\\s*+)(\\w*+)(\\s*+)([^\\w]*+)";
		Pattern p;
		Matcher m;

		p = Pattern.compile(patternString);
		m = p.matcher(mainClass.d);
		if (m.find()) {
			System.out.println("mGroup1: " + m.group(1));
			System.out.println("mGroup2: " + m.group(2));
			System.out.println("mGroup3: " + m.group(3));
			System.out.println("mGroup4: " + m.group(4));
			System.out.println("mGroup5: " + m.group(5));
			System.out.println("mGroup6: " + m.group(6));
			System.out.println("mGroup7: " + m.group(7));
			System.out.println("mGroup8: " + m.group(8));
			System.out.println("mGroup9: " + m.group(9));
			System.out.println("mGroup10: " + m.group(10));
			System.out.println("mGroup11: " + m.group(11));
			System.out.println("mGroup12: " + m.group(12));
		}
		System.out.println("#################################################3");
		p = Pattern.compile(patternString);
		m = p.matcher(mainClass.d);
		if (m.find()) {
			System.out.println("m.group(2): " + m.group(2));
			System.out.println("m.group(8): " + m.group(8));
			if (m.group(4).matches("(?<!\\S)\\d++(?!\\S)") && m.group(10).matches("(?<!\\S)\\d++(?!\\S)")) {
				mGroup1 = Integer.parseInt(m.group(4));
				mGroup2 = Integer.parseInt(m.group(10));
				mGroup3 = m.group(12).toString().trim();
				operators = m.group(6).toString().trim();
				System.out.println("mGroup :" + mGroup3);
				jump = controlif(satir, mGroup1, mGroup2, operators);
			} else if (m.group(2).trim().equals(m.group(8).trim())) {
				System.out.println(m.group(0));
				System.out.println("mGroup2: " + m.group(2));

				System.out.println("mGroup4: " + m.group(4));
				System.out.println("mGroup6: " + m.group(6));
				System.out.println("mGroup8: " + m.group(8));
				System.out.println("mGroup10: " + m.group(10));
				System.out.println("mGroup12: " + m.group(12));
				System.out.println("findMemoryFind gitmeden önceki durumlar.");
				ifElseControlStringObject = new IfElseControlString(satir, m.group(2), m.group(4), m.group(6),
						m.group(8), m.group(10), m.group(12));
				ifElseControlStringObject.findMemoryFind();
			} else {

				System.out.println("mGroup2: " + m.group(2));
				System.out.println("mGroup4: " + m.group(4));
				System.out.println("mGroup6: " + m.group(6));
				System.out.println("mGroup7: " + m.group(8));
				System.out.println("mGroup9: " + m.group(10));
				System.out.println("go to IfElseControlString");
				ifElseControlStringObject = new IfElseControlString(satir, m.group(4), m.group(6), m.group(10),
						m.group(12));
				ifElseControlStringObject.Control();
			}

		}
	}

	protected int controlif(int ifIndex, int value1, int value2, String operators) throws Exception {

		int endIfIndex = ifIndex; // Repeat(satir)--> m=satir ;
		syntaxSemiColonControl(ifIndex, mGroup3, "if");
		syntaxendifControl();
		while (!mainClass.satirText[endIfIndex].equals("endif;")) // ilk cümlede t[1] de exit olana kadar döngüye devam
																	// et.
		{
			endIfIndex++;
		}

		int copyEndIfIndex = endIfIndex; // Exit olan yan, son satiri
		System.out.println("endif 'in olduğu satir: " + copyEndIfIndex);

		System.out.println("operators: " + operators);
		System.out.println("operatorsArray[i]" + operatorsArray[0]);

		if (operators.equals(operatorsArray[0])) {
			System.out.println(">");
			if (value1 > value2) {
				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);
			} else {
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);
			}

		} else if (operators.equals(operatorsArray[1])) {
			System.out.println("<");
			if (value1 < value2) {
				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);
			} else {
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);
			}
		} else if (operators.equals(operatorsArray[2])) {
			System.out.println("==");
			if (value1 == value2) {
				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);

			} else {
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);
			}
		} else if (operators.equals(operatorsArray[3])) {

			System.out.println("<=");
			if (value1 <= value2) {
				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);
			} else {
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);
			}
		} else if (operators.equals(operatorsArray[4])) {

			System.out.println(">=");
			if (value1 >= value2) {
				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);
			} else {
				System.out.println("*****");
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);

			}
		} else if (operators.equals(operatorsArray[5])) {
			System.out.println("!=");
			if (value1 != value2) {
				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);
			} else {
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);

			}
		} else {
			// System.out.println("hiç bir operanta girmedi");
			throw new RunError("Yanlış veya eksik operant girilmiştir.");
		}

		return endIfIndex;
	}

	protected void controlInIf(int satirInIf, int copyEndIfIndex) throws Exception { // o=ifIndex+1
		System.out.println("satirText[o+1]" + mainClass.satirText[satirInIf] + " indeksi:" + satirInIf + " endIfIndex: "
				+ copyEndIfIndex);
		for (int i = satirInIf; i < copyEndIfIndex; i++) {
			System.out.println(i + ".indekse for döngü");
			if (mainClass.satirText[i].contains("for")) {
				programClassObjectifControlin
						.checkSyntax(mainClass.satirText[i].substring(0, mainClass.satirText[i].length()), i);
				System.out.println("her işlem yapıldığında: " + mainClass.satir);
				int endForIndexFind = i;
				while (!mainClass.satirText[endForIndexFind].equals("endfor;")) {
					endForIndexFind++;
				}
				System.out.println("endfor; ifadesinin bulunduğu satir: " + endForIndexFind);
				i = endForIndexFind + 1;
			} else {

				programClassObjectifControlin
						.checkSyntax(mainClass.satirText[i].substring(0, mainClass.satirText[i].length()), i);
				System.out.println("her işlem yapıldığında: " + mainClass.satir);
			}

		}
		System.out.println("DÖNGÜ BİTTİ !!!!!!");

	}

	private int controlelse(int startElseIndex) throws Exception {
		int endElseIndex = startElseIndex;
		syntaxendelseControl();
		while (!mainClass.satirText[endElseIndex].equals("endelse;")) {
			endElseIndex++;
		}
		System.out.println("for döngüsünün bittiği yerde endElseIndex: " + endElseIndex);
		for (int i = startElseIndex + 1; i < endElseIndex; i++) {

			System.out.println(i + ".indekse for döngü");
			if (mainClass.satirText[i].contains("for")) {
				programClassObjectifControlin
						.checkSyntax(mainClass.satirText[i].substring(0, mainClass.satirText[i].length()), i);
				System.out.println("her işlem yapıldığında mainClass.satir: " + mainClass.satir);
				int endForIndexFind = i;
				while (!mainClass.satirText[endForIndexFind].equals("endfor;")) {
					endForIndexFind++;
				}
				System.out.println("endfor; ifadesinin bulunduğu satir: " + endForIndexFind);
				i = endForIndexFind + 1;
			} else {
				programClassObjectifControlin
						.checkSyntax(mainClass.satirText[i].substring(0, mainClass.satirText[i].length()), i);
				System.out.println("her işlem yapıldığında: " + mainClass.satir);
			}
		}
		return endElseIndex + 1;

	}

	protected void ifIcineGiripElseSatiriniAtlama(int endIfIndex) throws RunError {
		if (mainClass.satirText[endIfIndex + 1].contains("el")) {
			syntaxElseControl(endIfIndex);
			syntaxendelseControl();
			System.out.println("else var");
			int findEndElseIndex = endIfIndex + 1;
			while (!mainClass.satirText[findEndElseIndex].equals("endelse;")) {
				findEndElseIndex++;
			}
			System.out.println("findElseIndex: " + findEndElseIndex);
			mainClass.satir = findEndElseIndex + 1;
		} else {
			System.out.println("else yok ");
			mainClass.satir = endIfIndex + 1;
		}
	}

	protected void ifIcineGiripOperatoruSaglamayipElseinIcineGirme(int endIfIndex) throws Exception {
		int jump = 0;

		try {
			System.out.println("endIfIndex: " + endIfIndex);
			if (mainClass.satirText[endIfIndex + 1].contains("el")) {
				syntaxElseControl(endIfIndex);
				jump = controlelse(endIfIndex + 1);
				System.out.println("mainClass.satir---->>>>>" + jump);
				mainClass.satir = jump;
			} else {
				System.out.println("**--");
				mainClass.satir = endIfIndex + 1;
			}
		} catch (Exception e) {
			System.out.println("*/*/*/*");
			throw new RunError("else yapısına içinde bir hata var !!!");
		}
	}

	public void syntaxElseControl(int endIfIndex) throws RunError {
		if (mainClass.satirText[endIfIndex + 1].contains("else")) {
			syntaxSemiColonControl(endIfIndex + 1, mGroup3, "else");
		} else {
			throw new RunError("else; anahtar kelimesini düzgün yaz !!");
		}
	}

	public void syntaxendelseControl() throws RunError {
		boolean endiffind = false;
		for (int i = 0; i < mainClass.satirText.length; i++) {
			if (mainClass.satirText[i].contains("endelse")) {
				syntaxSemiColonControl(i, mGroup3, "endelse");
				endiffind = true;
				System.out.println("endelse'in bulunduğu yer: " + i);
			}
		}
		if (endiffind == true) {

		} else {
			throw new RunError("endelse; anahtar sözcüğü eksik yada hatalı girilmiştir.");
		}
	}

	protected void syntaxendifControl() throws RunError {
		boolean endiffind = false;
		for (int i = 0; i < mainClass.satirText.length; i++) {
			if (mainClass.satirText[i].contains("en")) {
				endiffind = true;
				syntaxSemiColonControl(i, mGroup3, "endif");
			}
		}
		if (endiffind == true) {

		} else {
			throw new RunError("endif; anahtar sözcüğü eksik yada hatalı girilmiştir.");
		}
	}

	protected void syntaxSemiColonControl(int ifandElseIndex, String semiColon, String errorInformation)
			throws RunError {
		if (mainClass.satirText[ifandElseIndex].contains(";")) {

		} else {
			throw new RunError(errorInformation + "'in (';') noktali virgülü yok !!!");
		}
	}

}

//boolean endiffind = false;
//for (int i = 0; i < mainClass.satirText.length; i++) {
//	if (mainClass.satirText[i].equals("endif;")) {
//		endiffind = true;
//	}
//}
//if (endiffind == true) {
//
//} else {
//	throw new RunError("endif; anahtar sözcüğü eksik yada hatalı girilmiştir.");
//}
