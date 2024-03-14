package org.pgs.postp.repository;

import org.pgs.postp.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    // You can add custom query methods if needed
}
