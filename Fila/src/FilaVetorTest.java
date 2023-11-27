import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilaVetorTest {

    private FilaVetor<Integer> fila;

    @Test
    public void testEstaVazia() {
        fila = new FilaVetor<>(5);
        assertTrue(fila.estaVazia());
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testInserirERetirar() {
        fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.retirar());
        assertEquals(Integer.valueOf(20), fila.retirar());
        assertEquals(Integer.valueOf(30), fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testExcecaoFilaCheia() {
        fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertThrows(FilaCheiaException.class, () -> fila.inserir(40));
    }

    @Test
    public void testExcecaoFilaVazia() {
        fila = new FilaVetor<>(3);
        assertThrows(FilaVaziaException.class, () -> fila.retirar());
    }

    @Test
    public void testPeek() {
        fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.peek());
        assertEquals(Integer.valueOf(10), fila.retirar());
    }

    @Test
    public void testLiberar() {
        fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testConcatenar() {
        FilaVetor f1 = new FilaVetor<>(5);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);

        FilaVetor f2 = new FilaVetor<>(3);
        f1.inserir(40);
        f1.inserir(50);

        FilaVetor filaC = f1.concatenar(f2);
        assertEquals("10, 20, 30, 40, 50", filaC.toString());
    }

    @Test
    public void testEncolher() {
        FilaVetor f1 = new FilaVetor<>(5);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);
        f1.retirar();
        f1.retirar();
        f1.retirar();
        f1.inserir(10);
        f1.inserir(20);
        f1.retirar();
        f1.inserir(30);
        f1.inserir(50);

        assertEquals(4, f1.getInicio());

        f1.encolher();

        assertEquals(0, f1.getInicio());
        assertEquals(20, f1.retirar());


    }
}
