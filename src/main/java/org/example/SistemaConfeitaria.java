package org.example;

public interface SistemaConfeitaria {
    public void cadastrarSobremesas(String nome, String preco);
    public void cadastrarSalgados(String nome, String preco);
    public void cadastrarBebidas(String nome, String preco);

    void cadastrarSobremesas(String nomeSobremesas, double precoSobremesas) throws SobremesasJaCadastradasException;

    void cadastrarSalgados(String nomeSalgados, double precoSalgados) throws SalgadosJaCadastradosException;

    void cadastrarBebidas(String nomeBebidas, double precoBebidas) throws BebidasJacadastradasException;
}
