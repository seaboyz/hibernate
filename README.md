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

#### Primary Key
##### @NatualId
* When new Customer registers, the email should be unique, otherwise, it will throw an exception.
![](/images/Screen%20Shot%202022-05-11%20at%208.24.38%20PM.png)
![](/images/Screen%20Shot%202022-05-11%20at%208.24.12%20PM.png)

##### @Id
##### @GeneratedValue(strategy = GenerationType.AUTO)
##### @Genericgenerator(name = "generator", strategy = "native")
https://www.youtube.com/watch?v=rvaAx7r8lVY

##### UUID
![](./images/Screen%20Shot%202022-05-07%20at%204.33.11%20AM.png)
![](images/Screen%20Shot%202022-05-07%20at%206.24.57%20AM.png)
>https://thorben-janssen.com/generate-uuids-primary-keys-hibernate/

##### interger Id
![](images/Screen%20Shot%202022-05-07%20at%2010.04.35%20AM.png)


#### value object vs entity object
- value object: has no meaning without other object (address,cart)
- entity object: can exist independently (user, order, product)
- edge case: think about a order can be created by a guest(without register as a user)
- so the order has to be independent from user

### relationships
### What is a relationship?
![](/images/Screen%20Shot%202022-05-10%20at%209.18.12%20AM.png)
* A relationship is a link between two objects(Entity).
* https://www.youtube.com/watch?v=C3icLzBtg8I

#### Entity vs Value Object
* If you have a value object, you can't create a relationship between two value objects.
* An value object is a object that has no meaning without other object.
* An value object will not be saved in database.
* An embedded objects will be saved in database 
* An entity object is a object that can exist independently.
* An entity object can have a relationship with other entity objects.
* An entity object can't have a relationship with value objects.
* An entity object can't have a relationship with itself.
* An entity object will be saved in the database.
#### Entity @Entity
* An entity in DBMS (Database management System) is a real-world thing or a real-world object which is distinguishable from other objects in the real world. For example, a car is an entity. An attribute of an entity gives us information about the characteristic features of an entity.
* Customer is an entity.
* Product is an entity.
* Cart is an entity.
* Order is an entity.
#### Value Object @Data
* Address is an value object.
* CartItem is an value object.
* OrderItem is an value object.

#### relationship
* `one` customer has `many` addresses
* `one` address belongs to `one` customer

* `one` customer has `many` orders
* `one` order belongs to `one` customer

* `one` order has many `order` items
* `one` order_item belongs to `one` order
  
* `one` order_item has `one` product
* `one` product belongs `many` order_item

* `one` customer has `one` cart
* `one` cart belongs to `one` customer



#### user story
##### Place a order
* when customer buy a product, frontend will create a cart
* then customer can add product to cart, then the frontend will create a cart item with product id and quantity
* before customer checkout, the frontend will never talk to backend
* all the cart_item(product_id, quantity) will be saved in the frontend local storage/session storage/cookie storage
<br>
* when customer checkout, he/she has to provide address and payment information.
* frontend will get the cart_item(product_id and quantity) from local storage/session storage/cookie storage
* frontend will create an json object with customer_id,  product_id, quantity, shipping_address and payment_info, send it to backend
<br>
* when backend receive the json object, it will create an order with customer_id, shipping_address and payment_info
* first backend will create a empty order with order_id and customer_id and pending status
* then backend will create a order_item with order_id, product_id, quantity,subtotal and save it in the database
* then backend will update the total in the order table based on the subtotal of the order_item
* then after backend verify the payment information, backend will update the status of the order to paid
* backend will send a json object with order_id, customer_id, shipping_address, payment_info, status, total, order_items to the frontend
<br>
* after frontend receive the json object with the order infomation from the backend, it will clear the cart_item in the local storage/session storage/cookie storage
* show the customer order received message

# Can a pendding order be in the cart?

#### JPA (Java Persistence API) @Entity
* Entities in JPA are nothing but POJOs representing data that can be persisted to the database. 
* An entity represents a table stored in a database. 
* Every instance of an entity represents a row in the table.

