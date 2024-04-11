package org.example;

import javax.swing.*;

import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

public class SistemaConfeitariaMain {
    public static void main(String[] args) throws SobremesasJaCadastradasException {
        RegistroConfeitaria sistema = new RegistroConfeitaria();


        boolean continuar = true;
        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null,
                    "Digite escolha uma opção:\n1.Cadastrar Sobremesa\n2.Cadastrar Salgados" +
                            "\n3.Cadastrar Bebidas\n4.Pesquisar Sobremesas\n5.Pesquisar Salgados\n6.Pesquisar Bebidas" +
                            "\n7.Remover Sobremesas\n8.Remover Salgados\n9.Remover Bebidas\n10.Listar Sobremesas" +
                            "\n11.Listar Salgados\n12.Listar Bebidas\n13.Salvar\n14.Sair",
                    "Seja Bem Vindo", DEFAULT_OPTION);

            if (opcao.equals("1")) {
                String nomeDaSobremesa = JOptionPane.showInputDialog(null,
                        "Insira o nome da Sobremesa: ", "Cadastrar Sobremesa", DEFAULT_OPTION);
                double precoDaSobremesa = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Insira o preço da sobremesa: ", "Cadastrar Sobremesa", DEFAULT_OPTION));
                sistema.cadastrarSobremesas(nomeDaSobremesa, precoDaSobremesa);
            }else if (opcao.equals("2")){
                String nomeDoSalgado = JOptionPane.showInputDialog(null,
                        "Insira o nome do Salgado: ","Cadastrar Salgados", DEFAULT_OPTION);
                double precoDoSalgado = Double.parseDouble(JOptionPane.showInputDialog("Insira o preço do Salgado: "));
                try {
                    sistema.cadastrarSalgados(nomeDoSalgado, precoDoSalgado);
                } catch (SalgadosJaCadastradosException e) {
                    JOptionPane.showMessageDialog(null,
                            "Não foi possivel cadastrar, verifique se o salgado já não está cadastrado.");
                    throw new RuntimeException(e);
                }
            }else if (opcao.equals("3")) {
                String nomeDaBebida = JOptionPane.showInputDialog(null,
                        "Insira o nome da Bebida: ", "Cadastrar Bebida", DEFAULT_OPTION);
                double precoDaBebida = Double.parseDouble(JOptionPane.showInputDialog(
                        "Insira o preço da Bebida: "));
                try {
                    sistema.cadastrarBebidas(nomeDaBebida, precoDaBebida);
                } catch (BebidasJacadastradasException e) {
                    JOptionPane.showMessageDialog(null,
                            "Não foi possivel cadastrar, verifique se a bebida já não está cadastarda.");
                    throw new RuntimeException(e);
                }
            }else if (opcao.equals("4")){
                ArrayList<Cardapio>  ResultadoDaBuscaSobremesa = new ArrayList<>();
                String nomeDaSobremesa = JOptionPane.showInputDialog(null,
                        "Insira o nome da Sobremesa: ", "Pesquisar Sobremesa", DEFAULT_OPTION);
                ResultadoDaBuscaSobremesa = sistema.pesquisaSobremesasCadastradas(nomeDaSobremesa);
                for (Cardapio c : ResultadoDaBuscaSobremesa) {
                    JOptionPane.showMessageDialog(null, "Sobremesa:"+c.getNomeSobremesa()+"\nPreço: "+c.getPrecoSobremesa());
                }

            }else if (opcao.equals("5")){
                ArrayList<Cardapio> ResultadoDaBuscaSalgado = new ArrayList<>();
                String nomeDoSalgado = JOptionPane.showInputDialog(null, "Insira o nome do salgado: ",
                        "Pesquisar Salgado", DEFAULT_OPTION);
                ResultadoDaBuscaSalgado = sistema.pesquisaSalgadosCadastrados(nomeDoSalgado);
                for (Cardapio c : ResultadoDaBuscaSalgado) {
                    JOptionPane.showMessageDialog(null, "Salgado: "+"\nPreço: "+c.getPrecoSalgado());
                }
            }else if (opcao.equals("6")) {
                ArrayList<Cardapio> ResultadoDaBuscaBebidas = new ArrayList<>();
                String nomeDaBebida = JOptionPane.showInputDialog(null, "Insira o nome da bebida: ",
                        "Pesquisar bebiba", DEFAULT_OPTION);
                ResultadoDaBuscaBebidas = sistema.pesquisaBebidasCadastradas(nomeDaBebida);
                for (Cardapio c : ResultadoDaBuscaBebidas) {
                    JOptionPane.showMessageDialog(null, "Bebida: "+"\nPreço"+c.getPrecoBebida());
                }
            }else if(opcao.equals("7")) {
                String nomeDaSobremesa = JOptionPane.showInputDialog(null,
                        "Insira o nome da sobremesa: ", "Remoção da sobremesa", DEFAULT_OPTION);
                try {
                    sistema.removerSobremesas(nomeDaSobremesa);
                    JOptionPane.showMessageDialog(null, "Informações sobre a sobremesa foram removidas com sucesso.");
                } catch (SobremesasNaoCadastradasException e) {
                    JOptionPane.showMessageDialog(null, "Informações sobre a sobremesa não foram cadastradas no sistema.");
                    e.printStackTrace();
                }
            } else if (opcao.equals("8")){
                String nomeDoSalgado = JOptionPane.showInputDialog(null,
                        "Insira o nome do salgado: ", "Remoção do salgado", DEFAULT_OPTION);
                try {
                    sistema.removerSalgados(nomeDoSalgado);
                    JOptionPane.showMessageDialog(null, "Informações sobre o salgado foram removidas com sucesso.");
                } catch (SalgadosNaoCadastradosException e) {
                    JOptionPane.showMessageDialog(null, "Informações sobre o salgado não foram cadastradas no sistema.");
                    e.printStackTrace();
                }
            } else if (opcao.equals("9")) {
                String nomeDaBebida = JOptionPane.showInputDialog(null,
                        "Insira o nome da bebida: ", "Remoção da bebida", DEFAULT_OPTION);
                try {
                    sistema.removerBebidas(nomeDaBebida);
                    JOptionPane.showMessageDialog(null, "Informações sobre a bebida foram removidas com sucesso.");
                } catch (BebidasNaoCadastradasException | SalgadosNaoCadastradosException e) {
                    JOptionPane.showMessageDialog(null, "Informações sobre a bebida não foram cadastradas no sistema.");
                    e.printStackTrace();
                }
            } else if (opcao.equals("10")) {
                String lista = String.valueOf(((RegistroConfeitaria)sistema).getSobremesas());
                JOptionPane.showMessageDialog(null,lista,"10.Lista de Sobremesas: ",
                        Integer.parseInt(String.valueOf(DEFAULT_OPTION)));
            } else if (opcao.equals("11")) {
                String lista = String.valueOf(((RegistroConfeitaria)sistema).getSalgados());
                JOptionPane.showMessageDialog(null, lista,"11.Lista de Salgados: ",
                        Integer.parseInt(String.valueOf(DEFAULT_OPTION)));
            } else if (opcao.equals("12")) {
                String lista = String.valueOf(((RegistroConfeitaria)sistema).getBebidas());
                JOptionPane.showMessageDialog(null,lista,"12.Lista de Bebidas: ",
                        Integer.parseInt(String.valueOf(DEFAULT_OPTION)));
            } else if (opcao.equals("13")) {
                JOptionPane.showMessageDialog(null, "Volte Sempre","", DEFAULT_OPTION);
                continuar = false;
            }
        }
    }

    private static void salvarDados(RegistroConfeitaria sistema) {
    }
}