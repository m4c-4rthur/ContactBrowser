<%-- 
    Document   : editUser
    Created on : Feb 10, 2017, 9:22:17 AM
    Author     : hesham.ibrahim
--%>


<%@include file="template/header.jsp"%>
<div class="container-wrapper">


    <div class="container">
        <table border="0">
            <thead>
                <tr>
                    <th><h3>Edit User Info</h3> </th>
                </tr>
            </thead>
            <tbody>
            <form action="admin" method="post" name="user" onsubmit="return validateNewUser()">
                <tr>
                    <td>
                        Name: 
                    </td> 
                    <td>
                        <input type="text" name="name" value="${contactModel.name}"/>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Email:
                    </td> 
                    <td>
                        <input type="text" name="email" value="${contactModel.email}"/>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Telephone: 
                        <input type="hidden" name="contactId" value="${contactModel.contactId}"/>
                        <input type="hidden" name="action" value="editUser"/>
                    </td>
                    <td>
                        <input type="text" name="phoneNumber" value="${contactModel.phoneNumber}"/>

                    </td>
                </tr>
                <tr>
                    <td> 
                        <br>
                        <input type="submit" name="edituser" value="Save"> 
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
