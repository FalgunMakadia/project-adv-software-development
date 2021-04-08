package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.IProfileFormFactory;
import BusinessLogicLayer.ProfileForm.CommonProfileForm.ProfileFormFactory;
import BusinessLogicLayer.CommonAction.AbstractAction;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class OpenNewAccountAction extends AbstractAction {
    private static final String ACTION_TITLE = "Open New Account";

    private Map<Integer, IFormCommand> formActionCommandMap;
    private Map<Integer, IFormCommand> openNewAccountFormFieldMap;
    private AbstractProfile customer;
    private IProfileFormFactory profileFormFactory;

    @Override
    public String getActionTitle() {
        return ACTION_TITLE;
    }

    public OpenNewAccountAction() {
        super();
        profileFormFactory = new ProfileFormFactory();
        customer = userFactory.createCustomerProfile();

        getOpenNewAccountFormFieldMap();
        formActionCommandMap = new LinkedHashMap<>();
        formActionCommandMap.put(1, profileFormFactory.createEditProfileFormActionCommand(customer, openNewAccountFormFieldMap));
        formActionCommandMap.put(2, profileFormFactory.createSaveNewAccountProfileFormActionCommand(customer));
        formActionCommandMap.put(3, profileFormFactory.createBackToMainMenuProfileFormActionCommand());
    }

    public OpenNewAccountAction(Map<Integer, IFormCommand> openNewAccountFormFieldMap, Map<Integer, IFormCommand> formActionCommandMap) {
        this.openNewAccountFormFieldMap = openNewAccountFormFieldMap;
        this.formActionCommandMap = formActionCommandMap;
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(ACTION_TITLE);
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        userInterface.displayMessage("Please enter the details of following fields:");
        userInterface.displayMessage("Note: (*) are mandatory fields.");
        userInterface.insertEmptyLine();

        Iterator<Map.Entry<Integer, IFormCommand>> iterator = openNewAccountFormFieldMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, IFormCommand> formQuestionEntry = iterator.next();
            IFormCommand formCommand = formQuestionEntry.getValue();
            formCommand.execute();
        }

        if (0 < formActionCommandMap.size()) {
            while (loggedInUserContext.checkCurrentPageStatus(ACTION_TITLE)) {
                int key = 1;
                for (int i = 0; i < formActionCommandMap.size(); i++) {
                    IFormCommand formCommand = formActionCommandMap.get(key);
                    userInterface.displayMessage(key + ". " + formCommand.getCommandLabel());
                    key = key + 1;
                }
                String action = userInterface.getMandatoryIntegerUserInput("Enter any Number between 1-" + formActionCommandMap.size() + " to perform appropriate action:");

                IFormCommand formCommand = formActionCommandMap.get(Integer.parseInt(action));
                formCommand.execute();
            }
        }
    }

    private void getOpenNewAccountFormFieldMap() {
        openNewAccountFormFieldMap = new LinkedHashMap<>();
        openNewAccountFormFieldMap.put(1, profileFormFactory.createFirstNameFieldCommand(customer));
        openNewAccountFormFieldMap.put(2, profileFormFactory.createMiddleNameFieldCommand(customer));
        openNewAccountFormFieldMap.put(3, profileFormFactory.createLastNameFieldCommand(customer));
        openNewAccountFormFieldMap.put(4, profileFormFactory.createAddressLine1FieldCommand(customer));
        openNewAccountFormFieldMap.put(5, profileFormFactory.createAddressLine2FieldCommand(customer));
        openNewAccountFormFieldMap.put(6, profileFormFactory.createCityFieldCommand(customer));
        openNewAccountFormFieldMap.put(7, profileFormFactory.createPostalCodeFieldCommand(customer));
        openNewAccountFormFieldMap.put(8, profileFormFactory.createProvinceFieldCommand(customer));
        openNewAccountFormFieldMap.put(9, profileFormFactory.createContactFieldCommand(customer));
        openNewAccountFormFieldMap.put(10, profileFormFactory.createEmailFieldCommand(customer));
        openNewAccountFormFieldMap.put(11, profileFormFactory.createPassPortNumberFieldCommand(customer));
        openNewAccountFormFieldMap.put(12, profileFormFactory.createSsnNumberFieldCommand(customer));
        openNewAccountFormFieldMap.put(13, profileFormFactory.createDateOfBirthFieldCommand(customer));
    }

}
