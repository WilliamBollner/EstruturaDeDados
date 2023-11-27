public class NoLista<T> {
    private T info;
    private NoLista<T> proximo;

    public NoLista(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
}
