import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Encryption {
	
	private static final char[] hexChar = {
	        '0', '1', '2', '3', '4', '5', '6', '7',
	        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
	};
	
	/*
	 * Demo for encrypt plain text to SHA-256 and return the has value
	 *  Text string consists of English alphabetic letters 
	 *  (i.e.,  and/or decimal digits (i.e.,  through ) only.
	 * 
	 */
	public String encrypt(String text) {
		
		String ret = "";
		if(text == null || text == "") {
			return ret;
		}
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
			
			ret = toHexString(hash);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();			
		}
		
		return ret;
	}
	
	 private  String toHexString(byte[] b) {
	    StringBuilder sb = new StringBuilder(b.length * 2);
	    for (int i = 0; i < b.length; i++) {
	         sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
	         sb.append(hexChar[b[i] & 0x0f]);
	    }
	    return sb.toString();
	}
}
