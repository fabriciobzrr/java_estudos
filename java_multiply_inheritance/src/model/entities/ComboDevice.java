package model.entities;

public class ComboDevice extends Device implements Scanner, Printer {

    public ComboDevice(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public String scan() {
        return "ComboDevice scanning";
    }

    @Override
    public void print(String doc) {
        IO.println("ComboDevice printing: " + doc);
    }

    @Override
    public void processDoc(String doc) {
        IO.println("ComboDevice processing: " + doc);
    }
}
