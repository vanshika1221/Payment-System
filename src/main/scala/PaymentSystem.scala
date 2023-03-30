
package com.knoldus
import scala.util.Try

// PaymentMethod trait defining common behavior for all payment methods
trait PaymentMethod {
  def processPayment(amount: Double): Try[Boolean]
  def getDetails: String
}
// Case class representing Credit Card payment method
case class CreditCard(userName: String,cardNumber: String,cvvNumber: String,expiryDate: String) extends PaymentMethod {
  override def processPayment(amount: Double): Try[Boolean] = {
    Try {
      println(s"Processing Payment of $amount using Credit Card")
      true
    }
  }
  override def getDetails: String = s"Credit Card - $cardNumber of $userName"
}
// Case class representing PayPal payment method
case class PayPal(userName: String,emailId: String,password: String) extends PaymentMethod {
  override def processPayment(amount: Double): Try[Boolean] = {
    Try {
      println(s"Processing Payment of $amount using PayPal")
      true
    }
  }
  override def getDetails: String = s"PayPal - $emailId of $userName"
}
// Case class representing Bank Transfer payment method
case class BankTransfer(userName: String,accountNumber: String,accountNumberToTransfer: String) extends PaymentMethod {
  override def processPayment(amount: Double): Try[Boolean] = {
    Try {
      println(s"Processing Payment of $amount using Bank Transfer")
      true
    }
  }
  override def getDetails: String = s"Bank Transfer from - $accountNumber to $accountNumberToTransfer done by $userName"
}
// PaymentSystem class to manage payment methods and process payments
class PaymentSystem {
  // private variable to hold payment methods
  private var paymentMethods: List[PaymentMethod] = List.empty

  def addPaymentMethod(paymentMethodType: PaymentMethod): Boolean = {
    if (paymentMethods.contains(paymentMethodType)) {
      false
    }
    else {
      println(s"Payment Method $paymentMethodType added successfully")
      paymentMethods = paymentMethodType :: paymentMethods
      true
    }
  }
  // method to process payment of given amount using specified payment method
  def processPayment(amount: Double, paymentMethodName: String): Try[Boolean] = {
    paymentMethods.find(_.getDetails.contains(paymentMethodName)) match {
      case Some(paymentMethod) =>
        paymentMethod.processPayment(amount)
      case None =>
         throw new Exception(s"Payment method not found: $paymentMethodName")
    }
  }
  // method to list all payment methods in the system
  def listPaymentMethods(): Unit = {
    println("Payment Methods are: ")
    paymentMethods.foreach(paymentType => println(paymentType.getDetails))
  }
}
