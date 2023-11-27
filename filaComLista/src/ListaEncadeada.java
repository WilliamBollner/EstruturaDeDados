public class ListaEncadeada<T> {
    private NoLista<T> primeiro; // Referência para o primeiro nó da lista
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        primeiro = null; // Ao criar a lista, define-se que ela está vazia
    }

    public NoLista<T> getPrimeiro() {
        return primeiro; // Retorna o primeiro nó da lista
    }

    public void inserir(T info) {
        NoLista<T> novoNo = new NoLista<>(info); // Cria um novo nó com a informação fornecida
        novoNo.setProximo(primeiro); // O novo nó aponta para o nó que era o primeiro
        primeiro = novoNo; // O novo nó agora é o primeiro
    }

    public boolean estaVazia() {
        return primeiro == null; // Verifica se a lista está vazia olhando se o primeiro nó é nulo
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual; // Retorna o nó se a informação for encontrada
            }
            atual = atual.getProximo(); // Move para o próximo nó
        }
        return null; // Retorna nulo se a informação não for encontrada
    }

    public void retirar(T info) {
        if (estaVazia()) {
            return; // Se a lista estiver vazia, não há nada para remover
        }

        if (primeiro.getInfo().equals(info)) {
            primeiro = primeiro.getProximo(); // Remove o primeiro nó se a informação for encontrada nele
            return;
        }

        NoLista<T> atual = primeiro;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getInfo().equals(info)) {
                atual.setProximo(atual.getProximo().getProximo()); // Remove o nó se a informação for encontrada no próximo nó
                return;
            }
            atual = atual.getProximo(); // Move para o próximo nó
        }
    }

    public int obterComprimento() {
        int comprimento = 0;
        NoLista<T> atual = primeiro;
        while (atual != null) {
            comprimento++; // Incrementa o comprimento enquanto percorre os nós
            atual = atual.getProximo(); // Move para o próximo nó
        }
        return comprimento; // Retorna o comprimento da lista
    }

    public NoLista<T> obterNo(int posicao) {
        if (posicao < 0 || posicao >= obterComprimento()) {
            throw new IndexOutOfBoundsException(); // Lança uma exceção se a posição for inválida
        }

        NoLista<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo(); // Move para o nó na posição desejada
        }
        return atual; // Retorna o nó na posição fornecida
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        NoLista<T> atual = primeiro;

        while (atual != null) {
            if (resultado.length() > 0) {
                resultado.append(",");
            }
            resultado.append(atual.getInfo()); // Adiciona a informação do nó ao resultado
            atual = atual.getProximo(); // Move para o próximo nó"
        }

        return resultado.toString(); // Retorna a representação da lista como uma string
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> atual = primeiro;
        while (atual != null) {

            atual = atual.getProximo(); // Move para o próximo nó"
        }
    }
}
