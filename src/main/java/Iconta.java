import javax.swing.*;

public interface Iconta {


    void depositar(Double valor) ;

    void sacar(Double valor);

    void transferir(Conta contaDeposito, Double valor);



}
