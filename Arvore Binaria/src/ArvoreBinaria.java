public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T dado) {
        return pertence(raiz, dado);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T dado) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo().equals(dado) || pertence(no.esquerda, dado)
                    || pertence(no.direita, dado));
        }
    }


    public boolean isDegenerate() {
        return isDegenerate(raiz);
    }

    private boolean isDegenerate(NoArvoreBinaria<T> no) {
        if (no == null) {
            return true;
        }
        if (no.esquerda != null && no.direita != null) {
            return false;
        }
        return isDegenerate(no.esquerda) && isDegenerate(no.direita);
    }




    public String toString() {
        return arvorePre(raiz);
    }

    public String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        } else {
            return "<" + no.getInfo() + arvorePre(no.esquerda) + arvorePre(no.direita) + ">";
        }
    }


    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }
}





