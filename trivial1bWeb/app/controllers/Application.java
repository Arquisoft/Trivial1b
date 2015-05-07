package controllers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import play.data.Form;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import views.html.error;
import views.html.estadisticas;
import views.html.finpartida;
import views.html.iniciosesion;
import views.html.login;
import views.html.registro;
import views.html.tablero;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import es.uniovi.asw.infraestructura.util.casillas.Figura;
import es.uniovi.asw.model.Answer;
import es.uniovi.asw.model.Question;
import es.uniovi.asw.model.Registro;
import es.uniovi.asw.model.Trivial;
import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.UserDb;

public class Application extends Controller {

	private static Trivial juego = new Trivial();
	private static String coor;
	private static String dado;
	static Form<User> userForm = Form.form(User.class);
	private static UserDb user = new UserDb();
	static Form<Registro> registerForm = Form.form(Registro.class);
	
	private static int sumarAcertadas;
	private static int sumarFalladas;
	private static int sumarGanadas;
	private static int sumarPerdidas;

	public static Result index() {

		return ok(login.render(userForm));
	}

	public static Result login() {
		Form<User> filledForm = userForm.bindFromRequest();

		String username = filledForm.field("username").value();
		String password = filledForm.field("password").value();

		if (user.login(username, password)) {
			ArrayList<User> usuarios = new ArrayList<User>();
			usuarios.add(user.lookup(username));
			juego.setUsuarios(usuarios);
			session("connected", username);
			return redirect("/iniciosesion");
		} else {
			return ok(error.render("El usuario o la contraseña no son correctos."));
		}
	}

	public static Result mostrarEstadisticas() {
		return ok(estadisticas.render((juego.getUsuarios().get(0))));
	}

	public static Result iniciarSesion() {
		return ok(iniciosesion.render());
	}
	
	
	public static Result sumarAcertadas() {
		juego.getUsuarios().get(0).setnRightQuestions(juego.getUsuarios().get(0).getnRightQuestions() + 1);
		sumarAcertadas = juego.getUsuarios().get(0).getnRightQuestions();
		return ok();
		/*
		Integer numAcertadas = request().getQueryInteger("numAcertadas");
		
		if (numAcertadas != null) {
			user.setnRightQuestions(user.getnRightQuestions() + 1);
			return ok();
		}
		else {
			return ok();
		}
		*/
	}
	
	public static Result sumarFalladas() {
		juego.getUsuarios().get(0).setnWrongQuestions(juego.getUsuarios().get(0).getnWrongQuestions() + 1);
		sumarFalladas = juego.getUsuarios().get(0).getnWrongQuestions();
		return ok();
	}
	
	public static Result sumarGanadas() {
		juego.getUsuarios().get(0).setnWonGames(juego.getUsuarios().get(0).getnWonGames() + 1);
		sumarGanadas = juego.getUsuarios().get(0).getnWonGames();
		return ok();
	}
	
	public static Result sumarPerdidas() {
		juego.getUsuarios().get(0).setnLostGames(juego.getUsuarios().get(0).getnLostGames() + 1);
		sumarPerdidas = juego.getUsuarios().get(0).getnLostGames();
		return ok();
	}

	public static Result tablero() {

		String coor = request().getQueryString("coor");
		String dado = request().getQueryString("ndado");

		if (coor != null || dado != null) {

			int coorX = Integer.valueOf(coor.split("-")[0]);
			int coorY = Integer.valueOf(coor.split("-")[1]);

			Figura casilla = juego.buscarCasilla(new Point(coorX, coorY));
			ObjectNode respuesta = Json.newObject();
			if(casilla==null) {
				respuesta.put("encontrada", false);
				return ok(respuesta);
			} 
			
			respuesta.put("encontrada", true);
			respuesta.put("quesito", casilla.isQuesito());
			respuesta.put("dado", casilla.isDado());
			respuesta.put("centro", casilla.isCentral());


			if (casilla.isDado())
				return ok(respuesta);

			if (casilla.isCentral()) {
				User u = juego.getUsuarios().get(juego.getTurno());
				if (u.getQuesitos() == 6) {
					// TODO hacer lo de las 4 preguntas.

					return ok(respuesta);
				} else {
					// TODO hacer que pasa cuando no se acabo.
				}
			}

			if (casilla.getCategoria() != null) {
				respuesta.put("categoria", casilla.getCategoria());
				Question q = juego.getQuestion(coorX, coorY);
				respuesta.put("enunciado", q.getQuestion());

				ArrayNode opciones = respuesta.arrayNode();
				List<Answer> ans = q.getAnswers();
				for (int i = 0; i < ans.size(); i++) {
					Answer a = ans.get(i);
					opciones.add(a.getResponse());
					if (a.isCorrect()) {
						respuesta.put("correcta", i);
					}
				}

				respuesta.put("opciones", opciones);

			}
			return ok(respuesta);

		} else {
			return ok(tablero.render(juego, coor, dado, sumarAcertadas, sumarFalladas));
		}

	}

	public static Result pregunta(String coor) {

		return redirect("/pregunta");

	}

	public static Result logout() {
		session().clear();
		flash("EXITO", "sesion cerrada");
		return redirect("/index");

	}

	public static Result finalizarPartida() {
		return ok(finpartida.render());
	}

	public static Result nuevaPartida() {
		return ok(tablero.render(juego, coor, dado, sumarAcertadas, sumarFalladas));
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

			user.addUser(username, password);
			return ok(login.render(userForm));
		}

	}

	private static Set<play.mvc.WebSocket.Out<String>> outs = new HashSet<play.mvc.WebSocket.Out<String>>();

	public static WebSocket<String> socket() {
		return new WebSocket<String>() {

			@Override
			public void onReady(play.mvc.WebSocket.In<String> in,
					final play.mvc.WebSocket.Out<String> out) {

				outs.add(out);

				in.onMessage(new Callback<String>() {

					@Override
					public void invoke(String mensaje) throws Throwable {
						for (play.mvc.WebSocket.Out<String> out : outs) {
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
