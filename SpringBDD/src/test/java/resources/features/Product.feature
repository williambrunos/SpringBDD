Feature: Store Products
  Scenario: Get all products from my store
    Given I have more than 5 products in my store
    And one of these products is a cell phone
    Then all product must be returned successfully