# Minimal example for Apache Kafka real-time processing 

[Apache Kafka](https://en.wikipedia.org/wiki/Apache_Kafka) is a well-known messaging system which as key features comprises "real-time" processing (meaning very low latency) and high throughput. It is nonetheless a complex solution to master that needs fine-tuning in order to maximize the performance on a given technical need. We can think of [IoT](https://en.wikipedia.org/wiki/Internet_of_things) as an example of application, if for instance you want a real-time processing of data sent by the connected device.

In order to run this program, you need a local version of [Apache Kafka](https://kafka.apache.org/downloads) (see "Binary downloads") and Zookeeper which is used by Apache Kafka to manage its brokers, it is actually included in the binaries downloaded on the Apache website.

This program is composed of two executable files, one is a Producer and one is a Consumer. The Producer side will send 100 messages to a topic in Apache Kafka and the Consumer will read the messages and display them in the output console.

On Windows you need to replace two configuration variables in order for Apache Kafka to store properly its data : 
- In zookeeper.properties, seek the dataDir property and replace with --> `dataDir=kafka-data`
- In server.properties, seek the log.dirs property and replace with --> `log.dirs=kafka-logs`


## How to use (on Windows) : 
1) Run `zookeeper-server-start.bat` and give it the zookeeper.properties file as argument which will start the ZooKeeper server.
2) Run `kafka-server-start.bat` and give it server.properties file as argument
3) Create a topic by running the command : `kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic myTopicName`
4) Check if the topic was created by running : `kafka-topics.bat --list --bootstrap-server localhost:9092`
5) Execute the consumer JAR file with `java -jar` command and then the producer.
6) Run `kafka-server-stop.bat` then `zookeeper-server-stop.bat` to stop Apache Kafka