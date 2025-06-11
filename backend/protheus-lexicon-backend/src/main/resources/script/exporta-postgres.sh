
#exporta apenas os schemas
pg_restore --no-owner --no-privileges --table=sx3t10 --table=sx2t10 --table=sx6t10 --table=sx7t10 --table=sixt10 --table=sx1t10 --clean --create --schema-only -v -f v1_create_database.sql p1212410mntdbexp.dump

#exporta apenas os dados
pg_restore --no-owner --no-privileges --table=sx3t10 --table=sx2t10 --table=sx6t10 --table=sx7t10 --table=sixt10 --table=sx1t10 --data-only -v -f V2__populate_database.sql p1212410mntdbexp.dump


#INSERT INTO application.users (username, password) VALUES ('admin', '$2a$10$XqvP1xU6dJGGdWq0XWQsW.KqpyPM4eVq5opikbfaAbGxVBRmvCCtu');
#sudo docker-compose -f docker-compose.aws.yml up -d --build