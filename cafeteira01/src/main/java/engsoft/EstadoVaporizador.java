package engsoft;

class EstadoVaporizador {
    
    // Estados da máquina de estados do vaporizador
    public static final EstadoVaporizador naoFazendo= 
        new EstadoVaporizador(0);
    public static final EstadoVaporizador vaporizando=
        new EstadoVaporizador(1);
    public static final EstadoVaporizador fazendoJarRemovida= 
        new EstadoVaporizador(2);
    
    private int id;
    
    private EstadoVaporizador(int id) {
        this.id = id;
    }
    
    public EstadoVaporizador getEstadoVaporizador() {
    	return this;
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof EstadoVaporizador)
                && ((EstadoVaporizador) obj).id == id;
    }
}

