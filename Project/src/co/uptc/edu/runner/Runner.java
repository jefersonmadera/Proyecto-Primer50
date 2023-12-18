package co.uptc.edu.runner;

import co.uptc.edu.controller.AccesControl;
import co.uptc.edu.controller.AlbumControl;
import co.uptc.edu.controller.ArtistaControl;
import co.uptc.edu.controller.BandaControl;
import co.uptc.edu.controller.CancionControl;
import co.uptc.edu.controller.ColeccionistaControl;
import co.uptc.edu.controller.ComentariosControl;
import co.uptc.edu.model.Album;
import co.uptc.edu.model.Artista;
import co.uptc.edu.model.Banda;
import co.uptc.edu.model.Cancion;
import co.uptc.edu.model.Colector;
import co.uptc.edu.model.Comentario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        //esta en sincronizacion
        Scanner scanner = new Scanner(System.in);
        AlbumControl albumControl = new AlbumControl();
        ArtistaControl artistaControl = new ArtistaControl();
        ColeccionistaControl coleccionistaControl = new ColeccionistaControl();
        // List<Album> listaAlbumes = albumControl.getAlbums();
        //ArrayList<Album> listaAlbumesControl = new ArrayList<>(listaAlbumes);
        ComentariosControl comentariosControl = new ComentariosControl();
        ArrayList<Album> listaAlbumes = albumControl.getAlbums();
        ArrayList<Colector> listaColeccionistas = coleccionistaControl.obtenerListaColeccionistas();
        AccesControl accesControl = new AccesControl();
        CancionControl cancionControl = new CancionControl();
        BandaControl bandaControl = new BandaControl();

        int opcion;
        boolean inicioSesion = false;
        do {
            System.out.println("Bienvenido a la aplicación de música.");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // verificar si hay usuarios registrados
                    if (accesControl.getUsuarios().isEmpty()) {
                        System.out.println(
                                "►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►"
                        );
                        System.out.println(
                                "No hay usuarios registrados. (Intente nuevamente)"
                        );
                        System.out.println(
                                "►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►"
                        );
                        break;
                    }
                    // Lógica para iniciar sesión

                    System.out.println("Ingrese el nombre de usuario: ");
                    String nombreUsuario = scanner.next();
                    System.out.println("Ingrese la contraseña: ");
                    String contrasena = scanner.next();

                    if (accesControl.iniciarSesion(nombreUsuario, contrasena)) {
                        System.out.println("Inicio de sesión exitoso.");
                        inicioSesion = true;
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                    break;

                case 2:
                    // Lógica para registrarse
                    String nombreUsuarioRegistro;
                    do {
                        System.out.println("Ingrese el nombre de usuario:");
                        nombreUsuarioRegistro = scanner.nextLine(); // Utilice nextLine() para obtener la línea completa de entrada
                        if (nombreUsuarioRegistro.trim().isEmpty()) {
                            System.out.println(
                                    "¡Error! El nombre de usuario no puede estar vacío."
                            );
                        }
                    } while (nombreUsuarioRegistro.trim().isEmpty());
                    //Validacion para la contraseña
                    do {
                        System.out.println("Ingrese la contraseña (La contraseña debe tener por lo menos una mayuscula una minucuala y 8 caracteres): ");
                        String contrasenaRegistro = scanner.nextLine();

                        if (accesControl.registrarUsuario(nombreUsuarioRegistro, contrasenaRegistro)) {
                            System.out.println("►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►");
                            System.out.println("Registro exitoso.");
                            break;
                        } else {
                            System.out.println("Error en contraseña. Intentelo nuevamente");
                        }
                    } while (true);

                case 0:
                    System.out.println("►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (inicioSesion != true);

        do {
            System.out.println("Menú:");
            System.out.println("1. Álbumes");
            System.out.println("2. Artistas");
            System.out.println("3. Coleccionista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Llamar a métodos de control de álbumes
                    System.out.println("1. Añadir Álbum");
                    System.out.println("2. Mostrar Lista de Álbumes");
                    System.out.println("3. Eliminar Álbum");
                    System.out.println("4. Comentar Álbum");
                    System.out.println("5. Menu Canciones");
                    System.out.println("0. Volver al Menú Principal");

                    int opcionAlbum = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea pendiente

                    switch (opcionAlbum) {
                        case 1:
                            // Lógica para añadir álbum
                            System.out.println("Ingrese los datos del álbum:");

                            // Consumir la nueva línea pendiente para evitar problemas de lectura

                            System.out.print("Nombre del álbum: ");
                            String nombreAlbum = scanner.nextLine();

                            System.out.print("Portada del álbum: ");
                            String portadaAlbum = scanner.nextLine();

                            System.out.print("Descripcion del álbum: ");
                            String descripcionAlbum = scanner.nextLine();

                            System.out.print("Fecha lanzamiento del álbum: ");
                            String fechaLanzamientoAlbum = scanner.nextLine();

                            System.out.print("Genero del álbum: ");
                            String generoAlbum = scanner.nextLine();

                            System.out.print("Etiqueta Registro del álbum: ");
                            String etiquetaRegistroAlbum = scanner.nextLine();

                            // Validate input
                            if (nombreAlbum.isEmpty() || portadaAlbum.isEmpty() || descripcionAlbum.isEmpty() || fechaLanzamientoAlbum.isEmpty() || generoAlbum.isEmpty() || etiquetaRegistroAlbum.isEmpty()) {
                                System.out.println("Ningún campo debe quedar vacío. Inténtelo de nuevo.");
                            } else {
                                // Lógica para añadir el álbum usando el método añadirAlbum de AlbumControl
                                albumControl.añadirAlbum(new Album(portadaAlbum, nombreAlbum, descripcionAlbum, fechaLanzamientoAlbum, generoAlbum, etiquetaRegistroAlbum));
                                System.out.println("Álbum añadido exitosamente.");
                            }

                            break;
                        case 2:
                            if (!listaAlbumes.isEmpty()) {
                                // Display the list of albums with numbers
                                System.out.println("Lista de Álbumes:");
                                int i = 1;
                                for (Album album : listaAlbumes) {
                                    System.out.println(i + ". " + album.getNombre());
                                    i++;
                                }

                                // valida que la entrada sea un entero
                                try {
                                    System.out.print(
                                            "Ingrese el número del álbum para mostrar la información: "
                                    );
                                    int albumIndex = scanner.nextInt();
                                    scanner.nextLine(); // consumir el carácter de nueva línea
                                    //Validar el índice del álbum elegido
                                    if (albumIndex >= 1 && albumIndex <= listaAlbumes.size()) {
                                        Album selectedAlbum = listaAlbumes.get(albumIndex - 1);

                                        // Mostrar información sobre el álbum seleccionado
                                        System.out.println("Información del Álbum:");
                                        System.out.println("Nombre: " + selectedAlbum.getNombre());
                                        System.out.println("Portada: " + selectedAlbum.getPortada());
                                        System.out.println("Descripción: " + selectedAlbum.getDescripcion());
                                        System.out.println("Fecha Lanzamiento: " + selectedAlbum.getFechaLanzamiento());
                                        System.out.println("Genero: " + selectedAlbum.getGenero());
                                        System.out.println("Etiqueta de Registro: " + selectedAlbum.getEtiquetaRegistro());
                                        // ... (muestra otra información del álbum)
                                    } else {
                                        System.out.println("Número de álbum no válido. Inténtelo de nuevo.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Ingrese un número válido.");
                                    // Opcionalmente, es posible que desees borrar el búfer para evitar un bucle infinito.
                                    scanner.nextLine();
                                }
                            } else {
                                System.out.println("La lista de álbumes está vacía.");

                                // Ask if the user wants to add a new album
                                System.out.print(
                                        "¿Desea agregar un nuevo álbum? (1: Sí, 0: No): "
                                );
                                int agregarNuevoAlbum = scanner.nextInt();
                                scanner.nextLine(); // Consumir la nueva línea pendiente

                                if (agregarNuevoAlbum == 1) {
                                    // Lógica para agregar un nuevo álbum
                                    System.out.println("Ingrese los datos del álbum:");

                                    System.out.print("Nombre del álbum: ");
                                    String nombreAlbumNuevo = scanner.nextLine();

                                    System.out.print("Portada del álbum: ");
                                    String portadaAlbumNuevo = scanner.nextLine();

                                    System.out.print("Descripcion del álbum: ");
                                    String descripcionAlbumNuevo = scanner.nextLine();

                                    System.out.print("Fecha lanzamiento del álbum: ");
                                    String fechaLanzamientoAlbumNuevo = scanner.nextLine();

                                    System.out.print("Genero del álbum: ");
                                    String generoAlbumNuevo = scanner.nextLine();

                                    System.out.print("Etiqueta Registro del álbum: ");
                                    String etiquetaRegistroAlbumNuevo = scanner.nextLine();

                                    // validar entrada
                                    if (nombreAlbumNuevo.isEmpty() || portadaAlbumNuevo.isEmpty() || descripcionAlbumNuevo.isEmpty() || fechaLanzamientoAlbumNuevo.isEmpty() || generoAlbumNuevo.isEmpty() || etiquetaRegistroAlbumNuevo.isEmpty()) {
                                        System.out.println("Ningún campo debe quedar vacío. Inténtelo de nuevo.");
                                    } else {
                                        // Lógica para agregar el álbum usando el método añadirAlbum de AlbumControl
                                        albumControl.añadirAlbum(new Album(portadaAlbumNuevo, nombreAlbumNuevo, descripcionAlbumNuevo, fechaLanzamientoAlbumNuevo, generoAlbumNuevo, etiquetaRegistroAlbumNuevo));
                                        System.out.println("Álbum añadido exitosamente.");
                                    }
                                    break;
                                }
                            }
                            break;
                        case 3:
                            // Mostrar la lista de álbumes con números.
                            System.out.println("Lista de Álbumes:");
                            int i = 1;
                            for (Album album : listaAlbumes) {
                                System.out.println(i + ". " + album.getNombre());
                                i++;
                            }

                            System.out.println("Ingrese el número del álbum a eliminar (0 para cancelar): ");
                            int numeroEliminar = scanner.nextInt();
                            scanner.nextLine(); // consume the newline character

                            if (numeroEliminar == 0) {
                                System.out.println("Operación cancelada.");
                            } else if (
                                    numeroEliminar >= 1 && numeroEliminar <= listaAlbumes.size()
                            ) {
                                // Utilize the método eliminarAlbum of AlbumControl with the index
                                if (
                                        albumControl.eliminarAlbum(
                                                listaAlbumes.get(numeroEliminar - 1).getNombre()
                                        )
                                ) {
                                    System.out.println("Álbum eliminado exitosamente.");
                                } else {
                                    System.out.println(
                                            "El álbum no se encontró en la lista o no se pudo eliminar."
                                    );
                                }
                            } else {
                                System.out.println("Número no válido. Inténtelo de nuevo.");
                            }
                            break;
                        case 4:
                            if (listaAlbumes.isEmpty()) {
                                System.out.println("La lista de álbumes está vacía.");
                            } else {
                                // Display the list of albums
                                System.out.println("Lista de Álbumes:");
                                int albumIndex = 1;
                                for (Album album : listaAlbumes) {
                                    System.out.println(albumIndex + ". " + album.getNombre());
                                    albumIndex++;
                                }

                                System.out.println(
                                        "Ingrese el número del álbum (0 para cancelar):"
                                );
                                int numeroAlbumSeleccionado = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                if (
                                        numeroAlbumSeleccionado >= 1 &&
                                                numeroAlbumSeleccionado <= listaAlbumes.size()
                                ) {
                                    Album albumSeleccionado = listaAlbumes.get(
                                            numeroAlbumSeleccionado - 1
                                    );

                                    // Display additional options
                                    System.out.println("Seleccione una opción:");
                                    System.out.println("1. Comentar Album");
                                    System.out.println("2. Eliminar comentario");
                                    System.out.println("3. Actualizar comentario");
                                    System.out.println("4. Mostrar comentarios");

                                    int opcionComentarios = scanner.nextInt();
                                    scanner.nextLine(); // Consume the newline character

                                    switch (opcionComentarios) {
                                        case 1:
                                            // Logic to add a comment
                                            System.out.println(
                                                    "Ingrese su comentario para el álbum " +
                                                            albumSeleccionado.getNombre() +
                                                            ":"
                                            );
                                            String textoComentario = scanner.nextLine();
                                            System.out.println(
                                                    "Ingrese el rating para el comentario (1-5):"
                                            );
                                            int ratingComentario = scanner.nextInt();
                                            Comentario nuevoComentario = new Comentario(
                                                    textoComentario,
                                                    ratingComentario
                                            );

                                            // Implement comentariosControl method to add a comment
                                            comentariosControl.agregarComentario(
                                                    albumSeleccionado,
                                                    nuevoComentario
                                            );

                                            System.out.println("Comentario agregado exitosamente.");
                                            break;
                                        case 2:
                                            // Logic to delete a comment
                                            // Implement comentariosControl method to get comments for the selected album
                                            List<Comentario> comentariosAlbum = comentariosControl.obtenerComentarios(
                                                    albumSeleccionado
                                            );

                                            if (!comentariosAlbum.isEmpty()) {
                                                System.out.println(
                                                        "Lista de comentarios para el álbum " +
                                                                albumSeleccionado.getNombre() +
                                                                ":"
                                                );
                                                int idx = 1;
                                                for (Comentario comentario : comentariosAlbum) {
                                                    System.out.println(
                                                            idx + ". " + comentario.getDescripcion()
                                                    );
                                                    idx++;
                                                }

                                                System.out.println(
                                                        "Ingrese el número del comentario a eliminar (0 para cancelar):"
                                                );
                                                int numeroComentarioEliminar = scanner.nextInt();
                                                scanner.nextLine(); // Consume the newline character

                                                if (
                                                        numeroComentarioEliminar >= 1 &&
                                                                numeroComentarioEliminar <= comentariosAlbum.size()
                                                ) {
                                                    Comentario comentarioEliminar = comentariosAlbum.get(
                                                            numeroComentarioEliminar - 1
                                                    );

                                                    // Implement comentariosControl method to delete a comment
                                                    if (
                                                            comentariosControl.eliminarComentario(
                                                                    albumSeleccionado,
                                                                    comentarioEliminar
                                                            )
                                                    ) {
                                                        System.out.println(
                                                                "Comentario eliminado exitosamente."
                                                        );
                                                    } else {
                                                        System.out.println(
                                                                "No se pudo eliminar el comentario."
                                                        );
                                                    }
                                                } else if (numeroComentarioEliminar == 0) {
                                                    System.out.println("Operación cancelada.");
                                                } else {
                                                    System.out.println(
                                                            "Número no válido. Inténtelo de nuevo."
                                                    );
                                                }
                                            } else {
                                                System.out.println(
                                                        "No hay comentarios para este álbum."
                                                );
                                            }
                                            break;
                                        case 3:
                                            // Logic to update a comment
                                            // Implement comentariosControl method to get comments for the selected album
                                            List<Comentario> comentariosAlbumActualizar = comentariosControl.obtenerComentarios(
                                                    albumSeleccionado
                                            );

                                            if (!comentariosAlbumActualizar.isEmpty()) {
                                                System.out.println(
                                                        "Lista de comentarios para el álbum " +
                                                                albumSeleccionado.getNombre() +
                                                                ":"
                                                );
                                                int idx = 1;
                                                for (Comentario comentario : comentariosAlbumActualizar) {
                                                    System.out.println(
                                                            idx + ". " + comentario.getDescripcion()
                                                    );
                                                    idx++;
                                                }

                                                System.out.println(
                                                        "Ingrese el número del comentario a actualizar (0 para cancelar):"
                                                );
                                                int numeroComentarioActualizar = scanner.nextInt();
                                                scanner.nextLine(); // Consume the newline character

                                                if (
                                                        numeroComentarioActualizar >= 1 &&
                                                                numeroComentarioActualizar <=
                                                                        comentariosAlbumActualizar.size()
                                                ) {
                                                    Comentario comentarioActualizar = comentariosAlbumActualizar.get(
                                                            numeroComentarioActualizar - 1
                                                    );

                                                    // Implement comentariosControl method to delete a comment
                                                    if (
                                                            comentariosControl.eliminarComentario(
                                                                    albumSeleccionado,
                                                                    comentarioActualizar
                                                            )
                                                    ) {
                                                        System.out.println(
                                                                "Ingrese su nuevo comentario para el álbum " +
                                                                        albumSeleccionado.getNombre() +
                                                                        ":"
                                                        );
                                                        String nuevoTextoComentario = scanner.nextLine();
                                                        System.out.println(
                                                                "Ingrese el nuevo rating para el comentario (1-5):"
                                                        );
                                                        int nuevoRatingComentario = scanner.nextInt();

                                                        Comentario nuevoComentarioActualizar = new Comentario(
                                                                nuevoTextoComentario,
                                                                nuevoRatingComentario
                                                        );

                                                        // Implement comentariosControl method to add a comment
                                                        comentariosControl.agregarComentario(
                                                                albumSeleccionado,
                                                                nuevoComentarioActualizar
                                                        );

                                                        System.out.println(
                                                                "Comentario actualizado exitosamente."
                                                        );
                                                    } else {
                                                        System.out.println(
                                                                "No se pudo actualizar el comentario."
                                                        );
                                                    }
                                                } else if (numeroComentarioActualizar == 0) {
                                                    System.out.println("Operación cancelada.");
                                                } else {
                                                    System.out.println(
                                                            "Número no válido. Inténtelo de nuevo."
                                                    );
                                                }
                                            } else {
                                                System.out.println(
                                                        "No hay comentarios para este álbum."
                                                );
                                            }
                                            break;
                                        case 4:
                                            // Logic to display comments
                                            // Implement comentariosControl method to get comments for the selected album
                                            List<Comentario> comentariosAlbumMostrar = comentariosControl.obtenerComentarios(
                                                    albumSeleccionado
                                            );

                                            if (!comentariosAlbumMostrar.isEmpty()) {
                                                System.out.println(
                                                        "Lista de comentarios para el álbum " +
                                                                albumSeleccionado.getNombre() +
                                                                ":"
                                                );
                                                for (Comentario comentario : comentariosAlbumMostrar) {
                                                    System.out.println(
                                                            "Texto: " + comentario.getDescripcion()
                                                    );
                                                    System.out.println(
                                                            "Rating: " + comentario.getRating()
                                                    );
                                                    System.out.println("------------------------");
                                                }
                                            } else {
                                                System.out.println(
                                                        "No hay comentarios para este álbum."
                                                );
                                            }
                                            break;
                                        default:
                                            System.out.println(
                                                    "Opción no válida. Inténtelo de nuevo."
                                            );
                                            break;
                                    }
                                } else if (numeroAlbumSeleccionado == 0) {
                                    System.out.println("Operación cancelada.");
                                } else {
                                    System.out.println("Número no válido. Inténtelo de nuevo.");
                                }
                            }
                            break;
                        case 5: // Agregamos una nueva opción para canciones
                            // Logic for managing songs
                            if (listaAlbumes.isEmpty()) {
                                System.out.println("La lista de álbumes está vacía.");
                            } else {
                                System.out.println("Lista de Álbumes:");
                                int albumIndexSongs = 1;
                                for (Album album : listaAlbumes) {
                                    System.out.println(
                                            albumIndexSongs + ". " + album.getNombre()
                                    );
                                    albumIndexSongs++;
                                }
                                System.out.println(
                                        "Ingrese el número del álbum (0 para cancelar):"
                                );
                                int numeroAlbumSeleccionadoSongs = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                if (
                                        numeroAlbumSeleccionadoSongs >= 1 &&
                                                numeroAlbumSeleccionadoSongs <= listaAlbumes.size()
                                ) {
                                    Album albumSeleccionadoSongs = listaAlbumes.get(
                                            numeroAlbumSeleccionadoSongs - 1
                                    );

                                    // Display additional options
                                    System.out.println("Seleccione una opción para canciones:");
                                    System.out.println("1. Agregar Canción");
                                    System.out.println("2. Eliminar Canción");
                                    System.out.println("3. Actualizar Canción");
                                    System.out.println("4. Mostrar Canciones");

                                    int opcionCanciones = scanner.nextInt();
                                    scanner.nextLine(); // Consume the newline character

                                    switch (opcionCanciones) {
                                        case 1:
                                            // Logic to add a song
                                            System.out.println("Ingrese los datos de la canción:");
                                            System.out.print("Nombre de la canción: ");
                                            String nombreCancion = scanner.nextLine();
                                            System.out.print("Duración de la canción: ");
                                            String duracionCancion = scanner.nextLine();

                                            // Validate input
                                            if (
                                                    nombreCancion.isEmpty() || duracionCancion.isEmpty()
                                            ) {
                                                System.out.println(
                                                        "Ningún campo debe quedar vacío. Inténtelo de nuevo."
                                                );
                                            } else {
                                                // Logic to add the song using the añadirCancion method of AlbumControl
                                                albumControl.añadirCancion(
                                                        albumSeleccionadoSongs,
                                                        new Cancion(nombreCancion, duracionCancion)
                                                );
                                                System.out.println("Canción agregada exitosamente.");
                                            }
                                            break;
                                        case 2:
                                            // Logic to delete a song
                                            // Display the songs
                                            List<Cancion> cancionesAlbum = albumControl.obtenerCanciones(
                                                    albumSeleccionadoSongs
                                            );
                                            if (!cancionesAlbum.isEmpty()) {
                                                System.out.println(
                                                        "Lista de canciones para el álbum " +
                                                                albumSeleccionadoSongs.getNombre() +
                                                                ":"
                                                );
                                                int idx = 1;
                                                for (Cancion cancion : cancionesAlbum) {
                                                    System.out.println(idx + ". " + cancion.getNombre());
                                                    idx++;
                                                }
                                                System.out.println(
                                                        "Ingrese el número de la canción a eliminar (0 para cancelar):"
                                                );
                                                int numeroCancionEliminar = scanner.nextInt();
                                                scanner.nextLine(); // Consume the newline character
                                                if (
                                                        numeroCancionEliminar >= 1 &&
                                                                numeroCancionEliminar <= cancionesAlbum.size()
                                                ) {
                                                    Cancion cancionEliminar = cancionesAlbum.get(
                                                            numeroCancionEliminar - 1
                                                    );
                                                    if (
                                                            albumControl.eliminarCancion(
                                                                    albumSeleccionadoSongs,
                                                                    cancionEliminar
                                                            )
                                                    ) {
                                                        System.out.println(
                                                                "Canción eliminada exitosamente."
                                                        );
                                                    } else {
                                                        System.out.println(
                                                                "No se pudo eliminar la canción."
                                                        );
                                                    }
                                                } else if (numeroCancionEliminar == 0) {
                                                    System.out.println("Operación cancelada.");
                                                } else {
                                                    System.out.println(
                                                            "Número no válido. Inténtelo de nuevo."
                                                    );
                                                }
                                            } else {
                                                System.out.println("No hay canciones para este álbum.");
                                            }
                                            break;
                                        case 3:
                                            // Logic to update a song (similar to delete, then add)
                                            // Display the songs
                                            List<Cancion> cancionesAlbumActualizar = albumControl.obtenerCanciones(
                                                    albumSeleccionadoSongs
                                            );
                                            if (!cancionesAlbumActualizar.isEmpty()) {
                                                System.out.println(
                                                        "Lista de canciones para el álbum " +
                                                                albumSeleccionadoSongs.getNombre() +
                                                                ":"
                                                );
                                                int idx = 1;
                                                for (Cancion cancion : cancionesAlbumActualizar) {
                                                    System.out.println(idx + ". " + cancion.getNombre());
                                                    idx++;
                                                }
                                                System.out.println(
                                                        "Ingrese el número de la canción a actualizar (0 para cancelar):"
                                                );
                                                int numeroCancionActualizar = scanner.nextInt();
                                                scanner.nextLine(); // Consume the newline character
                                                if (
                                                        numeroCancionActualizar >= 1 &&
                                                                numeroCancionActualizar <=
                                                                        cancionesAlbumActualizar.size()
                                                ) {
                                                    Cancion cancionActualizar = cancionesAlbumActualizar.get(
                                                            numeroCancionActualizar - 1
                                                    );

                                                    // Delete the existing song
                                                    if (
                                                            albumControl.eliminarCancion(
                                                                    albumSeleccionadoSongs,
                                                                    cancionActualizar
                                                            )
                                                    ) {
                                                        System.out.println(
                                                                "Ingrese los nuevos datos de la canción:"
                                                        );
                                                        System.out.print("Nuevo nombre de la canción: ");
                                                        String nuevoNombreCancion = scanner.nextLine();
                                                        System.out.print("Nueva duración de la canción: ");
                                                        String nuevaDuracionCancion = scanner.nextLine();

                                                        // Validate input
                                                        if (
                                                                nuevoNombreCancion.isEmpty() ||
                                                                        nuevaDuracionCancion.isEmpty()
                                                        ) {
                                                            System.out.println(
                                                                    "Ningún campo debe quedar vacío. Inténtelo de nuevo."
                                                            );
                                                        } else {
                                                            // Logic to add the updated song
                                                            albumControl.añadirCancion(
                                                                    albumSeleccionadoSongs,
                                                                    new Cancion(
                                                                            nuevoNombreCancion,
                                                                            nuevaDuracionCancion
                                                                    )
                                                            );
                                                            System.out.println(
                                                                    "Canción actualizada exitosamente."
                                                            );
                                                        }
                                                    } else {
                                                        System.out.println(
                                                                "No se pudo actualizar la canción."
                                                        );
                                                    }
                                                } else if (numeroCancionActualizar == 0) {
                                                    System.out.println("Operación cancelada.");
                                                } else {
                                                    System.out.println(
                                                            "Número no válido. Inténtelo de nuevo."
                                                    );
                                                }
                                            } else {
                                                System.out.println("No hay canciones para este álbum.");
                                            }
                                            break;
                                        case 4:
                                            // Logic to display songs
                                            List<Cancion> cancionesAlbumMostrar = albumControl.obtenerCanciones(
                                                    albumSeleccionadoSongs
                                            );
                                            if (!cancionesAlbumMostrar.isEmpty()) {
                                                System.out.println(
                                                        "Lista de canciones para el álbum " +
                                                                albumSeleccionadoSongs.getNombre() +
                                                                ":"
                                                );
                                                for (Cancion cancion : cancionesAlbumMostrar) {
                                                    System.out.println("Nombre: " + cancion.getNombre());
                                                    System.out.println(
                                                            "Duración: " + cancion.getDuracion()
                                                    );
                                                    System.out.println("------------------------");
                                                }
                                            } else {
                                                System.out.println("No hay canciones para este álbum.");
                                            }
                                            break;
                                        default:
                                            System.out.println(
                                                    "Opción no válida. Inténtelo de nuevo."
                                            );
                                            break;
                                    }
                                } else if (numeroAlbumSeleccionadoSongs == 0) {
                                    System.out.println("Operación cancelada.");
                                } else {
                                    System.out.println("Número no válido. Inténtelo de nuevo.");
                                }
                                break;
                            }
                        case 0:
                            // Volver al Menú Principal
                            break;
                        default:
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                            break;
                    }
                    break;
                case 2:
                    // Llamar a métodos de control de artistas
                    System.out.println("1. Añadir Artista");
                    System.out.println("2. Mostrar Lista de Artistas");
                    System.out.println("3. Eliminar Artista");
                    System.out.println("4. Gestion Bandas");
                    System.out.println("0. Volver al Menú Principal");

                    int opcionArtista = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de linea

                    switch (opcionArtista) {
                        case 1:
                            // Lógica para añadir artista
                            System.out.println("Ingrese el nombre del artista: ");
                            String nombreArtista = scanner.nextLine();

                            System.out.println("Ingrese la descripción del artista: ");
                            String descripcionArtista = scanner.nextLine();

                            // Crea un objeto Artista con la información proporcionada
                            Artista nuevoArtista = new Artista(
                                    nombreArtista,
                                    null,
                                    descripcionArtista,
                                    null
                            );

                            // Utiliza el método añadirArtista de ArtistaControl
                            if (artistaControl.añadirArtista(nuevoArtista)) {
                                System.out.println("Artista añadido exitosamente.");
                            } else {
                                System.out.println("El artista ya existe en la lista.");
                            }
                            break;
                        case 2:
                            // Lógica para mostrar lista de artistas
                            ArrayList<Artista> listaArtistas = artistaControl.obtenerListaArtistas();

                            if (listaArtistas.isEmpty()) {
                                System.out.println("La lista de artistas está vacía.");
                                System.out.println(
                                        "¿Desea agregar un nuevo artista? (1.Sí/2.No): "
                                );
                                int respuesta = scanner.nextInt();
                                scanner.nextLine(); // Consumir la nueva línea pendiente
                                if (respuesta == 1) {
                                    // Lógica para añadir artista
                                    System.out.println("Ingrese el nombre del artista: ");
                                    String nombreArtistaNuevo = scanner.next();

                                    System.out.println("Ingrese la imagen del artista: ");
                                    String imagenArtistaNuevo = scanner.next();

                                    System.out.println("Ingrese la descripción del artista: ");
                                    String descripcionArtistaNuevo = scanner.next();

                                    // Crea un objeto Artista con la información proporcionada
                                    Artista nuevoArtista1 = new Artista(
                                            nombreArtistaNuevo,
                                            imagenArtistaNuevo,
                                            descripcionArtistaNuevo,
                                            nombreArtistaNuevo
                                    );

                                    // Utiliza el método añadirArtista de ArtistaControl
                                    if (artistaControl.añadirArtista(nuevoArtista1)) {
                                        System.out.println("Artista añadido exitosamente.");
                                    } else {
                                        System.out.println("El artista ya existe en la lista.");
                                    }

                                    // Muestra la lista actualizada de artistas
                                    listaArtistas = artistaControl.obtenerListaArtistas();
                                    for (Artista artista : listaArtistas) {
                                        System.out.println("Nombre: " + artista.getNombre());
                                        System.out.println("Imagen: " + artista.getImagen());
                                        System.out.println(
                                                "Descripción: " + artista.getDescripcion()
                                        );
                                        System.out.println("------------------------------------");
                                    }
                                } else {
                                    System.out.println("Operación cancelada.");
                                }
                            } else {
                                System.out.println("Lista de Artistas:");
                                for (Artista artista : listaArtistas) {
                                    System.out.println("Nombre: " + artista.getNombre());
                                    System.out.println("Imagen: " + artista.getImagen());
                                    System.out.println(
                                            "Descripción: " + artista.getDescripcion()
                                    );
                                    System.out.println("------------------------------------");
                                }
                            }
                            break;
                        case 3:
                            // Lógica para eliminar artista
                            System.out.println("Lista de Artistas:");

                            // Mostrar lista de artistas con números
                            ArrayList<Artista> listaArtistasEliminar = artistaControl.obtenerListaArtistas();
                            for (int i = 0; i < listaArtistasEliminar.size(); i++) {
                                Artista artista = listaArtistasEliminar.get(i);
                                System.out.println((i + 1) + ". " + artista.getNombre());
                            }

                            System.out.println(
                                    "Ingrese el número del artista a eliminar (0 para cancelar): "
                            );
                            int numeroArtistaEliminar = scanner.nextInt();

                            if (
                                    numeroArtistaEliminar >= 1 &&
                                            numeroArtistaEliminar <= listaArtistasEliminar.size()
                            ) {
                                // Utiliza el método eliminarArtista de ArtistaControl con el índice
                                Artista artistaEliminar = listaArtistasEliminar.get(
                                        numeroArtistaEliminar - 1
                                );
                                if (
                                        artistaControl.eliminarArtista(artistaEliminar.getNombre())
                                ) {
                                    System.out.println("Artista eliminado exitosamente.");
                                } else {
                                    System.out.println(
                                            "El artista no se encontró en la lista o no se pudo eliminar."
                                    );
                                }
                            } else if (numeroArtistaEliminar == 0) {
                                System.out.println("Operación cancelada.");
                            } else {
                                System.out.println("Número de artista no válido.");
                            }
                            break;
                        case 4:
                            // Lógica para gestionar bandas
                            System.out.println("1. Crear Banda");
                            System.out.println("2. Mostrar Lista de Bandas");
                            System.out.println("3. Actualizar Banda");
                            System.out.println("4. Eliminar Banda");
                            System.out.println("0. Volver al Menú Principal");

                            int opcionBanda = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea pendiente

                            switch (opcionBanda) {
                                case 1:
                                    // Lógica para crear banda
                                    System.out.println("Ingrese el nombre de la banda: ");
                                    String nombreBanda = scanner.nextLine();

                                    System.out.println("Ingrese el género de la banda: ");
                                    String generoBanda = scanner.nextLine();

                                    System.out.println(
                                            "Ingrese la fecha de creación de la banda: "
                                    );
                                    String fechaCreacionBanda = scanner.nextLine();

                                    // Crear un objeto Banda con la información proporcionada
                                    Banda nuevaBanda = new Banda(
                                            null,
                                            nombreBanda,
                                            generoBanda,
                                            fechaCreacionBanda,
                                            null
                                    );
                                    bandaControl.crear(nuevaBanda);
                                    System.out.println("Banda creada exitosamente.");
                                    break;
                                case 2:
                                    // Lógica para mostrar lista de bandas
                                    List<Banda> listaBandas = bandaControl.listar();

                                    if (listaBandas.isEmpty()) {
                                        System.out.println("La lista de bandas está vacía.");
                                    } else {
                                        System.out.println("Lista de Bandas:");
                                        for (Banda banda : listaBandas) {
                                            System.out.println("Nombre: " + banda.getNombre());
                                            System.out.println("Género: " + banda.getGenero());
                                            System.out.println(
                                                    "Fecha de Creación: " + banda.getFechaCreacion()
                                            );
                                            System.out.println(
                                                    "------------------------------------"
                                            );
                                        }
                                    }
                                    break;
                                case 3:
                                    // Lógica para actualizar banda
                                    // Mostrar lista de bandas
                                    List<Banda> listaBandasActualizar = bandaControl.listar();
                                    if (listaBandasActualizar.isEmpty()) {
                                        System.out.println("La lista de bandas está vacía.");
                                        System.out.println(
                                                "¿Desea agregar una nueva banda? (1: Sí, 0: No): "
                                        );
                                        int agregarNuevaBanda = scanner.nextInt();
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        if (agregarNuevaBanda == 1) {
                                            // Lógica para crear banda (similar a la opción 1 del menú)
                                            // Lógica para crear banda
                                            System.out.println("Ingrese el nombre de la banda: ");
                                            String nombreBanda1 = scanner.nextLine();

                                            System.out.println("Ingrese el género de la banda: ");
                                            String generoBanda1 = scanner.nextLine();

                                            System.out.println(
                                                    "Ingrese la fecha de creación de la banda: "
                                            );
                                            String fechaCreacionBanda1 = scanner.nextLine();

                                            System.out.println(
                                                    "Ingrese la lista de artistas de la banda: "
                                            );

                                            // Crear un objeto Banda con la información proporcionada
                                            Banda nuevaBanda1 = new Banda(
                                                    null,
                                                    nombreBanda1,
                                                    generoBanda1,
                                                    fechaCreacionBanda1,
                                                    null
                                            );
                                            bandaControl.crear(nuevaBanda1);
                                            System.out.println("Banda creada exitosamente.");
                                            break;
                                        } else {
                                            System.out.println("Operación cancelada.");
                                            break;
                                        }
                                    } else {
                                        // Mostrar lista de bandas con números
                                        System.out.println("Lista de Bandas:");
                                        for (int i = 0; i < listaBandasActualizar.size(); i++) {
                                            Banda banda = listaBandasActualizar.get(i);
                                            System.out.println((i + 1) + ". " + banda.getNombre());
                                        }

                                        System.out.println(
                                                "Ingrese el número de la banda a actualizar (0 para cancelar): "
                                        );
                                        int numeroBandaActualizar = scanner.nextInt();

                                        if (
                                                numeroBandaActualizar >= 1 &&
                                                        numeroBandaActualizar <= listaBandasActualizar.size()
                                        ) {
                                            // Obtener la banda seleccionada
                                            Banda bandaActualizar = listaBandasActualizar.get(
                                                    numeroBandaActualizar - 1
                                            );

                                            // Lógica para crear banda
                                            System.out.println("Ingrese el nombre de la banda: ");
                                            String nombreBanda2 = scanner.nextLine();

                                            System.out.println("Ingrese el género de la banda: ");
                                            String generoBanda2 = scanner.nextLine();

                                            System.out.println(
                                                    "Ingrese la fecha de creación de la banda: "
                                            );
                                            String fechaCreacionBanda2 = scanner.nextLine();

                                            System.out.println(
                                                    "Ingrese la lista de artistas de la banda: "
                                            );

                                            // Crear un objeto Banda con la información proporcionada
                                            Banda nuevaBanda2 = new Banda(
                                                    null,
                                                    nombreBanda2,
                                                    generoBanda2,
                                                    fechaCreacionBanda2,
                                                    null
                                            );
                                            bandaControl.crear(nuevaBanda2);
                                            System.out.println("Banda creada exitosamente.");

                                            System.out.println("Banda actualizada exitosamente.");
                                        } else if (numeroBandaActualizar == 0) {
                                            System.out.println("Operación cancelada.");
                                        } else {
                                            System.out.println(
                                                    "Número no válido. Inténtelo de nuevo."
                                            );
                                        }
                                    }
                                    break;
                                case 4:
                                    // Lógica para eliminar banda
                                    // Mostrar lista de bandas
                                    List<Banda> listaBandasEliminar = bandaControl.listar();
                                    if (listaBandasEliminar.isEmpty()) {
                                        System.out.println("La lista de bandas está vacía.");
                                        System.out.println(
                                                "¿Desea agregar una nueva banda? (1: Sí, 0: No): "
                                        );
                                        int agregarNuevaBanda = scanner.nextInt();
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        if (agregarNuevaBanda == 1) {
                                            // Lógica para crear banda
                                            System.out.println("Ingrese el nombre de la banda: ");
                                            String nombreBanda3 = scanner.nextLine();

                                            System.out.println("Ingrese el género de la banda: ");
                                            String generoBanda3 = scanner.nextLine();

                                            System.out.println(
                                                    "Ingrese la fecha de creación de la banda: "
                                            );
                                            String fechaCreacionBanda3 = scanner.nextLine();

                                            System.out.println(
                                                    "Ingrese la lista de artistas de la banda: "
                                            );

                                            // Crear un objeto Banda con la información proporcionada
                                            Banda nuevaBanda3 = new Banda(
                                                    null,
                                                    nombreBanda3,
                                                    generoBanda3,
                                                    fechaCreacionBanda3,
                                                    null
                                            );
                                            bandaControl.crear(nuevaBanda3);
                                            System.out.println("Banda creada exitosamente.");
                                            break;
                                        } else {
                                            System.out.println("Operación cancelada.");
                                            break;
                                        }
                                    } else {
                                        // Mostrar lista de bandas con números
                                        System.out.println("Lista de Bandas:");
                                        for (int i = 0; i < listaBandasEliminar.size(); i++) {
                                            Banda banda = listaBandasEliminar.get(i);
                                            System.out.println((i + 1) + ". " + banda.getNombre());
                                        }

                                        System.out.println(
                                                "Ingrese el número de la banda a eliminar (0 para cancelar): "
                                        );
                                        int numeroBandaEliminar = scanner.nextInt();

                                        if (
                                                numeroBandaEliminar >= 1 &&
                                                        numeroBandaEliminar <= listaBandasEliminar.size()
                                        ) {
                                            // Obtener la banda seleccionada
                                            Banda bandaEliminar = listaBandasEliminar.get(
                                                    numeroBandaEliminar - 1
                                            );

                                            // Lógica para eliminar banda (similar a la opción 1 del menú)
                                            bandaControl.eliminar(bandaEliminar.getId_banda());

                                            System.out.println("Banda eliminada exitosamente.");
                                        } else if (numeroBandaEliminar == 0) {
                                            System.out.println("Operación cancelada.");
                                        } else {
                                            System.out.println(
                                                    "Número no válido. Inténtelo de nuevo."
                                            );
                                        }
                                    }
                                    break;
                                case 0:
                                    // Volver al Menú Principal
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                                    break;
                            }
                            break;
                        case 0:
                            // Volver al Menú Principal
                            break;
                        default:
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                            break;
                    }
                    break;
                case 3:
                    // Llamar a métodos de control de coleccionistas
                    System.out.println("1. Registrar Coleccionista");
                    System.out.println("2. Mostrar Lista de Coleccionistas");
                    System.out.println("3. Eliminar Coleccionista");
                    System.out.println("0. Volver al Menú Principal");

                    int opcionColeccionista = scanner.nextInt();

                    switch (opcionColeccionista) {
                        case 1:
                            // Lógica para registrar coleccionista
                            System.out.println("Ingrese el nombre de usuario: ");
                            String nombreUsuario = scanner.next();
                            System.out.println("Ingrese la contraseña: ");
                            String contrasena = scanner.next();

                            if (
                                    coleccionistaControl.registrarColeccionista(
                                            nombreUsuario,
                                            contrasena
                                    )
                            ) {
                                System.out.println("Coleccionista registrado exitosamente.");
                            }
                            break;
                        case 2:
                            // Obtener la lista de coleccionistas
                            listaColeccionistas =
                                    coleccionistaControl.obtenerListaColeccionistas();
                            System.out.println(
                                    "numero de coleccionistas: " + listaColeccionistas.size()
                            );
                            // Lógica para mostrar lista de coleccionistas
                            for (Colector coleccionista : listaColeccionistas) {
                                System.out.println(coleccionista.getName());
                            }
                            break;
                        case 3:
                            // Lógica para eliminar coleccionista
                            if (listaColeccionistas.isEmpty()) {
                                System.out.println("La lista de coleccionistas está vacía.");
                            } else {
                                System.out.println("Lista de Coleccionistas:");

                                // Mostrar lista de coleccionistas con números
                                for (int i = 0; i < listaColeccionistas.size(); i++) {
                                    Colector coleccionista = listaColeccionistas.get(i);
                                    System.out.println((i + 1) + ". " + coleccionista.getName());
                                }

                                System.out.println(
                                        "Ingrese el número del coleccionista a eliminar (0 para cancelar): "
                                );
                                int numeroEliminarColeccionista = scanner.nextInt();

                                if (
                                        numeroEliminarColeccionista >= 1 &&
                                                numeroEliminarColeccionista <= listaColeccionistas.size()
                                ) {
                                    // Utiliza el método eliminarColeccionista de ColeccionistaControl con el índice
                                    Colector coleccionistaEliminar = listaColeccionistas.get(
                                            numeroEliminarColeccionista - 1
                                    );
                                    if (
                                            coleccionistaControl.eliminarColeccionista(
                                                    coleccionistaEliminar
                                            )
                                    ) {
                                        System.out.println("Coleccionista eliminado exitosamente.");
                                    } else {
                                        System.out.println(
                                                "El coleccionista no se encontró en la lista o no se pudo eliminar."
                                        );
                                    }
                                } else if (numeroEliminarColeccionista == 0) {
                                    System.out.println("Operación cancelada.");
                                } else {
                                    System.out.println("Número de coleccionista no válido.");
                                }
                            }
                            break;
                        case 0:
                            // Volver al Menú Principal
                            break;
                        default:
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
