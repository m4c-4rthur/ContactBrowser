<%@include file="template/header.jsp"%>

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">


        <div class="page-header">
            <h1>Welcome Page</h1>
            <p class="lead">This is Welcome Page to Contact System </p>
        </div>

       <table border="0">
            <thead>
                <tr>
                    <th>Please login to the System</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <form name="login" action="login" onsubmit="return validateLogin()" method="post">
                            <br>
                            <br>
                            <b>User name:</b><br>
                            <input type="text" name="username">
                            <br>
                            <b>password:</b><br>
                            <input type="password" name="password">
                            <br>
                            <br>
                            <input type="submit" value="Log In" />    
                            <button type="reset" value="Reset">Cancel</button>
                        </form>
                        <button onclick="location.href = 'adminLogin.jsp';">Admin login</button>
                    </td>   
                </tr>
                <tr>
                    <td>
                        <br>
                        <br>
                        <span style="color:red">${error}</span> 
                    </td>

                </tr>
            </tbody>
        </table>
        <script src="<c:url value="js/loginValidations.js"/>"> </script>
        <%@include file="template/footer.jsp"%>
