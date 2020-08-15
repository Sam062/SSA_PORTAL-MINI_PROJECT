package base.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserModel {
	private String fname;
	private String lname;
	private String gender;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob; // INPUT FORM- "1997-10-01"
	private String state;
	
	
//	public Date getDob() {
//		return dob;
//	}
//	public void setDob(String dob) throws ParseException {
//		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd"); 
//		Date date=f.parse(dob);  
//		this.dob = date;
//	}
}
