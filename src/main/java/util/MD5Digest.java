package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Digest {
	
	
	/**
	 * Method to calculate MD5 Hash for a given plain text string.
	 * 
	 * @param plainText The text for which MD5 hash is to be calculated.
	 * @return String which is the hash of the given text.
	 */
	public static String getMD5Hash(String plainText) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {
			return null;
		}
		md.reset();
		md.update(plainText.getBytes());
		byte[] digest = md.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashText = bigInt.toString(16);
		while (hashText.length() < 32)
			hashText = "0" + hashText;
		return hashText;
	}
}
