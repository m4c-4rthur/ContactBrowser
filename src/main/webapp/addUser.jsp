<%-- 
    Document   : addUser
    Created on : Feb 10, 2017, 11:06:20 AM
    Author     : hesham.ibrahim
--%>
<%@include file="template/header.jsp"%>
<div class="container-wrapper">


    <div class="container">
<table border="0">
    <thead>
        <tr>
            <th><h3>Add new User</h3> </th>
        </tr>
    </thead>
    <tbody>
    <form action="admin" method="post" name="user" onsubmit="return validateNewUser()">
        <tr>
            <td>
                Name: 
            </td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>
                Email: </td>
            <td>
                <input type="text" name="email"/>
            </td> 
        </tr>
        <tr>
            <td>
                Telephone: 
            </td>
            <td>
                <input type="text" name="phoneNumber"/>
            </td>
        </tr>
        <tr>
            <td> 
                <br>
                <br>
                <input type="submit" name="createuser" value="Create"> 
                <input type="hidden" name="action" value="addUser"> 
                <button type="reset" value="Reset">Cancel</button>

    </form>
    <br>
    <br>
    <form action="admin" method="post"> 
        <input type="submit" name="back" value="Back to Panel">
        <input type="hidden" name="action" value="backToPanel">
    </form>
</td>
</tr>
<tr><td><span class="error">${error}</td></tr>
</tbody>
</form>
</table>        
<script src="<c:url value="js/createUserVald.js"/>"> </script>
<%@include file="template/footer.jsp"%>
