package patterns.factorymethod;

class CarFactory implements TransportFactory{

    public Transport createTransport(){
        return new Car();
    }
}
