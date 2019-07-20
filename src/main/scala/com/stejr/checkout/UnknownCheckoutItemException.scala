package com.stejr.checkout

/**
 * To be used when the basket contains an item which doesn't appear in the price catalog
 * @param message
 */
case class UnknownCheckoutItemException(message: String = "Unknown item for checkout") extends Exception(message)
