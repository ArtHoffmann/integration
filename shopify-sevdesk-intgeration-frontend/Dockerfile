# Use a specific version of the official Node.js image based on the slim variant
FROM node:20.15.1 AS build

# Set the working directory
WORKDIR /app

# Copy required files for installing dependencies
COPY ./shopify-sevdesk-intgeration-frontend/*.json ./
COPY ./shopify-sevdesk-intgeration-frontend/apps/shopify-sevdesk/ ./apps/shopify-sevdesk/

RUN ls -la

RUN npm i -g nx

# Install dependencies
RUN npm cache clean --force && npm install --registry https://registry.npmjs.org/


# Set NX_DAEMON environment variable to false to prevent nx from running in daemon mode
ENV NX_DAEMON=false

# Build the application
RUN nx run shopify-sevdesk:build


# Stage 3: Serve the Angular application with Nginx
FROM nginx:bullseye as production
COPY --from=build /app/dist/apps/shopify-sevdesk/browser /usr/share/nginx/html
COPY ./nginx/conf.d /etc/nginx/conf.d

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
