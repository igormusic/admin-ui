package com.tvmsoftware.data.service;

import com.tvmsoftware.data.entity.SamplePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, Long> {

}
