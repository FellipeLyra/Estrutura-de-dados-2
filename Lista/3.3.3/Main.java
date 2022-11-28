
public class Main {
	public static void main(String[] args) {
		Conversao c = new Conversao();
		System.out.println(c.preFixPPosFix("@A"));
		System.out.println(c.preFixPPosFix("+@AB"));
		System.out.println(c.preFixPPosFix("*AB"));
		System.out.println(c.preFixPPosFix("*A+BC"));
		System.out.println(c.preFixPPosFix("**+AB-+CDEF"));
		System.out.println(c.preFixPPosFix("**+AB-+CD@E F"));
	}
}
