package co.uptc.edu.runner;

import co.uptc.edu.controller.AlbumControl;
import co.uptc.edu.controller.ArtistaControl;
import co.uptc.edu.controller.ColeccionistaControl;
import co.uptc.edu.model.Album;
import co.uptc.edu.model.Artista;
import co.uptc.edu.model.Colector;

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
                            }
                            break;

                        case 3:
                            // Lógica para eliminar álbum
                            System.out.println("Lista de Álbumes:");

                            // Mostrar lista de álbumes
                            for (Album album : listaAlbumes) {
                                System.out.println(album.getNombre());
                            }

                            System.out.println("Ingrese el nombre del álbum a eliminar: ");
                            String nombreEliminar = scanner.next();

                            // Utiliza el método eliminarAlbum de AlbumControl solo con el nombre
                            if (albumControl.eliminarAlbum(nombreEliminar)) {
                                System.out.println("Álbum eliminado exitosamente.");
                            } else {
                                System.out.println("El álbum no se encontró en la lista o no se pudo eliminar.");
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

                            String id_artista;
                            id_artista = scanner.next();
                            // Crea un objeto Artista con la información proporcionada
                            Artista nuevoArtista = new Artista(nombreArtista, imagenArtista, descripcionArtista, id_artista);

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

                            // Mostrar lista de artistas
                            ArrayList<Artista> listaArtistasEliminar = artistaControl.obtenerListaArtistas();
                            for (Artista artista : listaArtistasEliminar) {
                                System.out.println(artista.getNombre());
                            }

                            System.out.println("Ingrese el nombre del artista a eliminar: ");
                            String nombreArtistaEliminar = scanner.next();

                            // Utiliza el método eliminarArtista de ArtistaControl solo con el nombre
                            if (artistaControl.eliminarArtista(nombreArtistaEliminar)) {
                                System.out.println("Artista eliminado exitosamente.");
                            } else {
                                System.out.println("El artista no se encontró en la lista o no se pudo eliminar.");
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
                            if (listaColeccionistas.isEmpty()) {
                                System.out.println("La lista de coleccionistas está vacía.");
                            } else {
                                System.out.println("Lista de Coleccionistas:");
                                for (Colector coleccionista : listaColeccionistas) {
                                    System.out.println(coleccionista.getName());
                                }

                                // Lógica para eliminar coleccionista
                                System.out.println("Ingrese el nombre del coleccionista a eliminar: ");
                                String nombreEliminarColeccionista = scanner.next();

                                // Utiliza el método eliminarColeccionista de ColeccionistaControl
                                if (coleccionistaControl.eliminarColeccionista(
                                        new Colector(nombreEliminarColeccionista, null, null, null, null))) {
                                    System.out.println("Coleccionista eliminado exitosamente.");
                                } else {
                                    System.out.println(
                                            "El coleccionista no se encontró en la lista o no se pudo eliminar.");
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
