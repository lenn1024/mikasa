package ai.code.mikasa.factory.abstractfactory;

public class IPhoneFactory implements IFactory {
    @Override
    public Product create() {
        return new IPhoneProduct();
    }
}
