package engsoft;

class EstadoAquecedor {
    
    // Estados da máquina de estados do aquecedor
    public static final EstadoAquecedor naoAquecendo    =new EstadoAquecedor(0); 
    public static final EstadoAquecedor fazendoJarVazia =new EstadoAquecedor(1); 
    public static final EstadoAquecedor fazendoAquecendo=new EstadoAquecedor(2); 
    public static final EstadoAquecedor jarVaziaRemovida=new EstadoAquecedor(3);
    public static final EstadoAquecedor jarCheiaRemovida=new EstadoAquecedor(4); 
    public static final EstadoAquecedor cafeFeito=       new EstadoAquecedor(5); 
    public static final EstadoAquecedor feitoJarRemovida=new EstadoAquecedor(6); 
    
    private int id;
    
    public EstadoAquecedor() {
    }
        
    private EstadoAquecedor(int id) {
        this.id = id;
    }
    
    public EstadoAquecedor getEstadoAquecedor() {
    	return this;
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof EstadoAquecedor)
                && ((EstadoAquecedor) obj).id == id;
    }
}
