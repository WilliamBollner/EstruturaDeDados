public class PilhaLista implements Pilha {

    private ListaEncadeada lista;

    public PilhaLista() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public void push(Object info) {
        lista.inserir(info);
    }

    @Override
    public Object pop() {
        Object valor;
        valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public Object peek() {
        if(estaVazia()) {
            throw new PilhaVaziaException("Pilha está vazia");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }
}
