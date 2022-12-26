@addProductExample
Feature: Add products to the cart

  @add-to-cart
  Scenario Outline: User can add a phone to the cart
    Given the user is on the main page
    When the user opens detailed card for a product <title>
    And  the user checks product title <title>
    And  the user checks product price <price>
    And  the user checks product description <description>
    And  the user added product to cart
    Then the user opens the cart
    And the user checks that cart have a product with title <title> and price <price>

    Examples:
      | title         | price | description                                                                                                                                                                                                                                  |
      | Nexus 6       | 650   | The Motorola Google Nexus 6 is powered by 2.7GHz quad-core Qualcomm Snapdragon 805                                                                                                                                                           |
      | Iphone 6 32gb | 790   | It comes with 1GB of RAM. The phone packs 16GB of internal storage cannot be expanded. As far as the cameras are concerned, the Apple iPhone 6 packs a 8-megapixel primary camera on the rear and a 1.2-megapixel front shooter for selfies. |
