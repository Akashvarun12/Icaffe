import { Page, Locator } from '@playwright/test';

export class BranchSelectionPage {

    private readonly page: Page;
    private readonly branchDropdown: Locator;
    private readonly financialYearDropdown: Locator;
    private readonly okButton: Locator;


    constructor(page: Page) {
        this.page = page;
        this.branchDropdown = page.locator("//input[@id='txtBranch']");
        this.financialYearDropdown = page.locator("//input[@id='txtFinancialYear']");
        this.okButton = page.locator("//button[@id='ChooseButton']");
    }

    
    async selectBranch(branch: string) {
        await this.page.getByText("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + branch + "']").click();
    }

    
    async  SelectDevision(division: string) {
		await this.page.getByText("//input[contains(@id,'" + division + "')]").click();
	}


    async selectFinancialYear(financialYear: string) {
        await this.page.getByText("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + financialYear + "']").click();
    }


    async clickOK() {
        await this.okButton.click();
    }

    async selectBranchDetails(branch: string, division: string, financialYear: string){
        await this.selectBranch(branch);
        await this.selectFinancialYear(financialYear);
        await this.clickOK();
    }

}