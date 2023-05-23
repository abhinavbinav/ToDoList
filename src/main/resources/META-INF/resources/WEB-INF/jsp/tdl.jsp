<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>${name}'s To Do List</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Task</th>
                <th>Status</th>
                <th>Delete?</th>
                <th>Update?</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="todo">
                <tr>
                    <td>${todo.name}</td>
                    <td>${todo.task}</td>
                    <td>${todo.status}</td>
                    <td><a href="deletetodo?task=${todo.task}">DELETE</a></td>
                    <td><a href="updatelist?task=${todo.task}&currenttask=${todo.task}">UPDATE</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="addtolist">Add to List</a>
</body>
</html>