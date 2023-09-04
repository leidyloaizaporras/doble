/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doble;



/**
 *
 * @author USUARIO
 */
public class Doble {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
    NodoDoble<String> list1 = new NodoDoble<>();
    list1.add("leidy");
    list1.add("maria");
    list1.add("juan");

    System.out.println("Lista 1:");
    for (int i = 0; i < list1.tamaño(); i++) {
        System.out.println(list1.get(i));
    }
    System.out.println("Tamaño de la lista 1: " + list1.tamaño());

    NodoDoble<String> list2 = new NodoDoble<>();
    list2.add("leidy");
    list2.add("maria");
    list2.add("juan");

    System.out.println("Lista 2:");
    for (int i = 0; i < list2.tamaño(); i++) {
        System.out.println(list2.get(i));
    }
    System.out.println("Tamaño de la lista 2: " + list2.tamaño());

    System.out.println("¿Las dos listas son iguales? " + list1.equals(list2));
}
}

















