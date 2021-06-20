package revisao.capitulo5.exercicio3;

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

    public static void main(String[] args) {
        Inteiro inteiro = new Inteiro();

        inteiro.carregaValor(-473158);
        System.out.println(inteiro.devolveValor());
        System.out.println(inteiro.devolveValorAbsoluto());
        inteiro.imprime();

    }
}

