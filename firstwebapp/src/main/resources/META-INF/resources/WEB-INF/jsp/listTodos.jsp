<%@ include file="common/header.jspf" %>
<body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
        <!--div>Welcome ${name}</div-->
        <!--hr-->
        <h1>Your Todos</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th>Target date</th>
                    <th>IsDone?</th>
                    <th> </th>
                    <th></th>
                </tr>
                
            </thead>
            <c:forEach items ="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a> </td>
                </tr>

            </c:forEach>
        </table>
        <a href="add-todos" class="btn btn-success"> Add todo</a> 
    </div>    
</body>
</html>
