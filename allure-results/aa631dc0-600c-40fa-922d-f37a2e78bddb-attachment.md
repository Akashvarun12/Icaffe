# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: icaffeLoginTestCase.spec.ts >> iCaffe Login Test Suite >> Verify login with blank username
- Location: tests\icaffeLoginTestCase.spec.ts:42:9

# Error details

```
Error: page.goto: Target page, context or browser has been closed
Call log:
  - navigating to "https://idp.icaffe.co.in/demouat/", waiting until "load"

```

# Test source

```ts
  1  | import { test, expect } from '@playwright/test';
  2  | import { LoginPage } from '../pages/icaffeLoginPage';
  3  | import { testConfig } from '../utils/icaffe';
  4  | 
  5  | 
  6  | 
  7  | test.describe('iCaffe Login Test Suite', () => {
  8  |     let loginPage: LoginPage;
  9  | 
  10 |     
  11 |     test.beforeEach(async ({ page }) => {
> 12 |         await page.goto(testConfig.baseURL);
     |                    ^ Error: page.goto: Target page, context or browser has been closed
  13 |         
  14 |         //  Login Page class object
  15 |         loginPage = new LoginPage(page);
  16 |     });
  17 | 
  18 | 
  19 |     //  Valid Login
  20 |     test('Verify login with valid credentials', async ({ page }) => {
  21 | 
  22 |         await loginPage.login(
  23 |             testConfig.username,
  24 |             testConfig.password
  25 |         );
  26 |         await expect(page).not.toHaveURL(testConfig.baseURL);
  27 |     });
  28 | 
  29 | 
  30 |     // TC002 - Invalid Password
  31 |     test('Verify login with invalid password', async () => {
  32 | 
  33 |         await loginPage.login(
  34 |             testConfig.username,
  35 |             'WrongPassword123'
  36 |         );
  37 | 
  38 |     });
  39 | 
  40 | 
  41 |     // Blank Username
  42 |     test('Verify login with blank username', async () => {
  43 | 
  44 |         await loginPage.enterUsername('');
  45 |         await loginPage.enterPassword( testConfig.password);
  46 |         await loginPage.clickLogin();
  47 |     });
  48 | 
  49 | 
  50 |     //  Blank Password
  51 |     test('Verify login with blank password', async () => {
  52 | 
  53 |         await loginPage.enterUsername(
  54 |             testConfig.username
  55 |         );
  56 |         await loginPage.enterPassword('');
  57 |         await loginPage.clickLogin();
  58 |     });
  59 | 
  60 | 
  61 |     // Blank Username and Password
  62 |     test('Verify login with blank username and password', async () => {
  63 | 
  64 |         await loginPage.enterUsername('');
  65 |         await loginPage.enterPassword('');
  66 |         await loginPage.clickLogin();
  67 |     });
  68 | 
  69 | });
  70 | 
```