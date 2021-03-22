package stackjava.com.springmvchello.entities;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import stackjava.com.springmvchello.validator.Phone;

public class User {

	@NotNull(message = "Id not null")
	private Integer id;

	@NotBlank
	@Length(min = 5, max = 10)
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	private Date dateOfBirth;

	@Phone(message = "so dien thoai khong dung")
	private String phoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
