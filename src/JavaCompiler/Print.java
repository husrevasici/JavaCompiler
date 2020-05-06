package JavaCompiler;

import javax.swing.text.BadLocationException;

class Print extends Program implements Command {
	@Override
	public void checkSyntax(String s) throws RunError, Exception {
		System.out.println("Print Classı gelen String -->> " + s);
		if (s.charAt(s.length() - 1) == ';') {

		} else {
			throw new RunError("Print" + "'in (';') noktali virgülü yok !!!");
		}
		s = s.substring(0, s.length() - 1);
		System.out.println("seconds: " + s);
		int f = s.indexOf(' '); // ilk boslugun index degeri
		s = s.substring(f).trim(); // ilk bosluktan sonraki kisimi s ye tekrardan yaz.
		String p = "";
		int flag = 0; // String girip girmedigini kontrol etmek

		if (s.charAt(0) == '"') {
			System.out.println("noktalı virgül içinde bir string");
			ex[i] = "Print," + s;
			i++;
			flag = 1;
			executeCommand(s);
		}

		else if (s.charAt(0) != '"') {
			System.out.println("hafıza bulunan bir value hafıza git oraya sor");
			p = s.substring(0, s.length()).trim();
			System.out.println("p: " + p);
			if (var.containsKey(p)) // degisken onceden tanilanmissa
			{
				System.out.println(var.get(p));
				ex[i] = "Print," + var.get(p);
				i++;
				flag = 1;
				executeCommand(p);
			} else {
				throw new Exception("Hafıza da kayıtlı" + p + " adında bir değişken yoktur lütfen kontrol et !!");
			}
		}

		else {
			if (flag == 0)
				throw new RunError("Error in Print Syntax");
		}

	}

	@Override
	public void executeCommand(String s) throws Exception {

		System.out.println("Print executeCommanda gelen s: " + s);

		if (s.charAt(0) == '"') {
			s = s.substring(1, s.length() - 1); // iki noktalı virgülü siler.
			String s1 = "";
			try {
				s1 = text2.getText();

			} catch (NullPointerException e) {
				text2.setText(s);
			}

			text2.setText(s1 + "\n" + s);
		} else {

			text2.append("\n" + var.get(s)); // sonuna f yi ekle

		}
	}

}
