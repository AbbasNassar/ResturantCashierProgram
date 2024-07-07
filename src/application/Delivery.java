/*
 * Abbas Nassar 
 * 1210482
 * Lab_Sec_Number : 8L
 */

package application;



public class Delivery extends PizzaOrder {
	private double tripRate;
	private int zone;
	
	/*
	 * Since the class Delivery inherits the super class PizzaOrder, i created a constructor for Delivery
	 * and included the super class constructor using the word super. 
	 */
	Delivery(){
		
	}
	public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate,
			int zone) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.tripRate = tripRate;
		this.zone = zone;
	}
   // setters and getters for the attributes 
	public double getTripRate() {
		return tripRate;
	}

	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		
		this.zone = zone;
		
	}

	//here i override the method toString to return the string containing the info of the delivery 
	@Override
	public String toString() {
		return super.toString()+"Trip Rate = " + tripRate +"\n"+ "Zone = " + getZone() +"\n"+"Order price = "+ calculateOrderPrice() ;
	}
	//here i override the method calculate to return the order price calculated with a new formula.
	public double calculateOrderPrice() {
		return super.calculateOrderPrice()+((tripRate/100)*super.calculateOrderPrice()*zone);
	}
	
	

}
