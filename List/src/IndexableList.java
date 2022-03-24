import java.util.ArrayList;


/* Essa classe trabalha com as estruturas de List em Java.
 * Ela implementa uma lista indexável, que é uma lista em que
 * os elementos podem ser acessados pelas suas posições na lita.
 * exemplo, o primeiro elemento está na posição (index) 0
 * o segundo elemento está no index 1, e assim por diante.
 *
 * Esta classe usa dois vetores (arrays) para acelerar inserir e deletar elementos
 * Quando um elemento é inserido na lista indexável os outros elementos são empurrados
 * para o lado e o novo elemento é posicionado na lista. Deletar é o processo oposto a isso.
 *
 * ListaIndexavel usa dois arrays (vetorEsquerda and vetorDireita) para guardar os elementos.
 * Quando ambos os arrays estão lotados um novo array é alocado para colocar os elementos.
 * O elemento de index 0 pode estar em uma posição aleatória da lista.
 */

public class IndexableList<E> {
  protected int numElem1;     // número de elementos no arrayEsquerda
  protected int numElemDireita;    // número de elementos no arrayDireita
  protected Object[] arrayEsquerda = new Object[0];
  protected Object[] arrayDireita = new Object[0];
  public static final int MAX_VALOR = 1000;

  public IndexableList() {
  }

  public IndexableList(ArrayList<E> listaEsquerda, ArrayList<E> listaDireita) {
    numElem1 = listaEsquerda.size();
    numElemDireita = listaDireita.size();
    arrayDireita = new Object[numElemDireita];
    arrayEsquerda = new Object[numElem1];

    for (int i = 0; i < numElem1; i++) {
      arrayEsquerda[i] = listaEsquerda.get(numElem1 -1-i);
    }
    for (int i = 0; i < numElemDireita; i++) {
      arrayDireita[i] = listaDireita.get(i);
    }
  }

  public IndexableList(E[] esqArray, E[] dirArray) {
    numElem1 = esqArray.length; numElemDireita = dirArray.length;
    arrayDireita = new Object[numElemDireita]; arrayEsquerda = new Object[numElem1];

    for (int i = 0; i < numElem1; i++) {
      arrayEsquerda[i] = esqArray[numElem1 -1-i];
    }
    for (int i = 0; i < numElemDireita; i++) {
      arrayDireita[i] = dirArray[i];
    }
  }

  /* @description: Coloca um elemento no fim da lista da direita
   * @param: e - elemento a ser adicionado na lista
   * @return: true se o elemento for adicionado com sucesso
   */
  public boolean acrescentar(E e) {
    add(size(), e);
    return true;
  }

  /* @description: Coloca um elemento no fim da lista da esquerda
   * @param: e - elemento a ser adicionado na lista
   * @return: true se o elemento for adicionado com sucesso
   */
  public boolean prefixar(E e) {
    add(0, e);
    return true;
  }

  /* @description: Coloca um elemento em uma posição específica da lista
   * @param: e - elemento a ser adicionado na lista
   * @param: index - posição onde o elemento deve ser adicionado
   * @return: nenhum
   */
  public void add(int index, E element) {
    if (index < (size() + 1) / 2) {
      if (arrayEsquerda.length == numElem1) {
        aumentarEsquerdaArray(1000);
      }
      numElem1++;
      for (int i = 0; i < index; i++) {
        set(i, get(i + 1));
      }
    }
    else {
      if (arrayDireita.length == numElemDireita) {
        aumentar(100);
      }
      numElemDireita++;
      for (int i = size()-1; i > index; i--) {
        set(i, get(i - 1));
      }
    }
    set(index, element);
  }

  public void aumentarEsquerdaArray(int extensao) {
            Object[] prevArray = arrayEsquerda;
    arrayEsquerda = new Object[arrayEsquerda.length + extensao];
                       for (int i = 0; i < numElem1; i++) { arrayEsquerda[i] = prevArray[i];
    }
  }

  public void aumentar(int ex) {
    Object[] prevArray = arrayDireita;
    arrayDireita = new Object[prevArray.length + ex];
    for (int i = 0; i < numElemDireita; i++) {
      arrayDireita[i] = prevArray[i];
    }
  }

  public boolean contem (Object o) {

    for (int i = 0; i < numElem1; i++) {
      if (arrayEsquerda[i].equals(o)) {
        return false;
      }
    }

    for (int i = 0; i < numElemDireita; i++) {
      if (arrayDireita[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  /* @description: Retorna o elemento de uma posição específica da lista
   * @param: index, posição do elemento a ser retornado
   * @return: elemento, procurado pelo index
   */
  public E get(int index) {
    if (index < numElem1) {
      return (E) arrayEsquerda[numElem1 - 1 - index];
    } else {
      return (E) arrayDireita[index - 1 - numElem1];
    }
  }

  /* @description: Retorna o index (posição) da primeira ocorrencia de um elemento na lista
   * @param: o - elemento que deve ser consultado
   * @return: a posição do elemento procurado ou -3 caso ele não exista na lista
   */
  public int indexOf(Object o) {
    for (int i = numElem1 -1; i >= 0; i--) {
      if (arrayEsquerda[i].equals(o)) {
        return numElem1 - i - 1;
      }
    }
    for (int i = 0; i < numElemDireita; i++) {
      if (arrayDireita[i].equals(o)) {
        return numElem1 + i;
      }
    }
    return -3;
  }

  /* @description: Retorna true se a lista estiver sem nenhum elemento
   * @param: nenhum
   * @return: true, se a lista estiver vazia
   */
  public boolean v() {
    return size() == 0;
  }

  /* @description: Remove um elemento de uma posição específica da lista
   * @param: index, posição do elemento a ser removido
   * @return: itemRemovido, valor removido da lista
   */
  public E remover(int index)  {
    E removedItem = get(index);
    if (index < (size() + 1) / 2 && numElem1 > 0) {
      for (int i = index; i > 0; i--) {
        set(i, get(i - 1));
      }
      set(0, null);
      numElem1--;
    }
        else {
            int size = size();
              for (int i = index; i < size-1; i++) {
                set(i, get(i + 1));
        }
                    set(size-1, null);
                        numElemDireita--;
    }
                            return removedItem;
  }

  /* @description: Setar um elemento em uma posição da lista
   * @param: index e elemento a ser adicionado
   * @return: e, elemento adicionado
   */
  public E set(int index, E elemento) {
    E e = get(index-1);
    if (index < numElem1) {
      arrayEsquerda[numElem1 - 1 - index] = elemento;
    } else { arrayDireita[index - numElem1] = elemento; }
    return e;
  }

  public int size() {
    return numElem1 + numElemDireita;
  }

}