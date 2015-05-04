package controllers;

import infraestructura.util.ExtractorCoordenadas;

import java.util.ArrayList;

import model.Registro;
import model.Trivial;
import model.User;
import persistence.UserDb;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {
	
	private static Trivial juego = new Trivial();
	private static ExtractorCoordenadas coordenadasImagen= new ExtractorCoordenadas();
	static Form<User> userForm = Form.form(User.class);
	private static UserDb user = new UserDb();
	static Form<Registro> registerForm = Form.form(Registro.class);
	
	 public static Result index() {
		  
	    	return ok(login.render(userForm));
	    }
	    
	    public static Result login() {		
	    	Form<User> filledForm = userForm.bindFromRequest();
	    	
			String username = filledForm.field("username").value();
			String password = filledForm.field("password").value();
			System.out.println(username);
	    	System.out.println(password);
			if(user.login(username, password)) {
				ArrayList<User> usuarios = new ArrayList<User>();
				usuarios.add(user.lookup(username));
				juego.setUsuarios(usuarios);
				return redirect("/tablero");
				}
			else {
				return ok(error.render());
			}
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
    

    
    public static Result mostrarRegistro() {
	  return ok(registro.render());
  }
    public static Result registro() {
    	String username = request().getQueryString("username");
    	String password = request().getQueryString("password");
    	user.addUser(username, password);
		return ok(login.render(userForm));
    	
    }
    
}
