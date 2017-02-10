
<%@include file="template/header.jsp"%>



<div class="container-wrapper">
    
    
    <div class="container">
        <h1>Welcome ${sessionScope.userName}!!!</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>Please Choose the Desired action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <form name="login" action="client" method="post">
                            <br>
                            <br>
                            <input type="submit" value="View Contacts" />    
                        </form>
                    </td>   
                </tr>
                <tr>
                    <td>
                        <span class="error">${error}</span> 
                    </td>

                </tr>
            </tbody>
        </table>
        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                </tr>
            </thead>
            <c:forEach items="${contactList}" var="contact">
                <tr>
                    <td><c:out value="${contact.name}" /></td>
                    <td><c:out value="${contact.email}" /></td>
                    <td><c:out value="${contact.phoneNumber}" /></td>
                </tr>
            </c:forEach>
        </table>


        <%@include file="template/footer.jsp"%>