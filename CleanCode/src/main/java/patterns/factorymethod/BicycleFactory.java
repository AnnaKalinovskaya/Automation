package patterns.factorymethod;

class BicycleFactory implements TransportFactory{

    public Transport createTransport(){
        return new Bicycle();
    }
}
