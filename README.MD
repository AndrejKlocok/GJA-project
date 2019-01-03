# GJA Project
This project helps new students of subject GJA to understand basics of Java frameworks.
# JPA_Hibernate
This demo uses mysql database. In order to launch this demo you need to create
user, tables and init database. This is done by script located in root directory (dbMysql.sh) . 
You need pass root password to this script so it can init db.

Also glassfish server the newest version.

# Run
This example was tested in IntellijJ with oracles jdk 1.8 and glassfish 4.1.2.
In JPA_Hibernate demo we use Mysql database, so in order to run these examples you
need to have latest Mysql.

inicializácia databáze pomocou skriptu dbMysql.sh
mvn package a následne nasadenie na aplikačný server (alebo cez IDE)
 

* initialization using script dbMysql.sh
* mvn package and upload .war on application server (or using IDE)

eventually manual deploy of domain through command line through command line:
*    $ ./bin/asadmin start-domain domain1
*    $ ./bin/asadmin deploy path/to/GJA_Lectures-1.0-SNAPSHOT.war