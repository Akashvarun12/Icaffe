import { defineConfig, devices } from '@playwright/test';

/**
 * Playwright Test Configuration
 *
 * Documentation:
 * https://playwright.dev/docs/test-configuration
 */

export default defineConfig({

  // --------------------------------------------------
  // Test Directory
  // --------------------------------------------------

  testDir: './tests',


  // --------------------------------------------------
  // Test Execution
  // --------------------------------------------------

  // Run test files in parallel
  fullyParallel: false,

  // Fail CI build if test.only is accidentally used
  forbidOnly: !!process.env.CI,

  // Retry failed tests only in CI
  retries: process.env.CI ? 2 : 0,

  // Use 1 worker in CI
  workers: 1 ,


  // --------------------------------------------------
  // Reports
  // --------------------------------------------------

  reporter: [
    // Playwright HTML Report
    ['html', {
      outputFolder: 'playwright-report',
      open: 'never',
    }],

    // Allure Report
    ['allure-playwright'],
  ],


  // --------------------------------------------------
  // Common Settings
  // --------------------------------------------------

  use: {

    // Run tests against Google Chrome
    channel: 'chrome',

    // Screenshot only when a test fails
    screenshot: 'only-on-failure',

    // Keep video only when a test fails
    video: 'retain-on-failure',

    // Capture trace when test is retried
    trace: 'on-first-retry',

    // Uncomment this when you want a common application URL
    // baseURL: 'https://your-application-url.com',
  },


  // --------------------------------------------------
  // Browser Project
  // --------------------------------------------------

  projects: [

    {
      name: 'Google Chrome',

      use: {
        ...devices['Desktop Chrome'],

        // Use installed Google Chrome
        channel: 'chrome',
      },
    },

  ],

});