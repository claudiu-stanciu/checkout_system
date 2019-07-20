package com.stejr.checkout

/**
 * Checkout process for handling price catalog and total basket price
 */
class Checkout {

  /**
   * Define a simple price catalog
   */
  val prices = Map("apple" -> 0.60, "orange" -> 0.25)

  /**
   * Calculate the total price for the basket of items
   *
   * @param items for checkout
   * @return total price
   */
  def calcTotalPrice(basket: List[String]): Double = {
    basket.map { item => if (prices.contains(item)) prices(item) else throw new UnknownCheckoutItemException() }.sum
  }
}
