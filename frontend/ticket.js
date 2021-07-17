document.getElementById('getTicketsButton').addEventListener('click', loadFunc);

document.getElementById('employeeTicketButton').addEventListener('click', loadEmployeeTickets)


async function loadEmployeeTickets(){
    
    let id = getCookie("userid");

    let response = await fetch(url + 'employee/' + id, {
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

        let data = await response.json();
        console.log(data);
        let container = document.getElementById('employeeTicketBody');
        container.innerText = "";

        for (let ticket of data) {
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

            let cellDate1 = document.createElement('div');
            let create_date = new Date(ticket.createDate);
            cellDate1.innerHTML = "Date: "+ create_date.getDate()+
                            "/"+(create_date.getMonth()+1)+
                                "/"+create_date.getFullYear()+
                                    " "+create_date.getHours()+
                                        ":"+create_date.getMinutes()+
                                            ":"+create_date.getSeconds() + " pst"
            row.appendChild(cellDate1);

            let cellDate2 = document.createElement('td');
            let solve_date = new Date(ticket.resolveDate);
            cellDate2 .innerHTML = "Date: "+ solve_date.getDate()+
                                    "/"+(solve_date.getMonth()+1)+
                                        "/"+solve_date.getFullYear()+
                                            " "+solve_date.getHours()+
                                                ":"+solve_date.getMinutes()+
                                                    ":"+solve_date.getSeconds() + "pst" ;
            row.appendChild(cellDate2 );

            parentdiv.appendChild(row1);
            container.appendChild(parentdiv);
        }
    }
}

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

            let cell6 = document.createElement('td');
            cell6.innerHTML = ticket.amount;
            row.appendChild(cell6);

            let cell2 = document.createElement('td');
            cell2.innerHTML = ticket.ticketStatus;
            row.appendChild(cell2);

            let cell3 = document.createElement('td');
            cell3.innerHTML = ticket.ticketType;
            row.appendChild(cell3);

            let cell4 = document.createElement('td');
            let create_date = new Date(ticket.createDate);
            
            cell4.innerHTML = "Date: "+ create_date.getDate()+
                            "/"+(create_date.getMonth()+1)+
                                "/"+create_date.getFullYear()+
                                    " "+create_date.getHours()+
                                        ":"+create_date.getMinutes()+
                                            ":"+create_date.getSeconds() + " pst"
            row.appendChild(cell4);

            let cell5 = document.createElement('td');
            let solve_date = new Date(ticket.resolveDate);
            cell5.innerHTML = "Date: "+ solve_date.getDate()+
                                    "/"+(solve_date.getMonth()+1)+
                                        "/"+solve_date.getFullYear()+
                                            " "+solve_date.getHours()+
                                                ":"+solve_date.getMinutes()+
                                                    ":"+solve_date.getSeconds() + "pst" ;
            row.appendChild(cell5);

            
           let ticketbuttonGroup = document.createElement('td');
           //ticketbuttonGroup.classList.add('btn-group');
          // buttonCover.appendChild(buttonGroup);

           let ticketbutton1= document.createElement('button');
           ticketbutton1.innerText = "Approve";
           ticketbutton1.setAttribute('id', 'approve#' + ticket.id);
          ticketbutton1.addEventListener('click', approveFunc());
           //document.getElementById('approve#' + ticket.id).addEventListener('click', approveFunc());
           ticketbutton1.classList.add('btn-sm');
           ticketbutton1.classList.add('btn-outline-secondary');
           ticketbuttonGroup.appendChild(ticketbutton1);

           let ticketbutton2 = document.createElement('button');
           ticketbutton2.innerText = "Reject";
           ticketbutton2.setAttribute('id', 'reject#' + ticket.id);
           ticketbutton2.addEventListener('click', rejectFunc());
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
            button1.classList.add('btn-sm');
            button1.classList.add('btn-outline-secondary');
            button1.addEventListener('click', approveFunc());
            buttonGroup.appendChild(button1);

            let button2 = document.createElement('button');
            button2.innerHTML = "Reject";
            button2.setAttribute('id', 'reject#'+ ticket.id);
            button2.classList.add('btn-sm');
            button2.classList.add('btn-outline-secondary');
            button2.addEventListener('click', rejectFunc());
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
    let response = await fetch(url + 'approve/' + id, {
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

async function rejectFunc(id){
    console.log("reject");
   // console.log(this.innerHTML);
   console.log("reject" + id);
   let response = await fetch(url + 'reject/' + id, {
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

document.getElementById("openTicketButton").addEventListener('click', openTicketFunc);

async function openTicketFunc(){

    //let username = document.getElementById("").value;
    
    let id = getCookie("userid");
    let username = getCookie('username');
    let name = document.getElementById("ticketName").value;
    let amount = document.getElementById("ticketAmount").value;
    let description = document.getElementById("ticketDescription").value;
    let type = document.getElementById("ticketType").value;

    
    let newTicket = {
        id: id,
        username: username,
        name: name,
        amount: amount,
        description: description,
        type: type,
    }

    console.log(newTicket);

    console.log("open ticket" );
    let response = await fetch(url + 'open', {
        method: "POST", 
        body: JSON.stringify(newTicket),
        headers: {
            "Accept":  "*/*",
            "Content-Type": "application/json",
            //"Accept-Encoding": "gzip, deflate, br",
            "Connection": "Keep-alive"
        },
        credentials: "include"
    });

    if (response.status === 200){
        console.log("success");
    }

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
            case 'reject':  console.log("click reject" + buttonName[1]);
                    rejectFunc(buttonName[1]);
                        break;            
        }
     }
     
    
 });

 function getCookie(n) {
    let a = `; ${document.cookie}`.match(`;\\s*${n}=([^;]+)`);
    return a ? a[1] : '';
}
