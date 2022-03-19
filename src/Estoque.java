import Model.Bebida;
import Model.Produto;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/* Projeto Interdisciplinar - Grupo 01 

- André V Sena dos Anjos       - RGM: 25836048

- Bruno Sergio da Silva        - RGM  25549120

- Guilherme Jujeque Carnavalli - RGM: 25934945

- João Vitor Barbosa           - RGM: 21343322

- Juan Victor de Souza Silva   - RGM: 26418177

- Marcelo Stoianov Rinco       - RGM: 26650967
*/
public class Estoque {

    /**
     * Controle de Estoque
     * @param args
     */
    public static void main(String[] args) {
        int menu;
        Produto prod;
        do{
            //menu principal do programa
            menu =    Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a oppção "
                                + "\n1 - Cadastrar Produto: "
                                + "\n2 - Consultar Produto: "
                                + "\n3 - Listar Produto: "
                                + "\n4 - Alterar Produto: "                                 
                                + "\n5 - Deletar Produto: " 
                                + "\n6 - Sair"));//passando para variavel a entrada do usuario 
            
            switch(menu){// verificando entrada de Menu
                case 1:
                //cadastro dos produtos
                    //Pegando atributos da Bebida
                    String nome = JOptionPane.showInputDialog("Digite o nome da bebida : ");
                    String tipo = JOptionPane.showInputDialog("Digite o tipo da bebida : ");
                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade : "));
                    float valor = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor Unitário R$ : "));
                    //instanciando uma nova Bebida com parâmetros 
                    Bebida bebida = new Bebida(nome, tipo, quantidade, valor);
                    //cadastrando bebida
                    bebida.cadastrar(bebida);
                    break;   
                                    
                case 2:
                    //consultar os produtos
                      int con = parseInt(JOptionPane.showInputDialog(null,"Digite o ID do produto: "));//Id da entrada do usuario 
                      for(int i = 0; i<= Produto.produtos.size() -1 ; i++ ) //fazendo um loop na lista de Produto                                       
                    {
                        int idCon = Produto.produtos.get(i).getId();//Id do Produto da lista
                        if(con == idCon){//Se id Digitado pelo usuario FOR IGUAL ao id do produto da lista
                            String strProd = Produto.produtos.get(i).formatoString();//string retorno na variavel
                            JOptionPane.showMessageDialog(null, strProd);//mostar produto conforme id digitado
                            break;//Parar for 
                        }
                    }
                    break;
                
                case 3:
                     //listar produto
                    String imprimir = "";
                    for(int i = 0; i<= Produto.produtos.size() -1 ; i++ )//Loop na minha lista
                    imprimir += Produto.produtos.get(i).formatoSystemOut(); //Adiciona o Produto na string "imprimir" ja existente 
                    System.out.println(imprimir);//Escreve a string "imprimir"        
                        
                    break; 
                                                   
                case 4:
                    //alterar os produtos  
                     Produto prodd;
                        int update = parseInt(JOptionPane.showInputDialog(null,"Digite o ID do produto que deseja alterar: "));//Id de entrada de usuario
                        for(int i = 0; i<= Produto.produtos.size() -1 ; i++ )//Loop na lista de Produtos                                      
                    {
                        int idUpdate = Produto.produtos.get(i).getId();
                        if(update == idUpdate){//Se id Digitado pelo usuario FOR IGUAL ao id do produto da lista
                           int tipoAlt = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja alterar "
                                   + "\n1 - Nome"
                                   + "\n2 - Tipo"
                                   + "\n3 - Valor Unitário R$"));//passando para a variavel a entrada do usuario
                           switch(tipoAlt){//verificando entrada de submenu
                                case 1:
                                   String newNome = JOptionPane.showInputDialog(null, "Digite o novo nome: ");//Entrada de dados, novo nome
                                   prodd = Produto.produtos.get(i);//pegando Produto
                                   prodd.setNome(newNome);//setando novo nome no Produto
                                   break;
                                case 2:
                                    String newTipo = JOptionPane.showInputDialog(null, "Digite o novo tipo: ");//Entrada de dados, novo tipo
                                    prodd = Produto.produtos.get(i);//pegando Produto
                                    prodd.setTipo(newTipo);//setando novo tipo no Produto
                                    break;
                                case 3:
                                    float newValor = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a novo valor: "));//entrada de dadoos nova Quantidade
                                    prodd = Produto.produtos.get(i);
                                    prodd.setValor(newValor);
                                    break;
                           }
                                    
                        }
                    }break; 
                   
                case 5:
                    //deletar produto
                    int Delete = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o id do que deseja excluir: "));//Id de entrada de usuario
                    int menuDelete = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a opção: "
                                                                                            + "\n1 - Deletar Tudo"
                                                                                            + "\n2 - Deletar Quantidade Especifica"));//entrada de usuario do submenu
                     switch(menuDelete){//verificando entrada de submenu
                         case 1:
                                for(int i = 0 ; i<= Produto.produtos.size() -1 ; i++){//Loop na listade Produtos
                                int idDelete = Produto.produtos.get(i).getId();//id do Produto na lista
                                if(Delete == idDelete){//Se id Digitado pelo usuario FOR IGUAL ao id do produto da lista
                                    Produto.produtos.remove(i);//Deleta todo o objeto Produto da lista 
                                }
                                
                        }break;
                         case 2 :
                             int qtd = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a quatidade que deseja deletar: "));//Entrada de usuario, qtd a deletar
                             for(int i = 0 ; i<= Produto.produtos.size() -1 ; i++){//Loop na lista de Produtos
                                 int idDelete = Produto.produtos.get(i).getId();//id do Produto na lista
                                 if(Delete == idDelete){//Se id Digitado pelo usuario FOR IGUAL ao id do produto da lista
                                     int qtdAtual = Produto.produtos.get(i).getQuantidade();//pegando quantidade do Produto da lista
                                     if(qtdAtual < qtd ){//SE qtde digitada FOR MAIOR que a atual
                                         JOptionPane.showMessageDialog(null,"Digite uma quantidade menor do que a cadastrada");
                                     }
                                     else{
                                         prod = Produto.produtos.get(i);//passa produto da lista para variavel
                                         prod.setQuantidade(qtdAtual + (qtd*(-1)));//seta uma nova quantidade
                                     }
                                 }
                             }
                 }
                   
                                      
                default:
                //sair
                  break;   
            }     
        }while(menu!=6);//quando for == 6 fecha programa
    }
}
    

