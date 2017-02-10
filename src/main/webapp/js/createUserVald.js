function validateNewUser() {
    var username = document.forms["user"]["name"].value;
    var emailaddress = document.forms["user"]["email"].value;
    var telephone = document.forms["user"]["phoneNumber"].value;
    var usernameLength = username.length;
    
    if ((username == null || username == "") 
            && (emailaddress == null || emailaddress == "") 
            && (telephone == null|| telephone == ""))  {
        alert("You must enter at least one Value");
        return false;
    }
    if(usernameLength > 50)
    {
        alert("User Name must not exceed 50 characters");
        return false;
    }
    var email =  validateEmail(emailaddress);
    if(!email)
    {
        alert("Please enter valid email format");
         return false;
    }
    if (telephone == null || telephone == "") {
        alert("Please enter User's Telephone number");
        return false;
    }
      
   var mobile = telephone.match(/\d/g).length===11;
   var home = telephone.match(/\d/g).length===10;
   if(!(mobile || home))
   {
       alert("Please enter valid phone number format");
        return false;
   }
    
}
function validateEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}



