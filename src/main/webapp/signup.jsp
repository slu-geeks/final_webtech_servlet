<!doctype html>

<html>
<head>
    <title>Add New Account</title>

</head>

<body>

<form method="post" action="/signup" enctype="multipart/form-data">
    <p>username: <input type="text" name="username"/></p>
    <p>password: <input type="password" name="password"/></p>
    <p>address: <input type="text" name="address"/></p>
    <p>first name: <input type="text" name="firstName"/></p>
    <p>last name: <input type="text" name="lastName"/></p>
    <p>middle initial: <input type="text" name="middleInitial"/></p>
    <p>email address: <input type="text" name="emailAddress"/></p>
    <p>phone number: <input type="text" name="phoneNumber"/></p>
    <p>date of birth: <input type="date" name="dateOfBirth"/></p>
    <p>person pic: <input type="file" name="personPicture" required></p>
    <input type="submit" value="submit" />
</form>
</body>
</html>
