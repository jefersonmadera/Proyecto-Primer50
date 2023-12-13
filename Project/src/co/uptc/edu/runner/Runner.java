package co.uptc.edu.runner;

import co.uptc.edu.controller.AlbumControl;
import co.uptc.edu.controller.ArtistaControl;
import co.uptc.edu.controller.ColeccionistaControl;
import co.uptc.edu.controller.ComentariosControl;
import co.uptc.edu.model.Album;
import co.uptc.edu.model.Artista;
import co.uptc.edu.model.Colector;
import co.uptc.edu.model.Comentario;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlbumControl albumControl = new AlbumControl();
        ArtistaControl artistaControl = new ArtistaControl();
        ColeccionistaControl coleccionistaControl = new ColeccionistaControl();
        ArrayList<Album> listaAlbumes = albumControl.getAlbums();
        ArrayList<Colector> listaColeccionistas = coleccionistaControl.obtenerListaColeccionistas();

        int opcion;

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
                    System.out.println("0. Volver al Menú Principal");

                    int opcionAlbum = scanner.nextInt();

                    switch (opcionAlbum) {
                        case 1:
                            // Lógica para añadir álbum
                            System.out.println("Ingrese los datos del álbum:");

                            // Consumir la nueva línea pendiente para evitar problemas de lectura
                            scanner.nextLine();

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

                            // Lógica para añadir el álbum usando el método añadirAlbum de AlbumControl
                            albumControl.añadirAlbum(new Album(portadaAlbum, nombreAlbum, descripcionAlbum,
                                    fechaLanzamientoAlbum, generoAlbum, etiquetaRegistroAlbum));
                            System.out.println("Álbum añadido exitosamente.");
                            break;

                        case 2:
                            if (!listaAlbumes.isEmpty()) {
                                System.out.println("Lista de Álbumes:");
                                int i = 1;
                                for (Album album : listaAlbumes) {
                                    System.out.println(i + ". " + album.getNombre());
                                    i++;
                                }
                            } else {
                                System.out.println("La lista de álbumes está vacía.");
                                // Preguntar si desea agregar un álbum
                                System.out.print("¿Desea agregar un nuevo álbum? (1: Sí, 0: No): ");
                                int agregarNuevoAlbum = scanner.nextInt();
                                if (agregarNuevoAlbum == 1) {
                                    // Lógica para añadir álbum
                                    System.out.println("Ingrese los datos del álbum:");

                                    // Consumir la nueva línea pendiente para evitar problemas de lectura
                                    scanner.nextLine();

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

                                    // Lógica para añadir el álbum usando el método añadirAlbum de AlbumControl
                                    albumControl.añadirAlbum(new Album(portadaAlbumNuevo, nombreAlbumNuevo,
                                            descripcionAlbumNuevo,
                                            fechaLanzamientoAlbumNuevo, generoAlbumNuevo, etiquetaRegistroAlbumNuevo));
                                    System.out.println("Álbum añadido exitosamente.");
                                    break;
                                }
                            }
                            break;

                        case 3:
                            // Lógica para eliminar álbum
                            System.out.println("Lista de Álbumes:");

                            // Mostrar lista de álbumes
                            for (int i = 0; i < listaAlbumes.size(); i++) {
                                Album album = listaAlbumes.get(i);
                                System.out.println((i + 1) + ". " + album.getNombre());
                            }

                            // Verificar si la lista está vacía
                            if (listaAlbumes.isEmpty()) {
                                System.out.println("La lista de álbumes está vacía.");
                            } else {
                                System.out.println("Ingrese el número del álbum a eliminar (0 para cancelar): ");
                                int numeroEliminar = scanner.nextInt();

                                if (numeroEliminar >= 1 && numeroEliminar <= listaAlbumes.size()) {
                                    // Utiliza el método eliminarAlbum de AlbumControl con el índice
                                    if (albumControl.eliminarAlbum(listaAlbumes.get(numeroEliminar - 1).getNombre())) {
                                        System.out.println("Álbum eliminado exitosamente.");
                                    } else {
                                        System.out
                                                .println("El álbum no se encontró en la lista o no se pudo eliminar.");
                                    }
                                } else if (numeroEliminar == 0) {
                                    System.out.println("Operación cancelada.");
                                } else {
                                    System.out.println("Número no válido. Inténtelo de nuevo.");
                                }
                            }
                            break;
                        case 4:

                            System.out.println("Ingrese el número del álbum para comentar (0 para cancelar):");

                            // Mostrar lista de álbumes con números
                            for (int i = 0; i < listaAlbumes.size(); i++) {
                                Album album = listaAlbumes.get(i);
                                System.out.println((i + 1) + ". " + album.getNombre());
                            }

                            if (listaAlbumes.isEmpty()) {
                                System.out.println("La lista de álbumes está vacía.");
                            } else {
                                int numeroAlbumComentar = scanner.nextInt();

                                // Crear una instancia de ComentariosControl
                                ComentariosControl comentariosControl = new ComentariosControl();

                                if (numeroAlbumComentar >= 1 && numeroAlbumComentar <= listaAlbumes.size()) {
                                    Album albumComentar = listaAlbumes.get(numeroAlbumComentar - 1);
                                    scanner.nextLine(); // Consumir la nueva línea pendiente

                                    System.out.println(
                                            "Ingrese su comentario para el álbum " + albumComentar.getNombre() + ":");
                                    String textoComentario = scanner.nextLine();

                                    // Agregar la lógica para obtener el rating del usuario
                                    System.out.println("Ingrese el rating para el comentario (1-5):");
                                    int ratingComentario = scanner.nextInt();

                                    // Crear un objeto Comentario con la descripción y el rating proporcionados
                                    Comentario nuevoComentario = new Comentario(textoComentario, ratingComentario);

                                    // Lógica para agregar el comentario usando el método agregarComentario de
                                    // ComentariosControl
                                    comentariosControl.agregarComentario(albumComentar, nuevoComentario);

                                    System.out.println("Comentario agregado exitosamente.");
                                } else if (numeroAlbumComentar == 0) {
                                    System.out.println("Operación cancelada.");
                                } else {
                                    System.out.println("Número no válido. Inténtelo de nuevo.");
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

                case 2:
                    // Llamar a métodos de control de artistas
                    System.out.println("1. Añadir Artista");
                    System.out.println("2. Mostrar Lista de Artistas");
                    System.out.println("3. Eliminar Artista");
                    System.out.println("0. Volver al Menú Principal");

                    int opcionArtista = scanner.nextInt();

                    switch (opcionArtista) {
                        case 1:
                            // Lógica para añadir artista
                            System.out.println("Ingrese el nombre del artista: ");
                            String nombreArtista = scanner.next();

                            System.out.println("Ingrese la imagen del artista: ");
                            String imagenArtista = scanner.next();

                            System.out.println("Ingrese la descripción del artista: ");
                            String descripcionArtista = scanner.next();

                            // Crea un objeto Artista con la información proporcionada
                            Artista nuevoArtista = new Artista(nombreArtista, imagenArtista, descripcionArtista,
                                    nombreArtista);

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
                                System.out.println("¿Desea agregar un nuevo artista? (Sí/No): ");
                                String respuesta = scanner.next();

                                if (respuesta.equalsIgnoreCase("Sí")) {
                                    // Lógica para añadir artista
                                    System.out.println("Ingrese el nombre del artista: ");
                                    String nombreArtistaNuevo = scanner.next();

                                    System.out.println("Ingrese la imagen del artista: ");
                                    String imagenArtistaNuevo = scanner.next();

                                    System.out.println("Ingrese la descripción del artista: ");
                                    String descripcionArtistaNuevo = scanner.next();

                                    // Crea un objeto Artista con la información proporcionada
                                    Artista nuevoArtista1 = new Artista(nombreArtistaNuevo, imagenArtistaNuevo,
                                            descripcionArtistaNuevo, nombreArtistaNuevo);

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
                                        System.out.println("Descripción: " + artista.getDescripcion());
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
                                    System.out.println("Descripción: " + artista.getDescripcion());
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

                            System.out.println("Ingrese el número del artista a eliminar (0 para cancelar): ");
                            int numeroArtistaEliminar = scanner.nextInt();

                            if (numeroArtistaEliminar >= 1 && numeroArtistaEliminar <= listaArtistasEliminar.size()) {
                                // Utiliza el método eliminarArtista de ArtistaControl con el índice
                                Artista artistaEliminar = listaArtistasEliminar.get(numeroArtistaEliminar - 1);
                                if (artistaControl.eliminarArtista(artistaEliminar.getNombre())) {
                                    System.out.println("Artista eliminado exitosamente.");
                                } else {
                                    System.out.println("El artista no se encontró en la lista o no se pudo eliminar.");
                                }
                            } else if (numeroArtistaEliminar == 0) {
                                System.out.println("Operación cancelada.");
                            } else {
                                System.out.println("Número de artista no válido.");
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

                            if (coleccionistaControl.registrarColeccionista(nombreUsuario, contrasena)) {
                                System.out.println("Coleccionista registrado exitosamente.");
                            }
                            break;
                        case 2:
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

                                System.out
                                        .println("Ingrese el número del coleccionista a eliminar (0 para cancelar): ");
                                int numeroEliminarColeccionista = scanner.nextInt();

                                if (numeroEliminarColeccionista >= 1
                                        && numeroEliminarColeccionista <= listaColeccionistas.size()) {
                                    // Utiliza el método eliminarColeccionista de ColeccionistaControl con el índice
                                    Colector coleccionistaEliminar = listaColeccionistas
                                            .get(numeroEliminarColeccionista - 1);
                                    if (coleccionistaControl.eliminarColeccionista(coleccionistaEliminar)) {
                                        System.out.println("Coleccionista eliminado exitosamente.");
                                    } else {
                                        System.out.println(
                                                "El coleccionista no se encontró en la lista o no se pudo eliminar.");
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
