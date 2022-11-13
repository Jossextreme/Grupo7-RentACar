
package grupo7.rentacar;

/**
 *
 * @author Yoselyn Suarez Molina
 */

public class Extras {
    private boolean arranqueSinLlave;
    private boolean conectividadCargador;
    private boolean navegador;
    private boolean sensores;
    private boolean camaraTrasera; 

    public boolean isArranqueSinLlave() {
        return arranqueSinLlave;
    }

    public void setArranqueSinLlave(boolean arranqueSinLlave) {
        this.arranqueSinLlave = arranqueSinLlave;
    }

    public boolean isConectividadCargador() {
        return conectividadCargador;
    }

    public void setConectividadCargador(boolean conectividadCargador) {
        this.conectividadCargador = conectividadCargador;
    }

    public boolean isNavegador() {
        return navegador;
    }

    public void setNavegador(boolean navegador) {
        this.navegador = navegador;
    }

    public boolean isSensores() {
        return sensores;
    }

    public void setSensores(boolean sensores) {
        this.sensores = sensores;
    }

    public boolean isCamaraTrasera() {
        return camaraTrasera;
    }

    public void setCamaraTrasera(boolean camaraTrasera) {
        this.camaraTrasera = camaraTrasera;
    }
    
    
}
