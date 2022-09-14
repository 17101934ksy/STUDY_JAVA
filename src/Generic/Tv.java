package Generic;

public class Tv extends Product {
    public String kind = "tv";
    public String Model = "smart tv";

    @Override
    public Object getKind() {
        return this.kind;
    }

    @Override
    public Object getModel() {
        return this.model;
    }

    @Override
    public void setKind(Object kind) {
        super.setKind(kind);
    }

    @Override
    public void setModel(Object model) {
        super.setModel(model);
    }
}
