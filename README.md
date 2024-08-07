# Pizza Restaurant Management System

## Overview
This JavaFX application is designed to manage pizza orders in a restaurant. It supports different types of orders including to-go, delivery, and seated orders. The application allows users to input order details, calculate prices, and view all orders.

## Features
- **Order Types**: Supports to-go, delivery, and seated orders.
- **Order Management**: Add, view, and reset orders.
- **Price Calculation**: Calculates the total price based on pizza size, number of toppings, and other factors.
- **Sorting**: Orders can be sorted by price.

## Classes

### PizzaOrder
This is the base class for all pizza orders.

#### Attributes:
- `CustomerName`: The name of the customer.
- `dateOrdered`: The date the order was placed.
- `pizzaSize`: The size of the pizza (SMALL, MEDIUM, LARGE).
- `numberOfToppings`: The number of toppings on the pizza.
- `toppingPrice`: The price per topping.

#### Methods:
- `calculateOrderPrice()`: Calculates the total price of the order.
- `printOrderInfo()`: Returns a string with the customer name and order price.
- `compareTo(PizzaOrder)`: Compares orders based on their price for sorting.

### Delivery
This class extends `PizzaOrder` and adds attributes specific to delivery orders.

#### Attributes:
- `tripRate`: The rate charged for the trip.
- `zone`: The zone to which the delivery is made.

#### Methods:
- `calculateOrderPrice()`: Calculates the total price of the order, including delivery charges.
- `toString()`: Returns a string representation of the delivery details.

### Driver1
This is the main class for the JavaFX application.

#### Methods:
- `start(Stage)`: Sets up the primary stage and scene.
- Handles events such as adding an order, viewing orders, and resetting the form.
- `sortOrders(ArrayList<PizzaOrder>)`: Sorts the orders using a static method.

### Seated
This class extends `PizzaOrder` and adds attributes specific to seated orders.

#### Attributes:
- `serviceCharge`: The price of the service.
- `numberOfPeople`: The number of people to be served.

#### Methods:
- `calculateOrderPrice()`: Calculates the total price of the order.

## Getting Started

### Prerequisites:
- Java Development Kit (JDK) 8 or later.
- JavaFX SDK.

### Running the Application:
1. Compile the Java files.
2. Run the `Driver1` class to launch the application.

## Usage

### Add an Order:
1. Enter the customer name.
2. Select the order type (To Go, Delivery, Seated).
3. Choose the pizza size.
4. Select the toppings and their price.
5. For delivery, enter the trip rate and zone.
6. For seated orders, enter the service charge and number of people.
7. Click the "Add Order" button.

### View Orders:
1. Click the "View Orders" button to see all orders.

### Reset Form:
1. Click the "Reset" button to clear all inputs.