#### @OneToMany
 * ##### always add foreign key at the many side.
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
* Product-side(optional - if we want to get all orders of a certain product from the product side)
![](./images/Screen%20Shot%202022-05-09%20at%2011.19.42%20PM.png)
* OrderDetail-side
![](./images/Screen%20Shot%202022-05-09%20at%2011.20.38%20PM.png)
![](/images/Screen%20Shot%202022-05-09%20at%2011.20.57%20PM.png)
* Order-side
![](/images/Screen%20Shot%202022-05-09%20at%2011.21.17%20PM.png)
![](/images/Screen%20Shot%202022-05-09%20at%2011.22.11%20PM.png)
* database
![](./images/Screen%20Shot%202022-05-09%20at%2011.30.01%20PM.png)


### Cascade types
https://github.com/eugenp/tutorials/tree/master/persistence-modules/jpa-hibernate-cascade-type
https://www.baeldung.com/jpa-cascade-types
#### CascadeType.ALL
* CascadeType.ALL propagates all operations — including Hibernate-specific ones — from a `parent` to a `child` entity.
#### @Cascade = CascadeType.PERSIST
![](images/Screen%20Shot%202022-05-12%20at%204.25.31%20PM.png)
* Cascade Type PERSIST propagates the persist operation from a `parent` to a `child` entity. 
* when the customer entity is saved, the addresses entity belongs to the customer will be saved as well.
#### @Cascade = CascadeType.REMOVE
* Cascade Type REMOVE propagates the remove operation from a `parent` to a `child` entity.
#### @Cascade = CascadeType.MERGE
* Cascade Type MERGE propagates the merge operation from a `parent` to a `child` entity.
#### @Cascade = CascadeType.REFRESH
#### @Cascade = CascadeType.DETACH
#### @Cascade = CascadeType.REPLICATE
#### @Cascade = CascadeType.ALL


##### mvn exec
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.0.0</version>
    <configuration>
        <mainClass>com.webdev</mainClass>
    </configuration>
</plugin>
`mvn exec:java -Dexec.mainClass="com.webdev.App`

### Dao (Data Access Object)
he Data Access Object Pattern, aka DAO Pattern, is an abstraction of data persistence and is considered closer to the underlying storage, which is often `table-centric`.
![](images/Screen%20Shot%202022-05-12%20at%205.45.36%20AM.png)

### Repository (Data Access Object)
As per Eric Evans' book Domain-Driven Design, the “repository is a mechanism for encapsulating storage, retrieval, and search behavior, which emulates a `collection` of objects.”
Likewise, according to Patterns of Enterprise Application Architecture, it “mediates between the domain and data mapping layers using a collection-like interface for accessing domain objects.”
![](images/Screen%20Shot%202022-05-12%20at%205.46.07%20AM.png)

### Dao + Repository
![](/images/Screen%20Shot%202022-05-12%20at%205.51.19%20A M.png)
![](images/Screen%20Shot%202022-05-12%20at%205.52.23%20AM.png)'
Then, it aggregates both sets of information and provides a domain object of the UserSocialMedia class that is handy for our business use-case. Therefore, a repository relies on DAOs for accessing data from various sources.

### Dao vs Repository
* `DAO` is an abstraction of `data persistence`. However, a `repository` is an abstraction of a `collection` of objects
* `DAO` is a `lower-level` concept, closer to the storage systems. However, `Repository` is a `higher-level` concept, closer  to the Domain objects
* `DAO` works as a data `mapping/access` layer, hiding ugly queries. However, a `repository` is a layer between `domains` and `data access layers`, hiding the complexity of collating data and preparing a domain object
* `DAO` `can't be implemented` using a repository. However, a repository can use a DAO for accessing underlying storage

### SessionFactory vs Session
* `SessionFactory` is a factory for creating `Session` objects. However, `Session` is a `higher-level` concept, closer to the Domain objects
![](images/Screen%20Shot%202022-05-12%20at%2010.34.10%20AM.png)

### Transaction vs Session
* https://www.youtube.com/watch?v=HcjHJLEbtRs&list=PLSEDryV9VNWGPUN0-2R1GopFRJSggVzAH


#### CRUD
#### READ
![](/images/Screen%20Shot%202022-05-08%20at%2012.27.34%20PM.png)

<!-- TODO CREATE -->
<!-- TODO UPDATE -->
<!-- TODO DELETE -->

![]()
![]()
![]()
![]()
![]()