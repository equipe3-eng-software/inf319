package engsoft;

class EstadoIHC {
    
    // Estados da máquina de estados da IHC
    public static final EstadoIHC naoFazendo=           new EstadoIHC(0); 
    public static final EstadoIHC fazendo=              new EstadoIHC(1); 
    public static final EstadoIHC verificandoProntidao= new EstadoIHC(2); 
    public static final EstadoIHC cafeFeito=            new EstadoIHC(3);
    
    private int id;

    private EstadoIHC(int id) {
        this.id = id;
    }
    
    public EstadoIHC getEstadoIHC() {
    	return this;
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof EstadoIHC)
                && ((EstadoIHC) obj).id == id;
    }
}

