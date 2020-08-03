# Postgresql CRUD operations

Working with the Postgresql database and basic functions **Create + Read + Update + Delete (CRUD).** Functions are performed through SQL requests. For communication between the database and Java classes, the technology is used Hibernate.

### Task

Implement an interface with methods:

- void removeAll()

- void removeUser(int id)

- void removeUserByName(String name)

- void addUser(User user)

- void updateUser(User user)

- User getUser(int id)

- List<User> getAllUsers()

### Tech

* Postgresql;
* Hibernate;
* SQL.

### Result

**1. (C)** After creating the users table in the database itself using the SCL command [Script](https://github.com/bbogdasha/postgresqlCRUD/blob/master/Script.sql), the first step is to create new users in the database:

```java
        userDao.addUser(new User("Bob",24));
        userDao.addUser(new User("Masha",26));
        userDao.addUser(new User("Tommy",19));
        userDao.addUser(new User("Alex",18));
        userDao.addUser(new User("Viki",22));
        userDao.addUser(new User("Ana",27));
        userDao.addUser(new User("Alex",33));
        userDao.addUser(new User("Poul",41));
```
Result in database:

![Screenshot](https://github.com/bbogdasha/postgresqlCRUD/blob/master/screenshoots/Screenshot_1.jpg)

**2. (R)** The second action is the output of information requested for different parameters (id, name, all). 

```java
        userDao.getUserById(2);
        userDao.getUserByName("Alex");
        userDao.getAllUsers();
```

Result:

![Screenshot](https://github.com/bbogdasha/postgresqlCRUD/blob/master/screenshoots/Screenshot_2.jpg)

**3. (U)** Third step - updating user data. 

```java
        User user = userDao.getUserById(2);
        user.setAge(37);
        user.setName("Moa");
        userDao.updateUser(user);
        userDao.getUserById(2);
```

Result: 

![Screenshot](https://github.com/bbogdasha/postgresqlCRUD/blob/master/screenshoots/Screenshot_3.jpg)

**4. (D)** And the last operation to delete users with different parameters (id, name, all). 

```java
        userDao.removeUserById(2);
        userDao.removeUserByName("Alex");
```

Result:

![Screenshot](https://github.com/bbogdasha/postgresqlCRUD/blob/master/screenshoots/Screenshot_4.jpg)

In the end, after all the operations with the database, we will get the following result:

![Screenshot](https://github.com/bbogdasha/postgresqlCRUD/blob/master/screenshoots/Screenshot_5.jpg)
