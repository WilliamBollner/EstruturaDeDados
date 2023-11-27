public class FilaVetor<T> implements Fila {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    public int getLimite() {
        return limite;
    }
    public int getInicio() {
        return inicio;
    }

    @Override
    public void inserir(Object valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException("Fila está cheia");
        }
        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = (T) valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public Object peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila está vazia");
        }

        return info[inicio];
    }

    @Override
    public Object retirar() {
        T valor = (T) peek();
        inicio = (inicio + 1) % limite;
        tamanho = tamanho - 1;
        return valor;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;
    }

    public FilaVetor<T> concatenar(FilaVetor<T> f2) {
        FilaVetor<T> novaFila = new FilaVetor<>(getLimite() + f2.getLimite());
        for (int i = 0; i < tamanho; i++) {
            novaFila.inserir(info[(inicio + i) % limite]);
        }
        for (int i = 0; i < f2.tamanho; i++) {
            novaFila.inserir(f2.info[(f2.inicio + i) % f2.limite]);
        }
        return novaFila;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % limite;
            sb.append(info[pos]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void encolher() {
        T valorInicio = info[inicio];
        int novoLimite = tamanho;
        T[] novoInfo = (T[]) new Object[novoLimite];

        for (int i = 0; i < tamanho; i++) {
            novoInfo[i] = info[(inicio + i) % limite];
        }

        info = novoInfo;
        limite = novoLimite;

        for (int i = 0; i < tamanho; i++) {
            if (novoInfo[i].equals(valorInicio)) {
                inicio = i;
                break;
            }
        }
    }

}
