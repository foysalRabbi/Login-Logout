@contact-us
Feature: Check registration functionality.

  Scenario: Verify that a user is able to register successfully when take input in all fields.
    Given A user must be able to visit the registration url
    When A user enter a unique first name
    And A user enter a unique last name
    And A user enter a unique email address
    And A user enter a unique comment
    And A user click on the submit button
    Then A user should be able to see a message successfully