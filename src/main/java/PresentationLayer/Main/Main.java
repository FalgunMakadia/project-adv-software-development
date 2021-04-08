package PresentationLayer.Main;

import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.ILoginPage;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public class Main {
    public static void main(String[] args) {
        IPresentationFactory presentationFactory = new PresentationFactory();
        ICommonPagesFactory commonPagesFactory = presentationFactory.createCommonPagesFactory();

        ILoginPage loginPage = commonPagesFactory.createLogin();
        loginPage.takeLoginCredential();

    }
}