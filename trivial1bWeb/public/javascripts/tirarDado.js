var face0 = new Image()
face0.src = "/assets/images/dado1.png"
var face1 = new Image()
face1.src = '/assets/images/dado2.png'
var face2 = new Image()
face2.src = '/assets/images/dado3.png'
var face3 = new Image()
face3.src = '/assets/images/dado4.png'
var face4 = new Image()
face4.src = '/assets/images/dado5.png'
var face5 = new Image()
face5.src = '/assets/images/dado6.png'

var ws = new WebSocket('ws://localhost:9000/socket');
var theObj=""; 
var data;
	
function lanzar() {
	var randomdice = Math.round(Math.random() * 5);
	document.images["dado"].src = eval("face" + randomdice + ".src");
	
	ws.send(randomdice);
	
	$.ajax(
	       { url:"@routes.Application.dado()",
	       data: {
                'dado': randomdice
            },
            dataType: 'json',
	         success: function(data){
	      	 	console.log(data);
	      	 }
		   });
	
	
	
}