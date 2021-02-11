Feature: Change currency of prices

@ChangeCurrency
Scenario: Verfiy change of currency
	Given User is on retail environment home page
	When User changes selects a currency
	Then User selects item from Deskops menu
	And User verifies price is changed to different currency
