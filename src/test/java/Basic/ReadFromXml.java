package Basic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ReadFromXml {
	@Parameters({"Browser","username","password","url"})
	@Test
	public void main(String Browser,String username,String password,String url) {
		System.out.println(Browser);
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
	}
}
