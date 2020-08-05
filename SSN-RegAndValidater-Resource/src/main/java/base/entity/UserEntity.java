package base.entity;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
@Table(name = "USER_SSN")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name = "SSN")
	private Long ssn;
	@Column(name = "FNAME")
	private String firstName;
	@Column(name = "LNAME")
	private String lastName;
	@Column(name = "GENDER")
	private Character gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "STATE")
	private String state;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", insertable = false)
	private Date updatedDate;
}
