## Farm Class Test Strategy

### Constructor Tests

**Create a Farm object with the default constructor:**

* Verify name is null
* Verify state is initialized with empty predator list
* Verify sheep array is null

**Create a Farm object with the non-default constructor:**

**with valid field values:**

* Valid farm name (non-null, non-empty string)
* Valid state object with predator list
* Valid number of sheep (positive integer)
* Valid number of lambs (positive integer)
* Verify sheep array is properly initialized with correct total size
* Verify correct number of sheep vs lambs in array

**with invalid field values:**

* Null farm name
* Null state object
* Negative number of sheep
* Negative number of lambs
* Zero total animals (both sheep and lambs are 0)

### Test all get methods:

**Test getAlpacaHiringCost():**

* Verify returns correct constant value (500)

**Test getAlpacaMaintenanceCost():**

* Verify returns value within expected range (400-600)
* Test randomness by creating multiple Farm objects

**Test GetFarmName():**

* Verify returns correct farm name
* Test with null name
* Test with empty string name

**Test GetFarmState():**

* Verify returns correct state object
* Test with null state
* Test state contains correct predator list

**Test getName():**

* Verify returns same value as GetFarmName()

**Test getSheep():**

* Verify returns correct sheep array
* Test array length matches constructor parameters
* Verify sheep types (lambs vs adult sheep) are correct

**Test getState():**

* Verify returns same value as GetFarmState()

**Test getValuePerSheep():**

* Verify returns correct constant value (150)

**Test getValuePerLamb():**

* Verify returns correct constant value (250)

**Test getValuePerAlpaca():**

* Verify returns correct constant value (1000)

### Test all set methods:

**Test SetFarmName():**

**with valid field values:**

* Non-null string
* Empty string
* Very long string
* String with special characters

**with invalid field values:**

* Null string

**Test SetFarmState():**

**with valid field values:**

* Valid state object with predators
* Valid state object with empty predator list
* State with different names

**with invalid field values:**

* Null state object

**Test setName():**

**with valid field values:**

* Non-null string
* Empty string
* Very long string

**with invalid field values:**

* Null string

**Test setSheep():**

**with valid field values:**

* Valid sheep array with mixed sheep and lambs
* Empty sheep array
* Array with only sheep
* Array with only lambs

**with invalid field values:**

* Null sheep array

**Test setState():**

**with valid field values:**

* Valid state object
* State with different predator configurations

**with invalid field values:**

* Null state object

### Test Simulation method:

**Test Simulation() with different alpaca counts:**

* Test with 0 alpacas
* Test with 1 alpaca
* Test with 2 alpacas
* Test with negative alpaca count
* Test with very large alpaca count

**Verify simulation results:**

* SimulationResult object is not null
* Total cost calculation is correct
* Animal loss counts are within valid ranges
* Alpaca loss count doesn't exceed input count
* Predator-specific loss tracking is accurate

### Test toString() method:

* Verify string representation includes all relevant fields
* Test with null values
* Test with various field combinations
