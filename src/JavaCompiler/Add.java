package JavaCompiler;

import javax.swing.JOptionPane;

class Add extends Program implements Command {
	int flag = 1;

	@Override
	public void checkSyntax(String mainFromString) throws Exception {
		System.out.println("add classına gelen String: " + mainFromString);
		if (mainFromString.charAt(mainFromString.length() - 1) == ';') {
			System.out.println("var.");
		} else {
			throw new RunError("add" + "'ın (';') noktali virgülü yok !!!");
		}
		mainFromString = mainFromString.substring(0, mainFromString.length() - 1);
		System.out.println("mainFromString" + mainFromString);

		mainFromString = mainFromString.substring(3); // Add den sonraki string

		String add[];// Add yapılacak değişkenleri tutmak için
		add = mainFromString.trim().split("\\+");
		double d[] = new double[5];
		int l = 0; // for için
		double a = 0;

		try {
			for (l = 0; l < add.length; l++) {

				// double gelen bir sayiyi okumuyor !!!!!!!!!!!!!!!!!
				if (add[l].matches("(?<!\\S)\\d++(?!\\S)")) {
					// rakams

					d[l] = Double.parseDouble(add[l]); // double çevir.
					a += d[l];

				}

				else {
					// rakam dışında bir ifade ise hashtable dan bi kontrol etmemiz lazım

					if (var.containsKey(add[l]) == true) {
						// System.out.println(var.get(add[l]));
						d[l] = Double.parseDouble(var.get(add[l])); // double çevir.

						a += d[l];
					} else
						try {
							throw new RunError("Invalid variable in Add-hashtable not find.");
						} catch (RunError r) {

						}
				}
			}

			ex[i] = "Add," + a;
			i++;
			flag = 0;

		} catch (NumberFormatException e) { // NumberFormatException karakter katarinin sayisal bicime gecersiz donusumu
			String j = "";
			for (int k = 0; k < add.length; k++) {
				if (var.containsKey(add[k])) {
					j += ".";
					j += add[k];
				} else
					try {
						throw new RunError("Invalid variable error");
					} catch (RunError r) {

					}
			}

			j = j.substring(1);

			ex[i] = "Add," + j;
			i++;

		}
		String aString = Double.toString(a);
		executeCommand(aString);
	}

	@Override
	public void executeCommand(String s) {
		System.out.println("executeCommand(String s) ile gelen s degeri: " + s);
		float add = 0;
		if (flag == 0)
			text2.append("\n" + s);
		else {
			// ??????????????? mimari degistikten sonra burası duzeltilmedi ?????????????
			int f = 0;
			String t[] = s.split("\\.");

			while (var.containsKey(t[f])) {
				Float g = getValue(t[f]);
				add += g;
				f++;

				if (f == t.length)
					break;
			}

			text2.append("\n" + add);
		}

	}

}
