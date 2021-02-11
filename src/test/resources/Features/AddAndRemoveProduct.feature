@AddRemoveProduct
Feature: Add product to and remove from Shopping Cart

Background:
Given User is on Retail page
When User clicks moves mouse to Desktops menue
Then User clicks on the iMac
And User click on Add To Cart button

@AddProduct
Scenario: Add a product to the Shopping Cart
Then Verify Success Message 'Success: You have added iMac to your shopping cart!'

@VerifyTotal
Scenario: Verify shopping cart total

Then User click on Shopping Cart Button
Then verfiy total is calculated correctly
And verfity coupon text says "Enter your coupon here"


@RemoveProduc
Scenario: Remove a product from the Shopping Cart
Then User click on Shopping Cart Button
And User clicks on Remove Item button
And User confirms removal of item by clicking Yes from dialogue box



