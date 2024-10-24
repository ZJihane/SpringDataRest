# Step 1: Build the React app
FROM node:16-alpine AS builder
WORKDIR /app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install the dependencies
RUN npm install

# Copy the rest of the code to the container
COPY . .

# Build the React app
RUN npm run build

# Step 2: Serve the build using Nginx
FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
