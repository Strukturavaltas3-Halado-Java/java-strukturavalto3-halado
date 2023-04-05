# Adatbázis

```
docker run -d -e MARIADB_DATABASE=books -e MARIADB_USER=books -e MARIADB_PASSWORD=books -e MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=yes -p 3306:3306 --name books-mariadb mariadb
```