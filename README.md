# CityGo
Microservices

Alisher Ayupov IS1814R
Mikhalko Abdrasul IS1814R
Semeikhan Alibi IS1814R

## Project information

The platform is a social network for the development of knowledge about the city, by passing tests and puzzles through locations with an interesting story. The aim of each user is to get a prize after completing such a test, a thirst to solve the puzzle and get to know the city better and have more knowledge about it. The aim of the company is to attract advertising through our platform, thanks to a non-trivial way to attract the audience. Its mission is to introduce people to beautiful places, cultural, historical, and architectural attractions of the city (through puzzles and quests), as well as city services (stores, cafes, restaurants).

## Service for authorization.

The authorization service will provide registration and authorization functions. That is, in order to take part in solving riddles, you will need to register and authorize when you open the site on a new device. Registration and authorization are important in our project because users upload their photos and personal information to the platform in order to win prizes. But at the same time, they might want to hide their ratings on the site, photos, or just change/update information about themselves in order to get a prize without problems. To register, the user needs a mail, phone number, name and nickname that will be visible to all users in the ratings, etc. For authorization he will be able to use one of the above values and enter a password. Passwords in our system will be stored in a database in encrypted form through hash encryption, we will also use libraries with different encoders, which will provide us more security. Even if our database gets opened, they won't be able to pick up passwords, because hash encryption has no reverse encryption, and it works by comparing passwords. And also, the user will have to use at least 8 characters in the passwords, while necessarily including uppercase, lowercase, symbols, as well as numbers, so the range of possible passwords will be wider, and if you add to this several levels of encryption, the system will be very resistant to passwords.
Also, this microservice will give access to change the password or any other information by the user, as well as to delete the account.

## Challenge Service.

Its essence is to create, store, modify, publish, and display challenges. As well as the service on the structure of the processing of the terms of reference from the partner, this service is responsible for the challenge, but only for the already active. Challenges will consist of a "folder" that contains text, photo or video content, a link, and an interactive thing to start execution. You can modify this challenge as you go along, keep it among the active Challenges, and close or delete it when the Challenges expire. It will also use a database for the Challenges, which stores lists of Challenges, lists of inactive or archived Challenges, and lists of participants and their decisions. Each solution will be checked under the conditions of the contest challenge and depending on the essence of the task will be given prizes either to all users who solved the puzzle, or only a certain number who did it first, or solved this puzzle the right way, without alternative solutions. This will help to identify the winners faster and give them prizes. These will be given out by personal communication to each winner, and providing the deserved prize, either by link or, in the case of a physical prize, by delivery.

## User Service.

The service for gaining access to information about users will have a function that will include such features as getting a nickname, email, phone number by ID or by other parameters. That is, it is a service for finding information on clients. Also, this service will be able to receive a list of customers, which of course will be convenient for compiling ratings, or simply for finding the coincidence of nicknames during registration, etc. The service will have full control over customer information, help the customer update information, and so on. A separate database will store all this data and define the ID of the user as the key parameter of the database.

## Email Service.

The service need for send messages via email. This service we can used in place-service and guilds-service.

## Place Service.

Place service used for creation places. User can share intresting place and our application will draw it in list.

## Guild Service. 

This service has information about different organization. With this service user can find people that has same interests.

## Diagram.
![image](https://user-images.githubusercontent.com/63921220/146836371-1d20248d-85e4-4294-bdae-ff91205f7504.png)


