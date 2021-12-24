package co.edu.unicauca.Subscriptor1.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Json {
    public Json(){

    }

    public JsonObject comvertirString_Json(String mensaje){

        JsonParser parser = new JsonParser();

        JsonObject json = parser.parse(mensaje).getAsJsonObject();

        return json;
    }
}
