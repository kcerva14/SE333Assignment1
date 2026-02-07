Part 1
1. A. (On = 570, Off 571) At 570, the condition still holds true (570 <= 570), but at 571, the condition is no longer true.
2. (On = 10, Off = 9, 11) The condition X==10 only holds true @ 10. The edge cases for when this isn't true is 9 and 11.
3. Other cases I can come up with involve the letter input being too short/long or if it is including whitespaces. Ex: "C ", "CFM", " C".

Part 2
2. Input, combination, output
   * a. Individual Input
     * Null
     * Empty List
     * List w/ size == 1
     * List w/ size > 1
   * b. Combination of input
     * Left or Right contains null
     * Left or Right contains empty list
     * Left or Right contains a list with a single digit within range of 0-9
     * Left or Right contains a list with multiple digits within range of 0-9
     * Left or Right contains a list with digits not within the range of 0-9
   * c. Output
     * Null
     * Empty List
     * A list with either one digit or two (depending on size of the two digits added)
     * A list the size of two or three digits (depending on what digits were added)
     * Throws an IllegalArgumentException

I added extra tests in my code just to show the flip side of certain cases (for example left input null, right input not null vs. left input not null, right input null).

Part 3  
My program didn't really have any bugs, the only "issue" (if you'd even call it that) was with the last test case 
where I tried to get it to throw an IllegalArgumentException. I added a throw exception block of code during 
the Act step, but while writing the Assert step, I referred to the slides from lecture 3 that showed the 
assertThrows option and just decided to go with that.