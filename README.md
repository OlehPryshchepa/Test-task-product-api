###### <h1 style="text-align: center;"> <img src="https://em-content.zobj.net/source/apple/354/card-file-box_1f5c3-fe0f.png" width="35"/> Test Task API <img src="https://em-content.zobj.net/source/apple/354/card-file-box_1f5c3-fe0f.png" width="35"/> </h1>

## Technologies Used:
<ul>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="https://img.icons8.com/color/48/000000/java-coffee-cup-logo--v1.png"/> <b>Java</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="https://img.icons8.com/color/48/000000/spring-logo.png"/> <b>Spring Boot</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="https://img.icons8.com/color/48/000000/spring-logo.png"/> <b>Spring Security</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="https://img.icons8.com/color/48/000000/spring-logo.png"/> <b>Spring Data JPA</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="https://img.icons8.com/color/48/000000/mysql.png"/> <b>MySQL</b>
</li>
<li>
<b>Lombok</b>
</li>
<li>
<b>MapStruct</b>
</li>
</ul>

<h5>Description:</h5>
<ol>
<li>Uses Spring Data JPA for simplified data access and persistence.</li>
<li>The MySql database is employed to store products and users securely.</li>
<li>Integrates Swagger for API documentation, providing a clear and accessible reference for developers.</li></ul>
</ol>

## API Endpoints <img src="https://em-content.zobj.net/thumbs/160/apple/354/link_1f517.png" width="25"/>
### 1. User registration
- **Endpoint**: `/users/add`
- **Method**: `POST`
- **Description**: Register a new user, returning the generated JWT token.
### 2. User authentication
- **Endpoint**: `/admin/authenticate`
- **Method**: `POST`
- **Description**: Authenticate user and generate a JWT token for authorization.
### 3. Save new products 
- **Endpoint**: `/products/add`
- **Method**: `POST`
- **Description**: Retrieve a list of records.
### 4. Get all products
- **Endpoint**: `/products/all`
- **Method**: `GET`
- **Description**: Retrieve a list of saved records.
## <p id="how-to-start-the-program">🔨How to start the program</p>
To run this application follow these steps:
* use mvn clean package in terminal
* start your program
* the access to the swagger page via [link](http://localhost:8080/swagger-ui/index.html#/) after application started
