package com.edu.petairbnb.controller;

import com.edu.petairbnb.base.BaseComponent;
import com.edu.petairbnb.model.BaseModel;
import com.edu.petairbnb.service.BaseService;
import com.edu.petairbnb.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<T extends BaseModel> extends BaseComponent {

	protected abstract BaseService<T> getBaseService();

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<T>> get(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().get(id)).build());
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<T>>> findAll() {
		return ResponseEntity.ok(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build());
	}

	@PostMapping
	public ResponseEntity<ApiResponse<T>> create(@Valid @RequestBody final T entity) {
		return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(entity)).build(),
									HttpStatus.CREATED);
	}

	@PostMapping(headers = "content=list")
	public ResponseEntity<ApiResponse<List<T>>> createAll(@RequestBody List<T> entities) {
		return new ResponseEntity<>(ApiResponse.<List<T>>builder().data(getBaseService().createAll(entities)).build(),
									HttpStatus.CREATED);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody final T entity) {
		getBaseService().update(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") final Long id) {
		getBaseService().deleteById(id);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@Valid @RequestBody final T entity) {
		if (getBaseService().exists(entity)) {
			getBaseService().delete(entity);
		}
	}
}
