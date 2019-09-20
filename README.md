# DataBasePostgreSQL
PostgreSQL + hibernate

Есть класс User:

class User {
 int id;
 String name;
 int age;
}

id - autoincrement
Взять тот же интерфейс Storage что и в предыдущем задании, и написать реализацию с использованием базы данных(на выбор DJBC/Hibernate, H2/Postgress/Mysql):


- void removeAll()

- void removeUser(int id)

- void removeUserByName(String name)

- void addUser(User user)

- void updateUser(User user)

- User getUser(int id)

- List<User> getAllUsers()



Продемонстрирвоать работу всех методов.
