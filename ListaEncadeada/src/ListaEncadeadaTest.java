import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaEncadeadaTest {

    private ListaEncadeada<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaEncadeada<>();
    }

    @Test
    public void testListaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testListaNaoVazia() {
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void testInclusaoUmNumero() {
        lista.inserir(5);
        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(5, primeiro.getInfo());
        assertNull(primeiro.getProximo());
    }

    @Test
    public void testInclusaoTresNumeros() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        assertEquals(15, lista.getPrimeiro().getInfo());
        assertEquals(10, lista.getPrimeiro().getProximo().getInfo());
        assertEquals(5, lista.getPrimeiro().getProximo().getProximo().getInfo());
        assertNull(lista.getPrimeiro().getProximo().getProximo().getProximo());
    }

    @Test
    public void testBuscarPrimeiraPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> noEncontrado = lista.buscar(20);
        assertNotNull(noEncontrado);
        assertEquals(20, noEncontrado.getInfo());
    }

    @Test
    public void testBuscarMeioLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> noEncontrado = lista.buscar(15);
        assertNotNull(noEncontrado);
        assertEquals(15, noEncontrado.getInfo());
    }

    @Test
    public void testBuscarDadoInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> noEncontrado = lista.buscar(50);
        assertNull(noEncontrado);
    }

    @Test
    public void testExclusaoPrimeiroElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);
        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void testExclusaoElementoMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);
        assertEquals("20,10,5", lista.toString());
    }

    @Test
    public void testObterNoPosicao0() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(0);
        assertNotNull(no);
        assertEquals(20, no.getInfo());
    }

    @Test
    public void testObterNoUltimaPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(3);
        assertNotNull(no);
        assertEquals(5, no.getInfo());
    }

    @Test
    public void testObterNoPosicaoInvalida() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.obterNo(10);
        });
    }

    @Test
    public void testObterComprimentoListaVazia() {
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    public void testObterComprimentoListaNaoVazia() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.obterComprimento());
    }
}
