# CityGo
Microservices

Alisher Ayupov IS1814R
Mikhalko Abdrasul IS1814R
Semeikhan Alibi IS1814R

##Project information

The platform is a social network for the development of knowledge about the city, by passing tests and puzzles through locations with an interesting story. The aim of each user is to get a prize after completing such a test, a thirst to solve the puzzle and get to know the city better and have more knowledge about it. The aim of the company is to attract advertising through our platform, thanks to a non-trivial way to attract the audience. Its mission is to introduce people to beautiful places, cultural, historical, and architectural attractions of the city (through puzzles and quests), as well as city services (stores, cafes, restaurants).

##Service for authorization.

The authorization service will provide registration and authorization functions. That is, in order to take part in solving riddles, you will need to register and authorize when you open the site on a new device. Registration and authorization are important in our project because users upload their photos and personal information to the platform in order to win prizes. But at the same time, they might want to hide their ratings on the site, photos, or just change/update information about themselves in order to get a prize without problems. To register, the user needs a mail, phone number, name and nickname that will be visible to all users in the ratings, etc. For authorization he will be able to use one of the above values and enter a password. Passwords in our system will be stored in a database in encrypted form through hash encryption, we will also use libraries with different encoders, which will provide us more security. Even if our database gets opened, they won't be able to pick up passwords, because hash encryption has no reverse encryption, and it works by comparing passwords. And also, the user will have to use at least 8 characters in the passwords, while necessarily including uppercase, lowercase, symbols, as well as numbers, so the range of possible passwords will be wider, and if you add to this several levels of encryption, the system will be very resistant to passwords.
Also, this microservice will give access to change the password or any other information by the user, as well as to delete the account.
