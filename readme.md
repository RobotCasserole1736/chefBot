# ChefBot

See [this link](https://www.dangermouse.net/esoteric/chef.html) for syntax information on the Chef programming language.

There are a couple FIRST specific extensions we've made:

## Architecture

You must write your software in `.chef` files. Put them into the `src\main\deploy\tonightsMenu` folder. 

At robot init time, our little chefs read every "item" in the menu to make sure they understand what they'll be cooking.

The Chefs are fast. During teleop and autonomous, each recipe is cooked up once every 20ms.

There is (currently) no way to remember ingredients between loops. This helps keep things fresh!

## Input

Joystick in put is accessed by retrieving ingredients from the `nth refrigerator`. 

 * `1st refrigerator`: Joy 0 LH Y axis
 * `2nd refrigerator`: Joy 0 RH X axis
 * `3rd refrigerator`: Joy 0 Button 0
 * `4th refrigerator`: Joy 0 Button 1
 * `5th refrigerator`: Joy 0 Button 2


## Output

11 Baking sheets come pre-defined. The first 10 map to the 10 PWM outputs on the roboRIO. The 11th goes to `stdout`.

When the recipe is served, the value at the top of each PWM-related baking sheet is popped and passed to the motor controller.

