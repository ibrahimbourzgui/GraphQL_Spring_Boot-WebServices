<h3>This is a first touch project with GraphQL, it's developped using Spring Boot, including all CRUD methods(Add, Delete, Update, Select, and SelectById), i used H2 Memory as Database.</h3>
<br> <br>
<h2>1-SELECT</h2>
<h4>one of the most interesting features of GraphQL, is the posiblity of calling just the needed properties of the class, as you can see in the two first Screenshots</h4>
<br>
<h6>It's a GET query, in GraphQL GET queries are represented with @QueryMapping annotation</h6>
<h5>In the first photo we're calling just two properties (id and name) of the product</h5>
<img src="https://user-images.githubusercontent.com/47062719/205896545-95abf4a9-1ebf-479a-bfb2-0463d757d118.jpg"> <br>
<h5>While in the second photo we're calling id, name, price, and category that contains also id and name (it's a two-way relations between the two Entities (Category, and Product) of the product</h5>
<img src="https://user-images.githubusercontent.com/47062719/205897545-f4b47d99-c742-452c-8bab-f07a9dd508f2.jpg">

<br> <br> <br>
<h2>2- ADD</h2>
<h6>It's a POST query, in GraphQL POST queries are represented with @MuationMapping annotation, we can use it also for queries like (DELETE, PUT, PATCH)</h6>
<h5>As you can see here, i'm inserting data into the the database, by calling SaveProduct method, and it returns the inserted product</h5>
<img src="https://user-images.githubusercontent.com/47062719/205896545-95abf4a9-1ebf-479a-bfb2-0463d757d118.jpg"> <br>
<br> <br> <br>
<h2>3- Update</h2>
<h5>As you can see here, i'm updating an existing product in the Database, by calling updateProduct method, and it returns the updated product</h5>
<img src="https://user-images.githubusercontent.com/47062719/205903263-1e31cd3b-ce9f-47cf-925f-a1e42115667d.jpg"> <br>
<br> <br> <br>
<h2>4- Delete</h2>
<h5>Here, i'm deleting an existing product by providing the ID of the product, and calling deleteProduct method, it returns the NULL, that means the product has been deleted succefully, because it's a VOID method, it returns nothing</h5>
<img src="https://user-images.githubusercontent.com/47062719/205904388-914ba6e3-0522-4d26-b240-a04e52ac3f4f.jpg"> <br>
<br> <br> <br>
<h2>5- Find By ID</h2>
<h5>Here, i'm searching a product by providing the ID, and calling findById method, it returns the specified fiedls in the call</h5>
<img src="https://user-images.githubusercontent.com/47062719/205905508-54051d82-dd5c-48e1-9684-38f7d931c82f.jpg"> <br>

<br> <br> <br>
<h2>6- Exception Handler</h2>
<h5>Finally, i created a Java class to handle GraphQL exceptions, GraphQL by defualt is not configured to return the exact exception as you can see in the first photo below</h5>
<img src="https://user-images.githubusercontent.com/47062719/205906371-c8ffb36b-7929-4b7b-b32a-9cc8b922dd5b.jpg"> <br>
<h5>As you can see here, it's showing the wanted Error to display</h5>
<img src="https://user-images.githubusercontent.com/47062719/205906521-ae32d3f7-6817-4d89-b1f3-b8db70ef31d6.jpg"> <br>
<br> <br>
<h1>THANKS FOR READING ALL THE DOCUMENTATION <br> FOR CONTACT HERE IS MY LinkedIn PROFILE </h1> https://www.linkedin.com/in/ibrbou/
