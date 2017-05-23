# Jsf-FormValidator
JSF &amp; XHTML form validators example

Phone number validator : 

<code>
<h:inputText value="#{person.phoneNumber}"
									id="phone_number"
									label="Phone Number"
									validatorMessage="must be like xxxx-xxx-xxxx">
						<f:validateRegex pattern="\d{4}-\d{3}-\d{4}" />			
</h:inputText>			
<h:message for="phone_number" styleClass="error"/>
</code>

Custom validator : 
In HTML----->>
<code>
Course code : <h:inputText value="#{person.courseCode}"
									id="course_code"
									label="Course Code"
									validator="#{person.courseCodeValidator}">
</h:inputText>			
<h:message for="course_code" styleClass="error"/>
</code>

------------------------------------------------------------
In Java----->>
<code>
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
</code>

Email validator : 
In HTML----->>
<code>
Email: <h:inputText value="#{person.email}"
									id="email"
									label="Email"
									validator="#{person.emailValidator}">
					</h:inputText>			
					<h:message for="email" styleClass="error"/>
  </code>
  
  ----------------------------------------------------------------
  
  In Java----->>
  <code>
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
</code>
