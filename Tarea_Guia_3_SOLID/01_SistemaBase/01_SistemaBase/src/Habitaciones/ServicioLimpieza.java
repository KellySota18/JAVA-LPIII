package Habitaciones;

/**
 * Rol independiente: sólo las habitaciones que ofrecen limpieza lo implementan.
 * (Principio de Segregación de Interfaces)
 */
public interface ServicioLimpieza {

    void limpiar();
}
