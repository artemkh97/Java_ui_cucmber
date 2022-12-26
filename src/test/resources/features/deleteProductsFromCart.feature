Feature: Google image search

  @delete-from-cart
  Scenario: User can delete a product from cart
    Given the user is on the main page
    When the user opens detailed card for a random product
    And  the user checks product title, price and description
    And  the user added product to cart
    Then the user opens the cart
    And the user removes a product from cart
