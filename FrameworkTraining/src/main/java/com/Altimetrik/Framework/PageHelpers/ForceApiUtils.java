package com.Altimetrik.Framework.PageHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.testng.Assert;

import automation.force.api.ForceApi;
import automation.force.api.json.QueryResponse;
import automation.force.api.json.SuccessResponse;
import automation.force.api.sObject.Account;
import automation.force.api.sObject.Attachment;
import automation.force.api.sObject.Case;
import automation.force.api.sObject.Contact;
import automation.force.api.sObject.Lead;
import automation.force.api.sObject.Opportunity;
import automation.force.api.sObject.SocialPersona;
import automation.force.api.sObject.User;

public class ForceApiUtils {

	/* ---------------------- G E T ---------------------- */

	/**
	 * <h1>getUserId</h1>
	 * This function will return an ID related to a username
	 * 
	 * @param username
	 * 			username to get id from
	 * @return ID related to @username
	 * @author allado
	 */
	public static Object getUserId(String username) {

		Object user = new Object();

		try {

			ForceApi forceApi = ForceApi.getInstance();
			String query = "SELECT Id, Email, Name " 
					+ "FROM User " 
					+ "WHERE Username = '" + username  
					+ "' ORDER BY LastModifiedDate DESC";

			QueryResponse<User> queryResponse = forceApi.query(query, User.class);

			if (queryResponse != null) {
				List<User> records = queryResponse.getRecords();
				if (records != null && !records.isEmpty()) {
					user = records.get(0).getId();
				}
			}

		} catch (Exception e) {

			System.err.println(e);

		}

		return user;

	}

