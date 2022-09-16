package Generic;

public class ChildProductGeneric<T, M, C> extends ProductGeneric<T, M> {
    private C company;
    public C getCompany() {return this.company; }
    public void setCompany(C company) {this.company = company; }
}
