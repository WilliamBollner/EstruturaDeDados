import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaListaTest {

    @Test
    public void testEstaVaziaTrue() {
        ListaEncadeada lista;
        PilhaLista pilha = new PilhaLista();
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testEstaVaziaFalse() {
        PilhaLista pilha = new PilhaLista();
        pilha.push(30);
        assertFalse(pilha.estaVazia());
    }

    @Test
    public void testPop() {
        PilhaLista pilha = new PilhaLista();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
    }

    @Test
    public void testPeek() {
        PilhaLista pilha = new PilhaLista();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(30, pilha.peek());
    }

    @Test
    public void testLiberar() {
        PilhaLista pilha = new PilhaLista();
        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }

}