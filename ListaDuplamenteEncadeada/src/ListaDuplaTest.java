import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplaTest {

    @Test
    public void testInclusaoDados() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        String expected = "20, 15, 10, 5";
        assertEquals(expected, lista.toString());
    }

    @Test
    public void testBuscarElemento() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(20);
        lista.inserir(15);
        lista.inserir(10);
        lista.inserir(5);

        NoListaDupla<Integer> resultado = lista.buscar(20);
        assertNotNull(resultado);
        assertEquals(20, resultado.getInfo());

        NoListaDupla<Integer> resultadoNaoEncontrado = lista.buscar(25);
        assertNull(resultadoNaoEncontrado);
    }

    @Test
    public void testBuscarElementoNoMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> resultado = lista.buscar(10);
        assertNotNull(resultado);
        assertEquals(10, resultado.getInfo());
    }

    @Test
    public void testRemoverElementoInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        String expected = "15, 10, 5";
        assertEquals(expected, lista.toString());
    }

    @Test
    public void testRemoverElementoMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(20);
        lista.inserir(15);
        lista.inserir(10);
        lista.inserir(5);

        lista.retirar(10);

        int[] valoresEsperados = {20, 15, 5};
        NoListaDupla<Integer> atual = lista.getPrimeiro();

        for (int valorEsperado : valoresEsperados) {
            assertNotNull(atual);
            assertEquals(valorEsperado, atual.getInfo());
            atual = atual.getProximo();
        }

        atual = lista.getPrimeiro();
        for (int i = valoresEsperados.length - 1; i >= 0; i--) {
            assertEquals(valoresEsperados[i], atual.getInfo());
            atual = atual.getProximo();
        }
    }

    @Test
    public void testRemoverElementoFim() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(20);
        lista.inserir(15);
        lista.inserir(10);
        lista.inserir(5);

        lista.retirar(5);

        int[] valoresEsperados = {20, 15, 10};
        NoListaDupla<Integer> atual = lista.getPrimeiro();

        for (int valorEsperado : valoresEsperados) {
            assertNotNull(atual);
            assertEquals(valorEsperado, atual.getInfo());
            atual = atual.getProximo();
        }

        atual = lista.getPrimeiro();
        for (int i = valoresEsperados.length - 1; i >= 0; i--) {
            assertEquals(valoresEsperados[i], atual.getInfo());
            atual = atual.getProximo();
        }
    }

    @Test
    public void testLiberarDados() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(20);
        lista.inserir(15);
        lista.inserir(10);
        lista.inserir(5);

        NoListaDupla<Integer> no5 = lista.buscar(5);
        NoListaDupla<Integer> no10 = lista.buscar(10);
        NoListaDupla<Integer> no15 = lista.buscar(15);
        NoListaDupla<Integer> no20 = lista.buscar(20);

        lista.liberar();

        assertNull(no5.getAnterior());
        assertNull(no5.getProximo());
        assertNull(no10.getAnterior());
        assertNull(no10.getProximo());
        assertNull(no15.getAnterior());
        assertNull(no15.getProximo());
        assertNull(no20.getAnterior());
        assertNull(no20.getProximo());
    }

    @Test
    public void clonar(){
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.clonar().toString(), "5, 10, 15, 20");
    }
}
