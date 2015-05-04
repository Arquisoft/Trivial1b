package controllers;

import infraestructura.util.ExtractorCoordenadas;
import model.Trivial;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.login;
import views.html.logout;
import views.html.tablero;

public class Application extends Controller {
	
	private static Trivial juego = new Trivial();
	private static ExtractorCoordenadas coordenadasImagen= new ExtractorCoordenadas();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result login(){
    	return ok(login.render());
    }

    public static Result tablero(){
    	
    	return ok(tablero.render());
    	
    }
    
    public static Result pregunta(String coor){
    	
    	String[] coors= coor.split("-");//separo las dos coordenadas para tratarlas como numeros
    	int coor1= Integer.valueOf(coors[0]);//primea coordenada
    	int coor2= Integer.valueOf(coors[1]);//segunda coordenada
    	
    	juego.setCoordenada1(coor1);
    	juego.setCoordenada2(coor2);
    	
    	
    	
    	return redirect("/pregunta");
    	
    	
    	
    }
    
    public static Result logout(){
    	return ok(logout.render());
    }
    
    
    
}
