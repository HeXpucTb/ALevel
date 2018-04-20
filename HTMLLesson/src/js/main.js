var elements = document.getElementsByTagName('img');
for(var i = 0;i<elements.length;i++){
    elements.item(i).addEventListener('mouseover', function () {this.style.width = '110%'}, false);
    elements.item(i).addEventListener('mouseout', function () {this.style.width = '100%'}, false);
}
var hels = document.getElementsByTagName('a');
for(var j = 0;j<hels.length;j++){
    hels.item(j).addEventListener('mouseover', function () {this.style.color = 'violet';}, false);
    hels.item(j).addEventListener('mouseout', function () {this.style.color = '';}, false);
}
function func(textId) {
    if(document.getElementById(textId).style.display =="none"){
        document.getElementById(textId).style.display ="block"
    }else {
        document.getElementById(textId).style.display ="none"
    }
}