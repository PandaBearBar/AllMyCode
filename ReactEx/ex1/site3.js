//using React createElement to put an (type,null,htmlString)
const u3 = React.createElement("u",null,"Moshe With React");

const span3 = React.createElement("span",null,u3);

const h13 = React.createElement("h1",null,span3);

const container3 = document.getElementById("container3");
//inserting to reactdom rendering of h13 and container3
ReactDOM.render(h13,container3);
