# MySQL Setup

Wenn der MySQL User nicht existiert folgendes ausführen:

docker exec -it mydb mysql -u root -p

CREATE DATABASE IF NOT EXISTS basics;
GRANT ALL PRIVILEGES ON basics.* TO 'user'@'%' IDENTIFIED BY 'password';
FLUSH PRIVILEGES;
