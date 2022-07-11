import javax.swing.*;
import java.util.ArrayList;
import java.util.Enumeration;

public abstract class AgenciaBancaria implements Iconta {

    static ArrayList<Conta>contasBancarias;

    public static void main(String[] args) {
        //instanciando conta
        contasBancarias = new ArrayList<Conta>();
        //menu
        operacoes();
    }
    public static void operacoes() {

        //utilizando optionPane
        int operacao =
                Integer.parseInt(JOptionPane.showInputDialog("--------------- Escolha uma opção ---------------\n" +

                  "--- Opção 1 - Criar Conta\n" +
                  "--- Opção 2 - Depositar\n" +
                  "--- Opção 3 - Sacar\n" +
                  "--- Opção 4 - Transferir\n" +
                  "--- Opção 5 - Lista Contas\n" +
                  "--- Opção 6 - Sair"));

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                tranferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Volte sempre cliente DIO TQI");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                operacoes();
                break;
        }
    }

    //metido criacao de conta
    static void criarConta(){
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
        pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
        pessoa.setEmail(JOptionPane.showInputDialog("Email: "));

        Conta conta = new Conta(pessoa);
        conta.setTipoConta(JOptionPane.showInputDialog("Tipo da Conta: "));

        //adicionar a conta
        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
        operacoes();
    }

    /* metodo verifica se conta na base de conta se tiver percorre a lista de conta
    *  se localizar, retorna a conta
    * */
    private static Conta localizarConta(int numeroConta) {
        //inicia com valor null
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            //for verifica para cada conta em array de contas bancarias
            for (Conta c : contasBancarias) {
                //laço verifica se conta digital for igual a conta encontrada
                if(c.getNumeroConta() == numeroConta) {
                    //entao conta recebe c ou seja a conta digitada
                    conta = c;
                }
            }
        }
        //ai retorna a conta
        return conta;
    }

    //Metodo depositar valor
     public static void depositar() {
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito: "));

        //chama metodo localizar conta para verificar se existe
        Conta conta = localizarConta(numeroConta);

        //fazer validaçoes
        if(conta != null) {
            Double valorDeposito =
                    Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do depósito: "));
            //chama metodo depositar e deposita valor
            conta.depositar(valorDeposito);
        }else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
        //chamo metodo para mostra o menu de opções
        operacoes();
    }
    public static void sacar() {
        int numeroConta =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta  para saque: "));

        //chama metodo localizar conta para verificar se existe
        Conta conta = localizarConta(numeroConta);
        //fazer validaçoes
        if(conta != null) {
            Double valorSaque =
                    Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque: "));

            //chama metodo sacar e saca valor
            conta.sacar(valorSaque);
        }else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
        operacoes();
    }
    public static void tranferir() {
        int numeroContaRealizarDebito =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta a ser debitada: "));

        Conta contaRealizarDebito = localizarConta(numeroContaRealizarDebito);
        if(contaRealizarDebito != null) {
            int numeroContaRealizarCredito =
                    Integer.parseInt(JOptionPane.showInputDialog("Digite número da conta a ser creditado valor: "));

            Conta contaRealizarCredito = localizarConta(numeroContaRealizarCredito);
            if (contaRealizarCredito != null) {
                Double valor =
                        Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da transferencia: "));

                contaRealizarDebito.transferir(contaRealizarCredito, valor);
            }else {
                JOptionPane.showMessageDialog(null, "Conta para depósito não localizada!");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Conta de transferencia não localizada!");
        }
        operacoes();
    }
    // metodo listagem de contas bancarias
    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            //para cada conta na lista de conta imprime conta
            for(Conta conta: contasBancarias) {
                JOptionPane.showMessageDialog(null, conta);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não tem contas cadastradas!");
        }
        operacoes();
    }
}
