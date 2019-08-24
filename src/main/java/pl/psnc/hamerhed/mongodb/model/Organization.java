package pl.psnc.hamerhed.mongodb.model;

public enum Organization {
	X("org1"), Y("org2"), Z("org3");
	
	private String value;
	
	private Organization(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
	
	
}
