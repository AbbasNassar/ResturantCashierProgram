/*
 * Abbas Nassar 
 * 1210482
 * Lab_Sec_Number : 8L
 */
package application;
	
import java.util.ArrayList;
import java.util.Collections;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.event.*;

public class Driver1 extends Application {
	// I declared these variables here so i can use them freely inside the lamda expressions
	ArrayList <PizzaOrder> orders=new ArrayList<>();
	int pSize1=0 ;
	int numOfTop=0;
	double toppPrice=0;
	double tpRate=0;
	int Zone=0;
	double serviceCharge=0;
	int numPeo=0;
	int index =0;
	
	public static void main(String[] args) {
		
		Application.launch(args);
		
		
	}
	@Override
	public void start(Stage primaryStage)  {
		GridPane pane = new GridPane();  //Creating a pane from type grid pane to contain all the nodes that i need
		pane.setGridLinesVisible(false);
		pane.setAlignment(Pos.CENTER);  
		pane.setVgap(5); //Spacing between each column 
		pane.setHgap(5); //Spacing between each row
		
		Label custName = new Label("Customer Name");   // Creating nodes for the customer name
		TextField custNamet= new TextField("");
		custNamet.setEditable(true);
		
		
		
		pane.add(custName, 0, 0);   //Adding them to the grid pane in row 0 
		pane.add(custNamet, 1, 0);  
		
		Label ordTyp = new Label("Order Type");
		ComboBox<String> ordTypb = new ComboBox<>();  // Creating nodes for the order type
		ordTypb.getItems().addAll("To Go", "Delivary", "Seated");
		ordTypb.setValue("To Go"); //Setting default value
		
		
		
		pane.add(ordTyp, 0, 1);  //Adding them to the grid pane in row 1
		pane.add(ordTypb, 1, 1); 
		
		Label pizSze = new Label("Pizza Size");
		RadioButton SMALL = new RadioButton("SMALL");   // Creating nodes for the pizza size
		RadioButton MEDIUM = new RadioButton("MEDIUM");
		RadioButton LARGE = new RadioButton("LARGE");
		ToggleGroup group = new ToggleGroup();    
		SMALL.setSelected(true);  //Setting default value 
		group.getToggles().addAll(SMALL,MEDIUM,LARGE); //Here to make the user select one at most from the three radio buttons     
		HBox pSize = new HBox(); //To contain the three buttons in one row
		pSize.setSpacing(5);  //Spacing between each button
		pSize.getChildren().addAll(SMALL,MEDIUM,LARGE); //Adding the buttons to the HBox 
		
		pane.add(pizSze, 0, 2);  //Adding the HBox and the label to the grid pane
		pane.add(pSize, 1, 2);
		
		Label tops = new Label("List Of Toppings");   //Creating nodes for the toppings
		CheckBox onions = new CheckBox("Onions");
		CheckBox olives = new CheckBox("Olives");
		CheckBox greenPepper = new CheckBox("Green Pepper");
		HBox topBox = new HBox(); //To contain the three check boxes in one row
		topBox.setSpacing(5);//Spacing between each box
		topBox.getChildren().addAll(onions,olives,greenPepper);//Adding the buttons to the HBox 
				
		pane.add(tops, 0, 3);
		pane.add(topBox, 1, 3);  
		
		Label tripRate = new Label ("Trip Rate");  //Creating nodes for the trip rate
		TextField tripRatet = new TextField("0.0");//Setting default value 
		tripRatet.setEditable(true); 
		tripRate.setVisible(false);   //Hiding the nodes for the trip rate
		tripRatet.setVisible(false);
		
		pane.add(tripRate, 0, 4);  //Adding the nodes to the grid pane
		pane.add(tripRatet, 1, 4);
		
		Label zone = new Label ("Zone");   //Creating nodes for the zone
		TextField zonet = new TextField("0"); //Setting default value 
		zonet.setEditable(true); 
		zone.setVisible(false);  //Hiding the nodes for the zone
		zonet.setVisible(false);
		
		pane.add(zone, 0, 5); //Adding the nodes to the grid pane
		pane.add(zonet, 1, 5);
		
		Label servC = new Label ("Service Charge"); //Creating nodes for the service charge
		TextField servCt = new TextField("0.0");//Setting default value 
		servCt.setEditable(true);
		servC.setVisible(false); //Hiding the nodes for the service charge 
		servCt.setVisible(false);
		
		pane.add(servC, 0, 6);  //Adding them to the grid pane
		pane.add(servCt, 1, 6);
		
		Label numP = new Label ("Number Of People"); //Creating nodes for the number of people 
		TextField numPt = new TextField("0");//Setting default value 
		numPt.setEditable(true);
		numP.setVisible(false); //Hiding the nodes for the number of people 
		numPt.setVisible(false);
		
		pane.add(numP, 0, 7); //Adding the nodes to the grid pane
		pane.add(numPt, 1, 7);
		
		Label topPrice = new Label("Toppings Price"); //Creating nodes for the toppings price
		TextField topPricet = new TextField("10");
		topPricet.setEditable(true);
		topPricet.setAlignment(Pos.CENTER); //To make the string in the text field appear in the middle
		
		pane.add(topPrice, 0, 8); //Adding nodes to the grid pane 
		pane.add(topPricet, 1, 8);
		
		Label ordPrice = new Label("Order Price"); //Creating nodes for the order price 
		TextField ordPricet = new TextField("0.0");
		ordPricet.setEditable(false); //Making the order price uneditable
		ordPricet.setAlignment(Pos.CENTER);//To make the string in the text field appear in the middle
		
		pane.add(ordPrice, 0, 9); //Adding nodes to the grid pane
		pane.add(ordPricet, 1, 9);
		
		Button proOrd = new Button("Process Order"); //Creating buttons for the control buttons 
		Button prntOrd = new Button("Print Orders");
		Button res = new Button("Reset");
		HBox contBox = new HBox();
        contBox.setSpacing(5); //Spacing between each button 
		contBox.getChildren().addAll(proOrd,prntOrd,res); //Setting them in a HBox
		
		pane.add(contBox, 1, 10); //adding them to the grid pane
		
		ordTypb.setOnAction(e -> {    //If the order type button is clicked do this
			if (ordTypb.getValue()== "To Go" ) 
			{
				tripRate.setVisible(false);  //setting the appropriate nodes to appear based on the selected value in the combo box 
				tripRatet.setVisible(false);
				zone.setVisible(false);
				zonet.setVisible(false);
				servC.setVisible(false);
				servCt.setVisible(false);
				numP.setVisible(false);
				numPt.setVisible(false);
				
			}
			else if(ordTypb.getValue()== "Delivary")
			{
				tripRate.setVisible(true);//setting the appropriate nodes to appear based on the selected value in the combo box 
				tripRatet.setVisible(true);
				zone.setVisible(true);
				zonet.setVisible(true);
				servC.setVisible(false);
				servCt.setVisible(false);
				numP.setVisible(false);
				numPt.setVisible(false);	
			}
			else if (ordTypb.getValue()== "Seated" )
			{
				tripRate.setVisible(false);//setting the appropriate nodes to appear based on the selected value in the combo box 
				tripRatet.setVisible(false);
				zone.setVisible(false);
				zonet.setVisible(false);
				servC.setVisible(true);
				servCt.setVisible(true);
				numP.setVisible(true);
				numPt.setVisible(true);
			}
		});
			
		  proOrd.setOnAction(e-> {
			  numOfTop=0;
			  String name = custNamet.getText(); //Getting all the info from the GUI
			  String orderType = ordTypb.getValue();
			  toppPrice = Double.parseDouble(topPricet.getText()); //Casting the String to double and so on
			  tpRate = Double.parseDouble(tripRatet.getText());
			  Zone = Integer.parseInt(zonet.getText());
			  serviceCharge = Double.parseDouble(servCt.getText());
		      numPeo = Integer.parseInt(numPt.getText());
			   if(SMALL.isSelected())  //Setting an identifier for the size
				    pSize1 = 1;
				else if(MEDIUM.isSelected())
					pSize1 = 2;
				else if(LARGE.isSelected())
					pSize1 = 3;
			    if (onions.isSelected()) //Collecting how many toppings are sellected 
					numOfTop++;
			    if (olives.isSelected())
					numOfTop++;
				if (greenPepper.isSelected())
					numOfTop++;
			  if (orderType=="To Go"){ //If it is to go it will create an object from type to go and add it the array list 
				  
				  if (pSize1==1)
				  {
					  orders.add(new ToGo(name,PizzaOrder.SMALL,numOfTop,toppPrice));
					   String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());//Calculating the order price based on the index value and so on 
					   ordPricet.setText(orderPrice);
					   index++;
				  }
				  else if(pSize1 ==2 )
				  {
					  orders.add(new ToGo(name,PizzaOrder.MEDIUM,numOfTop,toppPrice));
					   String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					   ordPricet.setText(orderPrice);
					   index++;
				  }
				  else
				  {
					  orders.add(new ToGo(name,PizzaOrder.LARGE,numOfTop,toppPrice));
					   String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					   ordPricet.setText(orderPrice);
					   index++;
				  }
				
			 
			}
			else if ( orderType=="Delivary") {
				
				 if (pSize1==1) {
					 orders.add(new Delivery(name,PizzaOrder.SMALL,numOfTop,toppPrice,tpRate,Zone));
					 String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					 ordPricet.setText(orderPrice);
					 index++;
				 }
				 else if (pSize1==2)
				 {
					 orders.add(new Delivery(name,PizzaOrder.MEDIUM,numOfTop,toppPrice,tpRate,Zone));
					 String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					 ordPricet.setText(orderPrice);
					 index++;
				 }
				 else {
					 orders.add(new Delivery(name,PizzaOrder.LARGE,numOfTop,toppPrice,tpRate,Zone));
					 String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					 ordPricet.setText(orderPrice);
					 index++;
				 }
				 
			}
			else if (orderType=="Seated") {
				
				if (pSize1==1) {
					orders.add( new Seated(name,PizzaOrder.SMALL,numOfTop,toppPrice,serviceCharge,numPeo));
					 String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					 ordPricet.setText(orderPrice);
					 index++;
				}
				else if(pSize1==2){
					orders.add( new Seated(name,PizzaOrder.MEDIUM,numOfTop,toppPrice,serviceCharge,numPeo));
					 String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					 ordPricet.setText(orderPrice);
					 index++;
				}
				else {
					 orders.add( new Seated(name,PizzaOrder.LARGE,numOfTop,toppPrice,serviceCharge,numPeo));
					 String orderPrice = String.valueOf(orders.get(index).calculateOrderPrice());
					 ordPricet.setText(orderPrice);
					 index++;
				}
				
			}
			  
			  
			
		});
		  prntOrd.setOnAction(e ->{ 
			  Stage secStage = new Stage(); //Creating a new one 
			  GridPane pane1 = new GridPane();//New grid pane 
			  sortOrders(orders);//sorting the orders based on the method below in the class 
			  
			  Label order1 = new Label("Orders: "); //Creating nodes for the new orders
			  pane1.add(order1, 0, 0);
			  if(orders.size()==0) //If there is no orders print empty 
			     pane1.add(new Label ("EMPTY"), 1, 0);
			  else
			  {
				  for (int i=0; i<orders.size(); i++)
					{                                                       
					    Label t = new Label(orders.get(i).printOrderInfo());//Adding the strings to a node  
					    pane1.add(t, 1, i);//Adding the node to the grid pane
					}
			  }
			  pane1.setAlignment(Pos.CENTER);//Setting the grid pane to appeare in the middle of the screen 
			  Scene scene1 = new Scene(pane1,500,500);//putting the pane in the scene 
			  secStage.setTitle("Orders");//Setting a title 
			  secStage.setScene(scene1);//putting the scene in the stage
			  secStage.show();//Showing the new stage 
		  });
		  
		  res.setOnAction(e -> { //Reseting all the nodes to their default value 
				custNamet.setText("");
				SMALL.setSelected(true);
				ordTypb.setValue("To Go");
				onions.setSelected(false);
				olives.setSelected(false);
				greenPepper.setSelected(false);
				topPricet.setText("10");
				ordPricet.setText("0.0");
				tripRatet.setText("0.0");
				zonet.setText("0");
				servCt.setText("0.0");
				numPt.setText("0");
				orders.removeAll(orders);//Removing all the orders from the array list 
			});
		  
		 
		
		  
		
		 
		
		Scene scene = new Scene(pane, 500,500);//putting the pane in the scene
		
		primaryStage.setTitle("Pizza Resturant");//Setting the title 
		primaryStage.setScene(scene);//putting the scene in the primaryStage
		primaryStage.show();//Showing the primary stage
		
	}
	//sorting method 
    public static void  sortOrders(ArrayList<PizzaOrder> o) {
    	Collections.sort(o); //Method to sort the orders in the array list  
    }
}
