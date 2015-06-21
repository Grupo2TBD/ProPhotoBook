
package ejb;

/**
 *
 * @author ian
 */

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import facade.UsuarioEJBFacade;
import model.Usuario;

@Stateless  
public class UsuarioEJB implements UsuarioEJBLocal{

    @EJB
    UsuarioEJBFacade userFacade;
    
    public UsuarioEJB(){
    
    }
    
    @Override
    public List<Usuario> get() {
		
	return this.userFacade.findAll();
    }
        
    @Override 
    public Usuario test(){
        return this.userFacade.find(1);
    }
    
    @Override
    public Usuario Login(String mail, String pass){
        List <Usuario> list = this.userFacade.findAll();
            int largo=list.size();
            int contador=0;
            while(largo!=0){
                if(mail.equals(list.get(contador).getCorreoElectronicoUsuario()) && pass.equals(list.get(contador).getContrasenaUsuario())){
                    return list.get(contador);
                }
                contador++;
                largo--;
            }
            Usuario  aux=new Usuario();
            return aux;
                
        
        
    }
}
