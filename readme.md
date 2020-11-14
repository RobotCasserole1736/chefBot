# ChefBot

Program your [FIRST Robotics Competition](https://www.firstinspires.org/robotics/frc) robot using the [Chef programming language](https://www.dangermouse.net/esoteric/chef.html)!

There are a couple Robot-specific extensions we've made:

## Architecture

You must write your software in `.chef` files. Put them into [the `src\main\deploy\tonightsMenu` folder](https://github.com/RobotCasserole1736/chefBot/tree/master/src/main/deploy/tonightsMenu). 

At robot init time, our little chefs read every "item" in the menu to make sure they understand what they'll be cooking.

The Chefs are fast. During teleop and autonomous, each recipe is cooked up once every 20ms.

For convienece, `ingredients` hold values that are double floating point values (not integers). However, if you attempt to print out values as unicode, they'll still be converted back to integers first.

There is (currently) no way to remember ingredients between loops. This helps keep things fresh!

There is (currently) no way to exchange any information between chefs. They're on the clock, no time for socializing! 

## Input

Joystick in put is accessed by retrieving ingredients from the `nth refrigerator`. 

 * `1st refrigerator`: Joy 0 LH Y axis
 * `2nd refrigerator`: Joy 0 RH X axis
 * `3rd refrigerator`: Joy 0 Button 1
 * `4th refrigerator`: Joy 0 Button 2
 * `5th refrigerator`: Joy 0 Button 3

## Output

11 Baking sheets come pre-defined. The first 10 map to the 10 PWM outputs on the roboRIO. The 11th goes to `stdout`.

When the recipe is served, the value at the top of each PWM-related baking sheet is popped and passed to the motor controller.

## References

Special thanks to [Joost Rijneveld](https://joostrijneveld.nl/) for his [java-based Chef interpreter](https://github.com/joostrijneveld/Chef-Interpreter) that was the base of this project.

[Dylan Beattie included it in his wonderful talk "The Art of Code"](https://www.youtube.com/watch?v=6avJHaC3C2U&feature=youtu.be&t=2309)

## Demo

This repository contains a quick example of a simple (kitbot) tank drive robot with an arm. Buttons 1 and 2 trigger the arm to go up and down. X/Y axes on the joysticks drive the robot around.

![cool gif of the robot in action](./chef1.gif)

# But, Why?

Chef is an organic choice for programming: Everyone loves food, no one can live without it. Modeling your syntax after food ties it to some of the most base motivations we have as living creatures. 

Chef is efficient for you: You can indulge two hobbies (coding and cooking) simultaneously.

Chef reduces hard disk clutter: With a bit of care, you can encode your grandma's prize-winning recipe for chocolate chip cookies and that Machine Learning LQR State-Space Extended-PIDF Ramalamadingdong Decaf Turbo-Encabulator implementation in the same file! 

Chef is relevant: Many great FRC teams have words like "cheesy", "barbecue", and "corn" in their name. Furthermore, all great FRC teams have eaten food at some point. You can now use your software to funnel your team toward greatness, which flows from food.

# But, really, why?

Because Chris got bored. 

# Should I actually use this for anything?

Probably not.

