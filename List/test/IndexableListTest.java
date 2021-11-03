import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexableListTest {

    //Exemplo de criação da lista com dois vetores
        String[] vetorEsquerdo = {"morango", "maça", "uva"};
        String[] vetorDireito = {"manga", "abacaxi", "banana"};
        IndexableList<String> testLista = new IndexableList(vetorEsquerdo, vetorDireito);


    @Test
    void acrescentar() {
        testLista.acrescentar("laranja");
        assertEquals("laranja", testLista.get(6), "Error: Appended element is incorrect.");
    }

    @Test
    void prefixar() {
        testLista.prefixar("laranja");
        assertEquals("laranja", testLista.get(0), "Error: Prepend element is incorrect.");
    }

    @Test
    void add() {
        testLista.add(2,"laranja");
        assertEquals(7, testLista.size(), "Error: Add element is incorrect.");
    }

    @Test
    void contem() {
       assertTrue(testLista.contem("uva"), "Element not found.");
    }

    @Test
    void get() {
        assertEquals(testLista.get(1), "maça", "Element not found.");
    }

    @Test
    void indexOf() {
        int element = testLista.indexOf("abacaxi");
        assertEquals(4, element , "Index element is incorrect.");
    }

    @Test
    void isEmpty() {
        assertFalse(testLista.isEmpty(), "List is not empty.");
    }

    @Test
    void remover() {
        testLista.remover(3);
        assertEquals(testLista.get(3), "abacaxi" , "Remove element is incorrect.");
    }

    @Test
    void set() {
        testLista.add(2,"pitomba");
        assertEquals("pitomba", testLista.get(2), "Error: Set element is incorrect.");
    }

    @Test
    void size() {
        assertEquals(6, testLista.size(), "Size is incorrect.");
    }
}