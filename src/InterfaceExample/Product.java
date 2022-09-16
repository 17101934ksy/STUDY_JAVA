package InterfaceExample;

public class Product<T, M> {
    private T t;
    private M m;

    public void setT(T t) { this.t = t;}
    public void setM(M m) { this.m = m;}
    public T getT(){ return this.t;}
    public M getM(){ return this.m;}
}
