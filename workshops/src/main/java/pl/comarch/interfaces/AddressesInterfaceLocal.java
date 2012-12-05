package pl.comarch.interfaces;

import pl.comarch.datamodel.Address;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AddressesInterfaceLocal {

	public List<Address> findAll();
	public Address find(int addressId);
	public Address update(Address address);
	public int create(Address address);
	public void remove(int addressId);
	public List<Address> findRange(int offset, int limit);
	public long count();
}

