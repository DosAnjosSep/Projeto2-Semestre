/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/* Projeto Interdisciplinar - Grupo 01 
- André V Sena dos Anjos       - RGM: 25836048

- Bruno Sergio da Silva        - RGM  25549120

- Guilherme Jujeque Carnavalli - RGM: 25934945

- João Vitor Barbosa           - RGM: 21343322

- Juan Victor de Souza Silva   - RGM: 26418177

- Marcelo Stoianov Rinco       - RGM: 26650967
*/
public class Bebida extends Produto implements Imprimivel{
     
    public Bebida(String nome, String tipo, int quantidade, float valor) {
        super(nome, tipo, quantidade, valor);
    }
    
    
    @Override
    public String formatoSystemOut() {
        return NLIN + "Bebida{ " + "ID: " + super.getId() + " Nome: " + super.getNome() + 
                        " Tipo: " + super.getTipo() + " Quantidade: " + super.getQuantidade() + 
                                                        " Valor Unitário R$: " + super.getValor() + '}';
    }
    
    @Override
    public void cadastrar(Produto produto) {
        super.setProdutos(produto);
    }    
    
    
    
}
   

