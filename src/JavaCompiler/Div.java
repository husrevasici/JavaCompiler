package JavaCompiler;

import javax.swing.JOptionPane;

class Div extends Program implements Command {
	int flag = 1;

	@Override
	public void checkSyntax(String mainFromString) throws Exception {
		System.out.println(mainFromString);
		if (mainFromString.charAt(mainFromString.length() - 1) == ';') {
			System.out.println("var.");
		} else {
			throw new RunError("add" + "'in (';') noktali virgülü yok !!!");
		}
		mainFromString = mainFromString.substring(0, mainFromString.length() - 1);
		mainFromString = mainFromString.substring(3).trim(); // Add den sonraki string
		System.out.println(mainFromString);
		String div[];// Add yapılacak değişkenleri tutmak için
		div = mainFromString.trim().split("\\/");
		double divValue[] = new double[div.length];
		// int f = 0; // for için
		double count = 0;
		double result = 0;

		for (int h = 0; h < div.length; h++) {
			System.out.println(h + ".indeks: " + div[h]);
		}

		try {
			for (int f = 0; f < div.length; f++) {

				if (div[f].matches("(?<!\\S)\\d++(?!\\S)")) {

					divValue[f] = Double.parseDouble(div[f]); // double çevir.
					if (f == 0) {
						result = divValue[0];
						divValue[0] = 1;
						// text2.append("result: " + result);
					}
					result /= divValue[f];

				} else {
					if (var.containsKey(div[f]) == true) {
						System.out.println(var.get("hafıza ya bakmaya gidiyor." + div[f]));
						divValue[f] = Double.parseDouble(var.get(div[f]));

						if (f == 0) {
							result = divValue[0];
							divValue[0] = 1;
						} // end if
						result /= divValue[f];
					} // end if
				} // end else
			} // end for

			ex[i] = "Div," + result;
			i++;
			flag = 0;

		} catch (NumberFormatException e) { // NumberFormatException karakter katarinin sayisal bicime gecersiz donusumu
			String j = "";
			for (int k = 0; k < div.length; k++) {
				if (var.containsKey(div[k])) {
					j += ".";
					j += div[k];
				} else
					try {
						throw new RunError("Invalid variable in Addasdasda");
					} catch (RunError r) {

					}
			}

			j = j.substring(1);

			ex[i] = "Div," + j;
			i++;
		}
		String resultNew = Double.toString(result);
		executeCommand(resultNew);
	}

	@Override
	public void executeCommand(String s) {
		float add = 0;
		if (flag == 0)
			text2.append("\n" + s);
		else {
			int f = 0;
			String t[] = s.split("\\.");

			while (var.containsKey(t[f])) {
				Float g = getValue(t[f]);
				add += g;
				f++;

				if (f == t.length)
					break;
			}
			text2.append("t[0]:\n" + t[0]);
			text2.append("t[1]:\n" + add);
			text2.append("add:\n" + add);
		}

	}

}
/*
 * if(divValue.length==0 || divValue.length==1) { try { throw new
 * RunError("Missing variable in Div"); // eksik degisken } catch (RunError r) {
 * 
 * } } else if(divValue.length==2) {
 * 
 * result= divValue[0]/divValue[1];
 * 
 * } else if(divValue.length==3) { result=(divValue[0]/divValue[1])/divValue[2];
 * } else { // System.out.println(divValue.length); try { throw new
 * RunError("failure variable in Div"); // hatali degişken } catch (RunError r)
 * {
 * 
 * } }
 * 
 */
