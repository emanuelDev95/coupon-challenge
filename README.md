# coupon-challenge

## Ejecución de pruebas:

**Nota:** Se adiciona una carpeta postman en donde encontraran un coleccion donde podran importar y ejecutar las pruebas

1). En la collection de Postman brindada, se encuentra una carpeta llamada Auth, donde ejecuta un Metodo Post llamado "GetToken", allí generará un "access_token" el cual servirá para autenticarnos y asi ejecutar los consumos del api.
- En caso de que salga el mensaje: "message": "Error validating grant. Your authorization code or refresh token may be expired or it was already used", este quiere decir que ya existe un token y se tiene que ejecutar el refresh token.

- El token tiene un tiempo de vida de 6 horas, después de ese tiempo se tiene hacer uso nuevamente del método.
- Hay que tener en cuenta que nuestro token de autenticación se pasa por la cabezera (Headers) y tiene el valor de "token"


2). Tambien encontraran una carpeta llamada challenge, en la cual encontraran dos carpetas  una llamada aws y otra local, dependiendo de cual ambiente se quiere probar
 
- **aws**: en esta carpeta encontraran los request para probar los servicos ya desplegados de cupones y favoritos 

  - http://18.231.13.6/coupon
  - http://18.231.13.6/coupon/stats?ids=MLA1412962259,MLA1145029073,MLA1394823556,MLA1398389871,MLA1277641650
  
- **local**:  en esta carpeta encontraran los request para probar los servicos en ambiente local de cupones y favoritos

los items utilizados para las pruebas y el desarrollo fueron los siguientes: 

  | Items_Id | 
  | ------------- | 
  | MLA1412962259 | 
  | MLA1145029073 | 
  | MLA1394823556 | 
  | MLA1398389871 | 
  | MLA1277641650 | 

3).  tambien encontraran dos carpetas restanten una llamada items y otras calificaciones, las cuales contendran las apis usadas para este desarrollo

- items **GET** https://api.mercadolibre.com/items?ids=MLA1394823556,MLA1412962259,MLA1145029073,MLA1277641650,MLA1398389871&attributes=id,price
- calificaciones **GET** https://api.mercadolibre.com/reviews/item/MLA1145029073



## Instrucciones de Ejecución en ambiente local 

Prerrequisitos Java 17 o superior, Maven Instalación
1. Clonar el repositorio:

```console
git clone https://github.com/emanuelDev95/coupon-challenge.git
cd coupon-challenge
Construir el proyecto:
```

2. Construir proyecto

```console
mvn clean install

```
## Ejecución
1. Iniciar la aplicación:

```console
mvn spring-boot:run
```
2. La API estará disponible en http://localhost:8081.


## URL de la API
(Nivel 2 y 3): URL de la API desplegada en **AWS**

1. Metodo **POST CUPON:**

http://18.231.13.6/coupon

2. Metodo **GET FAVORITOS:**

http://18.231.13.6/coupon/stats?ids=MLA1412962259,MLA1145029073,MLA1394823556,MLA1398389871,MLA1277641650

## Pruebas unitarias

Se realizaron pruebas unitarias alcanzando un 89% de cobertura del codigo.

![alt text](/imgs/coverage.png)



