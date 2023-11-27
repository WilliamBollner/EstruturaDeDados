import java.util.Arrays;

public class PilhaVetor <T> implements Pilha {

    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(Object valor) {
        if(limite == tamanho) {
            throw new PilhaCheiaException("Capacidade esgotada da pilha");
        }
        info[tamanho] = (T) valor;
        tamanho++;
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();

        tamanho--;
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia()) {
            throw new PilhaVaziaException("Pilha está vazia");
        }
        return info[tamanho-1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho==0;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.limite-1; i >= 0; i--) {
                if(info[i] != null) {
                    sb.append(info[i]);
                    if (i > 0) {
                        sb.append(", ");
                    }
                }
        }
        return sb.toString();
    }

    public void concatenar(PilhaVetor<T> p) {
        for (int i = 0; i <= p.tamanho; i++) {
            this.push(p.info[i]);
        }
    }
}
