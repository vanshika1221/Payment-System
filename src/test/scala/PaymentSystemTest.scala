
package com.knoldus
import org.scalatest.funsuite.AnyFunSuite

import scala.util.{Success, Try}
class PaymentSystemTest extends AnyFunSuite {
  val paymentSystemObject = new PaymentSystem

  test("To process credit card payment") {
    val creditCard = CreditCard("John Doe", "1234567890123456", "123", "12/23")
    paymentSystemObject.addPaymentMethod(creditCard)
    val result = Success(true)
    assert(paymentSystemObject.processPayment(100.0,"Credit Card") === result)
  }
  test("To process PayPal payment") {
    val payPal = PayPal("Vanshika","vanshika.srivastava@example.com", "password123")
    paymentSystemObject.addPaymentMethod(payPal)
    val result = Success(true)
    assert(paymentSystemObject.processPayment(100.0, "PayPal") === result)
  }
  test("To process Bank Transfer payment") {
    val bankTransfer = BankTransfer("Vanshika","1234567890", "987654321")
    paymentSystemObject.addPaymentMethod(bankTransfer)
    val result = Success(true)
    assert(paymentSystemObject.processPayment(100.0, "Bank Transfer") === result)
  }
}
