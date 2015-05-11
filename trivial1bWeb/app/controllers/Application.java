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
import views.html.*;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import es.uniovi.asw.infraestructura.impl.Log;
import es.uniovi.asw.infraestructura.model.Answer;
import es.uniovi.asw.infraestructura.model.Question;
import es.uniovi.asw.infraestructura.model.Registro;
import es.uniovi.asw.infraestructura.model.Trivial;
import es.uniovi.asw.infraestructura.model.User;
import es.uniovi.asw.infraestructura.util.casillas.Figura;
import es.uniovi.asw.persistence.UserDb;

public class Application extends Controller {

	private static Trivial juego = new Trivial();
	private static String coor;
	private static String ndado;
	static Form<User> userForm = Form.form(User.class);
	private static UserDb user = new UserDb();

	static Form<Registro> registerForm = Form.form(Registro.class);

	private static int nacertadas;
	private static int nfalladas;

	// private static int sumarGanadas;
	// private static int sumarPerdidas;

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
			return ok(error
					.render("El usuario o la contraseña no son correctos."));
		}
	}

	public static Result mostrarEstadisticas() {
		return ok(estadisticas.render((juego.getUsuarios().get(0))));
	}

	public static Result iniciarSesion() {
		return ok(iniciosesion.render());
	}

	public static Result sumarAcertadas() {
		juego.getUsuarios()
				.get(0)
				.setnRightQuestions(
						juego.getUsuarios().get(0).getnRightQuestions() + 1);
		// sumarAcertadas = juego.getUsuarios().get(0).getnRightQuestions();
		nacertadas += 1;
		return ok(tablero.render(juego, coor, ndado, nacertadas, nfalladas));
		/*
		 * Integer numAcertadas = request().getQueryInteger("numAcertadas");
		 * 
		 * if (numAcertadas != null) {
		 * user.setnRightQuestions(user.getnRightQuestions() + 1); return ok();
		 * } else { return ok(); }
		 */
	}

	public static Result sumarFalladas() {
		juego.getUsuarios()
				.get(0)
				.setnWrongQuestions(
						juego.getUsuarios().get(0).getnWrongQuestions() + 1);
		nfalladas += 1;
		return ok(tablero.render(juego, coor, ndado, nacertadas, nfalladas));
	}

	public static Result sumarGanadas() {
		juego.getUsuarios().get(0)
				.setnWonGames(juego.getUsuarios().get(0).getnWonGames() + 1);
		// sumarGanadas = juego.getUsuarios().get(0).getnWonGames();
		return ok();
	}

	public static Result sumarPerdidas() {
		juego.getUsuarios().get(0)
				.setnLostGames(juego.getUsuarios().get(0).getnLostGames() + 1);
		// sumarPerdidas = juego.getUsuarios().get(0).getnLostGames();
		return ok();
	}

	public static Result tablero() {
		if (juego.getUsuarios().size() == 0) {
			return redirect("/index");
		}
		
		User u = juego.getUsuarios().get(juego.getTurno());
		
		if (request().getQueryString("respondida") != null
				&& request().getQueryString("quesito").equals("true")) {
			actualizarQuesitos();
			if(juego.isRondaFinal(u)) {
				return mostrarGanada();
			}
			return ok(tablero.render(juego, coor, ndado, nacertadas, nfalladas));
		}

		String coor = request().getQueryString("coor");
		String dado = request().getQueryString("ndado");

		if (coor != null || ndado != null) {

			int coorX = Integer.valueOf(coor.split("-")[0]);
			int coorY = Integer.valueOf(coor.split("-")[1]);
			ObjectNode respuesta = null;

			Figura casilla = juego.buscarCasilla(new Point(coorX, coorY));
			respuesta = Json.newObject();

			respuesta.put("quesito", casilla.isQuesito());
			respuesta.put("dado", casilla.isDado());
			respuesta.put("centro", casilla.isCentral());

			respuesta.put("encontrada", casilla != null);
			if (casilla.isDado())
				return ok(respuesta);

			if (casilla.getCategoria() != null || casilla.isCentral()) {
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

		} else if (coor == null && dado != null) {
			ndado = dado;

			return ok(tablero.render(juego, coor, ndado, nacertadas, nfalladas));

		} else {
			return ok(tablero.render(juego, coor, ndado, nacertadas, nfalladas));
		}

	}

	public static Result mostrarGanada() {
		User u = juego.getUsuarios().get(juego.getTurno());

		return ok(partidaganada.render());
	}

	private static void actualizarQuesitos() {
		User u = juego.getUsuarios().get(juego.getTurno());
		String categoria = request().getQueryString("categoria");
		u.incrementarQuesitos(categoria);
		
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
		if (juego.getUsuarios().size() == 0) {
			return redirect("/index");
		}
		return ok(tablero.render(juego, coor, ndado, nacertadas, nfalladas));
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
