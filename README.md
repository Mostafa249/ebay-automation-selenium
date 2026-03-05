# 🛠 eBay Automation Framework

This is a **Selenium + TestNG + Maven automation framework** for testing the [eBay](https://www.ebay.com/) website.  
The framework includes search operations, filtering scenarios, and validation of search results. All test results are generated using **Allure reporting**.

---

## ⚙ Tools & Technologies Used

- **Java 21** – Programming language  
- **Maven** – Dependency and build management  
- **Selenium WebDriver** – Browser automation  
- **TestNG** – Test execution and assertions  
- **Allure** – Test reporting and visualization  
- **ChromeDriver / WebDriverManager** – Browser automation and driver management  
- **Git & GitHub** – Version control  
- **IntelliJ IDEA** – IDE  

---

## 📂 Project Structure
ebay-automation/
├─ src/main/java/pages/ # Page Object classes
├─ src/main/java/base/ # Base classes (BasePage, BaseTest)
├─ src/test/java/tests/ # Test classes
├─ src/test/resources/ # Test data (JSON) and TestNG XML
├─ pom.xml # Maven dependencies
├─ .gitignore
└─ README.md

---

## ⚡ How to Set Up the Framework

1. **Clone the project**

```bash
git clone <your-repo-url>
cd project-name
```

2. **Install Maven dependencies**

```bash
mvn clean install
```

3. **Set configuration / test data**
  - Open src/test/resources/searchData.json (or your test data file)
  - Update the searchItem value as needed:

```json
{
  "searchItem": "mazda mx-5"
}
```

4. **Run the tests**
   - Using TestNG XML:
     ```bash
     mvn test
     ```
    - Or directly from IntelliJ IDEA by right-clicking testng.xml → Run

5. **View Allure Reports**
   - After running tests, generate and open the report:
   ```bash
   allure serve target/allure-results
   ```
   
