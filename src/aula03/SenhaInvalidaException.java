package aula03;

public class SenhaInvalidaException extends RuntimeException {
  public SenhaInvalidaException(String message) {
    super(message);
  }
}
