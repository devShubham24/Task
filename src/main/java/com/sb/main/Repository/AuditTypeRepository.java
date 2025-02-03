package com.sb.main.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sb.main.entity.AuditType;
import com.sb.main.linechartDTO.TreadsDTO;

@Repository
public interface AuditTypeRepository extends JpaRepository<AuditType, Long> {
    AuditType findByType(String type);
    @Query(value = "SELECT type, created_at AS createdAt FROM audit_type", nativeQuery = true)
       public List<TreadsDTO> getLineChartDto();

}
