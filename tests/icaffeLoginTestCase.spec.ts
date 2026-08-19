import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/icaffeLoginPage';
import { testConfig } from '../utils/icaffe';



test.describe('iCaffe Login Test Suite', () => {
    let loginPage: LoginPage;

    
    test.beforeEach(async ({ page }) => {
        await page.goto(testConfig.baseURL);
        
        //  Login Page class object
        loginPage = new LoginPage(page);
    });


    //  Valid Login
    test('Verify login with valid credentials', async ({ page }) => {

        await loginPage.login(
            testConfig.username,
            testConfig.password
        );
        await expect(page).not.toHaveURL(testConfig.baseURL);
    });


    // TC002 - Invalid Password
    test('Verify login with invalid password', async () => {

        await loginPage.login(
            testConfig.username,
            'WrongPassword123'
        );

    });


    // Blank Username
    test('Verify login with blank username', async () => {

        await loginPage.enterUsername('');
        await loginPage.enterPassword( testConfig.password);
        await loginPage.clickLogin();
    });


    //  Blank Password
    test('Verify login with blank password', async () => {

        await loginPage.enterUsername(
            testConfig.username
        );
        await loginPage.enterPassword('');
        await loginPage.clickLogin();
    });


    // Blank Username and Password
    test('Verify login with blank username and password', async () => {

        await loginPage.enterUsername('');
        await loginPage.enterPassword('');
        await loginPage.clickLogin();
    });

});
