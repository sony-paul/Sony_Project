@api
Feature: to test api feature
  I want to use this template for my feature file

  @authenticateapi
  Scenario: api testing
    Given I enter auth details
    
  @api
  Scenario: api testing
    Given I launch the url
    Then I can validate response
   @api
  Scenario: POST api testing
    Given I provide a post request
   @api
  Scenario: PUT api testing
    Given I provide a put request
    
     @api
  Scenario: PATCH api testing
    Given I provide a patch request
    
      @api
  Scenario: DELETE api testing
    Given I provide a delete request
  
    
   @multiapi
  Scenario Outline: POST api testing with multi users
    Given I enter"<user>"and"<pwd>"
    
   Examples:
   |name|job|
   |testname1|qa|
   |testname2|qe| 
   
   @deckofcardsapi
    Scenario: deck of cards api testing
  #  Given I provide a get request for deck of cards
    And a POST request payload check
   
    