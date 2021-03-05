# The Burger App

This is a Java exercise to built an app that helps a burger company to manage their processes

## Requirements
 - Create a base hamburger and two other types of hamburgers.
 - All burgers should have bread type and one meat topping.
    - Bread types: Wholegrain, White, Brioche, Ciabatta
    - Meat choices : Black angus patty, Kobe beef patty, Vegan patty, Fish patty
 - The basic hamburger should have the following items:
    - Up to 4 additional toppings (e.g. cheese, sauces, lettuce, tomato, union, etc) that the customer can select to be added to the burger.
    - Each one of these items gets charged an additional price.
    - So you need some way to track how many items got added.
    - The burger has a base price and the toppings/additions are all separately priced.
    - And calculate the final price (base burger with all the toppings/additions).
 - The healthy burger should have the following:
    - It can have 6 toppings in total.
 - The combo burger should have the following:
    - Comes with chips and drinks as additions
    - No extra toppings are allowed.
 - All burgers should be able to output:
    - Base price of the hamburger.
    - Each topping name.
    - Topping price.
    - And a grand total for the burger (base price + all toppings / additions).


## Considerations
It was not clear where the output should go to. STDOUT is a simple choice, so I decided to create a PicoCLI driver.