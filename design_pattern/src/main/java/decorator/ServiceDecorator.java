package decorator;

public abstract class ServiceDecorator implements Service {
    protected Service service;

    public ServiceDecorator(Service service) {
        this.service = service;
    }

    @Override
    public String getDescription() {
        return service.getDescription();
    }
    @Override
    public double getCost() {
        return service.getCost();
    }
}
