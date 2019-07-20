package com.stejr.checkout

import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode

/**
 * Checkout process for handling price catalog and total basket price
 */
class Checkout {

  /**
   * Define a simple price catalog using the convention (item -> price)
   */
  val prices = Map("apple" -> 0.60f, "orange" -> 0.25f)

  def getPrice(item: String): Float = {
    if (prices.contains(item)) prices(item) else throw new UnknownCheckoutItemException()
  }

  /**
   * Calculate the total price for the basket of items, deducting the discount from the initial price
   *
   * @param basket items for checkout
   * @return total price
   */
  def calcTotalPrice(basket: List[String]): Float = {
    BigDecimal(calcInitialPrice(basket) - calcDiscount(basket)).setScale(2, RoundingMode.HALF_UP).toFloat
  }

  /**
   * Calculate initial price for the basket of items
   */
  def calcInitialPrice(basket: List[String]): Float = {
    basket.map { item => getPrice(item) }.sum
  }

  /**
   * Calculate the discount for the basket of items
   */
  def calcDiscount(basket: List[String]): Float = {
    basket.groupBy(identity).map { case (item: String, itemGrouped: List[String]) =>
      val itemCount: Int = itemGrouped.length

      // apply promotion per item category
      item match {
        case "apple" => {
          // buy one, get one free
          val minQuantity = itemCount / 2
          if (minQuantity >= 1) minQuantity * getPrice(item) else 0
        }

        case "orange" => {
          // 3 for the price of 2
          val minQuantity = itemCount / 3
          if (minQuantity >= 1) minQuantity * getPrice(item) else 0
        }

        case _ => 0
      }
    }.sum
  }
}
