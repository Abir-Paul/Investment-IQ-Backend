package com.investmentiq.base.enums;

public class GlobalEnums
{
	
	public enum YesNoFlag
	{
		Y,N
	}

	public enum InstitutionType {

		POST_OFFICE("Post Office"),
		BANK("BANK");

		private final String displayName;

		InstitutionType(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}
}
