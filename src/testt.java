
public class testt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="李白|123.2";
		System.out.println(s.substring(0,s.indexOf("|")));
		System.out.println(s.substring(s.indexOf("|")+1,s.length()));
	}

}
