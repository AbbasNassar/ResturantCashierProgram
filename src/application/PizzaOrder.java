/*
 * Abbas Nassar 
 * 1210482
 * Lab_Sec_Number : 8L
 */

package application;

import java.util.*;


//here i created the comparable class PizzaOrder
public  class PizzaOrder implements Comparable<PizzaOrder> {
    
	//attributes for the PizzaOrder
	
	private String CustomerName;
	
	private Date dateOrdered=new Date() ;
	
	final static int SMALL=1,MEDIUM=2,LARGE=3;
	
	private int pizzaSize;
	
	private int numberOfToppings;
	
	private double toppingPrice;
	
	//here i defined two different constructors
	
	public PizzaOrder() {
		
	}
	public PizzaOrder(String customerName,int pizzaSize, int numberOfToppings, double toppingPrice) {
		
		this.CustomerName = customerName;
		this.pizzaSize = pizzaSize;
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
	}
	
	// Getters and setters for the attributes except the date order which i initialized above.
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public Date getDateOrdered() {
		return dateOrdered;
	}
	public int getNumberOfToppings() {
		return numberOfToppings;
	}
	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}
	public double getToppingPrice() {
		return toppingPrice;
	}
	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	/*
	 * here i changed the getter for pizza size to return a string based on the integer value of Pizza Size,
	 * so i can print for example "small" instead of the value 1 .
	 */
	public String getPizzaSize() {
		if(pizzaSize==1)
			return "small";
		else if(pizzaSize==2)
			return "medium";
			return "large";
		
	}

	public void setPizzaSize(int pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	
	// here i overriden the toString method in Object class.
	@Override
	public String toString() {
		return "Customer Name = " + CustomerName +"\n"+ "Date ordered = " + dateOrdered +"\n"+"Pizza size = "+getPizzaSize()+"\n"+ "Number of toppings = "
				+ numberOfToppings+"\n" + "Topping Price = " + toppingPrice + "\n";
	}
	
    //this method is used to calculate order price, and to be override in the subclasses.
	public double  calculateOrderPrice() {
		return numberOfToppings*toppingPrice*pizzaSize;
	}
	
	//this method is used to print the order info for the array list elements.
	public String printOrderInfo(){
		
		 return CustomerName+"  "+calculateOrderPrice()+"\n";
	}
	/*
	 * here i override the compare to method in the comparable  to make the Collection.sort sort the ArrayList elements 
	     based on each element order price.
	 */
	@Override
	public int compareTo(PizzaOrder A) {
		if (calculateOrderPrice()>A.calculateOrderPrice())
			return 1;
		else if (calculateOrderPrice()<A.calculateOrderPrice())
			return -1;
		else 
			return 0;
	}
}
