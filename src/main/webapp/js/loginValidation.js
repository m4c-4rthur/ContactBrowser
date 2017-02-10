function validateLogin() {
    var username = document.forms["login"]["username"].value;
    if (username == null || username == "") {
        alert("User Name must be filled out");
        return false;
    }
    var usernameLength = username.length;
    if(usernameLength > 50)
    {
        alert("User Name must not exceed 50 characters");
        return false;
    }
    var password = document.forms["login"]["password"].value;
    if (password == null || password == "") {
        alert("Password must entered");
        return false;
    }
    var newPassword = document.forms["login"]["password"].value;
    var confrim = document.forms["login"]["confirm"].value;
    if(!newPassword === confrim)
    {
        alert("Password does not matches");
        return false;
    }
}


