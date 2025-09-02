# Java Learning Journey


### ⚠️ This documentation represents a complete Java learning path from **basic fundamentals** to **advanced enterprise concepts**, including **Design Patterns** and **real-world projects**

## 📚 Learning Path Overview

**Java Learning Journey** is a comprehensive educational project that demonstrates the complete path from Java fundamentals to advanced enterprise development. This journey includes **90+ practical exercises**, **10+ major projects**, and implementation of **23 Design Patterns** with real-world applications.

## 📑 Table of Contents
- [Learning Path Overview](#-learning-path-overview)
- [Learning Objectives Achieved](#-learning-objectives-achieved)
- [Project Structure by Learning Phases](#️-project-structure-by-learning-phases)
  - [Phase 1: Java Fundamentals](#phase-1-java-fundamentals)
  - [Phase 2: Object-Oriented Programming](#phase-2-object-oriented-programming)
  - [Phase 3: Advanced Java & Data Structures](#phase-3-advanced-java--data-structures)
  - [Phase 4: GUI Development & Database Integration](#phase-4-gui-development--database-integration)
  - [Phase 5: Design Patterns Implementation](#phase-5-design-patterns-implementation)
- [Major Projects Portfolio](#-major-projects-portfolio)
- [Java Swing Order Management System](#java-swing-order-management-system)
- [Technologies & Tools Used](#️-technologies--tools-used)
- [Key Learning Outcomes](#-key-learning-outcomes)
- [What is Next?](#️-what-is-next)
- [Screenshots](#-screenshots)
- [Conclusion](#-conclusion)


### 🎯 Learning Objectives Achieved

- **Core Java Mastery**: Variables, operators, control structures, OOP principles
- **Advanced Java Concepts**: Collections, Exception Handling, I/O, JDBC, Multithreading
- **Design Patterns**: All 23 Gang of Four patterns with practical implementations
- **GUI Development**: Java Swing applications with database integration
- **Enterprise Applications**: Banking systems, management systems
- **Algorithm Implementation**: Sorting algorithms, recursive solutions
- **Database Integration**: JDBC operations, CRUD implementations
- **Project Management**: Clean code principles, proper folder structures

## 🏗️ Project Structure by Learning Phases

### Phase 1: Java Fundamentals

**Core Concepts and Basic Programming**

| Topic | Projects | Key Concepts |
|-------|----------|--------------|
| **Variables & Data Types** | Hello Java, VAT Calculator, Grade Average | Basic syntax, primitive types, input/output |
| **Operators & Expressions** | Calculator Practice, Grocery Practice | Arithmetic, logical, comparison operators |
| **Control Structures** | Leap Year, Ticket Price Calculator, Chinese Zodiac | if-else, switch-case, conditional logic |
| **Loops & Iterations** | Fibonacci Series, Prime Numbers, Perfect Numbers | for, while, do-while loops |
| **Arrays & Collections** | Array Sorting, Element Frequency, Matrix Transpose | Single/multi-dimensional arrays, array operations |

#### 🔧 Fundamental Projects

```java
// Example: Recursive Power
package Practices;

import java.util.Scanner;
public class RecursivePower {
    public static void main(String[] args) {
        System.out.println("Enter number to find power of a number: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number for base ");
        int base = input.nextInt();
        System.out.println("Enter a number for power");
        int power = input.nextInt();

        int result = rPower(base,power);
        System.out.println(result);
    }

    static int rPower(int base, int power) {
        if(power ==0)
            return 1;
        return base * rPower(base,power-1);
    }
}
```

### Phase 2: Object-Oriented Programming

**OOP Principles and Advanced Concepts**

| Concept | Implementation Projects | Skills Developed |
|---------|------------------------|------------------|
| **Classes & Objects** | Student Information System, Box Game, Salary Calculator | Object modeling, encapsulation |
| **Inheritance** | Employee hierarchy, Shape classes | Code reusability, is-a relationships |
| **Polymorphism** | Different calculation methods | Method overriding, dynamic binding |
| **Abstraction** | Abstract classes and interfaces | Design abstraction, contract definition |
| **Encapsulation** | Banking System, Insurance Management | Data hiding, access modifiers |

```java
// Example: Polymorphism
package OOPKeystones.Polymorphism;

public class MainPoly {
    public static void main(String[] args) {
        // Overrides
        EmployeePoly emp1 = new EmployeePoly("Muharrem Aslan","01234","muharrem@gmail.com");
        //emp1.shiftStart();
        InstructorPoly ins1 = new InstructorPoly("Fatih Sultan Mehmet","0123","fatih@gmail.com","Computer","Dr","Data Science");
        //ins1.shiftStart();
        SecurityPoly sec1 = new SecurityPoly("Mustafa Kemal Atatürk","01","mustafa@gmail.com","university campus","09-00/18-00","security");
        //ec1.shiftStart();

        /*
        EmployeePoly empIns = new InstructorPoly("Kanuni Sultan Süleyman","0123","süleyman@gmail.com","Computer","Dr","Data Science");
        empIns.shiftStart();
        */

        // Here using polymorphism, all shiftStarts are triggered using a single ancestor variable.

        EmployeePoly[] empList = {emp1,ins1,sec1};

        for(EmployeePoly emp : empList) {
            emp.shiftStart();
        }
    }
}

```

### Phase 3: Advanced Java & Data Structures

**Collections, Exception Handling, and Complex Data Structures**

| Advanced Topic | Projects | Technical Skills |
|----------------|----------|------------------|
| **Collections Framework** | Book Sorter, Patika Store, Fixture Generator | ArrayList, HashMap, TreeSet, custom comparators |
| **Exception Handling** | File operations, user input validation | try-catch-finally, custom exceptions |
| **Generics** | Custom List Class, Book List | Type safety, generic methods and classes |
| **I/O Operations** | File reading/writing applications | Stream API, file manipulation |
| **Multithreading** | Race of Threads, Chat Room | Thread management, synchronization |

#### 📋 An Advanced Project

```java
// Example: Fixture Generator
package Practices;

import java.util.*;

public class Fixture {

    private ArrayList<String> clubs;


    public Fixture(ArrayList<String> clubs) {
        this.clubs = clubs;
        if(clubs.size() % 2 != 0){
            this.clubs.add("PASS");
        }
    }

    public List<LinkedHashMap<String, String>> fixture() {
        List<LinkedHashMap<String, String>> fixture = new ArrayList<>();


        Collections.shuffle(clubs);
        List<String> rotation = new ArrayList<>(clubs);

        int numTeams = rotation.size();
        int matchesPerRound = numTeams / 2;

        String fixedTeam = rotation.remove(0);


        for (int round = 0; round < numTeams - 1; round++) {
            LinkedHashMap<String, String> week = new LinkedHashMap<>();
            week.put(fixedTeam, rotation.get(0));

            for (int i = 1; i < matchesPerRound; i++) {
                String home = rotation.get(i);
                String away = rotation.get(rotation.size() - i);
                week.put(home, away);
            }
            fixture.add(week);
            rotation.add(0, rotation.remove(rotation.size() - 1));
        }

        return fixture;
    }

    public void printFixture(List<LinkedHashMap<String, String>> allRounds) {
        int week = 1;

        System.out.println("\n== First Half ==");
        for (LinkedHashMap<String, String> round : allRounds) {
            System.out.println("\nWeek " + week + ":");
            for (Map.Entry<String, String> entry : round.entrySet()) {
                System.out.println(entry.getKey() + " vs " + entry.getValue());
            }
            week++;
        }

        System.out.println("\n== Second Half ==");
        for (LinkedHashMap<String, String> round : allRounds) {
            System.out.println("\nWeek " + week + ":");
            for (Map.Entry<String, String> entry : round.entrySet()) {
                System.out.println(entry.getValue() + " vs " + entry.getKey());
            }
            week++;
        }
    }


    public static void main(String[] args) {
        int clubCount;
        ArrayList<String> clubs = new ArrayList<>();
        System.out.println("Plese Enter the Number Of Clubs!  Min(2)");
        Scanner sc = new Scanner(System.in);
        clubCount = sc.nextInt();
        sc.nextLine();
        while(clubCount < 2) {
            System.out.println("Wrong Input Please Try Again");
            clubCount = sc.nextInt();
        }

        for(int i = 0; i < clubCount; i++) {
            System.out.println("Please Enter the "+(i+1)+". Club");
            clubs.add(sc.nextLine());
        }

        Fixture fixtureMaker = new Fixture(clubs);
        List<LinkedHashMap<String, String>> fixture = fixtureMaker.fixture();
        fixtureMaker.printFixture(fixture);
    }
}


```

### Phase 4: GUI Development & Database Integration

**Java  and Database Operations**

| Technology | Applications | Features Implemented |
|------------|-------------|---------------------|
| **Java Swing** | Management System | GUI design, event handling, dynamic forms |
| **JDBC** | Database operations, CRUD functionality | Connection management, prepared statements |
| **MVC Pattern** | Management System | Separation of concerns, clean architecture |

#### 🖥️ GUI Project

- **Swing Management System**: Complete learning management system with Gui

#### 🎯 Swing Management CartUI Example

```java
package View;

import Business.BasketController;
import Business.CartController;
import Business.ProductController;
import Core.Helper;
import Entity.Basket;
import Entity.Cart;
import Entity.Customer;
import Entity.Product;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.MaskFormatter;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class CartUI extends JFrame {
    private JPanel MainContainer;
    private JLabel lbl_cart_title;
    private JLabel lbl_cart_customer_name;
    private JTextField fld_cart_date;
    private JTextArea txtArea_cart;
    private JButton lbl_cart_save;
    private JLabel lbl_cart_note;
    private JLabel lbl_cart_date;
    private Customer customer;
    private final BasketController basketController = new BasketController();
    private final ProductController productController = new ProductController();
    private final CartController cartController;
    private final Basket basket;
    public CartUI(Customer customer, Basket basket) throws ParseException {
        this.customer = customer;
        this.cartController = new CartController();
        this.basket = basket;


        $$$setupUI$$$();
        setContentPane(MainContainer);
        setTitle("Create Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        lbl_cart_customer_name.setText("Customer: " + customer.getName());

        ArrayList<Product> products = basketController.findBasket(basket.get_id());

        //DEBUG:check products
        //System.out.println("products " + products);


        lbl_cart_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the date field is empty
                if (Helper.isTextFieldEmpty(fld_cart_date)) {
                    Helper.showMessage("Please enter a date");
                } else {
                    Cart cart = new Cart();
                    for (Product product : products) {
                        // Skip products that are out of stock
                        if (product.getStock() <= 0)
                            continue;

                        // Set cart details
                        cart.setCustomer(customer);
                        cart.setPrice(product.getPrice());
                        cart.setDate(LocalDate.parse(fld_cart_date.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        cart.setNote(txtArea_cart.getText());

                        // Assign the product list
                        ArrayList<Product> productList = new ArrayList();
                        productList.add(product);  // Add the product to the list
                        cart.setProducts(productList);

                    }
                    // Save the cart using the cart controller
                    cart.setProducts(products);
                    cartController.save(cart);
                    Helper.showMessage("ORDER_CREATED");
                    dispose();
                }
            }
        });
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() throws ParseException {
        createUIComponents();
        MainContainer = new JPanel();
        MainContainer.setLayout(new GridLayoutManager(8, 1, new Insets(0, 0, 0, 0), -1, -1));
        lbl_cart_title = new JLabel();
        Font lbl_cart_titleFont = this.$$$getFont$$$(null, -1, 22, lbl_cart_title.getFont());
        if (lbl_cart_titleFont != null) lbl_cart_title.setFont(lbl_cart_titleFont);
        lbl_cart_title.setText("Create Order");
        MainContainer.add(lbl_cart_title, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        MainContainer.add(spacer1, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lbl_cart_customer_name = new JLabel();
        Font lbl_cart_customer_nameFont = this.$$$getFont$$$(null, -1, 18, lbl_cart_customer_name.getFont());
        if (lbl_cart_customer_nameFont != null) lbl_cart_customer_name.setFont(lbl_cart_customer_nameFont);
        lbl_cart_customer_name.setText("Label");
        MainContainer.add(lbl_cart_customer_name, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbl_cart_date = new JLabel();
        lbl_cart_date.setText("Order Date");
        MainContainer.add(lbl_cart_date, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        MainContainer.add(fld_cart_date, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lbl_cart_note = new JLabel();
        lbl_cart_note.setText("Your Note:");
        MainContainer.add(lbl_cart_note, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtArea_cart = new JTextArea();
        MainContainer.add(txtArea_cart, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        lbl_cart_save = new JButton();
        lbl_cart_save.setText("Create Order");
        MainContainer.add(lbl_cart_save, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainContainer;
    }

    private void createUIComponents() throws ParseException {
        this.fld_cart_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fld_cart_date.setText(formatter.format(LocalDate.now()));
    }
}


```

### Phase 5: Design Patterns Implementation

**Gang of Four Design Patterns**

#### Creational Patterns (5 Patterns)

| Pattern | Implementation | Use Case |
|---------|---------------|----------|
| **Singleton** | Thread-safe database connection | Single instance management |
| **Factory Method** | Car factory, Pizza factory | Object creation abstraction |
| **Abstract Factory** | Cross-platform UI components | Family of related objects |
| **Builder** | Person object with fluent interface | Complex object construction |
| **Prototype** | Object cloning with performance comparison | Object copying strategies |

#### Structural Patterns (7 Patterns)

| Pattern | Implementation | Real-world Application |
|---------|---------------|----------------------|
| **Adapter** | Legacy system integration | Interface compatibility |
| **Bridge** | Shape drawing with different renderers | Abstraction from implementation |
| **Composite** | File system hierarchy | Tree structures |
| **Decorator** | Feature enhancement system | Dynamic behavior addition |
| **Facade** | Simplified API interface | Complex subsystem simplification |
| **Flyweight** | Character rendering optimization | Memory optimization |
| **Proxy** | Lazy loading, access control | Controlled access to objects |

#### Behavioral Patterns (11 Patterns)

| Pattern | Implementation | Practical Example |
|---------|---------------|-------------------|
| **Observer** | Event notification system | Publisher-subscriber model |
| **Strategy** | Student exam prioritization | Algorithm family selection |
| **Command** | Undo/redo operations | Action encapsulation |
| **State** | Joystick controller, graphics tools | State-dependent behavior |
| **Template Method** | Algorithm skeleton definition | Common algorithm structure |
| **Visitor** | COVID-19 data processing | Operations on object structures |
| **Chain of Responsibility** | Request processing pipeline | Handler chain |
| **Mediator** | Component communication | Loose coupling |
| **Memento** | State restoration | Snapshot pattern |
| **Iterator** | Collection traversal | Sequential access |
| **Interpreter** | Language processing | Bird/Crow Language Convertor |

### Design Pattern Implementation - State Pattern

```java
package DesignPatterns.Behavioural.State.Joystick;

// Behavioural
// State :Bir nesnenin iç durumuna göre davranışını değiştirmesini sağlar.
// Yani bir nesne, farklı durumlarda farklı şekillerde davranabilir.
// Bu desen, durum geçişlerinin yönetilmesini ve kodun daha esnek ve okunabilir olmasını sağlar.

//Avantajları:

//if-else ya da switch-case bloklarından kurtarır.

//Kod daha modüler, bakımı kolay ve açık/kapalı ilkesine uygun olur.

// Dezavantajları:

//Durum sayısı fazla ise, çok sayıda sınıf oluşur (class patlaması yaşanabilir).


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.triggerCircle();
        game.triggerTriangle();
        game.triggerSquare();
        System.out.println("The ball went out.");
        game.changeState();
        game.triggerCircle();
        game.triggerTriangle();
        game.triggerSquare();


    }
}

```

## 🚀 Major Projects Portfolio

| Project | Domain | Features |
|---------|-----------------|----------|
| **Adventure Game** | Core Java, OOP | Character classes, battle system, inventory, maps |
| **Order Management System** | GUİ | SWING , Preparing UI |
| **Minesweeper** | 2D Arrays, Game Logic | Grid generation, mine placement, adjacency calculation |
| **Rock Paper Scissors** | Random algorithms, Game states | Player vs Computer, automatic mode |
| **ATM System** | Banking Operations | Password security, transaction limits, account management |
| **Chat Room** | Thread, Socker, I/O, Communication | Multi-client server, network programming |
| **Fixture Generator** | Algorithm | Double round-robin algorithm, team scheduling |
| **Insurance Management** | OOP, Exceptions, Enums Management | Policy management, customer profiles, claims |
| **Student Information System** | OOP, Inheritance, Encapsulation | Add students & courses, set grades, calculate average, pass/fail |
| **Banking System** | OOP, File I/O, JSON | Register/login users, transfer money, pay loans, pay credit card, check balance |

## 🛠️ Technologies & Tools Used

### Core Technologies

- **Java SE 8+** - Primary programming language
- **Java Swing** - GUI development framework
- **JDBC** - Database connectivity

### Development Tools

- **IntelliJ IDEA** - Integrated Development Environment
- **Git** - Version control
- **Gradle** - Dependency management

### Design Principles Applied

- **SOLID Principles** - Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion
- **Clean Code** - Readable, maintainable, and well-documented code
- **DRY (Don't Repeat Yourself)** - Code reusability and maintainability
- **MVC Pattern** - Model-View-Controller architecture

## 🎯 Key Learning Outcomes

### Technical Competencies

1. **Java Language Mastery**: Complete understanding of Java syntax, features, and best practices
2. **Object-Oriented Design**: Expert-level implementation of OOP principles and design patterns
3. **Problem Solving**: Algorithmic thinking and efficient solution development
4. **Software Architecture**: Understanding of clean code principles and design patterns
5. **Database Integration**: JDBC operations and data persistence strategies
6. **GUI Development**: User interface design and event-driven programming

# Java Swing Order Management System

## 📖 Project Overview

**Java Swing Order Management System** is a comprehensive desktop application built with Java Swing that demonstrates modern software architecture patterns including **Layered Architecture**, **DAO Pattern**, **Singleton Pattern**, and **MVC Pattern**. The system provides complete order management functionality with MongoDB integration for data persistence.

### Key Features

- **Customer Management**: Add, edit, delete, and filter customers (Person/Company types)
- **Product Management**: Complete CRUD operations with stock management
- **Shopping Cart System**: Dynamic basket management with real-time updates
- **Order Processing**: Create and track orders with customer and product associations
- **User Authentication**: Secure login system
- **Advanced Filtering**: Multi-criteria filtering for customers and products
- **MongoDB Integration**: NoSQL database with efficient document operations
- **Modern UI**: Professional Swing interface with popup menus and table operations

## 🏗️ Architecture Overview

### Project Structure

```
src/
├── Business/         # Business Logic Layer (Controllers)
├── Core/             # Core Utilities and Database Connection
├── DAO/              # Data Access Layer
├── Entity/           # Domain Models/Entities
└── View/             # Presentation Layer (UI)
```

### Architecture Patterns Used

1. **Layered Architecture**: Clear separation of concerns across layers
2. **DAO Pattern**: Data access abstraction
3. **Singleton Pattern**: MongoDB connection management
4. **MVC Pattern**: Model-View-Controller separation
5. **Repository Pattern**: Data access layer abstraction

## 🛠️ Technologies & Dependencies

- **Java 21** - Programming Language
- **Java Swing** - GUI Framework
- **MongoDB** - NoSQL Database
- **MongoDB Java Driver** - Database connectivity
- **Nimbus Look and Feel** - Modern UI appearance
- **IntelliJ IDEA** - Development Environment (Required For UI Designer. You may use difference)

## 📊 Database Design

### MongoDB Collections

#### Users Collection

```json
{
  "_id": ObjectId,
  "username": "string",
  "mail": "string", 
  "password": "string"
}
```

#### Customers Collection

```json
{
  "_id": ObjectId,
  "name": "string",
  "phone": "string",
  "mail": "string",
  "address": "string",
  "type": "PERSON|COMPANY"
}
```

#### Products Collection

```json
{
  "_id": ObjectId,
  "name": "string",
  "code": "string",
  "price": number,
  "stock": number
}
```

#### Baskets Collection

```json
{
  "_id": ObjectId,
  "products": ["productId1", "productId2", ...]
}
```

#### Carts Collection

```json
{
  "_id": ObjectId,
  "price": number,
  "customerID": "string",
  "productIDs": ["productId1", "productId2", ...],
  "note": "string",
  "date": "YYYY-MM-DD"
}
```

## 🏛️ Detailed Layer Architecture

### 1. Entity Layer

Contains domain models representing business objects:

#### **User Entity**

```java
public class User {
    private String id;
    private String name;
    private String mail;
    private String password;
    // Constructors, getters, setters, toString
}
```

### 2. DAO Layer (Data Access Layer)

Implements data persistence operations with MongoDB:

#### **MongoDBConnection (Singleton)**

```java
public class MongoDBConnection {
    private static MongoDBConnection instance;
    private MongoClient mongoClient;
    private static MongoDatabase database;
    
    public static synchronized MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }
    
    public static MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }
}
```

#### **DAO Pattern Implementation**

Each DAO class provides:

- `findById(String id)` - Retrieve single entity
- `findAll()` - Retrieve all entities
- `save(Entity entity)` - Create new entity
- `update(Entity entity)` - Update existing entity
- `delete(Entity entity)` - Remove entity
- `filter(...)` - Advanced filtering

**Example: CustomerDao**

```java
public class CustomerDao {
    public Customer findById(String id) {
        MongoCollection<Document> collection = MongoDBConnection.getCollection("Customers");
        ObjectId objectId = new ObjectId(id);
        Document customerDoc = collection.find(Filters.eq("_id", objectId)).first();
        // Convert Document to Customer entity
        return customer;
    }
    
    public ArrayList<Customer> filter(String name, String type) {
        // Implements advanced filtering with MongoDB queries
        Bson filter = Filters.and(
            Filters.regex("name", ".*" + name + ".*", "i"),
            Filters.eq("type", type)
        );
        // Process results and return filtered customers
    }
}
```

### 3. Business Layer (Controllers)

Contains business logic and coordinates between UI and DAO:

#### **CustomerController**

```java
public class CustomerController {
    private final CustomerDao customerDao = new CustomerDao();
    
    public ArrayList<Customer> findAll() {
        return this.customerDao.findAll();
    }
    
    public boolean update(Customer customer) {
        if (customer.getId() == null) {
            Helper.showMessage("CUSTOMER_NOT_FOUND");
            return false;
        }
        return this.customerDao.update(customer);
    }
    
    public ArrayList<Customer> filter(String name, String type) {
        return this.customerDao.filter(name, type);
    }
}
```

### 4. Core Layer

Contains utility classes and helper functions:

#### **Helper Class**

```java
public class Helper {
    // UI Theme management
    public static void setTheme() {
        // Sets Nimbus Look and Feel
    }
    
    // Form validation
    public static boolean isTextFieldEmpty(JTextField text);
    public static boolean isTextFieldListEmpty(JTextField[] list);
    public static boolean isValidEmail(String email);
    
    // User interaction
    public static boolean confirmDelete(String str);
    public static void showMessage(String code);
}
```

### 5. View Layer (Presentation)

Implements user interface with Java Swing:

#### **DashboardUI**

- **Tabbed Interface**: Customer, Product, Basket, Orders
- **Customer Tab**:
  - Customer table with CRUD operations
  - Filtering by name and type
  - Right-click context menu (Update/Delete)
- **Product Tab**:
  - Product table with stock management
  - Advanced filtering (name, code, stock status)
  - Add to cart functionality
- **Basket Tab**:
  - Real-time cart display
  - Customer selection for order
  - Total price calculation
  - Order creation
- **Orders Tab**:
  - Order history display
  - Customer and product association

## 🔄 Application Flow

### 1. User Authentication Flow

```
LoginUI → Validate Credentials → DashboardUI
```

### 2. Customer Management Flow

```
DashboardUI → CustomerUI (Add/Edit) → Save/Update → Refresh Customer Table
```

### 3. Product Management Flow

```
DashboardUI → ProductUI (Add/Edit) → Save/Update → Refresh Product Table
```

### 4. Order Processing Flow

```
Product Selection → Add to Basket → Customer Selection → CartUI → Order Creation → Order History
```

## 🛡️ Key Design Patterns

### 1. Singleton Pattern

**MongoDBConnection** ensures single database connection instance:

```java
public static synchronized MongoDBConnection getInstance() {
    if (instance == null) {
        instance = new MongoDBConnection();
    }
    return instance;
}
```

### 2. Observer Pattern

Window listeners for UI updates:

```java
customerUI.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        loadCustomerTable(null);
        loadBasketCustomers();
    }
});
```

### 3. Factory Pattern (Implicit)

Document to Entity conversion in DAO classes:

```java
private Customer documentToCustomer(Document customerDoc) {
    Customer customer = new Customer();
    customer.setId(customerDoc.getObjectId("_id").toString());
    customer.setName(customerDoc.getString("name"));
    // ... other fields
    return customer;
}
```

## 📋 Features

### Customer Management

- **Add Customer**: Create new customers with validation
- **Edit Customer**: Update existing customer information
- **Delete Customer**: Remove customers with confirmation
- **Filter Customers**: Search by name and type
- **Customer Types**: Support for Person and Company types

### Product Management

- **Add Product**: Create products with code, price, and stock
- **Edit Product**: Update product information
- **Delete Product**: Remove products with confirmation
- **Filter Products**: Search by name, code, and stock status
- **Stock Management**: Real-time stock updates during orders

### Shopping Cart System

- **Add to Cart**: Select products and add to temporary basket
- **Real-time Updates**: Dynamic price and item count calculation
- **Stock Validation**: Prevents adding out-of-stock items
- **Customer Association**: Link orders to specific customers

### Order Processing

- **Order Creation**: Convert basket to formal order
- **Date Management**: Order date tracking
- **Order Notes**: Additional order information
- **Order History**: Complete order tracking with details

### Advanced Filtering

- **Customer Filtering**: By name (partial match) and type
- **Product Filtering**: By name, code, and stock status
- **Case-insensitive Search**: User-friendly search functionality
- **Combined Filters**: Multiple criteria filtering

## 🚀 Running the Application

### Prerequisites

1. **Java 21** installed
2. **MongoDB** running on localhost:27017 (default)
3. **IntelliJ IDEA** (recommended for UI designer compatibility)

### Steps

1. **Setup Database**:

   ```bash
   # Start MongoDB
   mongod
   
   # Create database and collections
   use Swing-OrderManagement
   db.createCollection("Users")
   db.createCollection("Customers")
   db.createCollection("Products")
   db.createCollection("Baskets")
   db.createCollection("Carts")
   ```

2. **Insert Test User**:

   ```javascript
   db.Users.insertOne({
     username: "admin",
     mail: "admin@test.com", 
     password: "admin123"
   })
   ```

3. **Compile and Run**

## 🧪 Testing Scenarios

### 1. Customer Management Testing

```java
// Test customer creation
Customer customer = new Customer();
customer.setName("John Doe");
customer.setType(Customer.ETYPE.PERSON);
// Verify save operation

// Test customer filtering
ArrayList<Customer> results = customerController.filter("John", "PERSON");
// Verify filter results
```

### 2. Product Management Testing

```java
// Test product stock management
Product product = new Product();
product.setStock(10);
// Add to cart
// Verify stock reduction
```

## 🔍 Code Quality Features

### Input Validation

- **Email Validation**: Regex-based email format checking
- **Required Fields**: Comprehensive null/empty validation
- **Data Type Validation**: Proper integer parsing with error handling

### Error Handling

- **Database Exceptions**: Try-catch blocks for all database operations
- **User-Friendly Messages**: Meaningful error messages via Helper class
- **Graceful Degradation**: Application continues operation on non-critical errors

### Memory Management

- **Connection Pooling**: Singleton pattern for database connections
- **Resource Cleanup**: Proper disposal of UI components
- **Efficient Queries**: Optimized MongoDB queries with proper indexing

## 🚀 Future Enhancement Opportunities

### Features

- **User Roles**: Admin, Manager, Clerk role-based access
- **Reporting**: Sales reports, inventory reports
- **Import/Export**: CSV/Excel data import/export

### Technical Improvements

- **REST API**: Convert to web-based application
- **Caching**: Redis caching for improved performance
- **Logging**: Comprehensive application logging
- **Testing**: Unit and integration test coverage

### UI Enhancements

- **Charts/Graphs**: Visual analytics dashboard
- **Drag & Drop**: Enhanced user interactions
- **Theme Support**: Multiple UI themes
- **Mobile Support**: Responsive design for tablets

# ➡️ What is Next?

### Now that you’ve learned all this, what’s next? Here are some tips I may suggest on Java technologies that can help you take your skills to the next level

### Topics

1. **Spring Framework Integration** - Enterprise Java development
2. **Microservices Architecture** - Distributed system design
3. **REST API Development** - Web service implementation
4. **Unit Testing Expansion** - Testing
5. **Cloud Deployment** - Modern deployment strategies
6. **Reactive Programming** - Reactive Programming
7. **Domain-Driven Architecture**
8. **Event-Driven Architecture**

---

## 📝 Conclusion

This Java Learning Journey represents a comprehensive educational progression from basic programming concepts to advanced software engineering principles. Through **100+ commits**, **23 design patterns**, and **10+ major projects**, this documentation showcases a systematic approach to mastering Java development.

The journey demonstrates not just coding ability, but also:

- **Software Engineering Principles**: Clean code, SOLID principles, design patterns
- **Problem-Solving Skills**: Algorithmic thinking and efficient solution design
- **Project Management**: Organized development with proper version control
- **Continuous Learning**: Progressive skill building and knowledge application

*This documentation serves as both a learning resource and a testament to the comprehensive Java development capabilities acquired through structured, hands-on practice.*

---

### 🚀 **Now You are ready for Enterprise Java Development and Advanced Software Engineering Challenges**



## 📸 Screenshots

<details>
<summary><strong>Click to view figures</strong></summary><br>


<details>
<summary><strong>Swing Management Desktop</strong></summary><br>

### Login Screen
<details>
<summary>See</summary>
  
<img width="1136" height="613" alt="management_4" src="https://github.com/user-attachments/assets/9affc4a0-22d5-4523-a4e7-d58174ec1b17" />

</details>

### Dashboard Customer
<details>
<summary>See</summary>
  
<img width="1472" height="766" alt="management_3" src="https://github.com/user-attachments/assets/40462293-340a-4568-9579-b0346b053b72" />


</details>

### Dashboard Product
<details>
<summary>See</summary>
  
<img width="1462" height="768" alt="management_2" src="https://github.com/user-attachments/assets/0bd68493-aa7e-4bbd-ad80-f0751d7067b7" />


</details>

### Add New Product
<details>
<summary>See</summary>
  
<img width="1463" height="769" alt="management_1" src="https://github.com/user-attachments/assets/98fc00c7-f306-4094-8944-23565ef37ed0" />


</details>

</details>

### Adventure Game

<details>
<summary>See</summary>
  
<img width="1740" height="849" alt="adventure" src="https://github.com/user-attachments/assets/e4ec791b-34de-4d42-9cd3-d18e86c609ed" />

</details>

---

### Armstrong Number

<details>
<summary>See</summary>
  
  <img width="1048" height="880" alt="Armstrong Number" src="https://github.com/user-attachments/assets/f4cf1a23-f5f4-4e07-ab5d-6d88e39d9da6" />

</details>

---

### Bank

<details>
<summary>See</summary>
  
<img width="1603" height="443" alt="bank" src="https://github.com/user-attachments/assets/d3d1d923-769f-4d9b-97e7-ce839beda609" />

</details>

---

### BLetter

<details>
<summary>See</summary>
  
<img width="1322" height="805" alt="BLetter" src="https://github.com/user-attachments/assets/31204a9b-ae45-4f52-9227-fa35df6e328c" />


</details>

---

### ChatRoom

<details>
<summary>See</summary>

<img width="1919" height="1032" alt="ChatRoom" src="https://github.com/user-attachments/assets/e6a0df58-c5de-4ba6-984b-cd3a1c6d1e59" />


</details>

---

### GcdLcm

<details>
<summary>See</summary>

<img width="1009" height="895" alt="GcdLcm" src="https://github.com/user-attachments/assets/04e9a2ba-076f-422a-a589-f2b53d982cd4" />


</details>

---

### Insurance

<details>
<summary>See</summary>


<img width="1706" height="818" alt="insurance" src="https://github.com/user-attachments/assets/6b738d08-d303-4cce-b513-1a67785de33f" />


</details>

---


### Matrix-Transpose

<details>
<summary>See</summary>


<img width="1020" height="432" alt="matrix-transpose" src="https://github.com/user-attachments/assets/a9d15ac4-5c3f-4753-9133-a86ea476e531" />


</details>

---


### MineSweeper

<details>
<summary>See</summary>


<img width="1818" height="929" alt="MineSweeper" src="https://github.com/user-attachments/assets/5789fbca-3023-4d98-8eee-c295f079cbeb" />



</details>

---


### Patika Store

<details>
<summary>See</summary>


<img width="1545" height="801" alt="patika-store" src="https://github.com/user-attachments/assets/821725a8-b16b-484c-98db-c1559c87f515" />


</details>

---



</details>
