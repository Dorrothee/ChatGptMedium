# AI-assisted Software Engineering. Java. Practical Tasks

## Task with middle level complexity

## Description
Build a RESTful API for a movie database using Spring Boot,
Hibernate, and a non-relational database like MongoDB or Cassandra.
The API should allow users to perform CRUD operations on movies, actors, and directors.
Movies should have a title, release date, runtime, and a list of actors and directors.
Users should be able to search for movies by title or release date.
Use Spring Data to access the database.

### Running the program
1. Clone this repository:
   ```sh
   git clone https://github.com/your-username/repository-name.git
2. Install MongoDB (if not installed). Create a database, a user and grant them privileges:
3. Change application properties as you want to have your application and database be named. Set free port for the server.
4. Install Postman (if not installed). Create a new collection. Create 5 requests for each entity (Movie, Actor, Director):
- GET to get all the instances of specific entity
- GET to get a specific instance of entity
- POST to add a new instance of entity
- PUT to be able to update a specific instance of entity
- DELETE to delete a specific instance of entity
5. Run the MovieapiApplication.
6. Open Postman and send different requests.
7. Stop the MovieapiApplication.
8. [Optional] Check the correctness of the program by visiting the page of the server.

> **Feedback**
> - Was it easy to complete the task using AI?
    > Not enough. This time AI gave quite controversial answers, so that I had to either rewrite prompts or change them completely and send in a new chat.
> - How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics)
    > About two hours.
> - Was the code ready to run after generation? What did you have to change to make it usable?
    > No, it was not ready to run after generation. Some pieces of code were incomplete and erroneous. I had either to ask AI to provide me with more detailed code or adjust
    > the code in the IntelliJ using its hints.
> - Which challenges did you face during completion of the task?
    > The main challenge I noticed was AI's suggestions using deprecated pieces of code and wrong configurations for the MongoDB database.
> - Which specific prompts you learned as a good practice to complete the task?
    > A good practice to complete the task is to provide a detailed prompt with the task description, working environment and required tools to complete the task.
    > In addition to that, providing the code you work with gives a better idea of your work to the AI.
