## Phone Company Kata

Each day at a Phone Company a batch job puts all the customer calls for the previous day into a single log file of:

'customer id','phone number called','call duration'

For a customer the cost of a call up to and including 3 minutes in duration is charged at 0.05p/sec, any call over 3 minutes in duration the additional time is charged at 0.03p/sec. However, there is a promotion on and the calls made to the phone number with the greatest total cost is removed from the customer's bill.

# Task

Write a program that when run will parse the calls.log file and print out the total cost of calls for the day for each customer. You can use any libraries you wish to.


# Tech Stack

- Scala
- ScalaTest

# How to run application.

- `cd` into root of application
- Type `./sbt run`

# To run unit test

- `cd` into the root of the application
- Type `./sbt test`