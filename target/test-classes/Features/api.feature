@api
Feature: Author API feature

  @api
  Scenario: Fetch author names from Author API
    Given the API endpoint for authors is available
    When I send a GET request to the authors endpoint
    Then the response status code should be 200
    And the response should contain a valid personal name "Sachi Rautroy" and alternate name "Yugashrashta Sachi Routray"
