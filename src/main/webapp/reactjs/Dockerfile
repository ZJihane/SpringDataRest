# Step 1: Build the React application
FROM node:20-alpine AS build

WORKDIR /app

# Install dependencies
COPY package.json ./
RUN npm install --legacy-peer-deps

# Copy the rest of the code and build the application
COPY .. ./
RUN npm run build

# Step 2: Serve the build using Nginx
FROM nginx:alpine

# Copy the build output to the Nginx HTML folder
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
