package BusinessLogicLayer.User;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User {

    private Map<String, String> listOfMandatoryFields = new HashMap<>();

    public Customer() {
        super();
    }

    @Override
    public Map<String, String> getListOfMandatoryFields() {
        listOfMandatoryFields.put("First Name", getFirstName());
        listOfMandatoryFields.put("Last Name", getLastName());
        listOfMandatoryFields.put("Address Line 1", getAddressLine1());
        listOfMandatoryFields.put("City", getCity());
        listOfMandatoryFields.put("Province", getProvince());
        listOfMandatoryFields.put("Postal Code", getPostalCode());
        listOfMandatoryFields.put("Email ", getEmailAddress());
        listOfMandatoryFields.put("Contact", getContact());
        return listOfMandatoryFields;
    }

    @Override
    public void setListOfMandatoryFields(Map<String, String> listOfMandatoryFields) {
        setFirstName(listOfMandatoryFields.get("First Name"));
        setLastName(listOfMandatoryFields.get("Last Name"));
        setAddressLine1(listOfMandatoryFields.get("Address Line 1"));
        setCity(listOfMandatoryFields.get("City"));
        setProvince(listOfMandatoryFields.get("Province"));
        setPostalCode(listOfMandatoryFields.get("Postal Code"));
        setEmailAddress(listOfMandatoryFields.get("Email"));
        setContact(listOfMandatoryFields.get("Contact"));
    }
}


