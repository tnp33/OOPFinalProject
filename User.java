
public class User {
	public String name;
	public String address;
	public String email;
	
	public User(){
		name = "undefined";
		address ="undefined";
		email = "undefined";
				
	}
	
	public User(String name, String address, String email, String occupation) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.occupation = occupation;
	}

	public String occupation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
