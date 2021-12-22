package co.edu.unicauca.layersmvc.infra;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import co.edu.unicauca.layersmvc.domain.Response;

public interface Publisher {
  public void publicar(Response s) throws IOException, TimeoutException ;
}
