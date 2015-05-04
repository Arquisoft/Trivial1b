var face0 = new Image()
face0.src = 'url(/public/images/dado1.png)'
var face1 = new Image()
face1.src = 'url(/public/images/dado2.png)'
var face2 = new Image()
face2.src = 'url(/public/images/dado3.png)'
var face3 = new Image()
face3.src = 'url(/public/images/dado4.png)'
var face4 = new Image()
face4.src = 'url(/public/images/dado5.png)'
var face5 = new Image()
face5.src = 'url(/public/images/dado6.png)'
	
function lanzar() {
	var randomdice = Math.round(Math.random() * 5);
	document.images["dado"].src = eval("face" + randomdice + ".src");
	
	
}