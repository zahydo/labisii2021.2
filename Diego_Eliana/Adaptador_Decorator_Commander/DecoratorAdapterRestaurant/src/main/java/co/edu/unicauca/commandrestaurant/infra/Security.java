package co.edu.unicauca.commandrestaurant.infra;

public class Security {
    //Ninguna librería me funcionó, ni Base64, ni Cipher

    public String encript(String sinCifrar) {
        char array[] = sinCifrar.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(array[i] + (char)5);
        }
        return String.valueOf(array);
    }
    
    public String decrypt(String cifrado) throws Exception {
        char array[] = cifrado.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(array[i] - (char)5);
        }
        return String.valueOf(array);
    }
}