package capitulo_3.exercicios.C331L;

/*
 * Created by jjmacagnan on 06/05/17.
 */
public class DoubleLinkedListUmaSentinelaCloneable<E> implements Cloneable{
    //Classe interna para representar o nó
    private static class No<E>{
        private E elemento;
        private No<E> prox;
        private No<E> ant;
        public No(E elem,No<E> ant,No<E> prox){
            this.elemento = elem;
            this.prox = prox;
            this.ant = ant;
        }
        public E getElemento(){
            return this.elemento;
        }
        public void setProx(No<E> prox){
            this.prox = prox;
        }
        public void setAnt(No<E> ant){
            this.ant = ant;
        }

        public No<E> getProx(){
            return this.prox;
        }
        public No<E> getAnt(){
            return this.ant;
        }

    }
    //Fim da classe interna

    //Variaveis de instancia (att)
    private int size=0;
    private No<E> sentinela;

    public DoubleLinkedListUmaSentinelaCloneable(){
        sentinela = new No<>(null,null,null);
        sentinela.setAnt(sentinela);
        sentinela.setProx(sentinela);
    }

    //Metodos de Acesso
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        if(size()==0)
            return true;
        else
            return false;
    }
    public E first(){
        if(isEmpty()){
            return null;
        }
        else{
            return sentinela.getProx().getElemento();
        }
    }
    public E last(){
        if(isEmpty()){
            return null;
        }
        else{
            return sentinela.getAnt().getElemento();
        }
    }

    //Metodos de atualizacao
    public void addFirst(E e){
        this.addBetween(e, sentinela,sentinela.getProx() );
    }
    public void addLast(E e){
        this.addBetween(e, sentinela.getAnt(),sentinela);
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(sentinela.getProx());
    }
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(sentinela.getAnt());
    }

    //Metodos privados
    private void addBetween(E e, No ant, No prox){
        No<E> novo = new No<>(e,ant,prox);
        ant.setProx(novo);
        prox.setAnt(novo);
        this.size++;
    }

    private E remove(No<E> no){
        no.getAnt().setProx(no.getProx());
        no.getProx().setAnt(no.getAnt());
        this.size--;
        return no.getElemento();
    }

    //Metodos extras
    public void imprime(){
        No aux = sentinela.getProx();
        while(aux != sentinela){
            System.out.println(aux.getElemento());
            aux=aux.getProx();
        }
        System.out.println("---Fim da Impressão---");
    }
    //Recebe um nó e devolve outro nó com o mesmo valor
    private No copia(No n){
        if(n == null || n==sentinela)
            return null;
        No novo = new No(n.getElemento(), null, null);
        return novo;
    }

    @Override
    public DoubleLinkedListUmaSentinelaCloneable<E> clone() throws CloneNotSupportedException{
        DoubleLinkedListUmaSentinelaCloneable<E> clone = new DoubleLinkedListUmaSentinelaCloneable();
        if(!isEmpty()){
            //crio o primeiro elemento
            No aux = sentinela.getProx();
            No primeiro = copia(aux);
            /*System.out.print("debug");
            System.out.println(clone.sentinela);
            System.out.print("debug");
            System.out.println(sentinela);*/
            clone.sentinela.setProx(primeiro);
            clone.sentinela.setAnt(primeiro);
            primeiro.setAnt(clone.sentinela);
            primeiro.setProx(clone.sentinela);
            //verifico se tem mais que um
            if (aux==null || aux==sentinela ){//so tem um elemento
                return clone;
            }
            //tem pelo menos 2
            No segundo = copia(aux);
            primeiro.setProx(segundo);
            segundo.setAnt(primeiro);
            clone.sentinela.ant=segundo;
            segundo.setProx(clone.sentinela);
            //Caso tiver mais que dois posso colocar em um casso comum
            aux=aux.getProx();
            No atual = segundo;

            while(aux!=sentinela && aux!=null){
                No novo = copia(aux);
                atual.setProx(novo);
                novo.setAnt(atual);
                novo.setProx(clone.sentinela);
                clone.sentinela.setAnt(novo);
                atual = novo;
                aux=aux.getProx();
            }
        }
        return clone;
    }
}
