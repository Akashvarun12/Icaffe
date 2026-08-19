import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/icaffeLoginPage';
import { BranchSelectionPage } from '../pages/icaffeBranchSelection';
import { testConfig } from '../utils/icaffe';


test.describe('iCaffe Branch Selection Test Suite', () => {
    let loginPage: LoginPage;
    let branchSelectionPage: BranchSelectionPage;


    test.beforeEach(async ({ page }) => {

        // Open Login Page
        await page.goto(testConfig.baseURL);
        // Create Login Page object
        loginPage = new LoginPage(page);
        // Login using valid credentials
        await loginPage.login(
            testConfig.username,
            testConfig.password
        );

        // Create Branch Selection Page object
        branchSelectionPage = new BranchSelectionPage(page);
    });


    test('Verify branch selection with valid details', async ({ page }) => {

        // Select Branch
        await branchSelectionPage.selectBranch(testConfig.branch);

        // Select Division
        await branchSelectionPage.SelectDevision(testConfig.division);

        // Select Financial Year
        await branchSelectionPage.selectFinancialYear(testConfig.financialYear);

        // Click OK
        await branchSelectionPage.clickOK();

    });

});