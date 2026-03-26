# ☕ Java Lightweight HTTP Server

A minimalistic, high-performance HTTP server built from scratch using **Java SE**. This project demonstrates core networking concepts, routing, and static file serving without any external dependencies or frameworks.

## 🚀 Features
* **Zero Dependencies**: Built entirely using `com.sun.net.httpserver`.
* **Static File Serving**: Automatically serves HTML, CSS, and assets from the `/web` directory.
* **Clean Architecture**: Separated handlers for logic and file management.
* **Custom Routing**: Support for multiple endpoints (e.g., `/`, `/about-me`).

## 📁 Project Structure
```
├── serverHTTP/          # Java Source Code
│   ├── Main.java        # Server configuration & Routing
│   └── MainHandler.java # Request processing logic
├── web/                 # Static assets (Frontend)
│   ├── index.html
│   ├── about-me.html
│   ├── css/
│   │   ├── styles.css
│   │   └── about-me.css
│   ├── img/
│   │   └── butterfly.jpg
│   └── js/
│       └── script.js
└── .gitignore           # Clean repo (no .class or .DS_Store files)
```

## 🛠️ Getting Started

Prerequisites
* JDK 11 or higher installed.
* Terminal / Command Line access.

### Installation & Run

1. **Clone the repository:**

Via HTTPS:
```
git clone https://github.com/Jurajski00/java-http-server-evolution.git
```

Via SSH:
```
git clone git@github.com:Jurajski00/java-http-server-evolution.git
```

Then enter he directory:
```
cd java-http-server-evolution
```

2. **Compile the project:**

Use the `-d bin` flag to keep compiled bytecode separate from source code.
```
javac -d bin serverHTTP/*.java
```
3. **Launch the server:**

Use the `-cp bin` flag to point the JVM to the compiled bytecode in the bin folder.
```
java -cp bin serverHTTP.Main
```
4. **Access the application:**

Open your browser and navigate to: http://localhost:8080

## 📊 Endpoints

| Path | Description | Output Format |
| :---| :--- | :--- |
| `/` | Serves the `index.html` file from the `/web` folder. | `text/html` |
| `/about-me.html` | Serves the `about-me.html` file from the `/web` folder. | `text/html` |

**Note:** All static assets (CSS, JS, Images) located in the `/web` directory are automatically served with the correct MIME type.

## 🛡️ License

Distributed under the MIT License. See `LICENSE` for more information.

---
*Created by Daniel*