Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: verify title of the Landing page
    Given user is in Landing page
    Then the title of the page will be correct
    When clicks on the sign in
    Then user sign in will be a success

  Scenario: Verify Signed in Home Page
    Given user is in Landing page
    When clicks on the sign in
    Then user is in signedinhome page

  Scenario: Verify OrderStatus Page
    Given user is in Landing page
    When clicks on the sign in
    When he clicks on the order status link
    When clicks on the sign in again
    When he clicks on the items tab
    Then he will get all items
