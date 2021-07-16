document.getElementById('getTicketsButton').addEventListener('click', loadFunc);

async function loadFunc(){
    
    let response = await fetch(url + 'tickets/', {
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
        document.getElementById("ticketBody").innerHTML = "";
        //let table = document.getElementByTagName('table');
        

        let data = await response.json();
        console.log(data);
        for (let ticket of data) {
            //console.log("username: " + customer.username);
            let row = document.createElement('tr');
           

            let cell = document.createElement('td');
            cell.innerHTML = ticket.id;
            row.appendChild(cell);

            let cell1 = document.createElement('td');
            cell1.innerHTML = ticket.name;
            row.appendChild(cell1);

            let cell2 = document.createElement('td');
            cell2.innerHTML = ticket.ticketStatus;
            row.appendChild(cell2);

            let cell3 = document.createElement('td');
            cell3.innerHTML = ticket.ticketType;
            row.appendChild(cell3);

            let cell4 = document.createElement('td');
            cell4.innerHTML = ticket.createDate;
            row.appendChild(cell4);

            let cell5 = document.createElement('td');
            cell5.innerHTML = ticket.resolveDate;
            row.appendChild(cell5);

            
           let ticketbuttonGroup = document.createElement('td');
           //ticketbuttonGroup.classList.add('btn-group');
          // buttonCover.appendChild(buttonGroup);

           let ticketbutton1= document.createElement('button');
           ticketbutton1.innerText = "Approve";
           ticketbutton1.setAttribute('id', 'approve#' + ticket.id);
          // ticketbutton1.addEventListener('click', approveFunc());
           //document.getElementById('approve#' + ticket.id).addEventListener('click', approveFunc());
           ticketbutton1.classList.add('btn-sm');
           ticketbutton1.classList.add('btn-outline-secondary');
           ticketbuttonGroup.appendChild(ticketbutton1);

           let ticketbutton2 = document.createElement('button');
           ticketbutton2.innerText = "Reject";
           ticketbutton2.setAttribute('id', 'reject#' + ticket.id);
           //ticketbutton2.addEventListener('click', rejectFunc());
           ticketbutton2.classList.add('btn-sm');
           ticketbutton2.classList.add('btn-outline-secondary');
           ticketbuttonGroup.appendChild(ticketbutton2);

           document.getElementById("ticketBody").appendChild(ticketbuttonGroup); 

           row.appendChild(ticketbuttonGroup);

            document.getElementById("ticketBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML
        }
        
        
        return response;
    } else {

    }
    // return response;
}

//////////////////////////////////////////////////////////////////////////////

document.getElementById('getTicketType1Button').addEventListener('click', typeFunc);

document.getElementById('getTicketType2Button').addEventListener('click', typeFunc);
document.getElementById('getTicketType3Button').addEventListener('click', typeFunc);
document.getElementById('getTicketType4Button').addEventListener('click', typeFunc);
//document.getElementById('getTicketType1Button').addEventListener('click', typeFunc);

async function typeFunc(){
    let text = this.innerText;
    console.log(text);
    let response = await fetch(url + 'Tickets/Type/'+ text + "/", {
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
        for (let ticket of data) {
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
            cell.innerHTML = "Ticket ID: " + ticket.id;
            row.appendChild(cell);
            //cell.classList.add("card");

            let cell1 = document.createElement('div');
            cell1.innerHTML = "Name:  "+ ticket.name;
            row.appendChild(cell1);

            let cell2 = document.createElement('div');
            cell2.innerHTML = "Status: "+ ticket.ticketStatus;
            row.appendChild(cell2);

            let cell3 = document.createElement('div');
            cell3.innerHTML = "Type:  "+ ticket.ticketType;
            row.appendChild(cell3);

            let cell4 = document.createElement('div');
            cell4.innerHTML = "Owner:  "+ ticket.owner;
            row.appendChild(cell4);

            let cell5 = document.createElement('div');
            cell5.innerHTML = "Amount:  "+ ticket.amount;
            row.appendChild(cell5);

            let cardtext = document.createElement('p');
            cardtext.innerHTML = "description: " + ticket.description;
            row.appendChild(cardtext);

            let buttonCover = document.createElement('div');
            buttonCover.className += "d-flex justify-content-between align-items-center";
            row1.appendChild(buttonCover);

            let buttonGroup = document.createElement('div');
            buttonGroup.classList.add('btn-group');
            buttonCover.appendChild(buttonGroup);

            let button1 = document.createElement('button');
            button1.innerHTML = "Approve";
            button1.setAttribute('id', 'approve#' + ticket.id);
            button1.addEventListener('click', rejectFunc());
            button1.classList.add('btn-sm');
            button1.classList.add('btn-outline-secondary');
            button1.addEventListener('click', approveFunc());
            buttonGroup.appendChild(button1);

            let button2 = document.createElement('button');
            button2.innerHTML = "Reject";
            button2.setAttribute('id', 'reject');
            button2.addEventListener('click', rejectFunc());
            button2.classList.add('btn-sm');
            button2.classList.add('btn-outline-secondary');
            buttonGroup.appendChild(button2);
            
            parentdiv.appendChild(row1);
            document.getElementById("typeBody").appendChild(parentdiv);
    
        }
        
        
        return response;
    } else {

    }

}


//document.getElementById('approve').addEventListener('click', approveFunc());

async function approveFunc(id){

   // let text = this.innerText;
   
    console.log("approve" + id);
    let response = await fetch(url + 'test/' + id, {
        method: "GET", 
        headers: {
            "Accept":  "*/*",
            "Content-Type": "application/json",
            //"Accept-Encoding": "gzip, deflate, br",
            "Connection": "Keep-alive"
        },
        credentials: "include"
    });
}

async function rejectFunc(){
    console.log("reject");
   // console.log(this.innerHTML);
}

document.addEventListener('click',function(e){
    let buttonName = e.target.id.split("#")

    if(e.target ){ //&& e.target.id== 'approve#1'
          //do something
          //console.log("click approve")
        
          switch(buttonName[0]){
            case 'approve':  console.log("click approve" + buttonName[1]);
                        approveFunc(buttonName[1]);
                        break;
                        
        }
     }
    
    
 });