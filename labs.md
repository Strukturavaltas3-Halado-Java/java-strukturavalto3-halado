# Konzultáción elhangzó gyakorlati feladatok

Tesztesetek írása akkor is javasolt, ha ez nem szerepel a feladatleírásban.

# WEEK 01 (2023.02.06-2023.02.10)

## DAY 02

Készíts egy osztályt `Algorithms` néven, benne egy metódussal, ami egész számok listáját várja.
Tudjuk, hogy a listában minden szám egyszer szerepel, kivéve egyet. A feladat az, hogy add vissza
azt a számot amelyik többször szerepel!

## DAY 03

Készíts egy `Movie` osztályt. Minden filmnek legyen egy egyedi azonosítója, egy címe, egy gyártási dátuma 
egy hossza, és egy műfaja ami enum típusú.  
Készíts egy `MovieService` osztályt melyben filmek listája található. 
Legyen egy `addMovie()` metódus amivel filmet lehet hozzáadni a listához, de figyeljünk arra, hogy csak 1911.01.01
utáni filmek kerülhessenek a listába.  
Továbbbi metódusok:
- Legyen egy metódus ami cím alapján talál meg egy filmet. Feltételezhetjük, hogy nincs két ugyanolyan című film. 
- Legyen egy metódus, ami csak egy paraméterül kapott bizonyos évszám utáni filmeket ad vissza egy listában. 
- Legyen egy metódus ami egy map-ben visszaadja műfajonként a filmeket egy listában. 

# WEEK 02 (2023.02.13-2023.02.17)

## DAY 01

Az [orders-app példa alkalmazás](https://github.com/Strukturavaltas3-Halado-Java/java-strukturavalto3-halado/tree/main/lab-solutions/consultation_w02d01/orders-app)-t kell 
lemásolni magadhoz a saját gépedre. A tesztosztályokban már benne vannak a megoldások, ezért azokból töröld ki az összes tesztmetódust, 
majd írd meg őket az alábbiak szerint:

* Írj tesztet az `Order` osztályra! (A kétféle létrehozásra.)
* Írj tesztet az `OrderRepository` `saveOrder()` metódusára! (Az id-ra úgy kell assertet írni, hogy abban ne szerepeljen az id tényleges értéke.)
* Írj tesztet az `OrderRepository` `getOrders()` metódusára! (Kollekcióra az AssertJ-vel írj assertet!)
* Írj egy paraméterezett tesztet az `OrderRepository` `getOrdersOverLimitedOrderPrice()` metódusára,
  legalább két különböző értékkel! 
* Hozz létre egy tesztosztályt az `OrderService` osztályra, amelyben kimockolod a osztály függőségét az `OrderRepository`
  osztályra!
* Írj egy-egy tesztesetet az `OrderService` osztály `saveOrder()` és `saveOrderAndDontReturnGeneratedKeys()` metódusaira! 
  (Figyeld meg, mi a különbség egy `void` és egy tényleges visszatérési értékkel rendelkező metódus mockolt tesztelésénél!)
* Írj egy tesztesetet az `OrderService` osztály `getOrders()` metódusára! (Gondolkozz el azon, hogy egy egysoros metódusnál mit lehet érdemes egyáltalán tesztelni!)
* Írj két tesztesetet az `OrderService` osztály `getOrdersOverLimitedOrderPrice()` metódusára! Az egyikben
  egy sima lefutást tesztelj, a másikban egy kivételdobást! 
* Írj egy tesztesetet az `OrderService` osztály `collectProductsAndCount()` metódusára!



## DAY 04

Hozz létre egy új projektet a labs repódban `users-jpa-project` néven és ebbe a projektbe dolgozz!

Készíts egy `users.User` entitást. A felhasználónak legyen egy felhasználóneve, és egy jelszava egy `Role` enum típusú attribútuma, ami
lehet `ADMIN` vagy `USER`. Figyelj arra, hogy az adatbázisban a tábla és az oszlopk neve konvenciónak megfelelő legyen.

Készíts egy `users.UserRepository` nevű osztályt, ami az adatbázissal való kommunikációért felelős.
Ebben az osztályban legyen egy `saveUser(User user)` nevű metódust, ami elment egy felhasználót az adatbázisba. 
Legyen benne még egy `findUserById(long id)` és egy `findUserByUserName(String ussername)` metódus is. 
Végezetül legyen egy `updateUserPassword(String username, String newPassword)` metódus, ami megkeresi az adatbázisban
a felhasználót a neve alapján, majd frissíti a jelszavát. 


# WEEK 03 (2023.02.20-2023.02.24)

## DAY 03

Hozz létre egy új projektet a labs repóban a neve legyen `trainings-jpa-project`.

A trainings csomagba dolgozz. Készíts egy Trainer nevű entitást. Attribútumai egy String name és egy Status status, ami egy felsorolásos típus (JUNIOR,INTERMEDIATE,SENIOR). Ezeket az értékeket konstruktorban kapja meg.  
Készíts egy Training nevű entitást. Attribútumai: String title, LocalDate startDate, LocalDate endDate. A kapcsolat a kettő között, 
hogy egy oktató több traininget is vihet, de egy training csak egy oktatóhoz tartozik.

Készítsd el a `TrainersTrainingsRepository`-t. Ebben lehessen oktatókat lementeni. Lehessen tanfolyamot is
lementeni, de csak úgy, hogy megkapjuk az oktató azonosítóját.  

Írj egy metódust amivel egy trainert lehet lekérdezni az összes olyan tanfolyamával ami egy adott időszakra esik.
Trainer findTrainerWithTrainingsBetween(long trainerId, LocalDate startDate, LocalDate endDate).

# WEEK 04 (2023.02.27-2023.03.03)

## DAY 01

A konzultációs feladat kiírása itt található:

[Feladatkiírás](https://github.com/Strukturavaltas3-Halado-Java/java-strukturavalto3-halado/tree/dbbe3413b001bcad76bf1a865d55800b10ccc3f9/lab-solutions/consultation_w04d01)

(Vigyázat, ez a feladat egy korábbi állapotának linkje, és ezt az állapotot érdemes lemásolni, mert azóta felkerült a megoldás is.)


# WEEK 07 ( 2023.03.20-2023.03.24)

## DAY 04
A mai feladatban ismét egy filmekkel foglalkozó alkalmazást kell összeraknod.  

A `Movie` entitásnak legyen egy azonosítója, egy címe, egy hossza, egy, az eddigi értékeléseket
tartalmazó listája és egy értékelésátlaga.
Minden egyes alkalommal amikor egy értékelést kap a film, akkor az értékelésátlag ennek megfelelően változik!   

Legyen egy `MovieService` osztályod, ami listában tárolja a filmeket. Kezdetben a lista üres, később tudunk filmet hozzáadni.   

Legyen egy `MovieController` ami alapértelmezetten az `api/movies` URL-en várja a kéréseket.   

A következő funkciókat kell megvalósítani:

* Lehessen lekérni az összes filmet illetve új filmet hozzáadni (cím és hossz) a `api/movies` végponton.
* A `/{id}` URL-en keresztül lehessen egy aktuális filmet lekérdezni.
* A `/{id}/ratings` URL-en keresztül lehessen egy filmre értékelést adni és az értékeléseit lekérdezni. GET esetén adjuk vissza a film értékeléseinek listáját. POST esetén egy számot várunk, de az értékelések listájával térünk vissza.