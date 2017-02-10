<%@include file="template/header.jsp"%>



<div class="container-wrapper">


    <div class="container">
        <h1>Welcome to my Assignment page</h1>
        <table border="0">
            <thead>
                <tr>
            <br>
            <br>
                    <th>Please login to the System</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <form name="login" action="admin" onsubmit="return validateLogin()" method="post">
                            <br>
                            <br>
                            <br>
                            <b>Admin name:</b><br>
                            <input type="text" name="username">
                            <br>
                            <b>password:</b><br>
                            <input type="password" name="password">
                            <br>
                            <br>
                            <input type="submit" value="Log In" />  
                            <input type="hidden" name="admin" value="1">
                            <input type="hidden" name="action" value="login">
                            
                            <button type="reset" value="Reset">Cancel</button>
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
 <%@include file="template/footer.jsp"%>