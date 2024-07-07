/*
 * Abbas Nassar 
 * 1210482
 * Lab_Sec_Number : 8L
 */

package application;

public class Seated extends PizzaOrder {
     double serviceCharge;
     int numberOfPeople;
	
     
     Seated(){
    	 
     }
     /*
 	 * Since the class Delivery inherits the super class PizzaOrder, i created a constructor for Delivery
 	 * and included the super class constructor using the word super. 
 	 */
     public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice,
			double serviceCharge, int numberOfPeople) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}
   //here i override the method toString to return the string containing the info of the delivery
	@Override
	public String toString() {
		return super.toString()+"Service charge = " + serviceCharge + "\n"+"Number of people = " + numberOfPeople +"\n"+"Order price = "+calculateOrderPrice();
	}
	//here i override the method calculate to return the order price calculated with a new formula.
	public double calculateOrderPrice() {
		return super.calculateOrderPrice()+serviceCharge*numberOfPeople;
	}
     
	
}
