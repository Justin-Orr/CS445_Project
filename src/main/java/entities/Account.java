package entities;

import enums.AccountType;

public class Account {
	
	private int ID;
	private AccountType type;
	
	public Account(String type) {
        this.ID = UniqueIdGenerator.getUniqueID();
        this.type = AccountType.valueOf(type);
	}
	
	public boolean matchesId(int lid) {
        return(lid == this.ID);
    }

    public boolean isNil() {
        return false;
    }

    public int getID() {
        return this.ID;
    }
    
    public String getAccountType() {
    	return type.toString();
    }
    
    public void setAccountType(String type) {
    	this.type = AccountType.valueOf(type);
    }
    
    public boolean equals(Account a) {
    	if(this.ID == a.getID() && type == AccountType.valueOf(a.getAccountType())) 
    		return true;
    	else
    		return false;
    }
	
}