import java.security.*;

public class KeyPairSign {

	public static void main(String[] args) throws Exception {
	
		// gen key pair
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		KeyPair pair = generator.generateKeyPair();
		Key pubKey = pair.getPublic();
		Key privKey = pair.getPrivate();		
		
		
		// sign with private key
		Signature rsa = Signature.getInstance("SHA256withRSA"); 

		rsa.initSign(privKey);

		byte[] msg = "My Message".getBytes();

		rsa.update(msg, 0, msg.length);

		byte[] realSig = rsa.sign();

		System.out.println("Signature: " + new sun.misc.BASE64Encoder().encode(realSig));
		
		// verify
		rsa.initVerify(pubKey);

		rsa.update(msg, 0, msg.length);

		System.out.println("verified: " + rsa.verify(realSig));
	}

}


