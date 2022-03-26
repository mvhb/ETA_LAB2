import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexableListTest {

    String[] vetorEsquerdo = {"A", "B", "C"};
    String[] vetorDireito = {"D", "E", "F"};
    IndexableList<String> testLista = new IndexableList(vetorEsquerdo, vetorDireito);

    String[] vetorEsquerdoVazio = {};
    String[] vetorDireitoVazio = {};
    IndexableList<String> testListaVazio = new IndexableList(vetorEsquerdoVazio, vetorDireitoVazio);


    @Test
    void acrescentar() {
        testLista.acrescentar("devo ser adicionado como o ultimo da direita");
        assertEquals("devo ser adicionado como o ultimo da direita", testLista.get(testLista.size()));
    }

    @Test
    void prefixar() {
        testLista.prefixar("1987");
        assertEquals("1987", testLista.get(vetorEsquerdo.length + 1));
    }

    @Test
    void add() {
        testLista.add(0, "Maior do Norte e do Nordeste");
        assertEquals("Maior do Norte e do Nordeste", testLista.get(0));
    }

    @Test
    void aumentarEsquerdaArray() {
        int tamanhoVetorEsquerdo = vetorEsquerdo.length;
        int aumento = 10;
        testLista.aumentarEsquerdaArray(aumento);
        assertEquals(tamanhoVetorEsquerdo + aumento, vetorEsquerdo.length);
    }

    @Test
    void aumentar() {
        int tamanhoVetorDireito = vetorDireito.length;
        int aumento = 10;
        testLista.aumentar(aumento);
        assertEquals(tamanhoVetorDireito + aumento, vetorDireito.length);
    }

    @Test
    void contem() {
        assertTrue(testLista.contem("A")); //vetor esquerda
        assertTrue(testLista.contem("F")); //vetor direita
        assertFalse(testLista.contem("não existo"));
    }

    @Test
    void get() {
        assertEquals("A", testLista.get(0)); //vetor esquerda
        assertEquals("F", testLista.get(5)); //vetor direita
    }

    @Test
    void indexOf() {
        assertEquals(-3, testLista.indexOf("não existo"));
        testLista.add(1, "A"); // pra verificar se traz a primeira ocorrencia
        assertEquals(0, testLista.indexOf("A"));
    }

    @Test
    void v() {
        assertFalse(testLista.v());
        assertTrue(testListaVazio.v());
    }

    @Test
    void remover() {
        assertEquals("A", testLista.remover(0));
    }

    @Test
    void set() {
        testLista.set(0, "sou o primeiro");
        assertEquals("sou o primeiro", testLista.get(0));
    }

    @Test
    void size() {
        assertEquals(6, testLista.size());
    }
}