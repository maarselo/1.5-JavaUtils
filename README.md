 # 📂 1.5-JavaUtils

A complete set of file handling and configuration exercises in Java.
This project demonstrates how to work with directories, files, serialization, and configuration files using Java's standard APIs. 

## 📄 Description - Exercise Statement
This repository contains the full solution for Sprint 1 - JavaUtils of the Java programming track.
The sprint is divided into two levels, progressively introducing techniques for reading, writing, and managing files and directories from the command line.

## 💥 Level 1

### Exercise 1
Implements a class that lists the contents of a directory (provided as an argument) in alphabetical order.

### Exercise 2
Enhances the previous class to recursively list the directory tree, sorting alphabetically at each level, and indicating whether each item is a directory (D) or file (F), along with its last modified date.

### Exercise 3
Modifies the previous version so that the output is written to a .txt file instead of being printed to the screen.

### Exercise 4
Adds the ability to read any .txt file and print its content to the console.

### Exercise 5
Implements object serialization to save a Java object to a .ser file, and then deserializes it to restore the object.

## ⚙️ Level 2
### Exercise 1
Reuses Exercise 3 from Level 1 but now reads all parameters from a configuration file.

The following aspects are parameterized:
- Directory to read
- Name and location of the resulting .txt file

You can use either a Java Properties file or the Apache Commons Configuration library to achieve this.

## 💻 Technologies Used
- Java (SDK 23)
- IntelliJ IDEA or any Java-compatible IDE
- Java Properties

## 📋 Requirements
Before running this project, make sure you have:

- Java SDK **17+** or higher (SDK 23 was used during development)
- An IDE like IntelliJ IDEA or Eclipse
- Git (optional, for version control)

## 🛠️ Installation

To run this project, you **must first clone the repository locally**. Otherwise, you won't be able to open it correctly in IntelliJ IDEA.
To get a local copy of the project:

```bash
# Clone this repository
https://github.com/maarselo/1.5-JavaUtils.git

# Navigate into the project directory
cd 1.5-JavaUtils/
```

### 📥 Cloning and Opening in IntelliJ IDEA

1. Open **IntelliJ IDEA**.
2. On the welcome screen, click **"Clone Repository"** (Get from Version Control).
3. Paste the following URL into the **URL** field:
```bash
git clone https://github.com/maarselo/1.5-JavaUtils
```
4. Choose the folder where the project should be saved.
5. Click **Clone**.

 if you already have it cloned, click on `Open` and select the local copy to open it. 

## ▶️ Running the Project

Each exercise can be compiled and executed from the command line using javac and java:

- Compile .java files to .class
- Run the corresponding main class using the java command

For example:
```bash
javac src/level1/ListDirectory.java  
java -cp src level1.ListDirectory
```
Make sure to adjust the class and path names according to each exercise. And pass an argument too if necessary as in the first level where folders have to be passed.

## 🌐 Deployment

This project is intended to run in a **local development environment** only.  
No production deployment configuration has been defined.

In the future, it could be extended into a GUI or web-based application for a better user experience.

## 🤝 Contributions

Contributions are welcome! If you’d like to collaborate:

1. Fork this repository.
2. Create a new branch:  
 `git checkout -b feature/YourFeatureName`
3. Make your changes and commit them:  
 `git commit -m "Add: Your meaningful commit message"`
4. Push your branch to your fork:  
 `git push origin feature/YourFeatureName`
5. Open a pull request with a clear description of your changes.

Thanks for your interest and support! 🚀
