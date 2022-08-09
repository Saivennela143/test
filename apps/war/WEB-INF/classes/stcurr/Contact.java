package stcurr;

import java.io.Serializable;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	private int contactID;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String homePhone;
	private String workPhone;
	private String mobilePhone;
	
	public Contact() {
	}
	
	public Contact(int id) {
		this.setContactID(id);
	}

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public String toString() {
		return "#" + this.getContactID() + " " + this.getFirstName() + " " + this.getLastName();
	}
	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Contact contact = (Contact)obj;
		return this.getContactID() == contact.getContactID();
	}

}
