package JavaCompiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

public class Main {
	static gui
	
	
	guiClassObject = new gui();
	public static String satirText[], d;
	static Program programClassObject = new Program();
	JTextArea text2;
	static int mGroup1;
	static int mGroup3;
	static char operators;
	static char operators1;
	static int satir;

	public static void main(String[] args) throws Exception {
		guiClassObject.go();
	}

	public int compile() throws Exception {
		int com = 0, k = 0; // com derleyenin basarili olup olmadigini gösterecek.
		satirText = guiClassObject.text.getText().split("\\n");
		// satirText, her komut satirini ayri ayri kaydeden bir dize dizisidir.

		for (satir = 0; satir < satirText.length - 1; satir++)
		// satirlari geziyoruz
		{
			System.out.println("SATİR İNDEKS ------------->>>>>>>>>>>>>>>> " + satir);
			if (satirText[satir].charAt(0) == 'R' || satirText[satir].charAt(0) == 'r')
			// Repeat kelimesi varsa
			{

				int j = satirText[satir].indexOf(' '); // ilk bosluk nerde
				String c = satirText[satir].substring(0, j); // kelimenin baslangici ile bosluksa kadar string c'de tut.

				d = satirText[satir].substring(j + 1); // bosluktan sonrasini ise string d'de tut.

				int jump = 0;
				if (c.equals("Repeat"))
					jump = repeat(satir);
				else {
					try {
						throw new RunError("Syntax Error in Repeat --> " + "Repeat seklinde olmali");

					} catch (RunError r) {

					}
				}

				satir = jump;
			}

			else {
				programClassObject.checkSyntax(satirText[satir].substring(0, satirText[satir].length()), satir);
			}
			// eger Repeat ile baslamiyorsa o satirdaki string ve satir numarasini
			// checkSyntax fonksiyonuna gonderiyoruz.

			k = satir;
		}

		if (k == satirText.length - 2)
			com = 3;
		return com;
	}

	public void run() throws Exception {

		programClassObject.executeCommand();

	}

	public int repeat(int o) throws Exception {

		String a[] = d.split(" "); // t[satir] in ilk bosluga kadar ayirdigimiz cümlenin devami olan cümleyi ilk
									// bosluguna kadar ayir.

		int m = o; // Repeat(satir)--> m=satir ;

		while (!satirText[m].equals("Exit;")) // ilk cümlede t[1] de exit olana kadar döngüye devam et.
		{
			m++;
		}

		int copy = m; // Exit olan yan, son satiri

		int n = 0; // Repeat kaç defa olacagi
		// burada Repeat den sonra hata da olabilir ??

		try {
			// Repeat'in value değeri olmassa asagidaki catch'e gider.

			n = Integer.parseInt(a[0]); // kaç defa döngü olacak

		} catch (NumberFormatException e) {
			try {
				throw new RunError("Syntax Error in Repeat --> ( Repeat Value ) seklinde olmali ");

			} catch (RunError r) {

			}
		}

		// Repeat n -> yani kaç defa döngüye girecek
		for (int k = 1; k <= n; k++) { 
			for (int x = o + 1; x < m; x++) {
				// Repeat içindeki, her satiri dönderecek.
				programClassObject.checkSyntax(satirText[x].substring(0, satirText[x].length()), x);
			}
		}
		return copy;

	}
}
