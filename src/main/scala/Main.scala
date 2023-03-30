
package com.knoldus

object Main extends App {
  private val paymentSystemObject = new PaymentSystem()
  private val creditCard =  CreditCard("Vanshika","1234-5678-9012-3456", "987", "12/30")
  private val payPal = PayPal("Vanshika","vanshika.srivastava@example.com", "password123")
  private val bankTransfer =  BankTransfer("Vanshika","1234567890", "987654321")

  paymentSystemObject.addPaymentMethod(creditCard)
  paymentSystemObject.addPaymentMethod(payPal)
  paymentSystemObject.addPaymentMethod(bankTransfer)


  paymentSystemObject.listPaymentMethods()

  paymentSystemObject.processPayment(100.0,"Credit Card")
  paymentSystemObject.processPayment(100.0,"PayPal")
  paymentSystemObject.processPayment(100.0,"Bank Transfer")
}