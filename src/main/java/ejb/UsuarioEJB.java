
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
        
    
    
}
