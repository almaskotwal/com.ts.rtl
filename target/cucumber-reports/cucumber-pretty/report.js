$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/ViewQuarterlyReport.feature");
formatter.feature({
  "line": 1,
  "name": "View Quarterly Report",
  "description": "",
  "id": "view-quarterly-report",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7118676700,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Investor views quarterly financial reports",
  "description": "",
  "id": "view-quarterly-report;investor-views-quarterly-financial-reports",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@downloadQ1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user is on AIMCO home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user clicks on Investor Info button",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user clicks on Filings and Financials dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user clicks on quarterly earning reports",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks on the Twenty Twenty earning releases",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user clicks on first quarter earning report",
  "keyword": "Then "
});
formatter.match({
  "location": "InvesterInfoStepDefinition.user_is_on_AIMCO_home_page()"
});
formatter.result({
  "duration": 5101067100,
  "status": "passed"
});
formatter.match({
  "location": "InvesterInfoStepDefinition.user_clicks_on_Investor_Info_button()"
});
formatter.result({
  "duration": 185311400,
  "status": "passed"
});
formatter.match({
  "location": "InvesterInfoStepDefinition.user_clicks_on_Filings_and_Financials_dropdown()"
});
formatter.result({
  "duration": 3270825400,
  "status": "passed"
});
formatter.match({
  "location": "InvesterInfoStepDefinition.user_clicks_on_quarterly_earning_reports()"
});
formatter.result({
  "duration": 3285065499,
  "status": "passed"
});
formatter.match({
  "location": "InvesterInfoStepDefinition.user_clicks_on_the_earning_releases()"
});
formatter.result({
  "duration": 63500,
  "status": "passed"
});
formatter.match({
  "location": "InvesterInfoStepDefinition.user_clicks_on_first_quarter_earning_report()"
});
formatter.result({
  "duration": 241152300,
  "error_message": "java.util.NoSuchElementException\r\n\tat java.util.LinkedHashMap$LinkedHashIterator.nextNode(LinkedHashMap.java:721)\r\n\tat java.util.LinkedHashMap$LinkedKeyIterator.next(LinkedHashMap.java:742)\r\n\tat stepDefinitions.InvesterInfoStepDefinition.user_clicks_on_first_quarter_earning_report(InvesterInfoStepDefinition.java:62)\r\n\tat ✽.Then user clicks on first quarter earning report(Features/ViewQuarterlyReport.feature:10)\r\n",
  "status": "failed"
});
});