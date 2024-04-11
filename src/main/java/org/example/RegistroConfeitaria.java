package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class RegistroConfeitaria implements SistemaConfeitaria {
    private ArrayList<Cardapio> sobremesas;
    private ArrayList<Cardapio> salgados;
    private ArrayList<Cardapio> bebidas;

    public RegistroConfeitaria() {
        this.sobremesas = new ArrayList<>();
        this.salgados = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }


    @Override
    public void cadastrarSobremesas(String nome, String preco) {

    }

    @Override
    public void cadastrarSalgados(String nome, String preco) {

    }

    @Override
    public void cadastrarBebidas(String nome, String preco) {

    }

    @Override
    public void cadastrarSobremesas(String nomeSobremesa, double precoSobremesa) throws SobremesasJaCadastradasException {
        ArrayList<String> sobremesa = new ArrayList<>();
        Cardapio s = new Cardapio(nomeSobremesa, precoSobremesa);
        if(this.sobremesas.contains(s)){
            throw new SobremesasJaCadastradasException(
                    "Não foi possível cadastrar. Veja se a sobremesa já existe.");
        } else {
            this.sobremesas.add(s);
            JOptionPane.showMessageDialog(null,
                    "cadastro feito com sucesso");
        }

    }

    @Override
    public void cadastrarSalgados(String nomeSalgados, double precoSalgados) throws SalgadosJaCadastradosException {
        ArrayList<String> salgado = new ArrayList<>();
        Cardapio a = new Cardapio(nomeSalgados, precoSalgados);
        if (this.salgados.contains(a)){
            throw new SalgadosJaCadastradosException("Não foi possível cadastrar. Veja se o salgado já existe.");
        } else {
            this.salgados.add(a);
            JOptionPane.showMessageDialog(null,
                    "Cadastro feito com sucesso");
        }
    }

    @Override
    public void cadastrarBebidas(String nomeBebidas, double precoBebidas) throws BebidasJacadastradasException {
        ArrayList<String> salgado = new ArrayList<>();
        Cardapio b = new Cardapio(nomeBebidas, precoBebidas);
        if (this.salgados.contains(b)){
            throw new BebidasJacadastradasException("Não foi possível cadastrar. Veja se o salgado já existe.");
        } else {
            this.bebidas.add(b);
            JOptionPane.showMessageDialog(null,
                    "Cadastro feito com sucesso");
        }
    }




    public ArrayList<Cardapio> pesquisaSobremesasCadastradas (String nomeSobremesas) {
        ArrayList<Cardapio> ResultadoDaBusca = new ArrayList<>();
        for (Cardapio c : sobremesas) {
            if (c.getNomeSobremesa().equals(nomeSobremesas)) {
                ResultadoDaBusca.add(c);
            }
        }
        return ResultadoDaBusca;
    }

    public ArrayList<Cardapio> pesquisaSalgadosCadastrados(String nomeSalgados) {
        ArrayList<Cardapio> ResultadoDaBusca = new ArrayList<>();
        for (Cardapio c : salgados) {
            if (c.getNomeSalgado().equals(nomeSalgados)){
                ResultadoDaBusca.add(c);
            }
        }
        return ResultadoDaBusca;
    }

    public ArrayList<Cardapio> pesquisaBebidasCadastradas(String nomeBebidas) {
        ArrayList<Cardapio> ResultadoDaBusca = new ArrayList<>();
        for (Cardapio c : bebidas) {
            if (c.getNomeBebida().equals(nomeBebidas)){
                ResultadoDaBusca.add(c);
            }
        }
        return ResultadoDaBusca;
    }

    public void removerSobremesas(String nomeSobremesas) throws SobremesasNaoCadastradasException {
        for(Cardapio c : sobremesas){
            if(c.getNomeSobremesa().equals(nomeSobremesas)){
                sobremesas.remove(c);
            }else {
                throw new SobremesasNaoCadastradasException("A sobremesa não foi cadastrada no sistema.");
            }
        }
    }
    public void removerSalgados (String nomeSalgados) throws SalgadosNaoCadastradosException {
        for (Cardapio c : salgados) {
            if(c.getNomeSalgado().equals(nomeSalgados)) {
                salgados.remove(c);
            }else {
                throw new SalgadosNaoCadastradosException("O salgado não foi cadastrado no sistema.");
            }
        }
    }
    public void removerBebidas (String nomeBebidas) throws SalgadosNaoCadastradosException, BebidasNaoCadastradasException {
        for (Cardapio c : salgados) {
            if (c.getNomeBebida().equals(nomeBebidas)) {
                bebidas.remove(c);
            }else {
                throw new BebidasNaoCadastradasException("A bebida não foi cadastrada no sistema.");
            }
        }
    }

    public ArrayList<Cardapio> getSobremesas() {
        return sobremesas;
    }

    public void setSobremesas(ArrayList<Cardapio> sobremesas) {
        this.sobremesas = sobremesas;
    }

    public ArrayList<Cardapio> getSalgados() {
        return salgados;
    }

    public void setSalgados(ArrayList<Cardapio> salgados) {
        this.salgados = salgados;
    }

    public ArrayList<Cardapio> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Cardapio> bebidas) {
        this.bebidas = bebidas;
    }

}