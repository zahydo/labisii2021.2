package co.edu.unicauca.layersmvc.infra;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface Publisher {
  public void publicar(String s) throws IOException, TimeoutException ;
}
