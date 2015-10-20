import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EnDecrypt {

	public static void main(String[] args) throws Exception {
		Cipher cipher = Cipher.getInstance("ARCFOUR");
		String passwd = "12345678";
		SecretKeySpec key = new SecretKeySpec(passwd.getBytes("ASCII"), "ARCFOUR");
		String input = "Hello World";
		
		if (args.length > 0) {
			input = args[0];
		}
		
		System.out.println("Input: " + input);
		
		byte[] text = input.getBytes("ASCII");
		
		byte[] cipherText = encrypt(cipher, key, text);
		
		System.out.println("Encrypted result: " + cipherText);

		String plainText = decrypt(cipher, key, cipherText);

		System.out.println("Decrypted result: " + plainText);
	}
	
	private static byte[] encrypt(Cipher cipher, SecretKeySpec key, byte[] plainText)  throws Exception  {

		byte[] cipherText = new byte[plainText.length];
	
		// 1. init
		cipher.init(Cipher.ENCRYPT_MODE, key);

		// 2. update
		int ctLength = cipher.update(plainText, 0, plainText.length, cipherText, 0);
		
		// 3. doFinal
		ctLength += cipher.doFinal(cipherText, ctLength);
		
		return cipherText;
	}
	
	private static String decrypt(Cipher cipher, SecretKeySpec key, byte[] cipherText)  throws Exception  {
		byte[] plainText = new byte[cipherText.length];
		
		// 1. init
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		// 2. update
		int ptLength = cipher.update(cipherText, 0, cipherText.length, plainText, 0);
		
		// 3. doFinal
		ptLength += cipher.doFinal(plainText, ptLength);
		
		return new String(plainText, "ASCII");
	}
}