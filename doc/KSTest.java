import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class KSTest {
	public static void main(String[] args) {
		try {
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			char[] password = "password".toCharArray(); 
			ks.load(null, password); 
			// Store away the keystore. 
			FileOutputStream fos = new FileOutputStream("myKeystore.jks"); 
			ks.store(fos, password); fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}