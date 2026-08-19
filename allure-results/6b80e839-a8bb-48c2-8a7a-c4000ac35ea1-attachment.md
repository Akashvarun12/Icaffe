# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: icaffeBranchSelectTestCase.spec.ts >> iCaffe Branch Selection Test Suite >> Verify branch selection with valid details
- Location: tests\icaffeBranchSelectTestCase.spec.ts:29:9

# Error details

```
Test timeout of 30000ms exceeded.
```

```
Error: locator.click: Test timeout of 30000ms exceeded.
Call log:
  - waiting for getByText('//ul[contains(@class,\'ui-autocomplete\')]//div[text()=\'ahmedabad\']')

```

# Page snapshot

```yaml
- generic [active] [ref=f1e1]:
  - generic [ref=f1e2]:
    - generic [ref=f1e3]: Welcome to iCaffe -
    - text: DEMO LTD
  - generic [ref=f1e4]:
    - generic [ref=f1e7]:
      - generic [ref=f1e9]:
        - generic [ref=f1e10]: Select Branch
        - textbox "Select Branch" [ref=f1e13]: ahmedabad
      - generic [ref=f1e15]:
        - generic [ref=f1e16]:
          - radio [ref=f1e17]
          - generic [ref=f1e18]: Export Air
        - generic [ref=f1e19]:
          - radio [ref=f1e20]
          - generic [ref=f1e21]: Import Air
      - generic [ref=f1e23]:
        - generic [ref=f1e24]:
          - radio [checked] [ref=f1e25]
          - generic [ref=f1e26]: Export Sea
        - generic [ref=f1e27]:
          - radio [ref=f1e28]
          - generic [ref=f1e29]: Import Sea
      - generic [ref=f1e31]:
        - generic [ref=f1e32]: Select Financial Year
        - textbox "Welcome to iCaffe - Select Branch Select Financial Year" [ref=f1e35]:
          - /placeholder: Select Financial Year
          - text: 2026-27
        - button " Ok" [ref=f1e38] [cursor=pointer]:
          - generic [ref=f1e39]: 
          - text: Ok
      - link "Follow the Hans Infomatic Pvt. Ltd. channel on WhatsApp" [ref=f1e42] [cursor=pointer]:
        - /url: https://whatsapp.com/channel/0029VaArfZdKwqSV27wcKH0x
    - generic [ref=f1e45]: NOTIFICATION
  - paragraph [ref=f1e54]:
    - text: © 2018 iCaffe | All Rights Reserved | Design and Developed by
    - link "Hans Infomatic Pvt. Ltd." [ref=f1e55] [cursor=pointer]:
      - /url: http://www.hansinfomatic.com/
  - status [ref=f1e56]
  - status [ref=f1e57]
```

# Test source

```ts
  1  | import { Page, Locator } from '@playwright/test';
  2  | 
  3  | export class BranchSelectionPage {
  4  | 
  5  |     private readonly page: Page;
  6  |     private readonly branchDropdown: Locator;
  7  |     private readonly financialYearDropdown: Locator;
  8  |     private readonly okButton: Locator;
  9  | 
  10 | 
  11 |     constructor(page: Page) {
  12 |         this.page = page;
  13 |         this.branchDropdown = page.locator("//input[@id='txtBranch']");
  14 |         this.financialYearDropdown = page.locator("//input[@id='txtFinancialYear']");
  15 |         this.okButton = page.locator("//button[@id='ChooseButton']");
  16 |     }
  17 | 
  18 |     
  19 |     async selectBranch(branch: string) {
> 20 |         await this.page.getByText("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + branch + "']").click();
     |                                                                                                             ^ Error: locator.click: Test timeout of 30000ms exceeded.
  21 |     }
  22 | 
  23 |     
  24 |     async  SelectDevision(division: string) {
  25 | 		await this.page.getByText("//input[contains(@id,'" + division + "')]").click();
  26 | 	}
  27 | 
  28 | 
  29 |     async selectFinancialYear(financialYear: string) {
  30 |         await this.page.getByText("//ul[contains(@class,'ui-autocomplete')]//div[text()='" + financialYear + "']").click();
  31 |     }
  32 | 
  33 | 
  34 |     async clickOK() {
  35 |         await this.okButton.click();
  36 |     }
  37 | 
  38 |     async selectBranchDetails(branch: string, division: string, financialYear: string){
  39 |         await this.selectBranch(branch);
  40 |         await this.selectFinancialYear(financialYear);
  41 |         await this.clickOK();
  42 |     }
  43 | 
  44 | }
```