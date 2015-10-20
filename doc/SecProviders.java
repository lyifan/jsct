import java.security.Security;
import java.security.Provider;
import java.util.Iterator;

public class SecProviders {

	public static void main(String[] args) {
		Provider[] p = Security.getProviders();
		for (int i = 0; i < p.length; i++) {
		  System.out.println(p[i].getName());
		  Iterator<Provider.Service> it =  p[i].getServices().iterator();
		  while (it.hasNext()) {
			  System.out.println("\t" + it.next().getAlgorithm());
			}
		}
	}
}