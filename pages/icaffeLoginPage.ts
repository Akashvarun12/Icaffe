import { Page, Locator } from '@playwright/test';

export class LoginPage {

  private readonly page: Page;
  private readonly usernameTextbox: Locator;
  private readonly passwordTextbox: Locator;
  private readonly loginButton: Locator;
  


  // Constructor
  constructor(page: Page) {
    this.page = page;
    this.usernameTextbox = page.locator("//input[@id='UserName']");
    this.passwordTextbox = page.locator("//input[@id='Password']");
    this.loginButton = page.locator("//input[@id='LoginButton']");
  }

  // Methods
  async enterUsername(username: string) {
    await this.usernameTextbox.fill(username);
  }

  async enterPassword(password: string) {
    await this.passwordTextbox.fill(password);
  }

  async clickLogin() {
    await this.loginButton.click();
  }


   // login
    async login(username: string, password: string) {
        await this.enterUsername(username);
        await this.enterPassword(password);
        await this.page.waitForTimeout(10000);
        await this.clickLogin();
        await this.page.waitForTimeout(5000);
    }


}