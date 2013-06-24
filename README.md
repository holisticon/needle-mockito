# de.holisticon.toolbox:needle-mockito
[![Build Status](https://secure.travis-ci.org/holisticon/needle-mockito.png)](https://travis-ci.org/holisticon/needle-mockito)
## Introduction

The [needle-test-tool](http://needle.spree.de) is very useful when it comes to testing/mocking JEE6 applications. We love it, we use it, we spread it and 
 we contribute. 
 
But needle has a very generic approach, it fits for testng, junit, easymock, mockito, spring, guice, weld, ejb, hsql, h2, ... and we do not need this flexibility.

Our setup is very contstant: JDK6, JBoss AS 7, EJB31, CDI, and when it comes to DB tests, we use h2. So instead of specifiing all concrete components for every project we do, we need a central setup that does all this and can just be included in the test scope. 
 
Apart from wrapping the necessary dependencies and configuring the environment, this package also contains some code extensions that should be included in the needle framework when possible, but that we need right now in our own release cycle.
Those extensions are:

- InjectionProvider factories for concrete instances and @Named instances
- InjectionProvider Set to configure more than one provider in a class
- Builder API for fluent and transparent setup of complex rule configuration
- H2 tools and basic config that are missing in the core framework

### Usage

needle-mockito is released on [maven-repo](http://repo1.maven.org/maven2/de/holisticon/toolbox/needle-mockito/), just set your maven dependencies to:

```xml
...
<dependency>
  <groupId>de.holisticon.toolbox</groupId>
  <artifactId>needle-mockito</artifactId>
  <version>1.0</version>
  <scope>test</scope>
</dependency>
...
```

## Getting started

Use the comprehensice documentation of needle itself to get started, this project merely does slight improvements.

## Contribution

We love to hear your feedback and your ideas.

## Sponsoring
This project is sponsored and supported by [holisticon AG](http://holisticon.de/cms/About/Startseite)

## License
This project is released under the revised BSD License (s. [License](license.txt)).
