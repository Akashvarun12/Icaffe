import { test } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';

const username = process.env.LOGIN_USERNAME;
const password = process.env.LOGIN_PASSWORD;
const expectedTitle = process.env.LOGIN_EXPECTED_TITLE ?? 'Login Branch Division';

test('valid credentials open the authenticated login page', async ({ page }) => {
  test.skip(!username || !password, 'LOGIN_USERNAME and LOGIN_PASSWORD must be provided');

  const loginPage = new LoginPage(page);
  await loginPage.open();
  await loginPage.login(username!, password!);
  await loginPage.expectTitle(expectedTitle);
});
