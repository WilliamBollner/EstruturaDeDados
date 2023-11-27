import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaVetorTest {

    @Test
    public void estaVaziaTrue(){
        PilhaVetor<Integer> pv = new PilhaVetor<>(10);

        assertEquals(true, pv.estaVazia());
    }

    @Test
    public void estaVaziaFalse(){
        PilhaVetor<Integer> pv = new PilhaVetor<>(10);
        pv.push(10);

        assertEquals(false, pv.estaVazia());
    }

    @Test
    public void pushAndPop(){
        PilhaVetor<Integer> pv = new PilhaVetor<>(10);

        pv.push(10);
        pv.push(20);
        pv.push(30);

        assertEquals(30, pv.pop());
        assertEquals(20, pv.pop());
        assertEquals(10, pv.pop());
    }

    @Test
    public void pilhaCheiaException(){
        PilhaVetor<Integer> pv = new PilhaVetor<>(3);

        pv.push(10);
        pv.push(20);
        pv.push(30);

        Assertions.assertThrows(PilhaCheiaException.class, () -> {
            pv.push(40);
        });
    }

    @Test
    public void pilhaVaziaException() {
        PilhaVetor<Integer> pv = new PilhaVetor<>(10);

        Assertions.assertThrows(PilhaVaziaException.class, () -> {
            pv.pop();
        });
    }

    @Test
    public void peekTest() {
        PilhaVetor<Integer> pv = new PilhaVetor<>(5);

        pv.push(10);
        pv.push(20);
        pv.push(30);

        assertEquals(30, pv.peek());
        assertEquals(30, pv.pop());
    }

    @Test
    public void liberarTest(){
        PilhaVetor<Integer> pv = new PilhaVetor<>(5);

        pv.push(10);
        pv.push(20);
        pv.push(30);
        pv.liberar();

        assertEquals(true, pv.estaVazia());
    }

    @Test
    public void concatenarPilhas(){
        PilhaVetor<Integer> pv1 = new PilhaVetor<>(10);

        pv1.push(10);
        pv1.push(20);
        pv1.push(30);

        PilhaVetor<Integer> pv2 = new PilhaVetor<>(5);

        pv2.push(40);
        pv2.push(50);

        pv1.concatenar(pv2);
        assertEquals("50, 40, 30, 20, 10", pv1.toString());
    }
}