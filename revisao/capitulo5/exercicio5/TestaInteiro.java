package revisao.capitulo5.exercicio5;

import revisao.capitulo5.exercicio4.Inteiro;

public class TestaInteiro {

    public static void main(String[] args) {
        Inteiro inteiro = new Inteiro();

        inteiro.carregaValor(1);
        System.out.println(inteiro.devolveValor());
        System.out.println(inteiro.devolveValorAbsoluto());
        inteiro.imprime();
        System.out.println(inteiro.soma(7));
        System.out.println(inteiro.subtrai(2));
        System.out.println(inteiro.multiplicaPor(3));
        System.out.println(inteiro.dividePor(4));
        System.out.println(inteiro.dividePor(0));

        System.out.println(inteiro.multiplicaPor(7));

        System.out.println(inteiro.dividePor(110));
    }

}
