package entities;

public class Account {
    public int numeroConta;
    public int numeroAgencia;
    public String nomeCliente;
    public String dataNascimento;
    public double saldoConta;
    public boolean status = true;

    public void sacarValor(double valor) {
    }
    public void transferirValor(ContaCorrente contaDestino, double valorSolicitado) {
    }
    public void cancelarContaComJ(String justificativa) {
        status = false;
        System.out.println("Cancelamento de conta: " + justificativa);
    }
    public List consultarExtrato(Instant data1, Instant data2) {
        System.out.println("Extrato da conta entre datas: " + data1 + " e " + data2);
    }

    public double consultarSaldo() {
        return this.saldoConta;
    }

}
