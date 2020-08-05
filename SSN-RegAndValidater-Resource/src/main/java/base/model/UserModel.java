package base.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class UserModel {
	private Long ssn;
	private String firstName;
	private String lastName;
	private Character gender;
	private Date dob; // INPUT FORM- "1997-10-01"
	private String state;
	private Date createdDate;
	private Date updatedDate;
	
	public Date getDob() {
		return dob;
	}
	public void setDob(String dob) throws ParseException {
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd"); 
		Date date=f.parse(dob);  
		this.dob = date;
	}
}
