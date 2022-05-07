# Hibernate learning notes

#### Add maven dependency

#### hibernate
![](images/Screen%20Shot%202022-05-04%20at%201.31.45%20PM.png)

#### postgresql
![](./images/Screen%20Shot%202022-05-06%20at%207.55.09%20AM.png)


#### Steps without Hibernate
![](/images/Screen%20Shot%202022-05-04%20at%204.24.03%20PM.png)
### The Hibernate way
![](./images/Screen%20Shot%202022-05-04%20at%204.34.08%20PM.png)
### Add lombok (optional)
![](./images/Screen%20Shot%202022-05-06%20at%204.21.49%20PM.png)
![](./images/Screen%20Shot%202022-05-06%20at%205.59.32%20AM.png)
>https://mvnrepository.com/artifact/org.projectlombok/lombok-maven-plugin

### Add annotated class to hibernate
![](./images/Screen%20Shot%202022-05-06%20at%206.27.50%20AM.png)
![](./images/Screen%20Shot%202022-05-06%20at%206.28.06%20AM.png)

### create a seesion factory session and user session to save model
![](./images/Screen%20Shot%202022-05-06%20at%206.39.06%20AM.png)
![](images/Screen%20Shot%202022-05-06%20at%209.43.35%20AM.png)

### `@Entity(name="table_name"` vs `@Table(name"table_name")`
![](./images/Screen%20Shot%202022-05-06%20at%209.54.13%20AM.png)

### create a singular name table
![](./images/Screen%20Shot%202022-05-06%20at%209.57.56%20AM.png)

### use column anotation to name db column
![](./images/Screen%20Shot%202022-05-06%20at%209.57.56%20AM.png)

### Hibernate Testing
![](/images/Screen%20Shot%202022-05-06%20at%2011.54.48%20AM.png)
>https://trello.com/c/LjsCTeyj/11-hibernate

#### @Transient
username is not saved in database
![](./images/Screen%20Shot%202022-05-06%20at%209.11.14%20PM.png)
![](./images/Screen%20Shot%202022-05-06%20at%209.12.51%20PM.png)

#### UUID
![](./images/Screen%20Shot%202022-05-07%20at%204.33.11%20AM.png)
![](images/Screen%20Shot%202022-05-07%20at%206.24.57%20AM.png)
>https://thorben-janssen.com/generate-uuids-primary-keys-hibernate/

#### interger Id
![](images/Screen%20Shot%202022-05-07%20at%2010.04.35%20AM.png)


#### value object vs entity object
- value object: has no meaning without other object (address,cart)
- entity object: can exist independently (user, order, product)
- edge case: think about a order can be created by a guest(without register as a user)
- so the order has to be independent from user
![]()
![]()
![]()
![]()
![]()
![]()
![]()