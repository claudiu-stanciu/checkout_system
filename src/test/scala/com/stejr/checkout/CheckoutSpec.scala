package com.stejr.checkout

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

class CheckoutSpec extends FeatureSpec with Matchers with GivenWhenThen {

  scenario("calculate the price for a simple list of items to checkout") {

    Given("a basket of produce")
    val basket = List("apple", "apple", "orange", "apple")

    When("we want to checkout")
    val checkout = new Checkout

    // apple = 0.6, orange = 0.25
    val expectedTotalPrice = 2.05
    Then(s"the checkout process should return the total price of $expectedTotalPrice")
    checkout.calcTotalPrice(basket) shouldBe expectedTotalPrice
  }

  scenario("calculate the price for an empty list of items to checkout") {

    Given("an empty basket")
    val basket = List[String]()

    When("we want to checkout")
    val checkout = new Checkout

    // apple = 0.6, orange = 0.25
    val expectedTotalPrice = 0f
    Then(s"the checkout process should return the total price of $expectedTotalPrice")
    checkout.calcTotalPrice(basket) shouldBe expectedTotalPrice
  }

  scenario("calculate the price for a list of unknown items to checkout") {

    Given("a basket with an unknown item")
    val basket = List[String]("zebra", "apple")

    When("we want to checkout")
    val checkout = new Checkout

    Then(s"the checkout process should throw an UnknownCheckoutItem exception")
    assertThrows[UnknownCheckoutItemException] {
      checkout.calcTotalPrice(basket)
    }
  }
}
