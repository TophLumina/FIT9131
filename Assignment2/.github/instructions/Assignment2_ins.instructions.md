# **Specification**

For this assignment you will write a program to evaluate the viability of employing alpacas to protect flocks of sheep on farms in Australia. First we will give some background and then specify the required functionality of the program.

## **Background**

Sheep farming is a major agricultural industry in Australia, making the country one of the world's leading producers of wool and lamb meat. Sheep farms are spread across the southern part of Australia in the states of New South Wales (NSW), Victoria (VIC), South Australia (SA), and Western Australia (WA). The types of farms vary from small intensive farms on rich pastures to extensive grazing on vast rangelands.

A major problem facing sheep farms in Australia is predators such as foxes, dingos, feral pigs and wedge-tailed eagles, with different levels of predators in each state. One practice, which is becoming increasingly popular, is the use of alpacas as guardians to protect the sheep from these predators. Alpacas are territorial animals with a strong herd instinct. They integrate well into sheep flocks and their mere presence can deter predators. Alpacas are alert to danger and will often position themselves between potential predators and the sheep. Using alpaca guards can greatly reduce losses of young lambs. Another benefit is that sheep that are free from the threat of predators are less stressed, which can lead to better growth rates and improved wool production. A single alpaca can guard up to 100 sheep. However, alpaca sheep guards work best in pairs and two alpacas are usually recommended to guard a flock.

Although alpacas are effective in reducing sheep loss, they are expensive to buy or hire, and maintain. They need food, veterinary care, and shearing, which is a cost to farmers. To understand more about the viability of using alpacas to protect their sheep, farmers would like some more information.

In this assignment you will write a computer program (Alpaca Sheep Guards) to help assess the viability of using Alpaca guards for protection for sheep flocks in four Australian states (NSW, VIC, SA, and WA). This will be done as a simulation with different levels of Alpaca protection.

The program will provide estimates for the cost for no protection, single alpaca, or pairs of alpaca protection. The cost will include the estimated stock losses plus the cost of alpaca maintenance. The farmer will then be able to choose the most effective option for their farm

## **Alpaca Sheep Guards Program**

The program will run three simulations, one for each level of alpaca protection:

1. no alpaca protection
2. single alpaca protection
3. pair of alpacas protection

To get an accurate estimate for each level of protection, each simulation will run 10 times, each time calculating a total cost, which will be the value of animals lost from predators plus the maintenance cost of any alpacas used). At the end of the 10 runs,  the lowest and highest cost and the average of 10 total costs will be reported.

At the end of the three simulations the relative costs of each protection level will be reported for the farmer to choose the most viable protection level.

**Program start up**

The program begins by displaying a brief welcome message.

The probability of a sheep death from each type of predator in each state is read from the file  *predators.txt* . The file will contain four lines each representing a state in Australia. In each line there will be a name of the state and four comma separated double numbers, each representing a danger factor of a predator in that state. These will be in the order: fox, dingo, feral pig, wedge-tailed eagle. There is no other reading from the file during the actual running of the program.

The program creates a collection of states. Each state will have:

* a name
* a collection of predators

The user is prompted for:

