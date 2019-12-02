package ru.pirateway.sb.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pirateway.sb.entity.Fork;

@Repository
public interface IForkRepository extends JpaRepository<Fork, String> {

}
