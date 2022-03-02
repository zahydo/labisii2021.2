package co.edu.unicauca.commandrestaurant.domain.service;

import co.edu.unicauca.commandrestaurant.infra.Security;

public class SecurityService {
    public static String encript(String text) {	
        try {
            return (new Security()).encript(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
    public static String decrypt(String encrypted) throws Exception {
        return (new Security()).decrypt(encrypted);
    }
}
