package entities;

import enums.AccountType;

public class Account {
	
	private int aid; //Account ID
	private AccountType type;
	
	public Account(String type) {
        this.aid = UniqueIdGenerator.getUniqueID();
        this.type = AccountType.valueOf(type);
	}
	
}