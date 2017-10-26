package capitulo_3.exercicios.inverte_lista_simples_recursivamente;

/*
 * Created by jjmacagnan on 07/05/17.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class SingleLinkedList<E> {
    //Classe interna para representar o nó
    private static class No<E>{
        private E elemento;
        private No<E> prox;
        public No(E elem, No<E> prox){
            this.elemento = elem;
            this.prox = prox;
        }
        public E getElemento(){
            return this.elemento;
        }
        public void setProx(No<E> prox){
            this.prox = prox;
        }

        public No<E> getProx(){
            return this.prox;
        }

    }
    //Fim da classe interna

    //Variaveis de instancia (att)
    private int size=0;
    private No<E> cabeca= null;
    private No<E> cauda = null;
    //Construtor, vazio pois ao instanciar a classe os att já são inicializados
    public SingleLinkedList(){
        //construtor vazio
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
        if(isEmpty()==true){
            return null;
        }
        else{
            return cabeca.getElemento();
        }
    }
    public E last(){
        if(isEmpty()==true){
            return null;
        }
        else{
            return cauda.getElemento();
        }
    }

    //Metodos de atualizacao
    public void addFirst(E e){
        //o novo elemento aponta para a cabeca
        No novo = new No(e,cabeca);
        cabeca = novo;
        if(size()==0)
            cauda=cabeca;
        this.size++;
    }
    public void addLast(E e){
        //o novo elemento aponta para a cabeca
        No novo = new No(e,null);
        if(size()==0)
            cabeca=novo;
        else
            cauda.setProx(novo);
        cauda=novo;
        this.size++;
    }
    public E removeFirst(){
        if(isEmpty()==true){
            return null;
        }
        else{
            E retorno = cabeca.getElemento();
            cabeca=cabeca.getProx();
            this.size--;
            if(size()==0){//só tinha um e agora não tem nenhum
                cauda=null;
            }
            return retorno;
        }
    }

    //Metodos extras
    public void imprime(){
        No aux = cabeca;
        while(aux != null){
            System.out.println(aux.getElemento());
            aux=aux.getProx();
        }
    }
}
