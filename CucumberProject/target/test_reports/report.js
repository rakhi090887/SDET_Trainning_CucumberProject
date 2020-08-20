$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CRMActivity3_1.feature");
formatter.feature({
  "line": 3,
  "name": "Counting Dashlets",
  "description": "",
  "id": "counting-dashlets",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CRMFeature"
    },
    {
      "line": 1,
      "name": "@CRMActivity3_1"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Counting Dashlets",
  "description": "",
  "id": "counting-dashlets;counting-dashlets",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User is on Alchemy CRM Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User logs using \"admin\" and \"pa$$w0rd\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Count the dashlet and print the title.",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "CountingDashlet.userIsOnalchemyCRMPage()"
});
formatter.result({
  "duration": 20980628500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 17
    },
    {
      "val": "pa$$w0rd",
      "offset": 29
    }
  ],
  "location": "CountingDashlet.loginPage(String,String)"
});
formatter.result({
  "duration": 5456254300,
  "status": "passed"
});
formatter.match({
  "location": "CountingDashlet.countDashlets()"
});
formatter.result({
  "duration": 2336352500,
  "status": "passed"
});
formatter.match({
  "location": "CountingDashlet.closeBrowser()"
});
formatter.result({
  "duration": 2000819300,
  "status": "passed"
});
formatter.uri("CRMActivity3_2.feature");
formatter.feature({
  "line": 3,
  "name": "Create leads using parameterization",
  "description": "",
  "id": "create-leads-using-parameterization",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CRMFeature"
    },
    {
      "line": 1,
      "name": "@CRMActivity3_2"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Create leads using parameterization",
  "description": "",
  "id": "create-leads-using-parameterization;create-leads-using-parameterization",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User is loggedin on AlchemyCRM WEbsite using \"admin\" and \"pa$$w0rd\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Navigate to leads page and createLeads",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "fill the form using Firstname \"Software\" and lastName \"TestABC\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Navigate to view leads to verify leads \"SoftwareTestABC\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "close the browser for CRMActivity3_2",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 46
    },
    {
      "val": "pa$$w0rd",
      "offset": 58
    }
  ],
  "location": "CreateLeads.userLoggedIn(String,String)"
});
formatter.result({
  "duration": 19071498600,
  "status": "passed"
});
formatter.match({
  "location": "CreateLeads.navigateToLeads()"
});
formatter.result({
  "duration": 2991886600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Software",
      "offset": 31
    },
    {
      "val": "TestABC",
      "offset": 55
    }
  ],
  "location": "CreateLeads.createLeads(String,String)"
});
formatter.result({
  "duration": 2493112600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SoftwareTestABC",
      "offset": 40
    }
  ],
  "location": "CreateLeads.VerifyLeads(String)"
});
formatter.result({
  "duration": 2040521800,
  "status": "passed"
});
formatter.match({
  "location": "CreateLeads.closeTheBrowser()"
});
formatter.result({
  "duration": 3042754700,
  "status": "passed"
});
formatter.uri("CRMActivity3_3.feature");
formatter.feature({
  "line": 4,
  "name": "Schedule a meeting and invite members",
  "description": "",
  "id": "schedule-a-meeting-and-invite-members",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@CRMFeature"
    },
    {
      "line": 2,
      "name": "@CRMActivity3_3"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Schedule a meeting and invite members",
  "description": "",
  "id": "schedule-a-meeting-and-invite-members;schedule-a-meeting-and-invite-members",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "User is logged in on alchemy CRM page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Navigate to schedule meeting and search for page",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "add member \"\u003cfirstName\u003e\" and \"\u003clastName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "verify the meeting created \"Testting\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "close the browser for CRMAc3_3",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "schedule-a-meeting-and-invite-members;schedule-a-meeting-and-invite-members;",
  "rows": [
    {
      "cells": [
        "firstName",
        "lastName"
      ],
      "line": 14,
      "id": "schedule-a-meeting-and-invite-members;schedule-a-meeting-and-invite-members;;1"
    },
    {
      "cells": [
        "test",
        "test1"
      ],
      "line": 15,
      "id": "schedule-a-meeting-and-invite-members;schedule-a-meeting-and-invite-members;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 15,
  "name": "Schedule a meeting and invite members",
  "description": "",
  "id": "schedule-a-meeting-and-invite-members;schedule-a-meeting-and-invite-members;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@CRMActivity3_3"
    },
    {
      "line": 2,
      "name": "@CRMFeature"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User is logged in on alchemy CRM page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Navigate to schedule meeting and search for page",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "add member \"test\" and \"test1\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "verify the meeting created \"Testting\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "close the browser for CRMAc3_3",
  "keyword": "Then "
});
formatter.match({
  "location": "ScheduleMeeting.userInLoginPage()"
});
formatter.result({
  "duration": 13667332600,
  "status": "passed"
});
formatter.match({
  "location": "ScheduleMeeting.navigateToMeeting()"
});
formatter.result({
  "duration": 6285040000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 12
    },
    {
      "val": "test1",
      "offset": 23
    }
  ],
  "location": "ScheduleMeeting.addMember(String,String)"
});
formatter.result({
  "duration": 2986067300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Testting",
      "offset": 28
    }
  ],
  "location": "ScheduleMeeting.verfifyMeetng(String)"
});
formatter.result({
  "duration": 2421834700,
  "status": "passed"
});
formatter.match({
  "location": "ScheduleMeeting.closeBrowser()"
});
formatter.result({
  "duration": 1966351900,
  "status": "passed"
});
formatter.uri("CRMActivity3_4.feature");
formatter.feature({
  "line": 3,
  "name": "Creating a Product.",
  "description": "",
  "id": "creating-a-product.",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CRMFeature"
    },
    {
      "line": 1,
      "name": "@CRMActivity3_4"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Creating a Product.",
  "description": "",
  "id": "creating-a-product.;creating-a-product.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on AlchemyCRM website page using username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Create product using information \"\u003cProductName\u003e\" and \"\u003cPrice\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Verify the product creation using \"\u003cProductName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "close the browser for CRMact3_4",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "creating-a-product.;creating-a-product.;",
  "rows": [
    {
      "cells": [
        "ProductName",
        "Price"
      ],
      "line": 11,
      "id": "creating-a-product.;creating-a-product.;;1"
    },
    {
      "cells": [
        "Test",
        "20"
      ],
      "line": 12,
      "id": "creating-a-product.;creating-a-product.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "Creating a Product.",
  "description": "",
  "id": "creating-a-product.;creating-a-product.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@CRMActivity3_4"
    },
    {
      "line": 1,
      "name": "@CRMFeature"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is on AlchemyCRM website page using username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Create product using information \"Test\" and \"20\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Verify the product creation using \"Test\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "close the browser for CRMact3_4",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateProduct.userInLoginPage()"
});
formatter.result({
  "duration": 13958084400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test",
      "offset": 34
    },
    {
      "val": "20",
      "offset": 45
    }
  ],
  "location": "CreateProduct.createProduct(String,String)"
});
formatter.result({
  "duration": 6016642300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test",
      "offset": 35
    }
  ],
  "location": "CreateProduct.verifyProduct(String)"
});
formatter.result({
  "duration": 2352593900,
  "status": "passed"
});
formatter.match({
  "location": "CreateProduct.closeBrowser()"
});
formatter.result({
  "duration": 3152626900,
  "status": "passed"
});
});