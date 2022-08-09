package stcurr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ContactRetriever {

	public ContactRetriever() {
		super();
	}
	
	public Contact getContact(int id) {
		DataAccess dAccess = new DataAccess();
        Contact contact = new Contact();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pStatement = null;

        try {
            con = dAccess.getConnection();

            String sql = "SELECT * FROM CONTACTS WHERE CONTACT_ID = ?";

            pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, id);

            rs = pStatement.executeQuery();

            while (rs.next()) {
            	contact.setContactID(id);
                contact.setFirstName(rs.getString("FIRST_NAME"));
                contact.setLastName(rs.getString("LAST_NAME"));
                contact.setStreet(rs.getString("STREET"));
                contact.setCity(rs.getString("CITY"));
                contact.setState(rs.getString("STATE"));
                contact.setZipCode(rs.getString("ZIPCODE"));
                contact.setHomePhone(rs.getString("HOME_PHONE"));
                contact.setWorkPhone(rs.getString("WORK_PHONE"));
                contact.setMobilePhone(rs.getString("MOBILE_PHONE"));
            }

        } catch (Exception e) {
            System.out.println("Error retrieving ID: " + id);
        } 
        try {
            rs.close();
            pStatement.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error closing database connection");
        }
        return contact;
        
	}
	
	public ArrayList<Contact> getAllContacts() {
		DataAccess dAccess = new DataAccess();
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pStatement = null;

        try {
            con = dAccess.getConnection();

            String sql = "SELECT * FROM CONTACTS";

            pStatement = con.prepareStatement(sql);

            rs = pStatement.executeQuery();

            while (rs.next()) {
                Contact contact = new Contact();

                contact.setContactID(rs.getInt("CONTACT_ID"));
                contact.setFirstName(rs.getString("FIRST_NAME"));
                contact.setLastName(rs.getString("LAST_NAME"));
                contact.setStreet(rs.getString("STREET"));
                contact.setCity(rs.getString("CITY"));
                contact.setState(rs.getString("STATE"));
                contact.setZipCode(rs.getString("ZIPCODE"));
                contact.setHomePhone(rs.getString("HOME_PHONE"));
                contact.setWorkPhone(rs.getString("WORK_PHONE"));
                contact.setMobilePhone(rs.getString("MOBILE_PHONE"));

                contacts.add(contact);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving all contacts");
        } 
        try {
            rs.close();
            pStatement.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error closing database");
        }
        return contacts;      

    }
	
	public void remove(Contact contact) {
		DataAccess dAccess = new DataAccess();
        Connection con = null;
        PreparedStatement pStatement = null;
        int result = 0;
        int id = contact.getContactID();

        try {
            con = dAccess.getConnection();

            String sql = "DELETE FROM CONTACTS WHERE CONTACT_ID = ?";

            pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, id);
            
            result = pStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error deleting contact with ID: " + id + ". Return code from DELETE: " + result);
        } 
        try {
            pStatement.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error closing database connection");
        }
        
	}

	public void update(Contact contact) {
		DataAccess dAccess = new DataAccess();
        Connection con = null;
        PreparedStatement pStatement = null;
        int result = 0;
        int id = contact.getContactID();

        try {
            con = dAccess.getConnection();

            String sql = "UPDATE CONTACTS SET FIRST_NAME=?, LAST_NAME=?, STREET=?, CITY=?, STATE=?, ZIPCODE=?, HOME_PHONE=?, WORK_PHONE=?, MOBILE_PHONE=? WHERE CONTACT_ID = ?";

            pStatement = con.prepareStatement(sql);
            pStatement.setString(1, contact.getFirstName());
            pStatement.setString(2, contact.getLastName());
            pStatement.setString(3, contact.getStreet());
            pStatement.setString(4, contact.getCity());
            pStatement.setString(5, contact.getState());
            pStatement.setString(6, contact.getZipCode());
            pStatement.setString(7, contact.getHomePhone());
            pStatement.setString(8, contact.getWorkPhone());
            pStatement.setString(9, contact.getMobilePhone());
            pStatement.setInt(10, id);
            
            result = pStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error updating contact with ID: " + id + ". Return code from UPDATE: " + result);
        } 
        try {
            pStatement.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error closing database connection");
        }
        
	}

}
