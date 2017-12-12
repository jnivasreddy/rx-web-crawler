# Sample web crawler using RxJava & JSoup library 

This is sample webcrawlewr application developed using functional programming, technologies used Java8, RxJava and Jsoup library ( Is a Java based library to parse HTML content)

##Prerequisites
* **_JDK 8_** - Install JDK 1.8 version from, http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* **_Gradle ** - Download latest version of gradle from https://gradle.org/install/


##Installation

###Building & run Application

clone repository using following command

```
git clone https://github.com/jnivasreddy/rx-web-crawler.git
```

run following command to build application

```
gradlew clean build
```

open cmd prompt and move to current installation directory and run following command to start application 

```
java -jar ./build/libs/rx-web-crawler-0.1.0.jar
```

#### REST API
api specificaiton has been detailed in document api-specification.txt

Method | URI | Description
--- | --- | --- | --- | --- | ---
`POST` | */crawler/search/ | crawler for specificaiton domain


## What could be done with more time

implement in-memory cache for saving processed URLs instead of HashMap & ConcurrentHashMap 