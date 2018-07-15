# moneytap

A Bitcoin Rate watcher App
Take a pull and do the following
Make sure the JDK version is Java 8 or higher
Do the following-
-->Run the moneytap_database.sql file using pgAdmin editor.It will create a schema called moneytap which contains a table called bitcoin_rate.
---------------
Run the command
---------------
Go inside the bitcoinwatcher folder
and in cmd type
-->mvn clean compile install 

A copy of application is included in the main folder or you can also take it from the resources folder
The database connections and port no can be specified in the application.properties
After this the jar will be generated in the target folder
Go to the target folder and open a terminal here
--------------
Run the command
---------------
-->java  -jar {specify the jar to run here}
The application will start at the specified port 8080
-------------------
Workflow of the API
-------------------
1)A cron scheduler starts running after each 1 minute and call the coindesk api using restTemplate(ssl) in order to get the usd and INR value of the bitcoin per minute in UTC timestamp.
2)After getting the response the cron scheduler inserts the required value into the table bitcoin_rate.
3)
Now to Verify
Service 1 Get average of the bitcoin price wrt to minutes
---------
localhost:8080/moneytap/bitcoin/avarage?minutes=5

This sevices gives the average of the bitcoin price in USD as well as INR value.
------
output
------
{
    "averageBitCoinPriceUSD": 6306.241584449241,
    "averageBitCoinPriceINR": 431956.7142228941
}
Service 2 Get median of the bitcoin price wrt to minutes
---------
localhost:8080/moneytap/bitcoin/median?minutes=4

------
output
-------
{
    "medianBitCoinPriceINR": 436224.294,
    "medianBitCoinPriceUSD": 6368.545
}
---------------
Junit test case
---------------
BitcoinwatcherApplicationTests.class
which tests both the services.
