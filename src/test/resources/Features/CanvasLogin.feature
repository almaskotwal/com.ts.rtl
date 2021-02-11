@AccessStuff
Feature: Canvas Login

Background: User logs in
Given User is on the canvas website
And User enters username 'almaskotwal2@gmail.com' and password 'mustafakamal'
And User clicks on submit button


@CanvasLogin
Scenario: User logs in to Canvas Website
Then User should be on canvas dashboard

@AccessFiles
Scenario: User accesses PowerPoint files through dashboard
Given User is dashboard
And User clicks on a current class
Then Verify user is inside the current class
And User clicks on file
Then User clicks on course image
