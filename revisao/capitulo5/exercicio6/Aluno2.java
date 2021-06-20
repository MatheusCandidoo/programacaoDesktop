package revisao.capitulo5.exercicio6;

public class Aluno2 {

    double p1, p2, p3, p4;

    public void recebeNota1(double nota1) {
        p1 = nota1;
    }

    public void recebeNota2(double nota2) {
        p2 = nota2;
    }

    public void recebeNota3(double nota3) {
        p3 = nota3;
    }

    public void recebeNota4(double nota4) {
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

    public void imprimeMédia() {
        System.out.println(
                "Média: " + calculaMédiaDoCandidato() + " -> " + retornaCondiçãoDoCandidato());
    }
}
