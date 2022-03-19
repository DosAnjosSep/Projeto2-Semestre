/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/* Projeto Interdisciplinar - Grupo 01 
- André V Sena dos Anjos       - RGM: 25836048

- Bruno Sergio da Silva        - RGM  25549120

- Guilherme Jujeque Carnavalli - RGM: 25934945

- João Vitor Barbosa           - RGM: 21343322

- Juan Victor de Souza Silva   - RGM: 26418177

- Marcelo Stoianov Rinco       - RGM: 26650967
*/
public abstract class Produto implements Imprimivel{
    public static int contadorId = 0;/* mantem a variável instanciada durante todo o projeto 
                                                    mantendo assim o valor do contador íntegro*/
    private int id; //id para alteração e identificação do produto 
    private String nome;
    private String tipo;// qual o tipo da bebida ex: cerveja, whisky, vodka, vinho.
    private int quantidade; 
    private float valor;// 
    
    
    public static ArrayList<Produto> produtos = new ArrayList<Produto>();//Lista que armazena os Produtos
    
    abstract void cadastrar(Produto produto);//metodo cadastrar

    public Produto(String nome, String tipo, int quantidade, float valor) {// construtor
        contadorId++;//Id tem o valor sempre crescente cada vez que adiciona um novo produto certo
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.id = contadorId;
    }
    //metodos de acesso
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String formatoString() {//sobrescrevendo metodo da classe "Imprimivel"
        return NLIN + "\nId: " + id + "\nNome: " + nome + "\nTipo: " + tipo +
                 "\nQuantidade: " + quantidade + "\nValor Unitário R$: " + valor;
    }
    
    
    
}
