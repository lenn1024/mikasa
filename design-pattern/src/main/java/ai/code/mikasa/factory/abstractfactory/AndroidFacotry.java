package ai.code.mikasa.factory.abstractfactory;

public class AndroidFacotry implements IFactory {
    @Override
    public Product create() {
        return new AndroidProduct();
    }
}
