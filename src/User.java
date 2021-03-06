import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for creating a new User object
 * Writes new records in the database
 * Includes methods for updating/deleting and checking data against the database
 */

public class User {
    private int cardCVV;
    private long cardNo;
    private String title, fName, lName, address1, address2, town, postcode, password;
    static String username; 
    private String email, phoneNo, orgName, webAddress, orgEmail, paymentMethod, userType;
    
    /**
     * Empty constructor
     */
    public User() {
    }

    /**
     * This constructs a user with the specified parameters.
     * @param cardNo the card number                    
     * @param cardCVV credit card security code
     * @param title the user gender                     
     * @param fName the users first name
     * @param lName the users last name                 
     * @param address1 the users address
     * @param address2 the users second address         
     * @param town the users town
     * @param postcode the users post code              
     * @param username the users login username
     * @param password the users password               
     * @param email the users email address
     * @param phoneNo the users phone number            
     * @param orgName the organization name
     * @param webAddress the organization web address
     * @param orgEmail the organization email
     * @param paymentMethod the payment method
     */
    public User(long cardNo, int cardCVV, String title, String fName, String lName, String address1,
                String address2, String town, String postcode, String username, String password, String email,
                String phoneNo, String orgName, String webAddress, String orgEmail, String paymentMethod) {
        this.cardNo = cardNo;
        this.cardCVV = cardCVV;
        this.title = title;
        this.fName = fName;
        this.lName = lName;
        this.address1 = address1;
        this.address2 = address2;
        if (address2 == null) {
        	this.address2 = "";
        }
        this.town = town;
        this.postcode = postcode;
        User.username = username;
        this.password = password;
        this.email = email;
        this.phoneNo = phoneNo;
        if (phoneNo == null) {
        	this.phoneNo = "";
        }
        this.orgName = orgName;
        this.webAddress = webAddress;
        this.orgEmail = orgEmail;
        this.paymentMethod = paymentMethod;
        this.userType = "customer";
        if (!RegisterView.checkType) {
        	this.orgName = "";
        	this.orgEmail = "";
        	this.paymentMethod = "On Booking";
        	this.webAddress = "";
        }
        if (RegisterView.checkType)
        	this.userType = "organization";
    }

    
    /**
     * Create a new database record
     */
    public void insertCustomerData() {
        String query;
            query = "INSERT INTO tbl_user(UserID,Title,Fname,LNAme,Address1,Address2,Town,PostCode,Username,Pass,Email" +
                    ",PhoneNo,CardNo,CVVCode,Type,OrganizationName,WebAddress,OrgEmail,PaymentMethod) VALUES(DEFAULT,'"
                    + this.title + "','" + this.fName + "','" + this.lName + "','" + this.address1 + "','" + this.address2 +
                    "','" + this.town + "','" + this.postcode + "','" + User.username + "','" + this.password + "','" + this.email + "','" +
                    this.phoneNo + "'," + this.cardNo + "," + this.cardCVV + ",'" + this.userType + "','" + this.orgName + "','" +
                    this.webAddress + "','" + this.orgEmail + "','" + this.paymentMethod + "');";
        try {
            Connect.updateData(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method checks if the value exists in the specified field in the database.
     * @param field table column
     * @param value data in the column
     * @return results
     */
    public boolean checkFieldInDB(String field, String value) {
        String query = "SELECT * FROM tbl_user WHERE " + field + "='" + value + "';";
        try {
            ResultSet results = Connect.selectStm(query);
            if (results.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * True if username and password combination exist in database
     * @return true or false depending on the users input
     */
    public boolean loginCheck(String username, String password) {
        String query = "SELECT * FROM tbl_user WHERE Username='" + username + "' AND Pass='" + password + "';";
        try {
            ResultSet results = Connect.selectStm(query);
            if (results.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Update customer details in the database
     *
     * @param username the users username
     * @param title the users gender
     * @param firstName the users first name
     * @param lastName the users last name
     * @param addressOne the users address
     * @param addressTwo the users second address
     * @param town the users town
     * @param postcode the users post code
     * @param email the users email address
     * @param phoneNumber the users phone number
     * @param cardNumber the users card number
     * @param cvv the users security card number
     * @param orgName the organization name
     * @param orgEmail the organization email
     * @param webAddress the organization web address
     * @param paymentMethod the payment method
     */
    public void updateDetails(String username,String title, String firstName, String lastName, String addressOne, String addressTwo, String town, String postcode,
    		String email, String phoneNumber, long cardNumber, int cvv, String orgName, String orgEmail, String webAddress, String paymentMethod) {
    	
    	String query = "UPDATE tbl_user SET Title='"+ title +"', FName = '"+ firstName +"', LName = '"+lastName+"', Address1 = '"+addressOne+"', Address2 = '"+addressTwo+""
    			+ "', Town = '"+town+"', PostCode = '"+postcode+"', Email = '"+email+"', PhoneNo = '"+phoneNumber+"', CardNo = '"+cardNumber+"', CVVCode = '"+cvv+""
    					+ "', OrganizationName = '"+orgName+"', OrgEmail = '"+orgEmail+"', WebAddress = '"+webAddress+"', PaymentMethod = '"+paymentMethod+"'"
    							+ "WHERE Username ='" + username + "';";
    	try {
			Connect.updateData(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    /**
     * This method returns a list of all the users that are registered from the database,
     * filtered on type
     *
     * @return String[] usernames
     */
    public String[] getAllUsernames(String typeFilter) {
        String query = "SELECT Username FROM tbl_user WHERE Type = '"+ typeFilter +"';";
        ArrayList<String> users = new ArrayList<>();
        try {
            ResultSet results = Connect.selectStm(query);
            while (results.next()) {
                String user = results.getString("Username");
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Object[] objDetails = users.toArray();
        return Arrays.copyOf(objDetails,objDetails.length,String[].class);
    }
    
    /**
     * This method returns a specified data from the users details.
     * @param username customer's username
     * @param field String- the field needed
     * @return String - field value
     */
    public String getData(String username, String field) {
        String query = "SELECT "+ field+" FROM tbl_user WHERE Username='" + username + "';";
        String data = "";
        try {
            ResultSet rs = Connect.selectStm(query);
            rs.next();
            data = rs.getString(field);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Update the password in the database
     *
     * @param newPass the new users password
     * @param username the actual user that is changing password
     */
    public void updatePass(String newPass, String username) {
    	String query = "UPDATE tbl_user SET Pass='" + newPass + "' WHERE Username='" + username + "'"; 

    	try {
			Connect.updateData(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Returns a list of all customer details
     *
     * @param username the users username
     * @return users details
     */
    public ArrayList<String> detailsList(String username) {
    	String query = "SELECT * FROM `tbl_user` WHERE Username = '" + username + "';";
    	ArrayList<String> details = new ArrayList<>();
    	try {
			ResultSet rs = Connect.selectStm(query);
			
	    	while (rs.next()) {
	    		details.add(rs.getString("Title"));
	    		details.add(rs.getString("FName"));
	    		details.add(rs.getString("LName"));
	    		details.add(rs.getString("Address1"));
	    		details.add(rs.getString("Address2"));
	    		details.add(rs.getString("Town"));
	    		details.add(rs.getString("PostCode"));
	    		details.add(rs.getString("Email"));
	    		details.add(rs.getString("PhoneNo"));
	    		long cardNo = rs.getLong("CardNo");
	    		details.add(String.valueOf(cardNo));
	    		int cvv = rs.getInt("CVVCode");
	    		details.add(String.valueOf(cvv));
	    		details.add(rs.getString("OrganizationName"));
	    		details.add(rs.getString("OrgEmail"));
	    		details.add(rs.getString("PaymentMethod"));
	    		details.add(rs.getString("WebAddress"));
	    		details.add(String.valueOf(rs.getInt("UserID")));
	    		
	    	}
		} catch (NullPointerException | SQLException e) {
			e.printStackTrace();
		}

        return details;
    }
    
    /**
     * This method returns a users ID according to the specified username. 
     * @param username the users username
     * @return users ID
     */
    public int getUserId(String username) {
    	String query = "SELECT * FROM tbl_user WHERE Username = '" + username + "';";
    	int ID = 0;
    	try {
    		ResultSet rs = Connect.selectStm(query);
        	rs.next();
        	ID = rs.getInt("UserID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return ID;
    }


}
