package capitulo_7.exercicios.reforco;

import capitulo_7.array_list.ArrayList;

/*R-7.9 O método de adição para um array dinâmica, conforme descrito no Fragmento de código 7.5,
tem a seguinte ineficiência. No caso de um redimensionamento ocorrer, a operação de redimensionamento
leva tempo para copiar todos os elementos da matriz antiga para uma nova matriz e, em seguida, o loop
subseqüente no corpo de adicionar altera alguns deles para abrir espaço para um novo elemento.
Dê uma implementação aprimorada do método de adição, de modo que, no caso de um redimensionamento,
os elementos são copiados para o seu lugar final no novo array (ou seja, nenhuma mudança é feita).*/
public class R79 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList(6);

        list.add(0, "A");
        list.add(1, "B");
        list.add(0, "C");

    }
}
