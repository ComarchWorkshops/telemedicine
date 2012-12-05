package pl.comarch.interfaces;

import pl.comarch.datamodel.Address;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AddressesInterface {

	public List<Address> findAll();
	public Address find(int addressId);
	public Address update(Address address);
	public int create(Address address);
	public void remove(int addressId);
	public List<Address> findRange(int offset, int limit);
	public long count();
}

