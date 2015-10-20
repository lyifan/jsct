import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class SHA256
{
    public static void main(String[] args)throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
		if( args.length == 0) {
			System.out.println("Usage: java SHA256 something");
			return;
		}
		
		md.update(args[0].getBytes());
		System.out.println( new BASE64Encoder().encode(md.digest()));
    }
}