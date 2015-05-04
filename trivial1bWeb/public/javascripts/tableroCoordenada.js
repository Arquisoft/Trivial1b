var theObj=""; 
var data;

function toolTip(me) { 

theObj=me 
theObj.onmousemove=updatePos; 
document.getElementById('toolTipBox').innerHTML=window.event.offsetX +" - "+ window.event.offsetY; 
document.getElementById('toolTipBox').style.display="block"; 
window.onscroll=updatePos; 

var coorString=window.event.offsetX +"-"+ window.event.offsetY;

jsRoutes.controllers.Application.pregunta(coorString);




} 

function updatePos() { 
var ev=arguments[0]?arguments[0]:event; 
var x=ev.clientX; 
var y=ev.clientY; 
diffX=8; 
diffY=8; 
document.getElementById('toolTipBox').style.top = y-2+diffY+document.body.scrollTop+ "px"; 
document.getElementById('toolTipBox').style.left = x-2+diffX+document.body.scrollLeft+"px"; 
theObj.onmouseout=hideMe; 

// Get a reference to the image you want the pixels of and its dimensions
var myImage = document.getElementById('tablero');
var w = myImage.width, h = myImage.height;

// Create a Canvas element
var canvas = document.createElement('canvas');

// Size the canvas to the element
canvas.width = w;
canvas.height = h;

// Draw image onto the canvas
var ctx = canvas.getContext('2d');
ctx.drawImage(myImage, 0, 0,w,h);

// Finally, get the image data
// ('data' is an array of RGBA pixel values for each pixel)
this.data = ctx.getImageData(y-2+diffY+document.body.scrollTop, x-2+diffX+document.body.scrollLeft, w, h);


} 
function hideMe() { 
document.getElementById('toolTipBox').style.display="none"; 
} 