* the name of their farm (the name must be 6 characters or more)
* the state where the farm is located (NSW, VIC, SA, or WA)
* the flock profile
* * number of sheep
  * number of lambs (note that the term ‘sheep’ will be used for adult sheep and ‘lambs' will be used for the baby sheep)

    Note:  the total number of sheep plus lambs must be greater than 0 and no greater than 100

**Specific actions for each simulation**

Each of the 10 runs of a simulation will involve the following actions:

*1. Determine the stock lost through predators*

* With no protection, each sheep has a probability of being killed by each type of predator according to the danger factor read from the *predators.txt* file.
* Each lamb has twice the probability than a sheep of being killed.
* With a single alpaca guarding the flock, the probability of death for lambs and sheep is halved.
* With a pair of alpacas guarding the flock, the probability of death for lambs and sheep is reduced to a quarter.
* The death of an alpaca by a predator is a rare event. The probability is one hundredth of the probability of a sheep death by each type of predator.

  With each death the animal status changes from 'live' to 'dead' and the type of predator responsible is recorded.

*2. Calculate the total value of stock lost*

The total value of stock lost is the sum of:

* number of sheep lost * $150 (value of one sheep)
* number of lambs lost * $250 (value of one lamb)
* number of alpacas lost * $1,000 (value of one alpaca)

*3. Calculate the hiring and maintenance costs for alpacas*

The hiring cost of alpacas is $500 per year. The maintenance cost varies from $400-$600, with each amount between 400 to 600 equally likely. Note: if an alpaca dies then the hiring cost still applies but the maintenance costs are halved.

*4. Calculate the total cost of alpaca protection*

The total cost of protection is the total value of animals lost plus the maintenance cost of alpacas.

**Specific actions at the end of each simulation**

At the end of the 10 rounds the following are displayed on the screen:

* average total cost
* lowest total cost
* highest total cost
* average numbers of each animals lost
* average numbers of animals killed by each type of predator

**Specific actions at the end of the three simulations**

At the end of the simulations of the three protection levels, the following is reported.

* The recommended level of protection, which will be the protection level with the lowest  *average total cost* .
* The most troublesome predator, the predator that killed the highest *average numbers of animals*  for the recommended level of protection.
* The names of any predators that did not kill any animals for the recommended level of protection.

A summary is written to the file  *alpacaSheepGuardViability.txt* . The details written to the file are:

* farm name
* number of sheep
* number of lambs
* recommended level of protection and cost
* predicted number of animals lost for the recommended level of protection
* most troublesome predator for the recommended level of protection

## **Program and Class Design**

The design of the program will be discussed in your Applied Class in Week 9. It is important that you attend this class.

# **Important Notes**

* Your program must demonstrate your understanding of the object-oriented concepts and general programming constructs presented in FIT9131. Consider carefully your choice of classes, how they interact and the fields and methods of each class. You must use appropriate data structures to store the various objects in the program. You must make use of **both Arrays and ArrayLists** in your program. Make sure that you discuss your design with your tutor. You must document any additional assumptions you made.
* You will be required to justify your design and the choice of any data structures used at the interview.
* Validation of values for fields and local variables should be implemented where appropriate. You should not allow an object of a class to be set to an invalid state (i.e., put some simple validations in your mutator methods).
* Your program should handle incorrect or invalid input and present the user with relevant error messages. No invalid input should crash the program.
* Exception handling should be used where appropriate.

# **Assessment**

Assessment for this assignment will be done via an **interview** with your tutor. The marks will be allocated as follows:

* 10% - Progress of test strategy and code development, as shown via Ed workspace environment. Your tutor will assess your work during your applied session in weeks 10 and 11.
  * 5% in week 10 for the **Farm** class and its **test plan** (i.e., a list of tests)
  * 5% in week 11 for a draft of the **class diagram** and two further classes, which must be a **FileIO** class and another class which is a *client* class (please see Lesson 8.1.2 for an explanation of client class). Note that the class diagram should show the individual classes and the interactions between the classes but does not need to include the details within the classes.
* 10% - Test strategy for the **Farm** class, the class which holds the details of a Farm. For the test strategy you are only required to provide details of tests for the constructors, the toString/display method, and one *get* and one *set* method. Also, for the non-default (parameterised) constructor and the *get* and *set* methods just one positive and one negative test are required.
* 10% - Class diagram, Java code quality and object-oriented design quality. This will be assessed on code quality (e.g., compliance with coding standards, including JavaDoc) appropriate design and implementation of classes, fields, constructors, methods, and validation of the object’s state.
* 10% - Program functionality in accordance to the requirements.
* 60% - Oral assessment.

Note that it is not a requirement that you use polymorphism and inheritance concepts in this assignment, but incorporating these concepts will enhance your chances of achieving a high distinction (HD) grade.

A reminder that you must use the workspace environment in the Ed platform (opposite this assignment specification) to code all parts of your program. You must not copy and paste large sections of code from other sources, and you must acknowledge *any* code in your assignment that has been taken from other sources.

Marks will be deducted for untidy/incomplete submissions.

You must submit your work by the submission deadline on the due date (a late penalty of 5% per day, inclusive of weekends, of the possible marks will apply). There will be no extensions - so start working on it early.

All submitted source code must compile. Any submission that does not compile, as submitted, will receive a grade of ‘N’.

## **Oral assessment**

As part of the assessment you will attend an interview following the submission date. At the interview, you will be asked questions about your code. You will asked to explain your code/design, modify your code, and discuss your design decisions and alternatives. Marks will be awarded for your answers (the marker may also delete excessive in-code comments before you are asked to explain that code).

In other words, you will be assessed on your understanding of the code, and not on the actual code itself.

Interview times will be arranged in the applied classes in Week 12 and will take place on campus during the following week.

It is your responsibility to make yourself available for an interview time. **Any student who does not attend an interview will not receive a pass grade for the assignment.**
