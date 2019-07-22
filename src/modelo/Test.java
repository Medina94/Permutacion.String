package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String s = "cristian";
		Set<String> l = permutation("", s);
		int i=0;
		for (Iterator it = l.iterator(); it.hasNext();) {
			String result = (String) it.next();
			System.out.println(i+"---"+result);
			i++;
		}

	}

	// ------------------------------------------------
	public static void intercambiar(char[] array, int p1, int p2) {
		char temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}

	// ------------------------------------------------
	//Con rescursividad
	    private static Set<String> permutation(String prefix, String str) {
	    	Set<String> permutations = new HashSet<>();
	        int n = str.length();
	        if (n == 0) {
	            permutations.add(prefix);
	        } else {
	            for (int i = 0; i < n; i++) {
	                permutations.addAll(permutation(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
	            }
	        }
	        return permutations;
	    }

	// -----------------------------------------------
	public static List<String> permutarString(String txt) {
		List<String> lista = new ArrayList();
		List<Character> listaString = new ArrayList();
		boolean limite = false;
		for (int i = 0; i < txt.length(); i++) {
			listaString.add(txt.charAt(i));
		}
		lista.add(txt);
		System.out.println(lista.size());
		while (!limite) {
			Collections.shuffle(listaString);
			
			if (!lista.contains(convertir(listaString))) {
				lista.add(convertir(listaString));
			}
			if(lista.size() == 24) {
				limite = true;
			}
		}

		return lista;
	}

	// ----------------------------------------------
	public static String convertir(List<Character> l) {
		String s = "";
		for (int i = 0; i < l.size(); i++) {
			s += l.get(i);
		}
		return s;
	}
}
