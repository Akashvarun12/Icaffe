package pojo;

import java.util.Map;

public class ConsigneeTestData {

	private String selectConsigneeType_InSearch;
	private String selectPartyName_InSearchGrid;
	private String selSubTypeRaidioBT;
	private String partyName;
	private String partyAddress;
	private String entCountry;
	private String country;
	private String entState;
	private String entExtendedName;
	private String entContactPerson;
	private String entEmail;
	private String expConfirmationMsg;

	// Constructor
	public ConsigneeTestData(Map<String, String> testData) {
		this.selectConsigneeType_InSearch = testData.get("selectConsigneeType_InSearch");
		this.selectPartyName_InSearchGrid = testData.get("selectpartyName_InSearchGrid");
		this.selSubTypeRaidioBT = testData.get("selSubTypeRaidioBT");
		this.partyName = testData.get("partyName");
		this.partyAddress = testData.get("partyAddress");
		this.entCountry = testData.get("entCountry");
		this.country = testData.get("country");
		this.entState = testData.get("entState");
		this.entExtendedName = testData.get("entExtendedName");
		this.entContactPerson = testData.get("entContactPerson");
		this.entEmail = testData.get("entEmail");
		this.expConfirmationMsg = testData.get("expConfirmationMsg");
	}

	// Getters

	public String selectConsigneeType_InSearch() {
		return selectConsigneeType_InSearch;
	}

	public String getselectpartyName_InSearchGrid() {
		return selectPartyName_InSearchGrid;
	}

	public String selSubTypeRaidioBT() {
		return selSubTypeRaidioBT;
	}

	public String getPartyName() {
		return partyName;
	}

	public String getPartyAddress() {
		return partyAddress;
	}

	public String getEntCountry() {
		return entCountry;
	}

	public String getCountry() {
		return country;
	}

	public String getEntState() {
		return entState;
	}

	public String entExtendedName() {
		return entExtendedName;
	}

	public String entContactPerson() {
		return entContactPerson;
	}

	public String entEmail() {
		return entEmail;
	}

	public String getExpConfirmationMsg() {
		return expConfirmationMsg;
	}

}
