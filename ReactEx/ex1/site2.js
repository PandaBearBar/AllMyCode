//creating const with the name of u that use document functions
const u = document.createElement('u');
//Insert into 'u' inner HTML
u.innerHTML = 'Moshe with JS'
//like in line 1
const span = document.createElement('span');
//insert into span an appendChild element => 'u'
span.appendChild(u);

const h1 = document.createElement('h1');

h1.appendChild(span);

// giving to the id container2 the reference to the const container2
const container2 = document.getElementById('container2');
container2.appendChild(h1);