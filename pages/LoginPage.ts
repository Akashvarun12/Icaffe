import { expect, Locator, Page } from '@playwright/test';

export class LoginPage {
  readonly page: Page;
  readonly username: Locator;
  readonly password: Locator;
  readonly signIn: Locator;

  constructor(page: Page) {
    this.page = page;
    this.username = page.locator('#UserName');
    this.password = page.locator('#Password');
    this.signIn = page.locator('#LoginButton');
  }

  async open(): Promise<void> {
    await this.page.goto(process.env.LOGIN_URL ?? '/');
  }

  async login(username: string, password: string): Promise<void> {
    await this.username.fill(username);
    await this.password.fill(password);
    await this.page.pause();
    await this.signIn.click();
  }

  async expectTitle(expectedTitle: string): Promise<void> {
    await expect(this.page).toHaveTitle(expectedTitle);
  }
}
