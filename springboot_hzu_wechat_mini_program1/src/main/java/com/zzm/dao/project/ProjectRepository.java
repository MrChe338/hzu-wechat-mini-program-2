package com.zzm.dao.project;
import com.zzm.pojo.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("SELECT p FROM Project p")
    List<Project> findAllProjects();
    List<Project> findByIdIn(List<Integer> projectIds);
    List<Project> findByProjectNameContainingOrUser_NicknameContaining(String projectName, String nickname);
    List<Project> findAllByOrderByCreateTimeDesc();
    @Query("SELECT p FROM Project p ORDER BY (p.likes + p.favorites) DESC")
    List<Project> findAllOrderByPopularity();
}
