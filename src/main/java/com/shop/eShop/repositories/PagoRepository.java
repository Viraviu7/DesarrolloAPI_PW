package com.shop.eShop.repositories;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.shop.eShop.entities.Pago;

@RepositoryRestController
public interface PagoRepository extends JpaRepository<Pago, Long> {

    /* find by pagos de una fecha */
    @Query("SELECT p FROM Pago p WHERE p.fechaPago = ?1")
    Optional<List<Pago>> findByFecha(Timestamp fechaPago);

    /* find by pagos antes de una fecha */
    @Query("SELECT p FROM Pago p WHERE p.fechaPago < ?1")
    Optional<List<Pago>> findByFechaBefore(Timestamp fechaPago);

    /* find by pagos despues de una fecha */
    @Query("SELECT p FROM Pago p WHERE p.fechaPago > ?1")
    Optional<List<Pago>> findByFechaAfter(Timestamp fechaPago);

    /* find by pagos entre fechas */
    @Query("SELECT p FROM Pago p WHERE p.fechaPago BETWEEN ?1 AND ?2")
    Optional<List<Pago>> findByFechaBetween(Timestamp fechaPago1, Timestamp fechaPago2);

    /* find by id del pedido y metodo de pago */
    @Query("SELECT p FROM Pago p WHERE p.idPedido.idPedido = ?1 AND p.metodoPago = ?2")
    Optional<Pago> findByIdPedidoAndMetodoPago(Long idPedido, String metodoPago);

    /* find by metodo de pago */
    @Query("SELECT p FROM Pago p WHERE p.metodoPago = ?1")
    Optional<List<Pago>> findByMetodoPago(String metodoPago);

    
}
