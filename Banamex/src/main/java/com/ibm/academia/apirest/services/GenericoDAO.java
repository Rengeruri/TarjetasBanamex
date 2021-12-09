package com.ibm.academia.apirest.services;

import java.util.Optional;

public interface GenericoDAO<E> {
	public Optional<E> findById(Integer id);
	public E save(E entidad);
	public Iterable<E> findAll();
	public void deleteById(Integer id);
}
