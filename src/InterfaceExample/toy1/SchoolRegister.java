package InterfaceExample.toy1;

public interface SchoolRegister<T> extends Register<T>{
    @Override
    void setRegister(T t);

    @Override
    T getRegsiter();
}
