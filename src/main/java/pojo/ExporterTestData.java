package pojo;

import java.util.Map;

public class ExporterTestData {
	private String selectclassDropDownOption_InSearch;
	private String selectname_or_ID_InSearch;
	private String selectpartyName_InSearchGrid;
	private String partyName;
	private String IECNumber;
	private String classDropDownOption;
	private String mercManufDropDownOption;
	private String serialNumber;
	private String partyAddress;
	private String entCountry;
	private String country;
	private String entState;
	private String state;
	private String regNumber;
	private String ctxState;
	private String ADCode;
	private String expConfirmationMsg;

	// Constructor
	public ExporterTestData(Map<String, String> testData) {
		this.selectclassDropDownOption_InSearch = testData.get("selectclassDropDownOption_InSearch");
		this.selectname_or_ID_InSearch = testData.get("selectname_or_ID_InSearch");
		this.selectpartyName_InSearchGrid = testData.get("selectpartyName_InSearchGrid");
		this.partyName = testData.get("partyName");
		this.IECNumber = testData.get("IECNumber");
		this.classDropDownOption = testData.get("classDropDownOption");
		this.mercManufDropDownOption = testData.get("mercManufDropDownOption");
		this.serialNumber = testData.get("serialNumber");
		this.partyAddress = testData.get("partyAddress");
		this.entCountry = testData.get("entCountry");
		this.country = testData.get("country");
		this.entState = testData.get("entState");
		this.state = testData.get("state");
		this.regNumber = testData.get("regNumber");
		this.ctxState = testData.get("ctxState");
		this.ADCode = testData.get("ADCode");
		this.expConfirmationMsg = testData.get("expConfirmationMsg");
	}

	// Getters
	
	public String getSelectclassDropDownOption_InSearch() {
		return selectclassDropDownOption_InSearch;
	}
	
	public String getSelectname_or_ID_InSearch() {
		return selectname_or_ID_InSearch;
	}

	public String getselectpartyName_InSearchGrid() {
		return selectpartyName_InSearchGrid;
	}
	
	public String getPartyName() {
		return partyName;
	}

	public String getIECNumber() {
		return IECNumber;
	}

	public String getClassDropDownOption() {
		return classDropDownOption;
	}

	public String getMercManufDropDownOption() {
		return mercManufDropDownOption;
	}

	public String getSerialNumber() {
		return serialNumber;
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

	public String getState() {
		return state;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public String getCtxState() {
		return ctxState;
	}

	public String getADCode() {
		return ADCode;
	}

	public String getExpConfirmationMsg() {
		return expConfirmationMsg;
	}
}
