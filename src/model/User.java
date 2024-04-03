package model;

public class User {
	
	private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }
    
    public boolean checkUserLogin()
    {
    	if(userId.equals("Seuli") && pin.equals("1234"))
    		{
    			return true;
    		} else  {
    			return false;
    		}
    }
}
