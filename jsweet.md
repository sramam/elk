# Experiment to use jsweet and transform elk to TypeScript

[`elkjs`](https://github.com/kieler/elkjs) seems like an excellent library for automated graph layout needs in JS/TS.

However, from js/ts/node-land, it's hard to grok and difficult to make contributions to a project that uses 
java. 

This ia an experiment to see if [`jsweet`](http://www.jsweet.org) can be used to transpile the java source to 
typescript. Since this is a source-to-source translation,
the hope is that changes will be easier to make and merge
upstream.

Not being a java person, I needed to document each step, 
so I won't forget them later. This is that record.

## Prerequisites
The [`jsweet prerequisites`](http://www.jsweet.org/getting-started/):

 - git
 - JDK 1.3+ 
 - [Maven (3.8.4 used here)](https://www.baeldung.com/install-maven-on-windows-linux-mac)
 - [node](https://nodejs.org/en/) (which bundles `npm`)
 
```
git clone https://github.com/sramam/elk
# this has modifications to build/pom.xml
cd elk
mvn package -f build/pom.xml
mvn generate-sources -f build/pom.xml
```