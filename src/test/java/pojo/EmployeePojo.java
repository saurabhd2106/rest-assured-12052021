package pojo;

import java.util.List;

public class EmployeePojo {
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private List<Long> allPhoneNumber;
	
	private List<Address> allAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getAllPhoneNumber() {
		return allPhoneNumber;
	}

	public void setAllPhoneNumber(List<Long> allPhoneNumber) {
		this.allPhoneNumber = allPhoneNumber;
	}

	public List<Address> getAllAddress() {
		return allAddress;
	}

	public void setAllAddress(List<Address> allAddress) {
		this.allAddress = allAddress;
	}

}
