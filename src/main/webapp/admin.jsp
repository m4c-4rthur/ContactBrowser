
<%@include file="template/header.jsp"%>



<div class="container-wrapper">


    <div class="container">
        <h1> Administrator panel</h1>
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <form action="admin" method="post">
                            <div class="page-header">
                                <h3>Users List</h3>
                            </div>

                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr class="bg-success">
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Phone Number</th>
                                        <th>Edit Info</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${contactList}" var="contact">
                                    <tr>
                                        <td><c:out value="${contact.name}" /></td>
                                        <td><c:out value="${contact.email}" /></td>
                                        <td><c:out value="${contact.phoneNumber}" /></td>
                                        <td><input type="submit" name="edit" value="edit" /></td>
                                        <td><input type="hidden" name="contactId" value="${contact.contactId}" /></td>
                                        <td><input type="hidden" name="action" value="editPage" /></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            </select>    
                            <br>
                            <br>
                        </form>
                        <form action="admin" method="post">
                            <input type="submit" name="add" value="Add User" />
                            <input type="hidden" name="action" value="addPage" />
                        </form>
                    </td>   
                    <td><span class="message">${usermessage}</span></td>
                </tr>
            </tbody>
        </table>
        <%@include file="template/footer.jsp"%>
