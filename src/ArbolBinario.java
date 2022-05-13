
public class ArbolBinario {

    NodoBinario RAIZ;

    public ArbolBinario() {
        RAIZ = null;
    }

    public boolean yaExiste(int dato) {
        //codigo de recorrido
        //se evalua si ya existe y se regresa TRUE
        return false;
    }

    public boolean insertar(int dato) {
        //si ya existe nodo con dato ya capturado
        if (yaExiste(dato)) {
            return false;
        }

        NodoBinario NUEVO = new NodoBinario(dato);
        if (NUEVO == null) {
            return false;
        }

        if (hayArbolBinarioVacio()) {
            RAIZ = NUEVO;
            return true;
        }
        
        if (dato < RAIZ.dato) {
            //izquierda del arbol binario
            if (RAIZ.izq == null) {// esta desocupado hijo izq?
                RAIZ.izq = NUEVO;
                return true;
            } else {
                //no esta desocupado, buscare hacia abajo
                return enlace(RAIZ.izq, NUEVO);
            }
        } else {//izquierda del arbol binario
            //derecha del arbol binario
            if (RAIZ.der == null) {// esta desocupado hijo izq?
                RAIZ.der = NUEVO;
                return true;
            } else {
                //no esta desocupado, buscare hacia abajo
                return enlace(RAIZ.der, NUEVO);
            }
        }//derecha del arbol bincario
    }

    private boolean enlace(NodoBinario padre, NodoBinario NUEVO){
        if(padre == null) return false;
        if(NUEVO.dato < padre.dato){
            //parte izquierda de padre
            if(padre.izq == null){
                padre.izq = NUEVO;
                return true;
            }else{
                return enlace(padre.izq, NUEVO);
            }//izquieda del nodo
        } else {
            //parte derecha de padre
            if(padre.der == null){
                padre.der = NUEVO;
                return true;
            }else{
                return enlace(padre.der, NUEVO);
            }
        }//derecha del nodo
    }
    
    //Recorrido inorden: izq->raiz->der
    public String inorden(){
        return inorden(RAIZ);
    }
    
    private String inorden(NodoBinario padre){
        if(padre == null) return "";
        return inorden(padre.izq)+"-"+padre.dato+"-"+inorden(padre.der);
    }
    
    //Recorrido preorden: raiz->izq->der
    public String preorden(){
        return preorden(RAIZ);
    }
    
    private String preorden(NodoBinario padre){
        if(padre == null) return "";
        return padre.dato +"-"+preorden(padre.izq)+"-"+preorden(padre.der);
    }
    
    //Recorrido posorden: izq->raiz->der
    public String posorden(){
        return posorden(RAIZ);
    }
    
    private String posorden(NodoBinario padre){
        if(padre == null) return "";
        return padre.dato +"-"+posorden(padre.der)+"-"+posorden(padre.izq);
    }
    //metodos de estado
    private boolean hayArbolBinarioVacio() {
        return RAIZ == null;
    }
}
