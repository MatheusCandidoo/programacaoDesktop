package revisao.capitulo5.exercicio4;

public class Inteiro {
    private int valor;

    public void carregaValor(int v) {
        this.valor = v;
    }

    public int devolveValor() {
        return valor;
    }

    public int devolveValorAbsoluto() {
        if (valor < 0) {
            return valor * (-1);
        }
        return valor;
    }

    public void imprime() {
        System.out.println("Valor: " + valor);
    }

    public int soma(int v) {
        return valor += v;
    }

    public int subtrai(int v) {
        return valor -= v;
    }

    public int multiplicaPor(int v) {
        return valor *= v;
    }

    public int dividePor(int v) {
        if (v != 0) {
            return valor /= v;
        }
        System.out.println("Impossível dividir por zero!");
        return 0;
    }

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
    }
}
