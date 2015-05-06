package controllers;

import infraestructura.util.ExtractorCoordenadas;

import java.util.*;

import model.Answer;
import model.Question;
import model.Registro;
import model.Trivial;
import model.User;
import persistence.UserDb;
import play.data.Form;
import play.libs.Json;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import views.html.error;
import views.html.estadisticas;
import views.html.iniciosesion;
import views.html.finpartida;
import views.html.login;
import views.html.registro;
import views.html.tablero;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Application extends Controller {

	private static Trivial juego = new Trivial();
	@SuppressWarnings("unused")
	private static ExtractorCoordenadas coordenadasImagen = new ExtractorCoordenadas(); // ¿?
	private static String coor;
	private static String dado;
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
		// System.out.println(username);
		// System.out.println(password);
		if (user.login(username, password)) {
			ArrayList<User> usuarios = new ArrayList<User>();
			usuarios.add(user.lookup(username));
			juego.setUsuarios(usuarios);
			session("connected", username);
			return redirect("/iniciosesion");
		} else {
			return ok(error.render());
		}
	}
	
	public static Result mostrarEstadisticas(){
		return ok(estadisticas.render((juego.getUsuarios().get(0))));
	}

	public static Result iniciarSesion(){
		return ok(iniciosesion.render());
	}
	
	public static Result dado(){
		String dado =  request().getQueryString("dado");
		
		if(dado!=null){
			System.out.println(dado);
			return ok(dado);
		}else{
			return ok(tablero.render(juego, coor, dado));
		}
			
	}
	
	public static Result tablero() {
    
		String coor = request().getQueryString("coor");
        //JsonNode json = request().body().asJson();
        if (coor != null) {
            
         
//            String name = coor; //json.findPath("coor").textValue();
            
            int coorX = Integer.valueOf(coor.split("-")[0]);
            int coorY = Integer.valueOf(coor.split("-")[1]);
            
            Question q = juego.sacarPreguntaPorCoordenadas(coorX, coorY);
            System.out.println(q);
            ObjectNode respuesta = Json.newObject();
            respuesta.put("encontrada", q != null);
            if(q!=null) {
                
                respuesta.put("enunciado", q.getQuestion());
                System.out.println(q.getQuestion());
                ArrayNode opciones = respuesta.arrayNode();
                for(Answer a: q.getAnswers()) {
                	opciones.add(a.getResponse());
                }
                
                respuesta.put("opciones", opciones);
                
                respuesta.put("correcta", 2);
                
                System.out.println(coor);
               
            }
            return ok(respuesta);
            
        }
        else {
    		return ok(tablero.render(juego, coor,dado));
        }
		
	/*		String[] coors = coor.split("-");// separo las dos coordenadas para
			// tratarlas como numeros
			int coor1 = Integer.valueOf(coors[0]);// primea coordenada
			int coor2 = Integer.valueOf(coors[1]);// segunda coordenada

			juego.setCoordenada1(coor1);
			juego.setCoordenada2(coor2);
			System.out.println(coor1+" "+coor2);*/
		

	}

	public static Result pregunta(String coor) {

		return redirect("/pregunta");

	}

	public static Result logout() {
		session().clear();
		flash("EXITO", "sesion cerrada");
		System.out.println("Sesion cerrada");
		return redirect("/index");

	}

	public static Result finalizarPartida() {
		System.out.println("partida finalizada");
		return ok(finpartida.render());
	}

	public static Result nuevaPartida() {
		System.out.println("iniciada nueva partida");
		return ok(tablero.render(juego, coor,dado));
	}

	public static Result mostrarRegistro() {
		return ok(registro.render(registerForm));
	}

	public static Result registro() {
		Form<Registro> filledForm = registerForm.bindFromRequest();

		if (filledForm.hasGlobalErrors())
			return badRequest(registro.render(filledForm));
		else {

			String username = filledForm.field("username").value();
			String password = filledForm.field("password").value();
			// System.out.println(username);
			// System.out.println(password);

			user.addUser(username, password);
			return ok(login.render(userForm));
		}

	}
	
	private static Set<play.mvc.WebSocket.Out<String>> outs = new HashSet<play.mvc.WebSocket.Out<String>>();
	
	public static WebSocket<String> socket() {
		return new WebSocket<String>() {
			
			@Override
			public void onReady(play.mvc.WebSocket.In<String> in,
					play.mvc.WebSocket.Out<String> out) {
					    
			    outs.add(out);
				
				in.onMessage(new Callback<String>() {
					
					@Override
					public void invoke(String mensaje) throws Throwable {
						for (play.mvc.WebSocket.Out<String> out: outs) {
						    out.write(mensaje);
						}
					}
				});
				
				in.onClose(new Callback0() {
				    
					@Override
					public void invoke() throws Throwable {
						outs.remove(out);
					}
				});
			}
			
		};
	}

}
