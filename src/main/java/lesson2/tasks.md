
### Requirements
1. First define a length calculate class
2. It could calculate the length with a input formula with different length units
3. The input formula likes `1m / 4 + 10cm * 3 - 5mm`

### Task
1. Define a formula class to persist the formula with a list inside.  The value in this list are objects which could be number or operator.
2. Define the length units and operator stuffs.
3. Define another Calculator class to compute the formula instance.
4. The Calculator could return the value in specified format.


### Equal
1. the same values with different length units should be equal
2. the same values with same length units should be equal
3. the different values with same length units should not be equal
4. the different values with different length units should not be equal