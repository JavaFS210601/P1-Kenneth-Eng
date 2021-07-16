const url = 'http://localhost:8081/P1-Kenneth-Eng/';

loggedElements = document.getElementsByClassName("logged");
        loggedElements[0].style.display = "none";
        loggedElements[1].style.display = "none";
        loggedElements[2].style.display = "none";
        loggedElements[3].style.display = "none";


var darkModeButton = document.getElementById('myButton');
var bg3 = document.getElementsByClassName("card");
for (let i = 0; i < bg3.length; i++) {
    bg3[i].style.color = "black";
  }
  let table = document.getElementById("foodTable");
  table.style.color = "white";
  let table2 = document.getElementById("avengerTable");
  table2.style.color = "white";
//bg.classList.add("bg-dark");
document.body.style.backgroundColor = "yellow";
document.body.style.color = "white";
document.cookie = "darkmode=false";
darkModeButton.innerText = "Night Mode On";

//document.getElementById('registerButton').addEventListener('click', registerFunc);

// async function registerFunc(){
//     let response = await fetch(url +  'register' ,{
//       method: "POST",
//       headers:{
//         "Content-Type": "application/json",
//         "Connnection": "Keep-alive"
//       },
//       credentials: "include"
//     });
//     if (response.status === 200){
//       console.log(response)
    
//     }
// }

document.getElementById('getCustomerButton').addEventListener('click', assembleFunc);

