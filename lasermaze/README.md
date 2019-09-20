# Lasermaze
In a rectangular room sits a laser that is about to be fired toward the east wall.  Inside the room, a certain number of prisms and mirrors have been placed.  They alter the direction of the laser if it hits them.  

You want to know how far the laser will travel before it hits a wall, taking into account the direction-altering properties of the prisms and mirrors that it might hit along the way.


## INPUT
* At most a string of 50 equal length lines ending in '\n'. 
* Each character is an unit of space, containing one of the object types below.  
* The last line may or may not contain a terminating newline.  
* The walls are the lower and upper bounds of the 2-dimensional array.

### Objects
Note:
* Westwardly - from west to east  (`* -----> []`)
* The strength of the beam is constant, there's no such thing as attenuation here.

1. **Laser**
  * `@` - Starting position of the laser, laser always starts westwardly.

2. **Empty space**
  * `-` - No change to direction

3. **Prisms**  
     Direct light to the absolute direction of the prism
    * `^` - Direct to the north - westwardly directs to north
    * `v` - Direct to the south - westwardly directs to south
    * `>` - Direct to the east - westwardly directs to east
    * `<` - Direct to the west - westwardly directs to the west (no change)

4. **Mirrors**
    Reflect light to a relative direction of the incoming direction
    * `/` - Reflect +90 - westwardly beam will reflect to the north
    * `\` - Reflect  -90 - westwardly beam will reflect to the south
    * `O` - Reflect 180 - westwardly beam will reflect back to the east

## OUTPUT
* A single integer: the distance traveled until a wall is hit.
* Infinite loop: -1, detect and exit on first recurrence of the loop (second iteration)
  * consider a laser between two 180 degree mirrors:  
   `O--@---O` (this would bounce back and forth forever).

### EXAMPLES
The following examples will help you understand what the input looks like, and what the proper corresponding output should look like.


**Empty space**
```
@--
---
---
```
Output: `3`

**Prism**
```
@-v
---
---
---
```
Output: `6`

**Prism 2**
```
@-v-
----
--<-
```
Output: `7`

**Triple Prism**
```
@-v
---
-^<
```
Output: `8`


**Quad prism**
```
@-v
->-
-^<
```
Output: `8` 

**Infinite loop**
```
@-v
->v
-^<
```
Output: `-1`

**Prisms and Mirrors**
```
@v-
/\v
-^<
```
Output: `9`

**Infinite loop**
```
@v-
/\v
\^<
```
Output: `-1`

**180**
```
-@\
--O
--^
```
Output: `6`


## Get Started

In this project, you may begin your implementation within the 'src/' directory.
Specifically, within the file, `src/main/java/Lasermaze.java`

```

public class Lasermaze implements  Testable {
  public int evaluate(String input) {
    /*
     * Implement your lazermaze here.
     * Feel free to create other classes and files in src/main/java/**
     */

    return -42;
  }
}
```
This implementation tries -42 which will never be a valid answer 
to the ultimate question.  It is advised to create other objects, 
and call your objects from this point.

You may test your implementation using:
`./gradlew test`

You will see a set of output describing what went wrong:
```
./gradlew test
...

LasermazeTest > testEvalatuate[input/input016.txt] FAILED
    java.lang.AssertionError: Given input:
    v-\--
    /-@-O
    -----
    \-/--
     expected:<17> but was:<-42>
        at org.junit.Assert.fail(Assert.java:88)
        at org.junit.Assert.failNotEquals(Assert.java:834)
        at org.junit.Assert.assertEquals(Assert.java:645)
        at LasermazeTest.testEvalatuate(LasermazeTest.java:62)
```