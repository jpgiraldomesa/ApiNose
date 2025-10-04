package co.ed.uco.nose.business.domain;

import java.util.UUID;

import co.ed.uco.nose.crosscuting.helper.TextHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;

public class UserDomain extends Domain{
	
	//Atributos
		private String firstname;
		private String secondname;
		private String firstlastname;
		private String secondlastname;
		private String email;
		private DocumentTypeDomain documentType;
		private String documentNumber;
		private CityDomain residenceCity;
		private String phoneNumber;
		private Boolean isEmailVerified;
		private Boolean isPhoneNumberVerified;
			
		//Constructor que asigna un ID y un nombre por defecto
		public UserDomain() {
			super(UUIDHelper.getUUIDHelper().getDefault());
			setName(TextHelper.getDefault());
		}
			
		//Constructor que asigna un ID por defecto y un nombre
		public UserDomain(final UUID id) {
			super(id);
			setName(TextHelper.getDefault());
		}
			
		//Constructor que asigna un ID y un nombre
		public UserDomain(final UUID id, final String firstname) {
			super(id);
			setName(firstname);
		}
			
		//Getter
		public String getName() {
			return firstname;
		}

		//Setter /Si el nombre es nulo, le asigna un valor por defecto y le quita los espacios en blanco al inicio y al final
		public void setName(final String firstname) {
			this.firstname = TextHelper.getDefaultWhithTrim(firstname);
		}

}
