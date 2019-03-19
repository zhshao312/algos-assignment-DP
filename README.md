# Dynamic Programming Assignment

First, instructions:
* git fork this repository to your own github account, then clone it from there
* work on the java files in your preferred editor + compiler
* put your writeups + drawings to all problems in a file titled YourName_DP_Writeup.pdf
* created a pull request from your fork to this original version


## 1. Falling Glass

You are the designer and inventor of a shock-proof landing mat that could catch the fall of glass from a certain height. You want to guarantee that up to a certain number of floors, the glass will not break. You need to calculate that highest floor X where the glass will not break, but you only have a set amount of glass panes.

### Notes:
* A glass sheet that survives the fall can be used again in another trial.
* The glass sheets are uniform, so results will not vary between them.
* A shattered glass sheet has to be swept up and thrown away.
* If glass shattered when it hits the mat, then it would shatter if dropped from a higher floor too.
* If glass survives a fall then it would survive a shorter fall.
* There’s no guarantee that the glass falling from the first floor window will break, nor that the glass thrown from (last) nth-floor does not break.

If only one glass sheet is available and we want to be absolutely sure of getting the right result, we can only try from the first floor and move up one by one. In the worst case, we would try all the floors. But what if you had 2, or just some general m number of sheets?

#### Given: n floors, m glass sheets
#### Find: What’s the minimum amount of trials?

(The problem is not actually to find the critical floor, but just to decide floors from which glass sheets should be dropped so that total number of trials are minimized.)

##### (a) Describe the optimal substructure/recurrence that would lead to a recursive solution
#### (b) Draw recurrence tree for given (floors = 4, sheets = 2)
#### (c) Code your recursive solution under GlassFallingRecur(int n numFloors, int m numGlass)
#### (d) How many distinct subproblems do you end up with given 4 floors and 2 sheets?
#### (e) How many distinct subproblems for n floors and m sheets?
#### (f) Describe how you would memoize GlassFallingRecur
#### (g) Code a bottom-up solution GlassFallingBottomUp(int n numFloors, int m numGlass)

#### Turn in: A pdf write-up of parts: a, b, d, e, f with good explanations! Coding parts c, g in the file GlassFalling.java
