var elements = document.getElementsByTagName('img');
var e_name = document.getElementById('e_name');
var e_email = document.getElementById('e_email');
for(var i = 0;i<elements.length;i++){
    elements.item(i).addEventListener('mouseover', function () {this.style.width = '110%'}, false);
    elements.item(i).addEventListener('mouseout', function () {this.style.width = '100%'}, false);
}

function butEvent() {
    var name = document.getElementById('exampleInputName').value;
    var email = document.getElementById('exampleInputEmail1').value;
    if(name.length<4||name.indexOf(' ')>=0||email.length<5){
        e_name.style.display = 'inline';
    }else{
        e_name.style.display = 'none';
        document.location.href = 'UserPage.html';
    }
}
function checkName(name1) {
    if(name1.length<4||name1.indexOf(' ')>=0){
        e_name.style.display = 'inline';
    }else{
        e_name.style.display = 'none';
    }
}
function checkEmail(email1) {
    if(email1.length <5){
        e_email.style.display = 'inline';
    }else{
        e_email.style.display = 'none';
    }
}

