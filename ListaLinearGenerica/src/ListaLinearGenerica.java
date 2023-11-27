public class ListaLinearGenerica<T> {

    private T[] info;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;

    public ListaLinearGenerica(T[] info, int tamanho) {
        this.info = (T[]) new Object[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() {
        T[] novo = (T[]) new Object[info.length + CAPACIDADE_INICIAL];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int posicao = buscar(valor);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = (T[]) new Object[CAPACIDADE_INICIAL];
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            return info[posicao];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            T temp = info[i];
            info[i] = info[tamanho - i - 1];
            info[tamanho - i - 1] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            if (i > 0)
                resultado.append(",");
            resultado.append(info[i]);
        }

        return resultado.toString();
    }
}
