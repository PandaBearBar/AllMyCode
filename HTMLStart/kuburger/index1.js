let count = 0;

function add(){
    // Create new p element
    const p = document.createElement('p');
    p.id="p"+(++count);
    p.innerHTML = "burger";

    // append p inside div
    const div = document.getElementById('container');
    div.appendChild(p);
    
}

function remove(){
    const id = "p"+(count);
    const p = document.getElementById(id);

    const div = document.getElementById('container');
    div.removeChild(p);
    count--;

}