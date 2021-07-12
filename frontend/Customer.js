const url = 'http://localhost:8081/P1-Kenneth-Eng/';

document.getElementById('getCustomerButton').addEventListener('click', assembleFunc);

async function assembleFunc(){

    let response = await fetch(url + 'customers/', {
        method: "GET", 
        headers: {
            "Accept":  "*/*",
            "Content-Type": "application/json",
            //"Accept-Encoding": "gzip, deflate, br",
            "Connection": "Keep-alive"
        },
        //credentials: "same-origin"
        credentials: "include"
    });

    if (response.status === 200){
        console.log(response);
        
        //let table = document.getElementByTagName('table');
        
        let data = await response.json();
        console.log(data);
        for (let customer of data) {
            console.log("username: " + customer.username);
            let row = document.createElement('tr');
            let cell = document.createElement('td');
            cell.innerHTML = customer.username;
            row.appendChild(cell);

            document.getElementById("avengerBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML
        }
        
        
        return response;
    } else {

    }
    // return response;
}

document.getElementById("loginButton").addEventListener("click", loginFunc);

async function loginFunc() {

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let user = {
        username: username,
        password: password
    }

    let response = await fetch(url + "login", {
        method: "POST", 
        //mode: 'no-cors',
        body: JSON.stringify(user),
        headers: {
            'Accept':  'application/json',
           'Content-Type': 'application/json',
          // 'Cache': 'no-cache'
        },
        //credentials: "same-origin"
       credentials: "include" // this will ensure the cookie is captured by the browser 
        
    });


     //control flow based on success or failed login
     if(response.status === 200) {
        //this will wipe our login row, and welcome the user
        document.getElementById("login-row").innerText="Welcome!";
       // document.cookie = "username=ken; expires=Thu, 18 july 2021 12:00:00"
    } else {
        document.getElementById("login-row").innerText="Login Failed! Refresh the page!";
    }

}