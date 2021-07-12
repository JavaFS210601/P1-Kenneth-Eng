const url = 'http://localhost:8081/P1-Kenneth-Eng/';

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
        
        //let table = document.getElementByTagName('table');
        
        let data = await response.json();
        console.log(data);
        for (let customer of data) {
            //console.log("username: " + customer.username);
            let row = document.createElement('tr');
            let cell = document.createElement('td');
            cell.innerHTML = customer.username;
            row.appendChild(cell);

            document.getElementById("foodBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML
        }
        
        
        return response;
    } else {

    }
    // return response;
}
