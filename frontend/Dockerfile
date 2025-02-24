# Usa a imagem do Node.js para construir o frontend
FROM node:18 AS build

WORKDIR /app
COPY . .

# Instala dependências e gera a build
RUN npm install && npm run build

# Usa Nginx para servir o frontend
FROM nginx:latest
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
