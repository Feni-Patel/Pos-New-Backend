package org.pgs.postp.repository;

import org.pgs.postp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    // You can add custom query methods if needed
}
