/*
 * Abbas Nassar 
 * 1210482
 * Lab_Sec_Number : 8L
 */

package application;


/*
 * Since the class ToGo inherits the super class PizzaOrder, i created a constructor for ToGo
 * and included the super class constructor using the word super. 
 */
public class ToGo extends PizzaOrder {
	
  ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		
		
	}
  

}
