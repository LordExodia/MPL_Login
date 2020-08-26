package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import controller.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

	// Ruta principal que muestra el archivo login.
	@RequestMapping(value = "/")
	public String loginHome(Model model) {

		return "login";
	}
 
	// Ruta a la que se  redirige después de validar el login.
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam("id") String id, @RequestParam("pw") String pw)
			throws IOException, ParseException {

		// Accede con las credenciales id y pw y las valida.
		try {
			SakaiLoginService servicio = new SakaiLoginServiceLocator();

			SakaiLogin ws = new SakaiLoginServiceSoapBindingStub(new URL(servicio.getSakaiLoginPortAddress()),
					servicio);

			// Almacena la cadena en caso de que las credenciales sean correctas.
			String rs = ws.login(id, pw);

			// Crea el objeto JSON para luego almacenarlo.
			JSONObject myObject = new JSONObject();
			
			myObject.put("id", id);
			myObject.put("pw", pw);
			myObject.put("rs", rs);

			// Se define la ruta en la que se guardará el archivo que contiene los JSON.
			String ruta = "./resources/result.json";
			File archivo = new File(ruta);
			JSONArray jo = new JSONArray();

			// Crea la carpeta contenedora si no existe.
			if (!archivo.getParentFile().exists())
				archivo.getParentFile().mkdirs();

			// Crea el archivo si no existe.
			if (!archivo.exists()) {
				archivo.createNewFile();
				jo.add(myObject);
			} else { // Si el archivo existe lo lee para agregar la información.
				FileReader fr = new FileReader(archivo);
				JSONParser parser = new JSONParser();
				jo = (JSONArray) parser.parse(fr);
				jo.add(myObject);
				fr.close();
			}
			// Envia rs con la información del Token de acceso para mostrarlo en el login.
			model.addAttribute("rs", "Token de sesión: \n" + rs);

			// Escribe en el archivo el nuevo JSON
			Writer fw = new FileWriter(archivo, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jo.toJSONString());
			bw.close();
			fw.close();

		} catch (Exception e) { //Si las credenciales son incorrectas atrapa la excepción y notifica al usuario.
			model.addAttribute("rs", "Credenciales incorrectas. \nId o Contraseña erronea.");
		}

		return "login";
	}
}
