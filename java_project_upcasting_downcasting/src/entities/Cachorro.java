package entities;

public class Cachorro extends Mamifero{
  public void latir() {
    IO.print("Latindo...");
  }

  @Override
  public void emitirSom() {
    IO.println("Rosnando...");
  }
}
