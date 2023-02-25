# Acquarium_GUI
Final project for my IC211 (Object Oriented Programming) class, made a GUI for a simple fish-tank game using java.
1. The program can be run in the command line by compiling all of the java files
and entering "java Prog3".

2. The GUI controls are relatively straightforward- start/stop button is used to
freeze/unfreeze the tank, feed button used to drop in plankton, the combobox
allows for adding of new animals. When using the advanced controls, slide the
JSlider to the desired amount and clicking on the action from the dropdown menu
actually causes it to happen. Note: when you make an animal immortal with the
advanced controls, there is no way to kill it, not even with hunger.

3. This solution to the fish tank uses good OOP design for a multitude of reasons-
first off, data hiding is preserved with the use of get() and set() methods, as
well as protected variables. Also, encapsulation is used because lower level
classes in the hierarchy are responsible for overriding methods that do what they
want. Additionally, there is a polymorphic ArrayList in Tank.java that holds
all of the different SeaCreatures, and are therefore a ton of different polymorphic
call sites. Finally, inheritance is used when classes inherit each other, such
as the hierarchy of SeaCreatures and Fish/LionFish/Shark/Plankton that all extend
the SeaCreature class.

4.
Fish= move diagonally left/right, bouncing off of the walls.
Shark= same as fish but confined to the lower part of the tank.
LionFish= moves in every direction to a random point, generates a new random
point when arriving at the previous one.
Plankton= starts at the surface and floats down to a random depth.

5. First off, the fish get larger when they eat more stuff. The degree to which
their size is increased is dependent on the aspect ratio of the image (or so I
believe), but they all increase at a rate of 5 pixels per plankton consumed.
Also, there are some additional advanced controls, such as the ability to make
an animal immortal, which means that the animal cannot be eaten or starve to
death.
