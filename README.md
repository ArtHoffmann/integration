# MySQL Setup

Wenn der MySQL User nicht existiert folgendes ausführen:

docker exec -it mydb mysql -u root -p

CREATE DATABASE IF NOT EXISTS basics;
GRANT ALL PRIVILEGES ON basics.* TO 'user'@'%' IDENTIFIED BY 'password';
FLUSH PRIVILEGES;

Anleitung:
https://developers.redhat.com/articles/2023/07/24/how-integrate-spring-boot-3-spring-security-and-keycloak#install_keycloak

# How to start keycloak:
1. Install
2. docker pull keycloak/keycloak
3. Run
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=password keycloak/keycloak start-dev



# nx generate angular project files

generate authguard:
    
npx nx generate @nrwl/angular:guard auth --project=shopify-sevdesk

generate component:

nx g @nx/angular:component login --project=shopify-sevdesk
