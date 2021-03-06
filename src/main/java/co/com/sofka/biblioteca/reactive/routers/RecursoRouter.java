package co.com.sofka.biblioteca.reactive.routers;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RecursoRouter {
    /*
    *     @Autowired
    ServicioRecurso servicioRecurso;

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> findbyId(@PathVariable("id") String id) {
        try {
            return new ResponseEntity(servicioRecurso.obtenerPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity("Recurso no esta",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<RecursoDTO>> findAll() {
        return new ResponseEntity(servicioRecurso.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<RecursoDTO> create(@RequestBody RecursoDTO recursoDTO) {
        return new ResponseEntity(servicioRecurso.crear(recursoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<RecursoDTO> update(@RequestBody RecursoDTO recursoDTO) {
        if (recursoDTO.getId() != null) {
            return new ResponseEntity(servicioRecurso.modificar(recursoDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            servicioRecurso.borrar(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity("Recurso no esta",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/disponible/{id}")
    public ResponseEntity findAvailable(@PathVariable("id") String id) {
        return new ResponseEntity(servicioRecurso.availability(id), HttpStatus.OK);
    }

    @PutMapping("/prestar/{id}")
    public ResponseEntity loanApplication(@PathVariable("id") String id) {
        return new ResponseEntity(servicioRecurso.loanApplication(id), HttpStatus.OK);
    }

    @PutMapping("/devolver/{id}")
    public ResponseEntity returnRequest(@PathVariable("id") String id) {
        return new ResponseEntity(servicioRecurso.returnRequest(id), HttpStatus.OK);
    }

    @GetMapping("/recomendar/{thematic}")
    public ResponseEntity<RecursoDTO> recommendation(@PathVariable("thematic") String thematic){
        if(thematic.equals("")){
            return new ResponseEntity("Tema no existe ",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(servicioRecurso.recommendTheme(thematic),HttpStatus.OK);
    }

    @GetMapping("/recomendarTipo/{type}")
    public ResponseEntity<RecursoDTO> recommendationByType(@PathVariable("type") String type){
        if(type.equals("")){
            return new ResponseEntity("El tipo no existe ",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(servicioRecurso.recommendType(type),HttpStatus.OK);
    }*/
}
