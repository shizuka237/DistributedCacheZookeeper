# DistributedCacheZookeeper
Implimentation of  In memory Distrubuted caching system  using Zookeeper


# Environment

* version : Java 1.8

#System requirements

* hadoop/ Zookeer up and running

## Getting Started

### Project structure

```
src
|-- main
|   |-- java
|   |   |-- META-INF
|   |   |-- app
|   |   |   |-- CacheController.java
|   |   |   |-- ExpireKey.java
|   |   |   |-- GetKeyController.java
|   |   |   |-- MainApplicationClass.java
|   |   |   `-- SetKeyController.java
|   |   `-- zooKeeper
|   |       `-- ZooMap.java
|   `-- resources
|       `-- META-INF
|           |-- MANIFEST.MF
|           `-- spring.factories
`-- test
    `-- java

* src directory contains the Java source files containing:
    * main.java.MainapplicationClass.java : entry point for the application
    * main.java.CacheController.java : Spring Controller for "/" route
    * main.java.SetKeyController.java : Spring Controller for GET  "/GET/{key}" route
    * main.java.GetKeyController.java : Spring Controller for  POST "/SET" route
    * main.java.ExpireKey.java : Spring Controller for  POST "/EXPIRE/{key}" route

    *main.ZooKeeper: Contains implementation of distributed map using ZookKeeper class

    *resources folder containds META infro and sping factory settings


```


### Building

```
git clone https://github.com/shizuka237/DistributedCacheZookeeper.git

cd DistributedCacheZookeeper

mkdir target

mvn package

```


### Running

```
java -jar target/DistCaching-1.0-SNAPSHOT.jar --server.port=8081

```


### Testing Distributed Cache using zookeeper

 * RUN 3 parallal instances of server

 ```
 java -jar target/DistCaching-1.0-SNAPSHOT.jar --server.port=8080

 java -jar target/DistCaching-1.0-SNAPSHOT.jar --server.port=8081

 java -jar target/DistCaching-1.0-SNAPSHOT.jar --server.port=8082

 ```

 * you can use curl and Postman to SET/ GET/ EXPIRE API's , we have tested following scenarios
      1. SET Key by request to one server, GET the same key from another server.
          ![SET A KEY IN SERVER localhost:8080](https://github.com/shizuka237/DistributedCacheZookeeper/blob/master/screenshots/SET_KEY.png){:height="400px" width="400px"}
          
          ![GET THAT KEY IN SERVER localhost:8082](https://github.com/shizuka237/DistributedCacheZookeeper/blob/master/screenshots/GET_AFTER_SET.png){:height="400px" width="400px"}

      2. SET key from one server , Sutdown that server, GET same key from another alive server.
          ![EXPIRE A KEY IN SERVER localhost:8081](https://github.com/shizuka237/DistributedCacheZookeeper/blob/master/screenshots/DEL_KEY.png){:height="400px" width="400px"}
          
          ![GET THAT KEY IN SERVER localhost:8082](https://github.com/shizuka237/DistributedCacheZookeeper/blob/master/screenshots/GET_AFTER_DEL.png){:height="400px" width="400px"}

