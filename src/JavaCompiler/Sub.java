package JavaCompiler;

import javax.swing.JOptionPane;

class Sub extends Program implements Command {

	int flag = 1;

	static double count = 0;

	@Override
	public void checkSyntax(String mainFromString) throws Exception {

		System.out.println(mainFromString);
		if (mainFromString.charAt(mainFromString.length() - 1) == ';') {
			System.out.println("var.");
		} else {
			throw new RunError("sub" + "'ın (';') noktali virgülü yok !!!");
		}
		mainFromString = mainFromString.substring(0, mainFromString.length() - 1);
		mainFromString = mainFromString.substring(3); // Sub'dan sonra gelen ifade
		System.out.println(mainFromString);
		String sub[];// Sub kelimesininden sonra gelen ifadeleri tutmak için sub dizisi

		// String[] parsedStr = str.split("\\ "); seklinde tanimlamayi unutma
		sub = mainFromString.trim().split("\\-");
		for (int i = 0; i < sub.length; i++)
			System.out.println(i + ".indekste " + sub[i] + " " + " ifadesi var.");
		double subValue[] = new double[sub.length];

		int f = 0; // for için

		try {

			for (f = 0; f < sub.length; f++) {

				if (sub[f].matches("(?<!\\S)\\d++(?!\\S)")) {
					// rakamsa
					System.out.println(sub[f] + " ifadesi rakamdır.");
					subValue[f] = Double.parseDouble(sub[f]); // double çevir.

					if (f == 0) {
						subValue[0] = -subValue[0];
					}
					count -= subValue[f];
				} else {
					System.out.println(
							sub[f] + "ifadesi else yapısının içine geldi ve hafıza da varmı diye kontrol edecek");

					if (var.containsKey(sub[f]) == true) {
						System.out.println(sub[f] + "ifadesi hafızada vardır.");
						System.out.println(var.get(sub[f]));
						subValue[f] = Double.parseDouble(var.get(sub[f])); // double çevir.

						System.out.println("subValue[" + f + "]" + " ifadesi hafıza " + subValue[f]);
						if (f == 0) {
							subValue[0] = -subValue[0];
						}
						count -= subValue[f];
					} else {
						throw new RunError(
								sub[f] + " ifadesi hafıza da bir değere sahip değildir. Lütfen kontrol et !!!");
					}
				}
			}

			ex[i] = "Sub," + count; // ex dizisinde hesaplanan sonuc diziye kaydedilir.
			i++;
			flag = 0;

		}

		catch (NumberFormatException e) {
			String j = "";
			for (int k = 0; k < sub.length; k++) {
				if (var.containsKey(sub[k])) {
					j += ".";
					j += sub[k];
				} else
					try {
						throw new RunError("Invalid variable in Sub");
					} catch (RunError r) {

					}
			}

			j = j.substring(1); // yukarda koydugumuz noktayi cikardik.

			ex[i] = "Sub," + j; // eger hashtable da bi karsiligi varsa yine ex[] dizisine yazilir.
			i++;
		}
		String countString = Double.toString(count);
		executeCommand(countString);
	}

	@Override
	public void executeCommand(String s) {
		float sub = 0;
		if (flag == 0)
			text2.append("\n" + s);
		else {
			int f = 0;
			String t[] = s.split("\\.");

			while (var.containsKey(t[f])) { // containsKey -> t[f] keyi daha önceden girilmiş mi hashtable'a bakar.
				Float g = getValue(t[f]); // eger varsa getir value sini Float g 'ye yaz.
				sub += g; // yukarida sub=0 ' a ekle.
				f++;

				if (f == t.length)
					break;
			}

			text2.append("\n" + sub);
		}

	}

}
/*
 * try { for (forIndex = 0; forIndex < sub.length; forIndex++) {
 * subValue[forIndex] = Double.parseDouble(sub[forIndex]); // double çevir. }
 * 
 * if (sub.length == 2) { count = subValue[0] - subValue[1]; } else if
 * (sub.length == 3) { count = subValue[0] - subValue[1] - count - subValue[2];
 * } else if (sub.length == 4) { count = subValue[0] - subValue[1] - count -
 * subValue[2] - subValue[3]; } else {
 * text2.setText("Missing and failure  variable in Sub"); /* try { throw new
 * RunError("Missing and failure  variable in Sub"); // eksik degisken } catch
 * (RunError r) {
 * 
 * }
 */
// }
// */
