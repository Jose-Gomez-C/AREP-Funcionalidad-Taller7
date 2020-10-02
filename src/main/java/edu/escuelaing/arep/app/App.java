package edu.escuelaing.arep.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.secure;

import com.google.gson.Gson;

public class App {
	public static void main(String[] args) {
		port(getPort());
		Gson gson = new Gson();
		port(getPort());
		secure("keystores/ecikeystore.p12", "Hola123", "keystores/myTrustStoreLogin", "Hola123");
		get("/respuesta",(request, response) -> {
			System.out.println("Llegue");
			return "<h4>Conectado con otra app</h4>"; 
		});
	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 5001;
	}
}