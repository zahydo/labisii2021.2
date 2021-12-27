package practica.baseDatos;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import practica.logica.ProductMessage;

public class DataBase {
	private String server = "localhost";
	private int port = 27017;
	private BasicDBObject document;
	private DBCollection coleccion;
	private DB BaseDatos;
	private MongoClient mongo = null;
	
	public MongoClient crearConexion() {
		
		
		try {
			mongo = new MongoClient(server,port);
			BaseDatos = mongo.getDB("dbmongo");
			coleccion = BaseDatos.getCollection("dbmongo");
			System.out.println("Conectado correctamente a MongoDB");
		}catch(MongoException e) {
			System.out.println("Error en la conexion a MongoDB" + e.toString());
		}
		return mongo;
	}
	
	public void accion(ProductMessage producto){
		/*
		 * AQUI SE DEBE DETERMINAR LO QUE SE VA A HACER, SI ES GUARDAR O ACTUALIZAR O ELIMINAR
		 * PARA ESTE CASO SOLO TENEMOS GUARDAR, POR LO TANTO SOLO SE CONSIDERA ESTA OPCION
		 * */
		if(producto.getAction().toString().equals("SAVE")) {
			insertar(producto);
		}
		if(producto.getAction().toString().equals("EDIT")) {
			actualizar(producto);
		}
	}
	
	public boolean insertar(ProductMessage producto) {
		document = new BasicDBObject();
		document.put("Insertar", producto.getProduct().toString());
		coleccion.insert(document);
		System.out.println("PRODUCTO INSERTADO");
		return true;
	}
	public boolean actualizar(ProductMessage producto) {
		try {
			
			String codigoFinal = String.valueOf(producto.getProduct().getProductId()) ;
			ArrayList<DBObject> lista = new ArrayList<DBObject>();

			
			DBCursor cursor = coleccion.find();
			while (cursor.hasNext()) {
			   DBObject obj = cursor.next();
			   lista.add(obj);
			}
			int x=0;
			for(int i=0; i<lista.size();i++) {
				DBObject obj = lista.get(i);
				String[] con = obj.toString().split(":");
				String[] con2 = con[3].split(",");
				String[] con3 = con2[0].split("=");
				String codigo = con3[1];
				if(codigo.equals(codigoFinal)) {
					x=i;
				}
				
			}
			document = new BasicDBObject();
			BasicDBObject newDocument = new BasicDBObject();
			//document.put("Insertar",  lista.get(x));
			//System.out.println("ACTUAL: " + lista.get(x) );
			//System.out.println("NUEVO: " + producto.getProduct().toString());
			newDocument.put("Edit", producto.getProduct().toString());
			//coleccion.findAndModify(document, newDocument);
			coleccion.remove(lista.get(x));
			coleccion.insert(newDocument);
			
			//coleccion.update(, document);
			System.out.println("PRODUCTO MODIFICADO");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
