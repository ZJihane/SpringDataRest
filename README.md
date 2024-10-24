
# 🚗 Spring Data Rest Project with Docker, React Frontend, and Monitoring (Prometheus & Grafana)

This project is a **full-stack web application** built with a **React frontend**, a **Spring Boot backend**, and a **PostgreSQL database**, all containerized using **Docker**. Monitoring tools **Prometheus** and **Grafana** are included for performance tracking.

---

## 🛠️ Technologies Used

- **Frontend**: React.js
- **Backend**: Spring Boot 
- **Database**: PostgreSQL
- **Monitoring**: Prometheus and Grafana
- **Container Orchestration**: Docker & Docker Compose

---

## ⚡ Quick Start

To run the entire project locally, ensure you have **Docker** and **Docker Compose** installed.
The Docker images for both the backend and frontend come pre-configured with Node.js and Maven. Additionally, PostgreSQL is included as part of the Docker Compose setup. This means you don’t need to install any additional dependencies or databases on your local machine. The application will handle the Node.js, Maven, and PostgreSQL setups automatically during the Docker image build and container run processes.

### 1. 🚀 Clone the Repository  
```bash
git clone https://github.com/ZJihane/SpringDataRest.git
cd SpringDataRest
```

### 2. 🏗️ Build the Docker Images

Before running the application, you need to build the Docker images for both the backend and frontend services.

For the backend Spring Boot application:

```bash
docker build -t spring-data-rest .
```

For the React.js frontend:

```bash
cd src/main/webapp/reactjs
docker build -t reactjs-frontend .
```

> **Note:** This step may take some time due to the installation of Node dependencies and executing the `npm install` and `mvn clean package` commands.

### 3. ⏯️ Run Docker Compose

Once the images are built, run the Docker Compose command to start all services including PostgreSQL, Prometheus, and Grafana.

```bash
docker-compose up --build
```

### 4. 🌐 Access the Services
- **Frontend**: [http://localhost:3000](http://localhost:3000)
- **Backend API**: [http://localhost:8080](http://localhost:8080)
- **Prometheus Monitoring**: [http://localhost:9090](http://localhost:9090)
- **Grafana Dashboard**: [http://localhost:3001](http://localhost:3001)  
  (Default login: `admin` / `admin123`)

---

### 5. 🛑 Stopping the Services

To stop the running containers, run:

```bash
docker-compose down
```

## 📊 Monitoring Setup

- **Prometheus**: The application exposes metrics to Prometheus, which scrapes them from the backend at `/actuator/prometheus`.
- **Grafana**: Grafana is pre-configured to display metrics from Prometheus. You can explore the dashboards at `http://localhost:3001`.

## ⚠️ Notes

- Ensure PostgreSQL is available at port `5433` if running another PostgreSQL instance on your machine.
- If any service fails to start, check the logs using `docker logs <container_name>` for more details.

