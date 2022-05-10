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

### relationships
#### @OneToMany
 * always add foreign key at the many side.
 * one user has many addresses
 * on the many side: addresses side add the foreign key user.id
 * one-side (user)
![](./images/Screen%20Shot%202022-05-07%20at%207.45.01%20PM.png)
* to-many-side (address)
![](./images/Screen%20Shot%202022-05-07%20at%207.47.44%20PM.png)
![](./images/Screen%20Shot%202022-05-07%20at%208.52.09%20PM.png)
![](/images/Screen%20Shot%202022-05-07%20at%208.51.41%20PM.png)

#### Add two addresses to one user
![](./images/Screen%20Shot%202022-05-08%20at%209.13.35%20AM.png)
![](./images/Screen%20Shot%202022-05-08%20at%209.15.53%20AM.png)

### Bidirectional @OneToMany
#### @OneToMany(mappedBy = "customer") 
1.  ***the relationship is on the other side (address-side)***
2.  ***the foreign key is on the other side (address-side)***
3.  ***many addddreses belong to one customer***
* Customer
  customer has the `getAddresses()` to access the addresses list
![](/images/Screen%20Shot%202022-05-08%20at%2010.26.50%20AM.png)
![](./images/Screen%20Shot%202022-05-08%20at%2010.13.07%20AM.png)


#### @ManyToOne
#### @JoinColumn(name = "customer_id") - foreign key name in the address table
* Address
  address has `setCustomer()` and `getCustomer()` to access the customer object
![](./images/Screen%20Shot%202022-05-08%20at%2010.22.58%20AM.png)
![](./images/Screen%20Shot%202022-05-08%20at%2010.13.30%20AM.png)

### Unidierctional @OneToMany
* Customer
  customer object has `getAddresses()` to access the addresses list
![](./images/Screen%20Shot%202022-05-08%20at%2010.33.03%20AM.png)
* Address
  address object knows nothing about the the customer object. it does not know which customer itself belongs to.
* database
  the database schemas are same for both `Bidirectional` and `Unidirectional` `One-To-Many` 

![](/images/Screen%20Shot%202022-05-08%20at%2010.33.41%20AM.png)
![](./images/Screen%20Shot%202022-05-08%20at%2011.04.44%20AM.png)

### Unidierctional vs Bidirectional
It's only from the hibernate...ORM, database schema, does not change. which one to use, it depends one, the user story.
* if user story need to check all the users use one specific address, then we need to add both @OneToMany for the customer side, and add @ManyToOne to the address side.

### CRUD
#### READ
![](/images/Screen%20Shot%202022-05-08%20at%2012.27.34%20PM.png)

#### Lazy vs Eager(customer side)

##### fetch = FetchType.LAZY
* lazy: only when we need to access the address object(`customer.getAddresses()`), it will be loaded from the database.
![](/images/Screen%20Shot%202022-05-08%20at%2012.48.51%20PM.png)
![](/images/Screen%20Shot%202022-05-08%20at%2012.48.23%20PM.png)

#### fetch = FetchType.EAGER
* eager: load the address object when the customer object is loaded
![](/images/Screen%20Shot%202022-05-08%20at%2012.49.18%20PM.png)
![](/images/Screen%20Shot%202022-05-08%20at%2012.49.39%20PM.png)
#### Proxy
![](/images/Screen%20Shot%202022-05-08%20at%201.29.09%20PM.png)

### @OneToOne
#### 1. Unidirectional @OneToOne
(cart_id is the foreign key in the customer table)
* add cart to hibernate configuration
![](./images/Screen%20Shot%202022-05-08%20at%205.07.02%20PM.png)
* add one-to-one relationship in the Customer class
![](/images/Screen%20Shot%202022-05-08%20at%205.07.27%20PM.png)
* add cart to customer
![](/images/Screen%20Shot%202022-05-08%20at%205.07.55%20PM.png)
* database cart as a foreign key in the customer table
![](/images/Screen%20Shot%202022-05-08%20at%205.06.46%20PM.png)

#### 2. Bidirectional @OneToOne
(customer_id is the foreign key in the cart table)
* add one-to-one relationship in the Customer class
![](/images/Screen%20Shot%202022-05-08%20at%205.26.28%20PM.png)
* add one-to-one relationship in the Cart class
![](/images/Screen%20Shot%202022-05-08%20at%205.26.39%20PM.png)
* add cart to customer
![](/images/Screen%20Shot%202022-05-08%20at%205.27.04%20PM.png)
* database customer_id as a foreign key in the cart table
![](/images/Screen%20Shot%202022-05-08%20at%205.25.56%20PM.png)

### @ManyToMany
* one cart has many products
* one prouct can be in many carts
#### 1. Unidirectional @ManyToMany
* add many-to-many relationship in the Cart class
![](/images/Screen%20Shot%202022-05-09%20at%2012.02.29%20AM.png)
![](/images/Screen%20Shot%202022-05-09%20at%2012.01.43%20AM.png)

#### 2. Bidirectional @ManyToMany
![](/images/Screen%20Shot%202022-05-09%20at%2012.02.29%20AM.png)
![](./images/Screen%20Shot%202022-05-09%20at%2012.06.32%20AM.png)

#### 3. ManyToMany with @JoinTable with additional columns
![](./images/Screen%20Shot%202022-05-09%20at%209.35.31%20PM.png)
* Product-side
![](./images/Screen%20Shot%202022-05-09%20at%2011.19.42%20PM.png)
* OrderDetail-side
![](./images/Screen%20Shot%202022-05-09%20at%2011.20.38%20PM.png)
![](/images/Screen%20Shot%202022-05-09%20at%2011.20.57%20PM.png)
* Order-side
![](/images/Screen%20Shot%202022-05-09%20at%2011.21.17%20PM.png)
![](/images/Screen%20Shot%202022-05-09%20at%2011.22.11%20PM.png)
* database
![](./images/Screen%20Shot%202022-05-09%20at%2011.30.01%20PM.png)
![]()
![]()
![]()
![]()
![]()
![]()
![]()