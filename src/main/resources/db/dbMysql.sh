#!/usr/bin/env bash
echo "Please enter root password to Mysql in order to init GJA db and test user"

read -s rootpasswd

mysql -uroot -p${rootpasswd} -e "CREATE DATABASE IF NOT EXISTS GJA;"

# Create standard user and grant permissions
#if !  mysql --raw --batch -uroot -p${rootpasswd} -e  "SELECT COUNT(*) FROM mysql.user WHERE user = 'user69';" -s &> /dev/null; then
    echo "Creating database user ..."
    mysql -uroot -p${rootpasswd} -e "CREATE USER user69 IDENTIFIED BY 'heslo';"
    mysql -uroot -p${rootpasswd} -e "GRANT ALL PRIVILEGES ON GJA.* TO 'user69';"
	mysql -uroot -p${rootpasswd} -e "FLUSH PRIVILEGES;"
#else
#    echo "Database user already created. Continue ..."
#fi

# init db
mysql -uroot -p${rootpasswd}  'GJA' < init.sql