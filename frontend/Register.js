const url = 'http://localhost:8081/P1-Kenneth-Eng/';

document.getElementById('registerButton').addEventListener('click', registerFunc);

async function registerFunc(){
    console.log("post")

    let username = document.getElementById("username");
    let password = document.getElementById("password");
    console.log(" " + username.innerText + " " + password.innerText);

    let response = await fetch(url +  'register' ,{
      method: "POST",
      // headers:{
      //   "Content-Type": "application/json",
      //   "Connnection": "Keep-alive"
      // },
      credentials: "include",
      body: JSON.stringify({"username": username.innerText , "password": password.innerText })
    });
    if (response.status === 200){
      console.log(response)
    
    } else if (response.status === 403){
      console.log(response)
    } else {
        var e =  document.getElementById("errorBody");
        var message  = document.createElement("p");
        message.innerText = "Rejected";
        e.appendChild(message);
    }

    window.location.href = "http://127.0.0.1:5500/" + "Customer.html";
}