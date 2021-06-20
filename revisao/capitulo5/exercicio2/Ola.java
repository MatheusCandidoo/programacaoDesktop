package revisao.capitulo5.exercicio2;

import java.util.Random;
import javax.swing.JOptionPane;

public class Ola {
    private String cumprimentosDisponíveis[] = {"Olá", "Como vai?", "Gostaria de um copo  d'água"};
    private int indexDoComprimentoASerExibido;

    public void saudação() {
        System.out.println(cumprimentosDisponíveis[indexDoComprimentoASerExibido]);
    }

    public void defineProximoCumprimento() {
        Random geradorDeUmNovoIndex = new Random(System.currentTimeMillis());
        indexDoComprimentoASerExibido = geradorDeUmNovoIndex.nextInt(2);
    }

    public void cumprimenta() {
        saudação();
        defineProximoCumprimento();
    }


    public static void main(String[] args) {
        Ola olá = new Ola();

        do {
            olá.cumprimenta();
        } while (JOptionPane.showConfirmDialog(null, "Cumprimentar novamente?", "Novo Cumprimento?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION);
    }
}