	public static String getLastCaseNumber() {
		String caseNumber = "";
		try {
			ForceApi forceApi = ForceApi.getInstance();

			String query = "SELECT CaseNumber FROM Case ORDER BY LastModifiedDate DESC LIMIT 1"; 
			QueryResponse<Case> queryResponse = forceApi.query(query, Case.class);

			if (queryResponse != null) {
				List<Case> records = queryResponse.getRecords();
				if (records != null && !records.isEmpty()) {
					caseNumber = records.get(0).getCaseNumber();
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return caseNumber;
	}

	public static Object getLastContactId() {
		try {
			ForceApi forceApi = ForceApi.getInstance();
			String query = "SELECT id, FirstName, LastName, Phone FROM Contact ORDER BY LastCreatedDate DESC"; 
			QueryResponse<Contact> queryResponse = forceApi.query(query, Contact.class);
			Object record = new Object();

			if (queryResponse != null) {
				List<Contact> records = queryResponse.getRecords();
				if (records != null && !records.isEmpty()) {
					record = records.get(0).getId();
				}
			}
			return record;
		} catch(Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public static Account getAccountById(String id) {

		try {

			ForceApi forceApi = ForceApi.getInstance();

			String query = "SELECT name, id, phone "  
					+ "FROM Account " 
					+ "WHERE id = '" + id 
					+ "' ORDER BY LastModifiedDate DESC";
			QueryResponse<Account> queryResponse = forceApi.query(query, Account.class);

			Account account = new Account();
			
			if (queryResponse != null) {
				account = queryResponse.getRecords().get(0);
			}
			
			return account;
			
		} catch (Exception e) {
			
			Assert.fail();
		
		}
		
		return null;
	}

	/* ---------------------- C R E A T E ---------------------- */

	/**
	 * <h1>createAccount</h1>
	 * This function will create an Account from the Force Api
	 * 
	 * @param clientNumber
	 * 			This value will be set in Phone field
	 * @author allado
	 */
	public static String createAccount(String clientNumber) {
		String id = null;
		try {
			ForceApi forceApi = ForceApi.getInstance();
			Account acc = new Account();
			acc.setName(UUID.randomUUID().toString());
			acc.setPhone(clientNumber);
			SuccessResponse response = forceApi.create("Account", acc);
			if (response != null && response.isSuccess())
			{
				id = response.getId();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return id;
	}

	/**
	 * <h1>createContact</h1>
	 * This function will create a Contact with phone = clientNumber
	 * 
	 * @param clientNumber
	 * 			This value will be set in Phone field
	 * @param contactName
	 * 			This value will be set on Last Name field
	 * @author allado
	 */
	public static String createContact(String clientNumber, String lastName) {
		String id = null;

		try {
			ForceApi forceApi = ForceApi.getInstance();

			Contact contact = new Contact();
			contact.setFirstName("Test");
			contact.setLastName(lastName);
			contact.setPhone(clientNumber);
			contact.setLeadSource("Other");

			SuccessResponse response = forceApi.create("Contact", contact);
			if (response != null && response.isSuccess())
			{
				id = response.getId();
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return id;
	}

	/**
	 * <h1>createLead</h1>
	 * This function will create a Lead from the Force Api
	 * 
	 * @param clientNumber
	 * 			This value will be set on Phone field.
	 * @author allado
	 */
	public static String createLead(String clientNumber, String leadName) {
		String id = null;
		try {
			ForceApi forceApi = ForceApi.getInstance();
			Lead lead = new Lead();
			lead.setPhone(clientNumber);
			lead.setLastName(leadName);
			lead.setCompany(UUID.randomUUID().toString());
			lead.setStatus("Open - Not Contacted");
			SuccessResponse response = forceApi.create("Lead", lead);
			if (response != null && response.isSuccess())
			{
				id = response.getId();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return id;
	}

	/**
	 * <h1>createCase</h1>
	 * This functions creates a case associated to a Contact
	 * @param clientNumber
	 * 		clientNumber related to Case
	 * @param conName
	 * 		name of case
	 * @param subject
	 * 		subject of case
	 * @param parentId
	 * 		id of parent Contact
	 * @return id of case
	 */
	public static String createCase(String clientNumber, String name, String subject, String parentId) {
		String id = null;
		try {
			ForceApi forceApi = ForceApi.getInstance();

			Case ca = new Case();
			ca.setOrigin("Phone");
			ca.setStatus("New");
			ca.setSubject(subject);
			Object record = parentId;
			ca.setContactId(record);
			SuccessResponse response = forceApi.create("Case", ca);
			if (response != null && response.isSuccess())
			{
				id = response.getId();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return id;
	}

	public static String createOpportunity(String clientNumber, String oppName) {
		Object acc = createAccount(clientNumber);
		String id = null;
		try {
			ForceApi forceApi = ForceApi.getInstance();
			Opportunity opp = new Opportunity();
			opp.setName(oppName);
			opp.setStageName("Prospecting");
			opp.setCloseDate("07/30/2018");            //opp.setCloseDate(Util.todaysDate());
			opp.setAccount(acc);

			SuccessResponse response = forceApi.create("Opportunity", opp);
			if (response != null && response.isSuccess())
			{
				id = response.getId();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return id;
	}

	/**
	 * <h1>createSocialPersona</h1>
	 * This function creates a Social Persona record
	 * @param name
	 * @param clientNumber
	 * @param provider
	 * @author epadron
	 */
	public static String createSocialPersona(String name, String clientNumber, String parentId) {   //ProviderType provider
		String id = null;

		try {
			ForceApi forceApi = ForceApi.getInstance();

			SocialPersona sp = new SocialPersona();
			sp.setParentId(parentId);
			sp.setProvider("Facebook");        //sp.setProvider(provider.getName());
			sp.setSourceApp("LiveMessage");
			sp.setRealName(name);
			sp.setProfileType("Person");
			sp.setExternalId(clientNumber);
			sp.setName(name);

			SuccessResponse response = forceApi.create("SocialPersona", sp);
			if (response != null && response.isSuccess())
			{
				id = response.getId();
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return id;
	}

	/**
	 * <h1>createUser</h1>
	 * This function creates a User
	 * @author epadron
	 * @return created user's id
	 */
	public static String createUser() {
		String id = null;
		try {

			ForceApi forceApi = ForceApi.getInstance();

			String profileQuery = "SELECT id, Name FROM Profile WHERE Name = 'Standard User'"; 
			QueryResponse<User> profileQueryResponse = forceApi.query(profileQuery, User.class);
			Object profileId = new Object();

			if (profileQueryResponse != null) {
				List<User> records = profileQueryResponse.getRecords();
				if (records != null && !records.isEmpty()) {
					profileId = records.get(0).getId();
				}
			}

			User user = new User();
			user.setFirstName("UserExample");
			user.setLastName("ForTest");
			user.setAlias("fortest");
			user.setEmail("epadron@altimetrik.com");
			user.setUsername("eduramdomfortest@altimetrik.com");
			user.setCommunityNickname("eduramdomfortest@altimetrik.com");
			user.setProfileId(profileId);
			user.setEmailEncodingKey("ISO-8859-1");
			user.setTimeZoneSidKey("America/Los_Angeles");
			user.setLocaleSidKey("en_US");
			user.setLanguageLocaleKey("en_US");
			user.setIsActive(true);

			SuccessResponse response = forceApi.create("User", user);
			if (response != null && response.isSuccess())
			{
				id = response.getId();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return id;
	}

	/**
	 * <h1>createImageAttachment</h1>
	 * This function creates an Image attachment
	 * @param parentId
	 * 			This image attachment will be related to parentId
	 * @author allado
	 */
	public static String createImageAttachment(String parentId) {
		String id = null;
		String str = UUID.randomUUID().toString();
		String body = "/9j/4AAQSkZJRgABAQEAYABgAAD//gA+Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZyBJSkcgSlBFRyB2ODApLCBkZWZhdWx0IHF1YWxpdHkK/9sAQwAIBgYHBgUIBwcHCQkICgwUDQwLCwwZEhMPFB0aHx4dGhwcICQuJyAiLCMcHCg3KSwwMTQ0NB8nOT04MjwuMzQy/9sAQwEJCQkMCwwYDQ0YMiEcITIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIy/8AAEQgAeAB4AwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/aAAwDAQACEQMRAD8A+f6KKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiitrw7Oqy3UH2eBmks7omV03MALeQgLngcgHIGeOuMggGLRWvoVxqAuRDaXf2aFT5s8pUFEQYBL8fMvbacgkgAZNXLzUBZWMNzpAa1S6u55CABnaCNkR9VAOSDwd3OaAOcorbv7K2Pi65sjFJFFJcMiRwJuMZY8KF6nBIGOpxjrVfWtLTR5o7RpRPcbd8ksTBoWB+6EP8WMHLdM5GPlyQDMoraE6y+ELmNbeCPyry3G9U+dyUnySx57DjoMdM5JksLy5/si6e9lzpywtBFAyjEkpHy7R/eUkOWHOBgn5gCAYNFdb5rf242joM6cLMoISBt/1G7zcf3t3z7uvbpxXJUAFFFFABRRRQAUUUUAFS29zLayGSF9rFHjJwD8rKVYc+oJFRUUAaNnrd7Y2L2UP2Y27yeayS2kUuWxgEl1J4HQdsnHU0lvrN5bK6J9nZGkMoSS2jdUc9SqlSF6DpxwPQVn0UATi8uRcyXPnyefLu3ybvmbdkNz75OfqaY08rwRwNIxijLMik8KTjOPrgVHRQBKtzKtrJah8QyOsjLgcsoYA569Hb86vTa/f3FlHaS/ZGhiiEMebOHcq+zbcg9TnOSSTnJzWZRQBo/25ffZfs++P/VeT5vkp5vl4xt343Yxx16cdOKzqKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA//2Q==";		
		try {
			ForceApi forceApi = ForceApi.getInstance();
			Attachment att = new Attachment();
			att.setName(str);
			att.setBody(body);
			att.setParentId(parentId);
			att.setDescription(str);

			SuccessResponse response = forceApi.create("Attachment", att);
			if (response != null && response.isSuccess()) {
				id = response.getId();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return id;
	} 

	/* ---------------------- D E L E T E ---------------------- */

	/**
	 * <h1>deleteRecordById</id>
	 * This function deletes a record
	 * @param recordType
	 * 		Record Type of the record to delete
	 * @param id
	 * 		Id of the record to delete
	 * @author allado
	 */
	public static void deleteRecord(String recordType, String id) {
		try {
			ForceApi.getInstance().delete(recordType, id);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
