# OrangeHRM Automation Project

## 📌 Project Overview

This project showcases both **Manual Testing** and **Automation Testing** practices applied on the [OrangeHRM](https://opensource-demo.orangehrmlive.com/) web application. It includes all critical test documentation and an extensive Selenium automation suite that covers a wide range of testing scenarios.

---

## 🧪 Manual Testing Deliverables

- ✅ **Test Plan Document**
- ✅ **Test Case Suite** (Functional, UI, Boundary, etc.)
- ✅ **Bug Reports** (With severity & priority)
- ✅ **SRS (Software Requirements Specification)**

All documents are included for reference and practical demonstration of a full testing lifecycle.

---

## 🤖 Automation Stack

| Tool        | Purpose                           |
|-------------|-----------------------------------|
| **Java**    | Programming language              |
| **Selenium**| Web automation framework          |
| **TestNG**  | Testing framework                 |
| **Maven**   | Project build and dependency mgmt |
| **AutoIT**  | File upload automation            |
| **AutoFinder** | Used to find upload dialog paths |
| **JIRA**    | Bug/issue tracking                |
| **Excel**   | Test data management              |

---

## ⚙️ Automation Coverage

The automation suite covers:
- ✅ Login, logout flows
- ✅ Uploading files and photos (via AutoIT)
- ✅ Handling dropdowns and form submissions
- ✅ Add, edit, reset, delete actions
- ✅ Validations with `assert` and `SoftAssert`
- ✅ Data-driven testing via Excel
- ✅ TestNG annotations and suite management
- ✅ Use of loops, waits, and exception handling

---

## 📂 Project Structure

orange-hrm-automation/
├── /testcases/ → Selenium test classes
├── /autoit/ → AutoIT scripts
├── /screenshots/ → Captured evidence
├── /testdata/ → Excel test data
├── /manual-docs/ → Test plan, SRS, bug reports
├── pom.xml → Maven config
└── README.md → Project info (this file)





---

## 🚀 How to Run

1. Clone the repo:  
   `git clone https://github.com/nitishere/orange-hrm-automation.git`

2. Import the project into **Eclipse** or **IntelliJ** as a Maven project.

3. Install dependencies:  
   `mvn clean install`

4. Run test suites using TestNG XML file.

---

## 🙋‍♂️ Author

**Nitish Mittal**  
> Manual & Automation Test Engineer  
> 🔗 [LinkedIn (optional)](https://www.linkedin.com/in/nitishmittal)  
> 📧 Contact me for collaboration, feedback, or hiring!

---

## 📄 License

This project is for learning and demonstration purposes only.
