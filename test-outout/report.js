$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Wishlist.feature");
formatter.feature({
  "line": 2,
  "name": "Login Test",
  "description": "",
  "id": "login-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@sampleTest"
    }
  ]
});
formatter.before({
  "duration": 8691335205,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login to the application with valid credentials",
  "description": "",
  "id": "login-test;login-to-the-application-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I add four different products to my wishlist",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I view my wishlist table",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I find total four selected items in my Wishlist",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I search for lowest price product",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I am able to add the lowest price item to my cart",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I am able to verify the item in my cart",
  "keyword": "Then "
});
formatter.match({
  "location": "baseStepDefinition.iAddFourDifferentProductsToMyWishlist()"
});
formatter.result({
  "duration": 12414150901,
  "status": "passed"
});
formatter.match({
  "location": "baseStepDefinition.iViewMyWishlistTable()"
});
formatter.result({
  "duration": 493146671,
  "status": "passed"
});
formatter.match({
  "location": "baseStepDefinition.iFindTotalFourSelectedItemsInMyWishlist()"
});
formatter.result({
  "duration": 12761697,
  "status": "passed"
});
formatter.match({
  "location": "baseStepDefinition.iSearchForLowestPriceProduct()"
});
formatter.result({
  "duration": 86176703,
  "status": "passed"
});
formatter.match({
  "location": "baseStepDefinition.iAmAbleToAddTheLowestPriceItemToMyCart()"
});
formatter.result({
  "duration": 3048168257,
  "status": "passed"
});
formatter.match({
  "location": "baseStepDefinition.iAmAbleToVerifyTheItemInMyCart()"
});
formatter.result({
  "duration": 2370868488,
  "status": "passed"
});
formatter.after({
  "duration": 121814298,
  "status": "passed"
});
});