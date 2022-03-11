package co.unicauca.restaurant.server.infra;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import co.unicauca.restaurant.commons.domain.Customer;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import co.unicauca.restaurant.commons.infra.Utilities;
import co.unicauca.restaurant.server.access.CustomerFactory;
import co.unicauca.restaurant.server.access.FoodFactory;
import co.unicauca.restaurant.server.domain.services.CustomerService;
import co.unicauca.restaurant.server.access.ICustomerRepository;
import co.unicauca.restaurant.server.access.IFoodRepository;
import co.unicauca.restaurant.server.domain.services.FoodService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Libardo, Julio
 */
public class ServerSocketRestaurant extends ServerSocketTemplate {

    /**
     * Servicio de clientes
     */
    private CustomerService customerService;
    /**
     * Servicio de comidas
     */
    private FoodService foodService;


    /**
     * Constructor
     */
    public ServerSocketRestaurant() {
    }
    
     /**
     * Inicialización
     * @return este mismo objeto
     */
    @Override
    protected ServerSocketTemplate init(){
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
         // Se hace la inyección de dependencia
        ICustomerRepository customerRepository = CustomerFactory.getInstance().getRepository();
        IFoodRepository foodRepository = FoodFactory.getInstance().getRepository();
        this.setCustomerService(new CustomerService(customerRepository));
        this.setFoodService(new FoodService(foodRepository));
        return this;
    }
    
    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    @Override
    protected void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "customer":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetCustomer(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostCustomer(protocolRequest);
                }
                break;
            case "food":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar una comida
                    processGetFood(protocolRequest);
                }
                if (protocolRequest.getAction().equals("post")) {
                    // Agregar una comida
                    processPostFood(protocolRequest);
                }
                break;
        }

    }

    /**
     * Procesa la solicitud de consultar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetCustomer(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Customer customer = getCustomerService().findCustomer(id);
        if (customer == null) {
            String errorJson = generateNotFoundErrorJson("Cliente no encontrado. Cédula no existe");
            respond(errorJson);
        } else {
            respond(objectToJSON(customer));
        }
    }

    /**
     * Procesa la solicitud de agregar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostCustomer(Protocol protocolRequest) {
        Customer customer = new Customer();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        customer.setId(protocolRequest.getParameters().get(0).getValue());
        customer.setFirstName(protocolRequest.getParameters().get(1).getValue());
        customer.setLastName(protocolRequest.getParameters().get(2).getValue());
        customer.setAddress(protocolRequest.getParameters().get(3).getValue());
        customer.setEmail(protocolRequest.getParameters().get(4).getValue());
        customer.setGender(protocolRequest.getParameters().get(5).getValue());
        customer.setMobile(protocolRequest.getParameters().get(6).getValue());

        String response = getCustomerService().createCustomer(customer);
        respond(response);
    }


    /**
     * Procesa la solicitud de consultar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetFood(Protocol protocolRequest) {
        // Extraer id de la comida
        String id = protocolRequest.getParameters().get(0).getValue();
        Food food = getFoodService().findFood(id);
        if (food == null) {
            String errorJson = generateNotFoundErrorJson("Plato no encontrado. Id no existente");
            respond(errorJson);
        } else {
            respond(objectToJSON(food));
        }
    }

    /**
     * Procesa la solicitud de agregar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostFood(Protocol protocolRequest) {
        Food food = new Food();
        // Reconstruir la comida a partid de lo que viene en los parámetros
        food.setId(protocolRequest.getParameters().get(0).getValue());
        food.setName(protocolRequest.getParameters().get(1).getValue());
        food.setDescription(protocolRequest.getParameters().get(2).getValue());
        

        String response = getFoodService().createFood(food);
        respond(response);
    }


    /**
     * Genera un ErrorJson de cliente no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson(String msg) {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage(msg);
        errors.add(error);
        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

    /**
     * @return the service
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * @param service the service to set
     */
    public void setCustomerService(CustomerService service) {
        this.customerService = service;
    }

    public FoodService getFoodService() {
        return foodService;
    }

    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

}
