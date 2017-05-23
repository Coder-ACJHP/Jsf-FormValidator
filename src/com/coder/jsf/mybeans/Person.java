package com.coder.jsf.mybeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Person {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String courseCode;
	private String email;
	
	public Person() {
		// TODO Auto-generated constructor stub
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void courseCodeValidator(FacesContext context,
									UIComponent component, Object value) throws ValidatorException {
		
		if(value == null) {
			return;
		}
		
		String message = value.toString();
		
		if(!message.startsWith("CODER")) {
			FacesMessage facesMessage = new FacesMessage("Must be start with CODER");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(facesMessage);
		}
	}

	public void emailValidator(FacesContext context,
								UIComponent component, Object value) throws ValidatorException {
		if(value == null) {
			return;
		}
		
		String vailedEmail = value.toString();
		
		final String EMAIL_PATTERN =  "^[_A-Za-z0-9-]+(\\." +
				"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
				"(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(vailedEmail);
		
		if(!matcher.matches()) {
			FacesMessage message = new FacesMessage("E-mail validation failed.",
						"Invalid E-mail format.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}
	
}


