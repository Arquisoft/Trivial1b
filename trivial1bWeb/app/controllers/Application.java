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
import views.html.error;
import views.html.finpartida;
import views.html.login;
import views.html.registro;
import views.html.tablero;

public class Application extends Controller {

	private static Trivial juego = new Trivial();
	@SuppressWarnings("unused")
	private static ExtractorCoordenadas coordenadasImagen = new ExtractorCoordenadas(); // ¿?
	private static String coor;
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
			return redirect("/iniciosesion");
		} else {
			return ok(error.render());
		}
	}

	public static Result iniciarSesion(){
		return ok(tablero.render(juego, coor));
	}
	public static Result tablero() {

		if (coor != null) {
			String[] coors = coor.split("-");// separo las dos coordenadas para
			// tratarlas como numeros
			int coor1 = Integer.valueOf(coors[0]);// primea coordenada
			int coor2 = Integer.valueOf(coors[1]);// segunda coordenada

			juego.setCoordenada1(coor1);
			juego.setCoordenada2(coor2);
			System.out.println(coor1+" "+coor2);
		}

		return ok(tablero.render(juego, coor));

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
		return ok(tablero.render(juego, coor));
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

}
