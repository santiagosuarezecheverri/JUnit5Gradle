package prueba;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calculadora { 
	public int suma(int numero1, int numero2) {
		return numero1 + numero2;
	}
	public int resta(int numero1, int numero2) {
		return numero1 - numero2;
	}
	public int multiplicacion(int numero1, int numero2) {
		return numero1 * numero2;
	}
	public int division(int numero1, int numero2) {
		return numero1 / numero2;
	}
	
	public int[] sumaVectores(int []vector1, int []vector2) {
		int [] resulado = new int[5];
		for (int i = 0; i < resulado.length; i++) {
			resulado[i]=vector1[i]+vector2[i];
		}
		
		return resulado;
	}
	public int[] ordenarBurbuja(int[] vector) {
	    for (int x = 0; x < vector.length; x++) {
	        for (int i = 0; i < vector.length-x-1; i++) {
	            if(vector[i] > vector[i+1]){
	                int tmp = vector[i+1];
	                vector[i+1] = vector[i];
	                vector[i] = tmp;
	            }
	        }
	    }
		return vector;
	}
	
	public String conexionBD (String serverName, String user, String password) {
		String conexion ="jdbc:sqlserver://" + serverName + ";user=" + user + ";password=" + password + ";";
		return conexion;
	}
	
	public int operacionNumeros(int numero1, int numero2, int numero3, int numero4) {
		
		return numero1 * numero3 + numero4 / numero2;
	}
	
	public String encontrarLetra(char letra, String cadena) {
		char[] cadenaChar = cadena.toCharArray();
		String respuesta = null;
		for (int i = 0; i < cadenaChar.length; i++) {
			if(cadenaChar[i] == letra) {
				respuesta = "Se encontró la letra";
			}else {
				respuesta = "No se encontró la letra";
			}
		}
		return respuesta;
		
	}
	
	public boolean encontrarBooleano(boolean boolean1, boolean boolean2, boolean boolean3) {
		boolean respuesta = false;
		if(boolean1&&boolean2) {
			respuesta = true;
		}else if(boolean2||boolean3) {
			respuesta = true;
		}else if(boolean1&&boolean3) {
			respuesta = true;
		}
		return respuesta;
		
	}
	
	public boolean encontrarCompuerta(boolean[] vectorBoolean, int numero1, int numero2) {
		boolean abrirCompuerta = false;
		for (int i = 0; i < vectorBoolean.length; i++) {
			if(vectorBoolean[i]) {
				abrirCompuerta = numero1 < numero2; 
			}else {
				abrirCompuerta = numero1 > numero2;
			}
				
		}
		return abrirCompuerta;
	}
	
	public boolean logicaBooleana(boolean boolean1, boolean boolean2) {
		return (!(boolean1&&boolean2)==(!boolean1||!boolean2));		
		
	}
	
	public int encontrarPalabra(String cadena, String palabra) {
		String[] vector = cadena.split(" ");
		int tamanoPalabraEncontrada = 0;
		for (int i = 0; i < vector.length; i++) {
			if(vector[i].equals(palabra)) {
				tamanoPalabraEncontrada = vector[i].length();
			}
		}
		return tamanoPalabraEncontrada;
		
	}
	
	public String convertirPalabraANumero(String phoneNumber) {		
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put("[a-c]", "2");
		aMap.put("[d-f]", "3");
		aMap.put("[g-i]", "4");
		aMap.put("[j-l]", "5");
		aMap.put("[m-o]", "6");
		aMap.put("[p-s]", "7");
		aMap.put("[t-v]", "8");
		aMap.put("[w-z]", "9");
		phoneNumber = phoneNumber.toLowerCase();
		Iterator<String> keys = aMap.keySet().iterator();
		while (keys.hasNext()){
		    String regex = keys.next();
		    String replacementValue = aMap.get(regex);
		    phoneNumber = phoneNumber.replaceAll(regex, replacementValue);
		}
		
		return phoneNumber;
	}
	
	public boolean nulos() {
		return "" != null;
	}
	
	public String metodo() {
		return "" + null;
	}
	
	public boolean ubicacionLetra(char letra) {	
		
		return letra < 'q';
	}
	public int tamanoCadena(String cadena) {
		return cadena.length()*2;
	}
	public boolean compararBooleano(String boolean1, boolean boolean2) {
		return boolean1.isEmpty() && boolean2;
	}
	public int numeroOculto(int numero) {
				
		return (++numero)+(--numero)*numero+numero;
	}
	public boolean llaveSecreta(int numero) {
		return !(numero > "Qvision".length());
	}
}
