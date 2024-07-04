# Stage 1: Install dependencies
FROM node:18 AS install
WORKDIR /app
COPY ./sevdesk-shopify-integration/package.json ./
COPY ./sevdesk-shopify-integration/package-lock.json ./

RUN npm install

# Stage 2: Build the Angular application
FROM install as build
COPY . .
RUN npx nx reset && npx nx build shopify-sevdesk

# Stage 3: Serve the Angular application with Nginx
FROM nginx:stable-alpine as production
COPY --from=build /app/dist/apps/shopify-sevdesk /usr/share/nginx/html
COPY ./nginx/conf.d/default.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
