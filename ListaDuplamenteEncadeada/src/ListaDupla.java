public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    // Construtor da classe ListaDupla
    public ListaDupla() {
        this.primeiro = null; // Inicializa a lista como vazia
    }

    // Método getter para obter o primeiro nó da lista
    public NoListaDupla<T> getPrimeiro() {
        return this.primeiro;
    }

    // Método para inserir um valor no final da lista
    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    // Método para buscar um valor na lista
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p; // Retorna o nó se encontrar o valor
            }
            p = p.getProximo(); // Avança para o próximo nó
        }
        return null; // Retorna null se não encontrar o valor
    }

    // Método para retirar um valor da lista
    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);
        if (p != null) {
            if (p.getAnterior() != null) {
                p.getAnterior().setProximo(p.getProximo()); // Remove a referência ao nó atual
            } else {
                primeiro = p.getProximo(); // Se o nó a ser removido é o primeiro, atualiza o primeiro
            }
            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior()); // Remove a referência ao nó anterior
            }
        }
    }

    // Método para exibir os valores na ordem inversa
    public void exibirOrdemInversa() {
        NoListaDupla<T> p = primeiro;
        while (p != null && p.getProximo() != null) {
            p = p.getProximo(); // Avança até o último nó
        }

        while (p != null) {
            System.out.println(p.getInfo()); // Imprime os valores em ordem inversa
            p = p.getAnterior(); // Retrocede para o nó anterior
        }
    }

    // Método para liberar a lista
    public void liberar() {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            NoListaDupla<T> temp = p.getProximo(); // Armazena a referência ao próximo nó
            p.setProximo(null); // Remove a referência ao próximo nó
            p.setAnterior(null); // Remove a referência ao nó anterior
            p = temp; // Avança para o próximo nó
        }
        primeiro = null; // Finaliza liberando o primeiro nó
    }

    // Sobrescreve o método toString para exibir os valores da lista
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            sb.append(p.getInfo());
            if (p.getProximo() != null) {
                sb.append(", ");
            }
            p = p.getProximo();
        }
        return sb.toString(); // Retorna a representação da lista como uma string
    }

    public ListaDupla<T> clonar (){
        ListaDupla<T> clonada = new ListaDupla<>();
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            clonada.inserir(p.getInfo());
            p = p.getProximo();
        }
        return clonada;
    }
}
