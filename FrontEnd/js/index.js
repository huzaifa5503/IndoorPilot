var firebaseConfig = {
  apiKey: "AIzaSyAMY7Ogac5NRk_HsP7FVkGJI4p47k43uN4",
  authDomain: "indoorpilotwebapp.firebaseapp.com",
  databaseURL: "https://indoorpilotwebapp.firebaseio.com",
  projectId: "indoorpilotwebapp",
  storageBucket: "indoorpilotwebapp.appspot.com",
  messagingSenderId: "404437924397",
  appId: "1:404437924397:web:a1808137987de4643d16a4",
  measurementId: "G-EPF9CQZH3V"
};
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  

  firebase.auth.Auth.Persistence.LOCAL; /* this line indiactes that user will be not
  logged out unless he clicks the logout button or the history is deleted */


  /* The below code is about on click action of button login */
  $("#btn-login").click(function()
  {
      var email = $("#email").val();
      var password = $("#password").val();
      if(email != "" && password != "")
      {
        var result = firebase.auth().signInWithEmailAndPassword(email, password);
        result.catch(function(error)
        {
            var errorCode= error.code;
            var errorMessage=error.message;

            console.log(errorCode);
            console.log(errorMessage);
            window.alert("Message :" + errorMessage);
        });
      }
      else
      {
        window.alert("Please fill out all fields");
      }

  });

  /* The below code is about on click action of button logout */

  $("#btn-signup").click(function()
  {
      var email = $("#email").val();
      var password = $("#password").val();
      var cPassword = $("#confirmPassword").val(); /* for confirm pass */


      if(email != "" && password != "" && cPassword != "") /* if email pass are not blank */
      {
        if(password == cPassword)
        {
          var result = firebase.auth().createUserWithEmailAndPassword(email, password);
          result.catch(function(error)
          {
              var errorCode= error.code;
              var errorMessage=error.message;
  
              console.log(errorCode);
              console.log(errorMessage);
              window.alert("Message :" + errorMessage);
          });


        }
        else
        {
          window.alert("Password do not match with the confirm password");
        }
      }
      else
      {
        window.alert("Please fill out all fields");
      }

  });

  $("#btn-resetPassword").click(function()
  {
    var auth = firebase.auth();
    var email = $("#email").val(); /* to get email entered by user in forget password  */
    if (email != "") /* if email bar is not empty then proceed to recover */
    {
      auth.sendPasswordResetEmail(email).then(function() /* firebase builtin functions for forgot emails */
      {
        window.alert("Email has been sent to you. Please check and verify");
      })
      .catch(function(error)
      {
        var errorCode= error.code; /* gets the error */
        var errorMessage=error.message;

        console.log(errorCode);
        console.log(errorMessage);
        window.alert("Message :" + errorMessage);
      });
    }
    else
    {
      window.alert("Please enter your email first");
    }
  });



  $("#btn-logout").click(function()
  {
    firebase.auth().signOut();

  });

  $("#btn-update").click(function() /* when update button pressed on acoount setting.html,this function is invoked */
  {
    var phone = $("#phone").val();
    var address = $("#address").val();
    var bio = $("#bio").val(); 
    var fName = $("#firstName").val();
    var sName = $("#secondName").val();
    var country = $("#country").val(); 
    var gender = $("#gender").val(); 

    var rootRef = firebase.database().ref().child("Users");
    var userID = firebase.auth().currentUser.uid; /* gets unique user id from firebase */
    var usersRef = rootRef.child(userID);

    if(fName != "" && sName != "" && phone != "" && country != "" && gender != "" && bio != "" && address != "" )
    {
      var userData=     /* object created */
      {                 /* all this data is stored in database using these names*/

        "phone": phone,
        "address": address,
        "bio": bio,
        "firstName": fName,
        "secondName": sName,
        "country": country,
        "gender": gender,
      };
      usersRef.set(userData, function(error) /* this line puts data in database */
      {
        if(error)
        {
          var errorCode= error.code; /* gets the error */
          var errorMessage=error.message;

          console.log(errorCode);
          console.log(errorMessage);
          window.alert("Message :" + errorMessage);

        }
        else
        {
          window.location.href ="MainPage.html";/* taking user back to home page */
        }

      });
    }
    else
    {
      window.alert("Form is incomplete.Please fill out all the fields");
    }
  });