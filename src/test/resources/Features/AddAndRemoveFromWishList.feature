@AddRemoveWishList
Feature: Add item to Wish List and remove from Wish List


Background: User logs in 
Given User is on Retail Page
And User logs in with userName'sdet@tekschool.us' and 'sdet'
And User clicks moves mouse over Desktops menu
Then User clicks on iMac

@AddToWishList
Scenario: Add to Wishlist
When User clicks on the heart icon
Then User should see the message 'Success: You have added iMac to your wish list!'

@RemoveItemFromWishList
Scenario: Remove from Wishlist
When User clicks on the Wish List button
And User sees iMac listed there
Then User clicks on the red X button
And User clicks yes in the confirmation box

