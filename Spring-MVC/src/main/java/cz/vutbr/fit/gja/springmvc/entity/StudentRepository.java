package cz.vutbr.fit.gja.springmvc.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends Spring Data JPA’s {@link JpaRepository},
 * specifying the domain type as Student and the id type as Long.
 *
 * This interface, though empty on the surface, packs a punch given it supports:
 * Creating new instances
 * Updating existing ones
 * Deleting
 * Finding (one, all, by simple or complex properties)
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
