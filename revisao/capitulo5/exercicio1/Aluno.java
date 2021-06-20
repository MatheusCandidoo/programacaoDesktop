package programacaoDesktop.revisao.capitulo5.exercicio1;

public class Aluno {

    double p1, p2, p3, p4;

    public void leituraDeNotas(double nota1, double nota2, double nota3, double nota4) {
        p1 = nota1;
        p2 = nota2;
        p3 = nota3;
        p4 = nota4;
    }

    public double calculaMédiaDoCandidato() {
        return (p1 + p2 + p3 + p4) / 4;
    }

    public String retornaCondiçãoDoCandidato() {
        double média = calculaMédiaDoCandidato();
        if (média >= 6) {
            return "Aprovado";
        } else if (média >= 4) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public void imprimeResultado() {
        System.out.println(
                "Média: " + calculaMédiaDoCandidato() + " -> " + retornaCondiçãoDoCandidato());
    }

    public static void main(String[] args) {
        System.out.println("Bem vindo ao calculador de média do Aluno!");
        Aluno aluno = new Aluno();

        aluno.leituraDeNotas(4, 9, 5, 2);

        aluno.calculaMédiaDoCandidato();

        aluno.imprimeResultado();
    }
}
