# Norwegian sea vessels tracker - backend
### Link to web application: [http://vesseltracker.pl/](http://34.118.67.174/)
#### Link to frontend of this app: [https://github.com/byko-dev/vessel_tracking_react](https://github.com/byko-dev/vessel_tracking_react)

#### How to deploy this web application
1. Build war project
2. Configure docker on server
    - install docker and docker-compose 
      - `apt install docker.io`
      - `apt install docker-compose`
    - pull images
      - `docker pull tomcat`
      - `docker pull postgres`
    - create docker-compose.yml
      - `docker-compose up -d`
3. Set up spring boot application on tomcat server => /manager/html
    
      



#### Public free apis i used: 
- [Ais vessel tracking => https://www.barentswatch.no/](https://www.barentswatch.no/)
- [Weather api => https://weatherstack.com](https://weatherstack.com)
- [Geolocation data => https://positionstack.com/](https://positionstack.com/)

#### Application endpoints
1. [/vessels/data](http://34.118.67.174/api/vessels/data)
    - method = `GET`
    - returns json with details about weather in local port
3. [/local/weather](http://34.118.67.174/api/local/weather)
    - method = `GET`
    - returns json with all updated vessels tracking data

#### Technologies used:
1. PostgreSQL
2. Docker, docker-compose
3. Spring boot, Hibernate

#### `docker-compose.yml` file
```
version: '3.5'
services:
  postgres:
    container_name: postgres
    image: postgres
    restart: always
    volumes:
      - /home/byko_dev/docker/db:/var/lib/postgresql/data
    networks:
      - vessels_network
    ports:
      - 5432:5432
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: mysecretpassword
      POSTGRES_DATABASE: vessels
    hostname: postgres
  tomcat9:
    container_name: tomcat
    restart: "no"
    image: tomcat:v2
    volumes:
      - /home/byko_dev/docker/tomcat9:/usr/share/tomcat9
    networks:
      - vessels_network
    ports:
      - 80:8080
    tty: true
networks:
  vessels_network:
    name: vessels_network
    driver: bridge
```

`Developed by byko-dev 2021`
