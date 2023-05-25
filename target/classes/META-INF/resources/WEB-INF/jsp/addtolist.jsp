<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form:form method="post" modelAttribute="toDoList">
        <h1>New Item</h1>
        <form:input type="text" name="description" path="task" required="required"/>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="status" value="false"/>
        <input type="submit" value="submit">
    </form:form>
</body>
</html>