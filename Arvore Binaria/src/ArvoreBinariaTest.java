import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArvoreBinariaTest {

        @Test
        public void testArvoreVazia() {
            ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
            assertTrue(arvore.estaVazia());
        }

        @Test
        public void testArvoreComNo() {
            ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
            arvore.setRaiz(new NoArvoreBinaria<>(5));
            assertFalse(arvore.estaVazia());
        }

        @Test
        public void testArvorePre() {
            NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
            NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);

            NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
            NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
            NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);

            NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, n2, n3);

            ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
            arvore.setRaiz(raiz);

            assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvore.arvorePre(raiz));
        }

        @Test
        public void testPertence1() {
            NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
            NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);

            NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
            NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
            NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);

            NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, n2, n3);

            ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
            arvore.setRaiz(raiz);

            assertTrue(arvore.pertence(1));
        }

        @Test
        public void testPertence2() {
            NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
            NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);

            NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
            NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
            NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);

            NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, n2, n3);

            ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
            arvore.setRaiz(raiz);


            assertTrue(arvore.pertence(3));
        }

    @Test
    public void testPertence3() {
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);

        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, n2, n3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(raiz);

        assertTrue(arvore.pertence(6));
    }

    @Test
    public void testPertence4() {
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);

        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, n2, n3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(raiz);

        assertFalse(arvore.pertence(10));
    }

    @Test
    public void testContarNos() {
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);

        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, n2, n3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(raiz);

        assertEquals(6, arvore.contarNos());
    }

    @Test
    public void testIsDegenerate() {
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);

        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, n2, n3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(raiz);

        assertFalse(arvore.isDegenerate());
    }

    @Test
    public void testIsDegenerateTrue() {

        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, null, n6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, null, n3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(raiz);

        assertTrue(arvore.isDegenerate());
    }
}