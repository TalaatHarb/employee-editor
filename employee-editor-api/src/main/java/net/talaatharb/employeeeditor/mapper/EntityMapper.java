/**
 * 
 */
package net.talaatharb.employeeeditor.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * EntityMapper interface that a mapper implementation between DTOs and entities
 * will inherit
 * 
 * @author mharb
 *
 * @param <E> The entity object
 * @param <D> The DTO object
 */
public interface EntityMapper<E, D> {

	/**
	 * Maps an entity object to its corresponding DTO
	 * 
	 * @param entity The entity to map
	 * @return The DTO it is mapped to
	 */
	public abstract D toDto(final E entity);

	/**
	 * Maps a list of entities to a corresponding list of DTOs
	 * 
	 * @param entities The list of entities to map
	 * @return The corresponding list of DTOs
	 */
	public default List<D> toDto(final List<E> entities) {
		final List<D> dtos = new ArrayList<>();
		entities.forEach(entity -> dtos.add(toDto(entity)));
		return dtos;
	}

	/**
	 * Maps a list of DTOs to a corresponding list of entities
	 * 
	 * @param dtos The list of DTOs to map
	 * @return The corresponding list of entities
	 */
	public default List<E> toEnity(final List<D> dtos) {
		final List<E> entities = new ArrayList<>();
		dtos.forEach(dto -> entities.add(toEntity(dto)));
		return entities;
	}

	/**
	 * Maps a DTO object to its corresponding entity
	 * 
	 * @param dto The DTO to map
	 * @return The entity it is mapped to
	 */
	public abstract E toEntity(final D dto);

}
