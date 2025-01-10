# Halal Pairing

## Overview
The **Halal Pairing** is an innovative platform developed to facilitate ethical matchmaking and foster meaningful connections. Designed with inclusivity and security in mind, the app integrates user management, matchmaking, event organization, secure payments, and real-time messaging. This five-month-long project demonstrates the application of robust backend logic, a dynamic frontend interface, and an efficient database system.

---

## Features

### **1. User Management**
- **Registration & Login**: Secure user registration with CNIC and password.
- **Profile Management**: Update user profiles, interests, and preferences.
- **Premium Membership**: Upgrade users to premium accounts for exclusive features.

### **2. Matchmaking**
- Find partners based on compatibility and interests.
- Calculate similarity indices and store matches for easy access.
- Securely manage feedback for continuous improvement.

### **3. Event Management**
- Organize halal events with gender-specific filters.
- Allow users to participate and explore community-driven events.

### **4. Communication**
- **Real-time Messaging**: Chat securely with matches.
- **Chat History**: Retrieve message history between users.

### **5. Payment Processing**
- Handle payments via Credit Card and Microfinance.
- Maintain transaction logs securely in the database.

### **6. Complaint Handling**
- Users can report issues and file complaints.
- Admin reviews complaints and takes necessary actions (e.g., warnings, restrictions).

---

## Technology Stack

### **Frontend**
- JavaFX for dynamic and interactive user interfaces.
- FXML for defining UI structure.

### **Backend**
- Java for business logic and application functionality.
- JDBC for database connectivity.

### **Database**
- MySQL for efficient and scalable data management.

---

## Installation and Setup

### **1. Clone the Repository**
    git clone https://github.com/Nouman-Amjad/HalalPairingApp.git
### **2. Set Up the Database**
1. Install MySQL and create the database:
    ```bash
    CREATE DATABASE HALAL_PAIRING;
2. Import the database schema provided:
    ```bash
    mysql -u root -p HALAL_PAIRING < schema.sql
### **3. Configure the Application**
Update the database credentials in Password.java:
    ```code
    public static String DBpassword = "your_password";
### **4. Run the Application**
1. Open the project in IntelliJ IDEA or Eclipse.
2. Run the Main class to launch the application. 

## File Structure
### Frontend
- **FXML Files**: 
    - **Login.fxml**: User login page. 
    - **createAcc.fxml**: Registration page.
    - **Chat.fxml**: Chat interface.
- **Controllers**:
    - **ChatboxController.java**: Handles messaging and chat navigation.
    - **ChatController.java**: Manages chat content and history.
### Business Logic
- **Admin.java**: Handles user complaints and restrictions.
- **HalalPairing.java**: Core business logic for user, event, and match management.
- **Feedback.java**: Stores and manages user feedback.
### Database Layer
- **MatchDBhandler.java**: Manages user matches and similarity indices.
- **PaymentDBhandler.java**: Processes user payments.
- **ComplainDBhandler.java**: Handles complaints lodged by users.

## How It Works - User Flow
### 1. Registration:
    - New users register with CNIC and secure credentials.
### 2. Login:
    - Users log in to access their dashboard.
### 3. Matchmaking:
    - Users explore potential matches and initiate chats.
### 4. Event Participation:
    - Users join community events.
### 5. Feedback & Complaints:
    - Users provide feedback or report issues.
### 6. Admin Actions:
    - Admin reviews complaints and manages user restrictions.

## Future Enhancements:
- Implement AI-driven matchmaking algorithms for improved compatibility.
- Integrate a notification system for new matches and events.
- Expand payment options to include international gateways.
- Develop a mobile version for broader accessibility.

## Acknowledgments
Special thanks to the faculty at FAST-NUCES for their guidance and support during this project.

## License
This project is licensed under the MIT License.