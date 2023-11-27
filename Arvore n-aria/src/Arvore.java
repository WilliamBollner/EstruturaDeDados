import java.util.ArrayList;
import java.util.List;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public String toString() {
        if (raiz == null) {
            return "";
        }
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s;
        s = "<";
        s = s + no.getInfo();
        NoArvore<T> p;
        p = no.getPrimeiro();
        while (p != null) {
            s = s + obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        s = s + ">";
        return s;
    }

    public boolean pertence(T info) {
        if(raiz == null) {
            return false;
        } else {
            return pertence(getRaiz(), info);
        }
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return true;
        } else {
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                if (pertence(p, info)) {
                    return true;
                } else {
                    p = p.getProximo();
                }
            }
        }
            return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        int qtde = 1;

        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            qtde += contarNos(p);
            p = p.getProximo();
        }

        return qtde;
    }
}
