<div align="center">

🍳 Loot | لوت
Smart Pantry & Meal Finder
Turn what you already have into what you can cook.
Loot is a Spring Boot backend application that helps users manage pantry ingredients, discover recipes they can cook, identify missing ingredients, track cooking history, and use AI to make smarter food decisions.
</div>

📌 About the Project
People often have ingredients at home but still do not know what to cook. This can lead to unnecessary grocery purchases, forgotten pantry items, and food waste.
Loot | لوت solves this by connecting the user's pantry with recipes. The system checks available ingredients and quantities, recommends suitable recipes, shows what is missing, updates pantry stock after cooking, and adds AI-powered features for a smarter cooking experience.
✨ Main Features
- User registration and login using session-based authentication
- Change and reset password using email verification
- Pantry and ingredient management
- System recipes and personal user recipes
- Check whether a recipe can be cooked with the current pantry
- Show missing or insufficient ingredients and quantities
- Find possible recipes by category
- Find almost-possible recipes when only a few ingredients are missing
- Detect low-stock pantry items
- Cook a recipe and automatically deduct used ingredients
- Save cooking history and the ingredients used
- Repeat a previously cooked recipe
- Convert a system recipe into a personal user recipe
- Send missing ingredient information by email
- AI-powered cooking and ingredient assistance
🤖 AI Features
Loot integrates AI to provide additional smart functionality:
- Image → Ingredient — identify an ingredient from an uploaded image
- Ingredient Substitute — suggest alternatives for a missing ingredient
- Recipe Recommendation — recommend suitable recipes based on the user's request and pantry
- Leftover Rescue — suggest ways to use leftover ingredients
- Recipe Generator — generate a new recipe using available pantry ingredients
- AI output validation against the application's ingredient and pantry data
🧰 Tech Stack
Technology	Purpose
Java	Backend programming language
Spring Boot	Application framework
Spring MVC	REST API development
Spring Data JPA	Database access
Hibernate	ORM
MySQL	Relational database
Jakarta Validation	Request and model validation
Lombok	Reduce boilerplate code
Spring Mail	Email integration
OpenAI API	AI-powered features
Maven	Dependency and build management
Postman	API testing


🏗️ Project Architecture
src/main/java/com/example/loot/
│
├── Api/             # Standard API responses
├── Controller/      # REST controllers / endpoints
├── DTO/             # Data Transfer Objects
├── Model/           # Database entities
├── Repository/      # JPA repositories
├── Service/         # Business logic
└── LootApplication.java
The application follows a layered structure:
Client / Postman
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
MySQL Database
🗃️ Main Database Entities
- User
- Ingredient
- PantryItem
- SystemRecipe
- SystemRecIng
- UserRecipe
- UserRecIng
- CookingHistory
- CookingHisIng
Supported Recipe Categories
Breakfast
Lunch
Dinner
Snack
Supported Ingredient Units
g
ml
piece
🔌 API Overview
The APIs are organized into three main groups.
1. CRUD APIs
CRUD operations are available for the main resources, including:
- Users
- Ingredients
- Pantry items
- System recipes
- System recipe ingredients
- User recipes
- User recipe ingredients
- Cooking history
- Cooking history ingredients
2. Smart / Business Logic APIs
Examples include:
- Login and logout
- Forgot password and verification
- Change password
- Check if a recipe can be cooked
- Get missing ingredients
- Possible system recipes by category
- Almost-possible system recipes by category
- Possible user recipes by category
- Almost-possible user recipes by category
- Low-stock ingredients
- Cook recipe
- Cooking history
- Repeat previous cook
- Convert system recipe to user recipe
- Send missing ingredients
3. AI APIs
AI endpoints support:
- Ingredient recognition from images
- Ingredient substitute suggestions
- AI recipe recommendations
- Leftover rescue
- AI recipe generation
🍽️ Cooking Logic
Before cooking a recipe, Loot compares every required ingredient with the user's pantry.
Required quantity <= Available quantity
            ↓
        Can Cook ✅
If an ingredient is unavailable or the quantity is too low, Loot returns the missing amount instead of cooking the recipe.
When cooking succeeds:
1. Required ingredient quantities are deducted from the pantry.
2. A new cooking-history record is created.
3. The exact ingredients and quantities used are saved.
This allows the application to keep the pantry synchronized with the user's cooking activity.
📧 Email Integration
Spring Mail is used for features such as:
- Welcome email after registration
- Forgot-password verification code
- Sending ingredient-related information
- Low-stock notifications where applicable
Sensitive email credentials should never be committed to GitHub.
⚙️ Configuration
Create or update:
src/main/resources/application.properties
Example configuration:
spring.application.name=Loot

spring.datasource.url=jdbc:mysql://localhost:3306/Loot
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Email
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# OpenAI
openai.api.key=YOUR_OPENAI_API_KEY
Keep passwords and API keys private. Use environment variables or a local configuration file that is excluded from Git whenever possible.

🚀 Running the Project
Prerequisites
Make sure you have:
- Java installed
- Maven or the included Maven Wrapper
- MySQL Server
- Postman or another REST client
- An email account/app password for email features
- An OpenAI API key for AI features
1. Clone the repository
git clone <YOUR_REPOSITORY_URL>
cd Loot
2. Create the database
CREATE DATABASE Loot;
3. Configure the application
Add your local database, email, and AI credentials to application.properties or environment variables.
4. Run the application
Windows
mvnw.cmd spring-boot:run
macOS / Linux
./mvnw spring-boot:run
The API will normally be available at:
http://localhost:8080
🧪 Testing
The REST APIs can be tested with Postman.
Example user base path:
/api/v1/user
Example authentication endpoints:
POST /api/v1/user/login
POST /api/v1/user/logout
POST /api/v1/user/forgotPassword/{email}
POST /api/v1/user/forgotPassword/{email}/{code}
For endpoints that require authentication, log in first so the application can store the user's ID in the HTTP session.
🔐 Security Notes
- Authentication is currently session-based using HttpSession.
- User passwords are validated before storage/update.
- Email addresses are unique.
- Sensitive credentials should not be pushed to public repositories.
- Production deployments should use environment variables and stronger production security practices.
🎯 Project Goal
Loot is designed to make everyday cooking easier by answering a simple question:
"What can I make with what I already have?"

Instead of treating pantry management and recipe discovery as separate tasks, Loot connects them into one workflow and enhances it with AI-powered assistance.
👨‍💻 Developer
Abdulaziz Shafae
Computer Information Systems
Built as a Capstone Project using Java, Spring Boot, MySQL, email integration, and AI.
<div align="center">

Loot | لوت
Use what you have. Cook what you can. Waste less.
</div>
