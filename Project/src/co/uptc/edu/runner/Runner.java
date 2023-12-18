package co.uptc.edu.runner;

import co.uptc.edu.controller.AccesControl;
import co.uptc.edu.controller.AlbumControl;
import co.uptc.edu.controller.ArtistaControl;
import co.uptc.edu.controller.ColeccionistaControl;
import co.uptc.edu.controller.ComentariosControl;
import co.uptc.edu.controller.PremiosControl;
import co.uptc.edu.model.Album;
import co.uptc.edu.model.Artista;
import co.uptc.edu.model.Cancion;
import co.uptc.edu.model.Colector;
import co.uptc.edu.model.Comentario;
import co.uptc.edu.model.DetallesPremio;
import co.uptc.edu.model.Premio;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    //esta en sincronizacion con la base de datos
    Scanner scanner = new Scanner(System.in);
    AlbumControl albumControl = new AlbumControl();
    ArtistaControl artistaControl = new ArtistaControl();
    ColeccionistaControl coleccionistaControl = new ColeccionistaControl();
    ComentariosControl comentariosControl = new ComentariosControl();
    ArrayList<Album> listaAlbumes = albumControl.getAlbums();
    ArrayList<Colector> listaColeccionistas = coleccionistaControl.obtenerListaColeccionistas();
    AccesControl accesControl = new AccesControl();
    PremiosControl premiosControl = new PremiosControl();

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
          do {
            System.out.println("Ingrese el nombre de usuario:");
            String nombreUsuarioRegistro = scanner.next();

            // Verificar si el usuario ya existe
            if (accesControl.getUsuarios().contains(nombreUsuarioRegistro)) {
              System.out.println(
                "El nombre de usuario ya está en uso. Por favor, elija otro."
              );
              continue; // Volver al inicio del bucle para que el usuario ingrese otro nombre
            }

            System.out.println(
              "Ingrese la contraseña (La contraseña debe tener por lo menos una mayúscula, una minúscula y 8 caracteres): "
            );
            String contrasenaRegistro = scanner.next();

            if (
              accesControl.registrarUsuario(
                nombreUsuarioRegistro,
                contrasenaRegistro
              )
            ) {
              System.out.println("Registro exitoso.");
              break; // Salir del bucle si el registro es exitoso
            } else {
              if (
                nombreUsuarioRegistro == null || nombreUsuarioRegistro.isEmpty()
              ) {
                System.out.println(
                  "El nombre de usuario no puede estar vacío."
                );
              }

              if (contrasenaRegistro.length() < 8) {
                System.out.println(
                  "La contraseña debe tener al menos 8 caracteres."
                );
              }

              if (!contrasenaRegistro.matches(".*[A-Z]*.")) {
                System.out.println(
                  "La contraseña debe contener al menos una mayúscula."
                );
              }

              if (!contrasenaRegistro.matches(".*[a-z]*.")) {
                System.out.println(
                  "La contraseña debe contener al menos una minúscula."
                );
              }
              // Pedir al usuario que vuelva a intentar
              System.out.println("¿Desea volver a intentar? (1: Sí, 0: No): ");
              opcion = scanner.nextInt();

              if (opcion != 0 && opcion != 1) {
                System.out.println("OPCIÓN INVALIDA");
                break;
              }
            }
          } while (opcion != 0);

          break;
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
              if (
                nombreAlbum.isEmpty() ||
                portadaAlbum.isEmpty() ||
                descripcionAlbum.isEmpty() ||
                fechaLanzamientoAlbum.isEmpty() ||
                generoAlbum.isEmpty() ||
                etiquetaRegistroAlbum.isEmpty()
              ) {
                System.out.println(
                  "Ningún campo debe quedar vacío. Inténtelo de nuevo."
                );
              } else {
                // Lógica para añadir el álbum usando el método añadirAlbum de AlbumControl
                albumControl.añadirAlbum(
                  new Album(
                    portadaAlbum,
                    nombreAlbum,
                    descripcionAlbum,
                    fechaLanzamientoAlbum,
                    generoAlbum,
                    etiquetaRegistroAlbum
                  )
                );
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

                // Input validation for a valid integer
                try {
                  System.out.print(
                    "Ingrese el número del álbum para mostrar la información: "
                  );
                  int albumIndex = scanner.nextInt();
                  scanner.nextLine(); // consume the newline character

                  // Validate the chosen album index
                  if (albumIndex >= 1 && albumIndex <= listaAlbumes.size()) {
                    Album selectedAlbum = listaAlbumes.get(albumIndex - 1);

                    // Display information about the selected album
                    System.out.println("Información del Álbum:");
                    System.out.println("Nombre: " + selectedAlbum.getNombre());
                    System.out.println(
                      "Portada: " + selectedAlbum.getPortada()
                    );
                    System.out.println(
                      "Descripción: " + selectedAlbum.getDescripcion()
                    );
                    System.out.println(
                      "Fecha Lanzamiento: " +
                      selectedAlbum.getFechaLanzamiento()
                    );
                    System.out.println("Genero: " + selectedAlbum.getGenero());
                    System.out.println(
                      "Etiqueta de Registro: " +
                      selectedAlbum.getEtiquetaRegistro()
                    );
                    // ... (display other album information)

                  } else {
                    System.out.println(
                      "Número de álbum no válido. Inténtelo de nuevo."
                    );
                  }
                } catch (InputMismatchException e) {
                  System.out.println("Ingrese un número válido.");
                  // Optionally, you might want to clear the buffer to avoid an infinite loop
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
                  // Logic to add a new album
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

                  // Validate input
                  if (
                    nombreAlbumNuevo.isEmpty() ||
                    portadaAlbumNuevo.isEmpty() ||
                    descripcionAlbumNuevo.isEmpty() ||
                    fechaLanzamientoAlbumNuevo.isEmpty() ||
                    generoAlbumNuevo.isEmpty() ||
                    etiquetaRegistroAlbumNuevo.isEmpty()
                  ) {
                    System.out.println(
                      "Ningún campo debe quedar vacío. Inténtelo de nuevo."
                    );
                  } else {
                    // Logic to add the album using the añadirAlbum method of AlbumControl
                    albumControl.añadirAlbum(
                      new Album(
                        portadaAlbumNuevo,
                        nombreAlbumNuevo,
                        descripcionAlbumNuevo,
                        fechaLanzamientoAlbumNuevo,
                        generoAlbumNuevo,
                        etiquetaRegistroAlbumNuevo
                      )
                    );
                    System.out.println("Álbum añadido exitosamente.");
                  }
                  break;
                }
              }
              break;
            case 3:
              if (listaAlbumes.isEmpty()) {
                System.out.println("La lista de álbumes está vacía.");
              } else {
                // Display the list of albums with numbers
                System.out.println("Lista de Álbumes:");
                int i = 1;
                for (Album album : listaAlbumes) {
                  System.out.println(i + ". " + album.getNombre());
                  i++;
                }

                System.out.println(
                  "Ingrese el número del álbum a eliminar (0 para cancelar): "
                );
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
              }
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
          if (listaAlbumes.isEmpty()) {
            System.out.println("La lista de álbumes está vacía.");
          } else {
            // Mostrar la lista de álbumes
            System.out.println("Lista de Álbumes:");
            int albumIndexSongs = 1;
            for (Album album : listaAlbumes) {
              System.out.println(albumIndexSongs + ". " + album.getNombre());
              albumIndexSongs++;
            }

            // Pedir al usuario que elija un álbum
            int numeroAlbumSeleccionadoSongs = -1;
            while (true) {
              System.out.println(
                "Ingrese el número del álbum (0 para cancelar):"
              );
              numeroAlbumSeleccionadoSongs = scanner.nextInt();
              scanner.nextLine(); // Consume el salto de línea

              if (
                numeroAlbumSeleccionadoSongs >= 1 &&
                numeroAlbumSeleccionadoSongs <= listaAlbumes.size()
              ) {
                break;
              } else {
                System.out.println("Número no válido. Inténtelo de nuevo.");
              }
            }
            // Display additional options
            System.out.println("Seleccione una opción para canciones:");
            System.out.println("1. Agregar Artista");
            System.out.println("2. Eliminar Artista");
            System.out.println("3. Actualizar Artista");
            System.out.println("4. Mostrar Artsita");

            int opcionArtista = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            // Lógica para manejar artistas según la opción seleccionada
            switch (opcionArtista) {
              case 1:
                // Lógica para añadir artista
                System.out.println("Ingrese el nombre del artista: ");
                String nombreArtista = scanner.nextLine();

                System.out.println("Ingrese la descripción del artista: ");
                String descripcionArtista = scanner.nextLine();

                System.out.println("Ingrese el id del artista: ");
                String idArtista = scanner.nextLine();

                // Verificar que las entradas no estén vacías
                if (
                  nombreArtista.isEmpty() ||
                  descripcionArtista.isEmpty() ||
                  idArtista.isEmpty()
                ) {
                  System.out.println(
                    "Ningún campo debe quedar vacío. Inténtelo de nuevo."
                  );
                } else {
                  // Crear un objeto Artista
                  Artista nuevoArtista = new Artista(
                    nombreArtista,
                    descripcionArtista,
                    idArtista
                  );

                  // Añadir el artista usando el método de control
                  if (artistaControl.añadirArtista(nuevoArtista)) {
                    System.out.println("Artista añadido exitosamente.");
                  } else {
                    System.out.println("El artista ya existe.");
                  }
                }

                // Crear un objeto Artista
                Artista nuevoArtista = new Artista(
                  nombreArtista,
                  descripcionArtista,
                  idArtista
                );

                // Añadir el artista usando el método de control
                if (artistaControl.añadirArtista(nuevoArtista)) {
                  System.out.println("Artista añadido exitosamente.");
                } else {
                  System.out.println("El artista ya existe.");
                }
                break;
              case 2:
                // Mostrar Lista de Artistas
                ArrayList<Artista> listaArtistas = artistaControl.obtenerListaArtistas();
                if (listaArtistas.isEmpty()) {
                  System.out.println("La lista de artistas está vacía.");
                } else {
                  System.out.println("Lista de Artistas:");
                  for (Artista artista : listaArtistas) {
                    System.out.println("Nombre: " + artista.getNombre());
                    System.out.println(
                      "Descripción: " + artista.getDescripcion()
                    );
                    System.out.println("Id: " + artista.getId_artista());
                    System.out.println("------------------------");
                  }
                }
                break;
              case 3:
                // Mostrar Lista de Artistas antes de eliminar
                ArrayList<Artista> listaArtistasEliminar = artistaControl.obtenerListaArtistas();
                if (listaArtistasEliminar.isEmpty()) {
                  System.out.println("La lista de artistas está vacía.");
                } else {
                  System.out.println("Lista de Artistas:");
                  for (Artista artista : listaArtistasEliminar) {
                    System.out.println("Nombre: " + artista.getNombre());
                    System.out.println(
                      "Descripción: " + artista.getDescripcion()
                    );
                    System.out.println("Id: " + artista.getId_artista());
                    System.out.println("------------------------");
                  }

                  System.out.println(
                    "Ingrese el nombre del artista a eliminar:"
                  );
                  String nombreEliminar = scanner.nextLine();
                  if (artistaControl.eliminarArtista(nombreEliminar)) {
                    System.out.println("Artista eliminado exitosamente.");
                  } else {
                    System.out.println("No se encontró el artista.");
                  }
                }
                break;
              case 4:
                // Lógica para manejar premios de artistas
                System.out.println("Ingrese el ID del artista: ");
                String idArtistaPremio = scanner.nextLine();

                // Verificar si el artista existe antes de continuar
                Artista artistaPremio = artistaControl.buscarArtista(
                  idArtistaPremio
                );
                if (artistaPremio == null) {
                  System.out.println(
                    "Artista no encontrado. Verifique el ID del artista e inténtelo de nuevo."
                  );
                  break;
                }

                System.out.println("Ingrese el ID del premio: ");
                String idPremio = scanner.nextLine();

                // Utiliza la instancia de PremiosControl para buscar el premio
                Premio premio = premiosControl.buscarPremio(idPremio);
                if (premio == null) {
                  System.out.println(
                    "Premio no encontrado. Verifique el ID del premio e inténtelo de nuevo."
                  );
                  break;
                }

                // Verificar si ya existen detalles de premio para el artista y el premio
                DetallesPremio detallesExistente = premiosControl.buscarDetallesPremio(
                  idArtistaPremio,
                  idPremio
                );
                if (detallesExistente != null) {
                  System.out.println(
                    "Ya existen detalles de premio para este artista y premio."
                  );
                  break;
                }

                // Crear un objeto DetallesPremio
                // Crear un objeto DetallesPremio
                DetallesPremio nuevosDetalles = new DetallesPremio(
                  idPremio, null, null, null, null,
                  premio,
                  idArtistaPremio
                );

                // Añadir detalles de premio usando el método de control
                premiosControl.agregarDetallesPremio(nuevosDetalles);
                System.out.println(
                  "Detalles de premio agregados exitosamente."
                );
                break;
              case 0:
                // Volver al Menú Principal
                break;
              default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                break;
            }
            break;
          }
        case 3:
          // Llamar a métodos de control de coleccionistas
          System.out.println("1. Registrar Coleccionista");
          System.out.println("2. Mostrar Lista de Coleccionistas");
          System.out.println("3. Eliminar Coleccionista");
          System.out.println("0. Volver al Menú Principal");

          int opcionColeccionista = scanner.nextInt();
          scanner.nextLine(); // Consumir la nueva línea pendiente

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
              if (listaColeccionistas.isEmpty()) {
                System.out.println("La lista de coleccionistas está vacía.");
              } else {
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
                scanner.nextLine(); // Consumir la nueva línea pendiente

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
