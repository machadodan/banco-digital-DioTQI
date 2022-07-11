import utilitarios.FormatValor;

import javax.swing.*;

public class Conta implements Iconta{

    private static int incrementConta = 1;
    private int numeroConta;
    private String tipoConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    // contrutor da classe porem passaremos so a pessoa
    public Conta(Pessoa pessoa) {
        //adiciona automaticamente e incrementa +1 ao final
        this.numeroConta = incrementConta;
        this.pessoa = pessoa;

        incrementConta += 1;
    }

    // getters e setter somente numero conta, pessoa e saldo
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {return  tipoConta;}
    public void setTipoConta(String tipoConta) {this.tipoConta = tipoConta;}

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    // gerando metodo toString pegando dados pessoa e formatação valores de utilitarios
    @Override
    public String toString() {
        return "\nNumero da conta: " + this.getNumeroConta() +
                "\nTipo da Conta: " + this.getTipoConta() +
                "\nNome Cliente: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail :" + this.pessoa.getEmail() +
                "\nSaldo: " + FormatValor.doubleToString(this.getSaldo()) +
                "\n";
    }

    // metodo de deposito
    @Override
    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar depósito!");
        }
    }

    //metodo para saque
    @Override
    public void sacar(Double valor) {
        if(valor > 0 && this.saldo >= valor) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");

        }else {
            JOptionPane.showMessageDialog(null, "Saldo para saque insuficiente!");
        }
    }

    // método transferir
    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!");

        }else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar transferencia!");

        }
    }
}
