# API Automation Framework

This project is an API Automation Framework built with **Java**, **TestNG**, and **Maven**.  
It follows a modular design to keep services, models, listeners, and test cases well organized.  

---

## 📂 Project Structure

### `src/test/java`

This folder contains all executable and non-executable packages and classes.

---

### **1. com.api.base**
This package contains base services and reusable modules.

- **BaseService**  
  - Contains utility functions that can be reused across other classes.  
  - Other service classes extend this class to inherit its methods.

- **AuthService** & **UserProfileManagementService**  
  - Contains module-specific request methods (e.g., authentication, user profile management).  

---

### **2. com.api.models.request**  
This package contains **POJO (Plain Old Java Objects)** classes for request payloads.

- Each variable that needs to be sent as part of the request is defined here as `private`.
- Getter and Setter methods are provided for these variables.

---

### **3. com.api.models.response**  
This package contains **POJO classes** for handling API responses.

- Each response variable is defined here as `private`.
- Getter and Setter methods are provided for parsing API responses.

---

### **4. com.api.listeners**  
This package contains the custom **logger** implementation.

- Uses **ITestResult** interface from TestNG.  
- Captures test execution results and logs them into a separate file named **`testLog`**, located in:  
  ```
  src/test/java/resources
  ```
- Example logger declaration:
  ```java
  private static final Logger logger = LogManager.getLogger(TestListeners.class);
  ```

---

### **5. com.api.tests**  
This package contains the actual **executable test classes**.

- Each class contains **TestNG test methods**.  
- The respective **service class object** is created, and its methods are called.  

Example:
```java
public class ForgetPassword_Test {

    @Test(description = "Verify forget password....")
    public void verifyForgetPass() {
        AuthService authService = new AuthService();
        Response response = authService.forgetPassword("akas@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
```

---

## ▶️ Running the Framework

To execute the tests from the terminal, use **Maven Surefire Plugin**:

```bash
mvn clean test
```

You can also specify a test suite if required:

```bash
mvn clean test -Dsuite=suite
```

---

## ✅ Features
- Modular architecture for scalability.  
- Request & Response handling with POJOs.  
- Custom logging with TestNG Listeners.  
- Reusable base services for utility functions.  
- Easily extendable for new API modules.  

---
<img width="359" height="768" alt="API_Automation_Framework_Workflow" src="https://github.com/user-attachments/assets/f9da1d97-a1e1-464c-a566-b36bb5406928" />
