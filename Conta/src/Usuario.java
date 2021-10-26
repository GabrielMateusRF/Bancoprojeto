import javax.swing.JOptionPane;

public class Usuario {
    public String nome;
    public int numUsuario;
    private String senha="default";
    public int contas[]= new int[10];
    public int numContas=0;
    public int numGerente;
    int i;

    
    public void setNome(String nomedado) {
        nome=nomedado;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNum(int num) {
        numUsuario=num;
    }
    
    public int getNum() {
        return numUsuario;
    }
    
    public void setContas(int numConta){
        contas[numContas]=numConta;
        numContas++;
    }
    
    public int getConta(int numdado){
        for( i=0; i<numContas; i++) {
            if(contas[i]==numdado) {
                return numdado;
            }
        }
        return 99;
    }
    
    public int[] getContas() {
        return contas;
    }
    
    public void setGerente(int gerenteDado) {
        numGerente=gerenteDado;
    }
    
    public int getGerente() {
        return numGerente;
    }
    
    public void alterarSenha (String senhaAntiga, String senhaNova) 
    {
        if(senhaAntiga.equals(senha))
        {
            if(!senha.equals("default")) {
                JOptionPane.showMessageDialog(null, "Senha alterada com socesso!");
            }
            senha=senhaNova;
            
            
        }else
        {
            JOptionPane.showMessageDialog(null, "Senha errada");
        }
    }
    
    public int conferirSenha(String senhadada) {
        if(senha.equals(senhadada)) {
            return 1;
        }else {
            
            return 0;
        }
    }
    
}