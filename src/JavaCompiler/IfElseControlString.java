package JavaCompiler;

public class IfElseControlString extends IfElseControlandInteger {
	private String value1;
	private String value2;
	private String operators;
	private String semiColon;
	private int ifIndex;
	private String specialCharacter1;
	private String specialCharacter2;

	IfElseControlString(int ifIndex, String mGroup1, String operators, String mGroup2, String semiColon) {
		this.value1 = mGroup1;
		this.value2 = mGroup2;
		this.operators = operators;
		this.ifIndex = ifIndex;
		this.semiColon = semiColon;
	}

	IfElseControlString(int ifIndex, String specialCharacter1, String value1, String operators,
			String specialCharacter2, String value2, String semiColon) {
		this.ifIndex = ifIndex;
		this.specialCharacter1 = specialCharacter1;
		this.value1 = value1;
		this.operators = operators;
		this.specialCharacter2 = specialCharacter2;
		this.value2 = value2;
		this.semiColon = semiColon;
	}

	public void Control() throws Exception {
		int endIfIndex = ifIndex;
		syntaxSemiColonControl(ifIndex, semiColon, "if");
		syntaxendifControl();
		while (!mainClass.satirText[endIfIndex].equals("endif;")) // ilk cümlede t[1] de exit olana kadar döngüye devam
		// et.
		{
			endIfIndex++;
		}
		syntaxSemiColonControl(ifIndex, semiColon, "endif");
		int copyEndIfIndex = endIfIndex; // Exit olan yan, son satiri
		System.out.println("endif 'in oldugu satir: " + copyEndIfIndex);
		if (operators.equals(operatorsArray[2])) {
			System.out.println("==");
			
			if (value1.equalsIgnoreCase(value2)) {

				System.out.println("ilk kelime grubu: " + value1);
				System.out.println("ikinci kelime grubu: " + value2);

				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);

			} else {
				System.out.println("ilk kelime grubu: " + value1);
				System.out.println("ikinci kelime grubu: " + value2);
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);
			}
		} else if (operators.equals(operatorsArray[5])) {
			System.out.println("!=");
			if (!value1.equals(value2)) {
				controlInIf(ifIndex + 1, copyEndIfIndex);
				System.out.println("endIfIndex-->> " + endIfIndex);
				ifIcineGiripElseSatiriniAtlama(endIfIndex);
			} else {
				ifIcineGiripOperatoruSaglamayipElseinIcineGirme(endIfIndex);

			}
		}

	}

	public void findMemoryFind() throws Exception {

		int v1;
		int v2;
		System.out.println("mGroup2: " + ifIndex);
		System.out.println("mGroup4: " + specialCharacter1);
		System.out.println("mGroup6: " + value1);
		System.out.println("mGroup8: " + operators);
		System.out.println("mGroup10: " + specialCharacter2);
		System.out.println("mGroup6: " + value2);
		System.out.println("mGroup12: " + semiColon);
		System.out.println("**************");
		System.out.println(value1 + "degişkenin hafızaki karsiligı: " + var.get(value1));
		System.out.println(value2 + "degişkenin hafızaki karsiligı: " + var.get(value2));
		if (specialCharacter1.equals(specialCharacter2)) {
			if (var.containsKey(value1) && var.containsKey(value2)) {
				v1 = Integer.parseInt(var.get(value1));
				v2 = Integer.parseInt(var.get(value2));
				controlif(ifIndex, v1, v2, operators);
			} else {
				if (var.containsKey(value1)) {

				} else {
					throw new RunError("'" + value1 + "'" + " degiskenin hafıza bir karşılıgı yoktur.");
				}
				if (var.containsKey(value2)) {

				} else {
					throw new RunError(value2 + " degişkenin hafıza bir karşılıgı yoktur.");
				}
			}

		} else {
			throw new Exception("ozel karakteriniz '&' eksik ya da yanlış girilmiştir.");
		}

	}
}