async function assembleFunc(){

    let response = await fetch(url + 'users', {
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
        document.getElementById("userBody").innerHTML = "";

        let data = await response.json();
        console.log(data);
        for (let user of data) {
            
            let row = document.createElement('tr');

            let cell = document.createElement('td');
            cell.innerHTML = user.userid;
            row.appendChild(cell);

            let cell1 = document.createElement('td');
            cell1.innerHTML = user.username;
            row.appendChild(cell1);

            let cell3 = document.createElement('td');
            cell3.innerHTML = user.firstname;
            row.appendChild(cell3);

            let cell4 = document.createElement('td');
            cell4.innerHTML = user.lastname;
            row.appendChild(cell4);


            let cell5 = document.createElement('td');
            cell5.innerHTML = user.userrole;
            row.appendChild(cell5);


            document.getElementById("userBody").appendChild(row);

          
           
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
        let loginPanel = document.getElementById("login-row");
        loginPanel.innerText="Welcome! "+ username.toUpperCase()  +" " ;
        loginPanel.classList.add("afterLogin");
        if (getCookie("darkmode") === "false"){
            loginPanel.style.color = document.body.style.color;
        }

        loggedElements = document.getElementsByClassName("logged");
        loggedElements[0].style.display = "block";
        loggedElements[1].style.display = "block";
        loggedElements[2].style.display = "block";
        loggedElements[3].style.display = "block";
        // document.cookie = "username=ken; expires=Thu, 18 july 2021 12:00:00"
    } else {
        document.getElementById("login-row").innerText="Login Failed! Refresh the page!";
    }

}

//////////////////////////////////////////////////////////////////////////////

// document.getElementById('getType1Button').addEventListener('click', typeFunc);

// document.getElementById('getType2Button').addEventListener('click', typeFunc);
// document.getElementById('getType3Button').addEventListener('click', typeFunc);
// document.getElementById('getType4Button').addEventListener('click', typeFunc);
// document.getElementById('getType5Button').addEventListener('click', typeFunc);

async function typeFunc(){
    let text = this.innerText;
    console.log(text);
    let response = await fetch(url + 'type/'+ text + "/", {
        method: "GET", 
        headers: {
            "Accept":  "*/*",
            "Content-Type": "application/json",
            //"Accept-Encoding": "gzip, deflate, br",
            "Connection": "Keep-alive"
        },
        credentials: "include"
    });

    if (response.status === 200){
        console.log(response);
        document.getElementById("typeBody").innerHTML = "";
        //let table = document.getElementByTagName('table');
        
        let data = await response.json();
        console.log(data);
        for (let food of data) {
            //console.log("username: " + customer.username);
            let parentdiv = document.createElement('div');
            parentdiv.classList.add('col-md-4');
            

            let row1 = document.createElement('div');
            //row1.classList.add("col-md-4");
            row1.classList.add("card");
            row1.classList.add('mb-4');
            row1.classList.add('box-shadow');
            if (getCookie("darkmode") === "true"){
              
              row1.style.color = "black";
              row1.style.backgroundColor = "white";
            } else{
              row1.classList.add('bg-dark');
            }
           
           

            let row = document.createElement('div');
            row.classList.add('card-body');
            row1.appendChild(row);

            let cell = document.createElement('div');
            cell.innerHTML = food.foodid;
            row.appendChild(cell);
            //cell.classList.add("card");

            let cell1 = document.createElement('div');
            cell1.innerHTML = "Name:  "+ food.foodname;
            row.appendChild(cell1);

            let cell2 = document.createElement('div');
            cell2.innerHTML = "Quality: "+ food.foodstatus;
            row.appendChild(cell2);

            let cell3 = document.createElement('div');
            cell3.innerHTML = "Type:  "+food.foodtype;
            row.appendChild(cell3);

            let cardtext = document.createElement('p');
            cardtext.innerHTML = "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.";
            row.appendChild(cardtext);

            let buttonCover = document.createElement('div');
            buttonCover.className += "d-flex justify-content-between align-items-center";
            row1.appendChild(buttonCover);

            let buttonGroup = document.createElement('div');
            buttonGroup.classList.add('btn-group');
            buttonCover.appendChild(buttonGroup);

            let button1 = document.createElement('button');
            button1.innerHTML = "ADD";
            button1.classList.add('btn-sm');
            button1.classList.add('btn-outline-secondary');
            buttonGroup.appendChild(button1);

            let button2 = document.createElement('button');
            button2.innerHTML = "REDUCE";
            button2.classList.add('btn-sm');
            button2.classList.add('btn-outline-secondary');
            buttonGroup.appendChild(button2);
            
            parentdiv.appendChild(row1);
            document.getElementById("typeBody").appendChild(parentdiv);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML
        }
        
        
        return response;
    } else {

    }
    // return response;
}

//////////////////////////////////////////////////////////////////////////

document.getElementById('getFoodButton').addEventListener('click', loadFunc);

async function loadFunc(){

    let response = await fetch(url + 'foods/', {
        method: "GET", 
        headers: {
            "Accept":  "*/*",
            "Content-Type": "application/json",
            //"Accept-Encoding": "gzip, deflate, br",
            "Connection": "Keep-alive"
        },
        credentials: "include"
    });

    if (response.status === 200){
        console.log(response);
        document.getElementById("foodBody").innerHTML = "";
        //let table = document.getElementByTagName('table');
        
        let data = await response.json();
        console.log(data);
        for (let food of data) {
            //console.log("username: " + customer.username);
            let row = document.createElement('tr');

            let cell = document.createElement('td');
            cell.innerHTML = food.foodid;
            row.appendChild(cell);

            let cell1 = document.createElement('td');
            cell1.innerHTML = food.foodname;
            row.appendChild(cell1);

            let cell2 = document.createElement('td');
            cell2.innerHTML = food.foodstatus;
            row.appendChild(cell2);

            let cell3 = document.createElement('td');
            cell3.innerHTML = food.foodtype;
            row.appendChild(cell3);

            document.getElementById("foodBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML
        }
        
        
        return response;
    } else {

    }
    // return response;
}

document.getElementById('myButton').addEventListener('click', bgDark);


function bgDark(){
    console.log("darkmode!");
    //let bg = document.getElementById("fullcontainer");
   // let isLogin = document.getElementsByClassName('afterlogin');
   //console.log(getCookie("darkmode"));
      if (getCookie("darkmode") === "true"){
        let bg = document.getElementsByClassName("card");
        for (let i = 0; i < bg.length; i++) {
           bg[i].style.color = "white";
            bg[i].classList.add("bg-dark");
          }

          document.getElementById("login-row").style.color = "white";
          let table = document.getElementById("foodTable");
          table.style.color = "white";
          let table2 = document.getElementById("avengerTable");
          table2.style.color = "white";

          let table3 = document.getElementById("ticketTable");
          table3.style.color = "white";
        //bg.classList.add("bg-dark");
        document.body.style.backgroundColor = "yellow";
        document.body.style.color = "white";
        document.cookie = "darkmode=false";
        darkModeButton.innerText = "Night Mode On";
      } else {
        let bg2 = document.getElementsByClassName("card");
        for (let i = 0; i < bg2.length; i++) {
            bg2[i].style.color = "black";
            bg2[i].classList.remove("bg-dark");
          }
          document.getElementById("login-row").style.color = "black";
          let table = document.getElementById("foodTable");
          table.style.color = "black";
          let table2 = document.getElementById("avengerTable");
          table2.style.color = "black";
          let table3 = document.getElementById("ticketTable");
          table3.style.color = "black";
        //bg.classList.add("bg-dark");
        document.body.style.backgroundColor = "white";
        document.body.style.color = "black";
        document.cookie = "darkmode=true";
        darkModeButton.innerText = "Night Mode Off";
      }

    
}

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }