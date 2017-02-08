package beans;

import java.util.Optional;
import java.util.concurrent.Future;

public interface AddressRepository {
	
	Future<Optional<Address[]>> getByPostCode (String country,String postCode);
}
