<div align="center">

# 🍳 Loot | لوت

### Smart Pantry & Meal Finder

**Turn what you already have into what you can cook.**

</div>

Loot is a Spring Boot backend application that helps users manage pantry ingredients, discover recipes they can cook, identify missing ingredients, track cooking history, and use AI for cooking and ingredient assistance.

---

## 📌 About the Project

People often have ingredients at home but still do not know what to cook. This can lead to unnecessary grocery purchases, forgotten pantry items, and food waste.

**Loot | لوت** connects the user's pantry with recipes. The system checks available ingredients and quantities, shows recipes that can be cooked, identifies missing or insufficient ingredients, updates pantry quantities after cooking, stores cooking history, and provides AI-powered features.

---

## ✨ Main Features

- User registration
- Login and logout using `HttpSession`
- Forgot-password flow using an email verification code
- Ingredient management
- Pantry item management
- System recipe management
- User recipe management
- Check whether a recipe can be cooked
- Show missing or insufficient ingredients
- View system recipes
- View system recipes by category
- View user recipes
- View user recipes by category
- Find possible system recipes by category
- Find almost-possible system recipes by category
- Find possible user recipes by category
- Find almost-possible user recipes by category
- Detect low-stock pantry items
- Send the low-stock list by email
- Preview a recipe before cooking
- Cook a recipe and deduct the required ingredient quantities
- Save cooking history and used ingredients
- View cooking history
- Filter cooking history by category
- Find possible recipes from cooking history by category
- Find almost-possible recipes from cooking history by category
- Preview and repeat a previous cook
- Convert a system recipe into a user recipe
- AI-powered cooking and ingredient assistance

---

## 🤖 AI Features

Loot includes the following AI features:

- **Image → Ingredient** — identify an ingredient from an uploaded image
- **Add Image Ingredient** — add or update the identified ingredient in the pantry
- **Ingredient Substitute** — suggest a substitute for a recipe ingredient
- **Recipe Recommendation** — recommend recipes based on the user's request and pantry
- **Leftover Rescue** — recommend recipes using provided leftovers
- **Recipe Generator** — generate a recipe based on the user's request and pantry
- **Add Generated Recipe** — save an AI-generated recipe as a user recipe
- Validate AI-generated recipe information against application data before returning or saving it

---

## 🧰 Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming language |
| Spring Boot 4.1.1 | Application framework |
| Spring Web MVC | REST API development |
| Spring Data JPA | Database access |
| Hibernate | ORM |
| MySQL | Relational database |
| Jakarta Validation | Request and model validation |
| Lombok | Reduce boilerplate code |
| Spring Mail | Email integration |
| OpenAI API | AI-powered features |
| Maven | Dependency and build management |

---

## 🏗️ Project Architecture

```text
src/main/java/com/example/loot/
│
├── Api/
│   └── Standard API responses
│
├── Controller/
│   └── REST controllers and endpoints
│
├── DTO/
│   └── Data Transfer Objects
│
├── Model/
│   └── Database entities
│
├── Repository/
│   └── JPA repositories
│
├── Service/
│   └── Business logic
│
└── LootApplication.java
```

The application follows a layered structure:

```text
Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
MySQL Database
```

---

## 🗃️ Main Database Entities

- `User`
- `Ingredient`
- `PantryItem`
- `SystemRecipe`
- `SystemRecIng`
- `UserRecipe`
- `UserRecIng`
- `CookingHistory`
- `CookingHisIng`

### Supported Recipe Categories

- Breakfast
- Lunch
- Dinner
- Snack

### Supported Ingredient Units

- `g`
- `ml`
- `piece`

---

## 🔌 API Overview

The project contains CRUD endpoints, business-logic endpoints, and AI endpoints.

### 1. CRUD APIs

CRUD controllers are available for:

- Users
- Ingredients
- Pantry items
- System recipes
- System recipe ingredients
- User recipes
- User recipe ingredients
- Cooking history
- Cooking history ingredients

### 2. Business Logic APIs

The current code includes:

- Login
- Logout
- Forgot password
- Password reset using verification code
- Check if a recipe can be cooked
- Get missing ingredients
- Get system recipes
- Get system recipes by category
- Get user recipes
- Get user recipes by category
- Possible system recipes by category
- Almost-possible system recipes by category
- Possible user recipes by category
- Almost-possible user recipes by category
- Low-stock ingredients
- Send low-stock list by email
- Preview recipe before cooking
- Complete cooking
- Cooking history
- Cooking history by category
- Possible cooking-history recipes by category
- Almost-possible cooking-history recipes by category
- Preview a previous cook
- Repeat a previous cook
- Convert a system recipe into a user recipe

### 3. AI APIs

The AI controller includes:

```http
POST /api/v1/ai/image/to/ingredient
POST /api/v1/ai/image/to/ingredient/add
POST /api/v1/ai/ingredient/substitute/{recipeId}/{listType}/{ingredientId}
POST /api/v1/ai/recipe/recommendation
POST /api/v1/ai/leftover/rescue
POST /api/v1/ai/recipe/generator
POST /api/v1/ai/recipe/generator/add
```

---

## 🍽️ Cooking Logic

Before completing a cook, Loot checks the ingredients required by the selected recipe against the user's pantry.

```text
Required Quantity <= Available Quantity
                ↓
            Can Cook ✅
```

If an ingredient is missing or its available quantity is insufficient, the recipe cannot be completed.

When cooking succeeds:

1. The required ingredient quantities are deducted from the pantry.
2. A cooking-history record is created.
3. The ingredients and quantities used are stored in the cooking-history ingredients.

---

## 📧 Email Integration

Spring Mail is used for:

- Welcome email after creating an account
- Forgot-password verification code
- Low-stock list email

---

## ⚙️ Configuration

The project configuration file is:

```text
src/main/resources/application.properties
```

Example configuration using placeholders:

```properties
spring.application.name=Loot

spring.datasource.url=jdbc:mysql://localhost:3306/Loot
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop

spring.web.error.include-message=always
spring.web.error.include-stacktrace=always

# Email
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com

# OpenAI
openai.api.key=YOUR_OPENAI_API_KEY

# Multipart
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
```

---

## 🚀 Running the Project

### Prerequisites

- Java 17
- MySQL
- Maven or the included Maven Wrapper

### 1. Clone the Repository

```bash
git clone <YOUR_REPOSITORY_URL>
cd Loot
```

### 2. Create the Database

```sql
CREATE DATABASE Loot;
```

### 3. Configure the Application

Set your MySQL, email, and OpenAI values in:

```text
src/main/resources/application.properties
```

### 4. Run the Application

#### Windows

```bash
mvnw.cmd spring-boot:run
```

#### macOS / Linux

```bash
./mvnw spring-boot:run
```

---

## 🧪 Authentication Examples

User API base path:

```text
/api/v1/user
```

Login:

```http
POST /api/v1/user/login
```

Logout:

```http
POST /api/v1/user/logout
```

Forgot password:

```http
POST /api/v1/user/forgotPassword/{email}
```

Reset password using the verification code:

```http
POST /api/v1/user/forgotPassword/{email}/{code}
```

After a successful login, the application stores the logged-in user's ID in the HTTP session as `userId`.

---

## 🎯 Project Goal

Loot is designed around one question:

> **"What can I make with what I already have?"**

The project connects pantry data, recipes, cooking history, email features, and AI assistance in one backend application.

---

## 👨‍💻 Developer

**Abdulaziz Shafae**  
Computer Information Systems

---

<div align="center">

## Loot | لوت

**Use what you have. Cook what you can. Waste less.**

</div>
