package co.com.sofka.biblioteca.reactive.usecases;

public class servicios {
    /*
    @Autowired
    RepositorioRecurso repositorioRecurso;
    RecursoMapper mapper = new RecursoMapper();

    public List<RecursoDTO> obtenerTodos() {
        List<Recurso> recursos = (List<Recurso>) repositorioRecurso.findAll();
        return mapper.fromCollectionList(recursos);
    }
    public RecursoDTO obtenerPorId(String id) {
        Recurso recurso = repositorioRecurso.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(recurso);
    }
    public RecursoDTO crear(RecursoDTO recursoDTO) {
        if (sonVacios(recursoDTO)) {
            throw new IllegalArgumentException("Los datos no pueden estar vacios");
        }
        Recurso recurso = mapper.fromDTO(recursoDTO);
        return mapper.fromCollection(repositorioRecurso.save(recurso));
    }
    private boolean sonVacios(RecursoDTO recursoDTO){
        if (recursoDTO.getName().isEmpty() || recursoDTO.getThematic().isEmpty() || recursoDTO.getType().isEmpty()) {
            return true;
        }
        return false;
    }
    public RecursoDTO modificar(RecursoDTO recursoDTO) {
        Recurso recurso = mapper.fromDTO(recursoDTO);
        repositorioRecurso.findById(recurso.getId()).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(repositorioRecurso.save(recurso));
    }
    public void borrar(String id) {
        repositorioRecurso.deleteById(id);
    }

    public String availability(String id){
        Recurso recurso = repositorioRecurso.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        if (recurso.isAvailable()) {
            return "El recurso " + recurso.getName() + " se encuentra disponible";
        }
        return "El recurso " + recurso.getName() + " no se encuentra disponible";
    }

    public String loanApplication(String id){
        Recurso recurso = repositorioRecurso.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        if (recurso.isAvailable()) {
            recurso.setAvailable(false);
            recurso.setDate(LocalDate.now());
            RecursoDTO recursoDTO = mapper.fromCollection(recurso);
            modificar(recursoDTO);
            return "El recurso " + recursoDTO.getName() + " se ha prestado";
        }
        return "el recurso " + recurso.getName() + " no tiene derechos para prestamo";
    }

    public String returnRequest(String id){
        Recurso recurso = repositorioRecurso.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        if (!recurso.isAvailable()) {
            recurso.setAvailable(true);
            LocalDate date = LocalDate.of(9999, 12, 31);
            recurso.setDate(date);
            RecursoDTO recursoDTO = mapper.fromCollection(recurso);
            modificar(recursoDTO);
            return "El recurso " + recursoDTO.getName() + " se ha devuelto";
        }
        return "El recurso " + recurso.getName() + " no se pudo devolver";
    }

    public List<RecursoDTO> recommendTheme(String theme) {
        //List<Recurso> recursos = (List<Recurso>) repositorioRecurso.findAll();
        List<RecursoDTO> recursoDTOS = new ArrayList<>();
        repositorioRecurso.findByThematic(theme).forEach(recurso -> recursoDTOS.add(mapper.fromCollection(recurso)));
        return recursoDTOS;
    }

    public List<RecursoDTO> recommendType(String type) {
        //List<Recurso> recursos = (List<Recurso>) repositorioRecurso.findAll();
        List<RecursoDTO> recursoDTOS = new ArrayList<>();
        repositorioRecurso.findByType(type).forEach(recurso -> recursoDTOS.add(mapper.fromCollection(recurso)));
        return recursoDTOS;
    }
     */
}
